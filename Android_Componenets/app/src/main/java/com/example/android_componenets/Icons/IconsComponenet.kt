package com.example.android_componenets.Componenets.Icons

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class IconsComponenet {



}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IocnSample(){

    Column {
        Row {
            Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.Green, modifier = Modifier.size(50.dp))
            Icon(Icons.Default.Settings, contentDescription = "Settings", tint = Color.Gray)
            Icon(Icons.Default.Favorite, contentDescription = "Favorite", tint = Color.Magenta)
            Icon(Icons.Default.Share, contentDescription = "Share", tint = Color.LightGray)
            Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.Cyan)
            Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.Blue)
            Icon(Icons.Default.Add, contentDescription = "Add", tint = Color.Cyan)
            Icon(Icons.Default.Delete, contentDescription = "Delete", tint = Color.Red)
            Icon(Icons.Default.Info, contentDescription = "Info", tint = Color.Red)
            Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.Blue)
        }
        //4. Icon with Clickable Behavior
        Icon(
            Icons.Default.Settings,
            contentDescription = "Settings",
            modifier = Modifier.clickable { /* Handle click */ }
        )
        //6. Icon with Circular Background
        Box(
            modifier = Modifier
                .background(Color.Gray, CircleShape)
                .padding(8.dp)
        ) {
            Icon(Icons.Default.Check, contentDescription = "Check", tint = Color.White)
        }
        //7. Icon with Custom Shape Background
        Box(
            modifier = Modifier
                .background(Color.Blue, RoundedCornerShape(8.dp))
                .padding(8.dp)
        ) {
            Icon(Icons.Default.Warning, contentDescription = "Warning", tint = Color.White)
        }
        //8. Toggle Favorite Icon (with State)
        var isFavorite by remember { mutableStateOf(false) }

        Icon(
            imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
            contentDescription = "Favorite",
            tint = if (isFavorite) Color.Red else Color.Gray,
            modifier = Modifier.clickable { isFavorite = !isFavorite }
        )
        //9. Icon in TopAppBar
        TopAppBar(
            title = { Text("My App") },
            navigationIcon = {
                Icon(Icons.Default.Menu, contentDescription = "Menu")
            }
        )

        //10. Icon in FloatingActionButton

        FloatingActionButton(onClick = { /* Do something */ }) {
            Icon(Icons.Default.Add, contentDescription = "Add")
        }
        //11. Icon in Row Layout
        Row {
            Icon(Icons.Default.Share, contentDescription = "Share")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Share")
        }
        //12. Icon in Column Layout
        Column {
            Icon(Icons.Default.Info, contentDescription = "Info")
            Spacer(modifier = Modifier.height(8.dp))
            Text("Info")
        }
        //14. Icon with Rotation
        Icon(
            Icons.Default.ArrowForward,
            contentDescription = "Forward",
            modifier = Modifier.rotate(300f)
        )
        //15. Icon with Scaling
        Icon(
            Icons.Default.ArrowDropDown,
            contentDescription = "Down Arrow",
            modifier = Modifier.scale(2f)
        )

        //16. Icon with Transparency
        Icon(
            Icons.Default.Notifications,
            contentDescription = "Notification",
            tint = Color.Black.copy(alpha = 0.8f)
        )


        //18. Icon with Shadow Effect
        Icon(
            Icons.Default.Phone,
            contentDescription = "Phone",
            modifier = Modifier.shadow(20.dp, CircleShape),
            tint = Color.Green
        )

        //19. Icon with Border and Padding
        Box(
            modifier = Modifier
                .border(1.dp, Color.Black, CircleShape)
                .padding(8.dp)
        ) {
            Icon(Icons.Default.Email, contentDescription = "Email")
        }

        //20. Icon in Custom Button
        Button(
            onClick = { /* Do something */ },
            modifier = Modifier.padding(8.dp),
            shape = RoundedCornerShape(50)
        ) {
            Icon(Icons.Default.PlayArrow, contentDescription = "Play")
            Text("Play")
        }

        //21. Icon as a Badge
        Box {
            Icon(Icons.Default.ShoppingCart, contentDescription = "Cart")
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .background(Color.Red, CircleShape)
                    .size(10.dp)
            ) {
                Text("2", color = Color.White, fontSize = 8.sp, modifier = Modifier.align(Alignment.Center))
            }
        }
        //22. Icon in TextField (Leading Icon)
        TextField(
            value = "",
            onValueChange = {},
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") }
        )
        //23. Icon in TextField (Trailing Icon)
        TextField(
            value = "",
            onValueChange = {},
            trailingIcon = { Icon(Icons.Default.Clear, contentDescription = "Clear") }
        )
        //24. Icon in a Slider Thumb
        Slider(
            value = 0.5f,
            onValueChange = {},
            thumb = {
                Icon(Icons.Default.ArrowDropDown, contentDescription = "Star")
            }
        )


    }



}


@Preview
@Composable
fun IocnSsamplePreview(){
    IocnSample()
}
