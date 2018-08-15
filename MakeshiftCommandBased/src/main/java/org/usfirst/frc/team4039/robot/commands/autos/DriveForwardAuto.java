package org.usfirst.frc.team4039.robot.commands.autos;

import org.usfirst.frc.team4039.robot.commands.drive.DriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveForwardAuto extends CommandGroup {
    public DriveForwardAuto() {
        addSequential(new DriveForward(5.0));
    }
}