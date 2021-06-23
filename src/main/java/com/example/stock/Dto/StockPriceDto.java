package com.example.stock.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockPriceDto {

    private int id;
    private BigDecimal currentPrice;
    private String date;
    private String time;
    private String companyCode;
    private String stockExchangeName;
    
	public int getId() {
		return id;
	}
	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}
	public String getDate() {
		return date;
	}
	public String getTime() {
		return time;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public String getStockExchangeName() {
		return stockExchangeName;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCurrentPrice(BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}
	public StockPriceDto(int id, BigDecimal currentPrice, String date, String time, String companyCode,
			String stockExchangeName) {
		super();
		this.id = id;
		this.currentPrice = currentPrice;
		this.date = date;
		this.time = time;
		this.companyCode = companyCode;
		this.stockExchangeName = stockExchangeName;
	}
	public StockPriceDto() {
	}
	
	
}
