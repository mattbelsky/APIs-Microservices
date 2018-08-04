package RequestHeaderParserMicroservice;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/requestheaderparserservice")
public class AppController {

    @GetMapping("/api/whoami")
    public @ResponseBody ParsedHeader getWhoIAm(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String acceptLanguage,
                                                @RequestHeader(HttpHeaders.USER_AGENT) String userAgent,
                                                HttpServletRequest httpServletRequest) {
        return new ParsedHeader(httpServletRequest.getRemoteAddr(), acceptLanguage, userAgent);
    }
}
