package org.usfirst.frc.team5493.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import org.usfirst.frc.team5493.robot.RobotMap;
import org.usfirst.frc.team5493.robot.commands.MecanumDriveCommand;

public class MecanumDriveSystem extends Subsystem {
	private SpeedController leftFrontController;
	private SpeedController leftBackController;
	private SpeedController rightFrontController;
	private SpeedController rightBackController;
	private RobotDrive mecanumDrive;
	private final String SYSTEM_NAME = "Mecanum Drive System";
	private final String LEFT_FRONT_NAME = "Left Front Motor";
	private final String RIGHT_FRONT_NAME = "Right Front Motor";
	private final String LEFT_BACK_NAME = "Left Back Motor";
	private final String RIGHT_BACK_NAME = "Right Back Motor";

	public MecanumDriveSystem() {
		this.leftFrontController = RobotMap.SpeedController(2, 2);
		this.rightFrontController = RobotMap.SpeedController(4, 3);
		this.leftBackController = RobotMap.SpeedController(3, 3);
		this.rightBackController = RobotMap.SpeedController(5, 3);
		this.mecanumDrive = new RobotDrive(this.leftFrontController, this.leftBackController, this.rightFrontController,
				this.rightBackController);

		LiveWindow.addActuator(SYSTEM_NAME, LEFT_FRONT_NAME, (LiveWindowSendable) this.leftFrontController);
		LiveWindow.addActuator(SYSTEM_NAME, RIGHT_FRONT_NAME, (LiveWindowSendable) this.rightFrontController);
		LiveWindow.addActuator(SYSTEM_NAME, LEFT_BACK_NAME, (LiveWindowSendable) this.leftBackController);
		LiveWindow.addActuator(SYSTEM_NAME, RIGHT_BACK_NAME, (LiveWindowSendable) this.rightBackController);
	}

	protected void initDefaultCommand() {
		setDefaultCommand(new MecanumDriveCommand());
	}

	public void drive(Joystick joy) {
		drive(joy.getX(), joy.getY(), joy.getTwist(), 0);
	}

	public void drive(double x, double y, double twist, int gyro) {
		this.mecanumDrive.mecanumDrive_Cartesian(x, y, twist, gyro);
	}

	public void reset() {
		drive(0.0D, 0.0D, 0.0D, 0);
	}
}
