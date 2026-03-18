package com.example.shoppinglistapplication.shop_list_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
            ShoppingListCardItem(list) { event ->
                viewModel.onEvent(event)
            }
        }
    }
    MainAlertDialog(viewModel)
}