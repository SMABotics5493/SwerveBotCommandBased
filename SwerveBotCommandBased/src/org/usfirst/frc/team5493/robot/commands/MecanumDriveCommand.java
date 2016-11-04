package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

public class MecanumDriveCommand extends edu.wpi.first.wpilibj.command.Command {
	
	public MecanumDriveCommand(){
		requires(Robot.mecanumDriveSystem);
	}
	
	protected void initialize() {
		//requires(Robot.mecanumDriveSystem);
	}

	protected void execute() {
		Robot.mecanumDriveSystem.drive(Robot.operatorInput.getDriverJoystick());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.mecanumDriveSystem.drive(0.0D, 0.0D, 0.0D, 0);
	}

	protected void interrupted() {
		end();
	}
}
