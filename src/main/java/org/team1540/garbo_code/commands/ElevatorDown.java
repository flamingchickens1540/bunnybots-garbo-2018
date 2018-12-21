package org.team1540.garbo_code.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.team1540.garbo_code.Robot;

//import edu.wpi.first.wpilibj.command.Subsystem;

public class ElevatorDown extends Command{


    boolean finished;
    @Override
    protected boolean isFinished() {
        return finished;
    }

    public ElevatorDown() {

        requires(Robot.elevator);
        finished = false;
    }

    @Override
    protected void execute() {

        if (Robot.elevator.canMoveElevatorDown()) {

            Robot.elevator.setMove(0, 0.5);
        }
        else
        {

            finished = true;

        }

    }
}
