package com.webdev.productsystem.Users.User.Domain.Entities;

import com.webdev.productsystem.Users.User.Domain.Exceptions.InvalidString;
import com.webdev.productsystem.Users.User.Domain.ValueObjects.UserId;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserData{

  private String userName;
  private String userLastname;
  private String userBirthday;
  private String userGender;
  private UserId userId;

  public UserData(String userName,  String userLastname, String userGender, String userBirthday, UserId userId) {
      this.userName = userName;
      this.userLastname = userLastname;
      this.userBirthday = userBirthday;
      this.userGender = userGender;
      this.userId = userId;
  }
  private void validateString(String value) {
      stringFormat(value);
  }

  private void stringFormat(String value) {
    Pattern pat = Pattern.compile("[a-zA-Z]+");
    Matcher mat = pat.matcher(value);
    if (mat.matches()) {
   } else {
        throw new InvalidString("No válido");
    }
  }

}
