package org.usfirst.frc.team4039.robot.commands.tilt;

import org.usfirst.frc.team4039.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class TiltDown extends InstantCommand {
    public TiltDown() {
    	requires(Robot.tilt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.tilt.setTilt(false);
    }
}
