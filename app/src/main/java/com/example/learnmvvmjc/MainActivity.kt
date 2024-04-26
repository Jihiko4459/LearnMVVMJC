package com.example.learnmvvmjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learnmvvmjc.ui.theme.LearnMVVMJCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnMVVMJCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Counter()
                }
            }
        }
    }
}
//функция без использования MVVM
//@Composable
//fun Counter(){
//    var count by remember {
//        mutableStateOf(0)
//    }
//
//    Column {
//        Button(onClick = { count++ }) {
//            Text(text = "Click me")
//        }
//
//        Text(text = "Counter Value: $count")
//    }
//}


//функция с mvvm
@Composable
fun Counter(myViewModel: MyViewModel= viewModel()){


    Column {
        Button(onClick = { myViewModel.incrementCoounter() }) {
            Text(text = "Click me")
        }

        Text(text = "Counter Value: ${myViewModel.count}")
    }
}