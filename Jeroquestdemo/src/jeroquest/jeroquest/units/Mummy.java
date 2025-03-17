package jeroquest.units;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Mummy extends Monster {
  protected static final int MOVEMENT = 4;
  
  protected static final int ATTACK = 3;
  
  protected static final int DEFENCE = 4;
  
  protected static final int BODY = 2;
  
  public Mummy(String name) {
    super(name, 4, 3, 4, 2);
  }
  
  public char toChar() {
    return 'M';
  }
  
  private static Icon icon = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/mummy.gif"));
  
  public Icon getImage() {
    return icon;
  }
}
