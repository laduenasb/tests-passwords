package org.example;

import org.junit.jupiter.api.Test;

import static org.example.PasswordUtil.SecurityLevel.*;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordUtilTest {

  @Test
  public void weak_when_has_less_than_8_letters() {
    assertEquals(WEAK, PasswordUtil.assessPassword("123asb!"));
  }

  @Test
  public void weak_when_has_only_letters() {
    assertEquals(WEAK, PasswordUtil.assessPassword("abcdefgh"));
  }

  @Test
  public void medium_when_has_letters_and_numbers() {
    assertEquals(MEDIUM, PasswordUtil.assessPassword("abxgdvcc12345789"));
  }
  @Test
  public void strong_when_has_letters_numbers_and_symbols() {
    assertEquals(STRONG, PasswordUtil.assessPassword("abce1234875!"));
  }
}