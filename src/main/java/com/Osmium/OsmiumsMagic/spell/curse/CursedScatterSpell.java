package com.Osmium.OsmiumsMagic.spell.curse;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import com.Osmium.OsmiumsMagic.regi.ModDamageTypes;
import com.Osmium.OsmiumsMagic.regi.ModSchoolRegistry;
import dev.xkmc.l2complements.init.registrate.LCEffects;
import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.CameraShakeData;
import io.redspace.ironsspellbooks.api.util.CameraShakeManager;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.particle.BlastwaveParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Optional;

@AutoSpellConfig
public class CursedScatterSpell extends AbstractSpell {
    private final ResourceLocation spellId = new ResourceLocation(Osmiumsmagic.MOD_ID, "cursed_scatter");

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.UNCOMMON)
            .setSchoolResource(new ResourceLocation(Osmiumsmagic.MOD_ID, "curse"))
            .setMaxLevel(10)
            .setCooldownSeconds(20)
            .build();

    public CursedScatterSpell() {
        this.manaCostPerLevel = 15;
        this.baseSpellPower = 8;
        this.spellPowerPerLevel = 3;
        this.castTime = 20;
        this.baseManaCost = 30;
    }

    @Override
    public ResourceLocation getSpellResource() {
        return spellId;
    }

    @Override
    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of(SoundEvents.ELDER_GUARDIAN_CURSE);
    }

    @Override
    public DefaultConfig getDefaultConfig() {
        return defaultConfig;
    }

    @Override
    public CastType getCastType() {
        return CastType.LONG;
    }

    @Override
    public SchoolType getSchoolType() {
        return ModSchoolRegistry.CURSE.get();
    }

    @Override
    public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        if (!level.isClientSide) {

            float radius = 5 + spellLevel * 2;
            float range = 1.7f;
            Vec3 smiteLocation = Utils.raycastForBlock(level, entity.getEyePosition(), entity.getEyePosition().add(entity.getForward().multiply(range, 0, range)), ClipContext.Fluid.NONE).getLocation();
            Vec3 particleLocation = level.clip(new ClipContext(smiteLocation, smiteLocation.add(0, -2, 0), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, null)).getLocation().add(0, 0.1, 0);
            MagicManager.spawnParticles(level, new BlastwaveParticleOptions(ModSchoolRegistry.CURSE.get().getTargetingColor(), radius * 2),
                    particleLocation.x, particleLocation.y, particleLocation.z, 1, 0, 0, 0, 0, true);
            MagicManager.spawnParticles(level, ParticleTypes.ELECTRIC_SPARK, particleLocation.x, particleLocation.y, particleLocation.z, 50, 0, 0, 0, 1, false);
            CameraShakeManager.addCameraShake(new CameraShakeData(10, particleLocation, 10));

            List<LivingEntity> targets = level.getEntitiesOfClass(
                    LivingEntity.class,
                    entity.getBoundingBox().inflate(radius),
                    e -> e.isAlive() && e != entity
            );

            for (LivingEntity target : targets) {

                applyDebuff(target, spellLevel);

                double baseDamage = entity.getAttributeValue(Attributes.ATTACK_DAMAGE);
                double bonus = spellLevel * 2.0;
                float damage = (float)(baseDamage + bonus);

                DamageSource source = new DamageSource(
                        level.registryAccess()
                                .registryOrThrow(Registries.DAMAGE_TYPE)
                                .getHolderOrThrow(ModDamageTypes.CURSE_MAGIC)
                );

                target.hurt(source, damage);
            }
        }
    }

    private void applyDebuff(LivingEntity target, int level) {

        int duration = 100 + level * 40; // ticks

        target.addEffect(new MobEffectInstance(LCEffects.CURSE.get(), duration, 1));
    }

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(Component.translatable("ui.irons_spellbooks.damage", getDamageText(spellLevel, caster)));
    }

    private float getDamage(int spellLevel, LivingEntity entity) {
        //Setting mob type to undead means the smite enchantment also adds to the spell's damage. Seems fitting.
        return getSpellPower(spellLevel, entity) + Utils.getWeaponDamage(entity, MobType.UNDEAD);
    }

    private String getDamageText(int spellLevel, LivingEntity entity) {
        if (entity != null) {
            float weaponDamage = Utils.getWeaponDamage(entity, MobType.UNDEAD);
            String plus = "";
            if (weaponDamage > 0) {
                plus = String.format(" (+%s)", Utils.stringTruncation(weaponDamage, 1));
            }
            String damage = Utils.stringTruncation(getDamage(spellLevel, entity), 1);
            return damage + plus;
        }
        return "" + getSpellPower(spellLevel, entity);
    }

    @Override
    public AnimationHolder getCastStartAnimation() {
        return SpellAnimations.OVERHEAD_MELEE_SWING_ANIMATION;
    }

    @Override
    public AnimationHolder getCastFinishAnimation() {
        return AnimationHolder.pass();
    }
}
