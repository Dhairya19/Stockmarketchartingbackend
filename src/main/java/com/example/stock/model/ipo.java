package com.example.stock.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="ipo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ipo {
	


	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Column(name = "price")
    private BigDecimal price;
    
    @NotNull
    @Column(name = "shares")
    private int shares;
    
    public ipo(int id, BigDecimal price, int shares, String openDateTime, String remarks, int company_id,
			int stockexchange_id, String companyName, String stockExchangeName,
			com.example.stock.model.company company) {
		this.id = id;
		this.price = price;
		this.shares = shares;
		this.openDateTime = openDateTime;
		this.remarks = remarks;
		this.companyName = companyName;
		this.stockExchangeName = stockExchangeName;
		this.company = company;
	}
    

	public ipo() {
	}


	@NotNull
    @Column(name = "opendatetime")
    private String openDateTime;
    
    @NotNull
    @Column(name = "remarks")
    private String remarks;
    
    

    @Column(name = "companyname")
    @NotNull
    private String companyName;
    @Column(name = "stockexchangename")
    @NotNull
    private String stockExchangeName;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private company company;
    
    

	

	public String getCompanyName() {
		return companyName;
	}

	public void setCompany(company company) {
		this.company = company;
	}

	public int getId() {
		return id;
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

	public String getStockExchangeName() {
		return stockExchangeName;
	}

	public company getCompany() {
		return company;
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

    


}
