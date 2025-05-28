package com.besson.arknights.block;

import com.besson.arknights.ArknightsFurniture;
import com.besson.arknights.block.columbian.*;
import com.besson.arknights.block.fantastic.*;
import com.besson.arknights.block.sideline.*;
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
    public static final RegistryObject<Block> LARGE_SHELF2 = registerBlockWithoutItems("warehouse/large_shelf2", () -> new LargeShelf(Block.Properties.of().strength(0.2f,0.2f).noOcclusion(), ModBlockEntities.LARGE_SHELF::get));
    public static final RegistryObject<Block> LARGE_SHELF3 = registerBlockWithoutItems("warehouse/large_shelf3", () -> new LargeShelf(Block.Properties.of().strength(0.2f,0.2f).noOcclusion(), ModBlockEntities.LARGE_SHELF::get));
    public static final RegistryObject<Block> LARGE_SHELF4 = registerBlockWithoutItems("warehouse/large_shelf4", () -> new LargeShelf(Block.Properties.of().strength(0.2f,0.2f).noOcclusion(), ModBlockEntities.LARGE_SHELF::get));
    public static final RegistryObject<Block> PALLET = registerBlocks("warehouse/pallet", () -> new Pallet(Block.Properties.of().strength(0.2f,0.2f).noOcclusion()));
    public static final RegistryObject<Block> PILE_OF_CARTONS = registerBlocks("warehouse/pile_of_cartons", () -> new PileOfCartons(Block.Properties.of().strength(0.2f,0.2f).noOcclusion()));
    public static final RegistryObject<Block> PORTABLE_CALCULATOR = registerBlocks("warehouse/portable_calculator", () -> new PortableCalculator(Block.Properties.of().strength(0.2f,0.2f).noOcclusion()));
    public static final RegistryObject<Block> POST_IT_NOTE = registerBlocks("warehouse/post_it_note", () -> new PostItNote(Block.Properties.of().strength(0.2f,0.2f).noOcclusion()));
    public static final RegistryObject<Block> REINFORCED_CONCRETE_WALLS = registerBlocks("warehouse/reinforced_concrete_walls", () -> new ReinforcedConcreteWalls(Block.Properties.of().strength(0.2f,0.2f).noOcclusion()));
    public static final RegistryObject<Block> CEILING_ROW_LIGHT = registerBlocks("warehouse/ceiling_row_light", () -> new CeilingRowLight(Block.Properties.of().strength(0.2f,0.2f).noOcclusion()));
    public static final RegistryObject<Block> CONCRETE_WALL = registerBlocks("warehouse/concrete_wall", () -> new ConcreteWall(Block.Properties.of().strength(0.2f,0.2f).noOcclusion()));
    public static final RegistryObject<Block> DORMITORY_DOOR_FRAMES = registerBlocks("warehouse/dormitory_door_frames", () -> new DormitoryDoorFrames(Block.Properties.of().strength(0.2f,0.2f).noOcclusion()));

    public static final RegistryObject<Block> GRAYISH_WALL_LIGHT = registerBlocks("sideline/grayish_wall_light",() -> new WallLight(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> SIMPLE_BLACK_CLOCK = registerBlocks("sideline/simple_black_clock",() -> new SimpleClock(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> BLACK_HD_TV = registerBlocks("sideline/black_hd_tv",() -> new HDTV(Block.Properties.of().strength(0.2f, 0.1f)));
    public static final RegistryObject<Block> BLACK_NIGHTSTAND = registerBlocks("sideline/black_nightstand",() -> new Nightstand(Block.Properties.of().noOcclusion().strength(0.2f, 0.2f), ModBlockEntities.NIGHTSTAND::get));
    public static final RegistryObject<Block> BLACK_BED = registerBlocks("sideline/black_bed",() -> new FurnitureBedBlock(DyeColor.BLACK, Block.Properties.of().strength(0.2f, 0.2f).noOcclusion()));
    public static final RegistryObject<Block> SMALL_CALLBOARD = registerBlocks("sideline/small_callboard",() -> new SmallCallboard(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> BLACK_AND_WHITE_SQUARE_TABLE = registerBlocks("sideline/black_and_white_square_table",() -> new SquareTable(Block.Properties.of().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> LOW_BLACK_AND_WHITE_SOFA = registerBlocks("sideline/low_black_and_white_sofa",() -> new LowSofa(Block.Properties.of().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> CHECKERBOARD_BOOKCASE_BBL = registerBlocks("sideline/checkerboard_bookcase_bbl",() -> new CheckerboardBookcase(Block.Properties.of().strength(0.2f, 0.2f), ModBlockEntities.CHECKERBOARD_BOOKCASE::get));
    public static final RegistryObject<Block> CHECKERBOARD_BOOKCASE_BBR = registerBlockWithoutItems("sideline/checkerboard_bookcase_bbr",() -> new CheckerboardBookcase(Block.Properties.of().strength(0.2f, 0.2f), ModBlockEntities.CHECKERBOARD_BOOKCASE::get));
    public static final RegistryObject<Block> CHECKERBOARD_BOOKCASE_BTL = registerBlockWithoutItems("sideline/checkerboard_bookcase_btl",() -> new CheckerboardBookcase(Block.Properties.of().strength(0.2f, 0.2f), ModBlockEntities.CHECKERBOARD_BOOKCASE::get));
    public static final RegistryObject<Block> CHECKERBOARD_BOOKCASE_BTR = registerBlockWithoutItems("sideline/checkerboard_bookcase_btr",() -> new CheckerboardBookcase(Block.Properties.of().strength(0.2f, 0.2f), ModBlockEntities.CHECKERBOARD_BOOKCASE::get));
    public static final RegistryObject<Block> CHECKERBOARD_BOOKCASE_MBL = registerBlockWithoutItems("sideline/checkerboard_bookcase_mbl",() -> new CheckerboardBookcase(Block.Properties.of().strength(0.2f, 0.2f), ModBlockEntities.CHECKERBOARD_BOOKCASE::get));
    public static final RegistryObject<Block> CHECKERBOARD_BOOKCASE_MBR = registerBlockWithoutItems("sideline/checkerboard_bookcase_mbr",() -> new CheckerboardBookcase(Block.Properties.of().strength(0.2f, 0.2f), ModBlockEntities.CHECKERBOARD_BOOKCASE::get));
    public static final RegistryObject<Block> CHECKERBOARD_BOOKCASE_MTL = registerBlockWithoutItems("sideline/checkerboard_bookcase_mtl",() -> new CheckerboardBookcase(Block.Properties.of().strength(0.2f, 0.2f), ModBlockEntities.CHECKERBOARD_BOOKCASE::get));
    public static final RegistryObject<Block> CHECKERBOARD_BOOKCASE_MTR = registerBlockWithoutItems("sideline/checkerboard_bookcase_mtr",() -> new CheckerboardBookcase(Block.Properties.of().strength(0.2f, 0.2f), ModBlockEntities.CHECKERBOARD_BOOKCASE::get));
    public static final RegistryObject<Block> CHECKERBOARD_BOOKCASE_TL = registerBlockWithoutItems("sideline/checkerboard_bookcase_tl",() -> new CheckerboardBookcase(Block.Properties.of().strength(0.2f, 0.2f), ModBlockEntities.CHECKERBOARD_BOOKCASE::get));
    public static final RegistryObject<Block> CHECKERBOARD_BOOKCASE_TR = registerBlockWithoutItems("sideline/checkerboard_bookcase_tr",() -> new CheckerboardBookcase(Block.Properties.of().strength(0.2f, 0.2f), ModBlockEntities.CHECKERBOARD_BOOKCASE::get));
    public static final RegistryObject<Block> GRAY_FIBER_CARPET = registerBlocks("sideline/gray_fiber_carpet",() -> new FiberCarpet(Block.Properties.of().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> GRAYISH_WALL_BBL = registerBlocks("sideline/grayish_wall_bbl",() -> new GrayishWallBottom(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> GRAYISH_WALL_BBR = registerBlockWithoutItems("sideline/grayish_wall_bbr",() -> new GrayishWallBottom(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> GRAYISH_WALL_BTL = registerBlockWithoutItems("sideline/grayish_wall_btl",() -> new GrayishWallBottom(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> GRAYISH_WALL_BTR = registerBlockWithoutItems("sideline/grayish_wall_btr",() -> new GrayishWallBottom(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> GRAYISH_WALL_TBL = registerBlocks("sideline/grayish_wall_tbl",() -> new GrayishWallTop(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> GRAYISH_WALL_TBR = registerBlockWithoutItems("sideline/grayish_wall_tbr",() -> new GrayishWallTop(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> GRAYISH_WALL_TTL = registerBlockWithoutItems("sideline/grayish_wall_ttl",() -> new GrayishWallTop(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> GRAYISH_WALL_TTR = registerBlockWithoutItems("sideline/grayish_wall_ttr",() -> new GrayishWallTop(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> SMALL_CEILING_LIGHT = registerBlocks("sideline/small_ceiling_light",() -> new CeilingLight(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> SIMPLE_BLACK_CABINET = registerBlocks("sideline/simple_black_cabinet",() -> new SimpleCabinet(Block.Properties.of().strength(0.2f, 0.2f).noOcclusion(), ModBlockEntities.SIMPLE_CABINET::get));
    public static final RegistryObject<Block> BLACK_OFFICE_CHAIR = registerBlocks("sideline/black_office_chair",() -> new OfficeChair(Block.Properties.of().noOcclusion().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> SIMPLE_BLACK_DESK_LBL = registerBlocks("sideline/simple_black_desk_lbl",() -> new BlackSimpleDesk(Block.Properties.of().noOcclusion().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> SIMPLE_BLACK_DESK_LBR = registerBlockWithoutItems("sideline/simple_black_desk_lbr",() -> new BlackSimpleDeskMiddle(Block.Properties.of().noOcclusion().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> SIMPLE_BLACK_DESK_LTL = registerBlockWithoutItems("sideline/simple_black_desk_ltl",() -> new BlackSimpleDesk(Block.Properties.of().noOcclusion().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> SIMPLE_BLACK_DESK_LTR = registerBlockWithoutItems("sideline/simple_black_desk_ltr",() -> new BlackSimpleDeskMiddle(Block.Properties.of().noOcclusion().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> SIMPLE_BLACK_DESK_RBL = registerBlockWithoutItems("sideline/simple_black_desk_rbl",() -> new BlackSimpleDeskMiddle(Block.Properties.of().noOcclusion().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> SIMPLE_BLACK_DESK_RBR = registerBlockWithoutItems("sideline/simple_black_desk_rbr",() -> new BlackSimpleDesk(Block.Properties.of().noOcclusion().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> SIMPLE_BLACK_DESK_RTL = registerBlockWithoutItems("sideline/simple_black_desk_rtl",() -> new BlackSimpleDeskMiddle(Block.Properties.of().noOcclusion().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> SIMPLE_BLACK_DESK_RTR = registerBlockWithoutItems("sideline/simple_black_desk_rtr",() -> new BlackSimpleDesk(Block.Properties.of().noOcclusion().strength(0.2f, 0.2f)));

    public static final RegistryObject<Block> BAR_CEILING = registerBlocks("columbian/bar_ceiling",() -> new BarCeiling(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> BARSTOOL_WITH_CURVED_LEGS = registerBlocks("columbian/barstool_with_curved_legs",() -> new BarstoolWithCurvedLegs(Block.Properties.of().strength(0.2f, 0.2f).noOcclusion()));
    public static final RegistryObject<Block> BEVERAGE_CABINET_COFFEE = registerBlocks("columbian/beverage_cabinet_coffee",() -> new BeverageCabinet(Block.Properties.of().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> BEVERAGE_CABINET_EMPTY = registerBlocks("columbian/beverage_cabinet_empty",() -> new BeverageCabinetEmpty(Block.Properties.of().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> BEVERAGE_MENU = registerBlocks("columbian/beverage_menu",() -> new BeverageMenu(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> BOLIVARIAN_COFFEE_BEAN = registerBlocks("columbian/bolivarian_coffee_bean",() -> new BolivarianCoffeeBean(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> BRICK_PATTERN_WALLPAPER = registerBlocks("columbian/brick_pattern_wallpaper",() -> new BrickPatternWallpaper(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> BRICK_PATTERN_WALLPAPER_FLOOR = registerBlocks("columbian/brick_pattern_wallpaper_floor",() -> new BrickPatternWallpaper(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> BROWN_BOOKCASE_LB = registerBlocks("columbian/brown_bookcase_lb",() -> new BrownBookcase(Block.Properties.of().strength(0.2f, 0.2f).noOcclusion()));
    public static final RegistryObject<Block> BROWN_BOOKCASE_LM = registerBlockWithoutItems("columbian/brown_bookcase_lm",() -> new BrownBookcase(Block.Properties.of().strength(0.2f, 0.2f).noOcclusion()));
    public static final RegistryObject<Block> BROWN_BOOKCASE_LT = registerBlockWithoutItems("columbian/brown_bookcase_lt",() -> new BrownBookcase(Block.Properties.of().strength(0.2f, 0.2f).noOcclusion()));
    public static final RegistryObject<Block> BROWN_BOOKCASE_RB = registerBlockWithoutItems("columbian/brown_bookcase_rb",() -> new BrownBookcase(Block.Properties.of().strength(0.2f, 0.2f).noOcclusion()));
    public static final RegistryObject<Block> BROWN_BOOKCASE_RM = registerBlockWithoutItems("columbian/brown_bookcase_rm",() -> new BrownBookcase(Block.Properties.of().strength(0.2f, 0.2f).noOcclusion()));
    public static final RegistryObject<Block> BROWN_BOOKCASE_RT = registerBlockWithoutItems("columbian/brown_bookcase_rt",() -> new BrownBookcase(Block.Properties.of().strength(0.2f, 0.2f).noOcclusion()));
    public static final RegistryObject<Block> COFFEE_BEAN_CAN = registerBlocks("columbian/coffee_bean_can",() -> new CoffeeBeanCan(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> COFFEE_BEAN_DISPLAY = registerBlocks("columbian/coffee_bean_display",() -> new CoffeeBeanDisplay(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> COFFEE_MENU = registerBlocks("columbian/coffee_menu",() -> new CoffeeMenu(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> COLUMBIAN_STREET_VIEW_PHOTO = registerBlocks("columbian/columbian_street_view_photo",() -> new ColumbianStreetViewPhoto(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> DINING_CHAIR = registerBlocks("columbian/dining_chair",() -> new DiningChair(Block.Properties.of().noOcclusion().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> PEDESTAL_COFFEE_TABLE = registerBlocks("columbian/pedestal_coffee_table",() -> new PedestalCoffeeTable(Block.Properties.of().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> PENDANT_LIGHT = registerBlocks("columbian/pendant_light",() -> new PendantLight(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> POTTED_LONG_LEAF_PLANT = registerBlocks("columbian/potted_long_leaf_plant",() -> new PottedLongLeafPlant(Block.Properties.of().strength(0.1f, 0.1f).noOcclusion()));
    public static final RegistryObject<Block> RED_BRICK_CAFE_BAR = registerBlocks("columbian/red_brick_cafe_bar",() -> new RedBrickCafeBar(Block.Properties.of().strength(0.2f, 0.2f).noOcclusion()));
    public static final RegistryObject<Block> RED_BROWN_CABINET = registerBlocks("columbian/red_brown_cabinet",() -> new RedBrownCabinet(Block.Properties.of().strength(0.2f, 0.2f), ModBlockEntities.RED_BROWN_CABINET::get));
    public static final RegistryObject<Block> SOFT_CEILING_LIGHT = registerBlocks("columbian/soft_ceiling_light",() -> new SoftCeilingLight(Block.Properties.of().strength(0.1f, 0.1f).noOcclusion()));
    public static final RegistryObject<Block> WOOD_ORNAMENT = registerBlocks("columbian/wood_ornament",() -> new WoodOrnament(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> CAFE_FLOOR = registerBlocks("columbian/cafe_floor",() -> new Block(Block.Properties.of().strength(0.1f, 0.1f)));

    public static final RegistryObject<Block> BROWN_BEAN_BAG_SOFA = registerBlocks("fantastic/brown_bean_bag_sofa", () -> new BrownBeanBagSofa(Block.Properties.of().strength(0.2f, 0.2f).noOcclusion()));
    public static final RegistryObject<Block> ECO_EXHIBITION_CABINET = registerBlockWithoutItems("fantastic/eco_exhibition_cabinet",() -> new EcoExhibitionCabinetBase(Block.Properties.of().strength(0.2f, 0.2f).noOcclusion()));
    public static final RegistryObject<Block> ECO_EXHIBITION_CABINET_BASE = registerBlocks("fantastic/eco_exhibition_cabinet_base",() -> new EcoExhibitionCabinetBase(Block.Properties.of().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> FLUSH_MOUNT_RECTANGLE_CEILING_LIGHT = registerBlocks("fantastic/flush_mount_rectangle_ceiling_light",() -> new FlushMountRectangleCeilingLight(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> FLUSH_MOUNT_SQUARE_CEILING_LIGHT = registerBlocks("fantastic/flush_mount_square_ceiling_light",() -> new FlushMountSquareCeilingLight(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> METALLIC_BED = registerBlocks("fantastic/metallic_bed",() -> new MetallicBed(DyeColor.BLACK, Block.Properties.of().strength(0.2f, 0.2f).noOcclusion()));
    public static final RegistryObject<Block> POTTED_BROADLEAF_PLANT = registerBlocks("fantastic/potted_broadleaf_plant",() -> new PottedBroadleafPlant(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> POTTED_CONIFER_PLANT = registerBlocks("fantastic/potted_conifer_plant",() -> new PottedConiferPlant(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> POTTED_SUCCULENT_PLANT = registerBlocks("fantastic/potted_succulent_plant",() -> new PottedSucculentPlant(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> SMALL_SQUARE_NIGHTSTAND = registerBlocks("fantastic/small_square_nightstand",() -> new SmallSquareNightstand(Block.Properties.of().strength(0.2f, 0.2f).noOcclusion(),ModBlockEntities.SMALL_SQUARE_NIGHTSTAND::get));
    public static final RegistryObject<Block> SPECIMEN_DATA_BOARD = registerBlocks("fantastic/specimen_data_board",() -> new SpecimenDataBoard(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> WIRE_SIDE_TABLE = registerBlocks("fantastic/wire_side_table",() -> new WireSideTable(Block.Properties.of().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> COPPER_FLOOR_FRONT = registerBlocks("fantastic/copper_floor_front",() -> new CopperFloor(Block.Properties.of().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> COPPER_FLOOR_BEHIND = registerBlockWithoutItems("fantastic/copper_floor_behind",() -> new CopperFloor(Block.Properties.of().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> METALLIC_WALLPAPER_BOTTOM = registerBlocks("fantastic/metallic_wallpaper_bottom",() -> new MetallicWallpaper1(Block.Properties.of().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> METALLIC_WALLPAPER_TOP = registerBlockWithoutItems("fantastic/metallic_wallpaper_top",() -> new MetallicWallpaper1(Block.Properties.of().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> METALLIC_WALLPAPER_LB = registerBlocks("fantastic/metallic_wallpaper_lb",() -> new MetallicWallpaper2(Block.Properties.of().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> METALLIC_WALLPAPER_LT = registerBlockWithoutItems("fantastic/metallic_wallpaper_lt",() -> new MetallicWallpaper2(Block.Properties.of().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> METALLIC_WALLPAPER_RB = registerBlockWithoutItems("fantastic/metallic_wallpaper_rb",() -> new MetallicWallpaper2(Block.Properties.of().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> METALLIC_WALLPAPER_RT = registerBlockWithoutItems("fantastic/metallic_wallpaper_rt",() -> new MetallicWallpaper2(Block.Properties.of().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> UNKNOWN_SPECIMENS = registerBlocks("fantastic/unknown_specimens",() -> new UnknownSpecimens(Block.Properties.of().strength(0.1f, 0.1f)));
    public static final RegistryObject<Block> WIDE_GRAY_CARPET_LEFT = registerBlocks("fantastic/wide_gray_carpet_left",() -> new WideGrayCarpet(Block.Properties.of().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> WIDE_GRAY_CARPET_RIGHT = registerBlockWithoutItems("fantastic/wide_gray_carpet_right",() -> new WideGrayCarpet(Block.Properties.of().strength(0.2f, 0.2f)));
    public static final RegistryObject<Block> UNKNOWN_BONES = registerBlocks("fantastic/unknown_bones",() -> new UnknownBones(Block.Properties.of().strength(0.2f, 0.2f)));


    private static <T extends Block> RegistryObject<T> registerBlockWithoutItems(String id, Supplier<T> block){
        return BLOCKS.register(id, block);
    }

    private static <T extends Block>RegistryObject<T> registerBlocks(String id, Supplier<T> block){
        RegistryObject<T> blocks = BLOCKS.register(id, block);
        registerBlockItem(id, blocks);
        return blocks;
    }
    private static <T extends Block> void registerBlockItem(String id, RegistryObject<T> block){
        ModItems.ITEM.register(id, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
