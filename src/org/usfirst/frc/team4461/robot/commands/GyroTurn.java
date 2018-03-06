package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc.team4461.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GyroTurn extends Command {
	private double degreesToTurn;
	private boolean done = false;
	private static final double DEAD_ZONE = 1.5;
	private static final double SPEED = .175;

	private GyroTurn(double numberOfDegreesToTurn) {
		requires(Robot.m_Gyro);
		degreesToTurn = numberOfDegreesToTurn;
	}

	public static GyroTurn turnLeft(double degreesToTurn) {
		return new GyroTurn(-degreesToTurn);
	}

	public static GyroTurn turnRight(double degreesToTurn) {
		return new GyroTurn(degreesToTurn);
	}

	protected void initialize() {
		Robot.m_Gyro.resetGyro();
		System.out.println("Yes its working");
	}

	protected void execute() {
		double facing = Robot.m_Gyro.getAngle();
		if (Math.abs(facing) > (Math.abs(degreesToTurn) - DEAD_ZONE)
				&& Math.abs(facing) < (Math.abs(degreesToTurn) + DEAD_ZONE)) {
			Robot.m_DriveBase.stopMotors();
			done = true;
		} else if (facing < degreesToTurn) {
			Robot.m_DriveBase.turnRight(SPEED);
			System.out.println("Facing " + facing);
			System.out.println("we are going to the RIGHT");
		} else if (facing > degreesToTurn) {
			Robot.m_DriveBase.turnLeft(SPEED);
			System.out.println("Facing " + facing);
			System.out.println("we are going to the left");
		}
	}

	protected boolean isFinished() {
		return done;
	}

	protected void end() {
		Robot.m_DriveBase.stopMotors();
	}

	protected void interrupted() {
		end();
	}
}