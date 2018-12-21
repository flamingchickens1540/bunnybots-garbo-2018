package org.team1540.garbo_code.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.team1540.garbo_code.OI;
import org.team1540.garbo_code.Ramping;
import org.team1540.garbo_code.Robot;

//import edu.wpi.first.wpilibj.command.Subsystem;
//import org.team1540.garbo_code.subsystems.Drivetrain;

public class ArcadeDrive extends Command {

    Ramping r = new Ramping();

    @Override
    protected boolean isFinished() {
        return false;
    }

    public ArcadeDrive(){

        requires(Robot.drivetrain);


    }

    private double[] getMotorLevels(double input1, double input2, double _left, double _right) {

        double turnError = -0.12; // How much right the robot drives
        double turn = deadzone(input1, 0.15) - turnError;
        double velocity = deadzone(input2, 0.15);
        double left = deadzone(_left, 0.25);
        double right = deadzone(_right, 0.25);
        double levels[] = new double[2];
        final double turnConstant = 1.15; //Some constant to change the turning prolly don't change

        double turnValue = Math.signum(turn) * Math.pow(Math.abs(turn), 1);

        if ((left == 0 && right == 0) || (left != 0 && right != 0)) {

            levels[0] = -velocity * Math.min(1, 1 + turnConstant * turnValue);
            levels[1] = velocity * Math.min(1, 1 - turnConstant * turnValue);

        } else if (left != 0) {

            levels[0] = -left;
            levels[1] = -left;

        } else if (right != 0) {

            levels[0] = right;
            levels[1] = right;

        }

        levels[0] = r.doRamping(0, levels[0], 0.05);
        levels[1] = r.doRamping(1, levels[1], 0.05);

        return levels;
    }

    @Override
    protected void execute() {

        double triggerLeftValue = OI.getDriverLeftTrigger();
        double triggerRightValue = OI.getDriverRightTrigger();
        double axisLeftValue = OI.getDriverLeftAxis();
        double axisRightValue = OI.getDriverRightAxis();

        double[] motorLevels = getMotorLevels(axisLeftValue, axisRightValue, triggerLeftValue, triggerRightValue);

        Robot.drivetrain.setLeft(motorLevels[0]);
        Robot.drivetrain.setRight(motorLevels[1]);

    }


}
