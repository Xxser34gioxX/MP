package items;

import jeroquest.boardgame.Piece;
import jeroquest.utils.Position;

public class Wall extends Item implements Piece{

	public Wall(Position pos) {
		super(pos);
	}

	public char toChar() {
		return '#';
	}

	@Override
	public Position getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPosition(Position pos) {
		// TODO Auto-generated method stub
		
	}

}
