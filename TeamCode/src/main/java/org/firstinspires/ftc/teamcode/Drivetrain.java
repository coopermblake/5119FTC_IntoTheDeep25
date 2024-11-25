package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Drivetrain {
    private final DcMotor backLeft;
    private final DcMotor backRight;
    private final DcMotor frontLeft;
    private final DcMotor frontRight;
    private final Robot robot;
    public Drivetrain(Robot robot) {
        this.robot = robot;
        backLeft = robot.backLeft;
        backRight = robot.backRight;
        frontLeft = robot.frontLeft;
        frontRight = robot.frontRight;
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void rawDriveMovement() {
        double inputY = -robot.gamepad1.left_stick_y;
        double inputX = robot.gamepad1.left_stick_x;
        double inputRot = robot.gamepad1.right_stick_x;
        // Divisor is used to scale the other inputs if an input is too large or slow down the robot
        double divisor = Math.max(Math.abs(inputY) + Math.abs(inputX) + Math.abs(inputRot), 1) + robot.gamepad1.right_trigger*3;
        if (robot.gamepad2.dpad_up) {
            inputY += 0.25;
        } else if (robot.gamepad2.dpad_down) {
            inputY += -0.25;
        }
        if (robot.gamepad2.right_bumper) {
            inputRot += 0.125;
        } else if (robot.gamepad2.left_bumper) {
            inputRot += -0.125;
        }
        backLeft.setPower((inputY - inputX + inputRot)/divisor);
        backRight.setPower((inputY + inputX - inputRot)/divisor);
        frontLeft.setPower((inputY + inputX + inputRot)/divisor);
        frontRight.setPower((inputY - inputX - inputRot)/divisor);
    }
}
