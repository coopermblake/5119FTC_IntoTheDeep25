package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class ViperSlide {
    int minRot;
    int maxRot;
    DcMotor slideExt;
    DcMotor slideRot;
    Robot robot;
    boolean slideExtended = false;
    boolean correcting = false;

    public ViperSlide(Robot robot) {
        this.robot = robot;
        slideExt = robot.slideExt;
        slideRot = robot.slideRot;
        slideExt.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slideExt.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slideRot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slideRot.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        minRot = slideRot.getCurrentPosition();
        maxRot = minRot + 2400; // temp value, calculate later
    }

    public void teleopSlideMovement() {
        double inputSlideRot = -robot.gamepad2.left_stick_y;
        double inputSlideExt = robot.gamepad2.right_stick_y;
        if (slideRot.getCurrentPosition() > maxRot) {
            correcting = true;
            slideRot.setPower(-0.1);
        } else if (slideRot.getCurrentPosition() < minRot) {
            slideRot.setPower(0.1);
            correcting = true;
        }  else if (correcting) {
            correcting = false;
            slideRot.setPower(0);
        } else {
            if (Math.abs(inputSlideRot) < 0.05) {
                inputSlideRot = 0;
            }
            slideRot.setPower(inputSlideRot);
            slideExt.setPower(inputSlideExt);
        }
        if (robot.gamepad2.right_trigger > 0.05) {
            robot.gripper.setPosition(0.81);

        } else if (robot.gamepad2.left_trigger > 0.05) {
            robot.gripper.setPosition(0.47);
        }
    }
}
