package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult=findViewById<TextView>(R.id.textview_result)
        val tvClassificacao=findViewById<TextView>(R.id.textview_classificacao)


        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text=result.toString()

        var classificacao=""

        if(result <18.5f){
            classificacao = "ABAIXO DO PESO"
        }else if (result in 18.5f..24.9f){
            classificacao = "NORMAL"
        }else if (result in 25.0f..29.9f){
            classificacao = "ACIMA DO PESO"
        }else if (result in 30.0f..39.9f){
            classificacao = "OBESIDADE"
        }else if (result >=40.0f){
            classificacao = "OBESIDADE GRAVE"
        }
        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

    /*
* Menor que 18,5 -> Abaixo do peso
* Entre 18,5 e 24,5 -> Normal
* Entre 25,0 e 29,9 -> Acima do Peso
* Entre 30,0 e 39,9 -> Obesidade
* Acima de 40,0 -> Obesidade Grave
*/
}