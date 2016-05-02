package remoteControl;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.utility.Delay;
import lejos.robotics.SampleProvider;
import lejos.robotics.filter.MeanFilter;
import lejos.hardware.port.Port;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.SensorModes;
import lejos.hardware.Button;

public class Motor {
	private EV3LargeRegulatedMotor motor1;
	private EV3LargeRegulatedMotor motor2;
	private EV3MediumRegulatedMotor motor3;
	private EV3TouchSensor ts;
	private float[] sample;
	
	
	public Motor() {
		this.motor1 = new EV3LargeRegulatedMotor(MotorPort.B);
		this.motor2 = new EV3LargeRegulatedMotor(MotorPort.C);
		this.motor3 = new EV3MediumRegulatedMotor(MotorPort.A);
		this.ts = new EV3TouchSensor(SensorPort.S1);
		this.sample = new float[ts.sampleSize()];
	}
	
	public void moveForward() {
		stop();
		motor1.setSpeed(720);
		motor2.setSpeed(720);
		motor1.forward();
		motor2.forward();
	}
	
	public void moveBack() {
		stop();
		motor1.setSpeed(720);
		motor2.setSpeed(720);
		motor1.backward();
		motor2.backward();
		Delay.msDelay(2000);
		turnRight();
		Delay.msDelay(500);
	}
	
	public void turnRight() {
		stop();
		motor1.setSpeed(720);
		motor1.forward();
	}
	
	public void turnLeft() {
		stop();
		motor2.setSpeed(720);
		motor2.forward();
	}
	
	public void stop() {
		motor1.stop(true);
		motor2.stop(true);
	}
	
	public void shootCatapult() {
		motor3.rotateTo(300);
		Delay.msDelay(200);
		motor3.rotateTo(0);
	}
	

	
	public void activateAutoPilot(EV3IRSensor infraredSensor) {
		int remoteCommand = infraredSensor.getRemoteCommand(0);
		Port port = LocalEV3.get().getPort("S4");
		SensorModes sensor = new EV3IRSensor(port);
		SampleProvider distance= sensor.getMode("Distance");
		while (Button.ESCAPE.isUp() && remoteCommand == 6) {
			Delay.msDelay(2000);
			moveForward();
			SampleProvider average = new MeanFilter(distance, 5);
			float[] sample = new float[average.sampleSize()];
			average.fetchSample(sample, 0);
			int dist = (int) sample[0];
			remoteCommand = infraredSensor.getRemoteCommand(0);
        	while (dist < 35 && Button.ESCAPE.isUp()) {
        		moveBack();
        		average = new MeanFilter(distance, 5);
        		sample = new float[average.sampleSize()];
        		average.fetchSample(sample, 0);
        		dist = (int) sample[0];
        	}
		}
	}
}
