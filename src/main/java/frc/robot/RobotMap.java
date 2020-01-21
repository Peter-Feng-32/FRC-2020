/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.

  // Drivetrain Motor Controllers
  public static int frontLeftDriveMotorController = 1;
  public static int backLeftDriveMotorController = 2;
  public static int frontRightDriveMotorController = 4;
  public static int backRightDriveMotorController = 3;

  // Intake motor controllers
  public static int intakeMotor1ID = 8;
  public static int intakeMotor2ID = 9;

  // Shooter motor controllers
  public static int shooterMotorID = 5;
  public static int panMotorID = 6;
  public static int tiltMotorID = 7;

  // Driver Input Devices
  public static int leftJoystickPort = 0;

  // *** Closed loop constants ***

  // How long we wait for a configuration change to happen before we give up and report a failure in miliseconds
  public final static int configureTimeoutMs = 30;
  // How many encoder clicks per revolution
  public final static int encoderUnitsPerShaftRotation = 4096;
  // The difference between the left and right side encoder values when the robot is rotated 180 degrees
  public final static int encoderUnitsPerRobotRotation = 38585;
  // How many miliseconds between each closed loop call
  public final static int closedLoopPeriodMs = 1;
	// Motor neutral dead-band, set to the minimum 0.1%
  public final static double NeutralDeadband = 0.001;

  
  /**
	 * PID Gains may have to be adjusted based on the responsiveness of control loop.
     * kF: 1023 represents output value to Talon at 100%, 6800 represents Velocity units at 100% output
     * Not all set of Gains are used in this project and may be removed as desired.
     * 
	 * 	                                    			  kP   kI   kD   kF               Iz    PeakOut */
  /*
	public final static Gains kGains_Distanc = new Gains( 0.1, 0.0,  0.0, 0.0,            100,  0.50 );
	public final static Gains kGains_Turning = new Gains( 2.0, 0.0,  4.0, 0.0,            200,  1.00 );
	public final static Gains kGains_Velocit = new Gains( 0.1, 0.0, 20.0, 1023.0/6800.0,  300,  0.50 );
	public final static Gains kGains_MotProf = new Gains( 1.0, 0.0,  0.0, 1023.0/6800.0,  400,  1.00 );
  */

  // Closed loop PID parameter values
  public final static double P_0 = 0;
	public final static double I_0 = 0;
	public final static double D_0 = 0;
	public final static double F_0 = 0;
	public final static int Izone_0 = 0;
  public final static double PeakOutput_0 = 0;

  // Closed loop PID parameter values  
  public final static double P_1 = 0;
	public final static double I_1 = 0;
	public final static double D_1 = 0;
	public final static double F_1 = 0;
	public final static int Izone_1 = 0;
  public final static double PeakOutput_1 = 0;

  // ---- Flat constants, you should not need to change these ---- 
	// We allow either a 0 or 1 when selecting an ordinal for remote devices [You can have up to 2 devices assigned remotely to a talon/victor]
	public final static int REMOTE_0 = 0;
	public final static int REMOTE_1 = 1;
	// We allow either a 0 or 1 when selecting a PID Index, where 0 is primary and 1 is auxiliary
	public final static int PID_PRIMARY = 0;
	public final static int PID_TURN = 1;
	// Firmware currently supports slots [0, 3] and can be used for either PID Set
	public final static int SLOT_0 = 0;
	public final static int SLOT_1 = 1;
	public final static int SLOT_2 = 2;
  public final static int SLOT_3 = 3;
  

  // ---- End closed loop parameter constants ----

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
