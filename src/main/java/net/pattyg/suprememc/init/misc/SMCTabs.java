package net.pattyg.suprememc.init.misc;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.pattyg.suprememc.SupremeMC;
import net.pattyg.suprememc.init.objects.SMCItems;

@Mod.EventBusSubscriber(modid = SupremeMC.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SMCTabs
{
    public static CreativeModeTab SUPREMEMC_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTab(CreativeModeTabEvent .Register event)
    {
        SUPREMEMC_TAB = event.registerCreativeModeTab(new ResourceLocation(SupremeMC.MOD_ID, "suprememc_tab"),
                builder -> builder.icon(() -> new ItemStack(SMCItems.AQUAMARINE.get()))
                        .title(Component.translatable("creativemodetab.suprememc_tab")));
    }
}
