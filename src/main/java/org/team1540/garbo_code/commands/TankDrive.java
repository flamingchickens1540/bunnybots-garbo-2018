package org.team1540.garbo_code.commands;

import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.command.Subsystem;
import org.team1540.garbo_code.OI;
import org.team1540.garbo_code.Robot;
//import org.team1540.garbo_code.subsystems.Drivetrain;

public class TankDrive extends Command {

    @Override
    protected boolean isFinished() {
        return false;
    }

    public TankDrive(){

        requires(Robot.drivetrain);


    }

    @Override
    protected void execute() {

        double triggerLeftValue = OI.getDriverLeftTrigger();
        double triggerRightValue = OI.getDriverRightTrigger();
        double axisLeftValue = OI.getDriverLeftAxis();
        double axisRightValue = OI.getDriverRightAxis();

        Robot.drivetrain.setLeft((-1) * ((axisLeftValue + triggerRightValue - triggerLeftValue)));
        Robot.drivetrain.setRight( axisRightValue + triggerRightValue - triggerLeftValue);

    }


}
