// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Commands.AutoCommands.DriveBCKCommand;
import frc.robot.Commands.AutoCommands.DriveFWDCommand;
import frc.robot.Commands.DriveCommands.DriveWithJoystick;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Subsystems.DrivetrainSubsystem;

public class RobotContainer {

  //Declaring the controller - this example uses a joystick
  //Needs to be public and static
  public static Joystick controller = new Joystick(OperatorConstants.kDriverPort);

  //Importants the subsystems
  private final DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();

  //Importants the commands
  //Goes 'private final Command command = new Command(subsystem);'

  //Drives with the joystick
  private final DriveWithJoystick driveWithJoystick = new DriveWithJoystick(drivetrainSubsystem);

  //Drives forwards
  private final DriveFWDCommand driveFWDCommand = new DriveFWDCommand(drivetrainSubsystem);

  //Drives backwards
  private final DriveBCKCommand driveBCKCommand = new DriveBCKCommand(drivetrainSubsystem);


  //A chooser for auto commands
  SendableChooser<Command> chooser = new SendableChooser<>();

  //Configures the bindings, specifically for higher level things, such as the SendableChooser
  public RobotContainer() {
    configureBindings();

    //Sets an option named "Backwards" to drive the robot backwards
    chooser.setDefaultOption("Backwards", driveBCKCommand);

    //Sets an option named "Forwards" to drive the robot forwards
    chooser.setDefaultOption("Forwards", driveFWDCommand);

    //Puts the chooser on the dashboard
    SmartDashboard.putData(chooser);
    
  }

  //Configures the bindings for commands
  private void configureBindings() {
    //Tells the drivetrainSubsystem that its default command is joystick driving
    drivetrainSubsystem.setDefaultCommand(driveWithJoystick);

    /*
     * Command buttons go
     * 'new JoystickButton(controller, buttonNumber).function(command)'
     * The function can be a variety of things - check the WPILib documentation for more information
     */
    //When the button 9 is pressed, the robot goes forward for two seconds
    new JoystickButton(controller, 9).onTrue(driveFWDCommand);
  }

  //Command to tell which auto command to execute
  public Command getAutonomousCommand() {
    //Tells the robot which command you chose
    return chooser.getSelected();
}
}
