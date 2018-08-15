/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4039.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import org.usfirst.frc.team4039.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Stretch extends Subsystem {
  double currentAngle = 0.0;
  boolean isDead = false;

  public void bottom() {
    currentAngle = 0;
  }

  public void tilt() {
    currentAngle = 30;
  }

  public void top() {
    currentAngle = 180;
  }

  public void kill(boolean dead) {
    isDead = dead;
  }

  private TalonSRX lift = new TalonSRX(RobotMap.stretchLift);

  @Override
  public void initDefaultCommand() {
  }

  @Override
  public void periodic() {
    if(isDead) {
      lift.set(ControlMode.PercentOutput, 0.0);
    } else {
      lift.set(ControlMode.Position, currentAngle);
    }
  }
}
