package commandGroups;

import org.usfirst.frc.team4461.robot.commands.EncoderDrive;
import org.usfirst.frc.team4461.robot.commands.GyroTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TestAutonomous extends CommandGroup {

    public TestAutonomous() {
    	addSequential(EncoderDrive.goForwardInches(20));
    }
}
