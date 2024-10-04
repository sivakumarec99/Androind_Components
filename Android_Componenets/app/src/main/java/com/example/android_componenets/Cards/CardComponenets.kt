package com.example.android_componenets.Componenets.Cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android_componenets.R

class CardComponenets {
}

@Composable
fun CardSample(){
     Column(modifier = Modifier.padding(16.dp)
     ){


    //simple Card
         Card (){
             Text(text = "Simple Card")
         }
    Spacer(modifier = Modifier.padding(1.dp))
    //card with text
         Card(
             shape = RoundedCornerShape(16.dp)
         ) {
             Text(text = "Rounded Card")
         }
         Spacer(modifier = Modifier.padding(1.dp))

         Card(modifier = Modifier.background(color = Color.Cyan),
         ) {
             Text(text = "Colored Card",
                 Modifier.background(Color.Transparent))
         }
         Spacer(modifier = Modifier.padding(1.dp))


         Card {
             Row(
                 modifier = Modifier.padding(16.dp),
                 horizontalArrangement = Arrangement.spacedBy(8.dp)
             ) {
                 Icon(Icons.Default.Favorite, contentDescription = null)
                 Text(text = "Card with Icon and Text")
             }
         }
         Spacer(modifier = Modifier.padding(1.dp))

         Card(
             border = BorderStroke(1.dp, Color.Black)
         ) {
             Text(text = "Outlined Card")
         }

         Spacer(modifier = Modifier.padding(1.dp))

         Card {
             Column {
                 Image(
                     painter = painterResource(id = R.drawable.ai_food_donate),
                     contentDescription = "Profile",
                     modifier = Modifier
                         .size(60.dp)
                         .clip(CircleShape)
                 )
                 Text(text = "Name")
             }
         }
         Spacer(modifier = Modifier.padding(1.dp))

         Card(
             modifier = Modifier
                 .background(
                     brush = Brush.linearGradient(
                         colors = listOf(Color.Red, Color.Blue)
                     )
                 )
         ) {
             Text(text = "Gradient Background Card")
         }
         Spacer(modifier = Modifier.padding(1.dp))

         Card(
             modifier = Modifier
                 .fillMaxWidth()
                 .height(200.dp)
         ) {
             Text(text = "Card with Constraints")
         }

         Spacer(modifier = Modifier.padding(1.dp))

         val elevated = remember { mutableStateOf(false) }
         Card(
             onClick = { elevated.value = !elevated.value
             }
         ) {
             Text(text = "Animated Card")
         }
         var expanded by remember { mutableStateOf(false) }
         Card(
             onClick = { expanded = !expanded }
         ) {
             Column {
                 Text(text = "Title")
                 if (expanded) {
                     Text(text = "Expanded content goes here")
                 }
             }
         }

         Card {
             LazyColumn {
                 items(5) { index ->
                     Text(text = "Item $index")
                 }
             }
         }

         Card {
             Image(
                 painter = painterResource(id = R.drawable.ai_food_donate),
                 contentDescription = "Rounded Image",
                 modifier = Modifier
                     .fillMaxWidth()
                     .clip(RoundedCornerShape(16.dp))
             )
         }

     }

}



@Preview
@Composable
fun CardSamplePreview(){
    CardSample()
}

@Composable
fun SwipeAbleCard(){

    Column {

        Card {
            Box {
                Image(painter = painterResource(id = R.drawable.ai_food_donate), contentDescription = "Image")
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                listOf(Color.Transparent, Color.Black)
                            )
                        )
                )
                Text(
                    text = "Overlay Text",
                    modifier = Modifier.align(Alignment.BottomStart)
                )
            }
        }

        val selected = remember { mutableStateOf(false) }
        Card(
            shape = RoundedCornerShape(if (selected.value) 0.dp else 16.dp),
            onClick = { selected.value = !selected.value }
        ) {
            Text(text = "Selectable Card")
        }

        Card(
            modifier = Modifier
                .size(100.dp)
                .padding(8.dp)
        ) {
            Text(text = "Grid Item")
        }


    }
}
@Preview
@Composable
fun SwipeAbleCardPreview(){
    SwipeAbleCard()
}
