package com.example.stock.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="sectors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class sectors {
	
    public sectors(int id, String name, String description, List<company> companies) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.companies = companies;
	}
    
	public sectors() {
		super();
	}



	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
	
    @Column(name = "name")
    @NotNull
    
    private String name;
    @Column(name = "description")
    @NotNull
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
	public void setCompanies(List<company> companies) {
		this.companies = companies;
	}
	@OneToMany(mappedBy = "sectors")
    private List<company> companies = new ArrayList<company>();

	public List<company> getCompanies() {
		return companies;
	}




}