package com.sh1nylabs.bonesupdate.common.entities.necromancy;

import com.sh1nylabs.bonesupdate.BonesUpdate;
import com.sh1nylabs.bonesupdate.common.entities.goal.ReaperAttackGoal;
import com.sh1nylabs.bonesupdate.init.BonesItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

public class Reaper extends FlyingMob implements Enemy {
    public Reaper(EntityType<? extends FlyingMob> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new ReaperAttackGoal.ReaperMoveControl(this);
    }

    public static AttributeSupplier.Builder getCustomAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH,28.0D) // FIX_VALUE
                .add(Attributes.MOVEMENT_SPEED, 0.2D) // FIX_VALUE
                .add(Attributes.ATTACK_DAMAGE, 6.0D) // FIX_VALUE
                .add(Attributes.ATTACK_SPEED, 1.7D); // FIX_VALUE, as ATTACK_SPEED * 10 ticks
    }

    protected void registerGoals() {
        //TODO: put custom attacks, change cow to player
        this.goalSelector.addGoal(3, new ReaperAttackGoal(this));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Cow.class, true));
    }

    /**
    @Override
    protected void populateDefaultEquipmentSlots(RandomSource rdmSequence, DifficultyInstance difficulty) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(BonesItems.REAPER_SCYTHE.get()));
        BonesUpdate.LOGGER.info("equipment called");
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag tag) {
        this.populateDefaultEquipmentSlots(level.getRandom(), difficulty);
        return spawnData;
    }
*/
    @Override
    public MobType getMobType() {
        return MobType.UNDEAD;
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.updateSwingTime();
    }


}
