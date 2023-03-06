package net.pattyg.suprememc.init.misc;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.pattyg.suprememc.SupremeMC;

public class InItTags
{
    public static void setup()
    {
        Fluids.setup();
    }


    public static class Fluids
    {
        private static void setup() {}

        public static final TagKey<Fluid> LIQUID_GAS = FluidTags.create(new ResourceLocation(SupremeMC.MOD_ID, "liquid_gas"));
    }
}
