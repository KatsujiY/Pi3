package com.meuprojeto;

import com.meuprojeto.model.Aluno;
import com.meuprojeto.service.AlunoService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AlunoService alunoService = new AlunoService();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n--- Menu de Gerenciamento de Alunos ---");
            System.out.println("1. Cadastrar Novo Aluno");
            System.out.println("2. Listar Alunos Cadastrados");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.print("Digite a matrícula: ");
                        int matricula = Integer.parseInt(scanner.nextLine());
                        System.out.print("Digite o nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o curso: ");
                        String curso = scanner.nextLine();
                        alunoService.adicionarAluno(matricula, nome, curso);
                        break;
                    case 2:
                        System.out.println("\n--- Lista de Alunos ---");
                        for (Aluno aluno : alunoService.listarAlunos()) {
                            System.out.println(aluno);
                        }
                        break;
                    case 3:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
            }
        } while (opcao != 3);

        scanner.close();
    }
}