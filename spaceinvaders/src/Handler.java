import java.util.ArrayList;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

public class Handler implements GLEventListener {
	
	private Rocket rocket;
	private float angle = 66;
	private Cube cube;
	private GLU glu;
	private float posX, posY;
	private ArrayList<Forme> advers;
	private ArrayList<Forme> choses;
	
	public Handler() {
		
		this.glu = new GLU();
		this.angle = 0;
		this.advers = new ArrayList<Forme>();			
		this.choses = new ArrayList<Forme>();
		
		this.choses.add(new Cube(0, -3, -10, 0.5f));
		
		this.cube = (Cube)this.choses.get(0);
		
		advers.add(new Advers(2, 2, -10, 0.5f));
		advers.add(new Advers(4, 2, -10, 0.5f));
		advers.add(new Advers(0, 2, -10, 0.5f));
		advers.add(new Advers(-2, 2, -10, 0.5f));
		advers.add(new Advers(-4, 2, -10, 0.5f));
		advers.add(new Advers(2, 0, -10, 0.5f));
		advers.add(new Advers(4, 0, -10, 0.5f));
		advers.add(new Advers(0, 0, -10, 0.5f));
		advers.add(new Advers(-2, 0, -10, 0.5f));
		advers.add(new Advers(-4, 0, -10, 0.5f));
		
	}
	
	@Override
	public void reshape(GLAutoDrawable draw, int x, int y, int width, int height) {
		
		GL2 gl = draw.getGL().getGL2();
		// -- SCREEN
		float aspect = (float)width / height;
		gl.glViewport(0, 0, width, height);
		// -- CAMERA
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		// FOCAL, ASPECT,
		this.glu.gluPerspective(45.0, aspect, 0.1, 100);
		// -- OBJECTS 
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
		int posX = 0;
		int posY = 0;
		gl.glViewport( posX, posY, width, height );
		gl.glScaled( width, height, 1 );
	} 

	@Override
	public void display(GLAutoDrawable draw) {
		// TODO Auto-generated method stub
		GL2 gl = draw.getGL().getGL2();
		
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		
		gl.glLoadIdentity();
		
		gl.glTranslatef(this.posX, this.posY, -0.01f);
		
		gl.glRotatef(angle, 1.0f, 0.0f, 0.0f);
		
		for (Forme s : this.choses)
			s.display(gl);
		
		for (Forme i : this.advers)
			i.display(gl);		

		if(rocket != null) {
			for (Forme e : this.advers) { 
				if (e.hit(rocket.x, rocket.y)) {
					advers.remove(e);
					advers.remove(rocket);					
					break;
				}
			}
		}	
	}
	
	@Override
	public void init(GLAutoDrawable draw) {
		
		GL2 gl = draw.getGL().getGL2();
		
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		
		gl.glEnable(GL2.GL_DEPTH_TEST);
	}
	
	public void goRight() { 
		cube.goRight();
	}
	
	public void goLeft() { 
		cube.goLeft();	
	}
	
	public void removeRocket() {
		advers.remove(this.rocket);
	}

	public void goRocket() {
		this.rocket = new Rocket(cube.getX(), cube.getY(), -10, 0.5f);
		this.advers.add(rocket);
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub	
	}
}