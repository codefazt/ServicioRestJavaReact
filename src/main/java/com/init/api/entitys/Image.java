package com.init.api.entitys;

import javax.persistence.*;

@Entity
@Table( name = "images" )
public class Image {

	@Id
	@Column( name = "id" )
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column( name = "src" )
	private String src;
	
	@Column( name = "alt" )
	private String alt;
	
	@Column( name = "title" )
	private String title;


	public void setSrc(String src) {
		this.src = src;
	}
	
	public String getSrc() {
		return this.src;
	}
	
	public void setAlt(String alt) {
		this.alt = alt;
	}
	
	public String getAlt() {
		return this.alt;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	
	
}


