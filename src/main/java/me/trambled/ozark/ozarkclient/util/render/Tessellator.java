package me.trambled.ozark.ozarkclient.util.render;

import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL32;

import java.awt.Color;

import static me.trambled.ozark.ozarkclient.util.misc.WrapperUtil.mc;
import static net.minecraft.client.renderer.GlStateManager.*;
import static org.lwjgl.opengl.GL11.*;

public class Tessellator {
    private final static net.minecraft.client.renderer.Tessellator tessellator = net.minecraft.client.renderer.Tessellator.getInstance();
    private final static BufferBuilder builder = tessellator.getBuffer();

    /**
     * skidded from momentum lololol
     *
     * @param width
     * @param height
     * @param color
     */
    public static void drawBBClaw(AxisAlignedBB bb, float width, float height, Color color) {
        pushMatrix();
        start1();
        width(width);

        double minX = bb.minX;
        double minY = bb.minY;
        double minZ = bb.minZ;
        double maxX = bb.maxX;
        double maxY = bb.maxY;
        double maxZ = bb.maxZ;

        builder.begin(GL_LINE_STRIP, DefaultVertexFormats.POSITION_COLOR);
        vertex(minX, minY, minZ).color(color.getRed(), color.getGreen(), color.getBlue(), 0.0F).endVertex();
        vertex(minX, minY, minZ + height).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        vertex(minX, minY, maxZ).color(color.getRed(), color.getGreen(), color.getBlue(), 0.0F).endVertex();
        vertex(minX, minY, maxZ - height).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        vertex(maxX, minY, minZ).color(color.getRed(), color.getGreen(), color.getBlue(), 0.0F).endVertex();
        vertex(maxX, minY, minZ + height).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        vertex(maxX, minY, maxZ).color(color.getRed(), color.getGreen(), color.getBlue(), 0.0F).endVertex();
        vertex(maxX, minY, maxZ - height).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        vertex(minX, minY, minZ).color(color.getRed(), color.getGreen(), color.getBlue(), 0.0F).endVertex();
        vertex(minX + height, minY, minZ).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        vertex(minX, minY, maxZ).color(color.getRed(), color.getGreen(), color.getBlue(), 0.0F).endVertex();
        vertex(minX + height, minY, maxZ).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        vertex(maxX, minY, minZ).color(color.getRed(), color.getGreen(), color.getBlue(), 0.0F).endVertex();
        vertex(maxX - height, minY, minZ).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        vertex(maxX, minY, maxZ).color(color.getRed(), color.getGreen(), color.getBlue(), 0.0F).endVertex();
        vertex(maxX - height, minY, maxZ).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        vertex(minX, minY, minZ).color(color.getRed(), color.getGreen(), color.getBlue(), 0.0F).endVertex();
        vertex(minX, minY + height, minZ).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        vertex(minX, minY, maxZ).color(color.getRed(), color.getGreen(), color.getBlue(), 0.0F).endVertex();
        vertex(minX, minY + height, maxZ).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        vertex(maxX, minY, minZ).color(color.getRed(), color.getGreen(), color.getBlue(), 0.0F).endVertex();
        vertex(maxX, minY + height, minZ).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        vertex(maxX, minY, maxZ).color(color.getRed(), color.getGreen(), color.getBlue(), 0.0F).endVertex();
        vertex(maxX, minY + height, maxZ).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        vertex(minX, maxY, minZ).color(color.getRed(), color.getGreen(), color.getBlue(), 0.0F).endVertex();
        vertex(minX, maxY, minZ + height).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        vertex(minX, maxY, maxZ).color(color.getRed(), color.getGreen(), color.getBlue(), 0.0F).endVertex();
        vertex(minX, maxY, maxZ - height).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        vertex(maxX, maxY, minZ).color(color.getRed(), color.getGreen(), color.getBlue(), 0.0F).endVertex();
        vertex(maxX, maxY, minZ + height).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        vertex(maxX, maxY, maxZ).color(color.getRed(), color.getGreen(), color.getBlue(), 0.0F).endVertex();
        vertex(maxX, maxY, maxZ - height).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        vertex(minX, maxY, minZ).color(color.getRed(), color.getGreen(), color.getBlue(), 0.0F).endVertex();
        vertex(minX + height, maxY, minZ).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        vertex(minX, maxY, maxZ).color(color.getRed(), color.getGreen(), color.getBlue(), 0.0F).endVertex();
        vertex(minX + height, maxY, maxZ).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        vertex(maxX, maxY, minZ).color(color.getRed(), color.getGreen(), color.getBlue(), 0.0F).endVertex();
        vertex(maxX - height, maxY, minZ).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        vertex(maxX, maxY, maxZ).color(color.getRed(), color.getGreen(), color.getBlue(), 0.0F).endVertex();
        vertex(maxX - height, maxY, maxZ).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        vertex(minX, maxY, minZ).color(color.getRed(), color.getGreen(), color.getBlue(), 0.0F).endVertex();
        vertex(minX, maxY - height, minZ).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        vertex(minX, maxY, maxZ).color(color.getRed(), color.getGreen(), color.getBlue(), 0.0F).endVertex();
        vertex(minX, maxY - height, maxZ).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        vertex(maxX, maxY, minZ).color(color.getRed(), color.getGreen(), color.getBlue(), 0.0F).endVertex();
        vertex(maxX, maxY - height, minZ).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        vertex(maxX, maxY, maxZ).color(color.getRed(), color.getGreen(), color.getBlue(), 0.0F).endVertex();
        vertex(maxX, maxY - height, maxZ).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        tessellator.draw();

        end1();
        popMatrix();
    }

