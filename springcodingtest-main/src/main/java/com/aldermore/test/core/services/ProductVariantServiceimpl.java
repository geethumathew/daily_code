package com.aldermore.test.core.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aldermore.test.core.client.ProductVariantClient;
import com.aldermore.test.core.model.ProductCategory;
import com.aldermore.test.core.model.ProductVariant;

@Service
public class ProductVariantServiceimpl implements ProductVariantService {

	@Autowired
	private ProductVariantClient productVariantClient;
	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private static final LocalDate datenow = LocalDate.parse("2024-11-01", DATE_FORMATTER);

	@Override
	public List<ProductVariant> getAll() {
		// TODO Auto-generated method stub
		return productVariantClient.getAll();
	}

	@Override
	public List<ProductVariant> getAllavailbelproducts() {

		List<ProductVariant> availableProducts = new ArrayList<>();

		for (ProductVariant productVariant : getAll()) {
			if (productVariant.getValidityStartDate().isAfter(datenow)
					|| productVariant.getValidityStartDate().isEqual(datenow)) {
				availableProducts.add(productVariant);
			}
		}

		return availableProducts;
	}

	@Override
	public List<ProductVariant> getAllcategory(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		List<ProductVariant> list = new ArrayList<>();
		for (ProductVariant variant : getAll()) {
			if (variant.getCategory() == productCategory) {
				list.add(variant); // Add the product variant to the filtered list
			}
		}

		return list; // Return the list of product variants filtered by category
	}

	@Override
	public List<ProductVariant> getname(String name) {
		// TODO Auto-generated method stub
		List<ProductVariant> list1 = new ArrayList<>();

		// Populate the list with product variants
		list1.addAll(getAll());

		// Filter the list based on the name
		List<ProductVariant> filteredList = list1.stream()
				.filter(productVariant -> productVariant.getName().equals(name)).collect(Collectors.toList());

		return filteredList;
	}

	@Override
	public Boolean isValid(String names) {
		// TODO Auto-generated method stub
		int sum = 0;
		boolean doubleDigit = false;

		for (int i = names.length() - 1; i >= 0; i--) {
			int digit = Character.getNumericValue(names.charAt(i));

			if (doubleDigit) {
				digit *= 2;
				if (digit > 9) {
					digit -= 9;
				}
			}

			sum += digit;
			doubleDigit = !doubleDigit;
		}

		return sum % 10 == 0;
	}
}
