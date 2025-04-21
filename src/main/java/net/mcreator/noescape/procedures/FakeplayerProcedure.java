package net.mcreator.noescape.procedures;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.GameType;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket.Action;

import com.mojang.authlib.GameProfile;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.UUID;

@Mod.EventBusSubscriber
public class FakeplayerProcedure {

    @SubscribeEvent
    public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        MinecraftServer server = event.getEntity().getServer();
        ServerLevel level = server.overworld();

        String playerName = event.getEntity().getDisplayName().getString();
        server.getPlayerList().broadcastSystemMessage(
            Component.literal("§e" + playerName + " §eoyuna katıldı"), false
        );

        // Sahte oyuncu isimleri
        String[] fakeNames = {"Escape", "İs", "No", "There",};
        for (String name : fakeNames) {
            GameProfile fakeProfile = new GameProfile(UUID.randomUUID(), name);
            ServerPlayer fakePlayer = new ServerPlayer(server, level, fakeProfile);
            fakePlayer.setGameMode(GameType.SURVIVAL);

            ClientboundPlayerInfoUpdatePacket packet = new ClientboundPlayerInfoUpdatePacket(
                Action.ADD_PLAYER, fakePlayer
            );
            ((ServerPlayer) event.getEntity()).connection.send(packet);
        }
    }
}
