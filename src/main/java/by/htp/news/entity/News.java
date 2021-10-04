package by.htp.news.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "news")
public class News  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "n_id")
	private int id;
	
	@NotNull(message = "This field cannot be empty")
	@Size(min = 5, max= 250, message = "The title must be between 5 and 250 characters")
	@Column(name = "n_title")
	private String title;
	
	@NotNull(message = "This field cannot be empty")
	@Size(min = 5, max= 500, message = "The title must be between 5 and 500 characters")
	@Column(name = "n_brief")
	private String brief;
	
	@NotNull(message = "This field cannot be empty")
	@Size(min = 5, max= 5000, message = "The title must be between 5 and 5000 characters")
	@Column(name = "n_content")
	private String content;
	
	@NotNull(message = "This field cannot be empty")
	@Column(name = "n_style")
	private String style;
	
	@Column(name = "n_date")
	private Timestamp date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("News [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", brief=");
		builder.append(brief);
		builder.append(", content=");
		builder.append(content);
		builder.append(", style=");
		builder.append(style);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
