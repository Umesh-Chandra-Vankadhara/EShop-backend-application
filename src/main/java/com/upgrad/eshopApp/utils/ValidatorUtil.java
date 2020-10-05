package com.upgrad.eshopApp.utils;

public class ValidatorUtil {

  public static boolean isValid(String email) {
    String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    return email.matches(regex);
  }
}
