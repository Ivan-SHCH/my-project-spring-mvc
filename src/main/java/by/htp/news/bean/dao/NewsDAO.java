package by.htp.news.bean.dao;

import java.util.List;

import by.htp.news.entity.News;

public interface NewsDAO {
	
	List<News> getNews();

	void addNews(News news);

	News getViewNews(int id);

	void deleteNews(int id);

}
