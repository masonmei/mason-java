package org.personal.mason.service;

import java.util.List;

import org.personal.mason.domain.News;
import org.personal.mason.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
@Autowired
private NewsRepository newsRepository;

public List<News> findAll() {
	return newsRepository.findAll();
}

public Page<News> findInScope(int page, int size) {
	PageRequest request = new PageRequest(page, size);
	return newsRepository.findAll(request);
}

public News findById(String id) {
	return newsRepository.findOne(id);
}

public News save(News news) {
	return newsRepository.save(news);
}

public void delete(News news) {
	newsRepository.delete(news);
}

public long count() {
	return newsRepository.count();
}

public void delete(String id) {
	newsRepository.delete(id);
}
}
