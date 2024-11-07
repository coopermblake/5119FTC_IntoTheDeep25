/*
Temporarily disabled
package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;

public class AprilTagInterface {
    private final AprilTagProcessor aprilTag;
    private final VisionPortal visionPortal;
    private final Position cameraPosition = new Position();
    private final YawPitchRollAngles cameraOrientation = new YawPitchRollAngles(AngleUnit.DEGREES);
    private Position currentRobotPosition;
    private YawPitchRollAngles currentRobotOrientation;

    AprilTagInterface(Robot robot) {
        aprilTag = new AprilTagProcessor.Builder()
                .setCameraPose(cameraPosition, cameraOrientation)
                .build();
        visionPortal = new VisionPortal.Builder()
                .setCamera(robot.webcam)
                .addProcessor(aprilTag)
                .build();
    }
    public Position getRobotPosition() {
        List<AprilTagDetection> detections = aprilTag.getDetections();
        for (AprilTagDetection detection : detections) {
            if (detection.metadata != null) {

            }
        }
        return currentRobotPosition;
    }
    public YawPitchRollAngles getRobotOrientation() {

        return currentRobotOrientation;
    }
    public void setDetectionStatus(boolean status) {
        visionPortal.setProcessorEnabled(aprilTag, status);
    }
}
 */
