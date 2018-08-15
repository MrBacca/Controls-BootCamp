package org.usfirst.frc.team4039.robot.subsystems;

import org.usfirst.frc.team4039.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Conveyor extends Subsystem {
	private double speed = 0.0;
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	private TalonSRX motor = new TalonSRX(RobotMap.conveyor);
	
	@Override
	public void periodic() {
		motor.set(ControlMode.PercentOutput, speed);
	}

	@Override
    public void initDefaultCommand() {
    }
}

