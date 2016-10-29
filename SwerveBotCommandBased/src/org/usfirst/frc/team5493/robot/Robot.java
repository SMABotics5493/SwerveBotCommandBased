package org.usfirst.frc.team5493.robot;

import org.usfirst.frc.team5493.robot.commands.CatapultChamberCommand;
import org.usfirst.frc.team5493.robot.commands.CatapultLaunchCommand;
import org.usfirst.frc.team5493.robot.commands.MecanumDriveCommand;
import org.usfirst.frc.team5493.robot.subsystems.CatapultSystem;
import org.usfirst.frc.team5493.robot.subsystems.MecanumDriveSystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	public static final MecanumDriveSystem mecanumDriveSystem = new MecanumDriveSystem();
	public static OperatorInput operatorInput;
	public static final CatapultSystem catapultSystem = new CatapultSystem();

	Command autonomousCommand;

	SendableChooser chooser;

	public void robotInit() {
		operatorInput = new OperatorInput();
		this.chooser = new SendableChooser();
		this.chooser.addDefault("Mecanum Drive", new MecanumDriveCommand());
		this.chooser.addObject("Catapult Launch", new CatapultLaunchCommand());
		this.chooser.addObject("Catapult Chamber", new CatapultChamberCommand());

		SmartDashboard.putData("Auto mode", this.chooser);
	}

	public void disabledInit() {
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		this.autonomousCommand = ((Command) this.chooser.getSelected());

		if (this.autonomousCommand != null) {
			this.autonomousCommand.start();
		}
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		if (this.autonomousCommand != null) {
			this.autonomousCommand.cancel();
		}
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	public void testPeriodic() {
	}
}
