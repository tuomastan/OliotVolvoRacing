import java.util.Random;
import lejos.hardware.Button;
import lejos.utility.Delay;

public class AutoPilot {
	
	public AutoPilot() {
	}
	
	public void autoPilot(Motors motors,IRSChecker irs,Random rng){
		while(Button.ESCAPE.isUp()){
			int random = rng.nextInt(3);
			motors.autoMoveForward();
			if(irs.getDistance() < 15){
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
					Delay.msDelay(1000);
				}
			}
		}
		motors.stop();
	}
}
