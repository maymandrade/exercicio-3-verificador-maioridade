package com.example.exercicio3verificadormaioridade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercicio3verificadormaioridade.ui.theme.Exercicio3VerificadorMaioridadeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            Exercicio3VerificadorMaioridadeTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    Maioridade(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Maioridade(
    modifier: Modifier = Modifier
) {

    val corFundo = Color(0xFFF9F8FD)

    var idade by remember {
        mutableStateOf(0)
    }

    val maioridade = if (idade >= 18) {
        "MAIOR"
    } else {
        "MENOR"
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(corFundo),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Texto principal
        Text(
            text = "Qual é a sua idade",
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF4D58AA),
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(4.dp)
        )

        // Texto secundário
        Text(
            text = "Aperte os botões para informar a sua idade",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Black,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        // Idade
        Text(
            text = idade.toString(),
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF4D58AA),
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            // Botão menos
            Button(
                onClick = {
                    if (idade > 0) {
                        idade--
                    }
                },

                modifier = Modifier.size(60.dp),

                shape = RoundedCornerShape(5.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4D58AA)
                )
            ) {

                Text(
                    text = "-",
                    fontSize = 24.sp,
                    color = Color.White
                )
            }

            Spacer(
                modifier = Modifier.width(15.dp)
            )

            // Botão mais
            Button(
                onClick = {
                    if (idade < 180) {
                        idade++
                    }
                },

                modifier = Modifier.size(60.dp),

                shape = RoundedCornerShape(5.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4D58AA)
                )
            ) {

                Text(
                    text = "+",
                    fontSize = 24.sp,
                    color = Color.White
                )
            }
        }

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Text(
            text = "Você é $maioridade de idade",
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF4D58AA),
            textAlign = TextAlign.Center
        )
    }
}