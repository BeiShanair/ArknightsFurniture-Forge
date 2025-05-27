package com.besson.arknights.item;

import com.besson.arknights.ArknightsFurniture;
import com.besson.arknights.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEM =
            DeferredRegister.create(ForgeRegistries.ITEMS, ArknightsFurniture.MOD_ID);

    public static final RegistryObject<Item> ABYSSAL_HUNTERS_LOGO =
            ITEM.register("abyssal_hunters_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AEGIR_LOGO =
            ITEM.register("aegir_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BABEL_LOGO =
            ITEM.register("babel_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLACK_STEEL_LOGO =
            ITEM.register("black_steel_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BOLIVAR_LOGO =
            ITEM.register("bolivar_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COLUMBIA_LOGO =
            ITEM.register("columbia_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DONG_LOGO =
            ITEM.register("dong_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DUBLINN_LOGO =
            ITEM.register("dublinn_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ELITE_OP_LOGO =
            ITEM.register("elite_op_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FOLLOWERS_LOGO =
            ITEM.register("followers_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GLASGOW_LOGO =
            ITEM.register("glasgow_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IBERIA_LOGO =
            ITEM.register("iberia_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KARLAN_TRADE_LOGO =
            ITEM.register("karlan_trade_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KAZIMIERZ_LOGO =
            ITEM.register("kazimierz_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KJERAG_LOGO =
            ITEM.register("kjerag_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LATERANO_LOGO =
            ITEM.register("laterano_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEES_DETECTIVE_AGENCY_LOGO =
            ITEM.register("lee-s_detective_agency_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEITHANIEN_LOGO =
            ITEM.register("leithanien_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LUNGMEN_GUARD_DEPARTMENT_LOGO =
            ITEM.register("lungmen_guard_department_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LUNGMEN_LOGO =
            ITEM.register("lungmen_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MINOS_LOGO =
            ITEM.register("minos_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OP_A4_LOGO =
            ITEM.register("op_a4_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OP_RESERVE_A1_LOGO =
            ITEM.register("op_reserve_a1_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OP_RESERVE_A4_LOGO =
            ITEM.register("op_reserve_a4_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OP_RESERVE_A6_LOGO =
            ITEM.register("op_reserve_a6_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PENGUIN_LOGISTICS_LOGO =
            ITEM.register("penguin_logistics_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PINUS_SYLVESTRIS_LOGO =
            ITEM.register("pinus_sylvestris_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RHINE_LAB_LOGO =
            ITEM.register("rhine_lab_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RHODES_ISLAND_LOGO =
            ITEM.register("rhodes_island_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RHODES_ISLAND_OVERRIDE_LOGO =
            ITEM.register("rhodes_island_override_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RIM_BILLITON_LOGO =
            ITEM.register("rim_billiton_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SAMI_LOGO =
            ITEM.register("sami_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SARGON_LOGO =
            ITEM.register("sargon_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SIESTA_LOGO =
            ITEM.register("siesta_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SIRACUSA_BRANCHES_LOGO =
            ITEM.register("siracusa_branches_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SIRACUSA_LOGO =
            ITEM.register("siracusa_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SUI_LOGO =
            ITEM.register("sui_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SWEEP_LOGO =
            ITEM.register("sweep_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEAM_RAINBOW_LOGO =
            ITEM.register("team_rainbow_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> URSUS_LOGO =
            ITEM.register("ursus_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> URSUS_STUDENT_SELF_GOVERNING_GROUP_LOGO =
            ITEM.register("ursus_student_self-governing_group_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VICTORIA_LOGO =
            ITEM.register("victoria_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> YAN_LOGO =
            ITEM.register("yan_logo", () -> new Item(new Item.Properties()));

//    public static final RegistryObject<Item> LARGE_SHELF = registerSameBlockItems(
//            ModBlocks.LARGE_SHELF1.get(), ModBlocks.LARGE_SHELF2.get(), ModBlocks.LARGE_SHELF3.get(), ModBlocks.LARGE_SHELF4.get());
//    private static RegistryObject<Item> registerSameBlockItems(Block block, Block... blocks){
//        BlockItem blockItem = new BlockItem(block, new Item.Properties());
//        for (Block b : blocks){
//            Item.BY_BLOCK.put(b, blockItem);
//        }
//        return ITEM.register(block.getDescriptionId(), () -> blockItem);
//    }
    public static void register(IEventBus iEventBus){
        ITEM.register(iEventBus);
    }
}
