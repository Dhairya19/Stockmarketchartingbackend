package com.example.stock.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="stockprice")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class stockprice {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "currentprice")
    @NotNull
    private BigDecimal currentPrice;
    @Column(name = "date")
    @NotNull
    private String date;
    @Column(name = "time")
    @NotNull
    private String time;
    @Column(name = "companycode")
    @NotNull
    private String companyCode;
    @Column(name = "stockexchangename")
    @NotNull
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
	public company getCompany() {
		return company;
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
	public stockprice() {
	}
	public stockprice(int id, BigDecimal currentPrice, String date, String time, String companyCode,
			String stockExchangeName, com.example.stock.model.company company) {
		this.id = id;
		this.currentPrice = currentPrice;
		this.date = date;
		this.time = time;
		this.companyCode = companyCode;
		this.stockExchangeName = stockExchangeName;
		this.company = company;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}
	public void setCompany(company company) {
		this.company = company;
	}
	@ManyToOne(fetch = FetchType.LAZY)
    private company company;

}