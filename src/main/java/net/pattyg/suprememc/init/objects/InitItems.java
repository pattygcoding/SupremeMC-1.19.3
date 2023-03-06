package net.pattyg.suprememc.init.objects;

import com.google.common.base.Suppliers;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.Item;
import net.pattyg.suprememc.SupremeMC;
import net.pattyg.suprememc.api.SMCFluids;


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

        Supplier<? extends Fluid> LIQUID_GAS_SUPPLIER = Suppliers.memoize(() -> SMCFluids.LIQUID_GAS.get());
        LIQUID_GAS_BUCKET = registerItem("liquid_gas_bucket", () -> new BucketItem(LIQUID_GAS_SUPPLIER, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1)));


    }


    public static RegistryObject<Item> registerItem(String name, Supplier<Item> itemSupplier)
    {
        return SupremeMC.ITEM_REGISTER.register(name, itemSupplier);
    }

}
