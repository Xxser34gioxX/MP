package jeroquest.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import jeroquest.logic.Game;
import jeroquest.units.Character;

public class MyPanelBoard extends JLayeredPane {
  private static final long serialVersionUID = 1L;
  
  protected static final int LENGTH = 32;
  
  private Map<GraphicalPiece, Component> map;
  
  private Game theGame = null;
  
  private Icon square = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/square.png"));
  
  private JLabel currentRoundJLabel = null;
  
  private JLabel statusBarJLabel = null;
  
  public MyPanelBoard(Game g) {
    this.map = new HashMap<>();
    this.theGame = g;
    initialiseBoard(g.getBoard().getRows(), g.getBoard().getColumns());
  }
  
  private void initialiseBoard(int rows, int columns) {
    setPreferredSize(new Dimension(32 * (1 + columns), 32 * (3 + rows)));
    Integer integer;
    for (integer = Integer.valueOf(0); integer.intValue() < columns; integer = Integer.valueOf(integer.intValue() + 1)) {
      JLabel label = new JLabel(integer.toString());
      label.setBounds(16 + integer.intValue() * 32, rows * 32, 32, 32);
      add(label, Integer.valueOf(1));
    } 
    for (integer = Integer.valueOf(0); integer.intValue() < rows; integer = Integer.valueOf(integer.intValue() + 1)) {
      JLabel label = new JLabel(integer.toString());
      label.setBounds(16 + columns * 32, integer.intValue() * 32, 32, 32);
      add(label, Integer.valueOf(1));
    } 
    for (int x = 0; x < rows; x++) {
      for (int y = 0; y < columns; y++) {
        JLabel c = new JLabel(this.square);
        c.setBounds(y * 32, x * 32, 32, 32);
        add(c, Integer.valueOf(1));
      } 
    } 
    this.currentRoundJLabel = new JLabel(
        "Round: " + this.theGame.getCurrentRound() + "/" + this.theGame.getTotalRounds());
    this.currentRoundJLabel.setBounds(16, (rows + 1) * 32, 128, 32);
    add(this.currentRoundJLabel, Integer.valueOf(1));
    this.statusBarJLabel = new JLabel();
    this.statusBarJLabel.setBounds(16, (rows + 2) * 32, 600, 32);
    add(this.statusBarJLabel, Integer.valueOf(1));
    initialiseCharacters();
  }
  
  public static String convertToMultiline(String orig) {
    return "<html>" + orig.replaceAll("\n", "<br>") + "</html>";
  }
  
  public void updateRoundLabel() {
    this.currentRoundJLabel.setText("Round: " + this.theGame.getCurrentRound() + "/" + this.theGame.getTotalRounds());
  }
  
  private void initialiseCharacters() {
    this.currentRoundJLabel.setText("Round: " + this.theGame.getCurrentRound() + "/" + this.theGame.getTotalRounds());
    for (Component comp : this.map.values())
      remove(comp); 
    this.map = new HashMap<>();
    byte b;
    int i;
    Character[] arrayOfCharacter;
    for (i = (arrayOfCharacter = this.theGame.getCharacters()).length, b = 0; b < i; ) {
      Character cj = arrayOfCharacter[b];
      if (cj.getPosition() != null) {
        JLabel lab = new MyJLabelCharacter(cj);
        this.map.put(cj, lab);
        add(lab, Integer.valueOf(2));
      } 
      b++;
    } 
    validate();
    repaint();
  }
  
  public void updateGraphicalPiece(GraphicalPiece graphicalPiece, String message) {
    if (message.length() > 0)
      this.statusBarJLabel.setText(message); 
    if (graphicalPiece != null) {
      Component comp = this.map.get(graphicalPiece);
      comp.repaint();
    } 
  }
}