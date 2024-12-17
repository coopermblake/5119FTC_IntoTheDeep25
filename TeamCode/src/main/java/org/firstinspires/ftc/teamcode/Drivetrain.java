package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Drivetrain {
    private final DcMotor backLeft;
    private final DcMotor backRight;
    private final DcMotor frontLeft;
    private final DcMotor frontRight;
    public Drivetrain(DcMotor backLeft, DcMotor backRight, DcMotor frontLeft, DcMotor frontRight) {
        this.backLeft = backLeft;
        this.backRight = backRight;
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void robotCentricDrive(Gamepad gamepad1, Gamepad gamepad2) {
        double[] inputs = getTeleopDriveInputs(gamepad1, gamepad2);
        rawDriveMovement(inputs[0], inputs[1], inputs[2], inputs[3]);
    }

    public double[] getTeleopDriveInputs(Gamepad gamepad1, Gamepad gamepad2) {
        double inputY = -gamepad1.left_stick_y;
        double inputX = gamepad1.left_stick_x;
        double inputRot = gamepad1.right_stick_x;
        // Divisor is used to scale the other inputs if an input is too large or slow down the robot
        double divisor = Math.max(Math.abs(inputY) + Math.abs(inputX) + Math.abs(inputRot), 1) + gamepad1.right_trigger*3;
        if (gamepad2.dpad_up) {
            inputY += 0.25;
        } else if (gamepad2.dpad_down) {
            inputY -= 0.25;
        }
        if (gamepad2.right_bumper) {
            inputRot += 0.125;
        } else if (gamepad2.left_bumper) {
            inputRot -= 0.125;
        }
        return new double[] {inputY, inputX, inputRot, divisor};
    }

    public void rawDriveMovement(double inputY, double inputX, double inputRot, double divisor) {
        backLeft.setPower((inputY - inputX + inputRot)/divisor);
        backRight.setPower((inputY + inputX - inputRot)/divisor);
        frontLeft.setPower((inputY + inputX + inputRot)/divisor);
        frontRight.setPower((inputY - inputX - inputRot)/divisor);
    }

    public void fieldCentricMovement(double inputY, double inputX, double inputRot, double divisor) {

    }
}
