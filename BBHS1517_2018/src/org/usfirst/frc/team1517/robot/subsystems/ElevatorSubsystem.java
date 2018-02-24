package org.usfirst.frc.team1517.robot.subsystems;

import org.usfirst.frc.team1517.robot.RobotMap;
import org.usfirst.frc.team1517.robot.commands.ElevatorCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class ElevatorSubsystem extends Subsystem {

	SpeedController m_elevator; 
	//DifferentialDrive m_robotElevator; 

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public ElevatorSubsystem()
	{
		m_elevator = new WPI_TalonSRX(RobotMap.ElTalon);

	}
	
	public void elevatorDrive(double x)
	{
		System.out.println("elevatordrive "+ x  );
		
		m_elevator.set(x);
	}

	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ElevatorCommand());
    }
}

