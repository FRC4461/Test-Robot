package org.usfirst.frc.team4461.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {

	public static Joystick lJoy = new Joystick(0);
	public static Joystick rJoy = new Joystick(1);

	public OI() {
	}

	/**
	 * Gets the Y axis value of the left joystick
	 * 
	 * @return
	 */
	public static double lJoyGetY() {
		return lJoy.getY();
	}

	/**
	 * Gets the Y axis value of the right joystick
	 * 
	 * @return
	 */
	public static double rJoyGetY() {
		return rJoy.getY();
	}
}
