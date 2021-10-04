package by.htp.news.bean.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.htp.news.entity.News;

@Repository
public class NewsDAOImpl implements NewsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<News> getNews() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<News> theNews = currentSession.createQuery("from News order by n_date", News.class);
		List<News> news = theNews.getResultList();
		return news;
	}

	public void addNews(News news) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(news);
	}

	public News getViewNews(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		News news = currentSession.get(News.class, id);
		return news;
	}

	public void deleteNews(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		Query<News> news = currentSession.createQuery("delete from News where id=:n_id");
		news.setParameter("n_id", id);
		news.executeUpdate();
	}
	
	public News getNews(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		News news = currentSession.get(News.class, id);
		return news;
	}

}
