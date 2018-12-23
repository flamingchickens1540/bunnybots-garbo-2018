package org.team1540.garbo_code.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {

    public Autonomous() {

        addSequential(new GrabBothAuto());
        addSequential(new DriveForward(1));
//        addSequential(new Stop());
        addSequential(new ReleaseBothAuto());

    }

}