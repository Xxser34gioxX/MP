package items;
import jeroquest.utils.Position;

public class Trap extends Item{
	private boolean activated;

	public Trap(Position pos, boolean activated) {
		super(pos);
		this.setActivated(activated);
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	
}
