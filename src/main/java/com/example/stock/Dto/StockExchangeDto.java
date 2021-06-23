package com.example.stock.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StockExchangeDto {

    private int id;
    private String stockExchangeName;
    private String brief;
    private String contactAddress;
    private String remarks;
    
	public int getId() {
		return id;
	}

	public String getStockExchangeName() {
		return stockExchangeName;
	}

	public String getBrief() {
		return brief;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public StockExchangeDto(int id, String stockExchangeName, String brief, String contactAddress, String remarks) {
		super();
		this.id = id;
		this.stockExchangeName = stockExchangeName;
		this.brief = brief;
		this.contactAddress = contactAddress;
		this.remarks = remarks;
	}

	public StockExchangeDto() {
		super();
	}
	

}