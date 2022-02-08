package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMax.SoftLimitDirection;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxRelativeEncoder.Type;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeMotors extends SubsystemBase{
    private TalonFX innerTalon;
    private TalonFX outerTalon;
    private double innerSpeed;
    private double outerSpeed;
    private CANSparkMax neoLeft;
    private CANSparkMax neoRight;
    private double neoLeftSpeed;
    private double neoRightSpeed;

    public IntakeMotors(int innerTalon, int outerTalon, int neoLeft, int neoRight, double innerSpeed, double outerSpeed, double neoLeftSpeed, double neoRightSpeed){
        this.innerTalon = new TalonFX(innerTalon);
        this.outerTalon = new TalonFX(outerTalon);
        this.innerSpeed = innerSpeed;
        this.outerSpeed = outerSpeed;
        this.neoLeft = new CANSparkMax(neoLeft, MotorType.kBrushless);
        this.neoRight = new CANSparkMax(neoRight, MotorType.kBrushless);
        this.neoLeftSpeed = neoLeftSpeed;
        this.neoRightSpeed = neoRightSpeed;
    }

    /*
    public void getPosition(){
        System.out.println("" + outerTalon.getSelectedSensorPosition() + innerTalon.getSelectedSensorPosition());
    }
    */

    public double getLeftNeoPosition(){
        return neoLeft.getEncoder().getPosition();
    }

    public double getRightNeoPosition(){
        return neoRight.getEncoder().getPosition();
    }

    public void brakeMode(){
        neoLeft.setIdleMode(IdleMode.kBrake);
        neoRight.setIdleMode(IdleMode.kBrake);
    }

    public void coastMode(){
        neoLeft.setIdleMode(IdleMode.kCoast);
        neoRight.setIdleMode(IdleMode.kCoast);
    }

    public void enableFwdLimit(){
        
        neoLeft.enableSoftLimit(SoftLimitDirection.kForward, true);
        neoRight.enableSoftLimit(SoftLimitDirection.kForward, true);
    }
    
    public void enableBkwdLimit(){
        neoLeft.enableSoftLimit(SoftLimitDirection.kReverse, true);
        neoRight.enableSoftLimit(SoftLimitDirection.kReverse, true);
    }

    public void disableFwdLimit(){
        neoLeft.enableSoftLimit(SoftLimitDirection.kForward, false);
        neoRight.enableSoftLimit(SoftLimitDirection.kForward, false);
    }
    
    public void disableBkwdLimit(){
        neoLeft.enableSoftLimit(SoftLimitDirection.kReverse, false);
        neoRight.enableSoftLimit(SoftLimitDirection.kReverse, false);
    }

    public void deploy(){
        neoLeft.getEncoder().getPosition();
        neoRight.getEncoder().getPosition();
        neoLeft.set(neoLeftSpeed);
        neoRight.set(-neoRightSpeed);
    }

    public void undeploy(){
        neoLeft.set(-neoLeftSpeed);
        neoRight.set(neoRightSpeed);
    }

    public void suck(){
        innerTalon.set(ControlMode.PercentOutput, innerSpeed);
        outerTalon.set(ControlMode.PercentOutput, outerSpeed);
    }

    public void spit(){
        innerTalon.set(ControlMode.PercentOutput, -innerSpeed);
        outerTalon.set(ControlMode.PercentOutput, outerSpeed);
    }

    public void stop(){
        innerTalon.set(ControlMode.PercentOutput, 0);
        outerTalon.set(ControlMode.PercentOutput, 0);
    }
}
