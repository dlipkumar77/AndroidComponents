package com.example.androidcomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcomponents.ui.theme.AndroidComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            AndroidComponentsTheme {
                //Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Components(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    Components(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
//fun Components(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

fun Components(modifier: Modifier = Modifier) {

    val myButtonBackGroundColor = remember {
        mutableStateOf(Color.Red)
    }
    val myButtonText = remember {
        mutableStateOf("Do your magic")
    }
    val myButtonTextColor = remember {
        mutableStateOf(Color.White)
    }
    val myText = remember {
        mutableStateOf("Hello World")
    }
    val myTextColor = remember {
        mutableStateOf(Color.Black)
    }
    val myButtonStatus = remember {
        mutableStateOf(true)
    }
    val valueOnTextField = remember {
        mutableStateOf("")
    }
    val userInput = remember {
        mutableStateOf("Result:")
    }
    val myImage = remember {
        mutableStateOf(R.drawable.accenture)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id =myImage.value),
            contentDescription = "accenture",
            modifier = Modifier.size(300.dp),
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center
        )
        Spacer(modifier = Modifier.padding(30.dp))

        if (myButtonStatus.value) {
            Text(
                text = myText.value,
                color = myTextColor.value,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(Color.Red)
                    .padding(10.dp)
            )
        }



        Spacer(modifier = Modifier.padding(30.dp))

        Button(
            onClick = {

                if (myButtonStatus.value) {
                    myButtonBackGroundColor.value = Color.Black
                    myButtonText.value = "Compose is fun"
                    myButtonTextColor.value = Color.Red
                    myText.value = "Hello Compose"
                    myTextColor.value = Color.White
                    myImage.value = R.drawable.second_image

                    myButtonStatus.value = false
                } else {
                    myButtonBackGroundColor.value = Color.Red
                    myButtonText.value = "Do your magic"
                    myButtonTextColor.value = Color.White
                    myText.value = "Hello World"
                    myTextColor.value = Color.Black
                    myImage.value = R.drawable.accenture

                    myButtonStatus.value = true
                }

                userInput.value = valueOnTextField.value
                valueOnTextField.value = ""

            },
            modifier = Modifier.size(250.dp, 60.dp),
            //colors = ButtonDefaults.buttonColors(Color.Red),
            colors = ButtonDefaults.buttonColors(myButtonBackGroundColor.value),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(2.dp, Color.Black)
        ) {
            Text(
                text = myButtonText.value,
                color = myButtonTextColor.value,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )

        }

        Spacer(modifier = Modifier.padding(30.dp))

        TextField(
            value = valueOnTextField.value,
            onValueChange = {
                valueOnTextField.value = it

            },
            //label = { Text(text = "Enter your name", color = Color.White) },
            label = { Text(text = "Enter your name") },
            modifier = Modifier.width(300.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Green,
                unfocusedTextColor = Color.Red,
                focusedContainerColor = Color.Yellow,
                unfocusedContainerColor = Color.White,

                ),
            textStyle = TextStyle.Default.copy(fontSize = 20.sp),
            maxLines = 4,
            //keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            //visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.padding(30.dp))
        Text(
            text = userInput.value,
            color = myTextColor.value,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Red)
                .padding(10.dp)
        )

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidComponentsTheme {
//        Components("Android")
        Components()
    }


}