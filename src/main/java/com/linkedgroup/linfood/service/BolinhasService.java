package com.linkedgroup.linfood.service;

import com.linkedgroup.linfood.domain.Bolinhas;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
public class BolinhasService {

    public List<String> ladoBalancaMaisPesado = new ArrayList<>();

    public Bolinhas resolveDesafioBolinhas(int totalDeBolinhas, int divisaoDePesagens) {
        List<Bolinhas> bolinhas = iniciaBolinhas(12);

        while ((bolinhas.size()) % 2 == 0) {
            bolinhas = pesagem(bolinhas, divisaoDePesagens);
        }

        log.info("Processo da ultima pesagem iniciada");
        return ultimaPesagem(bolinhas);
    }

    private List<Bolinhas> iniciaBolinhas(int totalDeBolinhas) {
        List<Bolinhas> bolinhas = new ArrayList<>();
        for (int i = 1; i <= totalDeBolinhas; i++) {
            bolinhas.add(new Bolinhas(i));
        }
        ladoBalancaMaisPesado.add("DIREITA");
        ladoBalancaMaisPesado.add("ESQUERDA");
        return bolinhas;
    }

    private List<Bolinhas> pesagem(List<Bolinhas> bolinhas, int divPesagens) {
        List<Bolinhas> listaBalancaEsquerda
                = bolinhas.stream().limit(bolinhas.size() / 2).collect(Collectors.toList());

        String ladoMaisPesado = pegaLadoMaisPesado();
        log.info("O lado mais pesado é: {}", ladoMaisPesado);

        if (ladoMaisPesado.equals("ESQUERDA")) {
            return listaBalancaEsquerda;
        }
        return bolinhas.stream().filter(e -> !listaBalancaEsquerda.contains(e)).collect(Collectors.toList());
    }

    private Bolinhas ultimaPesagem(List<Bolinhas> bolinhas) {

        ladoBalancaMaisPesado.add("IGUAL");

        log.info("Numero ímpar de bolinhas, retirando uma...");
        final Bolinhas bolinhaSolitaria = bolinhas.stream().findFirst().orElseThrow(() -> new IllegalArgumentException("Erro ao fazer a retirada da bolinha"));
        log.info("bolinha retirada: {}", bolinhaSolitaria.getNumBolinha());

        log.info("Realizando a ultima pesagem");
        String ultimaPesagem = pegaLadoMaisPesado();

        log.info("O resultado da ultima pesagem foi: {}", ultimaPesagem);
        if (ultimaPesagem.equals("IGUAL")) {
            return bolinhaSolitaria;
        }

        List<Bolinhas> bolinhasUltimaPesagem = bolinhas.stream().filter(b -> b.getNumBolinha() != bolinhaSolitaria.getNumBolinha()).collect(Collectors.toList());
        if (ultimaPesagem.equals("ESQUERDA")) {
            return bolinhasUltimaPesagem.get(0);
        }
        return bolinhasUltimaPesagem.get(1);
    }

    private String pegaLadoMaisPesado() {
        return ladoBalancaMaisPesado.get(new Random().nextInt(ladoBalancaMaisPesado.size()));
    }


}
