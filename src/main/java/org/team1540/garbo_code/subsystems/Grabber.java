package org.team1540.garbo_code.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import org.team1540.garbo_code.commands.GrabBoth;
import org.team1540.rooster.ChickenSubsystem;
import org.team1540.rooster.wrappers.ChickenTalon;

public class Grabber extends ChickenSubsystem {

    ChickenTalon leftGrab = new ChickenTalon(4);
    ChickenTalon rightGrab = new ChickenTalon(11);

    double speedConstant = 0.5;


    @Override
    protected void initDefaultCommand() {
        setDefaultCommand( new GrabBoth());
        //this function makes it so that moving the grabbers is a default command
    }

    public Grabber(){
        leftGrab.setBrake(true);
        rightGrab.setBrake(true);
    }

    public void setLeft(double num){
        leftGrab.set(ControlMode.PercentOutput, num * speedConstant);
    }

    public void setRight(double num){
        rightGrab.set(ControlMode.PercentOutput, num * speedConstant * (-1));
    }





}
