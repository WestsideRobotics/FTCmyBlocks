package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion;
import org.firstinspires.ftc.robotcore.external.ExportToBlocks;
import com.qualcomm.robotcore.hardware.Servo;

public class SampleMyBlocks extends BlocksOpModeCompanion {

    @ExportToBlocks (
    comment = "Move a conventional servo back and forth. Assumes servo starts from position 0. Servo name must be in the active configuration.",
    tooltip = "Wiggle a user-designated servo.",
    parameterLabels = {"Servo name", "Duration (milliseconds)", "Number of cycles"}
    )
    
    public static void wiggleServo (String servoName, int duration, int cycles) {

        Servo myServo = hardwareMap.get(Servo.class, servoName);

        for (int i = 1; i <= cycles; i++)  {       // count up to 'cycles'
            myServo.setPosition(0.5);              // move servo clockwise
            linearOpMode.sleep(duration);          // wait for 'duration'
            myServo.setPosition(0);                // move servo counterclockwise
            linearOpMode.sleep(duration);          // wait for 'duration'
        }
    }   // end method wiggleServo()
}       // end class SampleMyBlocks
