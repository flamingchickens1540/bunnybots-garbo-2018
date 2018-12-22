package org.team1540.garbo_code.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.team1540.garbo_code.OI;
import org.team1540.garbo_code.Robot;

public class GrabSimulBoth extends Command{

    @Override
    protected boolean isFinished() {
        return false;
    }

    public GrabSimulBoth(){

        requires(Robot.grabber);

    }

    @Override
    protected void execute() {

        Robot.grabber.setLeft(0.5*(OI.getCoLeftAxis()+OI.getCoRightAxis()));
        Robot.grabber.setRight(0.5*(OI.getCoLeftAxis()+OI.getCoRightAxis()));


    }



}
