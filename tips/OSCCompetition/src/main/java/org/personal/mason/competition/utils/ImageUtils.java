package org.personal.mason.competition.utils;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtils {
public static int THUMBNAIL_WIDTH = 200;
public static int THUMBNAIL_HEIGHT = 150;

public static BufferedImage getThumbnailImage(byte[] data) throws IOException {
	BufferedImage image = readImage(data);
	double height = image.getHeight();
	double width = image.getWidth();

	double times;
	
	if(width * 2 > height * 3){
		times = width / THUMBNAIL_WIDTH;
	}else{
		times = height / THUMBNAIL_HEIGHT;
	}
	
	Double targetWidth = width / times;
	Double targetHeight = height / times;
	BufferedImage thumbnail = new BufferedImage(targetWidth.intValue(), targetHeight.intValue(), BufferedImage.TYPE_INT_RGB);
	Graphics g = thumbnail.getGraphics();
	g.drawImage(image, 0, 0, targetWidth.intValue(), targetHeight.intValue(), null);
	g.dispose();
	return thumbnail;
}

public static BufferedImage readImage(byte[] data) throws IOException {
	return ImageIO.read(new ByteArrayInputStream(data));
}
}
