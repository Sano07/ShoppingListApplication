package com.example.shoppinglistapplication.shop_list_screen

import android.annotation.SuppressLint
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.shoppinglistapplication.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ShopListScreen() {
    Scaffold(
        bottomBar = {},
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_add
                    ),
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) {

    }
}