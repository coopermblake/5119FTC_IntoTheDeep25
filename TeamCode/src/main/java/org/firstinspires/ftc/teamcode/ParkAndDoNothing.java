package org.firstinspires.ftc.teamcode;

import com.qualcomm.ftccommon.SoundPlayer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.android.AndroidSoundPool;

@Autonomous(name = "Park and do nothing", group = "Competition Opmodes")
public class ParkAndDoNothing extends LinearOpMode {
    public void runOpMode() throws InterruptedException {
        // TODO: huge hack, please replace this later
        Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);
        robot.gripper.setPosition(0.81);
        waitForStart();
        robot.backLeft.setPower(0.5);
        robot.backRight.setPower(0.5);
        robot.frontLeft.setPower(0.5);
        robot.frontRight.setPower(0.5);
        android.os.SystemClock.sleep(2500);
        robot.backLeft.setPower(0);
        robot.backRight.setPower(0);
        robot.frontLeft.setPower(0);
        robot.frontRight.setPower(0);
    }
    
}
