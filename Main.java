package remoteControl;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;

public class Main {

	public static void main(String[] args) {
		EV3IRSensor irsSensor = new EV3IRSensor(SensorPort.S4);
		Motor motor = new Motor();
		SpecialEffects se = new SpecialEffects();
		IrsChecker irsChecker = new IrsChecker(irsSensor, motor, se);
		irsChecker.start();

	}

}
