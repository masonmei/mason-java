package org.personal.mason.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.personal.mason.domain.InterviewMaterial;
import org.personal.mason.service.InterviewMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/interviewMaterial")
public class InterviewMaterialController {

@Autowired
private InterviewMaterialService interviewMaterialService;

public void setInterviewMaterialService(InterviewMaterialService interviewMaterialService) {
	this.interviewMaterialService = interviewMaterialService;
}

@InitBinder
public void InitBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	dateFormat.setLenient(false);
	binder.registerCustomEditor(Date.class, null, new CustomDateEditor(dateFormat, true));
}

@RequestMapping(value = "/list", method = RequestMethod.GET)
public String listInterviewMaterial(Integer startIndex, Integer pageSize, Map<String, Object> map) {
	if (startIndex == null || startIndex < 0) {
		startIndex = 0;
	}

	if (pageSize == null || pageSize <= 0) {
		pageSize = 10;
	}

	Page<InterviewMaterial> interviewMaterials = interviewMaterialService.findInScope(startIndex, pageSize);
	long count = interviewMaterialService.count();
	map.put("interviewMaterials", interviewMaterials.iterator());
	map.put("count", count);
	return "interviewmaterials";
}

@RequestMapping(value = "/add", method = RequestMethod.GET)
public String addInterviewMaterial(Map<String, Object> map) {
	map.put("interviewMaterial", new InterviewMaterial());
	return "interviewmaterial_edit";
}

@RequestMapping(value = "/save", method = RequestMethod.POST)
public String saveInterviewMaterial(InterviewMaterial interviewMaterial) {
	interviewMaterialService.save(interviewMaterial);
	return "redirect:list";
}

@RequestMapping(value = "/view", method = RequestMethod.GET)
public String viewInterviewMaterial(@RequestParam("id") String id, Map<String, Object> map) {
	InterviewMaterial material = interviewMaterialService.findById(id);
	map.put("interviewMaterial", material);
	return "interviewmaterial";
}

@RequestMapping(value = "/delete")
public String deleteInterviewMaterial(@RequestParam("id") String id) {
	interviewMaterialService.delete(id);
	return "redirect:list";
}

@RequestMapping(value = "/answer")
public String getAnswer(@RequestParam("id") String id, Map<String, Object> map) {
	InterviewMaterial findById = interviewMaterialService.findById(id);
	map.put("answer", findById.getAnswer());
	return null;
}
}
