package org.usfirst.frc.team5493.robot;

import org.usfirst.frc.team5493.robot.commands.CatapultChamberCommand;
import org.usfirst.frc.team5493.robot.commands.CatapultCommandGroup;
import org.usfirst.frc.team5493.robot.commands.CatapultLaunchCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OperatorInput {
	private Joystick driverJoystick = new Joystick(RobotMap.JOY_DRIVER_STICK);
	private JoystickButton triggerButton = new JoystickButton(driverJoystick, RobotMap.JOYBTN_TRIGGER);

	public OperatorInput(){
		//getDriverJoystick().
		//triggerButton.whenPressed(new CatapultLaunchCommand());
		//triggerButton.whenReleased(new CatapultChamberCommand());
		triggerButton.whenPressed(new CatapultCommandGroup());
	}
	
	public Joystick getDriverJoystick() {
		return this.driverJoystick;
	}
}
