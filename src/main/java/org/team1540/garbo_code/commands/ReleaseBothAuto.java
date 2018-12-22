package org.team1540.garbo_code.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.team1540.garbo_code.Robot;

public class ReleaseBothAuto extends Command{

    Timer timer = new Timer();
    boolean finished = false;

    public ReleaseBothAuto(){

        requires(Robot.grabber);

    }

    @Override
    protected void initialize() {
        timer.reset();
        timer.start();
    }

    @Override
    protected boolean isFinished() {
        return finished;
    }

    @Override
    protected void execute() {

        if (timer.get() < 2.0)
        {

            Robot.grabber.setLeft(-0.25);
            Robot.grabber.setRight(-0.25);

        }
        else
        {

            finished = true;

        }

    }

    protected void end() {

        Robot.grabber.setLeft(0);
        Robot.grabber.setRight(0);

    }



}
