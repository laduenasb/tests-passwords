package org.example.player;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

  @Test
  public void losses_when_dice_number_is_too_low() {
    // Dado real pero no queremos que al lanzar el dado nos devuelva algo aleatorio porque sera dificil hacer pruebas
    //Dice dice = new Dice(6);
    // Dado simulado para simular el resultado de lanzar el dado
    Dice dice = Mockito.mock(Dice.class);
    Mockito.when(dice.roll()).thenReturn(2);
    Player player = new Player(dice, 2);
    assertFalse(player.play());
  }

  @Test
  public void win_when_dice_number_is_big() {
    Dice dice = Mockito.mock(Dice.class);
    Mockito.when(dice.roll()).thenReturn(4);
    Player player = new Player(dice, 3);
    assertTrue(player.play());
  }
}