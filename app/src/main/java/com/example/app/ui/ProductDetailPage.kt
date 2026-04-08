package com.example.app.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.app.viewmodel.ProductIntent
import com.example.app.viewmodel.ProductViewModel

@Composable
fun ProductDetailPage (
    viewModel: ProductViewModel= hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val product = state.selectedProduct

    LaunchedEffect(Unit) {
        viewModel.processIntent(ProductIntent.Loading)
        val productDetail = viewModel.getProductDetail(1)
        viewModel.processIntent(ProductIntent.ProductDetail(productDetail))
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            model = product?.image?:"",
            contentDescription = "Product Image"
        )

        Text(
            text = product?.title?:"",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 10.dp)
        )
        Text(
            text = "${product?.price?:0} INR",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}