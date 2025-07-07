package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FraseService {
    public Map<String, Integer> analisar(String frase) {
        if (frase == null || frase.trim().isEmpty()) {
            return Collections.emptyMap();
        }
        System.out.println("Input: " + frase);
        String fraseLimpa = frase.toLowerCase().replaceAll("[.,!?]", "").replaceAll("\\s+", " ").trim();
        String[] palavras = fraseLimpa.split(" ");
        Map<String, Integer> mapa = new HashMap<>();
        for (String palavra : palavras) {
            if (!palavra.isEmpty()) {
                mapa.put(palavra, mapa.getOrDefault(palavra, 0) + 1);
            }
        }
        return mapa;
    }
} 