package org.personal.mason.job.controller;

import java.util.List;
import java.util.Map;

import org.personal.mason.job.domain.InterviewMaterial;
import org.personal.mason.job.service.InterviewMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "meterial")
public class InterviewMaterialController {

	@Autowired
	private InterviewMaterialService interviewMaterialService;

	public void setInterviewMaterialService(
			InterviewMaterialService interviewMaterialService) {
		this.interviewMaterialService = interviewMaterialService;
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
		
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addInterviewMaterial(InterviewMaterial interviewMaterial) {
		interviewMaterialService.save(interviewMaterial);
		return null;
	}

	@RequestMapping(value = "/delete")
	public String deleteInterviewMaterial(@RequestParam("id") Long id) {
		interviewMaterialService.deleteById(id);
		return null;
	}
	
	@RequestMapping(value = "/answer")
	public String getAnswer(@RequestParam("id") Long id, Map<String, Object> map) {
		InterviewMaterial findById = interviewMaterialService.findById(id);
		map.put("answer", findById.getAnswer());
		return null;
	}
}
