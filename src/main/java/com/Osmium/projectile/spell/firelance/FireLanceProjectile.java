package com.Osmium.projectile.spell.firelance;

import com.Osmium.OsmiumsMagic.regi.ModSpells;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

import java.util.Optional;

public class FireLanceProjectile extends AbstractMagicProjectile {

    public FireLanceProjectile(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    public void trailParticles() {
        this.level().addParticle(
                ParticleTypes.FLAME,
                this.getX(),
                this.getY(),
                this.getZ(),
                0, 0, 0
        );
    }

    @Override
    public void impactParticles(double x, double y, double z) {
        for (int i = 0; i < 10; i++) {
            this.level().addParticle(
                    ParticleTypes.LAVA,
                    x, y, z,
                    (this.random.nextDouble() - 0.5) * 0.2,
                    (this.random.nextDouble()) * 0.2,
                    (this.random.nextDouble() - 0.5) * 0.2
            );
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (!this.level().isClientSide) {
            // ヒットしたエンティティを取得
            var entity = pResult.getEntity();

            // 魔法ダメージを与える
            // Iron's Spellbooks の方式に合わせる場合
            DamageSources.applyDamage(
                    entity,
                    this.getDamage(), // MagicFireLance の damage フィールド
                    ModSpells.FIRE_LANCE_SPELL.get().getDamageSource(this, this.getOwner())
            );

            // 燃焼効果（2秒）
            entity.setSecondsOnFire(2);

            // ヒット時のパーティクル
            impactParticles(entity.getX(), entity.getY() + entity.getEyeHeight() / 2, entity.getZ());

            // ヒット時のサウンド
            this.getImpactSound().ifPresent(sound ->
                    this.playSound(sound, 1.0F, 1.0F)
            );
        }
    }

    @Override
    public float getSpeed() {
        return 2.0f;
    }

    @Override
    public Optional<SoundEvent> getImpactSound() {
        return Optional.of(SoundEvents.FIRECHARGE_USE);
    }
}
