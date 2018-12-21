package org.team1540.garbo_code.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.team1540.garbo_code.Robot;

public class GrabHoldRight extends Command{

    @Override
    protected boolean isFinished() {
        return false;
    }

    public GrabHoldRight(){

        requires(Robot.grabber);

    }

    @Override
    protected void execute() {

        Robot.grabber.setRight(0.25);

    }
}
