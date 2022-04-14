package com.webdev.productsystem.Users.User.Domain.Entities;

import com.webdev.productsystem.Tours.City.Domain.City;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityCountry;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityId;
import com.webdev.productsystem.Tours.City.Domain.ValueObjects.CityName;
import com.webdev.productsystem.Users.User.Domain.Exceptions.InvalidString;
import com.webdev.productsystem.Users.User.Domain.Phone.Domain.ValueObjects.PhoneCountryCode;
import com.webdev.productsystem.Users.User.Domain.Phone.Domain.ValueObjects.PhoneId;
import com.webdev.productsystem.Users.User.Domain.Phone.Domain.ValueObjects.PhoneNumber;
import com.webdev.productsystem.Users.User.Domain.ValueObjects.UserId;

import java.util.HashMap;


public class Phone{

  private PhoneId phoneId;
  private PhoneCountryCode phoneCountryCode;
  private PhoneNumber phoneNumber;
  private UserId userId;

  public Phone(PhoneId phoneId,  PhoneCountryCode phoneCountryCode, PhoneNumber phoneNumber, UserId userId) {
      this.phoneId = phoneId;
      this.phoneCountryCode = phoneCountryCode;
      this.phoneNumber = phoneNumber;
      this.userId = userId;
  }
    public static Phone create(PhoneId phoneId, PhoneCountryCode phoneCountryCode, PhoneNumber phoneNumber, UserId userId){
        Phone phone = new Phone(phoneId, phoneCountryCode, phoneNumber, userId);
        return phone;
    }
    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("phoneId", phoneId.value());
            put("phoneCountryCode", phoneCountryCode.value());
            put("phoneNumber", phoneNumber.value());
        }};
    }
  
}
