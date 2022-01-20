import com.jogamp.opengl.GL2;

public class Rocket extends Forme {
	
	private float rquad = 0.0f;
	public int posMisY;
	
	public Rocket(float x, float y, float z, float size) {
		
		this.x = x; 
		this.y = y; 
		this.z = z;
		this.size = size;	
	}

	private void move() {
		for (int i = 0 ; i < 2; i++) {
			this.y += 0.05;
		} 
	}
	
	public void display(GL2 gl) {
		
		gl.glRotatef(rquad, 0.8f, 0.0f, 0.0f); 
		gl.glPushMatrix();
		gl.glTranslatef(x, y, z);
		gl.glScalef(size, size, size);
		gl.glRotated(size * 10, 1, 1, 1);
		gl.glBegin(GL2.GL_QUADS);
		// Front
		gl.glColor3d(0.7f, 0.7f, 0.7f);
		gl.glVertex3d(-0.3, -0.3, 0.3);
		gl.glVertex3d(0.3, -0.3, 0.3);
		gl.glVertex3d(0.3, 0.5, 0.3);
		gl.glVertex3d(-0.3, 0.5, 0.3);
		// Rear
		gl.glColor3d(0.7f, 0.7f, 0.7f);
		gl.glVertex3d(-0.3, -0.3, -0.3);
		gl.glVertex3d(0.3, -0.3, -0.3);
		gl.glVertex3d(0.3, 0.5, -0.3);
		gl.glVertex3d(-0.3, 0.5, -0.3);
		// Left
		gl.glColor3d(0.7f, 0.7f, 0.7f);
		gl.glVertex3d(-0.3, -0.3, -0.3);
		gl.glVertex3d(-0.3, -0.3, 0.3);
		gl.glVertex3d(-0.3, 0.5,  0.3);
		gl.glVertex3d(-0.3, 0.5, -0.3);
		// Right
		gl.glColor3d(0.7f, 0.7f, 0.7f);
		gl.glVertex3d(0.3, -0.3, -0.3);
		gl.glVertex3d(0.3, -0.3, 0.3);
		gl.glVertex3d(0.3, 0.5,  0.3);
		gl.glVertex3d(0.3, 0.5, -0.3);
		// Bottom
		gl.glColor3d(0.7f, 0.7f, 0.7f);
		gl.glVertex3d(-0.3, -0.3, -0.3);
		gl.glVertex3d(0.3, -0.3, 0.3);
		gl.glVertex3d(0.3, -0.5, -0.3);
		gl.glVertex3d(-0.3, -0.5, -0.3);
		// Up
		gl.glColor3d(0.7f, 0.7f, 0.7f);
		gl.glVertex3d(-0.3, 0.3, 0.3);
		gl.glVertex3d(0.3, 0.3, 0.3);
		gl.glVertex3d(0.3, 0.5, -0.3);
		gl.glVertex3d(-0.3, 0.5, -0.3);
		gl.glEnd();	
		gl.glPopMatrix();
		
		move();
	}

	public float size() {
		return this.size;
	}
	
	public float posMisY() {
		return this.y;
	}
	
	public float posMisX() {
		return this.x;
	}

	public Rocket get(int i) {
		return null;
	}

	public float getX() {
		return 0;
	}
}