/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4039.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// CAN ids
	public static int driveLeft = 1;
	public static int driveLeftFollower = 2;
	public static int driveRight = 3;
	public static int driveRightFollower = 4;
	public static int intakeRoller = 5;
	public static int intakeRollerFollower = 6;
	public static int conveyor = 7;
	public static int blue = 8;
	public static int blueFollower = 9;
	public static int stretchSpin = 10;
	public static int stretchLift = 42;
	
	// PCM ports
	public static int driveShiftForward = 0;
	public static int driveShiftReverse = 1;
	public static int tiltForward = 2;
	public static int tiltReverse = 3;
	public static int intakeGripper = 4;
	public static int intakePreventer = 5;
	
	// Digital ports
	public static int intakeBeamBreak = 0;

	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
