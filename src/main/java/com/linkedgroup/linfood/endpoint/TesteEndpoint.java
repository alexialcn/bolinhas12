package com.linkedgroup.linfood.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class TesteEndpoint {

    @GetMapping("/test")
    @ResponseBody
    public String testeDoBom() {
       log.info("uai so");
        return "flep";
    }
}
