package commandGroups;

import org.usfirst.frc4461.PapaGurGur.commands.EncoderDrive;
import org.usfirst.frc4461.PapaGurGur.commands.GyroTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TestAutonomous extends CommandGroup {

    public TestAutonomous() {
    	addSequential(EncoderDrive.goForwardInches(20));
    	addSequential(GyroTurn.turnRight(90));
    	addSequential(GyroTurn.turnLeft(90));
    }
}
