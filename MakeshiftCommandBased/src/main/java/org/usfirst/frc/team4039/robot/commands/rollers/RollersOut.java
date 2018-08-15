package org.usfirst.frc.team4039.robot.commands.rollers;

import org.usfirst.frc.team4039.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RollersOut extends Command {
    public RollersOut() {
    	requires(Robot.intakeRollers);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.intakeRollers.runOut();
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    
    // Called when this command is finished or interrupted
    protected void end() {
    	Robot.intakeRollers.stop();
    }
}
