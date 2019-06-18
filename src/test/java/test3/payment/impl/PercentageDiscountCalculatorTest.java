package test3.payment.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import test3.enums.ProductType;
import test3.model.Bill;
import test3.model.Product;
import test3.model.User;

public class PercentageDiscountCalculatorTest {

  @Test
  public void testCalculatePercentageDiscountSuccessfully() {
    // Given
    PercentageDiscountCalculator percentageDiscountCalculator = new PercentageDiscountCalculator();
    Bill bill = new Bill();
    bill.setUser(new User("test", LocalDate.now(), true, false));
    List<Product> products = new ArrayList<>();
    products.add(new Product(BigDecimal.valueOf(100), ProductType.OTHERS));
    products.add(new Product(BigDecimal.valueOf(300), ProductType.GROCERY));
    bill.setProducts(products);

    // When
    BigDecimal percentagePriceDiscount = percentageDiscountCalculator.calculateDiscount(bill);

    // Then
    Assert.assertEquals(BigDecimal.valueOf(370.0), percentagePriceDiscount);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCalculatePercentageDiscountWithNegativeInput() {
    // Given
    PercentageDiscountCalculator percentageDiscountCalculator = new PercentageDiscountCalculator();
    Bill bill = new Bill();
    bill.setUser(new User("test", LocalDate.now(), true, false));
    List<Product> products = new ArrayList<>();
    products.add(new Product(BigDecimal.valueOf(-100), ProductType.OTHERS));
    bill.setProducts(products);

    // When
    BigDecimal amountDiscountPrice = percentageDiscountCalculator.calculateDiscount(bill);
  }
}
