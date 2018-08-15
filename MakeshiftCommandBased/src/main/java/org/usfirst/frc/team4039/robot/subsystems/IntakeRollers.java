package org.usfirst.frc.team4039.robot.subsystems;

import org.usfirst.frc.team4039.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeRollers extends Subsystem {
	private double speed = 0.0;
	
	public void runIn() {
		this.speed = -1.0;
	}
	
	public void runOut() {
		this.speed = 1.0;
	}
	
	public void stop() {
		this.speed = 0.0;
	}
	
	TalonSRX roller = new TalonSRX(RobotMap.intakeRoller);
	TalonSRX rollerFollower = new TalonSRX(RobotMap.intakeRollerFollower);
	
	@Override
	public void periodic() {
		roller.set(ControlMode.PercentOutput, speed);
		rollerFollower.setInverted(true);
		rollerFollower.follow(roller);
	}
	
	@Override
	protected void initDefaultCommand() {
	}
}

