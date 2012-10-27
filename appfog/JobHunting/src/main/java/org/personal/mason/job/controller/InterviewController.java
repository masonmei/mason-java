package org.personal.mason.job.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.personal.mason.job.domain.Interview;
import org.personal.mason.job.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/interview")
public class InterviewController {

@Autowired
private InterviewService interviewService;

public void setInterviewService(InterviewService interviewService) {
	this.interviewService = interviewService;
}

@InitBinder
public void InitBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	dateFormat.setLenient(false);
	binder.registerCustomEditor(Date.class, null, new CustomDateEditor(dateFormat, true));
}

@RequestMapping(value = "/list", method = RequestMethod.GET)
public String listInterview(Integer startIndex, Integer pageSize, Map<String, Object> map) {
	if (startIndex == null || startIndex < 0) {
		startIndex = 0;
	}

	if (pageSize == null || pageSize <= 0) {
		pageSize = 10;
	}

	List<Interview> interviews = interviewService.findInScope(startIndex, pageSize);
	map.put("interviews", interviews);

	return "interviews";
}

@RequestMapping(value = "/add", method = RequestMethod.GET)
public String addInterview(Map<String, Object> map) {
	map.put("interview", new Interview());
	return "interview_edit";
}

@RequestMapping(value = "/save", method = RequestMethod.POST)
public String saveInterview(Interview interview) {
	interviewService.save(interview);
	return "redirect:/interview/list";
}

@RequestMapping(value = "/view", method = RequestMethod.GET)
public String viewInterview(@RequestParam("id") Long id, Map<String, Object> map) {
	Interview interview = interviewService.findById(id);
	map.put("interview", interview);
	return "interview";
}

@RequestMapping(value = "/delete")
public String deleteInterview(@RequestParam("id") Long id) {
	interviewService.deleteById(id);
	return "redirect:/interview/list";
}
}
