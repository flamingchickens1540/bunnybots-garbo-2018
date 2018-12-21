package org.team1540.garbo_code.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import org.checkerframework.checker.units.qual.C;
import org.team1540.rooster.ChickenSubsystem;
import org.team1540.rooster.wrappers.ChickenTalon;
import org.team1540.garbo_code.commands.ElevatorMove;

public class Elevator extends ChickenSubsystem {

    ChickenTalon elevator1 = new ChickenTalon(20);

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand( new ElevatorMove());
        //this function makes it so that moving the elevator is a default command
    }

    public Elevator(){
        elevator1.setBrake(true);
    }

    public void setMove(double numLeft, double numRight){

        elevator1.set(ControlMode.PercentOutput, (numLeft - numRight));

    }

   // public void moveDown(double numLeft){
   //     elevator1.set(ControlMode.PercentOutput, numLeft);
   // }
}
