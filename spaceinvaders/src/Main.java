import java.awt.Dimension;

import javax.swing.JFrame;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

public class Main{
	
	public static void main(String[] args) {
		JFrame window = new JFrame();
		
		GLCanvas canvas = new GLCanvas();
		Handler events = new Handler();
		canvas.addKeyListener(new Clavier(events));
		canvas.setPreferredSize(new Dimension(800, 600));
		canvas.addGLEventListener(events);
		
		window.getContentPane().add(canvas);
		
		window.setTitle("Space Invaders");
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.pack();
		
		window.setVisible(true);
		
		FPSAnimator anim = new FPSAnimator(canvas, 60);
	
		anim.start();
	}
}


