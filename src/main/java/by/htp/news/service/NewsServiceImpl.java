package by.htp.news.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.htp.news.bean.dao.NewsDAO;
import by.htp.news.entity.News;

@Service
public class NewsServiceImpl implements NewsService {
	@Autowired
	private NewsDAO newsDAO;

	@Transactional
	public List<News> getNews() {
		return newsDAO.getNews();
	}

	@Transactional
	public void addNews(News news) {
		newsDAO.addNews(news);
	}

	@Transactional
	public News getViewNews(int id) {
		
		return newsDAO.getViewNews(id) ;
	}

	@Transactional
	public void deleteNews(int id) {
		newsDAO.deleteNews(id);
	}

	public News getNews(int id) {
		return newsDAO.getViewNews(id);
	}

}
