/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1517.robot;

import org.usfirst.frc.team1517.robot.commands.DriveForward;
import org.usfirst.frc.team1517.robot.subsystems.DriveTrainSubsystem;
import org.usfirst.frc.team1517.robot.subsystems.ElevatorSubsystem;
import org.usfirst.frc.team1517.robot.subsystems.WinchSubsystem;
import org.usfirst.frc.team1517.robot.subsystems.IntakeSubsystem;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	public static final DriveTrainSubsystem DriveTrainSub = new DriveTrainSubsystem();
	public static final ElevatorSubsystem ElevatorSub = new ElevatorSubsystem();
	public static final WinchSubsystem WinchSub = new WinchSubsystem();
	public static final IntakeSubsystem IntakeSub = new IntakeSubsystem();
	
	public static OI oi;
	
//	private String m_autoSelected;
	
	Command m_autonomousCommand;
	public SendableChooser<Command> m_autoChooser ;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {

		oi = new OI();
		CameraServer.getInstance().startAutomaticCapture();
		
		// instantiate the command used for the autonomous period
//		m_autoChooser = new SendableChooser<Command>();
//		m_autoChooser.addDefault("Drive Forward", new DriveForward());
//		m_autoChooser.addObject("Drive Forward", new DriveForward());
//		SmartDashboard.putData("Auto Mode", m_autoChooser);

	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = new DriveForward();
		System.out.println("Auto selected: ");
	//	m_autonomousCommand = (Command) m_autoChooser.getSelected();
		m_autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		log();

	}

	/**
	 * This function is called periodically during operator control.
	 */

	@Override
	public void teleopInit() {
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}

	}

	/**
	 * This function is called periodically during teleoperated mode.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

	private void log() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
