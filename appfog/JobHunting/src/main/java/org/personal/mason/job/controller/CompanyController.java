package org.personal.mason.job.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company")
public class CompanyController {


	public String listCompany(){
		
		return "companies";
	}
}
