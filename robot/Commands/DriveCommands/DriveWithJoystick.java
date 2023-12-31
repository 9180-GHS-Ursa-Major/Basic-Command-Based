package frc.robot.Commands.DriveCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Subsystems.DrivetrainSubsystem;

public class DriveWithJoystick extends CommandBase {
   //I honestly have no idea what it is but it's here and important
   @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
   //Calls on the subsystem that the command uses
   private final DrivetrainSubsystem drivetrainSubsystem;

   //Creates the command - needs to be as such
   /*
    * public fileName(Subsystem subsystem) {
        this.subsystem = subsystem;
        addrequirements(subsystem);
    }
    */
   public DriveWithJoystick(DrivetrainSubsystem drivetrainSubsystem) {
    //Localizes the drivetrainsubsystem variable
    this.drivetrainSubsystem = drivetrainSubsystem;
    //Tells the robot "oi you need drivetrainSubsystem to do this"
    addRequirements(drivetrainSubsystem);
   }

   //@Override means that this takes over everything
   //This function is called when the command starts - usually used to check if the command is starting
   @Override
   public void initialize() {
    //I like to print out a sentence or something
    System.out.println("Starting joystick drive command");
   }

   //This is what the command actually does
   @Override
   public void execute() {
    //Gets the value of the Y axis of the controller, puts into a double called spd
    double spd = RobotContainer.controller.getY();

    //Gets the value of the X axis of the controller, put into a double called rot
    double rot = RobotContainer.controller.getX();

    //The @link function isn't working for some reason but live and let live I guess
    /**
     * Calls the {@link DrivetrainSubsystem#arcadeDrive} that was defined in DrivetrainSubsystem.java
     */
    drivetrainSubsystem.arcadeDrive(spd, rot);
   }

   //This function tells the robot when the command is finished
   //Since this command should never be finished, it simply isn't
   @Override
   public boolean isFinished() {
    return false;
   }
}
