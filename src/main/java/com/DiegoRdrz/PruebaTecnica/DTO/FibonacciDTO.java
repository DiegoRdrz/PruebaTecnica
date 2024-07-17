package com.DiegoRdrz.PruebaTecnica.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FibonacciDTO {

    private String time;
    private String sequence;
    private List<Integer> series;

}