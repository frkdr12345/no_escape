package net.mcreator.noescape.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.noescape.NoEscapeMod;

public class LightOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		NoEscapeMod.queueServerWork(25, () -> {
			NoEscapeMod.queueServerWork(26, () -> {
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
					_level.addFreshEntity(entityToSpawn);
				}
				NoEscapeMod.queueServerWork(27, () -> {
					if (world instanceof ServerLevel _level) {
						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
						entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
						_level.addFreshEntity(entityToSpawn);
					}
					NoEscapeMod.queueServerWork(28, () -> {
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
							_level.addFreshEntity(entityToSpawn);
						}
						NoEscapeMod.queueServerWork(29, () -> {
							if (world instanceof ServerLevel _level) {
								LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
								entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
								_level.addFreshEntity(entityToSpawn);
							}
							NoEscapeMod.queueServerWork(30, () -> {
								if (world instanceof ServerLevel _level) {
									LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
									entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
									_level.addFreshEntity(entityToSpawn);
								}
								NoEscapeMod.queueServerWork(31, () -> {
									if (world instanceof ServerLevel _level) {
										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
										entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
										_level.addFreshEntity(entityToSpawn);
									}
									NoEscapeMod.queueServerWork(32, () -> {
										if (world instanceof ServerLevel _level) {
											LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
											entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
											_level.addFreshEntity(entityToSpawn);
										}
										NoEscapeMod.queueServerWork(33, () -> {
											if (world instanceof ServerLevel _level) {
												LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
												entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
												_level.addFreshEntity(entityToSpawn);
											}
											NoEscapeMod.queueServerWork(34, () -> {
												if (world instanceof ServerLevel _level) {
													LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
													entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
													_level.addFreshEntity(entityToSpawn);
												}
												NoEscapeMod.queueServerWork(35, () -> {
													if (world instanceof ServerLevel _level) {
														LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
														entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
														_level.addFreshEntity(entityToSpawn);
													}
													NoEscapeMod.queueServerWork(36, () -> {
														if (world instanceof ServerLevel _level) {
															LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
															entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
															_level.addFreshEntity(entityToSpawn);
														}
														NoEscapeMod.queueServerWork(37, () -> {
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
																_level.addFreshEntity(entityToSpawn);
															}
															NoEscapeMod.queueServerWork(38, () -> {
																if (world instanceof ServerLevel _level) {
																	LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																	entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
																	_level.addFreshEntity(entityToSpawn);
																}
															});
														});
													});
												});
											});
										});
									});
								});
							});
						});
					});
				});
			});
		});
		NoEscapeMod.queueServerWork(39, () -> {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		});
	}
}
