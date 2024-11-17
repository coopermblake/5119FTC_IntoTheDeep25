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
        if (robot.gamepad2.dpad_up) {
            inputY += 0.25;
        } else if (robot.gamepad2.dpad_down) {
            inputY += -0.25;
        }
        double inputX = robot.gamepad1.left_stick_x + (robot.gamepad2.right_stick_x /4);
        double inputStrafe = robot.gamepad1.right_stick_x + (robot.gamepad2.left_stick_x / 8);
        double divisor = Math.max(Math.abs(inputY) + Math.abs(inputX) + Math.abs(inputStrafe), 1) + robot.gamepad1.right_trigger*3; // Scales movement
        backLeft.setPower((inputY - inputX + inputStrafe)/divisor);
        backRight.setPower((inputY + inputX - inputStrafe)/divisor);
        frontLeft.setPower((inputY + inputX + inputStrafe)/divisor);
        frontRight.setPower((inputY - inputX - inputStrafe)/divisor);
    }
}
