package test3.enums;

public enum PercentageDiscountType {

  EMPLOYEE(0.3), AFFILIATE(0.1), LOYAL_CUSTOMER(0.05), GROCERY(0), NON(0);

  private double discount;

  PercentageDiscountType(final double discount) {
    this.discount = discount;
  }

  public double getDiscount() {
    return discount;
  }
}
