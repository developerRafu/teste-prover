package org.example;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

@Named
@RequestScoped
public class FraseBean {
    private String frase;
    private Map<String, Integer> ocorrencias;
    private int totalDistintas;

    @Inject
    public FraseService fraseService;
    @Inject
    public FraseRepository fraseRepository;

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public Map<String, Integer> getOcorrencias() {
        return ocorrencias;
    }

    public int getTotalDistintas() {
        return totalDistintas;
    }

    public synchronized void analisarFrase() {
        ocorrencias = fraseService.analisar(frase);
        totalDistintas = ocorrencias.size();
        fraseRepository.salvarAnalise(frase, totalDistintas, ocorrencias);
    }
} 