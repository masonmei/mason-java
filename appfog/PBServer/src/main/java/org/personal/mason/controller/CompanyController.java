package org.personal.mason.controller;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.personal.mason.domain.Company;
import org.personal.mason.domain.Label;
import org.personal.mason.service.CompanyService;
import org.personal.mason.service.LabelService;
import org.personal.mason.utils.LocationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriUtils;

@Controller
@RequestMapping("company")
public class CompanyController {

private final Log log = LogFactory.getLog(getClass());
@Autowired
private CompanyService companyService;
@Autowired
private LabelService labelService;

@RequestMapping(value = "/list", method = RequestMethod.GET)
public String listCompany(Integer startIndex, Integer pageSize, Map<String, Object> map) {
	if (startIndex == null || startIndex < 0) {
		startIndex = 0;
	}

	if (pageSize == null || pageSize <= 0) {
		pageSize = 10;
	}

	Page<Company> companies = companyService.findInScope(startIndex, pageSize);
	map.put("companies", companies.iterator());

	return "companies";
}

@RequestMapping(value = "/delete")
public String deleteCompany(@RequestParam("id") String id) {
	companyService.deleteById(id);
	return null;
}

@RequestMapping(value = "/view", method = RequestMethod.GET)
public String viewCompany(@RequestParam("id") String id, Map<String, Object> map) {
	Company com = companyService.findById(id);
	map.put("company", com);
	map.put("labels", com.getLabels());
	return "company";
}

@RequestMapping(value = "/edit", method = RequestMethod.GET)
public String editCompany(@RequestParam("id") String id, Model model) {
	Company com = companyService.findById(id);
	model.addAttribute("company", com);
	model.addAttribute("labels", com.getLabels());
	return "company_edit";
}

@RequestMapping(value = "/new", method = RequestMethod.GET)
public String newCompany(Model model) {
	model.addAttribute("company", new Company());
	model.addAttribute("create", true);
	return "company_edit";
}

@RequestMapping(value = "/update", method = RequestMethod.POST)
public String updateCompany(Company company) {
	companyService.save(company);
	return "redirect:list";
}

@RequestMapping(value = "/label/add", method = RequestMethod.GET)
public @ResponseBody
boolean addLabelToCompany(@RequestParam("label") String labelName, @RequestParam("companyId") String companyId) {
	Label label = labelService.findByLabelName(labelName);
	if (label == null) {
		label = new Label();
		label.setLabelName(labelName);
		labelService.save(label);
	}

	boolean addLabelToCompany = companyService.addLabelToCompany(companyId, label);
	return addLabelToCompany;
}

@RequestMapping(value = "/cities", method = RequestMethod.GET)
public @ResponseBody
List<String> getCitiesOfProvince(@RequestParam("provinceName") String provinceName) {
	try {
		provinceName = UriUtils.decode(provinceName, "UTF-8");
		List<String> citiesOfProvince = LocationUtils.getCitiesOfProvince(provinceName);
		return Collections.unmodifiableList(citiesOfProvince);
	} catch (UnsupportedEncodingException e) {
		log.debug("could not decode the provinceName");
	}
	return null;
}

@RequestMapping(value = "/provinces", method = RequestMethod.GET)
public @ResponseBody
List<String> getProvinces() {
	return Collections.unmodifiableList(LocationUtils.getAllProvince());
}

}
