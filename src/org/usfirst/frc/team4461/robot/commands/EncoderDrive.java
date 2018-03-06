package org.usfirst.frc.team4461.robot.commands;

import org.usfirst.frc.team4461.robot.Robot;
import org.usfirst.frc.team4461.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderDrive extends Command {
	private static final int COUNTS_PER_REVOLUTION = 1024;
	private static final double WHEEL_CIRCUMFERENCE = 6 * Math.PI;
	private static final double GEAR_REDUCTION = ((45.0 / 19.0) * (50.0 / 14.0));
	private static final double COUNTS_PER_INCH = COUNTS_PER_REVOLUTION * GEAR_REDUCTION / WHEEL_CIRCUMFERENCE;
	// private static final int DEAD_ZONE = (int) COUNTS_PER_INCH * 1;
	private double countsToMove;

	private EncoderDrive(double inchesToMove) {
		requires(Robot.m_DriveBase);
		countsToMove = inchesToMove * COUNTS_PER_INCH;
	}

	public static EncoderDrive goForwardInches(double inchesToMove) {
		return new EncoderDrive(-inchesToMove);
	}

	public static EncoderDrive goBackwardInches(double inchesToMove) {
		return new EncoderDrive(inchesToMove);
	}

	protected void initialize() {
		Robot.m_DriveBase.ConfigEncoder();
		Robot.m_DriveBase.moveEncoder(countsToMove);
	}

	/**
	 * The set functions MUST be in execute because motor safety is off Motor safety
	 * requires that speed be set constantly Also, PID is set through the website,
	 * not in code
	 */
	protected void execute() {
		System.out.println("");
		System.out.println("sensorPos: " + RobotMap.backLeft.getSelectedSensorPosition(0) + " , "
				+ RobotMap.frontRight.getSelectedSensorPosition(0));
	}

	protected boolean isFinished() {
		if (Math.abs(RobotMap.backLeft.getSelectedSensorPosition(0)) > Math.abs(countsToMove)) {
			System.out.println("Done");
			return true;
		}
		return false;
	}

	protected void end() {
		Robot.m_DriveBase.resetMotors();
		Robot.m_DriveBase.stopMotors();
	}

	protected void interrupted() {
		end();
	}
}