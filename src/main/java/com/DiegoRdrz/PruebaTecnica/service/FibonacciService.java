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

    public FibonacciDTO generateFibonacci(String time) {
        String[] timeParts = time.split(":");
        String minuteStr = timeParts[1];
        int a = Integer.parseInt(minuteStr.substring(0, 1));
        int b = Integer.parseInt(minuteStr.substring(1, 2));

        List<Integer> fibonacciSequence = new ArrayList<>();
        fibonacciSequence.add(a);
        fibonacciSequence.add(b);

        for (int i = 0; i < 10; i++) {
            int next = a + b;
            fibonacciSequence.add(next);
            a = b;
            b = next;
        }

        Fibonacci fibonacci = new Fibonacci();
        fibonacci.setTime(time);
        fibonacci.setSequence(fibonacciSequence.toString());
        fibonacciRepository.save(fibonacci);

        FibonacciDTO fibonacciDTO = new FibonacciDTO();
        fibonacciDTO.setTime(time);
        fibonacciDTO.setSequence(fibonacciSequence.toString());

        return fibonacciDTO;
    }

    public List<FibonacciDTO> getAllFibonacciSequences() {
        List<Fibonacci> fibonacciList = fibonacciRepository.findAll();
        List<FibonacciDTO> fibonacciDTOList = new ArrayList<>();

        for (Fibonacci fibonacci : fibonacciList) {
            FibonacciDTO fibonacciDTO = new FibonacciDTO();
            fibonacciDTO.setTime(fibonacci.getTime());
            fibonacciDTO.setSequence(fibonacci.getSequence());
            fibonacciDTO.setSeries(Arrays.stream(fibonacci.getSequence().split(",")).map(Integer::parseInt).collect(Collectors.toList()));
            fibonacciDTOList.add(fibonacciDTO);
        }

        return fibonacciDTOList;
    }

}