package robotProject;
import lejos.hardware.Button;
import java.util.Random;
import lejos.utility.Delay;
import lejos.robotics.SampleProvider;
import lejos.hardware.sensor.EV3IRSensor;

public class RemoteControl {
	private IRSChecker irs;
	private Motors motors;
	private Random rng;
	private EV3IRSensor irSensor;
	
	public RemoteControl(IRSChecker irs, Motors motors, Random rng, EV3IRSensor irSensor) {
		this.irs = irs;
		this.motors = motors;
		this.rng = rng;
		this.irSensor = irSensor;
	}
	
	public void run() {
		irs.start();
		while (Button.ESCAPE.isUp()) {
			int cmd = irs.getRemoteCmd();
			switch(cmd) {
			case 1:
				motors.turnLeft();
				break;
			case 2:
				motors.stop();
				break;
			case 3:
				motors.turnRight();
				break;
			case 4:
				motors.shootCannon();
				break;
			case 5:
				motors.moveForward();
				break;
			case 8:
				motors.moveBack();
				break;
			case 10:
				autoPilot(motors,irSensor,rng);
				break;
			default:
				break;
			}
			Delay.msDelay(1000);
		}
		irs.stopSampling();
		motors.closeMotors();
	}
	
		public void autoPilot(Motors motors,EV3IRSensor irSensor,Random rng){
		SampleProvider distance = irSensor.getMode("Distance");
		while(Button.ESCAPE.isUp()){
			int random = rng.nextInt(3);
			motors.moveForward();
			float[] sample = new float[distance.sampleSize()];
			distance.fetchSample(sample,0);
			int dist = (int) sample[0];
			if(dist < 15){
				motors.moveBack();
				Delay.msDelay(1000);
				if(random == 0){
					motors.turnRight();
					Delay.msDelay(1000);
				}else if(random == 1){
					motors.turnLeft();
					Delay.msDelay(1000);
				}else if(random == 2){
					motors.turnRight();
					Delay.msDelay(2000);
				}	
			}
		}
	}
}
