/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4039.robot.commands.stretch;

import org.usfirst.frc.team4039.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class StretchLift extends InstantCommand {
  public StretchLift() {

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.stretch.top();
  }
}
