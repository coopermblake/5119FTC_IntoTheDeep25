package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "Hang 2 And Park", group = "Competition Opmodes")
public class Hang2AndPark extends LinearOpMode {
    public void runOpMode() throws InterruptedException {
        // TODO: huge hack, please replace this later
        Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);
        robot.gripper.setPosition(0.81);
        waitForStart();
        int lowPosition = robot.slideRot.getCurrentPosition();
        int minPosition = robot.slideExt.getCurrentPosition();
        robot.slideRot.setTargetPosition(lowPosition - 2800);
        robot.slideExt.setTargetPosition(minPosition + 1200);
        robot.slideRot.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.slideRot.setPower(1);
        android.os.SystemClock.sleep(500);
        robot.slideExt.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.slideExt.setPower(0.2);

        //go forward
        robot.backLeft.setPower(0.3);
        robot.backRight.setPower(0.3);
        robot.frontLeft.setPower(0.3);
        robot.frontRight.setPower(0.3);

        android.os.SystemClock.sleep(2300);

        //stop
        robot.backLeft.setPower(0);
        robot.backRight.setPower(0);
        robot.frontLeft.setPower(0);
        robot.frontRight.setPower(0);

        android.os.SystemClock.sleep(1000);

        //drop arm
        robot.slideExt.setTargetPosition(minPosition + 200);
        robot.slideRot.setTargetPosition(lowPosition - 2700);

        android.os.SystemClock.sleep(2000);

        //release specimen
        robot.gripper.setPosition(0.47);

        android.os.SystemClock.sleep(1000);

        //reset arm
        robot.slideRot.setTargetPosition(lowPosition);
        robot.slideExt.setTargetPosition(minPosition);

        //reverse
        robot.backLeft.setPower(-0.25);
        robot.backRight.setPower(-0.25);
        robot.frontLeft.setPower(-0.25);
        robot.frontRight.setPower(-0.25);
        android.os.SystemClock.sleep(3000);

        //go forward a little
        robot.backLeft.setPower(0.15);
        robot.backRight.setPower(0.15);
        robot.frontLeft.setPower(0.15);
        robot.frontRight.setPower(0.15);

        android.os.SystemClock.sleep(3000);

        //stop
        robot.backLeft.setPower(0);
        robot.backRight.setPower(0);
        robot.frontLeft.setPower(0);
        robot.frontRight.setPower(0);

        android.os.SystemClock.sleep(500);

        //go right
        robot.backLeft.setPower(-0.50);
        robot.backRight.setPower(0.50);
        robot.frontLeft.setPower(0.50);
        robot.frontRight.setPower(-0.50);

        android.os.SystemClock.sleep(3000);

        //180 turn
        robot.backLeft.setPower(-0.25);
        robot.backRight.setPower(0.25);
        robot.frontLeft.setPower(-0.25);
        robot.frontRight.setPower(0.25);

        android.os.SystemClock.sleep(1000);

        //extend arm and wait for human
        robot.viperSlide.slideExt.setTargetPosition(minPosition+1000);
        android.os.SystemClock.sleep(5000);

        //extend arm and grab specimen
        robot.viperSlide.slideExt.setTargetPosition(minPosition+2000);
        robot.gripper.setPosition(0.81);

        android.os.SystemClock.sleep(1000);

        //bring arm in
        robot.slideRot.setTargetPosition(lowPosition - 2800);
        robot.slideExt.setTargetPosition(minPosition + 1200);
        robot.slideRot.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.slideRot.setPower(1);
        android.os.SystemClock.sleep(500);
        robot.slideExt.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.slideExt.setPower(0.2);

        android.os.SystemClock.sleep(2000);

        //180 turn
        robot.backLeft.setPower(-0.25);
        robot.backRight.setPower(0.25);
        robot.frontLeft.setPower(-0.25);
        robot.frontRight.setPower(0.25);

        android.os.SystemClock.sleep(1000);

        //go left
        robot.backLeft.setPower(0.25);
        robot.backRight.setPower(-0.25);
        robot.frontLeft.setPower(-0.25);
        robot.frontRight.setPower(0.25);

        android.os.SystemClock.sleep(3000);

        //REPEAT BEGINNGIN

        //go forward
        robot.backLeft.setPower(0.3);
        robot.backRight.setPower(0.3);
        robot.frontLeft.setPower(0.3);
        robot.frontRight.setPower(0.3);

        android.os.SystemClock.sleep(2300);

        //stop
        robot.backLeft.setPower(0);
        robot.backRight.setPower(0);
        robot.frontLeft.setPower(0);
        robot.frontRight.setPower(0);

        android.os.SystemClock.sleep(1000);

        //drop arm
        robot.slideExt.setTargetPosition(minPosition + 200);
        robot.slideRot.setTargetPosition(lowPosition - 2700);

        android.os.SystemClock.sleep(2000);

        //release specimen
        robot.gripper.setPosition(0.47);

        android.os.SystemClock.sleep(1000);

        //reset arm
        robot.slideRot.setTargetPosition(lowPosition);
        robot.slideExt.setTargetPosition(minPosition);

        //reverse
        robot.backLeft.setPower(-0.25);
        robot.backRight.setPower(-0.25);
        robot.frontLeft.setPower(-0.25);
        robot.frontRight.setPower(-0.25);
        android.os.SystemClock.sleep(3000);

        //go forward a little
        robot.backLeft.setPower(0.15);
        robot.backRight.setPower(0.15);
        robot.frontLeft.setPower(0.15);
        robot.frontRight.setPower(0.15);

        android.os.SystemClock.sleep(1000);

        //stop
        robot.backLeft.setPower(0);
        robot.backRight.setPower(0);
        robot.frontLeft.setPower(0);
        robot.frontRight.setPower(0);

        android.os.SystemClock.sleep(500);

        //go right
        robot.backLeft.setPower(-0.25);
        robot.backRight.setPower(0.25);
        robot.frontLeft.setPower(0.25);
        robot.frontRight.setPower(-0.25);

        android.os.SystemClock.sleep(3000);

        robot.backLeft.setPower(0);
        robot.backRight.setPower(0);
        robot.frontLeft.setPower(0);
        robot.frontRight.setPower(0);

        android.os.SystemClock.sleep(5000);
        android.os.SystemClock.sleep(5000);
        android.os.SystemClock.sleep(5000);

    }
}
