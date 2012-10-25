package org.personal.mason.job.service;

import javax.annotation.Resource;

import org.personal.mason.job.dao.DAO;
import org.personal.mason.job.dao.NewsDao;
import org.personal.mason.job.domain.News;
import org.springframework.stereotype.Service;
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

}
