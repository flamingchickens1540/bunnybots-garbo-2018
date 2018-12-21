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



        Robot.elevator.setMove(OI.getCoLeftTrigger(), OI.getCoRightTrigger());

    }
}
