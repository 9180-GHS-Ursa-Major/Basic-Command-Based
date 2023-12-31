package frc.robot.Subsystems;

import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
//Importing files that will be referenced
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;

//This file is specifically for the subsystem that handles the drivetrain - the four motors that make the robot go
public class DrivetrainSubsystem extends SubsystemBase {
    

    /*
     * Declaring & initializing motor controllers.  They are declared as a Java object of type CANSparkMax
     * The CANSparkMax uses these arguments:
     * CANSparkMax(deviceID, Motor Type);
     * You can also hover the CANSparkMax after new to see this as well
     */
    CANSparkMax frontLeftMotor = new CANSparkMax(DriveConstants.kLM1, MotorType.kBrushed);
    CANSparkMax backLeftMotor = new CANSparkMax(DriveConstants.kLM2, MotorType.kBrushed);
    CANSparkMax frontRightMotor = new CANSparkMax(DriveConstants.kRM1, MotorType.kBrushed);
    CANSparkMax backRightMotor = new CANSparkMax(DriveConstants.kRM2, MotorType.kBrushed);

    //Declaring groups of two motor controllers:
    MotorControllerGroup left = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
    MotorControllerGroup right = new MotorControllerGroup(frontRightMotor, backRightMotor);
    //Front to back doesn't matter, you can adjust for this later in your code.  I like to do front first, then back.

    //Declaring a differential drive - this will allow the robot to drive
    DifferentialDrive drive = new DifferentialDrive(left, right);
    //Here the left size has to be first, then the right

    //This creates a drivetrain subsystem and will run the code inside at at the start
    //Can be blank - but you need this for the robot to work
    public DrivetrainSubsystem() {
        //Just minor upkeep - restores factory defaults in case you forgot to do it before running this.
        //Can comment this part out if wanted, not needed to run
        frontLeftMotor.restoreFactoryDefaults();
        backLeftMotor.restoreFactoryDefaults();
        frontRightMotor.restoreFactoryDefaults();
        backRightMotor.restoreFactoryDefaults();

        //This part here sets the back motor to follow the front motor
        //Once again, safeguarding the robot from problems, though I wouldn't comment this out
        backLeftMotor.follow(frontLeftMotor);
        backRightMotor.follow(frontRightMotor);

        /*
         * If the robot is driving in the opposite direction you mean, you may want to uncomment one or both of these lines
         * Uncomment one if the robot is driving in circles
         * Uncomment two if the robot is driving backwards
        left.setInverted(true);
        right.setInverted(true);
        */
    }

    //A function calling on the arcadeDrive function - will be used in commands
    //Needs to be public and void, but as long as you're consistent, you can name the function and variables whatever
    public void arcadeDrive(double fwd, double rot) {
        drive.arcadeDrive(fwd, rot);
    }
}
