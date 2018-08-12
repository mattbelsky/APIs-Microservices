package TimestampMicroservice;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.*;

@Service
public class TimestampService {

    /**
     * Parses input as either an ISO-8601 formatted (YYYY-MM-DD) date or milliseconds from the start of the current era.
     * @param dateInput the user input
     * @return the response object containing the date in both millisecond and string form
     */
    public DateResponse parseInput(String dateInput) {

        int year = 0;
        int month = 0;
        int dayOfMonth = 0;
        int hour = 0;
        int minute = 0;
        LocalDateTime localDateTime;
        Timestamp timestamp;

        // If there is no input, use the current time.
        if (dateInput == null) {

            timestamp = new Timestamp(System.currentTimeMillis());
            return new DateResponse(timestamp.getTime(), timestamp.toString());

        // If the input string has the format of XXXX-XX-XX, assign the year, month, and day to the appropriate
        // variables, and use them to initialize the LocalDateTime object.
        } else if (dateInput.length() >= 5 &&
                   dateInput.substring(4, 5).equals("-") &&
                   dateInput.substring(7, 8).equals("-")) {

            year = Integer.parseInt(dateInput.substring(0, 4));
            month = Integer.parseInt(dateInput.substring(5, 7));
            dayOfMonth = Integer.parseInt(dateInput.substring(8));

            localDateTime = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
            timestamp = new Timestamp(localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli());
            
            return new DateResponse(timestamp.getTime(), timestamp.toString());

        // Otherwise, the input should be parseable as milliseconds.
        } else {

            timestamp = new Timestamp(Long.parseLong(dateInput));
            return new DateResponse(timestamp.getTime(), timestamp.toString());
        }
    }
}
