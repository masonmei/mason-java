package org.personal.mason.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.personal.mason.domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class CompanyServiceTest {

@Autowired
private CompanyService companyService;

@Autowired
private LabelService labelService;

@Test
public void test() {
	assertTrue(true);
}

@Test
public void testSaveCompany() {
//	Company company = new Company();
//	company.setCompanyName("TestCompanyName");
//	company.setProvince("Province");
//	company.setCity("City");
//	company.setBusinessType("BT1");
//	company.setDescription("Desc");
//	company.setScale(1000);
//	Label label = new Label();
//	label.setLabelName("label1");
//	labelService.save(label);
//	company.getLabels().add(label);
//	Company saved = companyService.save(company);
//	// List<Company> findAll = companyService.findAll();
//	// assertEquals(findAll.size(), 1);
//	List<Label> labels = saved.getLabels();
//	Label label2 = labels.get(0);
//	System.out.println(label2.getLabelName());
}

@Test
public void testFindByCompanyNameLike() {
	String companyName = "CompanyName";
	List<Company> findByLabelName = companyService.findByCompanyNameLike(companyName);
	System.out.println(findByLabelName.size());
}

@Test
public void testUpdateCompany() {
//	String companyName = "CompanyName";
//	List<Company> findByLabelName = companyService.findByCompanyNameLike(companyName);
//	for (Company company : findByLabelName) {
//		company.setCompanyName(company.getCompanyName() + "update");
//		companyService.save(company);
//	}
}
}
