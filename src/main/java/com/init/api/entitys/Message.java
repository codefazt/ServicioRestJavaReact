package com.init.api.entitys;

import javax.persistence.*;

@Entity
@Table( name = "messages" )
public class Message {

	@Id
	@Column( name = "id" )
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column( name = "description" )
	private String description;

	@Column( name = "name" )
	private String name;

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
}


