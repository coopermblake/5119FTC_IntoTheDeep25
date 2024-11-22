package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

public class ViperSlide {
    DcMotor slideExt;
    DcMotor slideRot;
    Robot robot;
    boolean debounce = false;
    boolean gripperPosition = false;
    boolean isManual = true;
    boolean limiterEnabled = true;
    int maxExtension;
    int minExtension;
    int slideMax;
    int slideMin;

    public ViperSlide(Robot robot) {
        this.robot = robot;
        slideExt = robot.slideExt;
        slideRot = robot.slideRot;
        slideExt.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slideExt.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slideRot.setTargetPosition(slideRot.getCurrentPosition());
        slideRot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slideRot.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        minExtension = slideExt.getCurrentPosition();
        maxExtension = minExtension + 8000;
        slideMin = slideRot.getCurrentPosition();
        slideMax = slideMin + 5000;
    }

    public void teleopSlideMovement() {
        // debounce blocks servo from triggering again until trigger is released by both drivers
        if (robot.gamepad2.right_trigger > 0.05 || robot.gamepad1.left_trigger > 0.05) {
            if (!debounce) {
                if (gripperPosition) {
                    robot.gripper.setPosition(0.81);
                } else {
                    robot.gripper.setPosition(0.47);
                }
                gripperPosition = !gripperPosition;
                debounce = true;
            }
        } else {
            debounce = false;
        }

        if (!isManual) {
            return;
        }

        double inputSlideRot = -robot.gamepad2.right_stick_y / 2;
        double inputSlideExt = -robot.gamepad2.left_stick_y;
        if (limiterEnabled) {
            if (slideRot.getCurrentPosition() > slideMax) {
                inputSlideRot = -0.1;
            } else if (slideRot.getCurrentPosition() < slideMin) {
                inputSlideRot = 0.1;
            }
            if (slideExt.getCurrentPosition() > maxExtension) {
                inputSlideExt = -0.1;
            } else if (slideExt.getCurrentPosition() < minExtension) {
                inputSlideExt = 0.1;
            }
        }
        slideRot.setPower(inputSlideRot);
        slideExt.setPower(inputSlideExt);
    }

    public void handleMacros() {
        if (robot.gamepad2.a) {
            slideRot.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            slideExt.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            slideRot.setTargetPosition(slideMin);
            slideExt.setTargetPosition(minExtension);
            isManual = false;
        } else if (robot.gamepad2.y) {
            slideRot.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            slideExt.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            slideRot.setTargetPosition(slideMax);
            slideExt.setTargetPosition(maxExtension);
            isManual = false;
        }

        if (robot.gamepad2.b || !(slideRot.isBusy() || slideExt.isBusy())) {
            slideRot.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            slideExt.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            isManual = true;
        }

        if (robot.gamepad2.x && !limiterEnabled) {
            limiterEnabled = true;
        } else if (!robot.gamepad2.x && limiterEnabled) {
            limiterEnabled = false;
        }
    }
}
