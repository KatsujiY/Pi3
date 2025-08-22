package com.pi3;

import com.pi3.service.AlunoService;
import com.pi3.repository.AlunoRepository;
import org.junit.jupiter.api.*;

import java.io.File;

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
    void testValidarMatriculaValida() {
        assertTrue(service.validarMatricula("123456"));
    }

    @Test
    void testValidarMatriculaInvalida() {
        assertFalse(service.validarMatricula("123"));     // Muito curta
        assertFalse(service.validarMatricula("abcdef"));  // Não numérica
        assertFalse(service.validarMatricula("1234567")); // Muito longa
    }

    @Test
    void testCadastrarAlunoValido() {
        service.cadastrarAluno("654321", "Ana", "Direito");
        assertEquals(1, service.listarAlunos().size());
    }

    @Test
    void testCadastrarAlunoInvalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.cadastrarAluno("abc123", "Pedro", "História");
        });
        assertEquals("Matrícula inválida! Deve conter 6 dígitos numéricos.", exception.getMessage());
    }
}
