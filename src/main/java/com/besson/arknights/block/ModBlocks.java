package com.besson.arknights.block;

import com.besson.arknights.ArknightsFurniture;
import com.besson.arknights.block.warehouse.*;
import com.besson.arknights.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ArknightsFurniture.MOD_ID);

    public static final RegistryObject<Block> AIR_MATTRESS = registerBlocks("warehouse/air_mattress", () -> new AirMattress(DyeColor.BLACK, Block.Properties.of().strength(0.2f,0.2f).noOcclusion()));
    public static final RegistryObject<Block> ATTENDANCE_BOARD = registerBlocks("warehouse/attendance_board", () -> new AttendanceBoard(Block.Properties.of().strength(0.2f,0.2f).noOcclusion()));
    public static final RegistryObject<Block> CARGO_TROLLEY = registerBlocks("warehouse/cargo_trolley", () -> new CargoTrolley(Block.Properties.of().strength(0.2f,0.2f).noOcclusion()));
    public static final RegistryObject<Block> CARTON = registerBlocks("warehouse/carton", () -> new Carton(Block.Properties.of().strength(0.2f,0.2f).noOcclusion(), ModBlockEntities.CARTON::get));
    public static final RegistryObject<Block> CARTON_STOOL = registerBlocks("warehouse/carton_stool", () -> new CartonStool(Block.Properties.of().strength(0.2f,0.2f).noOcclusion()));
    public static final RegistryObject<Block> GRAFFITI = registerBlocks("warehouse/graffiti", () -> new Graffiti(Block.Properties.of().strength(0.2f,0.2f).noOcclusion()));
    public static final RegistryObject<Block> LARGE_SHELF1 = registerBlocks("warehouse/large_shelf1", () -> new LargeShelf(Block.Properties.of().strength(0.2f,0.2f).noOcclusion(), ModBlockEntities.LARGE_SHELF::get));
    public static final RegistryObject<Block> LARGE_SHELF2 = registerBlocks("warehouse/large_shelf2", () -> new LargeShelf(Block.Properties.of().strength(0.2f,0.2f).noOcclusion(), ModBlockEntities.LARGE_SHELF::get));
    public static final RegistryObject<Block> LARGE_SHELF3 = registerBlocks("warehouse/large_shelf3", () -> new LargeShelf(Block.Properties.of().strength(0.2f,0.2f).noOcclusion(), ModBlockEntities.LARGE_SHELF::get));
    public static final RegistryObject<Block> LARGE_SHELF4 = registerBlocks("warehouse/large_shelf4", () -> new LargeShelf(Block.Properties.of().strength(0.2f,0.2f).noOcclusion(), ModBlockEntities.LARGE_SHELF::get));
    public static final RegistryObject<Block> PALLET = registerBlocks("warehouse/pallet", () -> new Pallet(Block.Properties.of().strength(0.2f,0.2f).noOcclusion()));
    public static final RegistryObject<Block> PILE_OF_CARTONS = registerBlocks("warehouse/pile_of_cartons", () -> new PileOfCartons(Block.Properties.of().strength(0.2f,0.2f).noOcclusion()));
    public static final RegistryObject<Block> PORTABLE_CALCULATOR = registerBlocks("warehouse/portable_calculator", () -> new PortableCalculator(Block.Properties.of().strength(0.2f,0.2f).noOcclusion()));
    public static final RegistryObject<Block> POST_IT_NOTE = registerBlocks("warehouse/post_it_note", () -> new PostItNote(Block.Properties.of().strength(0.2f,0.2f).noOcclusion()));
    public static final RegistryObject<Block> REINFORCED_CONCRETE_WALLS = registerBlocks("warehouse/reinforced_concrete_walls", () -> new ReinforcedConcreteWalls(Block.Properties.of().strength(0.2f,0.2f).noOcclusion()));
    public static final RegistryObject<Block> CEILING_ROW_LIGHT = registerBlocks("warehouse/ceiling_row_light", () -> new CeilingRowLight(Block.Properties.of().strength(0.2f,0.2f).noOcclusion()));
    public static final RegistryObject<Block> CONCRETE_WALL = registerBlocks("warehouse/concrete_wall", () -> new ConcreteWall(Block.Properties.of().strength(0.2f,0.2f).noOcclusion()));
    public static final RegistryObject<Block> DORMITORY_DOOR_FRAMES = registerBlocks("warehouse/dormitory_door_frames", () -> new DormitoryDoorFrames(Block.Properties.of().strength(0.2f,0.2f).noOcclusion()));

    private static <T extends Block>RegistryObject<T> registerBlocks(String id, Supplier<T> block){
        RegistryObject<T> blocks = BLOCKS.register(id, block);
        registerBlockItem(id, blocks);
        return blocks;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String id, RegistryObject<T> block){
        return ModItems.ITEM.register(id, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
