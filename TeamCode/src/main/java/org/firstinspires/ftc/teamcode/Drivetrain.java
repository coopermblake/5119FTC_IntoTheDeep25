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
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    public void rawDriveMovement() {
        double inputY = -robot.gamepad1.left_stick_y;
        double inputX = robot.gamepad1.left_stick_x;
        double inputStrafe = robot.gamepad1.right_stick_x;
        double divisor = Math.max(Math.abs(inputY) + Math.abs(inputX) + Math.abs(inputStrafe), 1); // Scales movement
        if (Math.abs(inputY) > 0.05 || Math.abs(inputX) > 0.05 || Math.abs(inputStrafe) > 0.05 ) {
            if (robot.gamepad1.right_bumper && robot.gamepad1.left_bumper) {
                divisor = 4;
            } else if (robot.gamepad1.right_bumper || robot.gamepad1.left_bumper) {
                divisor = 2;
            }
        } else {
            inputY = -robot.gamepad2.right_stick_y;
            inputX = robot.gamepad2.right_stick_x;
            inputStrafe = 0;
            divisor = 2;
        }
        backLeft.setPower((inputY - inputX + inputStrafe)/divisor);
        backRight.setPower((inputY + inputX - inputStrafe)/divisor);
        frontLeft.setPower((inputY + inputX + inputStrafe)/divisor);
        frontRight.setPower((inputY - inputX - inputStrafe)/divisor);
    }
}
