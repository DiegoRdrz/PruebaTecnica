package com.DiegoRdrz.PruebaTecnica.Repository;

import com.DiegoRdrz.PruebaTecnica.Model.Fibonacci;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FibonacciRepository extends MongoRepository<Fibonacci, Long> {
}
