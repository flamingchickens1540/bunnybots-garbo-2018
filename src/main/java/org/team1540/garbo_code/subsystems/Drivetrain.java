package org.team1540.garbo_code.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import org.team1540.garbo_code.commands.TankDrive;
import org.team1540.rooster.ChickenSubsystem;
//import edu.wpi.first.wpilibj.*;
import org.team1540.rooster.wrappers.ChickenTalon;

public class Drivetrain extends ChickenSubsystem {

    ChickenTalon driveLeft1 = new ChickenTalon(1);
    ChickenTalon driveLeft2 = new ChickenTalon(2);
    ChickenTalon driveLeft3 = new ChickenTalon(3);
    ChickenTalon driveRight1 = new ChickenTalon(13);
    ChickenTalon driveRight2 = new ChickenTalon(14);
    ChickenTalon driveRight3 = new ChickenTalon(15);

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand( new TankDrive());
        //this function makes it so that TankDrive is a default command
    }

    public Drivetrain() {

        driveLeft2.set(ControlMode.Follower, driveLeft1.getDeviceID());
        driveLeft3.set(ControlMode.Follower, driveLeft1.getDeviceID());
        driveRight2.set(ControlMode.Follower, driveRight1.getDeviceID());
        driveRight3.set(ControlMode.Follower, driveRight1.getDeviceID());
        //this sets 2 talons on each side to copy the 3rd

        driveLeft1.setBrake(true);
        driveLeft2.setBrake(true);
        driveLeft3.setBrake(true);
        driveRight1.setBrake(true);
        driveRight2.setBrake(true);
        driveRight3.setBrake(true);


    }

    public void setLeft(double num){
        driveLeft1.set(ControlMode.PercentOutput, num);
    }

    public void setRight(double num){
        driveRight1.set(ControlMode.PercentOutput, num);
    }

}



