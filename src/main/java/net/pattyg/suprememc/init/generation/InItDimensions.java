package net.pattyg.suprememc.init.generation;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.pattyg.suprememc.SupremeMC;

import java.util.function.Supplier;

import static net.pattyg.suprememc.api.SMCDimensions.*;

public class InItDimensions
{
    public static void setup() {registerDimensions();}

    public static void registerDimensions()
    {
        ICETHER = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(SupremeMC.MOD_ID, "icether"));
    }

    /*public static RegistryObject<Block> registerBlock(String name, Supplier<Block> blockSupplier)
    {
        RegistryObject<Block> blockRegistryObject = SupremeMC.BLOCK_REGISTER.register(name, blockSupplier);
        SupremeMC.ITEM_REGISTER.register(name, () -> new BlockItem(blockRegistryObject.get(), new Item.Properties()));
        return blockRegistryObject;
    }*/

}
