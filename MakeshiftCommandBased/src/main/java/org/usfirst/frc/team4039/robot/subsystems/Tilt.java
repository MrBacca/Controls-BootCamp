package org.usfirst.frc.team4039.robot.subsystems;

import org.usfirst.frc.team4039.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Tilt extends Subsystem {
	private boolean doTilt = false;
	
	public void setTilt(boolean doTilt) {
		this.doTilt = doTilt;
	}
	
	private DoubleSolenoid tilt = new DoubleSolenoid(RobotMap.tiltForward, RobotMap.tiltReverse);
	
	@Override
	public void periodic() {
		tilt.set(doTilt ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
	}

	@Override
    public void initDefaultCommand() {
    }
}

