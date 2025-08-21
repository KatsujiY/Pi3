package com.pi3;

import com.pi3.model.Aluno;
import com.pi3.repository.AlunoRepository;
import com.pi3.service.AlunoService;
import org.junit.jupiter.api.*;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlunoServiceTest {

    private AlunoService service;
    private final String FILE_NAME = "alunos.dat";

    @BeforeEach
    void setup() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            file.delete();
        }
        service = new AlunoService(new AlunoRepository());
    }

    @Test
    void testCadastrarAluno() {
        service.cadastrarAluno("1", "João", "Engenharia");
        List<Aluno> alunos = service.listarAlunos();
        assertEquals(1, alunos.size());
        assertEquals("João", alunos.get(0).getNome());
    }

    @Test
    void testPersistencia() {
        service.cadastrarAluno("2", "Maria", "Medicina");

        // Recarrega em um novo serviço para validar persistência
        AlunoService novoService = new AlunoService(new AlunoRepository());
        List<Aluno> alunos = novoService.listarAlunos();

        assertEquals(1, alunos.size());
        assertEquals("Maria", alunos.get(0).getNome());
    }
}
