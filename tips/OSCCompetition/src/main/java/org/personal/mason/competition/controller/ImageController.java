package org.personal.mason.competition.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sourceforge.fastupload.FastUploadParser;
import net.sourceforge.fastupload.MultiPart;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.personal.mason.competition.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("image")
public class ImageController {

private final Log log = LogFactory.getLog(getClass());
@Autowired
private ImageService imageService;

@RequestMapping(value = "/upload", method = RequestMethod.POST)
public String updateCompany(HttpServletRequest request) {
	//TODO
//	splitOutImages(request);
	return null;
}

public static void splitOutImages(HttpServletRequest request) throws IOException{
	FastUploadParser parser = new FastUploadParser(request);
	List<MultiPart> parseList = parser.parseList();
	for (MultiPart part : parseList) {
		if(part.isFile()){
			System.out.println(part.getFileName());
		}
			
	}
}

}
