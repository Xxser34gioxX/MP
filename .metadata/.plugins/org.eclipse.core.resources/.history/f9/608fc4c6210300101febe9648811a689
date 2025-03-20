package jeroquest.boardgame;

public class Square {
  private Piece piece;
  
  public Square() {
    setPiece(null);
  }
  
  public Piece getPiece() {
    return this.piece;
  }
  
  public void setPiece(Piece piece) {
    this.piece = piece;
  }
  
  public boolean empty() {
    return (this.piece == null);
  }
  
  public String toString() {
    if (this.piece == null)
      return "-"; 
    return String.format("%c", new Object[] { Character.valueOf(this.piece.toChar()) });
  }
}