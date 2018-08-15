package org.usfirst.frc.team4039.robot.commands.blues;

import org.usfirst.frc.team4039.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunBlues extends Command {

    public RunBlues() {
    	requires(Robot.blues);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.blues.run(true);
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    
    // Called when this command is finished or interrupted
    protected void end() {
    	Robot.blues.run(false);
    }
}
