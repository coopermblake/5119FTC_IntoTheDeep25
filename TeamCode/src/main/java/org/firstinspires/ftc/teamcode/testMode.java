package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="MotorTest",group="TEST")
public class testMode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);
        robot.init();
        waitForStart();
        while(opModeIsActive()) {
            telemetry.addData("backLeft encoder value:", robot.backLeft.getCurrentPosition());
            telemetry.addData("backRight encoder value:", robot.backRight.getCurrentPosition());
            telemetry.addData("frontLeft encoder value:", robot.frontLeft.getCurrentPosition());
            telemetry.addData("frontRight encoder value:", robot.frontRight.getCurrentPosition());
            telemetry.update();
            //telemetry.addData("slideExt encoder value:", robot.slideExt.getCurrentPosition());
            //telemetry.addData("slideRot encoder value:", robot.slideRot.getCurrentPosition());

            // Mappings for drivetrain:
            //  FRONT
            // (Y) (B)
            // (X) (A)
            //  BACK
            if(gamepad1.x) {
                robot.backLeft.setPower(1);
            } else {
                robot.backLeft.setPower(0);
            }
            if(gamepad1.a) {
                robot.backRight.setPower(1);
            } else {
                robot.backRight.setPower(0);
            }
            if(gamepad1.y) {
                robot.frontLeft.setPower(1);
            } else {
                robot.frontLeft.setPower(0);
            }
            if(gamepad1.b) {
                robot.frontRight.setPower(1);
            } else {
                robot.frontRight.setPower(0);
            }
            // Mappings for slide:
            // (left_bumper) OUT - IN (right_bumper)
            // dpad up/down = slide rotate up/down
            /* if(gamepad1.left_bumper) {
                robot.slideExt.setPower(0.5);
            } else if(gamepad1.right_bumper) {
                robot.slideExt.setPower(-0.5);
            } else {
                robot.slideExt.setPower(0);
            }
            if(gamepad1.dpad_up) {
                robot.slideRot.setPower(0.5);
            } else if(gamepad1.dpad_down) {
                robot.slideRot.setPower(-0.5);
            } else {
                robot.slideRot.setPower(0);
            }
            */
        }
    }
}
