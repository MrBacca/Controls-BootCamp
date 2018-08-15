package org.usfirst.frc.team4039.robot.subsystems;

import org.usfirst.frc.team4039.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IntakeJaws extends Subsystem {
	private State state = State.ClosedNoCube;
	
	private enum State {
		Opening,
		Open,
		ClosedNoCube,
		ClosedWithCube;
		
		public Timer time = new Timer();
		State() {
			time.reset();
			time.start();
		}
	}
	
	public void open() {
		switch(this.state) {
		case Opening:
		case Open:
			// Already opening
			break;
		case ClosedNoCube:
		case ClosedWithCube:
			// Start opening
			this.state = State.Opening;
			break;
		}
	}
	
	public void close() {
		switch(this.state) {
		case Opening:
		case Open:
			// Close immedietly
			this.state = State.ClosedNoCube;
			break;
		case ClosedNoCube:
		case ClosedWithCube:
			// Already closed
			break;
		}
	}
	
	Solenoid gripper = new Solenoid(RobotMap.intakeGripper);
	Solenoid preventer = new Solenoid(RobotMap.intakePreventer);
	DigitalInput beamBreak = new DigitalInput(RobotMap.intakeBeamBreak);
	
	@Override
	public void periodic() {
		boolean doGrip = false, doPrevent = false;
		
		switch(state) {
		case ClosedNoCube:
			doGrip = true;
			doPrevent = false;
			
			// Not sure how this could happen, but we should probably do it.
			if(beamBreak.get()) {
				state = State.ClosedWithCube;
			}
			
			break;
		case Opening:
			doGrip = false;
			doPrevent = false;
			
			// Stay for 1s in this state before continuing
			if(state.time.get() < 1.0) {
				break;
			}
			
			// Otherwise, we can be fully open (intentional fallthrough)
			state = State.Open;
		case Open:
			doGrip = false;
			doPrevent = true;
			
			// Stay in this state if we don't have a cube
			if(!beamBreak.get()) {
				break;
			}
			
			// Otherwise, we should grab the cube (intentional fallthrough)
			state = State.ClosedWithCube;
		case ClosedWithCube:
			doGrip = true;
			doPrevent = false;
			
			// This will happen if we eject the cube
			if(!beamBreak.get()) {
				state = State.ClosedNoCube;
			}
			
			break;
		}
		
		gripper.set(doGrip);
		preventer.set(doPrevent);
		
		SmartDashboard.putBoolean("IntakeJaws/HasCube", state == State.ClosedWithCube);
	}
	
	@Override
	protected void initDefaultCommand() {
	}
}

