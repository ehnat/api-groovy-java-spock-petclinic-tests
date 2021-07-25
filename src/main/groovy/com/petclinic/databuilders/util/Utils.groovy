package com.petclinic.databuilders.util

import groovy.transform.CompileStatic

import java.time.LocalDate
import java.time.format.DateTimeFormatter

@CompileStatic
class Utils {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern('yyyy/MM/dd')

    static String getTodayDate() {
        LocalDate.now().format(DATE_FORMATTER)
    }
}
