package by.htp.news.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.htp.news.entity.News;
import by.htp.news.service.NewsService;

@Controller
@RequestMapping("/news")
public class NewsController {

	@Autowired
	private NewsService newsService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@RequestMapping("/list")
	public String listNews(Model model) {

		List<News> news = newsService.getNews();
		model.addAttribute("news", news);
		return "list-news";

	}

	@GetMapping("showFormForAdd")
	public String showFormForAdd(Model model) {
		News news = new News();

		model.addAttribute("news", news);
		return "news-form";
	}

	@PostMapping("/addNews")
	public String addNews(@ Valid @ModelAttribute("news") News news, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()){
			return "/news-form";
		}else {
			Timestamp time = new Timestamp(System.currentTimeMillis());
			news.setDate(time);
			newsService.addNews(news);
			return "redirect:/news/list";
		}
		
	}

	@GetMapping("/delete")
	public String deleteNews(@RequestParam("newsId") int id) {
		newsService.deleteNews(id);
		return "redirect:/news/list";
	}

	@GetMapping("/read")
	public String read(@RequestParam("newsId") int id, Model model) {
		News news = newsService.getViewNews(id);
		model.addAttribute("news", news);
		return "read";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("newsId") int id, Model model) {
		News news = newsService.getViewNews(id);
		model.addAttribute("news", news);
		return "news-form";
	}

}
