package org.usfirst.frc.team20.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class DriverControls {
	public class Robot extends IterativeRobot {
		String autoSelected;
		DriverStation station;
		DriveTrain drive;
		Controller driverJoy;
		Controller operatorJoy;

		public void navxnotworking() {
			// gearCamera.startUSBCamera();
			// highGoalCamera.startUSBCamera();
			// Driver Code with the NavX Not Working
			try {
				drive.initializeNavx();
			} catch (Exception e) {
				System.out.println("NavX Not Working");
				double speedStraight = driverJoy.getLeftYAxis();
				double speedLeft = driverJoy.getLeftTriggerAxis();
				double speedRight = driverJoy.getRightTriggerAxis();
				if (speedStraight != 0 || speedLeft > 0 || speedRight > 0) {
					drive.masterRight.set(speedStraight - speedRight + speedLeft);
					drive.masterLeft.set(-speedStraight + speedLeft - speedRight);
				}
				if (driverJoy.getButtonLeftBumper()) {
					drive.shiftHigh();
				}
				if (driverJoy.getButtonRightBumper()) {
					drive.shiftLow();
				}
			}
		}

		public void navxWorking() {
			// Driver Code with the NavX Working
			double speedStraight = driverJoy.getLeftYAxis();
			double speedLeft = driverJoy.getLeftTriggerAxis();
			double speedRight = driverJoy.getRightTriggerAxis();
			if (speedStraight != 0 || speedLeft > 0 || speedRight > 0) {
				drive.drive(speedStraight, speedRight, speedLeft);
			}
			if (driverJoy.getButtonLeftBumper()) {
				drive.shiftHigh();
			}
			if (driverJoy.getButtonRightBumper()) {
				drive.shiftLow();
			}
		}
	}
}
