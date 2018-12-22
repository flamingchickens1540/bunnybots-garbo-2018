package org.team1540.garbo_code.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {

    public Autonomous() {

        addSequential(new GrabBothAuto());
        addSequential(new DriveForward(1)); //A bit maybe use encoders
        addSequential(new Stop());
        addSequential(new ReleaseBothAuto());
        addSequential(new DriveBackward(0.5)); //A bit maybe use encoders
        addSequential(new Stop());
        addSequential(new TurnLeft(1));
        addSequential(new Stop());
        addSequential(new ElevatorDown());
        addSequential(new DriveForward(1)); //A lot maybe use encoders
        addSequential(new GrabBothAuto()); //A lot maybe use encoders
        addSequential(new DriveForward(2)); //A lot maybe use encoders
        addSequential(new Stop());
        addSequential(new TurnRight(2));
        addSequential(new Stop());
        addSequential(new ElevatorUp());
        addSequential(new DriveForward(3)); //A lot maybe use encoders
        addSequential(new Stop());
        addSequential(new ReleaseBothAuto());

    }

}