package br.com.lucaslins.contador

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //Variável do contador.
    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    // Início da área de funcionamento dos botões e visor

        // Referência ao visor e botão
        val contadorTextView = findViewById<TextView>(R.id.contadorTextView)
        val aumentarButton = findViewById<Button>(R.id.aumentarButton)
        val diminuirButton = findViewById<Button>(R.id.diminuirButton)

        // Função que atualiza o texto do contador
        fun atualizarContador() {
            contadorTextView.text = contador.toString()
        }
        // Botão para aumentar o valor em um a cada clique
        aumentarButton.setOnClickListener {
            contador++
            atualizarContador()
        }

        // Botão para diminuir o valor em um a cada clique, travando em zero
        diminuirButton.setOnClickListener {
            if (contador > 0) { // Solicitado que o contador não fique negativo
                contador--
                atualizarContador()
            }
        }

        // Atualiza o contador pelos botões de diminuir e aumentar
        atualizarContador()
    }
}
