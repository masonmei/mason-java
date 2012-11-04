package org.personal.mason.utils;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ImageUtils {
private static final Random RANDOM = new Random();

public static BufferedImage generateImage(String chars, int width, int height) {
	BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	Graphics graphics = image.getGraphics();
	graphics.setColor(ColorUtils.generateRandonColor(190, 250));
	graphics.fillRect(0, 0, width, height);
	graphics.setColor(ColorUtils.generateRandonColor(80, 180));
	String[] fontNames = new String[] { "Impact", "Comic Sans", "Arial", "Georgia" };
	int[] fontTypes = new int[] { Font.ITALIC, Font.BOLD, Font.PLAIN };
	for (int i = 0; i < chars.length(); i++) {
		graphics.setFont(new Font(fontNames[RANDOM.nextInt(fontNames.length)], fontTypes[RANDOM
				.nextInt(fontTypes.length)], height));
		graphics.setColor(ColorUtils.generateRandonColor(10, 100));
		graphics.drawString(String.valueOf(chars.charAt(i)), 25 * i + 10, height - RANDOM.nextInt(height / 2));
	}
	graphics.dispose();
	return image;
}
}
