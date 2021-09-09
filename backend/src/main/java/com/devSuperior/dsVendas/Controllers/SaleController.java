package com.devSuperior.dsVendas.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devSuperior.dsVendas.DTO.SaleDTO;
import com.devSuperior.dsVendas.DTO.SaleSuccessDTO;
import com.devSuperior.dsVendas.DTO.SaleSumDTO;
import com.devSuperior.dsVendas.Services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;

	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable page){
		Page<SaleDTO> result = service.findAll(page);
		return ResponseEntity.ok(result);
	}

	@GetMapping(value = "/SumBySaller")
	public ResponseEntity<List<SaleSumDTO>> amountSumPerSaller(){
		List<SaleSumDTO> result = service.amountSumPerSaller();
		return ResponseEntity.ok(result);
	}
	@GetMapping(value = "/SuccessBySaller")
	public ResponseEntity<List<SaleSuccessDTO>> successPerSaller(){
		List<SaleSuccessDTO> result = service.successPerSaller();
		return ResponseEntity.ok(result);
	}
}
