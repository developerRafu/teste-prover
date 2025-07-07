package org.example;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Map;

public class FraseRepository {
    private static final String DB_URL = "jdbc:sqlite:frases.db";
    private static final String CREATE_TABLE_SQL =
            "CREATE TABLE IF NOT EXISTS analise_frase (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "frase TEXT NOT NULL, " +
            "data_hora TIMESTAMP NOT NULL, " +
            "total_distintas INTEGER NOT NULL, " +
            "ocorrencias TEXT NOT NULL)";

    public FraseRepository() {
        inicializarBanco();
    }

    private void inicializarBanco() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(CREATE_TABLE_SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void salvarAnalise(String frase, int totalDistintas, Map<String, Integer> ocorrencias) {
        String ocorrenciasStr = ocorrencias.toString();
        String sql = "INSERT INTO analise_frase (frase, data_hora, total_distintas, ocorrencias) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, frase);
            pstmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            pstmt.setInt(3, totalDistintas);
            pstmt.setString(4, ocorrenciasStr);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
} 