    public static void drawBBFill(AxisAlignedBB bb, Color color) {
        pushMatrix();
        start1();
        width(1);

        final int r = color.getRed();
        final int b = color.getBlue();
        final int g = color.getGreen();
        final int a = color.getAlpha();

        builder.begin(GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_COLOR);
        double minX = bb.minX;
        double minY = bb.minY;
        double minZ = bb.minZ;
        double maxX = bb.maxX;
        double maxY = bb.maxY;
        double maxZ = bb.maxZ;
        vertex(minX, minY, minZ).color(r, g, b, a).endVertex();
        vertex(minX, minY, minZ).color(r, g, b, a).endVertex();
        vertex(minX, minY, minZ).color(r, g, b, a).endVertex();
        vertex(minX, minY, maxZ).color(r, g, b, a).endVertex();
        vertex(minX, maxY, minZ).color(r, g, b, a).endVertex();
        vertex(minX, maxY, maxZ).color(r, g, b, a).endVertex();
        vertex(minX, maxY, maxZ).color(r, g, b, a).endVertex();
        vertex(minX, minY, maxZ).color(r, g, b, a).endVertex();
        vertex(maxX, maxY, maxZ).color(r, g, b, a).endVertex();
        vertex(maxX, minY, maxZ).color(r, g, b, a).endVertex();
        vertex(maxX, minY, maxZ).color(r, g, b, a).endVertex();
        vertex(maxX, minY, minZ).color(r, g, b, a).endVertex();
        vertex(maxX, maxY, maxZ).color(r, g, b, a).endVertex();
        vertex(maxX, maxY, minZ).color(r, g, b, a).endVertex();
        vertex(maxX, maxY, minZ).color(r, g, b, a).endVertex();
        vertex(maxX, minY, minZ).color(r, g, b, a).endVertex();
        vertex(minX, maxY, minZ).color(r, g, b, a).endVertex();
        vertex(minX, minY, minZ).color(r, g, b, a).endVertex();
        vertex(minX, minY, minZ).color(r, g, b, a).endVertex();
        vertex(maxX, minY, minZ).color(r, g, b, a).endVertex();
        vertex(minX, minY, maxZ).color(r, g, b, a).endVertex();
        vertex(maxX, minY, maxZ).color(r, g, b, a).endVertex();
        vertex(maxX, minY, maxZ).color(r, g, b, a).endVertex();
        vertex(minX, maxY, minZ).color(r, g, b, a).endVertex();
        vertex(minX, maxY, minZ).color(r, g, b, a).endVertex();
        vertex(minX, maxY, maxZ).color(r, g, b, a).endVertex();
        vertex(maxX, maxY, minZ).color(r, g, b, a).endVertex();
        vertex(maxX, maxY, maxZ).color(r, g, b, a).endVertex();
        vertex(maxX, maxY, maxZ).color(r, g, b, a).endVertex();
        vertex(maxX, maxY, maxZ).color(r, g, b, a).endVertex();
        tessellator.draw();

        end1();
        popMatrix();
    }

