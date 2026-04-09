package com.example.shoppinglistapplication.added_item_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shoppinglistapplication.R
import com.example.shoppinglistapplication.dialog.DialogController
import com.example.shoppinglistapplication.dialog.MainAlertDialog
import com.example.shoppinglistapplication.ui.theme.Orange
import com.example.shoppinglistapplication.ui.theme.White_2
import com.example.shoppinglistapplication.utils.UiEvents

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddItemScreen(
    viewModel: AddedItemViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val itemsList = viewModel.itemsList?.collectAsState(
        initial = emptyList()
    )

    // если нет необходимости указывать все события , то можно прописать else -> {}
    LaunchedEffect(key1 = true) {
        viewModel.inUiEvent.collect{ event ->
            when(event) {
                is UiEvents.showSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        event.exception
                    )
                }
                else -> {}
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier
                .padding(top = 50.dp)
                .background(White_2)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(
                        modifier = Modifier.weight(1f),
                        value = viewModel.itemText.value,
                        onValueChange = {
                            viewModel.onEvent(AddedItemScreenUIEvent.OnTextChange(it))
                        },
                        label = {
                            Text(
                                text = "New item:",
                                fontSize = 12.sp
                            )
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        textStyle = TextStyle(
                            fontSize = 16.sp,
                            color = Color.Black
                        ),
                        singleLine = true
                    )
                    IconButton(
                        onClick = {
                            viewModel.onEvent(AddedItemScreenUIEvent.OnItemSave)
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_add),
                            contentDescription = ""
                        )
                    }
                }
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp, start = 5.dp, end = 5.dp)
            ) {
                if (itemsList != null) {
                    items(itemsList.value) {
                        UI_AddedScreenItemCard(
                            item = it,
                            onEvent = { event ->
                                viewModel.onEvent(event)
                            }
                        )
                    }
                }
            }
        }
        MainAlertDialog(viewModel)
        if(itemsList?.value?.isEmpty() == true) {
            Text(
                modifier = Modifier.fillMaxSize()
                    .wrapContentHeight(),
                text = "Empty",
                fontSize = 25.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}