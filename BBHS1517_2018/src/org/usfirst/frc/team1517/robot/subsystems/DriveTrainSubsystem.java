package org.usfirst.frc.team1517.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import org.usfirst.frc.team1517.robot.RobotMap;
import org.usfirst.frc.team1517.robot.commands.DriveTrainCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 *
 */
public class DriveTrainSubsystem extends Subsystem {

	WPI_TalonSRX LFMotor, RFMotor, LBMotor, RBMotor; 
	DifferentialDrive m_robotDrive; 
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

	public DriveTrainSubsystem()
	{
		LFMotor = new WPI_TalonSRX(RobotMap.LFTalon);
		LBMotor = new WPI_TalonSRX(RobotMap.LBTalon);
		RFMotor = new WPI_TalonSRX(RobotMap.RFTalon);
		RBMotor = new WPI_TalonSRX(RobotMap.RBTalon);
			
		SpeedControllerGroup m_right = new SpeedControllerGroup(RFMotor, RBMotor);
		SpeedControllerGroup m_left = new SpeedControllerGroup(LFMotor, LBMotor);
		
		m_robotDrive = new DifferentialDrive(m_right, m_left);
		
		m_robotDrive.setSafetyEnabled(false);
	
	}
	
	public void arcadeDrive(double x, double y)
	{
		System.out.println("drivetrainss - acrcadeDrive constructer2 "+ x +" " + y  );
		
		m_robotDrive.arcadeDrive(x,y);
	}
	
	public void stop() {
		m_robotDrive.arcadeDrive(0,0);
	}
		
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
	    setDefaultCommand(new DriveTrainCommand());
    }
}

