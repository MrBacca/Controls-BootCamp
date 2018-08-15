/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4039.robot;

import org.usfirst.frc.team4039.robot.subsystems.Blues;
import org.usfirst.frc.team4039.robot.subsystems.Conveyor;
import org.usfirst.frc.team4039.robot.subsystems.Drive;
import org.usfirst.frc.team4039.robot.subsystems.IntakeJaws;
import org.usfirst.frc.team4039.robot.subsystems.IntakeRollers;
import org.usfirst.frc.team4039.robot.subsystems.Tilt;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static Blues blues;
	public static Conveyor conveyor;
	public static Drive drive;
	public static IntakeJaws intakeJaws;
	public static IntakeRollers intakeRollers;
	public static Tilt tilt;
	
	public static OI oi;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		blues = new Blues();
		conveyor = new Conveyor();
		drive = new Drive();
		intakeJaws = new IntakeJaws();
		intakeRollers = new IntakeRollers();
		tilt = new Tilt();
		
		oi = new OI();

		chooser.addDefault("Drive forward", new DriveForwardAuto());
		chooser.addObject("Drive forward cube", new DriveForwardCube());
		chooser.addObject("Drive forward cube", new AutoWait(new WaitDriveForward(SmartDashboard.getInstance().getDouble("Auto Delay"))));
		
		SmartDashboard.putData("Auto mode", chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		// Stop all commands on state transition
		Scheduler.getInstance().removeAll();
	}

	@Override
	public void disabledPeriodic() {
		oi.periodic();
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		// Stop all commands on state transition
		Scheduler.getInstance().removeAll();
		
		autonomousCommand = chooser.getSelected();

		// schedule the autonomous command (example)
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		oi.periodic();
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// Stop all commands on state transition
		Scheduler.getInstance().removeAll();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		oi.periodic();
		Scheduler.getInstance().run();
	}
	
	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testInit() {
		// Stop all commands on state transition
		Scheduler.getInstance().removeAll();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		oi.periodic();
	}
}
