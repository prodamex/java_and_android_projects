import com.jogamp.opengl.GL2;

public class Cube extends Forme {
	
	public Cube(float x, float y, float z, float size) {
		this.x = x; this.y = y; this.z = z;
		this.size = size;
	}
	
	public void display(GL2 gl) {
		
		
		gl.glPushMatrix();
		gl.glTranslatef(x, y, z);
		gl.glScalef(size, size, size);
		gl.glRotated(size * 0.60, 0.6, 0.6, 0.6);
		gl.glBegin(GL2.GL_QUADS);


		
		gl.glColor3d(0, 0.6, 0);
		gl.glVertex3d(-0.6, -0.3, 0.6);
		gl.glVertex3d(0.6, -0.3, 0.6);
		gl.glVertex3d(0.6, 0.3, 0.6);
		gl.glVertex3d(-0.6, 0.3, 0.6);

		
		gl.glColor3d(0, 0.6, 0);
		gl.glVertex3d(-0.6, -0.3, -0.6);
		gl.glVertex3d(0.6, -0.3, -0.6);
		gl.glVertex3d(0.6, 0.3, -0.6);
		gl.glVertex3d(-0.6, 0.3, -0.6);


		gl.glColor3d(0, 0.6, 0.6);
		gl.glVertex3d(-0.6, -0.3, -0.6);
		gl.glVertex3d(-0.6, -0.3, 0.6);
		gl.glVertex3d(-0.6, 0.3,  0.6);
		gl.glVertex3d(-0.6, 0.3, -0.6);


		gl.glColor3d(0, 0.6, 0);
		gl.glVertex3d(0.6, -0.3, -0.6);
		gl.glVertex3d(0.6, -0.3, 0.6);
		gl.glVertex3d(0.6, 0.3,  0.6);
		gl.glVertex3d(0.6, 0.3, -0.6);


		
		gl.glColor3d(0, 0.6, -0.3);
		gl.glVertex3d(-0.6, -0.3, -0.3);
		gl.glVertex3d(0.6, -0.3, 0.6);
		gl.glVertex3d(0.6, -0.3, -0.6);
		gl.glVertex3d(-0.6, -0.3, -0.6);


		gl.glColor3d(0.6, 0.3, 0.6);
		gl.glVertex3d(-0.6, 0.3, 0.6);
		gl.glVertex3d(0.6, 0.3, 0.6);
		gl.glVertex3d(0.6, 0.3, -0.6);
		gl.glVertex3d(-0.6, 0.3, -0.6);
		gl.glEnd();	
		gl.glPopMatrix();
		
	}
	
	public void goRight() { 
		
		this.x += 0.2f;
		
	}
	
	public void goLeft() { 
		
		
		
		this.x -= 0.2f; 
	}

	public float getX() {
		return this.x;
		
		
	}
	
	public float getY() {
		
		
		return this.y;
		
	}
}