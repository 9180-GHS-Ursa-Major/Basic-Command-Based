package frc.robot.Commands.AutoCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.DrivetrainSubsystem;

//Drive backwards for two seconds, see DriveFWDCommand for commented code - this follows the same idea
public class DriveBCKCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final DrivetrainSubsystem drivetrainSubsystem;

    Timer timer = new Timer();

    public DriveBCKCommand(DrivetrainSubsystem drivetrainSubsystem) {
        this.drivetrainSubsystem = drivetrainSubsystem;
        addRequirements(drivetrainSubsystem);
    }

    @Override
    public void initialize() {
        //Timer stuff
        timer.reset();
        timer.start();
        System.out.println("Backwards");
    }

    @Override
    public void execute() {
        if (timer.get() < 2) {
            drivetrainSubsystem.arcadeDrive(-0.5, 0);
        } else {
            drivetrainSubsystem.arcadeDrive(0, 0);
        }
    }

    @Override
    public boolean isFinished() {
        return timer.get() > 2;
    }
    
}
