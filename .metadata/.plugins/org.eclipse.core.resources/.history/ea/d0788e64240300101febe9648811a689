package jeroquest.boardgame;

public class Position {
  private int row;
  
  private int col;
  
  public Position(int row, int col) {
    setRow(row);
    setCol(col);
  }
  
  public int getRow() {
    return this.row;
  }
  
  public void setRow(int row) {
    this.row = row;
  }
  
  public int getCol() {
    return this.col;
  }
  
  public void setCol(int col) {
    this.col = col;
  }
  
  public Position north() {
    return new Position(this.row - 1, this.col);
  }
  
  public Position south() {
    return new Position(this.row + 1, this.col);
  }
  
  public Position east() {
    return new Position(this.row, this.col + 1);
  }
  
  public Position west() {
    return new Position(this.row, this.col - 1);
  }
  
  public boolean equals(Object o) {
    if (o == null || !(o instanceof Position))
      return super.equals(o); 
    Position anotherLoc = (Position)o;
    return (anotherLoc.getRow() == this.row && anotherLoc.getCol() == this.col);
  }
  
  public String toString() {
    return "(" + this.row + "," + this.col + ")";
  }
}