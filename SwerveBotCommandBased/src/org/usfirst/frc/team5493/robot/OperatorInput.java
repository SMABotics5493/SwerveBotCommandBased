package org.usfirst.frc.team5493.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OperatorInput {
	private Joystick driverJoystick = new Joystick(RobotMap.JOY_DRIVER_STICK);

	public Joystick getDriverJoystick() {
		return this.driverJoystick;
	}
}
