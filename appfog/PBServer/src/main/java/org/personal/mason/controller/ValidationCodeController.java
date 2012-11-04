package org.personal.mason.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.personal.mason.utils.ImageUtils;
import org.personal.mason.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = { "/validationCode" })
public class ValidationCodeController{

private static final Log log = LogFactory.getLog(ValidationCodeController.class);

private static final int WIDTH = 4;
private static final int HEIGHT = 20;

@RequestMapping(method = RequestMethod.GET)
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setHeader("ragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);

	response.setContentType("image/jpeg");

	String validationcode = StringUtils.getRandomString(WIDTH);
	BufferedImage generateImage = ImageUtils.generateImage(validationcode, WIDTH * 25 + 20, HEIGHT);

	HttpSession session = request.getSession(true);
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
}

}
