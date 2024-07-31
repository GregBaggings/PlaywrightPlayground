package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static constants.Constants.DATE_PATTERN;

public class ExecutionDateHandler {

    public static String getExecutionDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        LocalDateTime now = LocalDateTime.now();
        return dateTimeFormatter.format(now).replace(" ", "-").replaceAll("/", "-").replaceAll(":", "-");
    }

}
