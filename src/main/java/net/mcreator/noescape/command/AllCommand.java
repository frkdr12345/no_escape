package net.mcreator.noescape.command;

import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mcreator.noescape.procedures.No2Procedure;
import net.minecraft.server.level.ServerPlayer;

@Mod.EventBusSubscriber
public class AllCommand {
    
    @SubscribeEvent
    public static void onChat(ServerChatEvent event) {
        if (event.getRawText().equalsIgnoreCase("ıs that all?")) {
            event.setCanceled(true);
            
            ServerPlayer player = event.getPlayer();
            if (player != null) {
                // No2Procedure'ın parametrelerine uygun şekilde çağırıyoruz
                No2Procedure.execute(
                    player.level(),  // LevelAccessor
                    player.getX(),  // double x
                    player.getY(),  // double y
                    player.getZ()   // double z
                );
            }
        }
    }
}