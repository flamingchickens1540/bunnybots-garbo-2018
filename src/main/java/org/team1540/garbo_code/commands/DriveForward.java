package org.team1540.garbo_code.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1540.robot.Robot;
import org.usfirst.frc.team1540.robot.RobotMap;

import java.util.Timer;


public class DriveForward extends Command{

	Timer t = new Timer();
	double time;
	boolean finished;

	public DriveForward(double _time) {
		
		// Use requires() here to declare subsystem dependencies
		requires(Robot.Drivetrain);
		finished = false;
		time = _time;

	}
	public DriveForward() {

		// Use requires() here to declare subsystem dependencies
		requires(Robot.Drivetrain);
		finished = false;
		time = 0;

	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
		Robot.Drivetrain.setLeft(0.5);
		Robot.Drivetrain.setRight(0.5);
		t.reset();
		t.start();
		
	}

	@Override
	protected void execute() {

		if (time != 0 && t.get() > time)
		{

			finished = true;

		}



	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return finished;
	}
	
}
