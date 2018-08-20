package com.example.phili.kommengehenrechner;

public class ArbeitszeitUtil {
    /**
     * Rundet in 5er Schritten ab
     * @param zahl
     * @return
     */
    public static int abrunden(int zahl) {
        return zahl -= zahl % 5;
    }

    /**
     * Rundet in 5er Schritten auf
     * @param zahl
     * @return
     */
    public static int aufrunden(int zahl) {
        return (zahl + 4) / 5 * 5;
    }
}
