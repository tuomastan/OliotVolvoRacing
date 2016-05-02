package robotProject;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;

public class Main {

	public static void main(String[] args) {
		EV3IRSensor irsSensor = new EV3IRSensor(SensorPort.S4);
		Motors motors = new Motors();
		IRSChecker irs = new IRSChecker(irsSensor);
		RemoteControl rmt = new RemoteControl(irs,motors);
		rmt.run();
	}

}
