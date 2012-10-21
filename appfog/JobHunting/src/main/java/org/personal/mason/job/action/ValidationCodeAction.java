package org.personal.mason.job.action;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;

import org.personal.mason.job.utils.ImageUtils;
import org.personal.mason.job.utils.StringUtils;

public class ValidationCodeAction extends AbstractAction {

private static final int WIDTH = 4;
private static final long serialVersionUID = 798942649664031159L;
private static final int HEIGHT = 20;

@Override
public String process() {
	response.setHeader("ragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);

	String validationcode = StringUtils.getRandomString(WIDTH);
	BufferedImage generateImage = ImageUtils.generateImage(validationcode, WIDTH * 25 + 20, HEIGHT);

	session.setMaxInactiveInterval(600);
	session.setAttribute("validationcode", validationcode);
	try {
		ServletOutputStream outputStream = response.getOutputStream();
		ImageIO.write(generateImage, "JPEG", outputStream);
		outputStream.flush();
		outputStream.close();
		outputStream = null;
		
		response.flushBuffer();
		
	} catch (IOException e) {
		log.debug("could not write image", e);
	}
	return null;
}

}
