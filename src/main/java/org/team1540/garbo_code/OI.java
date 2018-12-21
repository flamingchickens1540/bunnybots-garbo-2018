package org.team1540.garbo_code;

import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.buttons.Button;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import org.team1540.rooster.Utilities;

//will need to import commands ?

public class OI {

    static Joystick driver = new Joystick(0);
    static Joystick copilot = new Joystick(1);

    // Buttons
    public static final int A = 1;
    public static final int B = 2;
    public static final int X = 3;
    public static final int Y = 4;
    public static final int LB = 5;
    public static final int RB = 6;
    public static final int BACK = 7;
    public static final int START = 8;

    // Joysticks
    public static final int LEFT_X = 0;
    public static final int LEFT_Y = 1;
    public static final int LEFT_TRIG = 2;
    public static final int RIGHT_TRIG = 3;
    public static final int RIGHT_X = 4;
    public static final int RIGHT_Y = 5;

    //DRIVETRAIN
    public static double getDriverLeftAxis(){
        double value = driver.getRawAxis(LEFT_Y);
        if (Math.abs(value) >= 0.1){
            return value;
        }
        return 0;
    }

    public static double getDriverRightAxis(){
        double value = driver.getRawAxis(RIGHT_Y);
        if (Math.abs(value) >= 0.1){
            return value;
        }
        return 0;
    }

    public static double getDriverLeftTrigger(){
        double value = driver.getRawAxis(LEFT_TRIG);
        if (value >= 0.1){
            return value;
        }
        return 0;
    }

    public static double getDriverRightTrigger(){
        double value = driver.getRawAxis(RIGHT_TRIG);
        if (value >= 0.1){
            return value;
        }
        return 0;
    }

    //ELEVATOR
    public static double getCoLeftTrigger(){
        double value = copilot.getRawAxis(LEFT_TRIG);
        if (value >= 0.1){
            return value;
        }
        return 0;
    }

    public static double getCoRightTrigger(){
        double value = copilot.getRawAxis(RIGHT_TRIG);
        if (value >= 0.1){
            return value;
        }
        return 0;
    }

    //GRABBER
    public static double getCoLeftAxis(){
        double value = copilot.getRawAxis(LEFT_Y);
        if (Math.abs(value) >= 0.1){
            return value;
        }
        return 0;
    }

    public static double getCoRightAxis(){
        double value = copilot.getRawAxis(RIGHT_Y);
        if (Math.abs(value) >= 0.1){
            return value;
        }
        return 0;
    }



}


//this class only has static members
//it holds all my joysticks and buttons
//have functions to get values from joysticks / buttons

