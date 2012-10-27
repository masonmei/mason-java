package org.personal.mason.job.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.personal.mason.job.domain.Company;
import org.personal.mason.job.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
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
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addCompany(Company company) {
		
		return null;
	}
	
	@RequestMapping(value = "/delete")
	public String deleteCompany(@RequestParam("id") Long id) {
		companyService.deleteById(id);
		return null;
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewCompany(@RequestParam("id") Long id, Map<String, Object> map){
		Company com = companyService.findById(id);
		map.put("company", com);
		return "company";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editCompany(@RequestParam("id") Long id, Map<String, Object> map){
		Company com = companyService.findById(id);
		map.put("company", com);
		List<String> provinces = new ArrayList<String>();
		provinces.add("Henan");
		map.put("provinceList", provinces);
		List<String> cities = new ArrayList<String>();
		cities.add("luohe");
		map.put("cityOfProvince", cities);
		return "company_edit";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newCompany(Map<String, Object> map) {
		map.put("company", new Company());
		List<String> provinces = new ArrayList<String>();
		provinces.add("Henan");
		map.put("provinceList", provinces);
		List<String> cities = new ArrayList<String>();
		cities.add("luohe");
		map.put("cityOfProvince", cities);
		map.put("create", true);
		return "company_edit";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCompany(@ModelAttribute("company") Company company){
		if(company.getId() != null ){
			companyService.update(company);
		}else{
			companyService.save(company);
		}
		return "redirect:/company/list";
	}
}
