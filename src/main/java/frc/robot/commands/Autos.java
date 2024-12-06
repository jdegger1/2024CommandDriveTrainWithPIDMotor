// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

//import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrainSub;

public final class Autos {
  /** Example static factory for an autonomous command. */
  //public static Command exampleAuto(ExampleSubsystem subsystem) {
   // return Commands.sequence(subsystem.exampleMethodCommand(), new ExampleCommand(subsystem));
 // }

 // Middle Auto
  public static Command middleAuto(DriveTrainSub subsystem){
    return Commands.sequence(
      //drive forward for timeout seconds
      new AutoDriveCom(subsystem, Constants.MIDDLE_AUTO_FORWARD_SPEED, 0).withTimeout(Constants.MIDDLE_AUTO_FORWARD_TIME)
      );
  }
 //

 // Right Auto
  public static Command rightAuto(DriveTrainSub subsystem){
    return Commands.sequence(
      // turn right 4 1 sec
      new AutoDriveCom(subsystem, 0, Constants.RIGHT_AUTO_TURN_SPEED).withTimeout(Constants.RIGHT_AUTO_TURN_TIME),
      //pause 4 1 sec
      new AutoDriveCom(subsystem, 0, 0).withTimeout(Constants.LEFT_AUTO_FORWARD_PAUSE_TIME),
      //go forward 4 3 seconds
      new AutoDriveCom(subsystem, Constants.RIGHT_AUTO_FORWARD_SPEED, 0).withTimeout(Constants.RIGHT_AUTO_FORWARD_SPEED)
    );
  }
 //

 // Left Auto
  public static Command leftAuto(DriveTrainSub subsystem){
    return Commands.sequence(
      //turn left 4 1 second
      new AutoDriveCom(subsystem, 0, Constants.LEFT_AUTO_TURN_SPEED).withTimeout(Constants.LEFT_AUTO_TURN_TIME),
      //pause 4 1 sec
      new AutoDriveCom(subsystem, 0, 0).withTimeout(Constants.LEFT_AUTO_FORWARD_PAUSE_TIME),
      //go forward 4 3 sec
      new AutoDriveCom(subsystem, Constants.LEFT_AUTO_FORWARD_SPEED, 0).withTimeout(Constants.LEFT_AUTO_FORWARD_TIME)
    );
  }
 // 



  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
