package com.webdev.productsystem.Users.User.Domain.Entities;

import com.webdev.productsystem.Users.User.Domain.Exceptions.InvalidString;
import com.webdev.productsystem.Users.User.Domain.ValueObjects.UserId;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phone{

  private Integer PhoneId;
  private Integer PhoneCountryCode;
  private Integer PhoneNumber;
  private UserId userId;

  public Phone(Integer PhoneId,  Integer PhoneCountryCode, Integer PhoneNumber, UserId userId) {
      this.PhoneId = PhoneId;
      this.PhoneCountryCode = PhoneCountryCode;
      this.PhoneNumber = PhoneNumber;
      this.userId = userId;
  }
  
}
