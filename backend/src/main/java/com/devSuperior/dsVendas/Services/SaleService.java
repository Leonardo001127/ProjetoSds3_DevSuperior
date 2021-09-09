package com.devSuperior.dsVendas.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devSuperior.dsVendas.DTO.SaleDTO;
import com.devSuperior.dsVendas.Entities.Sale;
import com.devSuperior.dsVendas.Repositories.SaleRepository;
import com.devSuperior.dsVendas.Repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository selRep;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pegaeble){
		
		selRep.findAll();
		
		Page<Sale> result = repository.findAll(pegaeble); 		
		return result.map(x -> new SaleDTO(x)); 	
	}
}
