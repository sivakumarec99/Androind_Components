package com.example.android_componenets.Componenets.Button

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_componenets.R
import kotlinx.coroutines.delay


//1. Basic Button with Text
@Composable
fun BasicButton() {
    Button(
        onClick = {
            print("clicked Buttun")
        }
    ) {
        Text("Click Me")
    }
}
@Preview
@Composable
fun BasicButtonPreview() {
    BasicButton()
}
//2. Button with Icon and Text
@Composable
fun BasicButtonWithICon() {
    Button(
        onClick = { /* Handle Click */ }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Favorite, contentDescription = "Favorite")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Like")
        }
    }

}
@Preview
@Composable
fun BasicButtonWithIConPreview() {
    BasicButtonWithICon()
}

//3. Outlined
@Composable
fun OutlineButton(){
    OutlinedButton(
        onClick = { /* Handle Click */ }
    ) {
        Text("Outlined Button")
    }
}
@Preview
@Composable
fun OutlineButtonPreview() {
    OutlineButton()
}

//4. Button with Custom Shape and Colors

@Composable
fun CustomeShapeadColor(){
    Button(
        onClick = {
            print("Clicked Text")
        },
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(Color.Green)
    ) {
        Text("Custom Button", color = Color.White)
    }

}
@Preview
@Composable
fun CustomeShapeadColorPreview() {
    CustomeShapeadColor()
}

//5. Elevated Button
@Composable
fun ElavatedButton(){
    Button(
        onClick = { /* Handle Click */ },
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 20.dp)
    ) {
        Text("Elevated Button")
    }

}
@Preview
@Composable
fun ElavatedButtonPreview() {
    ElavatedButton()
}

//6. Button with Gradient Background

@Composable
fun ButtonWithGradient(){
    Button(
        onClick = { /* Handle Click */ },
        modifier = Modifier
            .background(Brush.horizontalGradient(listOf(Color.Cyan, Color.Magenta)))
    ) {
        Text("Gradient Button")
    }

}
@Preview
@Composable
fun ButtonWithGradientPreview() {
    ButtonWithGradient()
}
//
////7. Button with Image Background
//@Composable
//fun BackgroundImage(){
//
//    Button(
//        onClick = {
//            print("Na ana ana ana ana na a")
//        },
//        contentPadding = PaddingValues(0.dp)
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//
//        ) {
//            Text("Image Button", color = Color.White, modifier = Modifier.align(Alignment.Center))
//        }
//    }
//
//}
//@Preview
//@Composable
//fun BackgroundImagePreview() {
//    BackgroundImage()
//}

//8. IconButton
@Composable
fun IconButtonSample(){
    IconButton(
        onClick = {
            print("Meeage for user")
        }
    ) {
        Icon(Icons.Default.Settings, contentDescription = "Settings")
    }
}
@Preview
@Composable
fun IconButtonSamplePreview() {
    IconButtonSample()
}
//9. Custom Content Button

@Composable
fun CustomContentButton(){
    Button(
        onClick = { /* Handle Click */ }
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(Icons.Default.ShoppingCart, contentDescription = "Cart")
            Text("Shop Now")
        }
    }

}
//@Preview
//@Composable
//fun CustomContentButtonPreview() {
//    CustomContentButton()
//}
//
////1. Button with Debounce (Prevent Multiple Clicks)
//
//@Composable
//fun DebouncedButton(
//    onClick: () -> Unit,
//    delayInMillis: Long = 500L,
//    content: @Composable () -> Unit
//) {
//    var enabled by remember { mutableStateOf(true) }
//
//    Button(
//        onClick = {
//            if (enabled) {
//                onClick()
//                enabled = false
//                LaunchedEffect(Unit) {
//                    delay(delayInMillis)
//                    enabled = true
//                }
//            }
//        },
//        enabled = enabled
//    ) {
//        content()
//    }
//}
//@Preview
//@Composable
//fun DebouncedButtonPreview() {
//    DebouncedButton(
//        onClick = {
//            print("Button Clicked")
//        }
//        ) {
//        Text("Debounced Button")
//    }
//}

//2. Animated Button with Scale on Click
@Composable
fun AnimatedButton(
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    var isPressed by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(if (isPressed) 0.1f else 1f)

    Button(
        onClick = {
            isPressed = true
            onClick()
            isPressed = false
        },
        modifier = Modifier.scale(scale)
    ) {
        content()
    }
}
@Preview
@Composable
fun AnimatedButtonPreview() {
    AnimatedButton(
        onClick = {
            print("Button Clicked")
        }
    ){
       Text(text = "Button")
    }
}

