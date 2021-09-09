package com.devSuperior.dsVendas.DTO;

import java.io.Serializable;
import java.time.LocalDate;

import com.devSuperior.dsVendas.Entities.Sale;
 

public class SaleDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private Integer visited;
	private Integer deals;
	private Double amount;
	private LocalDate date;
	private SellerDTO seller;
	// private List<Sale> sales = new ArrayList<>();
	public SaleDTO() {

	}
 
	public SaleDTO(long id, Integer visited, Integer deals, Double amount, LocalDate date) {
 
		this.id = id;
		this.visited = visited;
		this.deals = deals;
		this.amount = amount;
		this.date = date;
	}
	
	public SaleDTO(Sale entity) {
		 
		this.id = entity.getId();
		this.visited = entity.getVisited();
		this.deals = entity.getDeals();
		this.amount = entity.getAmount();
		this.date = entity.getDate();
	}
 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getVisited() {
		return visited;
	}

	public void setVisited(Integer visited) {
		this.visited = visited;
	}

	public Integer getDeals() {
		return deals;
	}

	public void setDeals(Integer deals) {
		this.deals = deals;
	}

	public Double getAmount() {
		return amount;
	}

	public void setSeller(SellerDTO seller) {
		this.seller = seller;
	}

	public SellerDTO getSeller() {
		return seller;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}


}
