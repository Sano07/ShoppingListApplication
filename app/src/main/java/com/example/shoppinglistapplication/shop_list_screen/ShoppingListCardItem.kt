package com.example.shoppinglistapplication.shop_list_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.shoppinglistapplication.R
import com.example.shoppinglistapplication.ui.theme.CounterGreen
import com.example.shoppinglistapplication.ui.theme.EditYellow

@Preview(showBackground = true)
@Composable
fun ShoppingListCardItem() {
    ConstraintLayout(
        modifier = Modifier.padding(start = 3.dp, top = 18.dp, end = 3.dp)
    ) {
        // обьявление идентификаторов для лейаута
        val (card, counter, editButton, deleteButton) = createRefs()
        Card(
            modifier = Modifier
                .fillMaxWidth()
                // крепление карточки к родительскому обьекту
                .constrainAs(card) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                Text(
                    text = "List 1",
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )
                Text(
                    text = "12/12/2026",
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                )
                LinearProgressIndicator(
                    modifier = Modifier.fillMaxWidth().padding(top = 5.dp)

                )
            }

        }
        IconButton(
            onClick = {},
            modifier = Modifier.constrainAs(deleteButton) {
                top.linkTo(card.top)
                bottom.linkTo(card.top)
                end.linkTo(card.end)
            }.padding(end = 10.dp).size(30.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_delete),
                contentDescription = "delete",
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color.Red)
                    .padding(5.dp)
            )
        }
        IconButton(
            onClick = {},
            modifier = Modifier.constrainAs(editButton) {
                top.linkTo(card.top)
                bottom.linkTo(card.top)
                end.linkTo(deleteButton.start)
            }.padding(end = 7.dp).size(30.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_edit),
                contentDescription = "edit",
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .background(EditYellow)
                    .padding(5.dp)
            )
        }
        Card(
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier.constrainAs(counter) {
                top.linkTo(card.top)
                bottom.linkTo(card.top)
                end.linkTo(editButton.start)
            }.padding(end = 7.dp)
        ) {
            Text(
                modifier = Modifier
                    .background(CounterGreen)
                    .padding(top = 6.dp, bottom = 7.dp, start = 6.dp, end = 6.dp),
                text = "5/15",
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
        }
    }
}