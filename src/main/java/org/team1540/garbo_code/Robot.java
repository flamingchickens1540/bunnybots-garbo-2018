package org.team1540.garbo_code;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team1540.garbo_code.commands.*;
import org.team1540.garbo_code.subsystems.Drivetrain;
import org.team1540.garbo_code.subsystems.Elevator;
import org.team1540.garbo_code.subsystems.Grabber;

/**
 PDP port - CAN ID - motor function:
 0 - 20 - elevator
 1 - 1 - drive left
 2 - 2 - drive left
 3 - 3 - drive left
 4 - 4 - intake left (30 amps)
 11 - 11 - intake right (30 amps)
 13 - 13 - drive right
 14 - 14 - drive right
 15 - 15 - drive right
 */

public class Robot extends IterativeRobot {

    public static Drivetrain drivetrain = new Drivetrain();
    public static Elevator elevator = new Elevator();
    public static Grabber grabber = new Grabber();

    private Command autonomousCommand;

    @Override
    public void robotInit() {

        Button coLB = new JoystickButton(OI.copilot, OI.LB);
        coLB.toggleWhenPressed(new GrabHold());

        Button coRB = new JoystickButton(OI.copilot, OI.RB);
        coRB.toggleWhenPressed(new ReleaseBothAuto());

        Button coY = new JoystickButton(OI.copilot, OI.Y);
        coY.toggleWhenPressed(new ElevatorUp());

        Button coX = new JoystickButton(OI.copilot, OI.X);
        coX.toggleWhenPressed(new GrabHold());

        Button coA = new JoystickButton(OI.copilot, OI.A);
        coA.toggleWhenPressed(new ElevatorDown());

        Button coB = new JoystickButton(OI.copilot, OI.B);
        coB.toggleWhenPressed(new ReleaseBothAuto());

        Button drA = new JoystickButton(OI.driver, OI.A);
        drA.toggleWhenPressed(new SetArcadeMode());

        Button drB = new JoystickButton(OI.driver, OI.B);
        drB.toggleWhenPressed(new SetTankMode());

        UsbCamera camera = CameraServer.getInstance().startAutomaticCapture(0);
        camera.setResolution(128, 73);
        camera.setFPS(30);


    }


    @Override
    public void disabledInit() {

    }

    @Override
    public void autonomousInit() {
        autonomousCommand = new Autonomous();
        autonomousCommand.start();
    }

    @Override
    public void teleopInit() {
        if (autonomousCommand != null)
            autonomousCommand.cancel();
    }

    @Override
    public void testInit() {

    }

    @Override
    public void robotPeriodic() {
        //called every 30 ish milliseconds
        Scheduler.getInstance().run();
        //^ handles all command logic, very important
        //
        //System.out.println(elevator.canMoveElevatorDown());

        SmartDashboard.putBoolean("is elevator at top?", ! elevator.canMoveElevatorUp());
        SmartDashboard.putNumber("TEST TEST", 1);
        SmartDashboard.putBoolean("is elevator at bottom?", ! elevator.canMoveElevatorDown());
        SmartDashboard.putNumber("TEST TEST", 2);


        //System.out.println(drivetrain.getLeftPos());
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
}







////////////////////////////////////////////////////////////////////////////////////////////////////////////

//DONE in this class, make a static instance of each subsystem

//a command is a single action: "do tank drive," "drop cube," etc
    //command groups can run many commands as a sequence
//commands can (but dont have to) require one or more subsystems
//command framework makes sure that each subsystem is only being run by one thing at a time
//if a command requires a subsytem that is already being used, it stops the previous user
//ways to trigger commands:
    //bind command to button -
        //when pressed (define functions in robot init, define buttons in OI)
        //while held (starts when holding button, interrupts command on button release)
    //call command.start, create a new instance of the command, then call start on it
    //default commands (do this for tank drive command)
        //bind in "init default command" function of the subsystem, using "set default command"
        //is running when no other commands are running the subsystems


//interesting idea: tuning ??
    // "tuning is just numbers. magic numbers that you have" - Zack



/**

 subsystems:
    a mechanism / drivetrain
    define motors and sensors here
    make functions that can move them, example: a tank drive function
    other example: set elevator to some spot

 commands:
    the place where you call the functions from the subsystem
    do this:
    @override
    protected void _______ ----- this is the functions, get doc from Amber
    "schedule" will automatically call if command is "started"
    when a command is started, it will call initiate, then execute over and over until done, and will call end when done


 **/