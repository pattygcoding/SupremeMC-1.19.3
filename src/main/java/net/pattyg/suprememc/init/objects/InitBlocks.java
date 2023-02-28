package net.pattyg.suprememc.init.objects;

import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.RegistryObject;
import net.pattyg.suprememc.SupremeMC;

import static net.pattyg.suprememc.api.SMCBlocks.*;

import java.util.function.Supplier;

public class InitBlocks
{
    public static void setup()
    {
        registerBlocks();
    }

    public static void registerBlocks()
    {
        // Building Blocks
        COBBLED_ANDESITE = registerBlock("cobbled_andesite", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(2.0f, 6.0f).sound(SoundType.STONE)));
        COBBLED_DIORITE = registerBlock("cobbled_diorite", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(2.0f, 6.0f).sound(SoundType.STONE)));
        COBBLED_GRANITE = registerBlock("cobbled_granite", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DIRT).requiresCorrectToolForDrops().strength(2.0f, 6.0f).sound(SoundType.STONE)));

        ANDESITE_BRICKS = registerBlock("andesite_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(1.5f, 6.0f).sound(SoundType.STONE)));
        DIORITE_BRICKS = registerBlock("diorite_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.QUARTZ).requiresCorrectToolForDrops().strength(1.5f, 6.0f).sound(SoundType.STONE)));
        GRANITE_BRICKS = registerBlock("granite_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DIRT).requiresCorrectToolForDrops().strength(1.5f, 6.0f).sound(SoundType.STONE)));

        // Mineral Blocks
        AQUAMARINE_BLOCK = registerBlock("aquamarine_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_BLUE).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.STONE)));

        // Stairs
        COBBLED_ANDESITE_STAIRS = registerBlock("cobbled_andesite_stairs", () -> new StairBlock(COBBLED_ANDESITE.get()::defaultBlockState, Block.Properties.copy(COBBLED_ANDESITE.get())));
        COBBLED_DIORITE_STAIRS = registerBlock("cobbled_diorite_stairs", () -> new StairBlock(COBBLED_DIORITE.get()::defaultBlockState, Block.Properties.copy(COBBLED_DIORITE.get())));
        COBBLED_GRANITE_STAIRS = registerBlock("cobbled_granite_stairs", () -> new StairBlock(COBBLED_GRANITE.get()::defaultBlockState, Block.Properties.copy(COBBLED_GRANITE.get())));
        ANDESITE_BRICK_STAIRS = registerBlock("andesite_brick_stairs", () -> new StairBlock(ANDESITE_BRICKS.get()::defaultBlockState, Block.Properties.copy(ANDESITE_BRICKS.get())));
        DIORITE_BRICK_STAIRS = registerBlock("diorite_brick_stairs", () -> new StairBlock(DIORITE_BRICKS.get()::defaultBlockState, Block.Properties.copy(DIORITE_BRICKS.get())));
        GRANITE_BRICK_STAIRS = registerBlock("granite_brick_stairs", () -> new StairBlock(GRANITE_BRICKS.get()::defaultBlockState, Block.Properties.copy(GRANITE_BRICKS.get())));

        // Slabs
        COBBLED_ANDESITE_SLAB = registerBlock("cobbled_andesite_slab", () -> new SlabBlock(Block.Properties.copy(COBBLED_ANDESITE.get())));
        COBBLED_DIORITE_SLAB = registerBlock("cobbled_diorite_slab", () -> new SlabBlock(Block.Properties.copy(COBBLED_DIORITE.get())));
        COBBLED_GRANITE_SLAB = registerBlock("cobbled_granite_slab", () -> new SlabBlock(Block.Properties.copy(COBBLED_GRANITE.get())));
        ANDESITE_BRICK_SLAB = registerBlock("andesite_brick_slab", () -> new SlabBlock(Block.Properties.copy(ANDESITE_BRICKS.get())));
        DIORITE_BRICK_SLAB = registerBlock("diorite_brick_slab", () -> new SlabBlock(Block.Properties.copy(DIORITE_BRICKS.get())));
        GRANITE_BRICK_SLAB = registerBlock("granite_brick_slab", () -> new SlabBlock(Block.Properties.copy(GRANITE_BRICKS.get())));

        // Walls
        COBBLED_ANDESITE_WALL = registerBlock("cobbled_andesite_wall", () -> new WallBlock(Block.Properties.copy(COBBLED_ANDESITE.get())));
        COBBLED_DIORITE_WALL = registerBlock("cobbled_diorite_wall", () -> new WallBlock(Block.Properties.copy(COBBLED_DIORITE.get())));
        COBBLED_GRANITE_WALL = registerBlock("cobbled_granite_wall", () -> new WallBlock(Block.Properties.copy(COBBLED_GRANITE.get())));
        ANDESITE_BRICK_WALL = registerBlock("andesite_brick_wall", () -> new WallBlock(Block.Properties.copy(ANDESITE_BRICKS.get())));
        DIORITE_BRICK_WALL = registerBlock("diorite_brick_wall", () -> new WallBlock(Block.Properties.copy(DIORITE_BRICKS.get())));
        GRANITE_BRICK_WALL = registerBlock("granite_brick_wall", () -> new WallBlock(Block.Properties.copy(GRANITE_BRICKS.get())));


    }

    public static RegistryObject<Block> registerBlock(String name, Supplier<Block> blockSupplier)
    {
        RegistryObject<Block> blockRegistryObject = SupremeMC.BLOCK_REGISTER.register(name, blockSupplier);
        SupremeMC.ITEM_REGISTER.register(name, () -> new BlockItem(blockRegistryObject.get(), new Item.Properties()));
        return blockRegistryObject;
    }

    public static RegistryObject<Block> registerBlock(Supplier<Block> blockSupplier, Supplier<BlockItem> itemBlockSupplier, String name)
    {
        RegistryObject<Block> blockRegistryObject = SupremeMC.BLOCK_REGISTER.register(name, blockSupplier);
        if (itemBlockSupplier != null) SupremeMC.ITEM_REGISTER.register(name, itemBlockSupplier);
        return blockRegistryObject;
    }
}



