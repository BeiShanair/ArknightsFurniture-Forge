package com.besson.arknights.block;

import com.besson.arknights.ArknightsFurniture;
import com.besson.arknights.block.sideline.CheckerboardBookcaseBE;
import com.besson.arknights.block.sideline.NightstandBE;
import com.besson.arknights.block.sideline.SimpleCabinetBE;
import com.besson.arknights.block.warehouse.CartonBE;
import com.besson.arknights.block.warehouse.LargeShelfBE;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ArknightsFurniture.MOD_ID);

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ArknightsFurniture.MOD_ID);

    public static final RegistryObject<EntityType<SeatEntity>> SEAT =
            register("seat", EntityType.Builder.<SeatEntity>of((type, world) ->
                    new SeatEntity(world), MobCategory.MISC).sized(0.0F, 0.0F).setCustomClientFactory((spawnEntity, world) -> new SeatEntity(world)));

    public static final RegistryObject<BlockEntityType<CartonBE>> CARTON =
            register("carton", CartonBE::new,
                    () -> new Block[]{ModBlocks.CARTON.get()});

    public static final RegistryObject<BlockEntityType<LargeShelfBE>> LARGE_SHELF =
            register("large_shelf", LargeShelfBE::new,
                    () -> new Block[]{
                            ModBlocks.LARGE_SHELF1.get(),
                            ModBlocks.LARGE_SHELF2.get(),
                            ModBlocks.LARGE_SHELF3.get(),
                            ModBlocks.LARGE_SHELF4.get()});

    public static final RegistryObject<BlockEntityType<CheckerboardBookcaseBE>> CHECKERBOARD_BOOKCASE =
            register("checkerboard_bookcase", CheckerboardBookcaseBE::new,
                    () -> new Block[]{
                            ModBlocks.CHECKERBOARD_BOOKCASE_BBL.get(),
                            ModBlocks.CHECKERBOARD_BOOKCASE_BBR.get(),
                            ModBlocks.CHECKERBOARD_BOOKCASE_BTL.get(),
                            ModBlocks.CHECKERBOARD_BOOKCASE_BTR.get(),
                            ModBlocks.CHECKERBOARD_BOOKCASE_MBL.get(),
                            ModBlocks.CHECKERBOARD_BOOKCASE_MBR.get(),
                            ModBlocks.CHECKERBOARD_BOOKCASE_MTL.get(),
                            ModBlocks.CHECKERBOARD_BOOKCASE_MTR.get(),
                            ModBlocks.CHECKERBOARD_BOOKCASE_TL.get(),
                            ModBlocks.CHECKERBOARD_BOOKCASE_TR.get()});

    public static final RegistryObject<BlockEntityType<NightstandBE>> NIGHTSTAND =
            register("nightstand", NightstandBE::new,
                    () -> new Block[]{ModBlocks.BLACK_NIGHTSTAND.get()});

    public static final RegistryObject<BlockEntityType<SimpleCabinetBE>> SIMPLE_CABINET =
            register("simple_cabinet", SimpleCabinetBE::new,
                    () -> new Block[]{ModBlocks.SIMPLE_BLACK_CABINET.get()});
    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.Builder<T> builder)
    {
        return ENTITY_TYPES.register(name, () -> builder.build(name));
    }

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(
            String name, BlockEntityType.BlockEntitySupplier<T> supplier, Supplier<Block[]> validBlocksSupplier) {
        return BLOCK_ENTITIES.register(name,
                () -> BlockEntityType.Builder.of(supplier, validBlocksSupplier.get()).build(null));
    }

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
        ENTITY_TYPES.register(eventBus);
    }
}
