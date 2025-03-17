package jeroquest.units;

public class Weapon {
  private String name;
  
  private int attack;
  
  public Weapon(String name, int attack) {
    this.name = name;
    this.attack = attack;
  }
  
  public String getName() {
    return this.name;
  }
  
  public int getAttack() {
    return this.attack;
  }
  
  public String toString() {
    return String.valueOf(this.name) + " (" + this.attack + " dices)";
  }
}
