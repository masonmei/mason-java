package org.personal.mason.utils;

import java.awt.Color;
import java.util.Random;

public class ColorUtils {
private static final Random RANDOM = new Random();

public static Color generateRandonColor(int minColor, int maxColor) {
	int red = minColor + RANDOM.nextInt(maxColor - minColor);
	int green = minColor + RANDOM.nextInt(maxColor - minColor);
	int blue = minColor + RANDOM.nextInt(maxColor - minColor);
	return new Color(red, green, blue);
}
}
