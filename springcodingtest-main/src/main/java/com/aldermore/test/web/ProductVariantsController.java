package com.aldermore.test.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aldermore.test.core.model.ProductCategory;
import com.aldermore.test.core.model.ProductVariant;
import com.aldermore.test.core.services.ProductVariantService;

@RestController
@RequestMapping("/product-variants")
public class ProductVariantsController {
	@Autowired
	private final ProductVariantService service;

	public ProductVariantsController(ProductVariantService service) {
		this.service = service;
	}

	@GetMapping("")
	public List<ProductVariant> getAllProductVariants() {
		return service.getAll();
	}

	@GetMapping("/avaliable")
	public List<ProductVariant> getAllavalableProductVariants() {
		return service.getAllavailbelproducts();
	}

	@GetMapping("/{category}")
	public List<ProductVariant> getcategory(@PathVariable ProductCategory category) {
		return service.getAllcategory(category);
	}

	@GetMapping("/name/{name}")
	public List<ProductVariant> getnames(@PathVariable String name) {
		return service.getname(name);
	}

	@GetMapping("/name/{names}")
	public Boolean getvalidnames(@PathVariable String names) {
		return service.isValid(names);
	}
}
