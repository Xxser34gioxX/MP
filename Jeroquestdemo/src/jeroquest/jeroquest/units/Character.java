package jeroquest.units;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import jeroquest.boardgame.Dice;
import jeroquest.boardgame.Piece;
import jeroquest.boardgame.Position;
import jeroquest.gui.GraphicalPiece;
import jeroquest.logic.Controller;
import jeroquest.logic.Game;
import jeroquest.utils.DynamicVectorCharacters;
import jeroquest.utils.DynamicVectorPosition;

public abstract class Character implements Piece, GraphicalPiece {
  private int movement;
  
  private int attack;
  
  private int defence;
  
  private int body;
  
  private int maxMovement;
  
  private int maxAttack;
  
  private int maxDefence;
  
  private int maxBody;
  
  private String name;
  
  public Character(String name, int movement, int attack, int defence, int body) {
    setName(name);
    setMaxMovement(movement);
    setMaxAttack(attack);
    setMaxDefence(defence);
    setMaxBody(body);
    setMovement(movement);
    setAttack(attack);
    setDefence(defence);
    setBody(body);
    setPosition(null);
  }
  
  public int getMovement() {
    return this.movement;
  }
  
  public int getAttack() {
    return this.attack;
  }
  
  public int getDefence() {
    return this.defence;
  }
  
  public int getBody() {
    return this.body;
  }
  
  public int getMaxMovement() {
    return this.maxMovement;
  }
  
  protected void setMaxMovement(int maxMovement) {
    this.maxMovement = maxMovement;
  }
  
  public int getMaxAttack() {
    return this.maxAttack;
  }
  
  protected void setMaxAttack(int maxAttack) {
    this.maxAttack = maxAttack;
  }
  
  public int getMaxDefence() {
    return this.maxDefence;
  }
  
  protected void setMaxDefence(int maxDefence) {
    this.maxDefence = maxDefence;
  }
  
  public int getMaxBody() {
    return this.maxBody;
  }
  
  protected void setMaxBody(int maxBody) {
    this.maxBody = maxBody;
  }
  
  public String getName() {
    return this.name;
  }
  
  protected void setMovement(int movement) {
    this.movement = movement;
  }
  
  protected void setAttack(int attack) {
    this.attack = attack;
  }
  
  protected void setDefence(int defence) {
    this.defence = defence;
  }
  
  protected void setBody(int body) {
    this.body = body;
  }
  
  protected void setName(String name) {
    this.name = name;
  }
  
  public boolean isAlive() {
    return (this.body > 0);
  }
  
  public int attack() {
    int impacts = 0;
    for (int x = 0; x < getAttack(); x++) {
      if (Dice.roll() > 3)
        impacts++; 
    } 
    return impacts;
  }
  
  public void combat(Character c) {
    int impacts = attack();
    int wounds = c.defend(impacts);
    if (!c.isAlive())
      Controller.getInstance().getCurrentGame().getBoard().removePiece(c); 
    if (wounds > 0) {
      Controller.getInstance().updateGraphicalPiece(c, String.format("%s cannot block %d impacts%s", new Object[] { c.getName(), 
              Integer.valueOf(wounds), c.isAlive() ? "" : " and dies" }));
    } else {
      Controller.getInstance().updateGraphicalPiece(null, String.format("%s blocks the attack", new Object[] { c.getName() }));
    } 
  }
  
  public abstract int defend(int paramInt);
  
  public boolean isEnemy(Character c) {
    return (getClass() != c.getClass());
  }
  
  public boolean actionCombat() {
    DynamicVectorCharacters targets = validTargets();
    if (targets.length() > 0) {
      Character target = targets.get(Dice.roll(targets.length()) - 1);
      String message = String.format("%s %s attacks to %s %s", new Object[] { getName(), getPosition(), target.getName(), 
            target.getPosition() });
      Controller.getInstance().updateGraphicalPiece(null, message);
      combat(target);
      return true;
    } 
    return false;
  }
  
  public int actionMovement() {
    DynamicVectorPosition validPositions = validPositions();
    int steps = 0;
    while (validPositions.length() > 0 && steps < getMovement()) {
      Position newPosition = validPositions.get(Dice.roll(validPositions.length()) - 1);
      steps++;
      String message = String.format("%s %s step %d out of %d to %s", new Object[] { getName(), getPosition(), Integer.valueOf(steps), 
            Integer.valueOf(getMovement()), newPosition });
      Controller.getInstance().getCurrentGame().getBoard().movePiece(this, newPosition);
      Controller.getInstance().updateGraphicalPiece(this, message, true);
      validPositions = validPositions();
    } 
    return steps;
  }
  
  public void resolveTurn() {
    actionCombat();
    actionMovement();
  }
  
  public DynamicVectorCharacters validTargets() {
    DynamicVectorCharacters validTargets = new DynamicVectorCharacters();
    byte b;
    int i;
    Character[] arrayOfCharacter;
    for (i = (arrayOfCharacter = Controller.getInstance().getCurrentGame().getCharacters()).length, b = 0; b < i; ) {
      Character character = arrayOfCharacter[b];
      if (character.isAlive() && 
        isEnemy(character) && 
        isAtRange(character.getPosition()))
        validTargets.add(character); 
      b++;
    } 
    return validTargets;
  }
  
  public boolean isAtRange(Position pos) {
    if (getPosition().getRow() == pos.getRow() - 1 && getPosition().getCol() == pos.getCol())
      return true; 
    if (getPosition().getRow() == pos.getRow() + 1 && getPosition().getCol() == pos.getCol())
      return true; 
    if (getPosition().getCol() == pos.getCol() - 1 && getPosition().getRow() == pos.getRow())
      return true; 
    if (getPosition().getCol() == pos.getCol() + 1 && getPosition().getRow() == pos.getRow())
      return true; 
    return false;
  }
  
  public DynamicVectorPosition validPositions() {
    DynamicVectorPosition positions = new DynamicVectorPosition();
    Game currentGame = Controller.getInstance().getCurrentGame();
    Position position = getPosition().south();
    if (currentGame.getBoard().freeSquare(position))
      positions.add(position); 
    position = getPosition().west();
    if (currentGame.getBoard().freeSquare(position))
      positions.add(position); 
    position = getPosition().east();
    if (currentGame.getBoard().freeSquare(position))
      positions.add(position); 
    position = getPosition().north();
    if (currentGame.getBoard().freeSquare(position))
      positions.add(position); 
    return positions;
  }
  
  public String toString() {
    return String.format("%s (moves:%d attack:%d defence:%d body:%d/%d)", new Object[] { getName(), Integer.valueOf(getMovement()), Integer.valueOf(getAttack()), 
          Integer.valueOf(getDefence()), Integer.valueOf(getBody()), Integer.valueOf(getMaxBody()) });
  }
  
  private static Icon icon = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/unknown.png"));
  
  private Position position;
  
  public Icon getImage() {
    return icon;
  }
  
  public Position getPosition() {
    return this.position;
  }
  
  public void setPosition(Position pos) {
    this.position = pos;
  }
  
  public char toChar() {
    return '?';
  }
} 