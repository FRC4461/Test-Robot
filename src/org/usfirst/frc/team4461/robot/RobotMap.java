package org.usfirst.frc.team4461.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;

public class RobotMap {
	public static WPI_TalonSRX frontLeft;
	public static WPI_TalonSRX backLeft;
	public static WPI_TalonSRX frontRight;
	public static WPI_TalonSRX backRight;

	public static ADXRS450_Gyro gyro;

	public static void init() {
		// Drivebase Motors
		frontRight = new WPI_TalonSRX(3);
		frontLeft = new WPI_TalonSRX(4);
		backRight = new WPI_TalonSRX(1);
		backLeft = new WPI_TalonSRX(2);

		// Gyro
		gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
	}
}
