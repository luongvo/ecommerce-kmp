package vn.luongvo.kmp.ecommerce.presentation.screens.main.products

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seiko.imageloader.rememberImagePainter
import vn.luongvo.kmp.ecommerce.presentation.models.ProductModel
import vn.luongvo.kmp.ecommerce.presentation.theme.AppTheme.dimensions

@Composable
fun ProductsScreen(
    onProductClick: (ProductModel) -> Unit,
    viewModel: ProductsViewModel = ProductsViewModel(),
) {
    val state by viewModel.stateFlow.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadProducts()
    }

    ProductsScreenContent(
        state.isLoading,
        state.products,
        state.error,
        onProductClick = onProductClick,
    )
}

@Composable
fun ProductsScreenContent(
    isLoading: Boolean,
    products: List<ProductModel>,
    error: String?,
    onProductClick: (ProductModel) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (isLoading) {
                item {
                    CircularProgressIndicator()
                }
            } else if (!error.isNullOrBlank()) {
                item {
                    Text(text = error)
                }
            } else {
                items(products) { product ->
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(dimensions.spacingSmall),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onProductClick(product)
                            }
                            .padding(dimensions.spacingMedium)
                    ) {
                        Image(
                            painter = rememberImagePainter(product.image),
                            contentDescription = null,
                            modifier = Modifier.size(100.dp)
                        )

                        Column {
                            Text(
                                text = product.title,
                            )
                            Text(
                                text = product.category,
                                style = TextStyle(
                                    fontSize = 10.sp,
                                    color = Color.White,
                                ),
                                modifier = Modifier
                                    .background(color = Color.Gray, shape = RoundedCornerShape(20.dp))
                                    .padding(4.dp)
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "$${product.price}",
                                style = TextStyle(fontWeight = FontWeight.Bold)
                            )
                        }
                    }

                    HorizontalDivider()
                }
            }
        }
    }
}
