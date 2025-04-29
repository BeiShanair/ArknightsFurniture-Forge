package com.besson.arknights.block;

import com.besson.arknights.ArknightsFurniture;
import com.besson.arknights.block.warehouse.CartonBE;
import com.besson.arknights.block.warehouse.LargeShelfBE;
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

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(
            String name, BlockEntityType.BlockEntitySupplier<T> supplier, Supplier<Block[]> validBlocksSupplier) {
        return BLOCK_ENTITIES.register(name,
                () -> BlockEntityType.Builder.of(supplier, validBlocksSupplier.get()).build(null));
    }

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
