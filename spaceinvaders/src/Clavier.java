import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clavier implements KeyListener {
	
	private Handler events;
	
	public Clavier(Handler events) {
		this.events = events;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub	
	}
	
	@Override
	public void keyPressed(KeyEvent e) {

		// Se déplacer à gauche
		if (e.getKeyChar() == 'q')
			this.events.goLeft();
		
		// Se déplacer à droite
		if (e.getKeyChar() == 'd')
			this.events.goRight();
		
		// Tirer 
		if (e.getKeyChar() == 'f')
			this.events.goRocket();
	}
 
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	
	
}