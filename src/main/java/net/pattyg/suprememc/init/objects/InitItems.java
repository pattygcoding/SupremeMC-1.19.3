package net.pattyg.suprememc.init.objects;

import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.Item;
import net.pattyg.suprememc.SupremeMC;


import java.util.function.Supplier;

import static net.pattyg.suprememc.api.SMCItems.*;

public class InitItems
{
    public static void setup()
    {
        registerItems();
    }

    private static void registerItems()
    {
        AQUAMARINE = registerItem("aquamarine", () -> new Item(new Item.Properties()));

    }


    public static RegistryObject<Item> registerItem(String name, Supplier<Item> itemSupplier)
    {
        return SupremeMC.ITEM_REGISTER.register(name, itemSupplier);
    }

}
