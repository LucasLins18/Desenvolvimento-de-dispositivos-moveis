import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    var saldo = 0.0
    var executando = true

    while (executando) {
        println("\n=== MENU ===")
        println("1. Depositar")
        println("2. Sacar")
        println("3. Consultar o  Saldo")
        println("4. Sair")
        print("Escolha uma opção: ")

        when (scanner.nextInt()) {
            1 -> {
                print("Digite o valor para depósito: ")
                val valor = scanner.nextDouble()
                if (valor > 0) {
                    saldo += valor
                    println("Depósito de R$${"%.2f".format(valor)} realizado com sucesso!")
                } else {
                    println("Valor inválido para depósito!")
                }
            }
            2 -> {
                print("Digite o valor para saque: ")
                val valor = scanner.nextDouble()
                if (valor > 0) {
                    if (valor <= saldo) {
                        saldo -= valor
                        println("Saque de R$${"%.2f".format(valor)} realizado com sucesso!")
                    } else {
                        println("Saldo insuficiente!")
                    }
                } else {
                    println("Valor inválido para saque!")
                }
            }
            3 -> {
                println("Saldo atual: R$${"%.2f".format(saldo)}")
            }
            4 -> {
                println("Obrigado por usar nosso sistema bancário!")
                executando = false
            }
            else -> {
                println("Opção inválida! Tente novamente.")
            }
        }
    }
    scanner.close()
}
