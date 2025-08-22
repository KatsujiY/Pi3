package com.pi3.service;

import com.pi3.model.Aluno;
import com.pi3.repository.IRepository;

import java.util.ArrayList;
import java.util.List;

public class AlunoService {

    private final IRepository<Aluno> repository;
    private List<Aluno> alunos;

    public AlunoService(IRepository<Aluno> repository) {
        this.repository = repository;
        this.alunos = repository.carregar();
    }

    public void cadastrarAluno(String id, String nome, String curso) {
        if (!validarMatricula(id)) {
            throw new IllegalArgumentException("Matrícula inválida! Deve conter 6 dígitos numéricos.");
        }
        Aluno aluno = new Aluno(id, nome, curso);
        alunos.add(aluno);
        repository.salvar(alunos);
    }

    public List<Aluno> listarAlunos() {
        return new ArrayList<>(alunos);
    }

    /**
     * Valida se a matrícula é numérica e contém 6 dígitos.
     */
    public boolean validarMatricula(String id) {
        return id != null && id.matches("\\d{6}");
    }
}
