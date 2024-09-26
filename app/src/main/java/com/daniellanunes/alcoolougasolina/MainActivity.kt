package com.daniellanunes.alcoolougasolina

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    //Criação de Atributos
    private lateinit var textInputEtanol: TextInputLayout
    private lateinit var editEtanol: TextInputEditText

    private lateinit var textInputGasolina: TextInputLayout
    private lateinit var editGasolina: TextInputEditText

    private lateinit var btnCalcular : Button
    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Criando metodo de inicialização de componentes de interface:
        inicializarComponentesInterface()
        btnCalcular.setOnClickListener {
            calcularMelhorPreco()
        }
    }
    private fun calcularMelhorPreco() {
        val precoEtanol   = editEtanol.text.toString()
        val precoGasolina = editGasolina.text.toString()

        val resultadoValidacao = validarCampos(precoGasolina,precoEtanol)
        if (resultadoValidacao){
            val resultado = precoEtanol.toDouble() / precoGasolina.toDouble()
            if (resultado >= 0.7){
                textResultado.text = "Melhor Utilizar Gasolina"
            }else{
                textResultado.text = "Melhor Utilizar Etanol"
            }
        }
    }
    private fun validarCampos(pGasolina: String, pEtanol: String): Boolean {

        textInputEtanol.error = null
        textInputGasolina.error = null

        if(pGasolina.isEmpty()){
            textInputGasolina.error = "Digite o preço da Gasolina"
            return false
        }else if(pEtanol.isEmpty()){
            textInputEtanol.error = "Digite o preço do Etanol"
            return false
        }
        return true
    }
    private fun inicializarComponentesInterface(){

        textInputEtanol = findViewById(R.id.text_input_etanol)
        editEtanol = findViewById(R.id.edit_etanol)

        textInputGasolina = findViewById(R.id.text_input_gasolina)
        editGasolina = findViewById(R.id.edit_gasolina)

        btnCalcular = findViewById(R.id.btn_calcular)
        textResultado = findViewById(R.id.text_resultado)

    }
}