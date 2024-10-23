package com.DiegoRdrz.PruebaTecnica.Model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "Fibonaccis")
public class Fibonacci {

    @Id
    private String id;
    private String time;
    private String sequence;
    private List<Integer> series;
}
