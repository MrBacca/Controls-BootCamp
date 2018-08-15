package org.usfirst.frc.team4039.robot.commands.intakejaws;

import org.usfirst.frc.team4039.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class JawsClose extends InstantCommand {
    public JawsClose() {
    	requires(Robot.intakeJaws);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.intakeJaws.close();
    }
}
