package com.example.labex2

import android.content.Intent
import androidx.compose.ui.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.example.labex2.ui.theme.LabEx2Theme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabEx2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ActionBottons(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun ActionBottons(modifier: Modifier = Modifier,
        url:Uri = "https://georgebrown.ca".toUri(),
        phone: Uri = "tel: 5195559999".toUri(),
        location: Uri = ("geo:0,0?q="+Uri.encode("150 mill st, Guelph")).toUri()){

    val context = LocalContext.current
    var count by remember { mutableIntStateOf(0) }
    var step by remember { mutableIntStateOf(1) }

    Column(
        modifier = modifier.fillMaxWidth().padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically


        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Application Logo",
                modifier = Modifier.width(200.dp).height(100.dp)
            )


        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("$count")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically


        ) {
            Button(
                onClick = {
                    count += step
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("+")
            }

            Button(
                onClick = {
                    count -= step
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("-")
            }


        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically


        ) {
            Button(
                onClick = {
                    count = 0
                    step = 1
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = androidx.compose.ui.graphics.Color.White
                ),
                modifier = Modifier.weight(1f)
            ) {
                Text("Reset")
            }

            Button(
                onClick = {
                    step = 2
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Step")
            }


        }



    }



}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LabEx2Theme {
        ActionBottons()
    }
}