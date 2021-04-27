package com.linkedgroup.linfood.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Data
public class Balanca {

    private List<String> ladoPesado = new ArrayList<>();

    public Balanca(){
        ladoPesado.add("ESQUERDA");
        ladoPesado.add("DIREITA");
    }

    public String resultadoLadoBalanca() {
        String resultadoDaBalanca = ladoPesado.get(new Random().nextInt(ladoPesado.size()));
        log.info("O resultado da ultima pesagem foi: {}", resultadoDaBalanca);
        return resultadoDaBalanca;
    }

    public void adicionaTipoDeLado(String tipo){
        this.ladoPesado.add(tipo);
    }
}
