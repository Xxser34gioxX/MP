package items;
import jeroquest.utils.Position;
public class Item {
	private Position pos;

	public Item(Position pos) {
		this.pos = pos;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}
}
