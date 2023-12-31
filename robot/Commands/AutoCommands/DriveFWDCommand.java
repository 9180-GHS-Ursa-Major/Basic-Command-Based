package frc.robot.Commands.AutoCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.DrivetrainSubsystem;

//This will drive the robot forward for two seconds at 50% speed
public class DriveFWDCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    //Once again subsystem that command is using
    private final DrivetrainSubsystem drivetrainSubsystem;

    //Creates a Timer
    //Make sure it is imported from edu.wpi.first.wpilibj.Timer - nothing else
    Timer timer = new Timer();

    //Following the syntax for commands
    public DriveFWDCommand(DrivetrainSubsystem drivetrainSubsystem) {
        this.drivetrainSubsystem = drivetrainSubsystem;
        addRequirements(drivetrainSubsystem);
    }

    //Initializes the command
    @Override
    public void initialize() {
        //Resetting, then starting the timer
        //Important that it is in this order:
        timer.reset();
        timer.start();
        //Sending a message to the console
        System.out.println("Forward!");
    }

    @Override
    public void execute() {
        //Drives forward if the timer is less than 2 seconds
        if (timer.get() < 2) {
            drivetrainSubsystem.arcadeDrive(0.5, 0);
        } else {
            //stops the motors
            drivetrainSubsystem.arcadeDrive(0, 0);
        }
    }

    @Override
    public boolean isFinished() {
        //Tells the command it is finished when the timer is greater than 2 seconds
        return timer.get() > 2;
    }

    
    
}
