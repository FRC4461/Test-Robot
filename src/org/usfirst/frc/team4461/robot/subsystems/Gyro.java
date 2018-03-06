package org.usfirst.frc.team4461.robot.subsystems;

import org.usfirst.frc.team4461.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Gyro extends Subsystem {

	public void initDefaultCommand() {
	}

	public double getAngle() {
		return RobotMap.gyro.getAngle();
	}

	public void resetGyro() {
		RobotMap.gyro.reset();
	}
}
