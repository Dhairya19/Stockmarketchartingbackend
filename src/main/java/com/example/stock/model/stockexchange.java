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
@Table(name="stockexchange")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class stockexchange {
	
    public stockexchange(int id, String stockExchangeName, String brief, String contactAddress, String remarks,
			List<companystock> companystocks) {
		super();
		this.id = id;
		this.stockExchangeName = stockExchangeName;
		this.brief = brief;
		this.contactAddress = contactAddress;
		this.remarks = remarks;
		this.companystocks = companystocks;
	}
    
	public stockexchange() {
		super();
	}

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name = "stockexchangename")
    @NotNull
    private String stockExchangeName;

    @Column(name = "brief")
    @NotNull
    private String brief;
    @Column(name = "contactaddress")
    @NotNull
    private String contactAddress;

    @Column(name = "remarks")
    @NotNull
    private String remarks;
    @OneToMany(mappedBy = "stockexchange",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<companystock> companystocks = new ArrayList<companystock>();
	public Iterable<companystock> getCompanystocks() {
		// TODO Auto-generated method stub
		return null;
	}
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
	public void setCompanystocks(List<companystock> companystocks) {
		this.companystocks = companystocks;
	}
	

}
