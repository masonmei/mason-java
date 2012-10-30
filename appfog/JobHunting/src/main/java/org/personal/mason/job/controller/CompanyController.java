package org.personal.mason.job.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.personal.mason.job.domain.City;
import org.personal.mason.job.domain.Company;
import org.personal.mason.job.domain.Label;
import org.personal.mason.job.domain.Province;
import org.personal.mason.job.service.CityService;
import org.personal.mason.job.service.CompanyService;
import org.personal.mason.job.service.LabelService;
import org.personal.mason.job.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/company")
public class CompanyController {

@Autowired
private CompanyService companyService;

@Autowired
private ProvinceService provinceService;

@Autowired
private CityService cityService;

@Autowired
private LabelService labelService;

public void setCompanyService(CompanyService companyService) {
	this.companyService = companyService;
}

public void setProvinceService(ProvinceService provinceService) {
	this.provinceService = provinceService;
}

public void setCityService(CityService cityService) {
	this.cityService = cityService;
}

public void setLabelService(LabelService labelService) {
	this.labelService = labelService;
}

@RequestMapping(value = "/list", method = RequestMethod.GET)
public String listCompany(Integer startIndex, Integer pageSize, Map<String, Object> map) {
	if (startIndex == null || startIndex < 0) {
		startIndex = 0;
	}

	if (pageSize == null || pageSize <= 0) {
		pageSize = 10;
	}

	List<Company> companies = companyService.findInScope(startIndex, pageSize);
	map.put("companies", companies);

	return "companies";
}

@RequestMapping(value = "/listwithlabel", method = RequestMethod.GET)
public String listCompanyByLabel(@RequestParam("labelName") String labelName, Integer startIndex, Integer pageSize,
		Model model) {
	Label label = labelService.findByLabelName(labelName);
	if (label != null) {
		if (startIndex == null || startIndex < 0) {
			startIndex = 0;
		}

		if (pageSize == null || pageSize <= 0) {
			pageSize = 10;
		}

		List<Company> companies = companyService.findByLabel(label, startIndex, pageSize);
		model.addAttribute("companies", companies);
	}
	return "companies";
}

@RequestMapping(value = "/delete")
public String deleteCompany(@RequestParam("id") Long id) {
	companyService.deleteById(id);
	return null;
}

@RequestMapping(value = "/view", method = RequestMethod.GET)
public String viewCompany(@RequestParam("id") Long id, Map<String, Object> map) {
	Company com = companyService.findById(id);
	map.put("company", com);
	map.put("labels", com.getLabels());
	return "company";
}

@RequestMapping(value = "/edit", method = RequestMethod.GET)
public String editCompany(@RequestParam("id") Long id, Model model) {
	Company com = companyService.findById(id);
	model.addAttribute("company", com);
	model.addAttribute("labels",com.getLabels());
	return "company_edit";
}

@RequestMapping(value = "/new", method = RequestMethod.GET)
public String newCompany(Model model) {
	model.addAttribute("company", new Company());
	model.addAttribute("create", true);
	return "company_edit";
}

@RequestMapping(value = "/update", method = RequestMethod.POST)
public String updateCompany(@ModelAttribute("company") Company company) {
	if (company.getId() != null) {
		companyService.update(company);
	} else {
		companyService.save(company);
	}
	return "redirect:/company/list";
}

@RequestMapping(value="/label/add", method = RequestMethod.GET)
public @ResponseBody boolean addLabelToCompany(@RequestParam("label") String labelName, @RequestParam("companyId") Long companyId){
	Label label = labelService.findByLabelName(labelName);
	if(label == null){
		label = new Label();
		label.setLabelName(labelName);
		labelService.save(label);
	}
	
	boolean addLabelToCompany = companyService.addLabelToCompany(companyId, label);
	return addLabelToCompany;
}

@RequestMapping(value = "/cities", method = RequestMethod.GET)
public @ResponseBody
List<City> getCitiesOfProvince(@RequestParam("provinceName") String provinceName) {
	Province province = provinceService.findByProvinceName(provinceName);
	if (province != null) {
		List<City> cities = cityService.getByProvince(province);
		return Collections.unmodifiableList(cities);
	}
	List<City> findAll = cityService.findAll().subList(0, 10);
	return Collections.unmodifiableList(findAll);
}

@RequestMapping(value = "/provinces", method = RequestMethod.GET)
public @ResponseBody
List<Province> getProvinces() {
	return Collections.unmodifiableList(provinceService.findAll());
}

}