package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.hardware.motors.GoBILDA5201Series;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.internal.network.WifiDirectAgent;
import org.firstinspires.ftc.robotcore.internal.opengl.models.Geometry;

@TeleOp(name="Drive Mode",group="Competition Opmodes")
public class driveMode extends LinearOpMode {
    public void runOpMode() throws InterruptedException {
        Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);
        long lastCycleStart = System.currentTimeMillis();
        waitForStart();
        robot.viperSlide.driverControl = true;
        while(opModeIsActive()) {
            telemetry.addData("refresh rate (hz): ",1000/(System.currentTimeMillis() - lastCycleStart + 1));
            lastCycleStart = System.currentTimeMillis();
            robot.drivetrain.robotCentricDrive(gamepad1, gamepad2);
            robot.viperSlide.teleopSlideMovement(gamepad1, gamepad2);
            telemetry.addData("ext", robot.viperSlide.slideExt.getCurrentPosition());
            telemetry.addData("rot", robot.viperSlide.slideRot.getCurrentPosition());
            telemetry.addData("extMin", robot.viperSlide.extMin);
            telemetry.addData("extMaxLow", robot.viperSlide.extMaxLow);
            telemetry.addData("extMaxHigh", robot.viperSlide.extMaxHigh);
            telemetry.addData("rotMin", robot.viperSlide.rotMin);
            telemetry.addData("rotMax", robot.viperSlide.rotMax);
            telemetry.addData( "gripper", robot.gripper.getPosition());
            telemetry.addData("rightTrigger", gamepad2.right_trigger);
            telemetry.update();
        }
    }
}
