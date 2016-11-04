package org.usfirst.frc.team5493.robot;

import org.usfirst.frc.team5493.robot.controllers.LiveWindowTalon;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

public class RobotMap {
	public static final int MC_DRIVE_FRONT_RIGHT = 4;
	public static final int MC_DRIVE_FRONT_LEFT = 2;
	public static final int MC_DRIVE_BACK_RIGHT = 5;
	public static final int MC_DRIVE_BACK_LEFT = 3;
	public static final int MC_BALL_SHOOTER_RIGHT = 4;
	public static final int MC_BALL_SHOOTER_LEFT = 5;
	public static final int MC_BALL_INTAKE = 7;
	public static final int JOYBTN_A = 1;
	public static final int JOYBTN_B = 2;
	public static final int JOYBTN_X = 3;
	public static final int JOYBTN_Y = 4;
	public static final int JOYBTN_LB = 5;
	public static final int JOYBTN_RB = 6;
	public static final int JOYAXS_LEFT_Y = 1;
	public static final int JOYAXS_RIGHT_Y = 5;
	public static final int JOYAXS_TWIST_Z = 4;
	public static final int USE_CAN_TALON = 1;
	public static final int USE_PWM_TALON = 2;
	public static final int USE_PWM_VICTOR = 3;
	public static final int USE_PWM_JAGUAR = 4;
	public static final int JOY_DRIVER_STICK = 0;
	public static final int JOYBTN_TRIGGER = 1;
	public static final int COMPRESSOR_CATAPULT = 0;
	public static final int SOLENOID_CATAPULT_FORWARD = 7;
	public static final int SOLENOID_CATAPULT_REVERSE = 4;

	public static SpeedController SpeedController(int port, int controllerType) {
		switch (controllerType) {
		case USE_CAN_TALON:
			return new CANTalon(port);

		case USE_PWM_VICTOR:
			return new Victor(port);

		case USE_PWM_TALON:
			return new LiveWindowTalon(port);

		case USE_PWM_JAGUAR:
			return new Jaguar(port);
		}

		return null;
	}
}
