package com.example.app.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.app.data.ProductItem
import com.example.app.viewmodel.ProductIntent
import com.example.app.viewmodel.ProductViewModel

@Composable
fun ProductListItem(
    viewModel: ProductViewModel= hiltViewModel()
) {

    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.processIntent(ProductIntent.Loading)
        val productList = viewModel.getProductList()
        viewModel.processIntent(ProductIntent.ProductList(productList))
    }

    LazyColumn {
        items(state.productList.size) { index ->
            ProductItem(product = state.productList[index])
        }
    }
}
        @Composable
        fun ProductItem(product: ProductItem) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                AsyncImage(
                    modifier = Modifier.size(100.dp),
                    model = product.image,
                    contentDescription = "Product Image"
                )

                Column(
                    modifier = Modifier.weight(1f).padding(start = 10.dp, end = 10.dp)
                ) {
                    Text(
                        text = product.title,
                        style = MaterialTheme.typography.titleMedium,
                        maxLines = 2
                    )
                    Text(
                        text = "${product.price} INR",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }