package org.example.util;

public class PasswordUtil {

  public enum SecurityLevel {
    WEAK, MEDIUM, STRONG
  }
  public static SecurityLevel assessPassword(String password) {

    if(password.length() < 8){
      return SecurityLevel.WEAK;
    }

    if(password.matches("[a-zA-Z]+")){
      return SecurityLevel.WEAK;
    }

    if(password.matches("[a-zA-Z0-9]+")){
      return SecurityLevel.MEDIUM;
    }

    return SecurityLevel.STRONG;
  }

  public static class Main {
    public static void main(String[] args) {
      System.out.println("Hello world!");
    }
  }
}
