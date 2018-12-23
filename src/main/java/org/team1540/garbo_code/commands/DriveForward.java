package org.team1540.garbo_code.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.team1540.garbo_code.Robot;


public class DriveForward extends Command{

	double time;
	Timer t = new Timer();
	boolean finished;

	public DriveForward(double _time) {
		
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drivetrain);
		finished = false;
		time = _time;

	}
	public DriveForward() {

		// Use requires() here to declare subsystem dependencies
		requires(Robot.drivetrain);
		finished = false;
		time = -1;

	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
		Robot.drivetrain.setLeft(0.3);
		Robot.drivetrain.setRight(-0.3);
		t.reset();
		t.start();
		
	}

	@Override
	protected void execute() {

		if (time != -1 && time < t.get())
		{


			finished = true;

		}

	}

	@Override
	public void end()
	{

		Robot.drivetrain.setLeft(0);
		Robot.drivetrain.setRight(0);

	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return finished;
	}
	
}
