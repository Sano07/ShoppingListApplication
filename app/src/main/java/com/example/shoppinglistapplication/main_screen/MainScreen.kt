package com.example.shoppinglistapplication.main_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.shoppinglistapplication.R
import com.example.shoppinglistapplication.dialog.MainAlertDialog
import com.example.shoppinglistapplication.navigation.NavigationGraph
import com.example.shoppinglistapplication.shop_list_screen.ShoppingListViewModel
import com.example.shoppinglistapplication.ui.theme.Orange

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ShopListScreen(
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    val navController = rememberNavController()

    Box(modifier = Modifier.fillMaxSize()) {

        Scaffold(
            bottomBar = { BottomNavLine(navController) }
        ) { padding ->
            Box(modifier = Modifier.padding(padding)) {
                NavigationGraph(navController)
                MainAlertDialog(viewModel)
            }
        }
        FloatingActionButton(
            onClick = {
                viewModel.onEvent(MainScreenEvent.OnShowEditDialog)
            },
            modifier = Modifier
                // реализация наезда кнопки на bottomBar , в материал3
                .align(Alignment.BottomCenter)
                .offset(y = (-28).dp),
            containerColor = Orange,
            contentColor = Color.Black,
            shape = RoundedCornerShape(50.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = null
            )
        }
    }
}