// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatorCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CatapultSubsystem extends SubsystemBase {
  private TalonFX motor;

  /** Creates a new motor. */
  public CatapultSubsystem(int id) {
    motor = new TalonFX(id);
    motor.configVoltageCompSaturation(11);
    motor.enableVoltageCompensation(true);

    if(id == 21){
      motor.setInverted(InvertType.InvertMotorOutput);
    }
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler 

    }

  public void setPercent(double speed){
    motor.set(ControlMode.PercentOutput, speed);
  }
  
  public void setSelectedSensorPosition() {
    motor.setSelectedSensorPosition(0.0);
  }

  public double getPosition(){
    motor.getSelectedSensorPosition();
    return motor.getSelectedSensorPosition();
  }

  public void setBrake(){
    motor.setNeutralMode(NeutralMode.Coast);
  }

  public TalonFX getMotor(){
    return motor;
  }

  public double getStatorCurrent(){
    return motor.getStatorCurrent();
  }

  public double getSupplyCurrent(){
    return motor.getSupplyCurrent();
  }

  public void setCurrentLimit(){
    motor.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, 0, 45, 1));
    // motor.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, 0, 100, 1));
    }
  }
