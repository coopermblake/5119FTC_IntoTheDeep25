package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "Hang and park", group = "Competition Opmodes")
public class HangAndPark extends LinearOpMode {
    public void runOpMode() throws InterruptedException {
        // TODO: huge hack, please replace this later
        Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);
        int lowPosition = robot.slideRot.getCurrentPosition();
        //int minPosition = robot.slideExt.getCurrentPosition();
        robot.gripper.setPosition(0.81);
        waitForStart();
        robot.slideRot.setTargetPosition(lowPosition + 3500);
        //robot.slideExt.setTargetPosition(minPosition + 2000);
        robot.slideRot.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //robot.slideExt.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if (!robot.slideRot.isBusy()) {
            telemetry.addLine("Slide thinks that it is already in position");
            telemetry.update();
        } else {
            telemetry.addLine("Slide indicates that it is trying to move");
            telemetry.update();
        }
        if (robot.slideRot.getTargetPosition() != lowPosition + 3500) {
            telemetry.addLine("Slide is going to the wrong place");
            telemetry.update();
        }

        robot.backLeft.setPower(0.15);
        robot.backRight.setPower(0.15);
        robot.frontLeft.setPower(0.15);
        robot.frontRight.setPower(0.15);
        android.os.SystemClock.sleep(1500);
        if (!robot.slideRot.isBusy()) {
            telemetry.addLine("Slide thinks that it is in position");
            telemetry.update();
        } else {
            telemetry.addLine("Slide is still trying to move");
            telemetry.update();
        }
        robot.backLeft.setPower(0);
        robot.backRight.setPower(0);
        robot.frontLeft.setPower(0);
        robot.frontRight.setPower(0);
        //robot.slideExt.setTargetPosition(minPosition + 1500);
        android.os.SystemClock.sleep(1000);
        robot.gripper.setPosition(0.47);
        android.os.SystemClock.sleep(250);

        robot.backLeft.setPower(-0.15);
        robot.backRight.setPower(-0.15);
        robot.frontLeft.setPower(-0.15);
        robot.frontRight.setPower(-0.15);
        if (robot.slideRot.isBusy()) {
            telemetry.addLine("Slide is still trying to move, and will never reach its target");
            telemetry.update();
        }
        android.os.SystemClock.sleep(1500);
    }
}