//3. Button with Ripple Effect Customization

//@Composable
//fun ButtonWithRipple() {
//    Button(
//        onClick = { /* Handle Click */ },
//        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
//        interactionSource = remember { MutableInteractionSource() }.also {
//            it.collectIsPressedAsState().value
//        },
//        contentPadding = PaddingValues()
//    ) {
//        Box(
//            modifier = Modifier
//                .background(Color.Red, shape = CircleShape)
//                .clickable(
//                    onClick = { /* Handle Click */ },
//                    indication = rememberRipple(color = Color.Yellow, radius = 40.dp),
//                    interactionSource = remember { MutableInteractionSource() }
//                )
//                .padding(16.dp)
//        ) {
//            Text("Ripple Effect Button")
//        }
//    }
//
//}
//@Preview
//@Composable
//fun ButtonWithRipplePreview() {
//    ButtonWithRipple()
//}

//4. Button with Loading Indicator (Progress Button)

@Composable
fun LoadingButton(
    isLoading: Boolean,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        enabled = !isLoading
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(16.dp),
                color = Color.White,
                strokeWidth = 2.dp
            )
        } else {
            content()
        }
    }
}

@Preview
@Composable
fun LoadingButtonPreview() {
    Column {
        var isLoading by remember { mutableStateOf(false) }
        LoadingButton(
            isLoading = isLoading,
            onClick = {
                isLoading = true
                // Simulate loading
            }
        ){
            Text("Load")
        }
        Button(
            onClick = {
                isLoading = false
            }
        ) {
            Text("Stop")
        }
    }

}
//5. Custom Button with Gradient Text

@Composable
fun GradientTextButton(
    onClick: () -> Unit,
    text: String
) {
    Button(onClick = onClick) {
        Text(
            text = text,
            style = TextStyle(
                brush = Brush.horizontalGradient(
                    listOf(Color.Cyan, Color.Magenta)
                ),
                fontSize = 16.sp
            )
        )
    }
}

@Preview
@Composable
fun GradientTextButtonPreview() {
    GradientTextButton(
        onClick = { /* Handle Click */ },
        text = "Gradient Text Button"
    )
}

//6. Button with Corner Badge (Notification Count)
@Composable
fun BadgeButton(
    onClick: () -> Unit,
    badgeCount: Int,
    content: @Composable () -> Unit
) {
    Box {
        Button(onClick = onClick) {
            content()
        }
        if (badgeCount > 0) {
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .background(Color.Red, CircleShape)
                    .align(Alignment.TopEnd),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = badgeCount.toString(),
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
        }
    }
}
@Preview
@Composable
fun BadgeButtonPreview() {
    BadgeButton(
        onClick = { /* Handle Click */ },
        badgeCount = 5
    ) {
        Text(text = "Badge Button")
    }
}

////7. Advanced Button with Custom Click Feedback
//@Composable
//fun FeedbackButton(
//    initialColor: Color,
//    clickedColor: Color,
//    onClick: () -> Unit,
//    content: @Composable () -> Unit
//) {
//    var buttonColor by remember { mutableStateOf(initialColor) }
//
//    Button(
//        onClick = {
//            buttonColor = clickedColor
//            onClick()
//            buttonColor = initialColor
//        },
//        colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor)
//    ) {
//        content()
//    }
//}

//8. Button with Long Press Gesture

@Composable
fun LongPressButton(
    onClick: () -> Unit,
    onLongPress: () -> Unit,
    content: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.pointerInput(Unit) {
            detectTapGestures(
                onLongPress = {
                    onLongPress()
                }
            )
        }
    ) {
        content()
    }
}

@Preview
@Composable
fun LongPressButtonPreview() {
    LongPressButton(
        onClick = {
            print("Click Event")
        },
        onLongPress = {
            print("Long press action ")
        }
    ) {
        Icon(Icons.Default.Settings, contentDescription = "Settings")
    }
}
//9. Animated Gradient Button
@Composable
fun AnimatedGradientButton(
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition()
    val gradientOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(animation = tween(3000)), label = ""
    )

    val gradientBrush = Brush.linearGradient(
        colors = listOf(Color.Blue, Color.Red, Color.Green),
        start = Offset(gradientOffset * 200, gradientOffset * 200),
        end = Offset((1f - gradientOffset) * 200, (1f - gradientOffset) * 200)
    )

    Button(
        onClick = onClick,
        modifier = Modifier.background(gradientBrush)
    ) {
        content()
    }
}

