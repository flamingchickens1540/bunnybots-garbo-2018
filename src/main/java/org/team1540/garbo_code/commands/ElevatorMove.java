package org.team1540.garbo_code.commands;

import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.command.Subsystem;
import org.team1540.garbo_code.OI;
import org.team1540.garbo_code.Robot;

public class ElevatorMove extends Command{


    @Override
    protected boolean isFinished() {
        return false;
    }

    public ElevatorMove(){

         requires(Robot.elevator);
    }

    @Override
    protected void execute() {

        if (Robot.elevator.canMoveElevatorUp() && Robot.elevator.canMoveElevatorDown()) {
            //if the elevator is in a position to move up or down
            Robot.elevator.setMove(OI.getCoLeftTrigger(), OI.getCoRightTrigger());
        }

        else if (Robot.elevator.canMoveElevatorDown() && !Robot.elevator.canMoveElevatorUp()){
            //if the elevator could move down but not up
            Robot.elevator.setMove(0.0, OI.getCoRightTrigger());
        }

        else if (Robot.elevator.canMoveElevatorUp() && !Robot.elevator.canMoveElevatorDown()){
            //if the elevator could move up but not down
            Robot.elevator.setMove(OI.getCoLeftTrigger(), 0.0);
        }

    }
}
