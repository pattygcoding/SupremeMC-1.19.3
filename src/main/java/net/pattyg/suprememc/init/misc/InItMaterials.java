package net.pattyg.suprememc.init.misc;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class InItMaterials
{
    public static final Material LIQUID_GAS = (new Material.Builder(MaterialColor.COLOR_LIGHT_BLUE)).noCollider().nonSolid().replaceable().liquid().build();
}