@Preview
@Composable
fun AnimatedGradientButtonPreview() {
    AnimatedGradientButton(
        onClick = {
            print("Button Clicked")
        }
    ) {

    }
}

//10. Stateful Button with Toggle Behavior

//@Composable
//fun ToggleButton(
//    initialState: Boolean = false,
//    onStateChange: (Boolean) -> Unit
//) {
//    var isToggled by remember { mutableStateOf(initialState) }
//
//    Button(
//        onClick = {
//            isToggled = !isToggled
//            onStateChange(isToggled)
//        },
//        colors = ButtonDefaults.buttonColors(
//            backgroundColor = if (isToggled) Color.Green else Color.Gray
//        )
//    ) {
//        Text(text = if (isToggled) "ON" else "OFF", color = Color.White)
//    }
//}


//11. Multi-State Button
enum class ButtonState {
    Idle, Loading, Success, Error
}

@Composable
fun MultiStateButton(
    state: ButtonState,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        enabled = state != ButtonState.Loading
    ) {
        when (state) {
            ButtonState.Idle -> Text("Submit")
            ButtonState.Loading -> CircularProgressIndicator(modifier = Modifier.size(16.dp))
            ButtonState.Success -> Text("Success")
            ButtonState.Error -> Text("Error", color = Color.Red)
        }
    }
}
@Preview
@Composable
fun MultiStateButtonFuntion(){
    MultiStateButton(
        state = ButtonState.Idle,
        onClick = {
            print("Button Clicked")
        }
    )
}

//12. Button with Animated Gradient Border
@Composable
fun AnimatedGradientBorderButton(
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition()
    val animatedProgress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(animation = tween(4000))
    )

    val gradientBrush = Brush.linearGradient(
        colors = listOf(Color.Red, Color.Yellow, Color.Green, Color.Cyan, Color.Magenta),
        start = Offset(animatedProgress * 1000, animatedProgress * 1000),
        end = Offset((1f - animatedProgress) * 1000, (1f - animatedProgress) * 1000)
    )

    Button(
        onClick = onClick,
        modifier = Modifier
            .border(2.dp, gradientBrush, RoundedCornerShape(16.dp))
            .padding(4.dp)
    ) {
        content()
    }
}
@Preview
@Composable
fun AnimatedGradientBorderButtonPreview() {
    AnimatedGradientBorderButton(
        onClick = {
            print("Button Clicked")
        }
    ) {
        Text(text = "Gradient Border Button")
    }
}

//13. Button with Long Press and Feedback Animation

@Composable
fun LongPressFeedbackButton(
    onClick: () -> Unit,
    onLongPress: () -> Unit,
    content: @Composable () -> Unit
) {
    var scale by remember { mutableStateOf(1f) }

    Button(
        onClick = onClick,
        modifier = Modifier
            .scale(scale)
            .pointerInput(Unit) {
                detectTapGestures(
                    onLongPress = {
                        onLongPress()
                        scale = 0.9f
                    },
                    onPress = {
                        tryAwaitRelease()
                        scale = 1f
                    }
                )
            }
    ) {
        content()
    }
}
@Preview
@Composable
fun LongPressFeedbackButtonPreview() {
    LongPressFeedbackButton(
        onClick = {
            print("Click Event")
        },
        onLongPress = {
            print("Long press action ")
        }
    ) {
        Icon(Icons.Default.Settings, contentDescription = "Settings")
        }
}

//14. Button with Counter Animation
@Composable
fun CounterButton(
    count: Int,
    onClick: () -> Unit
) {
    val animatedCount by animateIntAsState(targetValue = count, animationSpec = tween(300))

    Button(onClick = onClick) {
        Text(text = "Count: $animatedCount")
    }
}
@Preview
@Composable
fun CounterButtonPreview() {
    CounterButton(
        count = 5,
        onClick = {
            print("Button Clicked")
        }
    )
}

//15. Download Button with Progress Animation
@Composable
fun DownloadButton(
    progress: Float,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        enabled = progress < 1f
    ) {
        if (progress < 1f) {
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Downloading...")
        } else {
            Text("Completed")
        }
    }
}
@Preview
@Composable
fun DownloadButtonPreview() {
    DownloadButton(
        progress = 0.5f,
        onClick = {
            print("Download Clicked")
        }
    )
}

