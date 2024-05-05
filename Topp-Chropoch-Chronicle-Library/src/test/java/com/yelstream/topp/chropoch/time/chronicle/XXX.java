package com.yelstream.topp.chropoch.time.chronicle;

import lombok.AllArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;

@AllArgsConstructor
public class XXX {

    private final Chronicle chronicle;

    public void run() {

        LocalDate localDate=chronicle.temporal().localDate().now();

//        Duration sleepDuration=chronicle.delay().duration(null).localDate().apply();




    }
}
