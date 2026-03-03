package com.example.shoppinglistapplication.shop_list_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.shoppinglistapplication.R
import com.example.shoppinglistapplication.nav_line.BottomNavLine
import com.example.shoppinglistapplication.ui.theme.Orange

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ShopListScreen() {
    Scaffold(
        bottomBar = {
            BottomNavLine()
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                containerColor = Orange,
                shape = RoundedCornerShape(50.dp)
            ) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_add
                    ),
                    contentDescription = null,
                    tint = Color.Black,

                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
    ) { paddingValue ->
    }
}