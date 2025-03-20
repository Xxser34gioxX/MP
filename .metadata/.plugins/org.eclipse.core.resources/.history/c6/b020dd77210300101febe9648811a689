package jeroquest.gui;

import javax.swing.JFrame;
import jeroquest.logic.Game;

public class JeroquestWindow extends JFrame {
  private static final long serialVersionUID = 1L;
  
  private MyPanelBoard panel = null;
  
  public JeroquestWindow(Game theGame) {
    super("Monitor Jeroquest");
    this.panel = new MyPanelBoard(theGame);
    setDefaultCloseOperation(3);
    add(this.panel);
    pack();
    setResizable(false);
    setVisible(true);
    setAlwaysOnTop(true);
  }
  
  public void close() {
    dispose();
  }
  
  public void updateRoundLabel() {
    this.panel.updateRoundLabel();
  }
  
  public void updateGraphicalPiece(GraphicalPiece graphicalPiece, String message) {
    this.panel.updateGraphicalPiece(graphicalPiece, message);
  }
}
