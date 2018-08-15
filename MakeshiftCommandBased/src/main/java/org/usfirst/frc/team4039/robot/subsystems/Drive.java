package org.usfirst.frc.team4039.robot.subsystems;

import org.usfirst.frc.team4039.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import com.kauailabs.navx.frc.AHRS.SerialDataType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Controls the drive train
 */
public class Drive extends Subsystem {
	private double forward = 0.0;
	private double turn = 0.0;
	private boolean doShift = false;
	private double distanceToDrive = 0.0;

	public void driveForwardTargetDistance(double distance) {
		this.distanceToDrive = distance;
	}
	
	public void user(double forward, double turn) {
		this.forward = forward;
		this.turn = turn;
	}
	
	public boolean driveForwardIsFinished() {
		return otherMagic();
	}
	
	public void setShift(boolean doShift) {
		this.doShift = doShift;
	}
	
	TalonSRX left = new TalonSRX(RobotMap.driveLeft);
	TalonSRX leftFollower = new TalonSRX(RobotMap.driveLeftFollower);
	TalonSRX right = new TalonSRX(RobotMap.driveRight);
	TalonSRX rightFollower = new TalonSRX(RobotMap.driveRightFollower);
	AHRS gyro = new AHRS(SerialPort.Port.kMXP, SerialDataType.kProcessedData, (byte) 50);
	DoubleSolenoid shifter = new DoubleSolenoid(RobotMap.driveShiftForward, RobotMap.driveShiftReverse);
	
	@Override
	public void periodic() {
		left.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		right.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		
		if(DriverStation.getInstance().isOperatorControl()) {
			// Teleop mode
			left.set(ControlMode.PercentOutput, forward + turn);
			right.set(ControlMode.PercentOutput, forward - turn);
		} else if(DriverStation.getInstance().isAutonomous()) {
			// Auto mode
			magic();
		} else {
			left.set(0.0);
			right.set(0.0);
		}
		
		leftFollower.follow(left);
		rightFollower.follow(right);
		
		shifter.set(doShift ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
		
		SmartDashboard.putNumber("Drive/LeftEncoder", left.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Drive/RightEncoder", right.getSelectedSensorPosition(0));
	}
	
	@Override
	protected void initDefaultCommand() {
	}
}

