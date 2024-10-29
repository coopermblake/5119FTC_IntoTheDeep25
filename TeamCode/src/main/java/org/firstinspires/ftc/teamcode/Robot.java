package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot.LogoFacingDirection;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot.UsbFacingDirection;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Robot {
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor slideExt;
    DcMotor slideRot;
    IMU imu;
    private final HardwareMap hardwareMap;
    Gamepad gamepad1;
    Gamepad gamepad2;
    ElapsedTime elapsedTime;
    public Robot(HardwareMap HardwareMap, Gamepad Gamepad1, Gamepad Gamepad2) {
        hardwareMap = HardwareMap;
        gamepad1 = Gamepad1;
        gamepad2 = Gamepad2;

        elapsedTime = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);

        backLeft = hardwareMap.get(DcMotor.class, "backLeft"); // broken encoder
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        slideExt = hardwareMap.get(DcMotor.class, "slideExt");
        slideRot = hardwareMap.get(DcMotor.class, "slideRot");
        imu = hardwareMap.get(IMU.class, "imu");

        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        slideRot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slideRot.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slideRot.setDirection(DcMotorSimple.Direction.REVERSE);
        slideExt.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slideExt.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        imu.initialize(new IMU.Parameters(new RevHubOrientationOnRobot(LogoFacingDirection.RIGHT, UsbFacingDirection.UP)));
    }
    public void rawDriveMovement() {
        double inputY = -gamepad1.left_stick_y;
        double inputX = gamepad1.left_stick_x;
        double inputStrafe = gamepad1.right_stick_x;
        //double botHeading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
        //double rotX = (inputX * Math.cos(-botHeading) - inputY * Math.sin(-botHeading)) * 1.1;
        //double rotY = inputX * Math.sin(-botHeading) + inputY * Math.cos(-botHeading);
        double divisor = Math.max(Math.abs(inputY) + Math.abs(inputX) + Math.abs(inputStrafe), 1); // Scales movement
        backLeft.setPower((inputY - inputX + inputStrafe)/divisor);
        backRight.setPower((inputY + inputX - inputStrafe)/divisor);
        frontLeft.setPower((inputY + inputX + inputStrafe)/divisor);
        frontRight.setPower((inputY - inputX - inputStrafe)/divisor);
    }
    public void slideMovement() {
        double inputSlideRot = -gamepad2.left_stick_y;
        double inputSlideExt = -gamepad2.right_stick_y;
        if (Math.abs(inputSlideRot) < 0.05) { // correct for stick drift
            inputSlideRot = 0;
        }
        if (Math.abs(inputSlideExt) < 0.05) {
            inputSlideExt = 0;
        }
        slideRot.setPower(inputSlideRot);
        slideExt.setPower(inputSlideExt);
    }
    public void PIDAdjustedDriveMovement() {

    }

}
