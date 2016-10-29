package org.usfirst.frc.team5493.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CatapultCommandGroup extends CommandGroup {
	public CatapultCommandGroup() {
		addSequential(new CatapultChamberCommand());
		addSequential(new CatapultLaunchCommand());
	}
}
