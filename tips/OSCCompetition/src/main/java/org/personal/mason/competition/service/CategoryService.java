package org.personal.mason.competition.service;

import java.util.List;

import org.personal.mason.competition.domain.Account;
import org.personal.mason.competition.domain.Category;
import org.personal.mason.competition.domain.Image;
import org.personal.mason.competition.repository.CategoryRepository;
import org.personal.mason.competition.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

@Autowired
private CategoryRepository categoryRepository;
@Autowired
private ImageRepository imageRepository;

public List<Category> getPublicPrivilegeCategories(Account account) {
	return categoryRepository.findByAccountAndPublicPrivilege(account, true);
}

public List<Category> findAllByAccount(Account account) {
	return categoryRepository.findByAccount(account);
}

public Page<Category> findPage(Account account, Pageable pageable) {
	return categoryRepository.findByAccount(account, pageable);
}

public boolean deleteCategory(Category category) {
	try {
		List<Image> images = category.getImages();
		imageRepository.delete(images);
		categoryRepository.delete(category);
		return true;
	} catch (Exception e) {
		return false;
	}
}

public List<Category> getPublicPrivilegeCategories(){
	return categoryRepository.findByPublicPrivilege(true);
}

public Category findById(String id) {
	return categoryRepository.findOne(id);
}

public Category createCategory(Category category) {
	return categoryRepository.save(category);
}
}
