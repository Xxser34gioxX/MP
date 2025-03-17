package jeroquest.units;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Goblin extends Monster {
  protected static final int MOVEMENT = 10;
  
  protected static final int ATTACK = 2;
  
  protected static final int DEFENCE = 1;
  
  protected static final int BODY = 1;
  
  public Goblin(String name) {
    super(name, 10, 2, 1, 1);
  }
  
  public char toChar() {
    return 'G';
  }
  
  private static Icon icon = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/goblin.png"));
  
  public Icon getImage() {
    return icon;
  }
}
