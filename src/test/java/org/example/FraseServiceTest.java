package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class FraseServiceTest {
    private FraseService service;

    @Before
    public void setUp() {
        service = new FraseService();
    }

    @Test
    public void testAnaliseFraseVazia() {
        Map<String, Integer> resultado = service.analisar("");
        Assert.assertTrue(resultado.isEmpty());
    }

    @Test
    public void testAnaliseFraseSimples() {
        Map<String, Integer> resultado = service.analisar("ola mundo ola");
        Assert.assertEquals(2, resultado.size());
        Assert.assertEquals(Integer.valueOf(2), resultado.get("ola"));
        Assert.assertEquals(Integer.valueOf(1), resultado.get("mundo"));
    }

    @Test
    public void testAnaliseComPontuacao() {
        Map<String, Integer> resultado = service.analisar("Ola, mundo! Ola.");
        Assert.assertEquals(2, resultado.size());
        Assert.assertEquals(Integer.valueOf(2), resultado.get("ola"));
        Assert.assertEquals(Integer.valueOf(1), resultado.get("mundo"));
    }
} 