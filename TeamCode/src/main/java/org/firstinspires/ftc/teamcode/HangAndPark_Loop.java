package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Hang and park loop variant", group = "Competition Opmodes")
public class HangAndPark_Loop extends LinearOpMode {
    public void runOpMode() throws InterruptedException {
        Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);
        int lowPosition = robot.slideRot.getCurrentPosition();
        int minPosition = robot.slideExt.getCurrentPosition();
        robot.gripper.setPosition(0.81);
        waitForStart();
        // note: replace this with RR Actions system later
        while (opModeIsActive()) {

        }
    }
}
