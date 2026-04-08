package com.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app.ui.ProductDetailPage
import com.example.app.ui.ProductListItem
import dagger.hilt.android.AndroidEntryPoint

/**
 * MainActivity converted to Jetpack Compose.
 * Inherits from ComponentActivity for a lightweight Compose-focused entry point.
 */

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Enable edge-to-edge support for a modern look and feel
        enableEdgeToEdge()

        // 2. Set the UI content using Compose instead of setContentView(R.layout...)
        setContent {
            // 3. Apply the Material3 Theme
            MaterialTheme {
                ProductDetailPage()
            }
        }
    }
}

/**
 * Preview function to see the UI in the Android Studio Design tab without running the app.
 */
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MaterialTheme {
        //GreetingScreen("World")
    }
}
