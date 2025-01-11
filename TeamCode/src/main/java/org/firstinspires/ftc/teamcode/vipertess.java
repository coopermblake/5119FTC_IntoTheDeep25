package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "viper tess", group = "Competition Opmodes")
public class vipertess extends LinearOpMode {
    public void runOpMode() throws InterruptedException {
        Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);
        telemetry.addData("ext",robot.viperSlide.slideExt.getCurrentPosition());
        telemetry.addData("rot",robot.viperSlide.slideRot.getCurrentPosition());
        telemetry.update();
        waitForStart();
        while(opModeIsActive()){
            telemetry.addData("ext",robot.viperSlide.slideExt.getCurrentPosition());
            telemetry.addData("rot",robot.viperSlide.slideRot.getCurrentPosition());
            telemetry.update();
        }

    }
}
