package jeroquest.units;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Barbarian extends Hero {
  protected static final int MOVEMENT = 7;
  
  protected static final int ATTACK = 1;
  
  protected static final int DEFENCE = 2;
  
  protected static final int BODY = 8;
  
  public Barbarian(String name, String player) {
    super(name, 7, 1, 2, 8, player, new Weapon("Broadsword", 3));
  }
  
  public char toChar() {
    return 'B';
  }
  
  private static Icon icon = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/barbarian.gif"));
  
  public Icon getImage() {
    return icon;
  }
}