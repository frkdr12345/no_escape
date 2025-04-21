package net.mcreator.noescape.command;

import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mcreator.noescape.procedures.HelpOnKeyPressedProcedure;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;

@Mod.EventBusSubscriber
public class ShutCommand {
    @SubscribeEvent
    public static void onChat(ServerChatEvent event) {
        if (event.getRawText().equalsIgnoreCase("help")) {
            
            event.setCanceled(true);
            
            
            if (event.getPlayer().level() instanceof ServerLevel) {
                ServerLevel world = (ServerLevel) event.getPlayer().level();
                HelpOnKeyPressedProcedure.execute((LevelAccessor)world);
            }
        }
    }
}