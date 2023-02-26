package net.pattyg.suprememc;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.pattyg.suprememc.init.misc.SMCTabs;
import net.pattyg.suprememc.init.objects.SMCItems;
import org.slf4j.Logger;

@Mod(SupremeMC.MOD_ID)
public class SupremeMC
{
    public static final String MOD_ID = "suprememc";
    private static final Logger LOGGER = LogUtils.getLogger();
    private static CreativeModeTab tab;

    public SupremeMC()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

        SMCItems.ITEMS.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if(event.getTab() == SMCTabs.SUPREMEMC_TAB)
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
