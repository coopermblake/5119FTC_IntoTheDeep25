package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="MotorTest",group="TEST")
public class testMode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);
        waitForStart();
        int encoderStart;
        encoderStart = robot.backLeft.getCurrentPosition();
        robot.backLeft.setPower(0.5);
        android.os.SystemClock.sleep(1000);
        if (robot.backLeft.getCurrentPosition() > encoderStart + 100) {
            telemetry.addLine("backLeft encoder test passed");
        }
        encoderStart = robot.backRight.getCurrentPosition();
        robot.backRight.setPower(0.5);
        android.os.SystemClock.sleep(1000);
        if (robot.backRight.getCurrentPosition() > encoderStart + 100) {
            telemetry.addLine("backRight encoder test passed");
        }
        encoderStart = robot.frontLeft.getCurrentPosition();
        robot.frontLeft.setPower(0.5);
        android.os.SystemClock.sleep(1000);
        if (robot.frontLeft.getCurrentPosition() > encoderStart + 100) {
            telemetry.addLine("frontLeft encoder test passed");
        }
        encoderStart = robot.frontRight.getCurrentPosition();
        robot.frontRight.setPower(0.5);
        android.os.SystemClock.sleep(1000);
        if (robot.frontRight.getCurrentPosition() > encoderStart + 100) {
            telemetry.addLine("frontRight encoder test passed");
        }
        telemetry.update();

        while(opModeIsActive()) {
            // note: encoder for backLeft is currently broken
            telemetry.addData("backLeft encoder value:", robot.backLeft.getCurrentPosition());
            telemetry.addData("backRight encoder value:", robot.backRight.getCurrentPosition());
            telemetry.addData("frontLeft encoder value:", robot.frontLeft.getCurrentPosition());
            telemetry.addData("frontRight encoder value:", robot.frontRight.getCurrentPosition());
            telemetry.addData("slideExt encoder value:", robot.slideExt.getCurrentPosition());
            telemetry.addData("slideRot encoder value:", robot.slideRot.getCurrentPosition());
            telemetry.update();

            if (robot.gamepad1.a) {
                robot.backLeft.setPower(0.5);
            } else {
                robot.backLeft.setPower(0);
            }
            if (robot.gamepad1.b) {
                robot.backRight.setPower(0.5);
            } else {
                robot.backRight.setPower(0);
            }
            if (robot.gamepad1.x) {
                robot.frontLeft.setPower(0.5);
            } else {
                robot.frontLeft.setPower(0);
            }
            if (robot.gamepad1.y) {
                robot.frontRight.setPower(0.5);
            } else {
                robot.frontRight.setPower(0);
            }
        }
    }
}
