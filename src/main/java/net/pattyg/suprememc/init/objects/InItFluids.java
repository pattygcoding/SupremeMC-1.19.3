package net.pattyg.suprememc.init.objects;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.RegistryObject;
import net.pattyg.suprememc.SupremeMC;
import net.pattyg.suprememc.block.LiquidGasFluidSMC;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static net.pattyg.suprememc.api.SMCFluids.*;


public class InItFluids
{
    public static void setup()
    {
        registerFluids();
    }

    public static void registerFluids()
    {
        FLOWING_LIQUID_GAS = registerFluid(() -> new LiquidGasFluidSMC.Flowing(), "flowing_liquid_gas");
        LIQUID_GAS = registerFluid(() -> new LiquidGasFluidSMC.Source(), "liquid_gas");

        LIQUID_GAS_TYPE = registerFluidType(() ->
                new FluidType(FluidType.Properties.create()
                        .descriptionId("block.suprememc.liquid_gas")
                        .fallDistanceModifier(0F)
                        .canExtinguish(true)
                        .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                        .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                        .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)
                        .density(3000)
                        .viscosity(6000))
                {
                    @Override
                    public @Nullable BlockPathTypes getBlockPathType(FluidState state, BlockGetter level, BlockPos pos, @Nullable Mob mob, boolean canFluidLog)
                    {
                        return canFluidLog ? super.getBlockPathType(state, level, pos, mob, true) : null;
                    }

                    @Override
                    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer)
                    {
                        consumer.accept(new IClientFluidTypeExtensions()
                        {
                            private static final ResourceLocation LIQUID_GAS_UNDERWATER = new ResourceLocation("suprememc:textures/block/liquid_gas_overlay.png"),
                                    LIQUID_GAS_STILL = new ResourceLocation("suprememc:block/liquid_gas_still"),
                                    LIQUID_GAS_FLOW = new ResourceLocation("suprememc:block/liquid_gas_flowing");

                            @Override
                            public ResourceLocation getStillTexture()
                            {
                                return LIQUID_GAS_STILL;
                            }

                            @Override
                            public ResourceLocation getFlowingTexture() { return LIQUID_GAS_FLOW; }

                            @Override
                            public ResourceLocation getRenderOverlayTexture(Minecraft mc) { return LIQUID_GAS_UNDERWATER; }

                            @Override
                            public Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor)
                            {
                                return new Vector3f(0.407F, 0.121F, 0.137F);
                            }

                            @Override
                            public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape)
                            {
                                RenderSystem.setShaderFogStart(0.125F);
                                RenderSystem.setShaderFogEnd(1.5F);
                            }
                        });
                    }
                }, "liquid_gas");
    }

    public static RegistryObject<Fluid> registerFluid(Supplier<Fluid> fluidSupplier, String name)
    {
        return SupremeMC.FLUID_REGISTER.register(name, fluidSupplier);
    }

    public static RegistryObject<FluidType> registerFluidType(Supplier<FluidType> fluidSupplier, String name)
    {
        return SupremeMC.FORGE_FLUID_REGISTER.register(name, fluidSupplier);
    }
}