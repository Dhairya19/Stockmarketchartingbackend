package com.example.stock.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="companytostockexchange")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class companystock {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "code")
    @NotNull
    private String companyCode;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private company company;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private stockexchange stockexchange;


    

	public companystock(int id, String companyCode, com.example.stock.model.company company,
			com.example.stock.model.stockexchange stockexchange) {
		super();
		this.id = id;
		this.companyCode = companyCode;
		this.company = company;
		this.stockexchange = stockexchange;
	}
	

	public companystock(String companyCode2, com.example.stock.model.company company2, com.example.stock.model.stockexchange stockExchange2) {
		super();
	}


	public String getCompanyCode() {
		return companyCode;
	}


	public company getCompany() {
		return company;
	}


	public int getId() {
		return id;
	}

	public stockexchange getStockexchange() {
		return stockexchange;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public void setCompany(company company) {
		this.company = company;
	}

	public void setStockexchange(stockexchange stockexchange) {
		this.stockexchange = stockexchange;
	}
	

}
