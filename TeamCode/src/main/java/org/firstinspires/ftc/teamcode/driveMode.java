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
        long lastCycleStart;
        robot.gripper.setPosition(0.81);
        waitForStart();
        robot.viperSlide.driverControl = true;
        while(opModeIsActive()) {
            robot.emergencyStop.checkAllMotors(robot);
            lastCycleStart = System.currentTimeMillis();
            robot.drivetrain.robotCentricDrive(gamepad1, gamepad2);
            robot.viperSlide.teleopSlideMovement(gamepad1, gamepad2);
            telemetry.addData("refresh rate (hz): ",1.0/(double) (System.currentTimeMillis() - lastCycleStart) );
            telemetry.update();
        }
    }
}
