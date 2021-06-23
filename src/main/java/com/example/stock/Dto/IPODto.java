package com.example.stock.Dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IPODto {

    private int id;
    private BigDecimal price;
    private int shares;
   
	private String openDateTime;
    private String remarks;
    private String companyName;
    private String stockExchangeName;
    
    public String getCompanyName() {
		return companyName;
	}

	public BigDecimal getPrice() {
		return price;
	}
	public int getShares() {
		return shares;
	}
	public String getOpenDateTime() {
		return openDateTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public void setShares(int shares) {
		this.shares = shares;
	}
	public void setOpenDateTime(String openDateTime) {
		this.openDateTime = openDateTime;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}
	public String getStockExchangeName() {
		return stockExchangeName;
	}
	public int getId() {
		return id;
	}

	public IPODto(int id, BigDecimal price, int shares, String openDateTime, String remarks, String companyName,
			String stockExchangeName) {
		this.id = id;
		this.price = price;
		this.shares = shares;
		this.openDateTime = openDateTime;
		this.remarks = remarks;
		this.companyName = companyName;
		this.stockExchangeName = stockExchangeName;
	}

	public IPODto() {
	}
	
	
	
}
