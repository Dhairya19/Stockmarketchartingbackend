package com.example.stock.Dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CompanyDto {

    private int id;
    private String companyName;
    private String ceo;
    private String boardOfDirectors;
    private String description;
    private BigDecimal turnover;
    private String companyCode;
    private String stockExchangeName;
    private String sectorName;
    
 
	public CompanyDto(int id, String companyName, String ceo, String boardOfDirectors, String description,
			BigDecimal turnover, String companyCode, String stockExchangeName, String sectorName) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.ceo = ceo;
		this.boardOfDirectors = boardOfDirectors;
		this.description = description;
		this.turnover = turnover;
		this.companyCode = companyCode;
		this.stockExchangeName = stockExchangeName;
		this.sectorName = sectorName;
	}
	
	   public CompanyDto() {
		super();
	}

	public String getCompanyName() {
			return companyName;
		}

	public String getCeo() {
		return ceo;
	}

	public String getBoardOfDirectors() {
		return boardOfDirectors;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getTurnover() {
		return turnover;
	}

	public String getStockExchangeName() {
		return stockExchangeName;
	}

    
	public void setId(int id) {
		this.id = id;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public void setBoardOfDirectors(String boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTurnover(BigDecimal turnover) {
		this.turnover = turnover;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	public int getId() {
		return id;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public String getSectorName() {
		return sectorName;
	}


	

}
