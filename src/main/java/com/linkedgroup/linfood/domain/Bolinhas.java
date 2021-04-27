package com.linkedgroup.linfood.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bolinhas {

    private int numBolinhas;

    public List<Bolinhas> iniciaProcessoBolinhas(int numBolinhas) {

        List<Bolinhas> bolinhas = new ArrayList<>();
        for (int i = 1; i <= numBolinhas; i++) {
            bolinhas.add(new Bolinhas(i));
        }
        return bolinhas;
    }
}
