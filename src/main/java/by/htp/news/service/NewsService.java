package by.htp.news.service;

import java.util.List;

import by.htp.news.entity.News;

public interface NewsService {

	List<News> getNews();
	
	void addNews(News news);
	
	News getViewNews(int id);
	
	void deleteNews(int id);
	
}
