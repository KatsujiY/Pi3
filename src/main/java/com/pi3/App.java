package com.pi3;

import com.pi3.model.Aluno;
import com.pi3.repository.AlunoRepository;
import com.pi3.service.AlunoService;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AlunoService service = new AlunoService(new AlunoRepository());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Sistema de Cadastro de Alunos (PI3) ---");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Sair");
            System.out.print("Escolha: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Matrícula: ");
                    String id = scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Curso: ");
                    String curso = scanner.nextLine();
                    service.cadastrarAluno(id, nome, curso);
                    System.out.println("Aluno cadastrado com sucesso!");
                }
                case 2 -> {
                    List<Aluno> alunos = service.listarAlunos();
                    if (alunos.isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado.");
                    } else {
                        alunos.forEach(System.out::println);
                    }
                }
                case 3 -> {
                    System.out.println("Encerrando o sistema...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