//16. Button with Confetti Animation on Success

@Composable
fun ConfettiButton(
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    var showConfetti by remember { mutableStateOf(false) }

    Button(
        onClick = {
            showConfetti = true
            onClick()
        }
    ) {
        Box(contentAlignment = Alignment.Center) {
            if (showConfetti) {
                LaunchedEffect(Unit) {
                    delay(2000)
                    showConfetti = false
                }
                // Add a confetti effect (pseudo code, replace with actual confetti logic)
                ConfettiAnimation()
            }
            content()
        }
    }
}

@Composable
fun ConfettiAnimation() {
    TODO("Not yet implemented")
}

@Preview
@Composable
fun ConfettiButtonPreview() {
    ConfettiButton(
        onClick = {
            print("Button Clicked")
        }
    ){
        Text(text = "Confetti Button")
    }
}

//17. Advanced Button with Shimmer Effect
@Composable
fun ShimmerButton(
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val shimmerOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(tween(1000, easing = LinearEasing)), label = ""
    )

    val shimmerBrush = Brush.linearGradient(
        colors = listOf(Color.Red, Color.White, Color.Cyan),
        start = Offset(0f, 0f),
        end = Offset(shimmerOffset * 200f, 200f)
    )

    Button(
        onClick = onClick,
        modifier = Modifier
            .background(shimmerBrush)
    ) {
        content()
    }
}

@Preview
@Composable
fun ShimmerButtonPreview() {
    ShimmerButton(
        onClick = {
            print("Button Clicked")
        }
    ){
        Text(text = "Shimmer Button")
    }
}

//18. Circular Button with Animated Progress
@Composable
fun CircularProgressButton(
    progress: Float,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        modifier = Modifier.size(100.dp)
    ) {
        CircularProgressIndicator(
            progress = progress,
            modifier = Modifier.size(48.dp),
            color = Color.White,
            strokeWidth = 4.dp
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text("Progress")
    }
}
@Preview
@Composable
fun CircularProgressButtonPreview() {
    CircularProgressButton(
        progress = 0.5f,
        onClick = {
            print("Button Clicked")
        }
    )
}

//19. Floating Action Button with Custom Animation
//@Composable
//fun AnimatedFAB(
//    onClick: () -> Unit,
//    expanded: Boolean
//) {
//    val size by animateDpAsState(targetValue = if (expanded) 80.dp else 56.dp)
//
//    FloatingActionButton(
//        onClick = onClick,
//        modifier = Modifier.size(size),
//        backgroundColor = if (expanded) Color.Green else Color.Blue
//    ) {
//        Icon(Icons.Default.Add, contentDescription = "FAB", tint = Color.White)
//    }
//}
//@Preview
//@Composable
//fun AnimatedFABPreview() {
//    AnimatedFAB(
//        onClick = {
//            print("FAB Clicked")
//        },
//        expanded = true
//    )
//}


//20. Button with Wave Animation on Press

@Composable
fun WaveAnimationButton(
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    var isPressed by remember { mutableStateOf(false) }

    val waveAnimation by animateFloatAsState(
        targetValue = if (isPressed) 1f else 0f,
        animationSpec = tween(500)
    )

    Button(
        onClick = {
            isPressed = true
            onClick()
            isPressed = false
        },
        modifier = Modifier.drawBehind {
            val radius = size.minDimension * waveAnimation
            drawCircle(Color.Gray.copy(alpha = 0.5f), radius, center)
        }
    ) {
        content()
    }
}

@Preview
@Composable
fun WaveAnimationButtonPreview() {
    WaveAnimationButton(
        onClick = {
            print("Button Clicked")
        }
        ) {
        Text(text = "Wave Button")
    }
}

//22. Icon Button with Reveal Animation
@Composable
fun RevealIconButton(
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    val size by animateDpAsState(targetValue = if (expanded) 200.dp else 56.dp, label = "")

    IconButton(
        onClick = {
            expanded = !expanded
            onClick()
        },
        modifier = Modifier.size(size)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(Color.Gray, shape = CircleShape)
        ) {
            content()
        }
    }
}

