package org.usfirst.frc.team4461.robot;

import org.usfirst.frc.team4461.robot.commandGroups.TestAutonomous;
import org.usfirst.frc.team4461.robot.commands.ScheduleCommands;
import org.usfirst.frc.team4461.robot.subsystems.DriveBase;
import org.usfirst.frc.team4461.robot.subsystems.Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static OI m_oi;
	public static DriveBase m_DriveBase;
	public static Gyro m_Gyro;

	public static SendableChooser<Command> TestAuto;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	public void listChoosers(SendableChooser<Command> sendableChooser) {
		sendableChooser.addObject("Test Auto Code", new TestAutonomous());
	}

	@Override
	public void robotInit() {
		TestAuto = new SendableChooser<Command>();
		SmartDashboard.putData("Test Autonomous", TestAuto);
		listChoosers(TestAuto);
		m_autonomousCommand = new ScheduleCommands();
		SmartDashboard.putData("Auto mode", m_chooser);

		m_DriveBase = new DriveBase();
		m_Gyro = new Gyro();
		m_oi = new OI();
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
	}
}
