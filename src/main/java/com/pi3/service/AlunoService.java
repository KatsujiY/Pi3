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
        Aluno aluno = new Aluno(id, nome, curso);
        alunos.add(aluno);
        repository.salvar(alunos);
    }

    public List<Aluno> listarAlunos() {
        return new ArrayList<>(alunos);
    }
}
