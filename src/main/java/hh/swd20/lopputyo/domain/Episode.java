package hh.swd20.lopputyo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Episode {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private int episodeNumber;
	private String season;
	
	@Lob
	@Column(name="DESCRIPTION")
	private String description;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "showId")
	private Show show;
	

	public Episode() {
		super();
	}

	public Episode(String name, int episodeNumber, String season, String description, Show show) {
		super();
		this.name = name;
		this.episodeNumber = episodeNumber;
		this.season = season;
		this.description = description;
		this.show = show;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEpisodeNumber() {
		return episodeNumber;
	}

	public void setEpisodeNumber(int episodeNumber) {
		this.episodeNumber = episodeNumber;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	@Override
	public String toString() {
		if (this.show != null)
		return "Episode [id=" + id + ", name=" + name + ", episodeNumber=" + episodeNumber + ", season="
				+ season + ", description=" + description + ", season=" + this.getShow() + "]";
		else
			return "Episode [id=" + id + ", name=" + name + ", episodeNumber=" + episodeNumber + ", season="
					+ season + ", description=" + description + "]";
	} 
	
	

}
