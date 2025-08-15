package com.meuprojeto.repository;

import com.meuprojeto.model.Aluno;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {

    private final String NOME_ARQUIVO = "alunos.dat";

    public void salvar(List<Aluno> alunos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOME_ARQUIVO))) {
            oos.writeObject(alunos);
        } catch (IOException e) {
            System.err.println("Erro ao salvar alunos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public List<Aluno> carregar() {
        File arquivo = new File(NOME_ARQUIVO);
        if (arquivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
                return (List<Aluno>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Erro ao carregar alunos: " + e.getMessage());
                return new ArrayList<>();
            }
        }
        return new ArrayList<>();
    }
}