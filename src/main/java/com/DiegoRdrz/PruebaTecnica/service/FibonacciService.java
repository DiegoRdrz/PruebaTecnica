package com.DiegoRdrz.PruebaTecnica.service;

import com.DiegoRdrz.PruebaTecnica.DTO.FibonacciDTO;
import com.DiegoRdrz.PruebaTecnica.Model.Fibonacci;
import com.DiegoRdrz.PruebaTecnica.Repository.FibonacciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FibonacciService {

    @Autowired
    private FibonacciRepository fibonacciRepository;

    private static List<Integer> getIntegers(String time) {
        String[] timeParts = time.split(":");
        String minuteStr = timeParts[1];
        int seconds = Integer.parseInt(timeParts[2]);
        int a = Integer.parseInt(minuteStr.substring(0, 1));
        int b = Integer.parseInt(minuteStr.substring(1, 2));


        List<Integer> fibonacciSequence = new ArrayList<>();
        fibonacciSequence.add(a);
        fibonacciSequence.add(b);

        for (int i = 0; i < seconds; i++) {
            int next = a + b;
            fibonacciSequence.add(next);
            a = b;
            b = next;
        }
        return fibonacciSequence;
    }

    public FibonacciDTO generateFibonacci(String time) {
        List<Integer> fibonacciSequence = getIntegers(time);

        Fibonacci fibonacci = new Fibonacci();
        fibonacci.setTime(time);
        fibonacci.setSequence(fibonacciSequence.toString());
        fibonacciRepository.save(fibonacci);

        FibonacciDTO fibonacciDTO = new FibonacciDTO();
        fibonacciDTO.setTime(time);
        fibonacciDTO.setSequence(fibonacciSequence.toString());

        return fibonacciDTO;
    }

    public List<Fibonacci> getAllFibonacciSequences() {
        try {
            return fibonacciRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener las secuencias de Fibonacci", e);
        }
    }

}