package account.controller;

import account.model.Account;
import account.repository.AccountRepository;

import java.util.ArrayList;

public class AccountController implements AccountRepository {

  private ArrayList<Account> listAccounts = new ArrayList<Account>();
  int number = 0;

  @Override
  public void findByNumber(int number) {
    var account = findInCollection(number);

    if (account != null)
      account.visualizar();
    else
      System.out.println("A conta número: " + number + " não foi encontrada!");

  }

  @Override
  public void listAll() {
    for (var account : listAccounts) {
      account.visualizar();
    }
  }

  @Override
  public void register(Account account) {
    listAccounts.add(account);
    System.out.println("\nA conta número: " + account.getNumero() + " foi criada com sucesso!");
  }

  @Override
  public void update(Account account) {
    var findAccount = findInCollection(account.getNumero());

    if (findAccount != null) {
      listAccounts.set(listAccounts.indexOf(findAccount), account);
      System.out.println("\nA conta número: " + account.getNumero() + " foi atualizada com sucesso!");
    } else
      System.out.println("\nA Conta número: " + account.getNumero() + " não foi encontrada!");
  }

  @Override
  public void delete(int number) {
    var account = findInCollection(number);

    if (account != null) {
      if (listAccounts.remove(account) == true)
        System.out.println("\nA Conta número: " + number + " foi apagada com sucesso!");
    } else
      System.out.println("\nA conta número: " + number + " não foi encontrada");
  }

  @Override
  public void withdraw(int number, float value) {
    var account = findInCollection(number);

    if (account != null) {
      if (account.sacar(value) == true) {
        System.out.println("\nO saque na conta número: " + number + " foi realizado com sucesso!");
      }
    } else
      System.out.println("\nA conta número: " + number + " não foi encontrada!");
  }

  @Override
  public void deposit(int number, float value) {
    var account = findInCollection(number);

    if (account != null) {
      account.depositar(value);
      System.out.println("\nO depósito na conta número: "+ number + " foi realizado com sucesso!");
    }else
      System.out.println("\nA conta número: "+ number+ " não foi encontrada!");
  }

  @Override
  public void transfer(int numberOrigin, int numberDestiny, float value) {
    var originAccount = findInCollection(numberOrigin);
    var destinyAccount = findInCollection(numberDestiny);

    if(originAccount != null && destinyAccount != null){
      if (originAccount.sacar(value) == true) {
        destinyAccount.depositar(value);
        System.out.println("\nA transfêrencia foi realizada com sucesso!");
      }
    }else
      System.out.println("\nA conta de origem e/ou destino não foram encontradas!");
  }

  public int generateNumber() {
    return ++number;
  }

  public Account findInCollection(int number) {
    for (var account : listAccounts) {
      if (account.getNumero() == number) {
        return account;
      }
    }
    return null;
  }

}
