package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Drive Mode",group="Competition Opmodes")
public class driveMode extends LinearOpMode {
    public void runOpMode() throws InterruptedException {
        Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);
        waitForStart();
        while(opModeIsActive()) {
            robot.drivetrain.rawDriveMovement();
            robot.viperSlide.teleopSlideMovement();
        }
    }
}
