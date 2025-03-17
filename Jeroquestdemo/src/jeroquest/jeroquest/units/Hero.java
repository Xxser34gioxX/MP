package jeroquest.units;

import jeroquest.boardgame.Dice;

public abstract class Hero extends Character {
  private String playerName;
  
  private Weapon weapon;
  
  public Hero(String name, int movement, int attack, int defence, int body, String player, Weapon weapon) {
    super(name, movement, attack, defence, body);
    setPlayerName(player);
    setWeapon(weapon);
  }
  
  public Weapon getWeapon() {
    return this.weapon;
  }
  
  public int getAttack() {
    if (getWeapon() != null)
      return getWeapon().getAttack(); 
    return super.getAttack();
  }
  
  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }
  
  public int defend(int impacts) {
    int wounds = 0;
    for (int totalDefenceDices = getDefence(); impacts > 0 && totalDefenceDices > 0; totalDefenceDices--) {
      if (Dice.roll() > 4)
        impacts--; 
    } 
    if (impacts > 0) {
      wounds = Math.min(getBody(), impacts);
      setBody(getBody() - wounds);
    } 
    return wounds;
  }
  
  public String getPlayerName() {
    return this.playerName;
  }
  
  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }
  
  public boolean isEnemy(Character c) {
    return c instanceof Monster;
  }
  
  public String toString() {
    String s = super.toString();
    if (this.weapon != null)
      s = String.valueOf(s) + " Armed with " + this.weapon.toString(); 
    return s;
  }
}