package org.usfirst.frc.team1517.robot.subsystems;

import org.usfirst.frc.team1517.robot.RobotMap;
import org.usfirst.frc.team1517.robot.commands.ElevatorCommand;
import org.usfirst.frc.team1517.robot.commands.WinchCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class WinchSubsystem extends Subsystem {

	SpeedController m_winch; 
	//DifferentialDrive m_robotElevator; 

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public WinchSubsystem()
	{
		m_winch = new WPI_TalonSRX(RobotMap.WITalon);

	}
	
	public void winchDrive(double x)
	{
		System.out.println("winchdrive "+ x  );
		
		m_winch.set(x);
	}

	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new WinchCommand());
    }
}

