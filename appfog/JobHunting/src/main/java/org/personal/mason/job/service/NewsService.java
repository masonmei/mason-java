package org.personal.mason.job.service;

import org.personal.mason.job.dao.NewsDao;
import org.personal.mason.job.domain.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mmei
 * 
 */
@Service("newsService")
public class NewsService extends DefaultService<News> {

	@Autowired
	private NewsDao newsDao;

	public NewsDao getNewsDao() {
		return newsDao;
	}

	public void setNewsDao(NewsDao newsDao) {
		super.setDao(newsDao);
		this.newsDao = newsDao;
	}

}
