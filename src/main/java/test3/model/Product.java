package test3.model;

import java.math.BigDecimal;
import test3.enums.ProductType;

public class Product {

  private BigDecimal price;
  private ProductType productType;

  public Product(final BigDecimal price, final ProductType productType) {
    this.price = price;
    this.productType = productType;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(final BigDecimal price) {
    this.price = price;
  }

  public ProductType getProductType() {
    return productType;
  }

  public void setProductType(final ProductType productType) {
    this.productType = productType;
  }
}
