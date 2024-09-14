package account;

import java.util.Scanner;

import account.model.Account;
import account.model.CurrentAccount;
import account.model.SavingsAccount;
import account.util.Cores;

public class Menu {
  public static void main(String[] args) {

    //Teste conta
    Account c1 = new Account(1, 123, 1, "joe hippie", 100000);
    c1.visualizar();
    c1.sacar(50000);
    c1.visualizar();
    c1.depositar(50000);
    c1.visualizar();

    //Teste conta poupança
    SavingsAccount cp1 = new SavingsAccount(1, 123, 2, "john doe", 100, 10);
    cp1.visualizar();
    cp1.sacar(200);
    cp1.visualizar();
    cp1.depositar(500);
    cp1.visualizar();

    //Teste conta corrente
    CurrentAccount cc1 = new CurrentAccount(1, 123, 1, "joao da silva", 10, 500);
    cc1.visualizar();
    cc1.sacar(50);
    cc1.visualizar();
    cc1.depositar(50);
    cc1.visualizar();

    try (Scanner read = new Scanner(System.in)) {

      int option;

      while (true) {
        System.out
            .println(Cores.TEXT_YELLOW_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "\n\n***************************************");
        System.out.println("                                       ");
        System.out.println("        BANCO DO BRAZIL COM Z          ");
        System.out.println("                                       ");
        System.out.println("***************************************");
        System.out.println("                                       ");
        System.out.println("         1 - Criar Conta               ");
        System.out.println("         2 - Listar todas as Contas    ");
        System.out.println("         3 - Buscar Conta por Numero   ");
        System.out.println("         4 - Atualizar dados da Conta  ");
        System.out.println("         5 - Apagar Conta              ");
        System.out.println("         6 - Sacar                     ");
        System.out.println("         7 - Depositar                 ");
        System.out.println("         8 - Transferir valores entre Contas    ");
        System.out.println("         9 - Sair                      ");
        System.out.println("                                       ");
        System.out.println("***************************************");
        System.out.println("Entre com a opção desejada:                      ");
        System.out.println("                                       ");

        option = read.nextInt();

        if (option == 9) {
          System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
          read.close();
          about();
          System.exit(0);
        }

        switch (option) {
          case 1:
            System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta\n\n");
            break;
          case 2:
            System.out.println(Cores.TEXT_WHITE_BOLD +"Listar todas as Contas\n\n");
            break;
          case 3:
            System.out.println(Cores.TEXT_WHITE_BOLD +"Consultar dados da Conta - por número\n\n");
            break;
          case 4:
            System.out.println(Cores.TEXT_WHITE_BOLD +"Atualizar dados da Conta\n\n");
            break;
          case 5:
            System.out.println(Cores.TEXT_WHITE_BOLD +"Apagar a Conta\n\n");
            break;
          case 6:
            System.out.println(Cores.TEXT_WHITE_BOLD +"Saque\n\n");
            break;
          case 7:
            System.out.println(Cores.TEXT_WHITE_BOLD +"Depósito\n\n");
            break;
          case 8:
            System.out.println(Cores.TEXT_WHITE_BOLD +"Tranferência entre Contas\n\n");
            break;
          default:
            System.out.println(Cores.TEXT_RED_BOLD +"\nOpção Inválida\n");
            break;
        }
      }
    }
  }

  public static void about() {
    System.out.println("\n***************************************");
    System.out.println("Projeto Desenvolvido por: Fernando Cassio");
    System.out.println("fernandocassiodev@gmail.com");
    System.out.println("github.com/fernandocassiodev");
    System.out.println("\n***************************************");
  }
}
