package frc.robot;

/*
 * This file contains constants that will be referenced by other parts of the robot
 * This is to allow for easy modification of global variables
 */

public final class Constants {
    
    //Constants related to the operation of the robot, i.e. controller ports
    public static class OperatorConstants {
        //Port for the general robot controller
        public static final int kDriverPort = 0;
    }

    //Constants related to the driving of the robot, i.e. the PWM ports or CAN IDs of the motor controllers
    public static class DriveConstants {
        //This is specifically made with CAN IDs in mind, but as long as the numbers align, it works for PWM ports
        //Drive motors:
        public static final int kLM1 = 1;
        public static final int kLM2 = 2;
        public static final int kRM1 = 3;
        public static final int kRM2 = 4;
        /*
         * 1 and 2 are front and back respectively
         * LM - Left Motor
         * RM - Right Motor
         */
    }



}
