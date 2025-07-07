package org.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class FraseBeanTest {
    private FraseBean bean;
    private FraseService mockService;
    private FraseRepository mockRepository;

    @Before
    public void setUp() {
        bean = new FraseBean();
        mockService = Mockito.mock(FraseService.class);
        mockRepository = Mockito.mock(FraseRepository.class);

        bean.fraseService = mockService;
        bean.fraseRepository = mockRepository;
    }

    @Test
    public void testGetSetFrase() {
        bean.setFrase("teste");
        assertEquals("teste", bean.getFrase());
    }

    @Test
    public void testAnalisarFrase() {
        Map<String, Integer> resultado = new HashMap<>();
        resultado.put("ola", 2);
        Mockito.when(mockService.analisar("ola ola")).thenReturn(resultado);
        bean.setFrase("ola ola");
        bean.analisarFrase();
        assertEquals(resultado, bean.getOcorrencias());
        assertEquals(1, bean.getTotalDistintas());
        Mockito.verify(mockRepository).salvarAnalise("ola ola", 1, resultado);
    }
} 