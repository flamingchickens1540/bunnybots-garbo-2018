package org.team1540.garbo_code.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.DigitalInput;
import org.team1540.garbo_code.commands.ElevatorMove;
import org.team1540.rooster.ChickenSubsystem;
import org.team1540.rooster.wrappers.ChickenTalon;

public class Elevator extends ChickenSubsystem {

    ChickenTalon elevator1 = new ChickenTalon(20);
    public DigitalInput elevatorBottomSwitch = new DigitalInput(8);
    public DigitalInput elevatorTopSwitch = new DigitalInput(9);

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand( new ElevatorMove());
        //this function makes it so that moving the elevator is a default command
    }

    public Elevator(){
        elevator1.setBrake(true);
    }
    //left is up, right is down
    public void setMove(double numLeft, double numRight){

        elevator1.set(ControlMode.PercentOutput, (numLeft - numRight));

    }

    public boolean canMoveElevatorUp(){
        return (elevatorTopSwitch.get());
    }
    public boolean canMoveElevatorDown(){
        return (elevatorBottomSwitch.get());
    }

}
