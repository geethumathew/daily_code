package com.aldermore.test.core.model;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data

@Setter
@Getter
public class ProductVariant {
	private final UUID id;
	private final String name;
	private final ProductCategory category;
	private final LocalDate validityStartDate;
	private final LocalDate validityEndDate;

	public ProductVariant(UUID id, String name, ProductCategory category, LocalDate validityStartDate,
			LocalDate validityEndDate) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.validityStartDate = validityStartDate;
		this.validityEndDate = validityEndDate;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public LocalDate getValidityStartDate() {
		return validityStartDate;
	}

	public LocalDate getValidityEndDate() {
		return validityEndDate;
	}

}