    public static void drawBBSlab(AxisAlignedBB bb, float height, Color color) {
        final int r = color.getRed();
        final int g = color.getGreen();
        final int b = color.getBlue();
        final int a = color.getAlpha();
        double minX = bb.minX;
        double minY = bb.minY;
        double minZ = bb.minZ;
        double maxX = bb.maxX;
        double maxY = bb.maxY + height;
        double maxZ = bb.maxZ;
        pushMatrix();

        disableTexture2D();
        enableBlend();
        disableAlpha();
        glDisable(GL_DEPTH_TEST);
        tryBlendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
        disableCull();
        shadeModel(GL_SMOOTH);

        builder.begin(GL_QUADS, DefaultVertexFormats.POSITION_COLOR);
        vertex(minX, minY, minZ).color(r, g, b, a).endVertex();
        vertex(maxX, minY, minZ).color(r, g, b, a).endVertex();
        vertex(maxX, minY, maxZ).color(r, g, b, a).endVertex();
        vertex(minX, minY, maxZ).color(r, g, b, a).endVertex();
        vertex(minX, maxY, minZ).color(0, 0, 0, 0).endVertex();
        vertex(minX, maxY, maxZ).color(0, 0, 0, 0).endVertex();
        vertex(maxX, maxY, maxZ).color(0, 0, 0, 0).endVertex();
        vertex(maxX, maxY, minZ).color(0, 0, 0, 0).endVertex();
        vertex(minX, minY, minZ).color(r, g, b, a).endVertex();
        vertex(minX, maxY, minZ).color(0, 0, 0, 0).endVertex();
        vertex(maxX, maxY, minZ).color(0, 0, 0, 0).endVertex();
        vertex(maxX, minY, minZ).color(r, g, b, a).endVertex();
        vertex(maxX, minY, minZ).color(r, g, b, a).endVertex();
        vertex(maxX, maxY, minZ).color(0, 0, 0, 0).endVertex();
        vertex(maxX, maxY, maxZ).color(0, 0, 0, 0).endVertex();
        vertex(maxX, minY, maxZ).color(r, g, b, a).endVertex();
        vertex(minX, minY, maxZ).color(r, g, b, a).endVertex();
        vertex(maxX, minY, maxZ).color(r, g, b, a).endVertex();
        vertex(maxX, maxY, maxZ).color(0, 0, 0, 0).endVertex();
        vertex(minX, maxY, maxZ).color(0, 0, 0, 0).endVertex();
        vertex(minX, minY, minZ).color(r, g, b, a).endVertex();
        vertex(minX, minY, maxZ).color(r, g, b, a).endVertex();
        vertex(minX, maxY, maxZ).color(0, 0, 0, 0).endVertex();
        vertex(minX, maxY, minZ).color(0, 0, 0, 0).endVertex();
        tessellator.draw();

        glEnable(GL_DEPTH_TEST);
        shadeModel(GL_FLAT);
        disableBlend();
        enableCull();
        enableAlpha();
        enableTexture2D();
        popMatrix();
    }

    public static void drawBBOutline(AxisAlignedBB bb, float width, Color color) {
        start(width);

        final int r = color.getRed();
        final int b = color.getBlue();
        final int g = color.getGreen();
        final int a = color.getAlpha();

        builder.begin(GL_LINE_STRIP, DefaultVertexFormats.POSITION_COLOR);
        vertex(bb.minX, bb.minY, bb.minZ, r, g, b, a);
        vertex(bb.minX, bb.minY, bb.maxZ, r, g, b, a);
        vertex(bb.maxX, bb.minY, bb.maxZ, r, g, b, a);
        vertex(bb.maxX, bb.minY, bb.minZ, r, g, b, a);
        vertex(bb.minX, bb.minY, bb.minZ, r, g, b, a);
        vertex(bb.minX, bb.maxY, bb.minZ, r, g, b, a);
        vertex(bb.minX, bb.maxY, bb.maxZ, r, g, b, a);
        vertex(bb.minX, bb.minY, bb.maxZ, r, g, b, a);
        vertex(bb.maxX, bb.minY, bb.maxZ, r, g, b, a);
        vertex(bb.maxX, bb.maxY, bb.maxZ, r, g, b, a);
        vertex(bb.minX, bb.maxY, bb.maxZ, r, g, b, a);
        vertex(bb.maxX, bb.maxY, bb.maxZ, r, g, b, a);
        vertex(bb.maxX, bb.maxY, bb.minZ, r, g, b, a);
        vertex(bb.maxX, bb.minY, bb.minZ, r, g, b, a);
        vertex(bb.maxX, bb.maxY, bb.minZ, r, g, b, a);
        vertex(bb.minX, bb.maxY, bb.minZ, r, g, b, a);
        tessellator.draw();

        end();
    }

