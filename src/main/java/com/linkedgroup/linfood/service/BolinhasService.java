package com.linkedgroup.linfood.service;

import com.linkedgroup.linfood.domain.Balanca;
import com.linkedgroup.linfood.domain.Bolinhas;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BolinhasService {

    Balanca balanca = new Balanca();


    public Bolinhas resolveDesafioBolinhas(int numBolinhas, int numDivisoesDeBolinhas) {
        List<Bolinhas> bolinhas = new Bolinhas().iniciaProcessoBolinhas(numBolinhas);

        while (bolinhas.size() % 2 == 0) {
            bolinhas = pesagem(bolinhas, numDivisoesDeBolinhas);
            log.info("bolinhas: {}", bolinhas);
        }

        return ultimaPesagem(bolinhas);
    }

    private List<Bolinhas> pesagem(List<Bolinhas> bolinhas, int numDivisoesDeBolinhas) {
        List<Bolinhas> listaBalancaEsquerda = bolinhas.stream().limit(bolinhas.size() / numDivisoesDeBolinhas).collect(Collectors.toList());

        log.info("Pesando bolinhas..");
        if (balanca.resultadoLadoBalanca().equals("ESQUERDA")) {
            return listaBalancaEsquerda;
        }

        return bolinhas.stream().filter(c -> !listaBalancaEsquerda.contains(c)).collect(Collectors.toList());
    }

    private Bolinhas ultimaPesagem(List<Bolinhas> bolinhas) {
        balanca.adicionaTipoDeLado("IGUAL");
        log.info("Bolinhas de numero ímpar, isolando uma..");
        Bolinhas bolinhaSolitaria = bolinhas.stream().findFirst().orElseThrow(() -> new IllegalArgumentException("Erro ao pesar a bolinha pela ultima vez"));
        log.info("A bolinha retirada foi: {}", bolinhaSolitaria);
        log.info("Realizando a ultima pesagem..");
        String resultadoDaBalanca = balanca.resultadoLadoBalanca();

        if (resultadoDaBalanca.equals("IGUAL")) {
            return bolinhaSolitaria;
        }

        List<Bolinhas> bolinhasFiltradas = bolinhas.stream().filter(b -> b.getNumBolinhas() != bolinhaSolitaria.getNumBolinhas()).collect(Collectors.toList());
        if (resultadoDaBalanca.equals("ESQUERDA")) {
            return bolinhasFiltradas.get(0);
        }
        return bolinhasFiltradas.get(1);
    }
}
