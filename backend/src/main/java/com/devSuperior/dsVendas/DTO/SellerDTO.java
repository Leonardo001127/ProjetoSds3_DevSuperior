package com.devSuperior.dsVendas.DTO;

import java.io.Serializable;

import com.devSuperior.dsVendas.Entities.Seller;

public class SellerDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String name;

	// private List<Sale> sales = new ArrayList<>();
	public SellerDTO() {

	}

	public SellerDTO(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public SellerDTO(Seller entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
