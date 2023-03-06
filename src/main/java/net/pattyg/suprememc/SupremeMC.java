package net.pattyg.suprememc;

import com.mojang.logging.LogUtils;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pattyg.suprememc.api.SMCBlocks;
import net.pattyg.suprememc.api.SMCItems;
import net.pattyg.suprememc.init.misc.InitTabs;
import net.pattyg.suprememc.init.objects.InitBlocks;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.sounds.SoundEvent;
import net.pattyg.suprememc.init.objects.InitItems;
import org.slf4j.Logger;

@Mod(SupremeMC.MOD_ID)
public class SupremeMC
{
    public static final String MOD_ID = "suprememc";
    private static final Logger LOGGER = LogUtils.getLogger();
    private static CreativeModeTab tab;

    public static final DeferredRegister<Biome> BIOME_REGISTER = DeferredRegister.create(Registries.BIOME, SupremeMC.MOD_ID);
    public static final DeferredRegister<Block> BLOCK_REGISTER = DeferredRegister.create(Registries.BLOCK, MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_REGISTER = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MOD_ID);
    public static final DeferredRegister<WorldCarver<?>> CARVER_REGISTER = DeferredRegister.create(Registries.CARVER, MOD_ID);
    public static final DeferredRegister<ConfiguredWorldCarver<?>> CONFIGURED_CARVER_REGISTER = DeferredRegister.create(Registries.CONFIGURED_CARVER, MOD_ID);
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURE_REGISTER = DeferredRegister.create(Registries.CONFIGURED_FEATURE, MOD_ID);
    public static final DeferredRegister<Level> DIMENSION_REGISTER = DeferredRegister.create(Registries.DIMENSION, MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE_REGISTER = DeferredRegister.create(Registries.ENTITY_TYPE, MOD_ID);
    public static final DeferredRegister<Feature<?>> FEATURE_REGISTER = DeferredRegister.create(Registries.FEATURE, MOD_ID);
    public static final DeferredRegister<Fluid> FLUID_REGISTER = DeferredRegister.create(Registries.FLUID, MOD_ID);
    public static final DeferredRegister<FluidType> FORGE_FLUID_REGISTER = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, MOD_ID);
    public static final DeferredRegister<Item> ITEM_REGISTER = DeferredRegister.create(Registries.ITEM, MOD_ID);
    public static final DeferredRegister<ParticleType<?>> PARTICLES_REGISTER = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, MOD_ID);
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANT_REGISTER = DeferredRegister.create(Registries.PAINTING_VARIANT, MOD_ID);
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURE_REGISTER = DeferredRegister.create(Registries.PLACED_FEATURE, MOD_ID);
    public static final DeferredRegister<SoundEvent> SOUND_EVENT_REGISTER = DeferredRegister.create(Registries.SOUND_EVENT, MOD_ID);


    public SupremeMC()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);


        // Register events
        BIOME_REGISTER.register(modEventBus);
        BLOCK_REGISTER.register(modEventBus);
        BLOCK_ENTITY_REGISTER.register(modEventBus);
        CARVER_REGISTER.register(modEventBus);
        CONFIGURED_CARVER_REGISTER.register(modEventBus);
        CONFIGURED_FEATURE_REGISTER.register(modEventBus);
        DIMENSION_REGISTER.register(modEventBus);
        ENTITY_TYPE_REGISTER.register(modEventBus);
        FEATURE_REGISTER.register(modEventBus);
        FLUID_REGISTER.register(modEventBus);
        FORGE_FLUID_REGISTER.register(modEventBus);
        ITEM_REGISTER.register(modEventBus);
        PARTICLES_REGISTER.register(modEventBus);
        PLACED_FEATURE_REGISTER.register(modEventBus);
        SOUND_EVENT_REGISTER.register(modEventBus);

        InitItems.setup();
        InitBlocks.setup();

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if(event.getTab() == InitTabs.SUPREMEMC_BLOCKS)
        {
            // Building Blocks
            event.accept(SMCBlocks.COBBLED_ANDESITE);
            event.accept(SMCBlocks.COBBLED_DIORITE);
            event.accept(SMCBlocks.COBBLED_GRANITE);
            event.accept(SMCBlocks.ANDESITE_BRICKS);
            event.accept(SMCBlocks.DIORITE_BRICKS);
            event.accept(SMCBlocks.GRANITE_BRICKS);
            event.accept(SMCBlocks.GLOWING_OBSIDIAN);
            event.accept(SMCBlocks.AQUAMARINE_BLOCK);
            
            // Slime Blocks
            event.accept(SMCBlocks.RED_SLIME_BLOCK);
            event.accept(SMCBlocks.ORANGE_SLIME_BLOCK);
            event.accept(SMCBlocks.YELLOW_SLIME_BLOCK);
            event.accept(SMCBlocks.LIME_SLIME_BLOCK);
            event.accept(SMCBlocks.GREEN_SLIME_BLOCK);
            event.accept(SMCBlocks.LIGHT_BLUE_SLIME_BLOCK);
            event.accept(SMCBlocks.CYAN_SLIME_BLOCK);
            event.accept(SMCBlocks.BLUE_SLIME_BLOCK);
            event.accept(SMCBlocks.PURPLE_SLIME_BLOCK);
            event.accept(SMCBlocks.MAGENTA_SLIME_BLOCK);
            event.accept(SMCBlocks.PINK_SLIME_BLOCK);
            event.accept(SMCBlocks.WHITE_SLIME_BLOCK);
            event.accept(SMCBlocks.LIGHT_GRAY_SLIME_BLOCK);
            event.accept(SMCBlocks.GRAY_SLIME_BLOCK);
            event.accept(SMCBlocks.BLACK_SLIME_BLOCK);
            event.accept(SMCBlocks.BROWN_SLIME_BLOCK);

            // Stairs
            event.accept(SMCBlocks.COBBLED_ANDESITE_STAIRS);
            event.accept(SMCBlocks.COBBLED_DIORITE_STAIRS);
            event.accept(SMCBlocks.COBBLED_GRANITE_STAIRS);
            event.accept(SMCBlocks.ANDESITE_BRICK_STAIRS);
            event.accept(SMCBlocks.DIORITE_BRICK_STAIRS);
            event.accept(SMCBlocks.GRANITE_BRICK_STAIRS);

            // Slabs
            event.accept(SMCBlocks.COBBLED_ANDESITE_SLAB);
            event.accept(SMCBlocks.COBBLED_DIORITE_SLAB);
            event.accept(SMCBlocks.COBBLED_GRANITE_SLAB);
            event.accept(SMCBlocks.ANDESITE_BRICK_SLAB);
            event.accept(SMCBlocks.DIORITE_BRICK_SLAB);
            event.accept(SMCBlocks.GRANITE_BRICK_SLAB);

            // Walls
            event.accept(SMCBlocks.COBBLED_ANDESITE_WALL);
            event.accept(SMCBlocks.COBBLED_DIORITE_WALL);
            event.accept(SMCBlocks.COBBLED_GRANITE_WALL);
            event.accept(SMCBlocks.ANDESITE_BRICK_WALL);
            event.accept(SMCBlocks.DIORITE_BRICK_WALL);
            event.accept(SMCBlocks.GRANITE_BRICK_WALL);
        }
        if(event.getTab() == InitTabs.SUPREMEMC_ITEMS)
        {
            event.accept(SMCItems.AQUAMARINE);
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {


        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }

    public static void setTab(CreativeModeTab tab)
    {
        if(SupremeMC.tab != null && tab != null) SupremeMC.tab = tab;
    }

    public static CreativeModeTab getTab()
    {
        return SupremeMC.tab;
    }
}
