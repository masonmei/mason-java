package org.personal.mason.competition.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.QueryParam;

import net.sourceforge.fastupload.FastUploadParser;
import net.sourceforge.fastupload.MultiPart;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.personal.mason.competition.domain.Category;
import org.personal.mason.competition.domain.Image;
import org.personal.mason.competition.service.CategoryService;
import org.personal.mason.competition.service.ImageService;
import org.personal.mason.competition.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("image")
public class ImageController {

private final Log log = LogFactory.getLog(getClass());
@Autowired
private ImageService imageService;

@Autowired
private CategoryService categoryService;

@RequestMapping(value = "/list", method = RequestMethod.GET)
public String listImages(Model model) {
	List<Image> images = imageService.findAll();
	model.addAttribute("images", images);
	return "index";
}

@RequestMapping(value = "/public", method = RequestMethod.GET)
public String listPublicImages(Model model) {
	List<Image> images = imageService.findAll();
	model.addAttribute("images", images);
	return "index";
}

@RequestMapping(value = "/original", method = RequestMethod.GET)
public String getImage(@QueryParam("id") String id, HttpServletResponse response) {
	Image image = imageService.findImageById(id);
	if (image != null) {
		response.setContentType(image.getContentType());
		try {
			BufferedImage generateImage = ImageUtils.readImage(image.getImageData());
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
	return "index";
}

@RequestMapping(value = "/thumbnail", method = RequestMethod.GET)
public String getThumbnail(@QueryParam("id") String id, HttpServletResponse response) {
	Image image = imageService.findImageById(id);
	if (image != null) {
		response.setContentType(image.getContentType());
		try {
			BufferedImage generateImage = ImageUtils.getThumbnailImage(image.getImageData());
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
	return "index";
}

@RequestMapping(value = "/upload", method = RequestMethod.POST)
public String uploadImage(HttpServletRequest request) {
	List<Image> images = new LinkedList<Image>();
	String cid = null;
	try {
		FastUploadParser parser = new FastUploadParser(request);
		List<MultiPart> parseList = parser.parseList();
		for (MultiPart part : parseList) {
			if (part.isFile()) {
				Image image = new Image();
				image.setFileName(part.getFileName());
				image.setImageData(part.getContentBuffer());
				image.setContentType(part.getContentType());
				images.add(image);
			}else if(part.getName().equals("cid")){
				cid = part.getString();
			}
		}
	} catch (Exception e) {
	}
	
	if (images.size() > 0) {
		List<Image> savedImages = imageService.save(images);
		Category cat = categoryService.findById(cid);
		if (cat != null) {
			cat.getImages().addAll(savedImages);
			categoryService.saveCategory(cat);
		}
	}

	return "redirect:/category/images?id=" + cid + "&page=0";
}

public static List<Image> splitOutImages(HttpServletRequest request) {
	List<Image> images = new LinkedList<Image>();
	try {
		FastUploadParser parser = new FastUploadParser(request);
		List<MultiPart> parseList = parser.parseList();
		for (MultiPart part : parseList) {
			if (part.isFile()) {
				Image image = new Image();
				image.setFileName(part.getFileName());
				image.setImageData(part.getContentBuffer());
				image.setContentType(part.getContentType());
				images.add(image);
			}

		}
	} catch (Exception e) {

	}
	return images;
}

}
