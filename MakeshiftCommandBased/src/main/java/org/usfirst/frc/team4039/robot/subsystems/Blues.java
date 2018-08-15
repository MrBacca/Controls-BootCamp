package org.usfirst.frc.team4039.robot.subsystems;

import org.usfirst.frc.team4039.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Blues extends Subsystem {
	private boolean isRunning = false;
	
	public void run(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	private TalonSRX motor = new TalonSRX(RobotMap.blue);
	private TalonSRX motorFollower = new TalonSRX(RobotMap.blueFollower);
	
	@Override
	public void periodic() {
		motor.set(ControlMode.PercentOutput, isRunning ? 1.0 : 0.0);
		motorFollower.follow(motor);
	}

	@Override
    public void initDefaultCommand() {
    }
}

