package threads;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.SampleProvider;


/**
 * The IRSChecker class implements the functionality of the infrared sensor.
 * @author Eetu Tarkamo
 * @version 1.0 9.5.2016
 */

public class IRSChecker extends Thread {
	private int remoteCommand = 0;
	private int dist = 0;
	private boolean stopSampling = false;
	EV3IRSensor infraredSensor;
	
	/**
	 * constructor creates IRSChecker
	 * @param infraredSensor sets infrared sensor
	 */
	
	public IRSChecker(EV3IRSensor infraredSensor) {
		this.infraredSensor = infraredSensor;
	}
	
	/**
	 * 
	 * @return returns integer value for the command given via controller
	 */
	
	public int getRemoteCmd() {
		return this.remoteCommand;
	}
	
	/**
	 * 
	 * @return returns distance value measured by the infrared sensor
	 */
	
	public int getDistance() {
		return this.dist;
	}
	
	/**
	 * A method that shuts down the IRSChecker thread
	 */
	
	public void stopSampling() {
		this.stopSampling = true;
	}
	
	/**
	 * A method that reads commands from the controller
	 * Measures distance values from infrared sensor
	 */
	
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
