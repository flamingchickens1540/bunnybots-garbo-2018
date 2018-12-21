package org.team1540.garbo_code.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.team1540.garbo_code.Robot;

public class GrabHoldLeft extends Command{

    @Override
    protected boolean isFinished() {
        return false;
    }

    public GrabHoldLeft(){

        requires(Robot.grabber);

    }

    @Override
    protected void execute() {

        Robot.grabber.setLeft(0.25);

    }

}
