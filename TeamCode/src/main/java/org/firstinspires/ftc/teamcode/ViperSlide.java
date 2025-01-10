package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class ViperSlide {
    DcMotor slideExt;
    DcMotor slideRot;
    Robot robot;
    boolean debounce = false;
    boolean gripperPosition = false;
    boolean driverControl = false;
    int rotMin;
    int rotMax;
    int extMin;
    int extMax;
    double rotSensitivity = 1; // equivalent to 1000 ticks/s
    double extSensitivity = 1;
    long lastCycle;

    public ViperSlide(Robot robot) {
        this.robot = robot;
        slideExt = robot.slideExt;
        slideRot = robot.slideRot;
        slideExt.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slideRot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slideExt.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slideRot.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rotMin = slideRot.getCurrentPosition();
        rotMax = rotMin + 4000;
        extMin = slideExt.getCurrentPosition();
        extMax = extMin + 3200;
    }

    public void moveSlide(double inputRot, double inputExt) {
       slideRot.setPower(-inputRot);
       slideExt.setPower(inputExt);
    }

    private void handleGripper() {
        // we use debounce to make pressing the trigger only toggle the gripper once per press
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

    public void teleopSlideMovement(Gamepad gamepad1, Gamepad gamepad2) {
        if (driverControl) {
            handleGripper();
            moveSlide(-gamepad2.right_stick_y, -gamepad2.left_stick_y);
            if (Math.abs(-gamepad2.right_stick_y) < 0.05) {
                slideRot.setPower(0);
            } else {
                slideRot.setPower(-gamepad2.right_stick_y);
            }
            if (Math.abs(-gamepad2.left_stick_y) < 0.05) {
                slideExt.setPower(0);
            } else {
                slideExt.setPower(-gamepad2.left_stick_y);
            }
            handleMacros(gamepad2);
        }
    }

    private void handleMacros(Gamepad gamepad2) {

    }
}
