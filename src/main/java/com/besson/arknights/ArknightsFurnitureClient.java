package com.besson.arknights;

import com.besson.arknights.block.ModBlockEntities;
import com.besson.arknights.renderer.SeatEntityRenderer;
import net.minecraftforge.client.event.EntityRenderersEvent;

public class ArknightsFurnitureClient {
    public static void registerRenderer(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(ModBlockEntities.SEAT.get(), SeatEntityRenderer::new);
    }
}
