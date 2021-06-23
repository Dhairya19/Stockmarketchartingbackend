package com.example.stock.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CompanyCompareRequest {
    private String companyCode;
    private String stockExchangeName;
    private String fromPeriod;
    private String toPeriod;
    private String periodicity;
    

	public CompanyCompareRequest(String companyCode, String stockExchangeName, String fromPeriod, String toPeriod,
			String periodicity) {
		super();
		this.companyCode = companyCode;
		this.stockExchangeName = stockExchangeName;
		this.fromPeriod = fromPeriod;
		this.toPeriod = toPeriod;
		this.periodicity = periodicity;
	}
	
	
	public CompanyCompareRequest() {
		super();
	}


	public String getToPeriod() {
		return toPeriod;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}
	public void setFromPeriod(String fromPeriod) {
		this.fromPeriod = fromPeriod;
	}
	public void setToPeriod(String toPeriod) {
		this.toPeriod = toPeriod;
	}
	public void setPeriodicity(String periodicity) {
		this.periodicity = periodicity;
	}
	public String getPeriodicity() {
		return periodicity;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public String getStockExchangeName() {
		return stockExchangeName;
	}
	public String getFromPeriod() {
		return fromPeriod;
	}
	
}
