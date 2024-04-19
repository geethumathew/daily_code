
package com.aldermore.test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.aldermore.test.core.model.ProductCategory;
import com.aldermore.test.core.model.ProductVariant;
import com.aldermore.test.core.services.ProductVariantService;
import com.aldermore.test.web.ProductVariantsController;

@ExtendWith(MockitoExtension.class)
public class ProductVariantControllerTest {
	private static final UUID PRODUCT_VARIANT_ID = UUID.fromString("4d52e8aa-c16a-4834-941b-3e65942c3a71");
	private static final UUID ANOTHER_PRODUCT_VARIANT_ID = UUID.fromString("7da2c423-cf58-4a3b-a62d-1648bec3b311");
	private static final String PRODUCT_VARIANT_NAME = "a product variant";
	private static final String ANOTHER_PRODUCT_VARIANT_NAME = "another product variant";
	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private static final LocalDate A_START_DATE = LocalDate.parse("2023-10-01", DATE_FORMATTER);
	private static final LocalDate AN_END_DATE = LocalDate.parse("2023-11-01", DATE_FORMATTER);
	private static final UUID YET_ANOTHER_PRODUCT_VARIANT_ID = UUID.fromString("279dfb8b-562a-4635-91a3-afb77078f0e2");
	private static final String YET_ANOTHER_PRODUCT_VARIANT_NAME = "yet another product variant";
	private static final LocalDate ANOTHER_START_DATE = LocalDate.parse("2023-10-31", DATE_FORMATTER);

	@Mock
	ProductVariantService service;
	@InjectMocks
	ProductVariantsController controller;

	@Test
	public void testShouldReturnAllProductVariants() {
		List<ProductVariant> expected = List.of(aProductVariant(), anotherProductVariant(), yetAnotherProductVariant());
		given(service.getAll()).willReturn(expected);
		assertThat(expected).asList().isEqualTo(controller.getAllProductVariants());
	}

	@Test
	public void testgetname() {
		String testName = "a product variant";
		List<ProductVariant> result = service.getname(testName);
		for (ProductVariant variant : result) {
			assertThat(testName).isEqualTo(variant.getName());

		}

	}

	@Test
	public void testgetnames() {
		String testName = "4111111111111111";
		given(service.isValid(testName)).willReturn(true);
		assertTrue(controller.getvalidnames(testName));
	}

	@Test
	public void testgetnamesINVALID() {
		String testName = "41111111111111167";
		given(service.isValid(testName)).willReturn(false);
		assertFalse(controller.getvalidnames(testName), "Expected valid credit card number");
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
