package me.trambled.ozark.ozarkclient.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

import java.awt.*;

// Travis


public class RainbowUtil {
	private static FontRenderer font_renderer = Minecraft.getMinecraft().fontRenderer;
	private static Minecraft mc = Minecraft.getMinecraft();
	private static boolean flag;


	public static void drawRainbowStringChat(String text, float x, float y, int startColor, float factor) {
		Color currentColor = new Color(startColor);
		float hueIncrement = 1.0f / factor;
		float currentHue = Color.RGBtoHSB(currentColor.getRed(), currentColor.getGreen(), currentColor.getBlue(), null)[0];
		float saturation = Color.RGBtoHSB(currentColor.getRed(), currentColor.getGreen(), currentColor.getBlue(), null)[1];
		float brightness = Color.RGBtoHSB(currentColor.getRed(), currentColor.getGreen(), currentColor.getBlue(), null)[2];
		int currentWidth = 0;
		boolean shouldRainbow = true;
		boolean shouldContinue = false;
		for (int i = 0; i < text.length(); ++i) {
			char currentChar = text.charAt(i);
			char nextChar = text.charAt(MathUtil.clamp(i + 1, 0, text.length() - 1));
			if ((String.valueOf(currentChar) + nextChar).equals("\u00a7r")) {
				shouldRainbow = false;
			} else if ((String.valueOf(currentChar) + nextChar).equals("\u00a74")) {
				shouldRainbow = true;
			}
			if (shouldContinue) {
				shouldContinue = false;
				continue;
			}
			if ((String.valueOf(currentChar) + nextChar).equals("\u00a7r")) {
				String escapeString = text.substring(i);
				drawString(escapeString, x + (float) currentWidth, y, Color.WHITE.getRGB());
				break;
			}
			drawString(String.valueOf(currentChar).equals("\u00a7") ? "" : String.valueOf(currentChar), x + (float) currentWidth, y, shouldRainbow ? currentColor.getRGB() : Color.WHITE.getRGB());
			if (String.valueOf(currentChar).equals("\u00a7")) {
				shouldContinue = true;
			}
			currentWidth += get_string_width(String.valueOf(currentChar));
			if (String.valueOf(currentChar).equals(" ")) continue;
			currentColor = new Color(Color.HSBtoRGB(currentHue, saturation, brightness));
			currentHue += hueIncrement;
		}
	}

	public static void drawRainbowStringChatCustomFont(String text, float x, float y, int startColor, float factor) {
		Color currentColor = new Color(startColor);
		float hueIncrement = 1.0f / factor;
		float currentHue = Color.RGBtoHSB(currentColor.getRed(), currentColor.getGreen(), currentColor.getBlue(), null)[0];
		float saturation = Color.RGBtoHSB(currentColor.getRed(), currentColor.getGreen(), currentColor.getBlue(), null)[1];
		float brightness = Color.RGBtoHSB(currentColor.getRed(), currentColor.getGreen(), currentColor.getBlue(), null)[2];
		int currentWidth = 0;
		boolean shouldRainbow = true;
		boolean shouldContinue = false;
		for (int i = 0; i < text.length(); ++i) {
			char currentChar = text.charAt(i);
			char nextChar = text.charAt(MathUtil.clamp(i + 1, 0, text.length() - 1));
			if ((String.valueOf(currentChar) + nextChar).equals("\u00a7r")) {
				shouldRainbow = false;
			} else if ((String.valueOf(currentChar) + nextChar).equals("\u00a74")) {
				shouldRainbow = true;
			}
			if (shouldContinue) {
				shouldContinue = false;
				continue;
			}
			if ((String.valueOf(currentChar) + nextChar).equals("\u00a7r")) {
				String escapeString = text.substring(i);
				drawString(escapeString, x + (float) currentWidth, y, Color.WHITE.getRGB());
				break;
			}
			FontUtil.drawStringWithShadow(String.valueOf(currentChar).equals("\u00a7") ? "" : String.valueOf(currentChar), x + (float) currentWidth, y, shouldRainbow ? currentColor.getRGB() : Color.WHITE.getRGB());
			if (String.valueOf(currentChar).equals("\u00a7")) {
				shouldContinue = true;
			}
			currentWidth += FontUtil.getFontWidth(String.valueOf(currentChar));
			if (String.valueOf(currentChar).equals(" ")) continue;
			currentColor = new Color(Color.HSBtoRGB(currentHue, saturation, brightness));
			currentHue += hueIncrement;
		}
	}

	public static void drawRainbowString(String text, int x, int y, int color, float factor) {
		Color currentColor = new Color(color);
		float hueIncrement = 1.0f / factor;
		float currentHue = Color.RGBtoHSB(currentColor.getRed(), currentColor.getGreen(), currentColor.getBlue(), null)[0];
		float saturation = Color.RGBtoHSB(currentColor.getRed(), currentColor.getGreen(), currentColor.getBlue(), null)[1];
		float brightness = Color.RGBtoHSB(currentColor.getRed(), currentColor.getGreen(), currentColor.getBlue(), null)[2];
		int currentWidth = 0;
		for (int i = 0; i < text.length(); ++i) {
			char currentChar = text.charAt(i);
			if (String.valueOf(currentChar).equals("\u00a7")) {
				flag = true;
				continue;
			}
			if (flag) {
				flag = false;
				continue;
			}
			GuiUtil.draw_string(String.valueOf(currentChar), x + currentWidth, y, currentColor.getRGB());
			currentWidth += get_string_width(String.valueOf(currentChar));
			currentColor = new Color(Color.HSBtoRGB(currentHue, saturation, brightness));
			currentHue += hueIncrement;
		}
	}

	public static int get_string_width(String string) {
		FontRenderer fontRenderer = font_renderer;

		return (fontRenderer.getStringWidth(string));
	}


	public static int get_string_height() {
		FontRenderer fontRenderer = font_renderer;

		return (fontRenderer.FONT_HEIGHT);
	}

	public static float drawString(String text, float x, float y, int color) {
		return mc.fontRenderer.drawString(text, x, y, color, true);
	}

	public static Color getMultiColour() {
		return Color.getHSBColor((float) (System.currentTimeMillis() % 7500L) / 7500f, 0.8f, 0.8f);
	}

	public static int toRGBA(int r, int g, int b, int a) {
		return (r << 16) + (g << 8) + b + (a << 24);
	}

}