package net.pattyg.suprememc.init.objects;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.CreativeModeTabRegistry;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.Item;
import net.pattyg.suprememc.SupremeMC;
import net.pattyg.suprememc.item.ItemSMC;

import java.util.ArrayList;
import java.util.List;

public class SMCItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SupremeMC.MOD_ID);


    public static final RegistryObject<ItemSMC> AQUAMARINE = newItem("aquamarine");

    public static RegistryObject<ItemSMC> newItem(String name)
    {
        return ITEMS.register(name, () -> new ItemSMC());
    }

    public static void addItemsToItemGroup()
    {

    }

    private static void addToItemGroup(CreativeModeTab group, Item item)
    {

    }
}
