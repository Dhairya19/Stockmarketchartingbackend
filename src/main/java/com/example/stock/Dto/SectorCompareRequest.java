package com.example.stock.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SectorCompareRequest {
    private String sectorName;
    private String stockExchangeName;
    private String fromPeriod;
    private String toPeriod;
    private String periodicity;
    
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
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

	public String getSectorName() {
		return sectorName;
	}
	public String getStockExchangeName() {
		return stockExchangeName;
	}
	public String getPeriodicity() {
		return periodicity;
	}
	public String getFromPeriod() {
		return fromPeriod;
	}
	public String getToPeriod() {
		return toPeriod;
	}
	public SectorCompareRequest(String sectorName, String stockExchangeName, String fromPeriod, String toPeriod,
			String periodicity) {
		super();
		this.sectorName = sectorName;
		this.stockExchangeName = stockExchangeName;
		this.fromPeriod = fromPeriod;
		this.toPeriod = toPeriod;
		this.periodicity = periodicity;
	}
	public SectorCompareRequest() {
		super();
	}
	
	
}
