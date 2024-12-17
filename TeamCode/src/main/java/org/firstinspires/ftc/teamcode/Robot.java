package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot.LogoFacingDirection;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot.UsbFacingDirection;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

public class Robot {
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor frontLeft;
    DcMotor frontRight;

    DcMotor slideExt;
    DcMotor slideRot;

    Servo gripper;
    IMU imu;

    Gamepad gamepad1;
    Gamepad gamepad2;

    Drivetrain drivetrain;
    ViperSlide viperSlide;
    EmergencyStop emergencyStop;

    public Robot(HardwareMap HardwareMap, Gamepad Gamepad1, Gamepad Gamepad2) {
        gamepad1 = Gamepad1;
        gamepad2 = Gamepad2;
        backLeft = HardwareMap.get(DcMotor.class, "backLeft");
        backRight = HardwareMap.get(DcMotor.class, "backRight");
        frontLeft = HardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = HardwareMap.get(DcMotor.class, "frontRight");
        slideExt = HardwareMap.get(DcMotor.class, "slideExt");// max-min = +8k
        slideRot = HardwareMap.get(DcMotor.class, "slideRot"); // max-min = +5k
        gripper = HardwareMap.get(Servo.class, "gripper");
        imu = HardwareMap.get(IMU.class, "imu");

        slideExt.setDirection(DcMotorSimple.Direction.REVERSE);

        imu.initialize(new IMU.Parameters(new RevHubOrientationOnRobot(LogoFacingDirection.RIGHT, UsbFacingDirection.UP)));

        drivetrain = new Drivetrain(backLeft, backRight, frontLeft, frontRight);
        viperSlide = new ViperSlide(this);
        emergencyStop = new EmergencyStop();
    }
}
