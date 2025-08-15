package com.meuprojeto.service;

import com.meuprojeto.model.Aluno;
import com.meuprojeto.repository.AlunoRepository;
import java.util.List;

public class AlunoService {

    private List<Aluno> alunos;
    private final AlunoRepository repository;

    public AlunoService() {
        this.repository = new AlunoRepository();
        this.alunos = repository.carregar();
    }

    public void adicionarAluno(int matricula, String nome, String curso) {
        // Lógica de negócio (ex: validação) poderia ser adicionada aqui
        Aluno novoAluno = new Aluno(matricula, nome, curso);
        this.alunos.add(novoAluno);
        this.repository.salvar(this.alunos);
        System.out.println("Aluno adicionado com sucesso!");
    }

    public List<Aluno> listarAlunos() {
        return this.alunos;
    }
}