package net.mcreator.noescape.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

import net.mcreator.noescape.NoEscapeMod;

public class HelpOnKeyPressedProcedure {
	public static void execute(LevelAccessor world) {
		NoEscapeMod.queueServerWork(20, () -> {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("NO ESCAPE"), false);
		});
		NoEscapeMod.queueServerWork(30, () -> {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("NO ESCAPE"), false);
		});
		NoEscapeMod.queueServerWork(40, () -> {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("NO ESCAPE "), false);
		});
		NoEscapeMod.queueServerWork(50, () -> {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("NO ESCAPE"), false);
		});
		NoEscapeMod.queueServerWork(60, () -> {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("NO ESCAPE"), false);
		});
		NoEscapeMod.queueServerWork(70, () -> {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("NO ESCAPE"), false);
		});
		NoEscapeMod.queueServerWork(80, () -> {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("NO ESCAPE"), false);
		});
	}
}
