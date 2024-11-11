package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class ViperSlide {
    DcMotor slideExt;
    DcMotor slideRot;
    Robot robot;
    boolean gripperPosition;
    boolean debouncePrimary;
    boolean debounceSecondary;

    public ViperSlide(Robot robot) {
        this.robot = robot;
        slideExt = robot.slideExt;
        slideRot = robot.slideRot;
        slideExt.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slideExt.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slideRot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slideRot.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        gripperPosition = false;
        debouncePrimary = false;
    }

    public void teleopSlideMovement() {
        double inputSlideRot = -robot.gamepad2.right_stick_y;
        double inputSlideExt = robot.gamepad2.left_stick_y;
        if (Math.abs(inputSlideRot) < 0.05) {
            inputSlideRot = 0;
        }
        slideRot.setPower(inputSlideRot);
        slideExt.setPower(inputSlideExt);
        if (robot.gamepad1.left_trigger > 0.05) {
            if (!debouncePrimary) {
                if (gripperPosition) {
                    robot.gripper.setPosition(0.81);
                } else {
                    robot.gripper.setPosition(0.47);
                }
            }
        } else {
            debouncePrimary = false;
            if (robot.gamepad2.right_trigger > 0.05) {
                if (!debounceSecondary) {
                    if (gripperPosition) {
                        robot.gripper.setPosition(0.81);
                    } else {
                        robot.gripper.setPosition(0.47);
                    }
                }
            } else {
                debounceSecondary = false;
            }
        }

        if (robot.gamepad1.left_trigger > 0.05 && gripperPosition && !debouncePrimary) {
            robot.gripper.setPosition(0.81);
            gripperPosition = !gripperPosition;
            debouncePrimary = true;
        } else if (robot.gamepad1.left_trigger > 0.05 && !gripperPosition && !debouncePrimary) {
            robot.gripper.setPosition(0.47);
            gripperPosition = !gripperPosition;
            debouncePrimary = true;
        } else if (robot.gamepad1.left_trigger < 0.05) {
            debouncePrimary = false;
        }
    }
}
