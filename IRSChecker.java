package robotProject;
import lejos.hardware.sensor.EV3IRSensor;

public class IRSChecker extends Thread {
	private EV3IRSensor infraredSensor;
	private int remoteCommand = 0;
	private boolean stopSampling = false;
	
	public IRSChecker(EV3IRSensor sensor) {
		this.infraredSensor = sensor; 
	}
	
	public int getRemoteCmd() {
		return this.remoteCommand;
	}
	
	public void stopSampling() {
		this.stopSampling = true;
	}
	
	public void run() {
		while(stopSampling == false) {
			this.remoteCommand = infraredSensor.getRemoteCommand(0);
		}
	}

}
