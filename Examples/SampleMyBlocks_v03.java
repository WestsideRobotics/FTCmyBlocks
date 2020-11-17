/*
This example is used in a tutorial on FTC myBlocks.
A gamepad button operates a simple timer.
The Blocks user places this myBlock in a loop.
*/

package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.ExportToBlocks;

public class SampleMyBlocks_v03 extends BlocksOpModeCompanion {

    // declare the timer object, outside the method
    private static ElapsedTime myStopwatch = new ElapsedTime();

    @ExportToBlocks (
    comment = "Place this myBlock inside a 'repeat loop'. Press button X to reset timer.",
    tooltip = "Stopwatch on gamepad button X."
    )
    public static void stopwatchX()  {      // myBlock method "stopwatchX"
        
        telemetry.addData("Stopwatch timer", "%.2f", myStopwatch.time());
        telemetry.addData("To reset stopwatch", "press button X");
        telemetry.update();                 // display message on DS screen
        
        if (gamepad1.x || gamepad2.x)  {    // press button X, either gamepad
            myStopwatch.reset();            // reset the timer
        }
   
    }   // end of method stopwatchX()
    
}       // end of class SampleMyBlocks_v03
