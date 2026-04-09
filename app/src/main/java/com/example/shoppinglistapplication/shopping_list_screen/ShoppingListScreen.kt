package com.example.shoppinglistapplication.shopping_list_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shoppinglistapplication.dialog.MainAlertDialog
import com.example.shoppinglistapplication.ui.theme.White_2
import com.example.shoppinglistapplication.utils.UiEvents

@Composable
fun ShoppingListScreen(
    viewModel: ShoppingListViewModel = hiltViewModel(),
    onNavigate: (String) -> Unit
) {
    val itemsList = viewModel.list.collectAsState(initial = emptyList())

    // получение UI ивента
    LaunchedEffect(key1 = true) {
        viewModel.inUiEvent.collect{ uiEvent ->
            when(uiEvent) {
                is UiEvents.navigate -> {
                    onNavigate(uiEvent.route)
                }
                else -> {}
            }
        }
    }
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize()
            .background(White_2),
        contentPadding = PaddingValues(bottom = 50.dp),
        columns = GridCells.Fixed(2)
    ) {
        items(itemsList.value) { list ->
            UI_ShoppingListCardItem(list) { event ->
                viewModel.onEvent(event)
            }
        }
    }
    MainAlertDialog(viewModel)
    if(itemsList.value.isEmpty()) {
        Text(
            modifier = Modifier.fillMaxSize()
                .wrapContentHeight(),
            text = "Empty",
            fontSize = 25.sp,
            textAlign = TextAlign.Center
        )
    }
}