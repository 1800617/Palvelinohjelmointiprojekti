package hh.swd20.lopputyo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Show {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message= "Show title is mandatory")
	private String title;
	
	@Lob
	@Column(name="DESCRIPTION")
	private String description;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryId")
	private Category category;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "show")
	private List<Episode> episodes;

	public Show() {
		super();
	}

	public Show(String title, String description, Category category) {
		super();
		this.title = title;
		this.description = description;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public List<Episode> getEpisodes() {
		return episodes;
	}

	@Override
	public String toString() {
		if (this.category != null)
			return "Show [id=" + id + ", title=" + title + ", description=" + description + ", category=" + this.getCategory() + "]";
		else
			return "Show [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
	
	

}
