package account.model;

public class CurrentAccount  extends Account{

  private float limite;

  public CurrentAccount(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
    super(numero, agencia, tipo, titular, saldo);
    this.limite = limite;
  }

  public float getLimite() {
    return limite;
  }

  public void setLimite(float limite) {
    this.limite = limite;
  }

  @Override
  public boolean sacar(float value){
    if(this.getSaldo() + this.getLimite() < value){
      System.out.println("\n Saldo Insuficiente!");
      return false;
    }

    this.setSaldo(this.getSaldo() - value);
    return true;
  }

  public void visualizar(){
    super.visualizar();
    System.out.println("Limite de Crédito: " + this.limite);
  }
}
