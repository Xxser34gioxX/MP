package jeroquest.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;
import jeroquest.boardgame.Position;
import jeroquest.units.Character;

public class MyJLabelCharacter extends JLabel {
  private static final long serialVersionUID = 1L;
  
  private Character character;
  
  public Character getCharacter() {
    return this.character;
  }
  
  public MyJLabelCharacter(Character character) {
    super(character.getImage());
    this.character = character;
    Position pos = character.getPosition();
    setBounds(pos.getCol() * 32, pos.getRow() * 32, 32, 
        32);
    setToolTipText(MyPanelBoard.convertToMultiline(character.toString()));
  }
  
  private void lifeBar(Graphics g, int currentValue, int maximum) {
    int width = Math.round((currentValue * 32 / maximum));
    g.setColor(Color.WHITE);
    g.drawRect(0, 28, 31, 3);
    g.setColor(Color.BLACK);
    g.fillRect(1, 29, 30, 2);
    if (this.character.getBody() > 0.75D * this.character.getMaxBody()) {
      g.setColor(Color.GREEN);
    } else if (this.character.getBody() > 0.5D * this.character.getMaxBody()) {
      g.setColor(Color.YELLOW);
    } else {
      g.setColor(Color.RED);
    } 
    g.fillRect(1, 29, width - 2, 2);
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (this.character.getPosition() != null) {
      setIcon(this.character.getImage());
      Position pos = this.character.getPosition();
      setBounds(pos.getCol() * 32, pos.getRow() * 32, 32, 
          32);
      setToolTipText(MyPanelBoard.convertToMultiline(this.character.toString()));
      lifeBar(g, this.character.getBody(), this.character.getMaxBody());
    } else {
      setVisible(false);
    } 
  }
}