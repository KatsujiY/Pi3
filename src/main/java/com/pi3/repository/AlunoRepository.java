package com.pi3.repository;

import com.pi3.model.Aluno;
import com.pi3.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class AlunoRepository implements IRepository<Aluno> {

    private final String FILE_NAME = "alunos.dat";

    @Override
    public void salvar(List<Aluno> lista) {
        FileUtil.salvarArquivo(lista, FILE_NAME);
    }

    @Override
    public List<Aluno> carregar() {
        List<Aluno> alunos = FileUtil.carregarArquivo(FILE_NAME);
        return alunos != null ? alunos : new ArrayList<>();
    }
}
