package br.com.banco;


public class ContaCorrente extends Conta implements OperacoesBancarias {
   private static final double TAXA_OPERACAO = 0.005; // 0.5% de taxa por saque


   public ContaCorrente(int numero, String titular, double saldoInicial) {
       super(numero, titular, saldoInicial);
   }


   @Override
   public void atualizarSaldo() {
       saldo -= saldo * TAXA_OPERACAO;  // Deduz a taxa de operação
       System.out.println("Saldo atualizado com a taxa de operação de 0.5%.");
   }


   @Override
   public void transferir(Conta destino, double valor) throws SaldoInsuficienteException {
       if (valor > saldo) {
           throw new SaldoInsuficienteException("Saldo insuficiente para transferir.");
       }
       saldo -= valor;
       destino.depositar(valor);  // Deposita na conta destino
       System.out.println("Transferência de R$ " + valor + " realizada com sucesso.");
   }


   @Override
   public void imprimirExtrato() {
       System.out.println("** Extrato Conta Corrente **");
       super.imprimirExtrato();
   }
}
