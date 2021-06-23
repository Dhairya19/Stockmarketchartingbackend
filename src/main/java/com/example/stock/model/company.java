package com.example.stock.model;

import com.example.stock.Dto.CompanyDto;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="company")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class company {
        
	public company(int id, String companyName, String ceo, BigDecimal turnover, String boardOfDirectors,
			String description, String stockExchangeName, String sectorName, String companyCode,
			com.example.stock.model.sectors sectors, List<companystock> companystocks, List<ipo> ipos,
			List<stockprice> stockprices) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.ceo = ceo;
		this.turnover = turnover;
		this.boardOfDirectors = boardOfDirectors;
		this.description = description;
		this.stockExchangeName = stockExchangeName;
		this.sectorName = sectorName;
		this.companyCode = companyCode;
		this.sectors = sectors;
		this.companystocks = companystocks;
		this.ipos = ipos;
		this.stockprices = stockprices;
	}
        

		public company() {
		super();
	}


		@Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private int id;
        
        @Column(name = "companyname")
        @NotNull
        
        private String companyName;
        @Column(name = "ceo")
        @NotNull
        private String ceo;
        @Column(name = "turnover")
        @NotNull
        private BigDecimal turnover;
        @Column(name = "boardofdirectors")
        @NotNull
        private String boardOfDirectors;
        @Column(name = "description")
        @NotNull
        private String description;
        @Column(name = "stockexchangename")
        @NotNull
        private String stockExchangeName;
        @Column(name = "sectorname")
        @NotNull
        private String sectorName;
        
        @Column(name = "companycode")
        @NotNull
        private String companyCode;
        
        @ManyToOne(fetch = FetchType.LAZY)
        private sectors sectors;
        
        @OneToMany(mappedBy = "company")
        private List<companystock> companystocks = new ArrayList<companystock>();
        
        @OneToMany(mappedBy = "company")
        private List<ipo> ipos = new ArrayList<ipo>();
        
        @OneToMany(mappedBy = "company")
        private List<stockprice> stockprices = new ArrayList<stockprice>();
        

		public int getId() {
			return id;
		}

		public String getCompanyName() {
			return companyName;
		}

		public String getCeo() {
			return ceo;
		}

		public BigDecimal getTurnover() {
			return turnover;
		}

		public String getBoardOfDirectors() {
			return boardOfDirectors;
		}

		public String getDescription() {
			return description;
		}

		public String getCompanyCode() {
			return companyCode;
		}

		public sectors getSectors() {
			return sectors;
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

		public void setTurnover(BigDecimal turnover) {
			this.turnover = turnover;
		}

		public void setBoardOfDirectors(String boardOfDirectors) {
			this.boardOfDirectors = boardOfDirectors;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public void setStockExchangeName(String stockExchangeName) {
			this.stockExchangeName = stockExchangeName;
		}

		public void setSectorName(String sectorName) {
			this.sectorName = sectorName;
		}

		public void setCompanyCode(String companyCode) {
			this.companyCode = companyCode;
		}

		public void setCompanystocks(List<companystock> companystocks) {
			this.companystocks = companystocks;
		}

		public void setIpos(List<ipo> ipos) {
			this.ipos = ipos;
		}

		public void setStockprices(List<stockprice> stockprices) {
			this.stockprices = stockprices;
		}

		public String getStockExchangeName() {
			return stockExchangeName;
		}

		public String getSectorName() {
			return sectorName;
		}

		public List<companystock> getCompanystocks() {
			return companystocks;
		}

		public List<ipo> getIpos() {
			return ipos;
		}

		public List<stockprice> getStockprices() {
			return stockprices;
		}

		public void setSectors(sectors sectors) {
			this.sectors = sectors;
		}
		
		
		}


