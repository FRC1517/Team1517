package org.usfirst.frc.team1517.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import org.usfirst.frc.team1517.robot.RobotMap;
import org.usfirst.frc.team1517.robot.commands.DriveTrainCommand;
import org.usfirst.frc.team1517.robot.commands.IntakeCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {

	WPI_TalonSRX LIMotor, RIMotor; 
	SpeedControllerGroup m_intake ;

	// Put methods for controlling this subsystem
    // here. Call these from Commands.

	public IntakeSubsystem()
	{
		LIMotor = new WPI_TalonSRX(RobotMap.LITalon);
		RIMotor = new WPI_TalonSRX(RobotMap.RITalon);
	
		m_intake = new SpeedControllerGroup(LIMotor, RIMotor);
	}
	
	public void intakeDrive(double x)
	{
		System.out.println("intakedrive "+ x );
		if (x > 0.5) {
			x = 0.5 ; 
		}
		m_intake.set(x);
	}
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
	    setDefaultCommand(new IntakeCommand());
    }
}

