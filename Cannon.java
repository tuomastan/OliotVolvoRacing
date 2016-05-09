import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class Cannon {
	private EV3LargeRegulatedMotor motor3;
	private EV3MediumRegulatedMotor motor4;
	
	public Cannon() {
		this.motor3 = new EV3LargeRegulatedMotor(MotorPort.A);
		this.motor4 = new EV3MediumRegulatedMotor(MotorPort.D);
	}
	
	public void shootCannon() {
		motor3.rotate(360);
	}
	
	public void rotateCannonLeft(){
		motor4.rotate(180);
	}
	
	public void rotateCannonRight(){
		motor4.rotate(-180);
	}
	
	public void closeCannonMotors() {
		motor3.close();
		motor4.close();
	}
}
