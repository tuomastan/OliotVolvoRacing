import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.SampleProvider;

public class IRSChecker extends Thread {
	private int remoteCommand = 0;
	private int dist = 0;
	private boolean stopSampling = false;
	EV3IRSensor infraredSensor;
	
	public IRSChecker(EV3IRSensor infraredSensor) {
		this.infraredSensor = infraredSensor;
	}
	
	public int getRemoteCmd() {
		return this.remoteCommand;
	}
	
	public int getDistance() {
		return this.dist;
	}
	
	public void stopSampling() {
		this.stopSampling = true;
	}
	
	public void run() {
		while(stopSampling == false) {
			this.remoteCommand = infraredSensor.getRemoteCommand(0);
			SampleProvider distance = infraredSensor.getMode("Distance");
			float[] sample = new float[distance.sampleSize()];
			distance.fetchSample(sample,0);
			this.dist = (int) sample[0];
		}
		infraredSensor.close();
	}

}
