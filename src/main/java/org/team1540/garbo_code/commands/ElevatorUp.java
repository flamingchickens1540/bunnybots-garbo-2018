package org.team1540.garbo_code.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.team1540.garbo_code.Robot;

//import edu.wpi.first.wpilibj.command.Subsystem;

public class ElevatorUp extends Command{


    boolean finished;
    @Override
    protected boolean isFinished() {
        return finished;
    }

    public ElevatorUp(){

         requires(Robot.elevator);
         finished = false;
    }

    @Override
    protected void execute() {

        if (Robot.elevator.canMoveElevatorUp()) {

            Robot.elevator.setMove(0.2, 0);
        }
        else
        {

            Robot.elevator.setMove(0, 0);
            finished = true;

        }

    }
}
