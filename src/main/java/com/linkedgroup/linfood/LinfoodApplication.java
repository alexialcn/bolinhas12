package com.linkedgroup.linfood;

import com.linkedgroup.linfood.service.BolinhasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class LinfoodApplication {

    public static void main(String[] args) {

        BolinhasService service = new BolinhasService();

        log.info("bolinhas mais pesada: {}", service.resolveDesafioBolinhas(12, 2).getNumBolinhas());
    }
}



