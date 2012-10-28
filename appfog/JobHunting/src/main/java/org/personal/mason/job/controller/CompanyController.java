package org.personal.mason.job.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.personal.mason.job.domain.City;
import org.personal.mason.job.domain.Company;
import org.personal.mason.job.domain.Province;
import org.personal.mason.job.service.CityService;
import org.personal.mason.job.service.CompanyService;
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

public void setCompanyService(CompanyService companyService) {
	this.companyService = companyService;
}

public void setProvinceService(ProvinceService provinceService) {
	this.provinceService = provinceService;
}

public void setCityService(CityService cityService) {
	this.cityService = cityService;
}

@RequestMapping(value = "/list", method = RequestMethod.GET)
public String listCompany(Integer startIndex, Integer pageSize,
        Map<String, Object> map) {
	if (startIndex == null || startIndex < 0) {
		startIndex = 0;
	}

	if (pageSize == null || pageSize <= 0) {
		pageSize = 10;
	}

	List<Company> companies = companyService.findInScope(startIndex,
	        pageSize);
	map.put("companies", companies);

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
	return "company";
}

@RequestMapping(value = "/edit", method = RequestMethod.GET)
public String editCompany(@RequestParam("id") Long id, Model model) {
	Company com = companyService.findById(id);
	model.addAttribute("company", com);
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

@RequestMapping(value="/cities", method=RequestMethod.GET)
public @ResponseBody List<City> getCitiesOfProvince(@RequestParam("province") String province, HttpServletRequest request){
	Province pro = new Province(province);
	List<Province> findByExample = provinceService.findByExample(pro);
	if(findByExample != null && findByExample.size() > 0){
		List<City> cities = cityService.getByProvince(findByExample.get(0));
		return Collections.unmodifiableList(cities);
	}
	return Collections.emptyList();
}
@RequestMapping(value="/provinces", method=RequestMethod.GET)
public @ResponseBody List<Province> getProvinces(){
	return Collections.unmodifiableList(provinceService.findAll());
}
}
