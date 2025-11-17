package com.Osmium.spell.fire;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import com.Osmium.projectile.spell.firelance.FireLanceProjectile;
import com.Osmium.OsmiumsMagic.regi.ModEntities;
import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.api.spells.CastType;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.damage.SpellDamageSource;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Optional;

public class FireLanceSpell extends AbstractSpell {

    private final ResourceLocation spellId = new ResourceLocation(Osmiumsmagic.MOD_ID, "fire_lance");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.damage", Utils.stringTruncation(getDamage(spellLevel, caster), 2))
        );
    }

    public FireLanceSpell() {
        this.manaCostPerLevel = 20;
        this.baseSpellPower = 20;
        this.spellPowerPerLevel = 5;
        this.castTime = 16;
        this.baseManaCost = 40;
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.COMMON)
            .setSchoolResource(SchoolRegistry.FIRE.getId())
            .setMaxLevel(10)
            .setCooldownSeconds(5)
            .build();

    @Override
    public ResourceLocation getSpellResource() {
        return spellId;
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
    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of(SoundRegistry.FIREBALL_START.get());
    }

    @Override
    public void onCast(Level level, int spellLevel, LivingEntity caster, CastSource castSource, MagicData playerMagicData) {
        if (!level.isClientSide) {

            // 射出方向
            Vec3 look = caster.getLookAngle();
            Vec3 origin = caster.getEyePosition().add(look.scale(0.3));

            // NEW: 魔法エンティティを生成
            FireLanceProjectile projectile = new FireLanceProjectile(
                    ModEntities.FIRE_LANCE.get(), // ←必ず登録した EntityType を使う
                    level
            );

            projectile.setOwner(caster);
            projectile.setPos(origin.x, origin.y, origin.z);

            // 射出速度
            projectile.shoot(
                    look.x, look.y, look.z,
                    projectile.getSpeed(), // 2.0f
                    0.0f
            );

            // ダメージを渡す
            projectile.setDamage(getDamage(spellLevel, caster));

            // スポーン
            level.addFreshEntity(projectile);
        }

    }

    public float getDamage(int spellLevel, LivingEntity caster) {
        return 5 + 5 * getSpellPower(spellLevel, caster);
    }

    @Override
    public SpellDamageSource getDamageSource(Entity projectile, Entity attacker) {
        return super.getDamageSource(projectile, attacker).setFireTime(10);
    }
}
