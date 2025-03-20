package jeroquest.logic;

import jeroquest.boardgame.Dice;
import jeroquest.boardgame.Piece;
import jeroquest.boardgame.Position;
import jeroquest.gui.GraphicalPiece;
import jeroquest.gui.JeroquestWindow;
import jeroquest.gui.MyKeyboard;
import jeroquest.units.Character;

public class Controller {
  private static final Controller INSTANCE = new Controller();
  
  private Game currentGame;
  
  private static JeroquestWindow monitor;
  
  public static Controller getInstance() {
    return INSTANCE;
  }
  
  public Game getCurrentGame() {
    return this.currentGame;
  }
  
  public void toPlay() {
    monitor = new JeroquestWindow(this.currentGame);
    System.out.println("START OF THE GAME");
    System.out.println(this.currentGame);
    MyKeyboard.pressEnter();
    while (noEndOfGame()) {
      resolveRound();
      System.out.println(this.currentGame);
      MyKeyboard.pressEnter();
      nextRound();
    } 
    System.out.println("END OF THE GAME");
    System.out.println("Winners: " + highestBody());
    MyKeyboard.pressEnter();
    monitor.close();
  }
  
  public void newGame(int numHeroes, int numMonsters, int rows, int columns, int totalRounds) {
    this.currentGame = new Game(numHeroes, numMonsters, rows, columns, totalRounds);
    placeCharacters();
  }
  
  private void nextRound() {
    this.currentGame.setCurrentRound(this.currentGame.getCurrentRound() + 1);
    monitor.updateRoundLabel();
  }
  
  private boolean noEndOfGame() {
    return (this.currentGame.getCurrentRound() <= this.currentGame.getTotalRounds() && opponentsLeft());
  }
  
  private void resolveRound() {
    System.out.println("Round: " + this.currentGame.getCurrentRound());
    for (int x = 0; x < (this.currentGame.getCharacters()).length && opponentsLeft(); x++) {
      Character c = this.currentGame.getCharacters()[x];
      if (c.isAlive())
        c.resolveTurn(); 
    } 
  }
  
  private void placeCharacters() {
    int rows = this.currentGame.getBoard().getRows();
    int columns = this.currentGame.getBoard().getColumns();
    byte b;
    int i;
    Character[] arrayOfCharacter;
    for (i = (arrayOfCharacter = this.currentGame.getCharacters()).length, b = 0; b < i; ) {
      Character p = arrayOfCharacter[b];
      int row = Dice.roll(rows) - 1;
      int col = Dice.roll(columns) - 1;
      while (!this.currentGame.getBoard().movePiece((Piece)p, new Position(row, col))) {
        row = Dice.roll(rows) - 1;
        col = Dice.roll(columns) - 1;
      } 
      b++;
    } 
  }
  
  private String highestBody() {
    int cHeroes = 0;
    int cMonsters = 0;
    byte b;
    int i;
    Character[] arrayOfCharacter;
    for (i = (arrayOfCharacter = this.currentGame.getCharacters()).length, b = 0; b < i; ) {
      Character c = arrayOfCharacter[b];
      if (c instanceof jeroquest.units.Hero) {
        cHeroes += c.getBody();
      } else if (c instanceof jeroquest.units.Monster) {
        cMonsters += c.getBody();
      } 
      b++;
    } 
    if (cMonsters > cHeroes)
      return "Monsters"; 
    if (cHeroes > cMonsters)
      return "Heroes"; 
    return "Draw";
  }
  
  public boolean opponentsLeft() {
    boolean heroesAlive = false;
    boolean monstersAlive = false;
    int x = 0;
    while (x < (this.currentGame.getCharacters()).length && (!heroesAlive || !monstersAlive)) {
      if (this.currentGame.getCharacters()[x].isAlive())
        if (this.currentGame.getCharacters()[x] instanceof jeroquest.units.Hero) {
          heroesAlive = true;
        } else if (this.currentGame.getCharacters()[x] instanceof jeroquest.units.Monster) {
          monstersAlive = true;
        }  
      x++;
    } 
    return (heroesAlive && monstersAlive);
  }
  
  public void updateGraphicalPiece(GraphicalPiece graphicalPiece, String message, boolean waitForEnter) {
    if (monitor != null)
      monitor.updateGraphicalPiece(graphicalPiece, message); 
    if (message.length() > 0)
      System.out.println(message); 
    if (waitForEnter)
      MyKeyboard.pressEnter(); 
  }
  
  public void updateGraphicalPiece(GraphicalPiece graphicalPiece, String message) {
    updateGraphicalPiece(graphicalPiece, message, false);
  }
}