package net.mcreator.noescape.procedures;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import org.lwjgl.glfw.GLFW;

import javax.swing.*;

@Mod.EventBusSubscriber(modid = "no_escape", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ShakeProcedure {

    private static boolean aktif = false;
    private static long bitisZamani = 0;
    private static final int MAX_SURE = 8000;
    private static final int MIN_SIDDET = 200;
    private static final int ATLAMA_ARALIGI = 150;
    private static float totalShakeOffset = 100;
    private static final int KUCUK_PENCERE_GENISLIK = 1000;
    private static final int KUCUK_PENCERE_YUKSEKLIK = 600;
    private static boolean mesajlarGosterildi = false;
    
    private static float kararmaAlpha = 0f;  // Alpha değeri (başlangıçta 0)

    @SubscribeEvent
    public static void onKeyPress(InputEvent.Key event) {
        if (event.getKey() == GLFW.GLFW_KEY_J && event.getAction() == GLFW.GLFW_PRESS) {
            aktif = !aktif;
            bitisZamani = System.currentTimeMillis() + MAX_SURE;
            mesajlarGosterildi = false;

            
            if (aktif) {
                kararmaAlpha = 0f;  
            }

            Minecraft mc = Minecraft.getInstance();
            mc.execute(() -> {
                
                if (mc.options.fullscreen().get()) {
                    mc.options.fullscreen().set(false);
                    mc.options.save();
                }

                
                mc.getWindow().setWindowed(KUCUK_PENCERE_GENISLIK, KUCUK_PENCERE_YUKSEKLIK);

                
                int ekranGenislik = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor()).width();
                int ekranYukseklik = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor()).height();
                int x = (ekranGenislik - KUCUK_PENCERE_GENISLIK) / 2;
                int y = (ekranYukseklik - KUCUK_PENCERE_YUKSEKLIK) / 2;
                GLFW.glfwSetWindowPos(mc.getWindow().getWindow(), x, y);
            });

             
            new Thread(() -> {
                try {
                    for (int i = 0; i < 3; i++) {
                        JOptionPane.showMessageDialog(null, "You can't escape...", "System Error", JOptionPane.ERROR_MESSAGE);
                        Thread.sleep(700);
                    }
                    mesajlarGosterildi = true;
                } catch (Exception ignored) {}
            }).start();
        }
    }

    @SubscribeEvent
    public static void onCameraSetup(ViewportEvent.ComputeCameraAngles event) {
        if (!aktif || System.currentTimeMillis() > bitisZamani) {
            aktif = false;
            return;
        }

        Minecraft mc = Minecraft.getInstance();
        try {
            float zamanKalan = bitisZamani - System.currentTimeMillis();
            float siddet = Mth.clamp(zamanKalan / MAX_SURE * 50f, MIN_SIDDET, 50f);

            RandomSource random = mc.level != null ? mc.level.random : RandomSource.create();

            
            totalShakeOffset += siddet * 0.15f;
            float shakeX = Mth.sin(totalShakeOffset * 2.5f) * siddet * 3f;
            float shakeY = Mth.cos(totalShakeOffset * 1.8f) * siddet * 2f;

            event.setYaw(event.getYaw() + shakeX);
            event.setPitch(Mth.clamp(event.getPitch() + shakeY, -90, 90));
            event.setRoll(event.getRoll() + Mth.randomBetween(random, -siddet * 0.3f, siddet * 0.3f));

            
            if (mc.getWindow() != null && zamanKalan % ATLAMA_ARALIGI < 50) {
                long windowHandle = mc.getWindow().getWindow();
                int genislik = mc.getWindow().getWidth();
                int yukseklik = mc.getWindow().getHeight();
                int ekranGenislik = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor()).width();
                int ekranYukseklik = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor()).height();

                int yeniX = Mth.clamp(
                    (int) (mc.getWindow().getX() + (random.nextFloat() - 0.5f) * 150),
                    0, ekranGenislik - genislik
                );
                int yeniY = Mth.clamp(
                    (int) (mc.getWindow().getY() + (random.nextFloat() - 0.5f) * 100),
                    0, ekranYukseklik - yukseklik
                );

                GLFW.glfwSetWindowPos(windowHandle, yeniX, yeniY);
            }

        } catch (Exception e) {
            System.err.println("Sarsıntı efekti hatası: " + e.getMessage());
            aktif = false;
        }
    }

    @SubscribeEvent
    public static void onRenderOverlay(RenderGuiOverlayEvent.Post event) {
        if (!aktif) return;

        Minecraft mc = Minecraft.getInstance();
        PoseStack poseStack = event.getGuiGraphics().pose();
        int width = mc.getWindow().getGuiScaledWidth();
        int height = mc.getWindow().getGuiScaledHeight();

        
        if (kararmaAlpha < 0.75f) {
            kararmaAlpha = Mth.clamp(kararmaAlpha + 0.01f, 0f, 1f);  
        }

        RenderSystem.disableDepthTest();  
        RenderSystem.enableBlend();       
        RenderSystem.defaultBlendFunc();  

        
        Tesselator t = Tesselator.getInstance();
        BufferBuilder buffer = t.getBuilder();
        buffer.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);  
        buffer.vertex(0, height, 0).color(0, 0, 0, kararmaAlpha).endVertex();  
        buffer.vertex(width, height, 0).color(0, 0, 0, kararmaAlpha).endVertex();
        buffer.vertex(width, 0, 0).color(0, 0, 0, kararmaAlpha).endVertex();
        buffer.vertex(0, 0, 0).color(0, 0, 0, kararmaAlpha).endVertex();
        t.end();

        RenderSystem.enableDepthTest();  
    }
}
