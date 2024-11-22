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
            telemetry.addData("Slide rotation stick input", -gamepad2.right_stick_y);
            telemetry.addData("Slide extension stick input", -gamepad2.left_stick_y);
            robot.viperSlide.teleopSlideMovement();
            telemetry.addData("Slide rotation real input", robot.slideRot.getPower());
            telemetry.addData("Slide extension real input", robot.slideRot.getPower());
            robot.viperSlide.handleMacros();
            telemetry.addData("Viper slide rotation encoder: ", robot.viperSlide.slideRot.getCurrentPosition());
            telemetry.addData("Viper slide extension encoder: ", robot.viperSlide.slideExt.getCurrentPosition());
            telemetry.update();
        }
    }
}
