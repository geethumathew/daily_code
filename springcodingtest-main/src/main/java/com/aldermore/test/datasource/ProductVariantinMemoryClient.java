package com.aldermore.test.datasource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.aldermore.test.core.client.ProductVariantClient;
import com.aldermore.test.core.model.ProductCategory;
import com.aldermore.test.core.model.ProductVariant;

@Component
public class ProductVariantinMemoryClient implements ProductVariantClient {

	private static final UUID PRODUCT_VARIANT_ID = UUID.fromString("4d52e8aa-c16a-4834-941b-3e65942c3a71");
	private static final UUID ANOTHER_PRODUCT_VARIANT_ID = UUID.fromString("7da2c423-cf58-4a3b-a62d-1648bec3b311");
	private static final UUID YET_ANOTHER_PRODUCT_VARIANT_ID = UUID.fromString("279dfb8b-562a-4635-91a3-afb77078f0e2");

	private static final String PRODUCT_VARIANT_NAME = "a product variant";
	private static final String ANOTHER_PRODUCT_VARIANT_NAME = "another product variant";
	private static final String YET_ANOTHER_PRODUCT_VARIANT_NAME = "yet another product variant";
	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private static final LocalDate A_START_DATE = LocalDate.parse("2024-12-01", DATE_FORMATTER);
	private static final LocalDate ANOTHER_START_DATE = LocalDate.parse("2023-10-31", DATE_FORMATTER);
	private static final LocalDate AN_END_DATE = LocalDate.parse("2023-11-01", DATE_FORMATTER);

	@Override
	public List<ProductVariant> getAll() {
		return List.of(aProductVariant(), anotherProductVariant(), yetAnotherProductVariant());
	}

	private static ProductVariant aProductVariant() {
		return new ProductVariant(PRODUCT_VARIANT_ID, PRODUCT_VARIANT_NAME, ProductCategory.BUY_TO_LET, A_START_DATE,
				AN_END_DATE);
	}

	private static ProductVariant anotherProductVariant() {
		return new ProductVariant(ANOTHER_PRODUCT_VARIANT_ID, ANOTHER_PRODUCT_VARIANT_NAME,
				ProductCategory.PRIVATE_OWNERSHIP, A_START_DATE, null);
	}

	private static ProductVariant yetAnotherProductVariant() {
		return new ProductVariant(YET_ANOTHER_PRODUCT_VARIANT_ID, YET_ANOTHER_PRODUCT_VARIANT_NAME, null,
				ANOTHER_START_DATE, null);
	}

}
