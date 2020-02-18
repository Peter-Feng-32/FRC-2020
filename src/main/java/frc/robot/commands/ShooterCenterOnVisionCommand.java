/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ShooterCenterOnVisionCommand extends Command {
  public ShooterCenterOnVisionCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.shooterSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    double panVal = Math.signum(Robot.shooterSubsystem.getDifferenceFromMiddleX()) * 0.5;
    Robot.shooterSubsystem.pan(panVal);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    boolean retVal = false;
    retVal = Robot.shooterSubsystem.getCenteredX();
    return retVal;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.shooterSubsystem.pan(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.shooterSubsystem.pan(0);
  }
}
