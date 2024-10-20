package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot.LogoFacingDirection;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot.UsbFacingDirection;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

public class Robot {
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor slideExt;
    DcMotor slideRot;
    IMU imuControlHub;
    IMU imuExpansionHub;
    private final HardwareMap hardwareMap;
    Gamepad gamepad1;
    Gamepad gamepad2;
    float[] driveMotorPower;

    public Robot(HardwareMap HardwareMap, Gamepad Gamepad1, Gamepad Gamepad2) {
        hardwareMap = HardwareMap;
        gamepad1 = Gamepad1;
        gamepad2 = Gamepad2;
    }
    public void init() {
        backLeft = hardwareMap.get(DcMotor.class, "backLeft"); // broken encoder
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        slideExt = hardwareMap.get(DcMotor.class, "slideExt");
        slideRot = hardwareMap.get(DcMotor.class, "slideRot");
        imuControlHub = hardwareMap.get(IMU.class, "imuExpansionHub");
        imuExpansionHub = hardwareMap.get(IMU.class, "imuExpansionHub");

        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        imuControlHub.initialize(new IMU.Parameters(new RevHubOrientationOnRobot(LogoFacingDirection.RIGHT, UsbFacingDirection.UP)));
        imuExpansionHub.initialize(new IMU.Parameters(new RevHubOrientationOnRobot(LogoFacingDirection.LEFT, UsbFacingDirection.UP)));
    }
    public void processDriveInput() {
        // 2 3
        // 0 1
        float inputY = -gamepad1.left_stick_y;
        float inputX = gamepad1.left_stick_x;
        float inputRot = gamepad1.right_stick_x;
        float divisor = Math.max(Math.abs(inputY) + Math.abs(inputX) + Math.abs(inputRot), 1); // Scales movement
        driveMotorPower[0] = (inputY - inputX + inputRot)/divisor;
        driveMotorPower[1] = (inputY + inputX - inputRot)/divisor;
        driveMotorPower[2] = (inputY + inputX + inputRot)/divisor;
        driveMotorPower[3] = (inputY - inputX - inputRot)/divisor;
    }
    public void rawDriveMovement() {
        backLeft.setPower(driveMotorPower[0]);
        backRight.setPower(driveMotorPower[1]);
        frontLeft.setPower(driveMotorPower[2]);
        frontRight.setPower(driveMotorPower[3]);
    }
    public void PIDAdjustedDriveMovement() {

    }

}
