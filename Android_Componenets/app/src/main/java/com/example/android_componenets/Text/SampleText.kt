package com.example.android_componenets.Componenets.Text
import android.widget.ListView
import android.widget.ScrollView
import android.widget.Scroller
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_componenets.R
import kotlinx.coroutines.delay
import kotlin.math.cos
import kotlin.math.sin


//1. Simple Text with Basic Customization
@Composable
fun SimpleTextExample() {
    Text(
        text = "Simple Text Example",
        fontSize = 32.sp,
        color = androidx.compose.ui.graphics.Color.Red,
        fontWeight = FontWeight.Bold,
        maxLines = 2,
        softWrap = true,
        overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
    )

}
@Preview
@Composable
fun SimpleTextPreview() {
    SimpleTextExample()
}

//2. Text with Background and Padding
@Composable
fun TextWithBackground() {

    Text(text = "This is a text with a background color.",
        modifier = Modifier
            .background(Color.LightGray)
            .padding(16.dp)
            .background(Color.Yellow),
        fontSize = 32.sp,
        color = Color.Cyan
    )
}
@Preview
@Composable
fun TextWithBackgroundPreview() {
    TextWithBackground()
}

//3. Text with Custom Font Family

@Composable
fun CustomFontText() {
    Text(
        text = "Styled with Custom Font",
        fontFamily = FontFamily(Font(R.font.rm_bold)),
        fontSize = 22.sp,
        color = Color.Magenta
    )
}

@Preview
@Composable
fun CustomFontTextPreview() {
    CustomFontText()
}

//4. Clickable Text with Action
@Composable
fun ClickableTextExample() {

    Text(text = "Click Me$",
        modifier = Modifier.clickable {
            println("Text clicked!")
        },
        fontSize = 18.sp,
        color = Color.Green,
        textDecoration = TextDecoration.Underline
    )

}

@Preview
@Composable
fun ClickableTextExamplePreview() {
    ClickableTextExample()
}

//5. Multiline Text with Overflow Handling
@Composable
fun MultilineText() {

    Text(
        text = "This is a long text that will be limited to two lines and if it exceeds, ellipses (...) will be shown.",
        fontSize = 16.sp,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.padding(16.dp),
        color = Color.Red
    )

}
@Preview
@Composable
fun MultilineTextPreview() {
    MultilineText()
}
//6. Rich Text with Different Styles
@Composable
fun RichTextExample() {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Blue)){
                append("This is a Bold Text")
            }
            withStyle(style = SpanStyle(fontStyle = FontStyle.Italic, color = Color.Blue)){
                append("This is an Italic Text")
            }
        },
        fontSize = 18.sp
    )
}

@Preview
@Composable
fun RichTextExamplePreview() {
    RichTextExample()
}

//7. Gradient Text
@Composable
fun GradientText() {
    Text(
        text = "Gradient Text",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = listOf(Color.Yellow, Color.Red)
            )

        )
    )
}
@Preview
@Composable
fun GradientTextPreview() {
    GradientText()
}

//8. Text with Custom Letter Spacing
@Composable
fun LetterSpacingText() {
    Text(text = "Text with Spacing",
        fontSize = 24.sp,
        letterSpacing = 4.sp,
        color = Color.Red
    )
}
@Preview
@Composable
fun LetterSpacingTextPreview() {
    LetterSpacingText()
}

//9. Text with Shadow

@Composable
fun ShadowText() {
    Text(text = "Shadow Effect",
        fontSize = 28.sp,
        color = Color.Black,
        style = TextStyle(
            shadow = Shadow(
                color = Color.Green,
                offset = Offset(8f, 8f),
                blurRadius = 10f
            )
        )
    )
}

@Preview
@Composable
fun ShadowTextPreview() {
    ShadowText()
}

//10. Text with Inline Icons

@Composable
fun TextWithInlineIcon() {
    val inlineTextContent = mapOf(
        "icon" to InlineTextContent(
            placeholder = Placeholder(
                width = 24.sp,
                height = 24.sp,
                placeholderVerticalAlign = PlaceholderVerticalAlign.AboveBaseline
            )
        ){
            Icon(
                painter = painterResource(id = R.drawable.bird), // Replace with your drawable
                contentDescription = null,
                tint = Color.Yellow
            )
        }

    )

    Text(
        text = buildAnnotatedString {
            append("Rate us: ")
            appendInlineContent("icon", "star")
        },
        inlineContent = inlineTextContent,
        fontSize = 18.sp
    )
}

