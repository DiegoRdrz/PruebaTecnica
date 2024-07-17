package com.DiegoRdrz.PruebaTecnica.Controller;

import com.DiegoRdrz.PruebaTecnica.DTO.FibonacciDTO;
import com.DiegoRdrz.PruebaTecnica.Model.Fibonacci;
import com.DiegoRdrz.PruebaTecnica.service.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/series")
public class FibonacciController {
    @Autowired
    private FibonacciService fibonacciService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<Fibonacci> getAllFibonacciSequences() {
        return fibonacciService.getAllFibonacciSequences();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/{time}")
    public FibonacciDTO generateFibonacci(@PathVariable String time) {
        return fibonacciService.generateFibonacci(time);
    }

}