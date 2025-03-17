package jeroquest.units;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Dwarf extends Hero {
  protected static final int MOVEMENT = 6;
  
  protected static final int ATTACK = 1;
  
  protected static final int DEFENCE = 2;
  
  protected static final int BODY = 7;
  
  public Dwarf(String name, String player) {
    super(name, 6, 1, 2, 7, player, new Weapon("Hand axe", 2));
  }
  
  public char toChar() {
    return 'D';
  }
  
  private static Icon icon = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/dwarf.gif"));
  
  public Icon getImage() {
    return icon;
  }
}
