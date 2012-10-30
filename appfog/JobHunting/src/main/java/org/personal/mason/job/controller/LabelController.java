package org.personal.mason.job.controller;

import java.util.ArrayList;
import java.util.List;

import org.personal.mason.job.domain.Label;
import org.personal.mason.job.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/label")
public class LabelController {

@Autowired
private LabelService labelService;

public void setLabelService(LabelService labelService) {
	this.labelService = labelService;
}

@RequestMapping(value="/list", method = RequestMethod.GET)
public @ResponseBody List<String> listLabels(){
	List<Label> labels = labelService.findAll();
	List<String> names = new ArrayList<>();
	for (Label label : labels) {
	    names.add(label.getLabelName());
    }
	return names;
}

}
