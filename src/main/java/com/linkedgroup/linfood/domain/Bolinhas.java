package com.linkedgroup.linfood.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bolinhas {

    private int numBolinha;
    private PesoBolinha pesoBolinha;

}
