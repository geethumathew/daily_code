package com.aldermore.test.core.services;

import java.util.List;

import com.aldermore.test.core.model.ProductCategory;
import com.aldermore.test.core.model.ProductVariant;

public interface ProductVariantService {

	List<ProductVariant> getAll();

	List<ProductVariant> getAllavailbelproducts();

	List<ProductVariant> getAllcategory(ProductCategory productCategory);

	List<ProductVariant> getname(String name);

	Boolean isValid(String names);

}
