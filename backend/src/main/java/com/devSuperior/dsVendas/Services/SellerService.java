package com.devSuperior.dsVendas.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devSuperior.dsVendas.DTO.SellerDTO;
import com.devSuperior.dsVendas.Entities.Seller;
import com.devSuperior.dsVendas.Repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repository;
	
	public List<SellerDTO> findAll(){
		List<Seller> result = repository.findAll(); 
		
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	
	}
}
