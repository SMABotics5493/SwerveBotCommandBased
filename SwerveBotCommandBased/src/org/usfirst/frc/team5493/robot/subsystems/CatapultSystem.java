package org.usfirst.frc.team5493.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CatapultSystem extends Subsystem {
	private DoubleSolenoid catapultSolenoid;
	private boolean stateIsChambered = false;

	public CatapultSystem() {
		this.catapultSolenoid = new DoubleSolenoid(7, 4);
	}

	protected void initDefaultCommand() {
	}

	public void chamber() {
		if (!this.stateIsChambered) {
			this.catapultSolenoid.set(DoubleSolenoid.Value.kReverse);
			this.stateIsChambered = true;
			Timer.delay(0.5D);
		}

		DriverStation.reportError("CHAMBER", false);
	}

	public void launch() {
		if (this.stateIsChambered) {
			DriverStation.reportError("LAUNCH", false);
			this.catapultSolenoid.set(DoubleSolenoid.Value.kForward);
			this.stateIsChambered = false;
		} else {
			DriverStation.reportError("NOT CHAMBERED", false);
		}
	}

	public void done() {
		DriverStation.reportError("OFF", false);
		this.catapultSolenoid.set(DoubleSolenoid.Value.kOff);
	}
}
