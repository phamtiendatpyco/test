package test3.model;

import java.time.LocalDate;

public class User {

  private String username;
  private LocalDate createdDate;
  private boolean employee;
  private boolean affiliate;

  public User(final String username, final LocalDate createdDate, final boolean employee, final boolean affiliate) {
    this.username = username;
    this.createdDate = createdDate;
    this.employee = employee;
    this.affiliate = affiliate;
  }

  public String getUsername() {
    return username;
  }

  public LocalDate getCreatedDate() {
    return createdDate;
  }

  public boolean isEmployee() {
    return employee;
  }

  public boolean isAffiliate() {
    return affiliate;
  }
}
