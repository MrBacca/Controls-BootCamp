/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4039.robot.commands.autos;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class SwitchSide extends Command {
  Command left, right;
  boolean finished;

  public SwitchSide(Command left, Command right) {
    this.left = left;
    this.right = right;
  }

  @Override
  protected void initialize() {
    finished = false;
  }

  // Called just before this Command runs the first time
  @Override
  protected void execute() {
    char side = DriverStation.getInstance().getGameSpecificMessage().charAt(0);
    switch(side) {
    case 'R':
      right.start();
      finished = true;
      break;
    case 'L':
      left.start();
      finished = true;
      break;
    default:
    }
  }

  protected boolean isFinished() {
    return this.finished;
  }
}
