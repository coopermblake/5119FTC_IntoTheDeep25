package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Hang and park loop variant", group = "Competition Opmodes")
public class HangAndPark_Loop extends LinearOpMode {
    public void runOpMode() throws InterruptedException {
        Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);
        int lowPosition = robot.slideRot.getCurrentPosition();
        int highPosition = lowPosition + 2800;
        int minPosition = robot.slideExt.getCurrentPosition();
        int maxPosition = minPosition + 1200;
        robot.gripper.setPosition(0.81);
        waitForStart();
        // note: replace this with RR Actions system later
        int action = 0;
        ElapsedTime timer = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
        boolean isWaiting = false;
        boolean endedWaiting = false;
        boolean actionOver;
        int waitingEnd = 0;
        while (opModeIsActive()) {
            switch (action) {
                case 0: // raise and extend the arm
                    if(!isWaiting && !endedWaiting) {
                        isWaiting = true;
                        waitingEnd = 500;
                        robot.slideRot.setTargetPosition(highPosition);
                        robot.slideRot.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        robot.slideRot.setPower(1);
                        timer.reset();
                    } else if (endedWaiting) {
                        robot.slideRot.setPower(0);
                    }
                    actionOver = false;
                case 1: // lower the arm to midpoint

                case 2: // move robot to hang bar from start

                case 3: // move robot to wall position from hang bar

                case 4: // move robot to hang bar from wall position

            }
            if (isWaiting) {
                if (timer.milliseconds() > waitingEnd) {
                    isWaiting = false;
                    endedWaiting = true;
                }
            }
        }
    }
}
