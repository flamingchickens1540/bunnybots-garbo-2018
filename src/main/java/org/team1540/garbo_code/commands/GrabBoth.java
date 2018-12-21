package org.team1540.garbo_code.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.team1540.garbo_code.OI;
import org.team1540.garbo_code.Robot;

public class GrabBoth extends Command{

    @Override
    protected boolean isFinished() {
        return false;
    }

    public GrabBoth(){

        requires(Robot.grabber);

    }

    @Override
    protected void execute() {

        Robot.grabber.setLeft(OI.getCoLeftAxis());
        Robot.grabber.setRight(OI.getCoRightAxis());


    }



}
