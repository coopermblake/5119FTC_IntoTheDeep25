package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorControllerEx;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

public class EmergencyStop {
    public boolean checkAllMotors(Robot robot) {
        DcMotor[] allMotors = {robot.slideExt, robot.slideRot};
        for (int i = 0; i < allMotors.length; i++) {
            if (checkMotor(allMotors[i])) {
                return true;
            }
        }
        return false;
    }

    // this should check if a motor is stalled out on something or otherwise stuck.
    public boolean checkMotor(DcMotor motor) {
        DcMotorEx motorEx = (DcMotorEx) motor;
        if (motorEx.getCurrent(CurrentUnit.AMPS) > 4 && motorEx.getVelocity() < 50) {
            motorEx.setMotorDisable();
            return true;
        } else {
            return false;
        }
    }
}
