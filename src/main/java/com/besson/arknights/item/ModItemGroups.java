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

    // region LOGO
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
    // endregion

    // region WAREHOUSE
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
    // endregion

    // region SIDE LINE
    public static final RegistryObject<CreativeModeTab> SIDE_LINE =
            ITEM_GROUPS.register("side_line", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.SIMPLE_BLACK_CLOCK.get()))
                    .title(Component.translatable("itemGroup.side_line"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.GRAYISH_WALL_LIGHT.get());
                        pOutput.accept(ModBlocks.SIMPLE_BLACK_CLOCK.get());
                        pOutput.accept(ModBlocks.BLACK_HD_TV.get());
                        pOutput.accept(ModBlocks.BLACK_NIGHTSTAND.get());
                        pOutput.accept(ModBlocks.BLACK_BED.get());
                        pOutput.accept(ModBlocks.SMALL_CALLBOARD.get());
                        pOutput.accept(ModBlocks.BLACK_AND_WHITE_SQUARE_TABLE.get());
                        pOutput.accept(ModBlocks.LOW_BLACK_AND_WHITE_SOFA.get());
                        pOutput.accept(ModBlocks.CHECKERBOARD_BOOKCASE_BBL.get());
                        pOutput.accept(ModBlocks.BLACK_OFFICE_CHAIR.get());
                        pOutput.accept(ModBlocks.SIMPLE_BLACK_CABINET.get());
                        pOutput.accept(ModBlocks.SIMPLE_BLACK_DESK_LBL.get());
                        pOutput.accept(ModBlocks.GRAY_FIBER_CARPET.get());
                        pOutput.accept(ModBlocks.GRAYISH_WALL_BBL.get());
                        pOutput.accept(ModBlocks.GRAYISH_WALL_TBL.get());
                        pOutput.accept(ModBlocks.SMALL_CEILING_LIGHT.get());
                    }).build());
    // endregion

    // region COLUMBIAN CAFE
    public static final RegistryObject<CreativeModeTab> COLUMBIAN_CAFE =
            ITEM_GROUPS.register("columbian_cafe", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.BOLIVARIAN_COFFEE_BEAN.get()))
                    .title(Component.translatable("itemGroup.columbian_cafe"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.BAR_CEILING.get());
                        pOutput.accept(ModBlocks.BARSTOOL_WITH_CURVED_LEGS.get());
                        pOutput.accept(ModBlocks.BEVERAGE_CABINET_COFFEE.get());
                        pOutput.accept(ModBlocks.BEVERAGE_CABINET_EMPTY.get());
                        pOutput.accept(ModBlocks.BEVERAGE_MENU.get());
                        pOutput.accept(ModBlocks.BOLIVARIAN_COFFEE_BEAN.get());
                        pOutput.accept(ModBlocks.BRICK_PATTERN_WALLPAPER.get());
                        pOutput.accept(ModBlocks.BRICK_PATTERN_WALLPAPER_FLOOR.get());
                        pOutput.accept(ModBlocks.BROWN_BOOKCASE_LB.get());
                        pOutput.accept(ModBlocks.COFFEE_BEAN_CAN.get());
                        pOutput.accept(ModBlocks.COFFEE_BEAN_DISPLAY.get());
                        pOutput.accept(ModBlocks.COFFEE_MENU.get());
                        pOutput.accept(ModBlocks.COLUMBIAN_STREET_VIEW_PHOTO.get());
                        pOutput.accept(ModBlocks.DINING_CHAIR.get());
                        pOutput.accept(ModBlocks.PEDESTAL_COFFEE_TABLE.get());
                        pOutput.accept(ModBlocks.PENDANT_LIGHT.get());
                        pOutput.accept(ModBlocks.POTTED_LONG_LEAF_PLANT.get());
                        pOutput.accept(ModBlocks.RED_BROWN_CABINET.get());
                        pOutput.accept(ModBlocks.RED_BRICK_CAFE_BAR.get());
                        pOutput.accept(ModBlocks.SOFT_CEILING_LIGHT.get());
                        pOutput.accept(ModBlocks.WOOD_ORNAMENT.get());
                        pOutput.accept(ModBlocks.CAFE_FLOOR.get());
                    }).build());
    // endregion

    // region FANTASTIC BIO DOCUMENTARY
    public static final RegistryObject<CreativeModeTab> FANTASTIC_BIO_DOCUMENTARY =
            ITEM_GROUPS.register("fantastic_bio_documentary", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.WIRE_SIDE_TABLE.get()))
                    .title(Component.translatable("itemGroup.fantastic_bio-documentary"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.BROWN_BEAN_BAG_SOFA.get());
                        pOutput.accept(ModBlocks.ECO_EXHIBITION_CABINET_BASE.get());
                        pOutput.accept(ModBlocks.FLUSH_MOUNT_RECTANGLE_CEILING_LIGHT.get());
                        pOutput.accept(ModBlocks.FLUSH_MOUNT_SQUARE_CEILING_LIGHT.get());
                        pOutput.accept(ModBlocks.METALLIC_BED.get());
                        pOutput.accept(ModBlocks.POTTED_BROADLEAF_PLANT.get());
                        pOutput.accept(ModBlocks.POTTED_CONIFER_PLANT.get());
                        pOutput.accept(ModBlocks.POTTED_SUCCULENT_PLANT.get());
                        pOutput.accept(ModBlocks.SMALL_SQUARE_NIGHTSTAND.get());
                        pOutput.accept(ModBlocks.SPECIMEN_DATA_BOARD.get());
                        pOutput.accept(ModBlocks.WIRE_SIDE_TABLE.get());
                        pOutput.accept(ModBlocks.COPPER_FLOOR_FRONT.get());
                        pOutput.accept(ModBlocks.METALLIC_WALLPAPER_BOTTOM.get());
                        pOutput.accept(ModBlocks.METALLIC_WALLPAPER_LB.get());
                        pOutput.accept(ModBlocks.UNKNOWN_SPECIMENS.get());
                        pOutput.accept(ModBlocks.WIDE_GRAY_CARPET_LEFT.get());
                        pOutput.accept(ModBlocks.UNKNOWN_BONES.get());
                    }).build());
    // endregion
    public static void register(IEventBus iEventBus){
        ITEM_GROUPS.register(iEventBus);
    }
}
