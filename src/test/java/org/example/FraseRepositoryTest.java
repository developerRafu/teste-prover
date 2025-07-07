package org.example;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FraseRepositoryTest {
    private FraseRepository repository;

    @Before
    public void setUp() {
        repository = new FraseRepository();
    }

    @Test
    public void testSalvarAnalise() {
        Map<String, Integer> ocorrencias = new HashMap<>();
        ocorrencias.put("ola", 2);
        ocorrencias.put("mundo", 1);
        repository.salvarAnalise("ola mundo ola", 2, ocorrencias);
        // Não verifica persistência, apenas que não lança exceção
    }
} 