    public static void drawGradientAlphaCubeOutline(AxisAlignedBB bb, float width, Color start) {
        disableTexture2D();
        enableBlend();
        disableAlpha();
        disableDepth();
        tryBlendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
        shadeModel(GL_SMOOTH);
        width(width);

        final int r = start.getRed();
        final int b = start.getBlue();
        final int g = start.getGreen();
        final int a = start.getAlpha();

        builder.begin(GL_LINE_STRIP, DefaultVertexFormats.POSITION_COLOR);
        vertex(bb.minX, bb.minY, bb.minZ, r, g, b, a);
        vertex(bb.minX, bb.minY, bb.maxZ, r, g, b, a);
        vertex(bb.maxX, bb.minY, bb.maxZ, r, g, b, a);
        vertex(bb.maxX, bb.minY, bb.minZ, r, g, b, a);
        vertex(bb.minX, bb.minY, bb.minZ, r, g, b, a);
        vertex(bb.minX, bb.maxY, bb.minZ, r, g, b, 0);
        vertex(bb.minX, bb.maxY, bb.maxZ, r, g, b, 0);
        vertex(bb.minX, bb.minY, bb.maxZ, r, g, b, a);
        vertex(bb.maxX, bb.minY, bb.maxZ, r, g, b, a);
        vertex(bb.maxX, bb.maxY, bb.maxZ, r, g, b, 0);
        vertex(bb.minX, bb.maxY, bb.maxZ, r, g, b, 0);
        vertex(bb.maxX, bb.maxY, bb.maxZ, r, g, b, 0);
        vertex(bb.maxX, bb.maxY, bb.minZ, r, g, b, 0);
        vertex(bb.maxX, bb.minY, bb.minZ, r, g, b, a);
        vertex(bb.maxX, bb.maxY, bb.minZ, r, g, b, 0);
        vertex(bb.minX, bb.maxY, bb.minZ, r, g, b, 0);
        tessellator.draw();

        enableDepth();
        shadeModel(GL_FLAT);
        disableBlend();
        enableAlpha();
        enableTexture2D();
    }


    public static void drawLine(double posX, double posY, double posZ, double posX1, double posY1, double posZ1, Color color, float width) {
        start2();

        width(width);
        disableDepth();
        builder.begin(GL_LINES, DefaultVertexFormats.POSITION_COLOR);
        builder.pos(posX1, posY1, posZ1).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        builder.pos(posX, posY, posZ).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        tessellator.draw();
        end2();
    }





    public static void start(float width) {
        GlStateManager.pushMatrix();
        glDisable(GL_TEXTURE_2D);
        glDisable(GL_DEPTH_TEST);
        glDisable(GL_CULL_FACE);
        glDepthMask(false);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        width(width);
    }

    public static void start1() {
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA, GL_ZERO, GL_ONE);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask(false);
        glEnable(GL_LINE_SMOOTH);
        glHint(GL_LINE_SMOOTH_HINT, GL_NICEST);
    }

    public static void start2() {
        GlStateManager.pushMatrix();
        width(1f);
        glEnable(GL_LINE_SMOOTH);
        glEnable(GL32.GL_DEPTH_CLAMP);
        glHint(GL_LINE_SMOOTH_HINT, GL_NICEST);
        GlStateManager.disableAlpha();
        GlStateManager.shadeModel(GL_SMOOTH);
        GlStateManager.disableCull();
        GlStateManager.enableBlend();
        GlStateManager.depthMask(false);
        GlStateManager.disableTexture2D();
        GlStateManager.disableLighting();
    }

    public static void end2() {
        GlStateManager.enableTexture2D();
        GlStateManager.enableDepth();
        GlStateManager.disableBlend();
        GlStateManager.enableCull();
        GlStateManager.shadeModel(GL_FLAT);
        GlStateManager.enableAlpha();
        GlStateManager.depthMask(true);
        glDisable(GL32.GL_DEPTH_CLAMP);
        glDisable(GL_LINE_SMOOTH);
        GlStateManager.color(1f, 1f, 1f);
        width(1f);
        GlStateManager.popMatrix();
    }

    public static void end1() {
        glDisable(GL_LINE_SMOOTH);
        GlStateManager.depthMask(true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void end() {
        glDepthMask(true);
        glDisable(GL_BLEND);
        glEnable(GL_TEXTURE_2D);
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_CULL_FACE);
        GlStateManager.popMatrix();
    }

    private static void width(float width) {
        GlStateManager.glLineWidth(width);
    }

    private static void vertex(double x, double y, double z, int r, int g, int b, int a) {
        builder.pos(x - mc.getRenderManager().viewerPosX, y - mc.getRenderManager().viewerPosY, z - mc.getRenderManager().viewerPosZ).color(r, g, b, a).endVertex();
    }

    private static void vertex(int r, int g, int b, int a) {
        builder.pos(0, mc.player.getEyeHeight(), 0).color(r, g, b, a).endVertex();
    }

    private static BufferBuilder vertex(double x, double y, double z) {
        return builder.pos(x - mc.getRenderManager().viewerPosX, y - mc.getRenderManager().viewerPosY, z - mc.getRenderManager().viewerPosZ);
    }

    public static void color(Color color) {
        GL11.glColor4d(color.getRed() / 255d, color.getGreen() / 255d, color.getBlue() / 255d, color.getAlpha() / 255d);
    }
}
