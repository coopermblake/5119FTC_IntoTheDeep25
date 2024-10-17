package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="DriveTest",group="TEST")
public class driveTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Robot robot = new Robot(hardwareMap, gamepad1, gamepad2);
        robot.init();
        waitForStart();
        while(opModeIsActive()) {
            robot.processDriveInput();
            robot.rawDriveMovement();
        }
    }
}
