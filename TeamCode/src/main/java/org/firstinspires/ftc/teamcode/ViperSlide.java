package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class ViperSlide {
    DcMotor slideExt;
    DcMotor slideRot;
    Robot robot;
    boolean debounce = false;
    boolean gripperPosition = false;

    public ViperSlide(Robot robot) {
        this.robot = robot;
        slideExt = robot.slideExt;
        slideRot = robot.slideRot;
        slideExt.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slideExt.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slideRot.setTargetPosition(slideRot.getCurrentPosition());
        slideRot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slideRot.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void teleopSlideMovement() {
        double inputSlideRot = -robot.gamepad2.right_stick_y / 2;
        double inputSlideExt = -robot.gamepad2.left_stick_y;
        slideRot.setPower(inputSlideRot);
        slideExt.setPower(inputSlideExt);
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
    }

    //public void handleMacros() {
    //
    //}
}
