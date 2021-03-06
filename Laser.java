package space_shooter;

import java.awt.Color;

import sage.scene.shape.Sphere;
import graphicslib3D.Matrix3D;
import graphicslib3D.Point3D;
import graphicslib3D.Vector3D;

public class Laser extends MoveableObject{
	private Sphere laser;
	private float speed;
	private Point3D location;
	private SpaceShip ship;
	private float lastUpdatedLasTime;
	boolean expired = false;
	
	public Laser(SpaceShip ship, float speed){
		laser = new Sphere();
		laser.setRenderMode(RENDER_MODE.OPAQUE);
		this.ship = ship;
		this.speed = speed;
		laser.scale(0.1f, 0.1f, 0.1f);
		laser.setColor(Color.RED);
		lastUpdatedLasTime = System.nanoTime();
		laser.translate((float)ship.getCamera().getLocation().getX(), (float)ship.getCamera().getLocation().getY(), (float)ship.getCamera().getLocation().getZ());
		
	}
	
	public boolean expired()
		{ 
		float currentLasTime = System.nanoTime();
		float elapsedLasTime = ((currentLasTime-lastUpdatedLasTime)/10000000.0f);
		//System.out.println("laser time:" + elapsedLasTime);
		if (elapsedLasTime > 500.0f)
			{
			expired = true;
			return expired;
			}
		return false;
		}
	
	public void move(){
	/*	Vector3D viewDir = ship.getCamera().getViewDirection().normalize();
		Vector3D curLocVector = new Vector3D(this.getLocation());
		Vector3D newLocVector = new Vector3D();
		
		newLocVector = curLocVector.add(viewDir.mult(0.05 * speed));
		 
		double newX = newLocVector.getX();
		double newY = newLocVector.getY();
		double newZ = newLocVector.getZ();
		Point3D newLoc = new Point3D(newX,newY,newZ);
		this.setLocation(newLoc);
	*/
	}
	
	public Sphere getLaser(){
		return laser;
	}
	
	@Override
	public void setSpeed(float speed) {
		this.speed = speed;
	}

	@Override
	public float getSpeed() {
		return speed;
	}

	public void setLocation(Point3D location) {
		this.location = location;
	}

	public Point3D getLocation() {
		return location;
	}

}
