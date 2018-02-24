/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1517.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1517.robot.Robot;

/**
 * This command drives the robot over a given distance with simple proportional
 * control This command will drive a given distance limiting to a maximum speed.
 */
public class DriveForward extends Command {
/*	private double m_driveForwardSpeed;
	private double m_distance;
*/	public double m_time;
/*	private double m_error;
	private static final double kTolerance = 0.1;
	private static final double kP = -1.0 / 5.0;
*/	
	public Timer m_timer;
	
	public DriveForward() {
		requires(Robot.DriveTrainSub);
		m_timer = new Timer();
		m_timer.reset();
		m_timer.start();
		m_time = 5 ; 
	}

	@Override
	protected void initialize() {
//		Robot.drivetrain.getRightEncoder().reset();
		setTimeout(2);
	}

	@Override
	protected void execute() {
/*		m_error = m_distance - Robot.drivetrain.getRightEncoder().getDistance();
		if (m_driveForwardSpeed * kP * m_error >= m_driveForwardSpeed) {
			Robot.drivetrain.tankDrive(m_driveForwardSpeed, m_driveForwardSpeed);
		} else {
			Robot.drivetrain.tankDrive(m_driveForwardSpeed * kP * m_error,
					m_driveForwardSpeed * kP * m_error);
		}
*/	
		if (m_timer.get() < m_time) {
			Robot.DriveTrainSub.arcadeDrive(-0.65, 0); // drive forwards half speed
		} else {
			Robot.DriveTrainSub.stop(); // stop robot
		}
		
	}
	

	@Override
	protected boolean isFinished() {
		return false;
	}
	@Override
	protected void end() {
		Robot.DriveTrainSub.stop();
	}
}
