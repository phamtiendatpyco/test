package test3.payment.impl;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;

public class AmountDiscountCalculatorTest {

  @Test
  public void testCalculateAmountDiscountSuccessfully() {
    // Given
    AmountDiscountCalculator amountDiscountCalculator = new AmountDiscountCalculator();

    // When
    BigDecimal amountDiscountPrice = amountDiscountCalculator.calculateDiscount(BigDecimal.valueOf(990));

    // Then
    Assert.assertEquals(BigDecimal.valueOf(945), amountDiscountPrice);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCalculateAmountDiscountWithNegativeInput() {
    // Given
    AmountDiscountCalculator amountDiscountCalculator = new AmountDiscountCalculator();

    // When
    BigDecimal amountDiscountPrice = amountDiscountCalculator.calculateDiscount(BigDecimal.valueOf(-990));
  }

}
