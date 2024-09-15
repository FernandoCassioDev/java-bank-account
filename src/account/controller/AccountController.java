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
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public void withdraw(int number, float value) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'withdraw'");
  }

  @Override
  public void deposit(int number, float value) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deposit'");
  }

  @Override
  public void transfer(int numberOrigin, int numberDestiny, float value) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'transfer'");
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
