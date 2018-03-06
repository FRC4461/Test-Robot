package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc.team4461.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ScheduleCommands extends Command {

	String gameData;

	public ScheduleCommands() {
	}

	protected void initialize() {
		System.out.println("Call Scheduler");
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData.charAt(0) == 'L') {
			if (gameData.charAt(1) == 'L') {
				Robot.TestAuto.getSelected().start();
			} else if (gameData.charAt(1) == 'R') {
				Robot.TestAuto.getSelected().start();
			}
		} else if (gameData.charAt(0) == 'R') {
			if (gameData.charAt(1) == 'R') {
				Robot.TestAuto.getSelected().start();
			} else if (gameData.charAt(1) == 'L') {
				Robot.TestAuto.getSelected().start();
			}
		}
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}