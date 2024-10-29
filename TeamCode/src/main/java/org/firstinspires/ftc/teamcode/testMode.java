package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="MotorTest",group="TEST")
public class testMode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);
        waitForStart();
        while(opModeIsActive()) {
            // note: encoder for backLeft is currently broken
            telemetry.addData("backLeft encoder value:", robot.backLeft.getCurrentPosition());
            telemetry.addData("backRight encoder value:", robot.backRight.getCurrentPosition());
            telemetry.addData("frontLeft encoder value:", robot.frontLeft.getCurrentPosition());
            telemetry.addData("frontRight encoder value:", robot.frontRight.getCurrentPosition());
            telemetry.addData("slideExt encoder value:", robot.slideExt.getCurrentPosition());
            telemetry.addData("slideRot encoder value:", robot.slideRot.getCurrentPosition());
            telemetry.update();

            // Mappings for drivetrain:
            //  FRONT
            // (Y) (B)
            // (X) (A)
            //  BACK
            // Y = BL
            // B = BR
            // X = FL
            // A = FR
            if(gamepad1.x) {
                robot.backLeft.setPower(0.5);
            } else {
                robot.backLeft.setPower(0);
            }
            if(gamepad1.a) {
                robot.backRight.setPower(0.5);
            } else {
                robot.backRight.setPower(0);
            }
            if(gamepad1.y) {
                robot.frontLeft.setPower(0.5);
            } else {
                robot.frontLeft.setPower(0);
            }
            if(gamepad1.b) {
                robot.frontRight.setPower(0.5);
            } else {
                robot.frontRight.setPower(0);
            }
            // Mappings for slide:
            // (left_bumper) OUT | IN (right_bumper)
            // dpad up/down = slide rotate up/down
            /*if(gamepad1.left_bumper) {
                robot.slideExt.setPower(1);
            } else if(gamepad1.right_bumper) {
                robot.slideExt.setPower(-1);
            } else {
                robot.slideExt.setPower(0);
            }
            if(gamepad1.dpad_up) {
                robot.slideRot.setPower(1);
            } else if(gamepad1.dpad_down) {
                robot.slideRot.setPower(-1);
            } else {
                robot.slideRot.setPower(0);
            }*/
        }
    }
}
