package org.personal.mason.job.service;

import org.personal.mason.job.dao.DAO;
import org.personal.mason.job.dao.NewsDao;
import org.personal.mason.job.domain.News;

public class NewsService extends DefaultService<News> {

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
