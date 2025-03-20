package jeroquest.boardgame;

public class Board {
  private Square[][] squares;
  
  private int rows;
  
  private int columns;
  
  public Board(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
    this.squares = new Square[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++)
        this.squares[i][j] = new Square(); 
    } 
  }
  
  public int getRows() {
    return this.rows;
  }
  
  public int getColumns() {
    return this.columns;
  }
  
  private Square getSquare(Position pos) {
    return this.squares[pos.getRow()][pos.getCol()];
  }
  
  public void removePiece(Piece p) {
    if (p.getPosition() != null) {
      getSquare(p.getPosition()).setPiece(null);
      p.setPosition(null);
    } 
  }
  
  private boolean validSquare(Position pos) {
    if (pos.getRow() < 0 || pos.getRow() >= this.rows)
      return false; 
    if (pos.getCol() < 0 || pos.getCol() >= this.columns)
      return false; 
    return true;
  }
  
  public boolean freeSquare(Position pos) {
    return (validSquare(pos) && getSquare(pos).empty());
  }
  
  public boolean movePiece(Piece p, Position pos) {
    if (freeSquare(pos)) {
      removePiece(p);
      p.setPosition(pos);
      getSquare(pos).setPiece(p);
      return true;
    } 
    return false;
  }
  
  public String toString() {
    String s = "";
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.columns; j++)
        s = String.valueOf(s) + this.squares[i][j]; 
      s = String.valueOf(s) + "\n";
    } 
    return s;
  }
}