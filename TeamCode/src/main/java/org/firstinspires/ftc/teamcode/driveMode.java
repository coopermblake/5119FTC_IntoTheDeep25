package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Drive Mode",group="Competition Opmodes")
public class driveMode extends LinearOpMode {
    public void runOpMode() throws InterruptedException {
        Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);
        waitForStart();
        while(opModeIsActive()) {
            if (robot.viperSlide.slideExtended) { // restrict top speed when slide is out
                robot.drivetrain.rawDriveMovement(0.5);
            } else {
                robot.drivetrain.rawDriveMovement(1);
            }
            robot.viperSlide.teleopSlideMovement();
            // if (gamepad1.y) {
            //     robot.imu.resetYaw();
            // }
        }
    }
}
