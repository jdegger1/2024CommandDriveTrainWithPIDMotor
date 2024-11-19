package frc.robot;


//import frc.robot.Constants.OperatorConstants;

import frc.robot.commands.ButtonMotorForwardCom;
import frc.robot.commands.ButtonMotorReverseCom;
import frc.robot.commands.TeleDriveCom;
import frc.robot.subsystems.ButtonMotorSub;
import frc.robot.subsystems.DriveTrainSub;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
   private final DriveTrainSub m_DriveTrainSub;
   private final ButtonMotorSub m_ButtonMotorSub;
  private Joystick m_Joystick;
  private JoystickButton fButton;
  private JoystickButton rButton;


  public RobotContainer() {
    m_DriveTrainSub = new DriveTrainSub();
    m_ButtonMotorSub = new ButtonMotorSub();
    m_Joystick = new Joystick(Constants.JOYSTICK_CHANNEL);
    fButton = new JoystickButton(m_Joystick, Constants.FORWARD_BUT);
    rButton = new JoystickButton(m_Joystick, Constants.BACKWARD_BUT);
    m_ButtonMotorSub.resetEncoder();


    m_DriveTrainSub.setDefaultCommand(new TeleDriveCom(
        m_DriveTrainSub,
        () -> m_Joystick.getZ() * Constants.Z_SPEED_MULTIPLIER,
        () -> m_Joystick.getY() * Constants.Y_SPEED_MULTIPLIER));


    configureBindings();
    fButton.toggleOnTrue(new ButtonMotorForwardCom(m_ButtonMotorSub, Constants.FORWARD_SETPOINT));
    rButton.toggleOnTrue(new ButtonMotorReverseCom(m_ButtonMotorSub, Constants.BACKWARD_SETPOINT));
  }


  private void configureBindings() {
  }
  /*public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
  */
}
