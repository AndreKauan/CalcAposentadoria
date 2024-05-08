package com.akantonelli.calcaposentadoria

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.akantonelli.calcaposentadoria.ui.theme.CalcAposentadoriaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter.createFromResource(this, R.array.spinnerGenero,android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        val txtIdade =  findViewById<EditText>(R.id.editTextIdade)
        val txtContribuicao = findViewById<EditText>(R.id.editTextContribuicao)
        val txtRetorno = findViewById<TextView>(R.id.textViewRetorno)
        val btnCalc = findViewById<Button>(R.id.btnCalcular)


        btnCalc.setOnClickListener{
            txtRetorno.text = ""
            var idade = txtIdade.text.toString().toFloat()
            var contribuicao = txtContribuicao.text.toString().toFloat()

            if (idade<contribuicao) {
                txtRetorno.text = "Voce trabalhou mais do que viveu?"
            }else{
                if (spinner.selectedItemPosition == 0) {
                    when{
                        idade < 65 -> txtRetorno.text = "Faltam ${65-idade} para solicitar aposentadoria."
                        contribuicao < 35 -> txtRetorno.append(" Faltam ${35-contribuicao} anos contribuidos")
                        idade>=65 && contribuicao>=35 -> txtRetorno.text = "APOSENTADORIA!"
                    }
                }else{
                    when{
                        idade < 65 -> txtRetorno.text = "Faltam ${62-idade} para solicitar aposentadoria."
                        contribuicao < 35 -> txtRetorno.append(" Faltam ${30-contribuicao} anos contribuidos")
                        idade>=62 && contribuicao>=30 -> txtRetorno.text = "APOSENTADORIA!"

                    }
                }
            }
        }
    }


}