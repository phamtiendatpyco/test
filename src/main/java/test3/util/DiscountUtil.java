package test3.util;

import static test3.util.DateUtil.isOverTwoYear;

import java.math.BigDecimal;
import test3.enums.PercentageDiscountType;
import test3.enums.ProductType;
import test3.model.Product;
import test3.model.User;

public class DiscountUtil {

  private DiscountUtil() {
    throw new UnsupportedOperationException("Constructor is not allow for this object");
  }

  public static BigDecimal getPercentageDiscountPrice(User user, Product product) {
    if (isNegativeNumber(product.getPrice())) {
      throw new IllegalArgumentException("Price is not allowed as a negative number!");
    }
    final PercentageDiscountType percentageDiscountType = getDiscountType(user, product);
    final BigDecimal discountPrice = product.getPrice().multiply(BigDecimal.valueOf(percentageDiscountType.getDiscount()));
    return product.getPrice().subtract(discountPrice);
  }

  private static PercentageDiscountType getDiscountType(User user, Product product) {
    if (ProductType.GROCERY == product.getProductType()) {
      return PercentageDiscountType.GROCERY;
    } else if (user.isEmployee()) {
      return PercentageDiscountType.EMPLOYEE;
    } else if (user.isAffiliate()) {
      return PercentageDiscountType.AFFILIATE;
    } else if (isOverTwoYear(user.getCreatedDate())) {
      return PercentageDiscountType.LOYAL_CUSTOMER;
    }
    return PercentageDiscountType.NON;
  }

  public static boolean isNegativeNumber(final BigDecimal price) {
    return price.compareTo(BigDecimal.ZERO) < 0;
  }
}
