package org.team1540.garbo_code.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.team1540.garbo_code.Robot;

public class GrabBothAuto extends Command {

    @Override
    protected boolean isFinished() {
        return true;
    }

    public GrabBothAuto() {

        requires(Robot.grabber);

    }

    @Override
    protected void execute() {

        Robot.grabber.setLeft(0.25);
        Robot.grabber.setRight(0.25);


    }


}
