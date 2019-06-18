package test3.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import test3.enums.ProductType;
import test3.model.Product;
import test3.model.User;

public class DiscountUtilTest {

  @Test
  public void getEmployeePercentageDiscountPrice() {
    // Given
    User user = new User("test", LocalDate.now(), true, false);
    Product product = new Product(BigDecimal.valueOf(100), ProductType.OTHERS);

    // When
    BigDecimal percentageDiscountPrice = DiscountUtil.getPercentageDiscountPrice(user, product);

    // Then
    Assert.assertEquals(BigDecimal.valueOf(70.0), percentageDiscountPrice);
  }

  @Test
  public void getAffiliatePercentageDiscountPrice() {
    // Given
    User user = new User("test", LocalDate.now(), false, true);
    Product product = new Product(BigDecimal.valueOf(100), ProductType.OTHERS);

    // When
    BigDecimal percentageDiscountPrice = DiscountUtil.getPercentageDiscountPrice(user, product);

    // Then
    Assert.assertEquals(BigDecimal.valueOf(90.0), percentageDiscountPrice);
  }

  @Test
  public void getLoyalPercentageDiscountPrice() {
    // Given
    User user = new User("test", LocalDate.of(2015, 1, 1), false, false);
    Product product = new Product(BigDecimal.valueOf(100), ProductType.OTHERS);

    // When
    BigDecimal percentageDiscountPrice = DiscountUtil.getPercentageDiscountPrice(user, product);

    // Then
    Assert.assertEquals(new BigDecimal("95.00"), percentageDiscountPrice);
  }

  @Test
  public void testIsNegativeNumber() {
    // When
    boolean negativeNumber = DiscountUtil.isNegativeNumber(BigDecimal.valueOf(-1));

    // Then
    Assert.assertTrue(negativeNumber);
  }
}
