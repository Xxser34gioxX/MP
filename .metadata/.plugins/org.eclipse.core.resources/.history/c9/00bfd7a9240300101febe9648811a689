package jeroquest.logic;

import jeroquest.boardgame.Board;
import jeroquest.boardgame.Dice;
import jeroquest.units.Barbarian;
import jeroquest.units.Character;
import jeroquest.units.Dwarf;
import jeroquest.units.Goblin;
import jeroquest.units.Mummy;

public class Game {
  private Character[] characters;
  
  private Board board;
  
  private int currentRound;
  
  private int totalRounds;
  
  public int getTotalRounds() {
    return this.totalRounds;
  }
  
  private void setTotalRounds(int totalRounds) {
    this.totalRounds = totalRounds;
  }
  
  public Game(int numHeroes, int numMonsters, int rows, int columns, int totalRounds) {
    setTotalRounds(totalRounds);
    this.board = new Board(rows, columns);
    this.characters = new Character[numHeroes + numMonsters];
    for (int x = 0; x < numHeroes; x++) {
      if (Dice.roll() % 2 == 0) {
        this.characters[x] = (Character)new Barbarian("Barbarian" + x, "<NoPlayer>");
      } else {
        this.characters[x] = (Character)new Dwarf("Dwarf" + x, "<NoPlayer>");
      } 
    } 
    for (int y = 0; y < numMonsters; y++) {
      if (Dice.roll() % 2 == 0) {
        this.characters[numHeroes + y] = (Character)new Mummy("Mummy" + y);
      } else {
        this.characters[numHeroes + y] = (Character)new Goblin("Goblin" + y);
      } 
    } 
    this.currentRound = 1;
  }
  
  public int getCurrentRound() {
    return this.currentRound;
  }
  
  public void setCurrentRound(int currentRound) {
    this.currentRound = currentRound;
  }
  
  public Character[] getCharacters() {
    return this.characters;
  }
  
  public Board getBoard() {
    return this.board;
  }
  
  public String toString() {
    String s = "";
    for (int x = 0; x < this.characters.length; x++) {
      s = String.valueOf(s) + String.format("%s\n", new Object[] { this.characters[x] });
    } 
    s = String.valueOf(s) + getBoard();
    return s;
  }
}