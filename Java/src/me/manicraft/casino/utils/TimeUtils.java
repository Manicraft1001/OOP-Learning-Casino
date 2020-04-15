package me.manicraft.casino.utils;

import java.util.concurrent.TimeUnit;

/**
 * Utils class for managing some time things
 * @author Manuel Ruwe
 * @author www.ict-campus.net
 */

public class TimeUtils {

    /**
     * This method waits the provided time
     * Could result an InterruptedException if user executes CTRL + C or tries to interrupt the current script / program
     * If a Exception occurs while executing sleep command, program will be exited with code 0
     * @param s Time in seconds to sleep
     */
    public static void sleep(int s) {
        try {
            TimeUnit.SECONDS.sleep(s);
        } catch (InterruptedException e) {
            System.exit(0);
        }
    }
}
