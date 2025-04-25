package vn.luongvo.kmp.ecommerce.presentation.screens.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seiko.imageloader.rememberImagePainter
import ecommerce_kmp.shared.generated.resources.Res
import ecommerce_kmp.shared.generated.resources.ic_close
import ecommerce_kmp.shared.generated.resources.product_add_to_cart
import ecommerce_kmp.shared.generated.resources.product_rating
import ecommerce_kmp.shared.generated.resources.product_view
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import vn.luongvo.kmp.ecommerce.presentation.models.ProductModel
import vn.luongvo.kmp.ecommerce.presentation.theme.AppTheme.dimensions

@Composable
fun ProductScreen(
    productId: String,
    onClickBack: () -> Unit,
    viewModel: ProductViewModel = ProductViewModel(),
) {
    val state by viewModel.stateFlow.collectAsState()

    LaunchedEffect(productId) {
        viewModel.loadProduct(productId)
    }

    ProductScreenContent(
        isLoading = state.isLoading,
        error = state.error,
        product = state.product,
        onClickBack = onClickBack,
        onAddToCart = {
            // TODO add to cart
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreenContent(
    isLoading: Boolean,
    product: ProductModel?,
    error: String?,
    onClickBack: () -> Unit,
    onAddToCart: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        if (isLoading) {
            CircularProgressIndicator()
        } else if (!error.isNullOrBlank()) {
            Text(text = error)
        } else if (product != null) {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = product.title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onClickBack) {
                        Icon(
                            painter = painterResource(Res.drawable.ic_close),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }
                },
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {
                Image(
                    painter = rememberImagePainter(product.image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(dimensions.spacingSmall),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensions.spacingMedium)
                ) {
                    Column {
                        Text(
                            text = "$${product.price}",
                            style = TextStyle(
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Spacer(modifier = Modifier.height(dimensions.spacingXSmall))

                        Row(horizontalArrangement = Arrangement.spacedBy(dimensions.spacingXSmall)) {
                            Text(
                                text = product.category,
                                style = TextStyle(
                                    fontSize = 10.sp,
                                    color = Color.White,
                                ),
                                modifier = Modifier
                                    .background(color = Color.Gray, shape = RoundedCornerShape(20.dp))
                                    .padding(dimensions.spacing2XSmall)
                            )
                            Text(
                                text = stringResource(Res.string.product_rating, product.rating?.rate.toString()),
                                style = TextStyle(
                                    fontSize = 10.sp,
                                    color = Color.White,
                                ),
                                modifier = Modifier
                                    .background(color = Color.Gray, shape = RoundedCornerShape(20.dp))
                                    .padding(dimensions.spacing2XSmall)
                            )
                            Text(
                                text = stringResource(Res.string.product_view, product.rating?.count.toString()),
                                style = TextStyle(
                                    fontSize = 10.sp,
                                    color = Color.White,
                                ),
                                modifier = Modifier
                                    .background(color = Color.Gray, shape = RoundedCornerShape(20.dp))
                                    .padding(dimensions.spacing2XSmall)
                            )
                        }

                        Spacer(modifier = Modifier.height(dimensions.spacingXSmall))

                        Text(
                            text = product.description,
                        )
                    }
                }
            }

            Button(
                onClick = onAddToCart,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensions.spacingMedium)
            ) {
                Text(text = stringResource(Res.string.product_add_to_cart, "$${product.price}"))
            }
        }
    }
}
