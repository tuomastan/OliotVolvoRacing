package robotProject;
import lejos.hardware.Button;
import lejos.utility.Delay;

public class RemoteControl {
	private IRSChecker irs;
	private Motors motors;
	
	public RemoteControl(IRSChecker irs, Motors motors) {
		this.irs = irs;
		this.motors = motors;
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
			default:
				break;
			}
			Delay.msDelay(1000);
		}
		irs.stopSampling();
		motors.closeMotors();
	}
	
		public static void autoPilot(Motors motors,EV3IRSensor irSensor,Random rng){
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
