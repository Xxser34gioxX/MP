package jeroquest.units;

import jeroquest.boardgame.Dice;

public abstract class Monster extends Character {
  public Monster(String name, int movement, int attack, int defence, int body) {
    super(name, movement, attack, defence, body);
  }
  
  public int defend(int impacts) {
    int wounds = 0;
    for (int totalDefenceDices = getDefence(); impacts > 0 && totalDefenceDices > 0; totalDefenceDices--) {
      if (Dice.roll() == 6)
        impacts--; 
    } 
    if (impacts > 0) {
      wounds = Math.min(getBody(), impacts);
      setBody(getBody() - wounds);
    } 
    return wounds;
  }
  
  public boolean isEnemy(Character c) {
    return c instanceof Hero;
  }
}
