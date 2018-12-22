package org.team1540.garbo_code.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.team1540.garbo_code.Robot;

public class GrabHold extends Command{

    boolean finished;

    @Override
    protected boolean isFinished() {
        return finished;
    }

    public GrabHold(){

        requires(Robot.grabber);
        finished = false;

    }

    @Override
    protected void execute() {

        Robot.grabber.setLeft(0.3);
        Robot.grabber.setRight(0.3);
        finished = false;

    }

}
