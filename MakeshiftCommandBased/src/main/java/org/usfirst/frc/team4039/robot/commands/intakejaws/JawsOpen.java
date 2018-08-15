package org.usfirst.frc.team4039.robot.commands.intakejaws;

import org.usfirst.frc.team4039.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class JawsOpen extends InstantCommand {
    public JawsOpen() {
    	requires(Robot.intakeJaws);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.intakeJaws.open();
    }
}
