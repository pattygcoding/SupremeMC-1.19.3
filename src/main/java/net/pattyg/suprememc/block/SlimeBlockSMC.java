package net.pattyg.suprememc.block;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.Vec3;
import net.pattyg.suprememc.api.SMCBlocks;
import org.joml.Vector3d;

public class SlimeBlockSMC extends HalfTransparentBlock
{public SlimeBlockSMC(MaterialColor color)
{
    super(Properties.of(Material.CLAY, color).friction(0.8F).sound(SoundType.SLIME_BLOCK).noOcclusion());
}

    @Override
    public boolean isSlimeBlock(BlockState state)
    {
        return true;
    }

    @Override
    public boolean isStickyBlock(BlockState state)
    {
        return true;
    }


    @Override
    public boolean canStickTo(BlockState state, BlockState other)
    {

        if (state.getBlock() == this)
        {
            ImmutableList<Block> slimeBlocks = ImmutableList.of
                    (
                            SMCBlocks.RED_SLIME_BLOCK.get(), SMCBlocks.ORANGE_SLIME_BLOCK.get(), SMCBlocks.YELLOW_SLIME_BLOCK.get(), SMCBlocks.LIME_SLIME_BLOCK.get(),
                            SMCBlocks.GREEN_SLIME_BLOCK.get(), SMCBlocks.LIGHT_BLUE_SLIME_BLOCK.get(), SMCBlocks.CYAN_SLIME_BLOCK.get(), SMCBlocks.BLUE_SLIME_BLOCK.get(),
                            SMCBlocks.PURPLE_SLIME_BLOCK.get(), SMCBlocks.MAGENTA_SLIME_BLOCK.get(), SMCBlocks.PINK_SLIME_BLOCK.get(), SMCBlocks.WHITE_SLIME_BLOCK.get(),
                            SMCBlocks.LIGHT_GRAY_SLIME_BLOCK.get(), SMCBlocks.GRAY_SLIME_BLOCK.get(), SMCBlocks.BLACK_SLIME_BLOCK.get(), SMCBlocks.BROWN_SLIME_BLOCK.get(),
                            Blocks.SLIME_BLOCK, Blocks.HONEY_BLOCK
                    );
            for(Block block : slimeBlocks)
            {
                if(block != this && block == other.getBlock()) return false;
            }
        }
        return state.isStickyBlock() || other.isStickyBlock();
    }

    @Override
    public void fallOn(Level p_154567_, BlockState p_154568_, BlockPos p_154569_, Entity p_154570_, float p_154571_) {
        if (p_154570_.isSuppressingBounce()) {
            super.fallOn(p_154567_, p_154568_, p_154569_, p_154570_, p_154571_);
        } else {
            p_154570_.causeFallDamage(p_154571_, 0.0F, DamageSource.FALL);
        }

    }

    @Override
    public void updateEntityAfterFallOn(BlockGetter p_56406_, Entity p_56407_) {
        if (p_56407_.isSuppressingBounce()) {
            super.updateEntityAfterFallOn(p_56406_, p_56407_);
        } else {
            this.bounceUp(p_56407_);
        }

    }

    private void bounceUp(Entity p_56404_) {
        Vec3 vec3 = p_56404_.getDeltaMovement();
        if (vec3.y < 0.0D) {
            double d0 = p_56404_ instanceof LivingEntity ? 1.0D : 0.8D;
            p_56404_.setDeltaMovement(vec3.x, -vec3.y * d0, vec3.z);
        }

    }

    @Override
    public void stepOn(Level p_154573_, BlockPos p_154574_, BlockState p_154575_, Entity p_154576_) {
        double d0 = Math.abs(p_154576_.getDeltaMovement().y);
        if (d0 < 0.1D && !p_154576_.isSteppingCarefully()) {
            double d1 = 0.4D + d0 * 0.2D;
            p_154576_.setDeltaMovement(p_154576_.getDeltaMovement().multiply(d1, 1.0D, d1));
        }

        super.stepOn(p_154573_, p_154574_, p_154575_, p_154576_);
    }
}
