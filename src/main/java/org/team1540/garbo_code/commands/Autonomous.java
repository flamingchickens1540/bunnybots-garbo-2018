package org.team1540.garbo_code.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup{

	public Autonomous()
	{

		addSequential(new GrabBothAuto());
		addSequential(new DriveForward(0.5)); //A bit maybe use encoders
		addSequential(new ReleaseBothAuto());
		addSequential(new DriveBackward(0.25)); //A bit maybe use encoders
		addSequential(new TurnLeft(0.25));// whatever 90 degrees is
		addSequential(new ElevatorDown());
		addSequential(new DriveForward(1.5)); //A lot maybe use encoders
		addSequential(new GrabBothAuto()); //A lot maybe use encoders
		addSequential(new DriveForward(2.5)); //A lot maybe use encoders
		addSequential(new TurnLeft(0.5));// whatever 180 degrees is
		addSequential(new ElevatorUp());
		addSequential(new DriveForward(4)); //A lot maybe use encoders
		addSequential(new ReleaseBothAuto());
		
	}

}