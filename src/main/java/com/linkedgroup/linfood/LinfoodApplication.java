package com.linkedgroup.linfood;

import com.linkedgroup.linfood.service.BolinhasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class LinfoodApplication {

    public static void main(String[] args) {

        BolinhasService service = new BolinhasService();

        log.info("A Bolinha mais pesada no desafio é : {}", service.resolveDesafioBolinhas(12, 2).getNumBolinha());
    }
}



