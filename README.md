# teste-prover

## Descrição
Sistema web Java para análise de frases, que recebe uma frase digitada pelo usuário e retorna a quantidade de palavras distintas e a quantidade de ocorrências de cada palavra. Os resultados são salvos em um banco SQLite via JDBC.

## Funcionalidades
- Interface web JSF com PrimeFaces para entrada e exibição dos resultados.
- Backend Java 8 com CDI, separando responsabilidades em beans de interface, serviço e persistência.
- Persistência do histórico de análises em banco SQLite.
- Testes unitários com JUnit e Mockito.

## Requisitos
- Java 8 (JDK 1.8)
- Maven
- WildFly 10
- Navegador Chrome ou Edge

## Como executar

### 1. Compilar o projeto
```sh
mvn clean package
```

### 2. Deploy no WildFly
- Copie o arquivo `target/tetse-prover.war` para a pasta `standalone/deployments/` do seu WildFly 10.
- Inicie o WildFly (caso não esteja rodando):
  - Windows: `standalone.bat`
  - Linux/Mac: `./standalone.sh`

### 3. Acesse a aplicação
Abra o navegador e acesse:
```
http://localhost:8080/tetse-prover/
```

### 4. Executar os testes
```sh
mvn test
```

## Estrutura do Projeto
```
org.example.FraseBean         // Bean JSF (interface)
org.example.FraseService      // Lógica de análise
org.example.FraseRepository   // Persistência JDBC
```

## Observações
- O banco SQLite (`frases.db`) é criado automaticamente na raiz do projeto.
- O sistema não depende de JPA/Hibernate, apenas JDBC puro.
- O deploy pode ser feito com o WildFly rodando (hot deploy).

## Exemplo de uso
1. Digite uma frase na interface web.
2. Clique em "Analisar".
3. Veja o total de palavras distintas e a contagem de cada palavra.

---
Dúvidas ou problemas? Abra uma issue ou entre em contato!