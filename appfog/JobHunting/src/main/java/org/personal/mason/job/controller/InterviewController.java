package org.personal.mason.job.controller;

import java.util.List;
import java.util.Map;

import org.personal.mason.job.domain.Interview;
import org.personal.mason.job.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listCompany(Integer startIndex, Integer pageSize, Map<String, Object> map) {
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
		
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addInterview(Interview interview) {
		interviewService.save(interview);
		return null;
	}

	@RequestMapping(value = "/delete")
	public String deleteInterview(@RequestParam("id") Long id) {
		interviewService.deleteById(id);
		return null;
	}
}
