package com.meuprojeto.model;

import java.io.Serializable;

public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;

    private int matricula;
    private String nome;
    private String curso;

    // Construtores, Getters e Setters

    public Aluno(int matricula, String nome, String curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    // ... Getters e Setters omitidos para brevidade

    @Override
    public String toString() {
        return "Aluno [Matricula=" + matricula + ", Nome=" + nome + ", Curso=" + curso + "]";
    }
}