/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.robot.RobotMap;

public class ShootAndRunAuto extends CommandGroup {

  //TODO: Add shooting code to autonomous sequence

  public static int startingRotation = 1;
  // 1 is pointing towards the target, 2 is 90 degrees to the right of 1, 3 is 180 degrees, 4 is 270 degrees

  public static double xPositionIn = 0;
  public static double yPositionIn = 228.59;
  // X position is distance from the starting line (negative X pointing towards the target)
  /* Y position is distance from the far wall of the field -- the side with the other team's ball dispenser
      Field is 323.5 in long
      228.59 when starting in the big shot zone
      276.75 + RobotMap.robotLength / 2 when the front is aligned with the outer line of the trench
      161.75 when the center of the robot is aligned with the center of the starting line*/

  public ShootAndRunAuto(boolean shootingFromCenter) {
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.


    /* Robot shoots its pre-loaded balls */
    addSequential(new DriveZeroEncodersCommand());
    if(shootingFromCenter == true) {
      if(yPositionIn == 228.59) {
        // — — — — PUT SHOOTING CODE (for sweetspot) HERE — — — —
      } else {
        addSequential(new WaitCommand(.1));
        if(startingRotation == 4 && yPositionIn > 228.59 || startingRotation == 2 && yPositionIn < 228.59){
          addSequential(new DriveForwardCommand((int) Math.round(Math.abs(228.59 - yPositionIn) * RobotMap.encoderTicksPerInch)));
          addSequential(new DriveStopCommand());
          yPositionIn = 228.59;
        } else {System.out.println("Auto: Something's wrong with initial position");}
        // — — — — PUT SHOOTING CODE (for sweetspot) HERE — — — —
      }
    } else {
      // — — — — PUT SHOOTING CODE (for non-sweetspot / angled) HERE — — — —
    }
    
    /* Robot gets out of the way */
    addSequential(new WaitCommand(.1));
    switch(startingRotation) {
      case 1:
        addSequential(new DriveTurnCommand(-30));
        break;
      case 2:
        addSequential(new DriveTurnCommand(-120));
        break;
      case 3:
        addSequential(new DriveTurnCommand(120));
        break;
      case 4:
        addSequential(new DriveTurnCommand(60));
        break;
    }
    addSequential(new DriveStopCommand());

    addSequential(new WaitCommand(.1));
    addSequential(new DriveForwardCommand(80 * RobotMap.encoderTicksPerInch));
    addSequential(new DriveStopCommand());
    addSequential(new WaitCommand(0.1));

    addSequential(new DriveTurnCommand(-150));
    addSequential(new DriveStopCommand());
    addSequential(new WaitCommand(0.1));
    
    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
  }

  public ShootAndRunAuto(boolean shootingFromCenter, double yPositionBuddy) {
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.


    /* Robot shoots its pre-loaded balls */
    addSequential(new DriveZeroEncodersCommand());
    if(shootingFromCenter == true) {
      if(yPositionIn == 228.59) {
        // — — — — PUT SHOOTING CODE (for sweetspot) HERE — — — —
      } else {
        addSequential(new WaitCommand(.1));
        // Can add delay here if needed
        if(startingRotation == 4 && yPositionIn > 228.59 || startingRotation == 2 && yPositionIn < 228.59){
          addSequential(new DriveForwardCommand((int) Math.round(Math.abs(228.59 - yPositionIn) * RobotMap.encoderTicksPerInch)));
          addSequential(new DriveStopCommand());
          yPositionIn = 228.59;
        } else {System.out.println("Auto: Something's wrong with initial position");}
        // — — — — PUT SHOOTING (for sweetspot) CODE HERE — — — —
      }
    } else {
      // — — — — PUT SHOOTING CODE (for non-sweetspot / angled) HERE — — — —
    }
    
    /* Robot prepares to push non-autonomous friend */
    addSequential(new WaitCommand(.1));
    if(shootingFromCenter == true) {
    switch(startingRotation) {
      case 1:
        addSequential(new DriveTurnCommand(180));
        break;
      case 2:
        addSequential(new DriveTurnCommand(90));
        break;
      case 3:
        break;
      case 4:
      addSequential(new DriveTurnCommand(-90));
      }
    }
    addSequential(new DriveStopCommand());

    addSequential(new WaitCommand(.1));
    addSequential(new DriveForwardCommand((int) Math.round(Math.abs(50 - xPositionIn) * RobotMap.encoderTicksPerInch)));
    addSequential(new DriveStopCommand());
    xPositionIn = 50;

    if(yPositionBuddy > yPositionIn) {
      addSequential(new WaitCommand(.1));
      addSequential(new DriveTurnCommand(-90));
      addSequential(new DriveStopCommand());

      addSequential(new WaitCommand(.1));
      addSequential(new DriveForwardCommand((int) Math.round(Math.abs(yPositionBuddy - yPositionIn) * RobotMap.encoderTicksPerInch)));
      addSequential(new DriveStopCommand());
      yPositionIn = yPositionBuddy;

      addSequential(new WaitCommand(.1));
      addSequential(new DriveTurnCommand(-90));
      addSequential(new DriveStopCommand());
      /* Robot pushes poor non-autonomous friend*/
      addSequential(new WaitCommand(.1));
      addSequential(new DriveForwardCommand((int) Math.round(Math.abs(xPositionIn * 2.25) * RobotMap.encoderTicksPerInch)));
      addSequential(new DriveStopCommand());

      /* Robot positions itself for game start*/
      addSequential(new WaitCommand(.1));
      addSequential(new DriveTurnCommand(-90));
      addSequential(new DriveStopCommand());

      addSequential(new WaitCommand(.1));
      addSequential(new DriveForwardCommand(RobotMap.robotLength * RobotMap.encoderTicksPerInch));
      addSequential(new DriveStopCommand());

      addSequential(new WaitCommand(.1));
      addSequential(new DriveTurnCommand(-90));
      addSequential(new DriveStopCommand());
    } else {
      addSequential(new WaitCommand(.1));
      addSequential(new DriveTurnCommand(90));
      addSequential(new DriveStopCommand());

      addSequential(new WaitCommand(.1));
      addSequential(new DriveForwardCommand((int) Math.round(Math.abs(yPositionBuddy - yPositionIn) * RobotMap.encoderTicksPerInch)));
      addSequential(new DriveStopCommand());
      yPositionIn = yPositionBuddy;

      addSequential(new WaitCommand(.1));
      addSequential(new DriveTurnCommand(90));
      addSequential(new DriveStopCommand());

      /* Robot pushes poor non-autonomous friend*/
      addSequential(new WaitCommand(.1));
      addSequential(new DriveForwardCommand((int) Math.round(Math.abs(xPositionIn * 2.25) * RobotMap.encoderTicksPerInch)));
      addSequential(new DriveStopCommand());

      /* Robot positions itself for game start*/
      addSequential(new WaitCommand(.1));
      addSequential(new DriveTurnCommand(90));
      addSequential(new DriveStopCommand());

      addSequential(new WaitCommand(.1));
      addSequential(new DriveForwardCommand(RobotMap.robotLength * RobotMap.encoderTicksPerInch));
      addSequential(new DriveStopCommand());

      addSequential(new WaitCommand(.1));
      addSequential(new DriveTurnCommand(90));
      addSequential(new DriveStopCommand());
    }

    


    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
  }

  @Override 
  public void initialize() {
    System.out.println("++++++++++ AUTO INIT ++++++++++");
    super.initialize();
  }
}