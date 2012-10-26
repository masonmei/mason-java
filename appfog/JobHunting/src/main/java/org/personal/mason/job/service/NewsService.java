package org.personal.mason.job.service;

import java.util.List;

import javax.annotation.Resource;

import org.personal.mason.job.dao.DAO;
import org.personal.mason.job.dao.NewsDao;
import org.personal.mason.job.domain.Company;
import org.personal.mason.job.domain.News;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class NewsService extends DefaultService<News> {

@Resource
private NewsDao newsDao;

public NewsDao getNewsDao() {
	return newsDao;
}

public void setNewsDao(NewsDao newsDao) {
	this.newsDao = newsDao;
}

@Override
public DAO<News> getDao() {
	return newsDao;
}

public List<News> findCompanyNews(Company company){
	return findCompanyNews(company, -1, -1);
}

@Transactional(readOnly=true)
public List<News> findCompanyNews(Company company, int start, int length){
	return newsDao.findCompanyNews(company, start, length);
}

}
