package org.team1540.garbo_code.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.team1540.garbo_code.Robot;


public class SetTankMode extends Command {

    public SetTankMode() {

        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.drivetrain.driveMode=Robot.drivetrain.TANKDRIVE;

    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return true;
    }

}
