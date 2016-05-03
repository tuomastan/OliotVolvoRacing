package robotProject;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		EV3IRSensor irsSensor = new EV3IRSensor(SensorPort.S4);
		Random randomGenerator = new Random();
		Motors motors = new Motors();
		IRSChecker irs = new IRSChecker(irsSensor);
		RemoteControl rmt = new RemoteControl(irs,motors,randomGenerator);
		rmt.run();
	}

}
