package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;

public class Controller {
    private Gamepad gamepad1Previous = new Gamepad();
    private Gamepad gamepad2Previous = new Gamepad();
    private Gamepad gamepad1;
    private Gamepad gamepad2;
    private Gamepad gamepad1Active;
    private Gamepad gamepad2Active;
    // These are the thresholds for when an input will be counted as a button press for analog inputs.
    public double leftStickXThreshold = 0.75;
    public double leftStickYThreshold = 0.75;
    public double rightStickXThreshold = 0.75;
    public double rightStickYThreshold = 0.75;
    public double leftTriggerThreshold = 0.75;
    public double rightTriggerThreshold = 0.75;

    public enum BUTTON {
        LSTICKX,
        LSTICKY,
        RSTICKX,
        RSTICKY,
        A,
        B,
        X,
        Y,
        LB,
        RB,
        LT,
        RT,
        BACK,
        START,
        LSTICKCLICK,
        RSTICKCLICK,
        DPADUP,
        DPADDOWN,
        DPADLEFT,
        DPADRIGHT
    }
    public Controller(Gamepad gamepad1, Gamepad gamepad2) {
        this.gamepad1 = gamepad1;
        this.gamepad2 = gamepad2;
    }
    public void update() {
        gamepad1Previous.copy(gamepad1Active);
        gamepad1Previous.copy(gamepad2Active);
        gamepad1Active.copy(gamepad1);
        gamepad2Active.copy(gamepad2);
    }
    public boolean buttonOnce(BUTTON button, boolean isController1, boolean onPress) {
        Gamepad previousInputController;
        Gamepad currentInputController;
        if (isController1) {
            previousInputController = gamepad1Previous;
            currentInputController = gamepad1Active;
        } else {
            previousInputController = gamepad2Previous;
            currentInputController = gamepad2Active;
        }
        boolean previousInput;
        boolean currentInput;
        switch (button) {
            case LSTICKX:
                previousInput = Math.abs(previousInputController.left_stick_x) > leftStickXThreshold;
                currentInput = Math.abs(currentInputController.left_stick_x) > leftStickXThreshold;
                break;
            case LSTICKY:
                previousInput = Math.abs(previousInputController.left_stick_y) > leftStickYThreshold;
                currentInput = Math.abs(currentInputController.left_stick_y) > leftStickYThreshold;
                break;
            case RSTICKX:
                previousInput = Math.abs(previousInputController.right_stick_x) > rightStickXThreshold;
                currentInput = Math.abs(currentInputController.right_stick_x) > rightStickXThreshold;
                break;
            case RSTICKY:
                previousInput = Math.abs(previousInputController.right_stick_y) > rightStickYThreshold;
                currentInput = Math.abs(currentInputController.right_stick_y) > rightStickYThreshold;
                break;
            case A:
                previousInput = previousInputController.a;
                currentInput = currentInputController.a;
                break;
            case B:
                previousInput = previousInputController.b;
                currentInput = currentInputController.b;
                break;
            case X:
                previousInput = previousInputController.x;
                currentInput = currentInputController.x;
                break;
            case Y:
                previousInput = previousInputController.y;
                currentInput = currentInputController.y;
                break;
            case LB:
                previousInput = previousInputController.left_bumper;
                currentInput = currentInputController.left_bumper;
                break;
            case RB:
                previousInput = previousInputController.right_bumper;
                currentInput = currentInputController.right_bumper;
                break;
            case LT:
                previousInput = Math.abs(previousInputController.left_trigger) > leftTriggerThreshold;
                currentInput = Math.abs(currentInputController.left_trigger) > leftTriggerThreshold;
                break;
            case RT:
                previousInput = Math.abs(previousInputController.right_trigger) > rightTriggerThreshold;
                currentInput = Math.abs(currentInputController.right_trigger) > rightTriggerThreshold;
                break;
            case BACK:
                previousInput = previousInputController.back;
                currentInput = currentInputController.back;
                break;
            case START:
                previousInput = previousInputController.start;
                currentInput = currentInputController.start;
                break;
            case LSTICKCLICK:
                previousInput = previousInputController.left_stick_button;
                currentInput = currentInputController.left_stick_button;
                break;
            case RSTICKCLICK:
                previousInput = previousInputController.right_stick_button;
                currentInput = currentInputController.right_stick_button;
                break;
            case DPADUP:
                previousInput = previousInputController.dpad_up;
                currentInput = currentInputController.dpad_up;
                break;
            case DPADDOWN:
                previousInput = previousInputController.dpad_down;
                currentInput = currentInputController.dpad_down;
                break;
            case DPADLEFT:
                previousInput = previousInputController.dpad_left;
                currentInput = currentInputController.dpad_left;
                break;
            case DPADRIGHT:
                previousInput = previousInputController.dpad_right;
                currentInput = currentInputController.dpad_right;
                break;
            default:
                previousInput = false;
                currentInput = false;
        }
        // first () detects change, second () checks if the previous input is correct
        return (previousInput ^ currentInput) && (previousInput ^ onPress);
    }
    // only works for "analog" inputs
    public boolean pressed(BUTTON button, boolean isController1) {
        Gamepad selectedController;
        if (isController1) {
            selectedController = gamepad1Active;
        } else {
            selectedController = gamepad2Active;
        }
        switch (button) {
            case LSTICKX:
                return Math.abs(selectedController.left_stick_x) > leftStickXThreshold;
            case LSTICKY:
                return Math.abs(selectedController.left_stick_y) > leftStickYThreshold;
            case RSTICKX:
                return Math.abs(selectedController.right_stick_x) > rightStickXThreshold;
            case RSTICKY:
                return Math.abs(selectedController.right_stick_y) > rightStickYThreshold;
            case LT:
                return Math.abs(selectedController.left_trigger) > leftTriggerThreshold;
            case RT:
                return Math.abs(selectedController.right_trigger) > rightTriggerThreshold;
            default:
                return false;
        }
    }
}
