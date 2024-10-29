package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class ViperSlide {
    int minExtension;
    int maxExtension;
    int minRot;
    int maxRot;
    DcMotor slideExt;
    DcMotor slideRot;
    Robot robot;
    boolean slideExtended = false;

    public ViperSlide(Robot robot) {
        this.robot = robot;
        slideExt = robot.slideExt;
        slideRot = robot.slideRot;
        slideExt.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slideExt.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slideRot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slideRot.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        minExtension = slideExt.getCurrentPosition();
        maxExtension = minExtension + 1000000; // temp value, calculate later
        minRot = slideRot.getCurrentPosition();
        maxRot = minRot + 1000000; // temp value, calculate later
    }

    public void teleopSlideMovement() {
        double inputSlideRot = -robot.gamepad2.left_stick_y;
        double inputSlideExt = -robot.gamepad2.right_stick_y;
        if (Math.abs(inputSlideRot) < 0.05 || slideRot.getCurrentPosition() > maxRot || slideRot.getCurrentPosition() < minRot) {
            inputSlideRot = 0;
        }
        if (Math.abs(inputSlideExt) < 0.05 || slideExt.getCurrentPosition() > maxExtension || slideExt.getCurrentPosition() < minExtension) {
            inputSlideExt = 0;
        }
        slideExtended = slideExt.getCurrentPosition() > minExtension + 10000; // temp value, calculate later
        slideRot.setPower(inputSlideRot);
        slideExt.setPower(inputSlideExt);
    }
}
