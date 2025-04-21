package net.mcreator.noescape.events;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "no_escape", value = Dist.CLIENT)
public class TabListModifier {

    private static boolean shown = false;

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Minecraft mc = Minecraft.getInstance();

            if (mc.options.keyPlayerList.isDown()) {
                if (!shown) {
                    mc.gui.getTabList().setHeader(Component.literal("§4§lServer List"));
                    mc.gui.getTabList().setFooter(Component.literal(
                        "§eThere\n§eİs\n§eNo\n§eEscape"
                    ));
                    shown = true;
                }
            } else {
                shown = false; // TAB bırakıldığında tekrar güncelleyebilmek için
            }
        }
    }
}