@Preview
@Composable
fun TextWithInlineIconPreview() {
    TextWithInlineIcon()
}

//11. Multi-Color Text using Spans

@Composable
fun MultiColorText() {
    Text(
        buildAnnotatedString {
            append("This is ")
            withStyle(style = SpanStyle(color = Color.Red)) {
                append("red, ")
            }
            withStyle(style = SpanStyle(color = Color.Green)) {
                append("green, ")
            }
            withStyle(style = SpanStyle(color = Color.Blue)) {
                append("and blue!")
            }
        },
        fontSize = 20.sp
    )
}
@Preview
@Composable
fun MultiColorTextPreview() {
    MultiColorText()
}
//12. Text with Stroke (Outline)

@Composable
fun StrokeText() {
    Box (modifier = Modifier.background(Color.Cyan)){
        // Bottom layer: text with a bigger size to simulate stroke
        Text(
            text = "Outlined Text",
            fontSize = 40.sp,
            color = Color.White,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(1f, 1f),
                    blurRadius = 10f
                )
            )
        )
        // Top layer: normal text
        Text(
            text = "Outlined Text",
            fontSize = 40.sp,
            color = Color.Black
        )
    }
}
@Preview
@Composable
fun StrokeTextPreview() {
    StrokeText()
}

//13. Auto-Sized Text within Constraints
@Composable
fun MixedFontText() {
    Text(
        buildAnnotatedString {
            append("This is ")
            withStyle(style = SpanStyle(fontFamily = FontFamily.Serif)) {
                append("Serif ")
            }
            withStyle(style = SpanStyle(fontFamily = FontFamily.Monospace, fontSize = 22.sp)) {
                append("Monospace ")
            }
            withStyle(style = SpanStyle(fontFamily = FontFamily.Cursive, fontWeight = FontWeight.Bold)) {
                append("and Cursive")
            }
        },
        fontSize = 18.sp,
        color = Color.Blue
    )
}
@Preview
@Composable
fun MixedFontTextPreview() {
    MixedFontText()
}

//15. Text with Hyperlink
@Composable
fun HyperlinkText() {
    val annotatedString = buildAnnotatedString {
        append("For more information, visit ")
        pushStringAnnotation(tag = "URL", annotation = "https://example.com")
        withStyle(style = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline)) {
            append("our website.")
        }
        pop()
    }

    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(tag = "URL", start = offset, end = offset)
                .firstOrNull()?.let { annotation ->
                    println("Clicked URL: ${annotation.item}")
                }
        },
        style = TextStyle(color = Color.Black),
        modifier = Modifier.padding(16.dp)
    )
}

@Preview
@Composable
fun HyperlinkTextPreview() {
    HyperlinkText()
}

//16. Circular Text
@Composable
fun CircularText() {
    val radius = 100.dp
    val angleStep = 360 / 10 // Divide the circle into 10 segments for the text characters
    val texts = listOf("J", "E", "T", "P", "A", "C", "K", "C", "O", "M")

    Box(modifier = Modifier.size(radius * 2)) {
        texts.forEachIndexed { index, char ->
            val angle = angleStep * index
            val x = radius * cos(Math.toRadians(angle.toDouble())).toFloat()
            val y = radius * sin(Math.toRadians(angle.toDouble())).toFloat()

            Text(
                text = char,
                fontSize = 24.sp,
                color = Color.Black,
                modifier = Modifier
                    .rotate(angle.toFloat())
                    .offset(x, y)
            )
        }
    }
}
@Preview
@Composable
fun CircularTextPreview() {
    CircularText()
}

//17. Rotated Text
@Composable
fun RotatedText() {
    Text(
        text = "Rotated Text",
        fontSize = 28.sp,
        color = Color.Red,
        modifier = Modifier.rotate(45f)
    )
}

@Preview
@Composable
fun RotatedTextPreview() {
    RotatedText()
}

//18. Text with Background Image

//@Composable
//fun TextWithBackgroundImage() {
//    Box(
//        modifier = Modifier.run {
//            background(
//                painter = painterResource(id = R.drawable.ai_food_donate), // Replace with your image
//                contentScale = ContentScale.Crop
//            )
//                .fillMaxWidth()
//                .height(200.dp)
//        }
//    ) {
//        Text(
//            text = "Text with Background Image",
//            color = Color.White,
//            fontSize = 24.sp,
//            modifier = Modifier.align(Alignment.Center)
//        )
//    }
//
//
//}
//
//@Preview
//@Composable
//fun TextWithBackgroundImagePreview() {
//    TextWithBackgroundImage()
//}

