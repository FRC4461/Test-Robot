package org.usfirst.frc.team4461.robot.subsystems;

import org.usfirst.frc.team4461.robot.RobotMap;
import org.usfirst.frc.team4461.robot.commands.Driving;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveBase extends Subsystem {
	DifferentialDrive drive;

	public DriveBase() {
	}

	public void initDefaultCommand() {
		setDefaultCommand(new Driving());
	}

	/**
	 * Stops all DriveBase motors This is useful for encapsulation and you don't
	 * have to set Every motor to 0 in commands
	 */
	public void stopMotors() {
		RobotMap.frontLeft.set(0);
		RobotMap.backLeft.set(0);
		RobotMap.frontRight.set(0);
		RobotMap.backRight.set(0);
	}

	/**
	 * Turns right The speeds are set the same because 2 of the motors are backwards
	 * 
	 * @param SPEED
	 */
	public void turnRight(double speed) {
		RobotMap.frontLeft.set(speed);
		RobotMap.backLeft.set(speed);
		RobotMap.frontRight.set(speed);
		RobotMap.backRight.set(speed);
	}

	/**
	 * Turns left Speeds are set the same because 2 motors are backwards
	 * 
	 * @param SPEED
	 */
	public void turnLeft(double speed) {
		RobotMap.frontLeft.set(-speed);
		RobotMap.backLeft.set(-speed);
		RobotMap.frontRight.set(-speed);
		RobotMap.backRight.set(-speed);
	}

	/**
	 * This is the configuration to make the encoders work
	 */
	public void ConfigEncoder() {
		RobotMap.backLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 1);
		RobotMap.backLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 1);
		RobotMap.backLeft.setSelectedSensorPosition(0, 0, 1);
		RobotMap.backLeft.setSensorPhase(true);
		RobotMap.backLeft.setSafetyEnabled(false);
		RobotMap.frontLeft.setInverted(true);
		RobotMap.backLeft.setInverted(true);

		RobotMap.frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 1);
		RobotMap.frontRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 1);
		RobotMap.frontRight.setSelectedSensorPosition(0, 0, 1);
		RobotMap.frontRight.setSensorPhase(true);
		RobotMap.frontRight.setSafetyEnabled(false);

		RobotMap.frontLeft.setSafetyEnabled(false);
		RobotMap.backLeft.setSafetyEnabled(false);

		System.out.println("encoder initialize");
	}

	/**
	 * After autonomous routines, set the configuration back to normal for driving
	 */
	public void resetMotors() {
		RobotMap.frontLeft.setSafetyEnabled(true);
		RobotMap.backLeft.setSafetyEnabled(true);
		RobotMap.frontRight.setSafetyEnabled(true);
		RobotMap.backLeft.setSafetyEnabled(true);

		RobotMap.frontRight.setInverted(false);
		RobotMap.backRight.setInverted(false);
		RobotMap.frontLeft.setInverted(false);
		RobotMap.backLeft.setInverted(false);
		System.out.println(RobotMap.backLeft.getSelectedSensorPosition(0));
	}

	/**
	 * The command takes in the joystick axis value and then sets the motor speed
	 * 
	 * @param lSpeed
	 * @param rSpeed
	 */
	public void drive(double lSpeed, double rSpeed) {
		RobotMap.frontLeft.set(ControlMode.PercentOutput, -lSpeed);
		RobotMap.backLeft.set(ControlMode.PercentOutput, -lSpeed);
		RobotMap.frontRight.set(ControlMode.PercentOutput, rSpeed);
		RobotMap.backRight.set(ControlMode.PercentOutput, rSpeed);
	}

	/**
	 * Use encoder ticks to move the robot autonomously. Set inverted because of the
	 * way the motors are setup
	 * 
	 * @param countsToMove
	 */
	public void moveEncoder(double countsToMove) {
		RobotMap.backLeft.set(ControlMode.Position, countsToMove);
		RobotMap.frontLeft.set(ControlMode.Follower, RobotMap.backLeft.getDeviceID());
		RobotMap.frontRight.set(ControlMode.Position, countsToMove);
		RobotMap.backRight.set(ControlMode.Follower, RobotMap.frontRight.getDeviceID());
	}
}