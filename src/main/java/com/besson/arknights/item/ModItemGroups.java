package com.besson.arknights.item;

import com.besson.arknights.ArknightsFurniture;
import com.besson.arknights.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModItemGroups {
    public static final DeferredRegister<CreativeModeTab> ITEM_GROUPS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ArknightsFurniture.MOD_ID);

    public static final RegistryObject<CreativeModeTab> LOGO =
            ITEM_GROUPS.register("logo", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.ABYSSAL_HUNTERS_LOGO.get()))
                    .title(Component.translatable("itemGroup.logo"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ABYSSAL_HUNTERS_LOGO.get());
                        pOutput.accept(ModItems.AEGIR_LOGO.get());
                        pOutput.accept(ModItems.BABEL_LOGO.get());
                        pOutput.accept(ModItems.BLACK_STEEL_LOGO.get());
                        pOutput.accept(ModItems.BOLIVAR_LOGO.get());
                        pOutput.accept(ModItems.COLUMBIA_LOGO.get());
                        pOutput.accept(ModItems.DONG_LOGO.get());
                        pOutput.accept(ModItems.DUBLINN_LOGO.get());
                        pOutput.accept(ModItems.ELITE_OP_LOGO.get());
                        pOutput.accept(ModItems.FOLLOWERS_LOGO.get());
                        pOutput.accept(ModItems.GLASGOW_LOGO.get());
                        pOutput.accept(ModItems.IBERIA_LOGO.get());
                        pOutput.accept(ModItems.KARLAN_TRADE_LOGO.get());
                        pOutput.accept(ModItems.KAZIMIERZ_LOGO.get());
                        pOutput.accept(ModItems.KJERAG_LOGO.get());
                        pOutput.accept(ModItems.LATERANO_LOGO.get());
                        pOutput.accept(ModItems.LEES_DETECTIVE_AGENCY_LOGO.get());
                        pOutput.accept(ModItems.LEITHANIEN_LOGO.get());
                        pOutput.accept(ModItems.LUNGMEN_LOGO.get());
                        pOutput.accept(ModItems.MINOS_LOGO.get());
                        pOutput.accept(ModItems.LUNGMEN_GUARD_DEPARTMENT_LOGO.get());
                        pOutput.accept(ModItems.OP_A4_LOGO.get());
                        pOutput.accept(ModItems.OP_RESERVE_A1_LOGO.get());
                        pOutput.accept(ModItems.OP_RESERVE_A4_LOGO.get());
                        pOutput.accept(ModItems.OP_RESERVE_A6_LOGO.get());
                        pOutput.accept(ModItems.PENGUIN_LOGISTICS_LOGO.get());
                        pOutput.accept(ModItems.PINUS_SYLVESTRIS_LOGO.get());
                        pOutput.accept(ModItems.RHINE_LAB_LOGO.get());
                        pOutput.accept(ModItems.RHODES_ISLAND_LOGO.get());
                        pOutput.accept(ModItems.RHODES_ISLAND_OVERRIDE_LOGO.get());
                        pOutput.accept(ModItems.RIM_BILLITON_LOGO.get());
                        pOutput.accept(ModItems.SAMI_LOGO.get());
                        pOutput.accept(ModItems.SARGON_LOGO.get());
                        pOutput.accept(ModItems.SIESTA_LOGO.get());
                        pOutput.accept(ModItems.SIRACUSA_LOGO.get());
                        pOutput.accept(ModItems.SIRACUSA_BRANCHES_LOGO.get());
                        pOutput.accept(ModItems.SUI_LOGO.get());
                        pOutput.accept(ModItems.SWEEP_LOGO.get());
                        pOutput.accept(ModItems.TEAM_RAINBOW_LOGO.get());
                        pOutput.accept(ModItems.URSUS_LOGO.get());
                        pOutput.accept(ModItems.URSUS_STUDENT_SELF_GOVERNING_GROUP_LOGO.get());
                        pOutput.accept(ModItems.VICTORIA_LOGO.get());
                        pOutput.accept(ModItems.YAN_LOGO.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> WAREHOUSE =
            ITEM_GROUPS.register("warehouse", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.CARTON.get()))
                    .title(Component.translatable("itemGroup.warehouse"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.AIR_MATTRESS.get());
                        pOutput.accept(ModBlocks.ATTENDANCE_BOARD.get());
                        pOutput.accept(ModBlocks.CARGO_TROLLEY.get());
                        pOutput.accept(ModBlocks.CARTON.get());
                        pOutput.accept(ModBlocks.CARTON_STOOL.get());
                        pOutput.accept(ModBlocks.GRAFFITI.get());
                        pOutput.accept(ModBlocks.LARGE_SHELF1.get());
                        pOutput.accept(ModBlocks.PALLET.get());
                        pOutput.accept(ModBlocks.PILE_OF_CARTONS.get());
                        pOutput.accept(ModBlocks.PORTABLE_CALCULATOR.get());
                        pOutput.accept(ModBlocks.POST_IT_NOTE.get());
                        pOutput.accept(ModBlocks.REINFORCED_CONCRETE_WALLS.get());
                        pOutput.accept(ModBlocks.CEILING_ROW_LIGHT.get());
                        pOutput.accept(ModBlocks.CONCRETE_WALL.get());
                        pOutput.accept(ModBlocks.DORMITORY_DOOR_FRAMES.get());
                    }).build());
    public static void register(IEventBus iEventBus){
        ITEM_GROUPS.register(iEventBus);
    }
}
