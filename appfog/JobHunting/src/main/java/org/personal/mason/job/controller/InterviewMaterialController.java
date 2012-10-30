package org.personal.mason.job.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.personal.mason.job.domain.InterviewMaterial;
import org.personal.mason.job.service.InterviewMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
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

	List<InterviewMaterial> interviewMaterials = interviewMaterialService.findInScope(startIndex, pageSize);
	long count = interviewMaterialService.countAll();
	map.put("interviewMaterials", interviewMaterials);
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
	return "redirect:/interviewMaterial/list";
}

@RequestMapping(value = "/view", method = RequestMethod.GET)
public String viewInterviewMaterial(@RequestParam("id") Long id, Map<String, Object> map) {
	InterviewMaterial material = interviewMaterialService.findById(id);
	map.put("interviewMaterial", material);
	return "interviewmaterial";
}

@RequestMapping(value = "/delete")
public String deleteInterviewMaterial(@RequestParam("id") Long id) {
	interviewMaterialService.deleteById(id);
	return "redirect:/interviewMaterial/list";
}

@RequestMapping(value = "/answer")
public String getAnswer(@RequestParam("id") Long id, Map<String, Object> map) {
	InterviewMaterial findById = interviewMaterialService.findById(id);
	map.put("answer", findById.getAnswer());
	return null;
}
}
