package com.prog.matoz.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.prog.matoz.data.vo.ProductVO;
import com.prog.matoz.repository.ProductMocks;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class ProductService {

	public ProductVO create(ProductVO productVO) {
		return productVO;
	}

	public ProductVO findById(Long id) {
		return ProductMocks.findById();
	}
	
	public Page<ProductVO> findAll(Pageable pageable) {
		var products = ProductMocks.findAll();
		
		return new PageImpl<>(products);
	}

	public ProductVO update(ProductVO productVO) {
		final ProductVO currentProduct = findById(productVO.getId());

		Optional.ofNullable(productVO.getName()).ifPresent(val -> currentProduct.setName(val));
		Optional.ofNullable(productVO.getPrice()).ifPresent(val -> currentProduct.setPrice(val));
		Optional.ofNullable(productVO.getStock()).ifPresent(val -> currentProduct.setStock(val));

		return productVO;
	}

	public void delete(Long id) {
		return;
	}

}
