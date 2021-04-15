/*  This OpMode helps with testing PR2275.

    "Without this PR, a LinearOpMode will stop executing, but appear to 
    keep running on the Driver Station, in the event that it throws a 
    CancellationException or InterruptedException."

    This OpMode allows observation without and with the PR, for either
    exception (or none), on various RC and DS devices.  Log files are
    also affected by this PR.
    
    v01 dated 4/14/21
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import java.util.concurrent.CancellationException;

@Autonomous(name = "W PR2275 Exception Stop V01", group = "")
public class W_PR2275ExceptionStop_v01 extends LinearOpMode {

  private String OpModeBehavior = "null";

  @Override
  public void runOpMode() throws InterruptedException, CancellationException {
  
  while (!gamepad1.a && !gamepad1.b && !gamepad1.x && !isStopRequested())  {
    telemetry.addData("Testing PR 2275 Exception Stop.  Choose one", "");
    telemetry.addData("", "Green A for well-behaved OpMode,");
    telemetry.addData("", "Red B for Interrupted Exception,");
    telemetry.addData("", "Blue X for Cancellation Exception.");    
    telemetry.update();

    if (gamepad1.a) OpModeBehavior = "Good";
    else if (gamepad1.b) OpModeBehavior = "Interrupted";
    else if (gamepad1.x) OpModeBehavior = "Cancellation";
  }
  
  telemetry.addData("Selection", OpModeBehavior);
  telemetry.addLine();
  telemetry.addData("", "Press the Start arrow to begin...");
  telemetry.update();

  waitForStart();
  if (opModeIsActive()) {
    if (OpModeBehavior.equals("Good"))  {
      telemetry.addData("", "OpMode ends quietly in 3 seconds");
      telemetry.update();
      sleep(3000);
    }
    else if (OpModeBehavior.equals("Interrupted"))  {
      telemetry.addData("", "Interrupted Exception in 3 seconds");
      telemetry.update();
      sleep(3000);
      throw new InterruptedException();   // this ends the OpMode
      // any code here gives compiler error "unreachable statement"
    } 
    else if (OpModeBehavior.equals("Cancellation"))  {
      telemetry.addData("", "Cancellation Exception in 3 seconds");
      telemetry.update();
      sleep(3000);
      throw new CancellationException();  // this ends the OpMode
      // any code here gives compiler error "unreachable statement"
      } 
    }  // end of main if structure
  
  }    // end of OpMode
}   // end of class


