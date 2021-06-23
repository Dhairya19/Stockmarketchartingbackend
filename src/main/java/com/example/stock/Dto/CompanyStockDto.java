package com.example.stock.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CompanyStockDto {
    private int id;
    
    private String companyCode;

	public int getId() {
		return id;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public CompanyStockDto(int id, String companyCode) {
		super();
		this.id = id;
		this.companyCode = companyCode;
	}

	public CompanyStockDto() {
		super();
	}

    
}
