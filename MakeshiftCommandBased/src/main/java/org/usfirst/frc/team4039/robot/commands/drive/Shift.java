package org.usfirst.frc.team4039.robot.commands.drive;

import org.usfirst.frc.team4039.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Shift extends Command {
    public Shift() {
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.setShift(true);
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    
    // Called when this command is finished or interrupted
    protected void end() {
    	Robot.drive.setShift(false);
    }
}
