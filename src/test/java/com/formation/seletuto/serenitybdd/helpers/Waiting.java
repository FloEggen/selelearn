package com.formation.seletuto.serenitybdd.helpers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Waiting {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            log.warn("waitFor(millis): " + e);
        }
    }

    public static void waitFor(long millis) {
        sleep(millis);
    }

}
