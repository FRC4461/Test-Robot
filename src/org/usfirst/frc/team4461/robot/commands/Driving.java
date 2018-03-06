package org.usfirst.frc.team4461.robot.commands;

import org.usfirst.frc.team4461.robot.OI;
import org.usfirst.frc.team4461.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Driving extends Command {

	public Driving() {
		requires(Robot.m_DriveBase);
	}

	protected void initialize() {
	}

	protected void execute() {
		double lSpeed = OI.lJoyGetY();
		double rSpeed = OI.rJoyGetY();
		Robot.m_DriveBase.drive(lSpeed, rSpeed);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
