//this file is where the catapult is ran
//find the SpinMotor's to change id and speed

package frc.robot;

import javax.print.attribute.standard.JobPriority;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.Button;
import frc.robot.commands.DefaultDriveCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DrivetrainSubSystem.DrivetrainSubsystem;
import frc.robot.subsystems.CatapultSubSystem.*;


public class LeftCatapult{
    private final Motor motor = new Motor(1);
    private final XboxController m_controller = new XboxController(0);

    public LeftCatapult(){

        configureButtonBindings();
    }

    public void configureButtonBindings(){
        JoystickButton buttonB = new JoystickButton(m_controller, XboxController.Button.kB.value);
        JoystickButton buttonX = new JoystickButton(m_controller, XboxController.Button.kX.value);

        // SpinMotor s
        // change motor and speed here. SpinMotor(motor id, percent output[-1 to 1 as double])
        buttonB.whenPressed(() -> new SpinMotor(motor, .9));
        
    }

    public Object getAutonomousCommand() {
        return null;
    }
}