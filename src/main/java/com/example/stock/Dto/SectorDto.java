package com.example.stock.Dto;

import lombok.*;

import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
public class SectorDto {

    private int id;
    private String name;
    private String description;
    
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SectorDto(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public SectorDto() {
		super();
	}

	public SectorDto(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	
	
	
	
}