//19. Gradient Outline Text

@Composable
fun GradientOutlineText() {
    val gradientBrush = Brush.linearGradient(
        colors = listOf(Color.Red, Color.Yellow)
    )
    Box {
        // Bottom layer for the outline effect
        Text(
            text = "Gradient Outline",
            fontSize = 40.sp,
            color = Color.Black,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Gray,
                    offset = Offset(1f, 1f),
                    blurRadius = 30f
                )
            )
        )
        // Top layer with gradient fill
        Text(
            text = "Gradient Outline",
            fontSize = 40.sp,
            style = TextStyle(brush = gradientBrush)
        )
    }
}

@Preview
@Composable
fun GradientOutlineTextPreview() {
    GradientOutlineText()
}
//20. Text Inside a Shape


@Composable
fun TextInShape() {
    Box(
        modifier = Modifier
            .size(150.dp)
            .background(Color.LightGray, shape = CircleShape)
            .border(2.dp, Color.DarkGray, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Inside a Circle",
            fontSize = 16.sp,
            color = Color.White
        )
    }
}
@Preview
@Composable
fun TextInShapePreview() {
    TextInShape()
}

//21. Text Animation with AnimatedVisibility
@Composable
fun AnimatedTextExample() {
    var isVisible by remember {
            mutableStateOf(true)
    }
     Column(horizontalAlignment = Alignment.CenterHorizontally) {
        AnimatedVisibility(visible = isVisible) {
            Text(
                text = "This text is animated!",
                fontSize = 24.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = if (isVisible) "Hide Text" else "Show Text")
        }
    }
}
@Preview
@Composable
fun AnimatedTextExamplePreview() {
    AnimatedTextExample()
}
//22. Vertical Text (Stacked Letters)

@Composable
fun VerticalText() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        "VERTICAL".forEach { char ->
            Text(
                text = char.toString(),
                fontSize = 24.sp,
                color = Color.Blue
            )
        }
    }
}
@Preview
@Composable
fun VerticalTextPreview() {
    VerticalText()
}

//23. Flashing Text Animation

@Composable
fun FlashingText() {
    val infiniteTransition = rememberInfiniteTransition()
    val alpha by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0.3f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Text(
        text = "Flashing Text",
        fontSize = 30.sp,
        color = Color.Red.copy(alpha = alpha)
    )
}
@Preview
@Composable
fun FlashingTextPreview() {
    FlashingText()
}

//24. Scrolling Marquee Text

@Composable
fun MarqueeText() {
    val scrollState = rememberScrollState()

    LaunchedEffect(scrollState) {
        scrollState.animateScrollTo(scrollState.maxValue)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.Gray)
            .horizontalScroll(scrollState)
    ) {
        Text(
            text = "This is a marquee text that scrolls continuously across the screen!",
            fontSize = 18.sp,
            color = Color.White
        )
    }
}
@Preview
@Composable
fun MarqueeTextPreview() {
    MarqueeText()
}

//25. Text with Dynamic Color Change
@Composable
fun DynamicColorText() {
    var color by remember { mutableStateOf(Color.Red) }

    LaunchedEffect(Unit) {
        while (true) {
            color = if (color == Color.Red) Color.Green else Color.Red
            delay(1000) // Change color every 1 second
        }
    }

    Text(
        text = "Dynamic Color Text",
        fontSize = 24.sp,
        color = color
    )
}
@Preview
@Composable
fun DynamicColorTextPreview() {
    DynamicColorText()
}

//26. Gradient Stroke Text
@Composable
fun GradientStrokeText() {
    val gradientBrush = Brush.linearGradient(
        colors = listOf(Color.Magenta, Color.Cyan)
    )

    Box {
        // Outline layer
        Text(
            text = "Gradient Stroke",
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Gray,
                    offset = Offset(2f, 2f),
                    blurRadius = 4f
                )
            )
        )
        // Main text layer
        Text(
            text = "Gradient Stroke",
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold,
            style = TextStyle(brush = gradientBrush)
        )
    }
}
@Preview
@Composable
fun GradientStrokeTextPreview() {
    GradientStrokeText()
}