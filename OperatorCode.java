package org.usfirst.frc.team20.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class OperatorCode {
	// class for operator code
	DriverStation station;
	GroundCollector collector;
	Controller operatorJoy;
	Hopper hopper;
	double initialMatchTime;
	boolean hopperToFlywheel = false;

	public void operatorCode() {

		if (operatorJoy.getButtonA()) {
			collector.intake(1);
		}
		if (operatorJoy.getButtonB()) {
			collector.outtake(1);
		}
		if (operatorJoy.getButtonX()) {
			hopper.hopperMotorIntoFlywheel(1);
			hopperToFlywheel = true;
		}
		if (hopperToFlywheel) {
			double currentMatchTime = station.getMatchTime();
			if (initialMatchTime < 0) {
				initialMatchTime = currentMatchTime;
			}
			System.out.println(initialMatchTime + "              " + currentMatchTime);
			if (initialMatchTime - 0.25 < currentMatchTime) {
				System.out.println("In the If");
				hopper.retractAgitator();
			} else {
				if (initialMatchTime - 0.4 > currentMatchTime) {
					initialMatchTime = currentMatchTime;
				}
				System.out.println("In the else");
				hopper.actuateAgitator();
			}
		}

	}
}
