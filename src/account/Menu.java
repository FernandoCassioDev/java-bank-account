package account;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import account.controller.AccountController;
import account.model.CurrentAccount;
import account.model.SavingsAccount;
import account.util.Cores;

public class Menu {
  public static void main(String[] args) {

    AccountController accounts = new AccountController();

    try (Scanner read = new Scanner(System.in)) {

      int option, number, agency, type, birthday;
      String holder;
      float balance, limit;

      while (true) {
        System.out
            .println(
                Cores.TEXT_YELLOW_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "\n\n***************************************");
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
        System.out.println("Entre com a opção desejada: ");
        System.out.println("                                       " + Cores.TEXT_RESET);

        try {
          option = read.nextInt();
        } catch (InputMismatchException e) {
          System.out.println("\nDigite valores inteiros!");
          read.nextLine();
          option = 0;
        }

        if (option == 9) {
          System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
          read.close();
          about();
          System.exit(0);
        }

        switch (option) {
          case 1:
            System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta\n\n");

            System.out.println("Digite o número da agência: ");
            agency = read.nextInt();

            System.out.println("Digite o nome do titular: ");
            read.skip("\\R");
            holder = read.nextLine();

            do {
              System.out.println("Digite o tipo da conta (1 - CC ou 2 - CP): ");
              type = read.nextInt();
            } while (type < 1 || type > 2);

            System.out.println("Digite o saldo da Conta (R$): ");
            balance = read.nextFloat();

            switch (type) {
              case 1:
                System.out.println("Digite o limite de Crédito (R$): ");
                limit = read.nextFloat();
                accounts.register(new CurrentAccount(accounts.generateNumber(), agency, type, holder, balance, limit));
                break;

              case 2:
                System.out.println("Digite o dia do aniversário da conta: ");
                birthday = read.nextInt();
                accounts
                    .register(new SavingsAccount(accounts.generateNumber(), agency, type, holder, balance, birthday));
                break;
            }
            keyPress();
            break;
          case 2:
            System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas\n\n");
            accounts.listAll();
            keyPress();
            break;
          case 3:
            System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta - por número\n\n");

            System.out.println("Digite o número da conta deseja consultar: ");
            number = read.nextInt();

            accounts.findByNumber(number);

            keyPress();
            break;
          case 4:
            System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da Conta\n\n");

            System.out.println("Digite o número da conta que deseja atualizar: ");
            number = read.nextInt();

            var findAccount = accounts.findInCollection(number);

            if (findAccount != null) {
              System.out.println("Digite o novo número da agência: ");
              agency = read.nextInt();

              System.out.println("Digite o novo nome do titular: ");
              read.skip("\\R");
              holder = read.nextLine();

              do {
                System.out.println("Digite o novo tipo da conta (1 - CC ou 2 - CP): ");
                type = read.nextInt();
              } while (type < 1 || type > 2);

              System.out.println("Digite o novo saldo da Conta (R$): ");
              balance = read.nextFloat();

              switch (type) {
                case 1:
                  System.out.println("Digite o novo limite de Crédito (R$): ");
                  limit = read.nextFloat();
                  accounts.update(new CurrentAccount(number, agency, type, holder, balance, limit));
                  break;

                case 2:
                  System.out.println("Digite o novo dia do aniversário da conta: ");
                  birthday = read.nextInt();
                  accounts.update(new SavingsAccount(number, agency, type, holder, balance, birthday));
                  ;
                  break;
                default:
                  System.out.println("Tipo de conta inválido!");
                  break;
              }
            } else
              System.out.println("A conta não foi encontrada!");

            keyPress();
            break;
          case 5:
            System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n\n");

            keyPress();
            break;
          case 6:
            System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n\n");

            keyPress();
            break;
          case 7:
            System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n\n");

            keyPress();
            break;
          case 8:
            System.out.println(Cores.TEXT_WHITE_BOLD + "Tranferência entre Contas\n\n");

            keyPress();
            break;
          default:
            System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida\n");

            keyPress();
            break;
        }
      }
    }
  }

  public static void keyPress() {
    try {
      System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
      System.in.read();
    } catch (IOException e) {
      System.out.println("Você pressionou uma tecla diferente de enter!");
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
