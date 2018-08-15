/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4039.robot.commands.drive;

import org.usfirst.frc.team4039.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command {
  private double distance;

  public DriveForward(double distance) {
    requires(Robot.drive);
    this.distance = distance;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.drive.driveForwardTargetDistance(distance);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.drive.driveForwardIsFinished();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {

  }
}
