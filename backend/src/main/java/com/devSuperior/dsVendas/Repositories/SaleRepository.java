package com.devSuperior.dsVendas.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devSuperior.dsVendas.DTO.SaleSuccessDTO;
import com.devSuperior.dsVendas.DTO.SaleSumDTO;
import com.devSuperior.dsVendas.Entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{


	@Query("SELECT new com.devSuperior.dsVendas.DTO.SaleSumDTO(obj.seller, SUM(obj.amount))"
			+ " FROM Sale as obj"
			+ " GROUP BY obj.seller")
	List<SaleSumDTO> amountSumPerSaller();
	
	

	@Query("SELECT new com.devSuperior.dsVendas.DTO.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals))"
			+ " FROM Sale as obj"
			+ " GROUP BY obj.seller")
	List<SaleSuccessDTO> successPerSaller();
	
}
