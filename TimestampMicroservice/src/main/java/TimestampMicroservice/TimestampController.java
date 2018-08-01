package TimestampMicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/timestampservice")
public class TimestampController {

    @Autowired
    TimestampService timestampService;

    @GetMapping("/api/timestamp/{date_string}")
    public DateResponse getTimestamp(@PathVariable(value = "date_string", required = false) String dateString) {
        return timestampService.parseInput(dateString);
    }
}
