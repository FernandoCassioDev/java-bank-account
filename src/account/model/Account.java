package account.model;

public abstract class Account {
  private int numero;
  private int agencia;
  private int tipo;
  private String titular;
  private float saldo;

  public Account(int numero, int agencia, int tipo, String titular, float saldo) {
    this.numero = numero;
    this.agencia = agencia;
    this.tipo = tipo;
    this.titular = titular;
    this.saldo = saldo;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getAgencia() {
    return agencia;
  }

  public void setAgencia(int agencia) {
    this.agencia = agencia;
  }

  public int getTipo() {
    return tipo;
  }

  public void setTipo(int tipo) {
    this.tipo = tipo;
  }

  public String getTitular() {
    return titular;
  }

  public void setTitular(String titular) {
    this.titular = titular;
  }

  public float getSaldo() {
    return saldo;
  }

  public void setSaldo(float saldo) {
    this.saldo = saldo;
  }

  public boolean sacar(float value) {
    if (this.getSaldo() < value) {
      System.out.println("\nSaldo Insuficiente!");
      return false;
    }

    this.setSaldo(this.getSaldo() - value);
    return true;
  }

  public void depositar(float value) {
    this.setSaldo(this.getSaldo() + value);
  }

  public void visualizar(){
    String type = "";

    switch (this.tipo) {
      case 1:
        type = "Conta Corrente";
        break;
      case 2:
        type = "Conta Poupança";
        break;
    }

    System.out.println("\n\n************************************");
    System.out.println("Dados da Conta:");
    System.out.println("\n\n************************************");
    System.out.println("Numero da Conta: " + this.numero);
    System.out.println("Agência: " + this.agencia);
    System.out.println("Tipo da conta: " + type);
    System.out.println("Titular: " + this.titular);
    System.out.println("Saldo: " + this.saldo);
  }
}
