package com.webdev.productsystem.Users.Phone.Domain;

import com.webdev.productsystem.Shared.Domain.Aggregate.AggregateRoot;
import com.webdev.productsystem.Users.Phone.Domain.DomainEvents.PhoneCreatedDomainEvent;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneCountryCode;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneId;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.PhoneNumber;
import com.webdev.productsystem.Users.Phone.Domain.ValueObjects.UserId;

import java.util.HashMap;


public class Phone extends AggregateRoot {

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
        phone.record(new PhoneCreatedDomainEvent(phoneId.value(), phoneCountryCode.value(), phoneNumber.value()));


        return phone;
    }
    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("phoneId", phoneId.value());
            put("phoneCountryCode", phoneCountryCode.value());
            put("phoneNumber", phoneNumber.value());
            put("userId", userId.value());
        }};
    }
    public PhoneId getPhoneId() {
        return phoneId;
    }
    public UserId getUserId() {
        return userId;
    }
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
    public PhoneCountryCode getPhoneCountryCode() {
        return phoneCountryCode;
    }
    public void updatePhoneNumber(PhoneNumber phoneNumber){
      this.phoneNumber = phoneNumber;
    }
    public void updatePhoneCountryCode(PhoneCountryCode phoneCountryCode){
        this.phoneCountryCode = phoneCountryCode;
    }


}
