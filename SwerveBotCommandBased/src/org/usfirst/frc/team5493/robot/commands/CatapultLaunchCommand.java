package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

public class CatapultLaunchCommand extends edu.wpi.first.wpilibj.command.Command {
	public CatapultLaunchCommand() {
		requires(Robot.catapultSystem);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.catapultSystem.launch();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.catapultSystem.done();
	}

	protected void interrupted() {
		end();
	}
}
