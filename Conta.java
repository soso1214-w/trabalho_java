package br.com.banco;


public abstract class Conta {
   private int numero;
   private String titular;
   protected double saldo;


   public Conta(int numero, String titular, double saldoInicial) {
       this.numero = numero;
       this.titular = titular;
       this.saldo = saldoInicial;
   }


   public void depositar(double valor) {
       if (valor > 0) {
           saldo += valor;
           System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
       } else {
           System.out.println("Valor de depósito inválido.");
       }
   }


   public void sacar(double valor) throws SaldoInsuficienteException {
       if (valor > saldo) {
           throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque.");
       }
       saldo -= valor;
       System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
   }


   public double getSaldo() {
       return saldo;
   }


   public int getNumero() {
       return numero;
   }


   public String getTitular() {
       return titular;
   }


   // Método abstrato a ser implementado nas subclasses
   public abstract void atualizarSaldo();


   // Exibe o extrato da conta
   public void imprimirExtrato() {
       System.out.println("Extrato da Conta " + (this instanceof ContaCorrente ? "Corrente" : "Poupança") + ":");
       System.out.println("Titular: " + titular);
       System.out.println("Número: " + numero);
       System.out.println("Saldo: R$ " + saldo);
   }
}
