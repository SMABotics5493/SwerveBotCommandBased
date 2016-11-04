package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

public class CatapultChamberCommand extends edu.wpi.first.wpilibj.command.Command {
	public CatapultChamberCommand() {
		requires(Robot.catapultSystem);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.catapultSystem.chamber();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.catapultSystem.done();
	}

	protected void interrupted() {
	}
}
