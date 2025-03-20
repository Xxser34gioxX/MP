package jeroquest.boardgame;

public interface Piece {
	
  Position getPosition();
  
  void setPosition(Position paramPosition);
  
  char toChar();
}