@Preview
@Composable
fun RevealIconButtonPreview() {
    RevealIconButton(
        onClick = {
            print("Icon Button Clicked")
        }
    ){
        Icon(Icons.Default.Add, contentDescription = "Add")
    }
}

//23. Split Button (Two Actions in One)

@Composable
fun SplitButton(
    primaryAction: () -> Unit,
    secondaryAction: () -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = primaryAction,
            modifier = Modifier.weight(1f)
        ) {
            Text("Primary Action")
        }

        Button(
            onClick = secondaryAction,
            modifier = Modifier.weight(1f)
        ) {
            Text("Secondary Action")
        }
    }
}
@Preview
@Composable
fun SplitButtonPreview() {
    SplitButton(
        primaryAction = {
            print("Primary Action Clicked")
        }
    ){
        print("Secondary Action Clicked")
    }
}
//24. Button with Loading Progress Circle on Text
@Composable
fun ProgressTextButton(
    isLoading: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        enabled = !isLoading
    ) {
        if (isLoading) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Loading ")
                CircularProgressIndicator(
                    modifier = Modifier.size(16.dp),
                    color = Color.White,
                    strokeWidth = 2.dp
                )
            }
        } else {
            Text("Submit")
        }
    }
}

@Preview
@Composable
fun ProgressTextButtonPreview() {
    ProgressTextButton(
        isLoading = false,
        onClick = {
            print("Button Clicked")
        }
    )
}
//25. Button with Custom Gesture (Swipe to Confirm)

@Composable
fun SwipeToConfirmButton(
    onSwipeComplete: () -> Unit
) {
    var offsetX by remember { mutableStateOf(0f) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.LightGray, RoundedCornerShape(25.dp))
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    val newOffset = offsetX + dragAmount.x
                    if (newOffset in 0f..size.width.toFloat()) {
                        offsetX = newOffset
                    }

                    if (offsetX >= size.width - 100.dp.toPx()) {
                        onSwipeComplete()
                    }
                }
            }
    ) {
        Text(
            text = "Swipe to Confirm",
            modifier = Modifier.align(Alignment.Center),
            color = Color.DarkGray
        )
        Box(
            modifier = Modifier
                .offset { IntOffset(offsetX.toInt(), 0) }
                .size(50.dp)
                .background(Color.Green, CircleShape)
                .align(Alignment.CenterStart)
        )
    }
}

@Preview
@Composable
fun SwipeToConfirmButtonPreview() {
    SwipeToConfirmButton(
        onSwipeComplete = {
            print("Swipe Completed")
        }
    )
}

//26. Button with Fading Icon Animation

@Composable
fun FadingIconButton(
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val alpha by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    IconButton(onClick = onClick) {
        Box(modifier = Modifier.alpha(alpha)) {
            content()
        }
    }
}

@Preview
@Composable
fun FadingIconButtonPreview() {
    FadingIconButton(
        onClick = {
            print("Icon Button Clicked")
        }
    ){
        Column {
            Icon(Icons.Default.Favorite, contentDescription = "Add")
        }

    }
}

//27. Button with Shadow Lift Animation
@Composable
fun LiftButton(
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    var isPressed by remember { mutableStateOf(false) }

    val elevation by animateDpAsState(if (isPressed) 16.dp else 4.dp)

    Button(
        onClick = {
            isPressed = true
            onClick()
            isPressed = false
        },
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = elevation)
    ) {
        content()
    }
}

@Preview
@Composable
fun LiftButtonPreview() {
    LiftButton(
        onClick = {
            print("Button Clicked")
        }
    ){
        Text(text = "Lift Button")
    }
}

//28. Sliding Button with Image Reveal
@Composable
fun SlidingRevealButton(
    onClick: () -> Unit,
    image: Painter,
    content: @Composable () -> Unit
) {
    var offsetX by remember { mutableStateOf(0f) }
    val imageWidth = 100.dp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.LightGray, RoundedCornerShape(25.dp))
    ) {
        content()

        Image(
            painter = image,
            contentDescription = "Slide Image",
            modifier = Modifier
                .offset { IntOffset(offsetX.toInt(), 0) }
                .size(imageWidth)
                .clickable {
                    onClick()
                }
        )
    }
}

@Preview
@Composable
fun SlidingRevealButtonPreview() {
    SlidingRevealButton(
        onClick = {
            print("Image Clicked")
        },
        image = painterResource(id = R.drawable.bird)
    ){
        Text(text = "Sliding Button")
    }
}