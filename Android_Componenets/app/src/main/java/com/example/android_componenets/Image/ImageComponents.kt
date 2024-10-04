package com.example.android_componenets.Componenets.Image

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.android_componenets.R

class ImageComponents {
}



//1. Rounded Corner Image with Border

@Composable
fun RoundedCornerImage() {
    Image(
        painter = painterResource(id = R.drawable.bird),
        contentDescription = null,
        modifier = Modifier
            .size(120.dp)
            .clip(RoundedCornerShape(16.dp))
            .border(3.dp, Color.Red, RoundedCornerShape(16.dp)),
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun RoundedCornerImagePreview() {
    RoundedCornerImage()
}

//2. Full-Screen Image Background

@Composable
fun FullScreenImage() {
    Image(
        painter = painterResource(id = R.drawable.bird),
        contentDescription = "Background Image",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}
@Preview
@Composable
fun FullScreenImagePreview() {
    FullScreenImage()
}
//3. Circular Image with Drop Shadow
@Composable
fun CircularImageWithShadow() {
    Image(
        painter = painterResource(id = R.drawable.bird),
        contentDescription = "Circular Image",
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
            .shadow(8.dp, CircleShape),
        contentScale = ContentScale.Crop
    )
}
@Preview
@Composable
fun CircularImageWithShadowPreview() {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Cyan)){
        CircularImageWithShadow()
    }
}
//4. Grayscale Image Transformation with Coil
//@Composable
//fun GrayscaleImage(url: String) {
//    val painter = rememberAsyncImagePainter(
//        model = url,
//        transformations = listOf(GrayscaleTransformation())
//    )
//    Image(
//        painter = painter,
//        contentDescription = "Grayscale Image",
//        modifier = Modifier.size(150.dp),
//        contentScale = ContentScale.Crop
//    )
//}
//@Preview
//@Composable
//fun GrayscaleImagePreview() {
//    GrayscaleImage("https://example.com/image.jpg")
//}

//5. Zoomable Image
//@Composable
//fun ZoomableImage(url: String) {
//    var scale by remember { mutableStateOf(1f) }
//
//    Image(
//        painter = rememberAsyncImagePainter(url),
//        contentDescription = "Zoomable Image",
//        modifier = Modifier
//            .fillMaxWidth()
//            .pointerInput(Unit) {
//                detectTransformGestures { _, _, zoom, _ ->
//                    scale *= zoom
//                }
//            }
//            .graphicsLayer(scaleX = scale, scaleY = scale),
//        contentScale = ContentScale.Crop
//    )
//}
//@Preview
//@Composable
//fun ZoomableImagePreview() {
//    ZoomableImage("https://example.com/image.jpg")
//}

//6. Image with Gradient Overlay
@Composable
fun ImageWithGradientOverlay() {
    Box {
        Image(
            painter = painterResource(id = R.drawable.bird),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(Color.Transparent, Color.Black)
                    )
                )
        )
    }
}

@Preview
@Composable
fun ImageWithGradientOverlayPreview() {
    ImageWithGradientOverlay()
}
//7. Image with Content Alignment (Bottom Right)
@Composable
fun BottomRightAlignedImage() {
    Image(
        painter = painterResource(id = R.drawable.bird),
        contentDescription = null,
        modifier = Modifier
            .size(150.dp),
        contentScale = ContentScale.Crop
    )
}
@Preview
@Composable
fun BottomRightAlignedImagePreview() {
    BottomRightAlignedImage()
}
//8. Circular Image Button8. Circular Image Button
@Composable
fun CircularImageButton(onClick: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.bird),
        contentDescription = null,
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .clickable { onClick() },
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun CircularImageButtonPreview() {
    CircularImageButton(onClick = {
        print("send me this")
    })
}

//9. Image with Blurred Background
@Composable
fun BlurredBackgroundImage() {
    Box {
        Image(
            painter = painterResource(id = R.drawable.bird),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .blur(8.dp),
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(id = R.drawable.bird),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.Center),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
fun BlurredBackgroundImagePreview() {
    BlurredBackgroundImage()
}

//10. Image with Padding
@Composable
fun PaddedImage() {
    Image(
        painter = painterResource(id = R.drawable.bird),
        contentDescription = "Padded Image",
        modifier = Modifier
            .size(120.dp)
            .padding(16.dp),
        contentScale = ContentScale.Crop
    )
}
@Preview
@Composable
fun PaddedImagePreview() {
    PaddedImage()
}
//11. Image List with Coil
@Composable
fun ImageList(imageUrls: List<String>) {
    LazyColumn {
        items(imageUrls) { url ->
            RemoteImageExample(url.toString())
        }
    }
}

fun items(count: List<String>, itemContent: @Composable() (LazyItemScope.(index: Int) -> Unit)) {
    TODO("Not yet implemented")
}



//12. Image with Circular Progress Indicator
@Composable
fun ImageWithLoading(url: String) {
    var isLoading: Boolean by remember { mutableStateOf(true) }

    Box {
        if (isLoading) {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }

        Image(
            painter = rememberAsyncImagePainter(url),
            contentDescription = "Loaded Image",
            modifier = Modifier
                .size(150.dp)
                .onGloballyPositioned { isLoading = false },
            contentScale = ContentScale.Crop
        )
    }
}



@Preview
@Composable
fun ImageWithLoadingPreview() {
    ImageWithLoading("https://example.com/image.jpg")
}

//13. Image with Fade-in Animation
@Composable
fun FadeInImage(url: String) {
    var alpha by remember { mutableFloatStateOf(0f) }

    LaunchedEffect(Unit) {
        alpha = 1f
    }

    Image(
        painter = rememberAsyncImagePainter(url),
        contentDescription = null,
        modifier = Modifier
            .alpha(alpha)
            .animateContentSize(),
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun FadeInImagePreview() {
    FadeInImage("https://picsum.photos/id/1/200/300")
}

@Composable
fun ImageCollage(imageUrls: List<String>) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        imageUrls.take(3).forEach { url ->
            RemoteImageExample(url = url)
        }
    }
}
@Preview
@Composable
fun ImageCollagePreview() {
    ImageCollage(imageUrls = listOf("https://imgur.com/mew-CzXTtJV","https://imgur.com/mew-CzXTtJV","https://imgur.com/mew-CzXTtJV"))
}


//15. Circular Reveal Animation on Image Load

@Composable
fun CircularRevealImage(url: String) {
    val revealProgress = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        revealProgress.animateTo(1f, animationSpec = tween(1000))
    }

    Image(
        painter = rememberAsyncImagePainter(url),
        contentDescription = "Revealed Image",
        modifier = Modifier
            .size(150.dp)
            .graphicsLayer {
                clip = true
                shape = CircleShape
                scaleX = revealProgress.value
                scaleY = revealProgress.value
            },
        contentScale = ContentScale.Crop
    )

}
@Preview
@Composable
fun CircularRevealImagePreview() {
    CircularRevealImage("https://fastly.picsum.photos/id/1025/300/200.jpg?hmac=Cndwice7Ml2dHJI2wd4lnNLppf96nA1LZx1wStLzKFk")
}


//16. Collapsible Image Section

@Composable
fun CollapsibleImageSection(imageUrl: String) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(if (expanded) 200.dp else 100.dp)
                .clickable { expanded = !expanded },
            contentScale = ContentScale.Crop
        )
    }
}
@Preview
@Composable
fun CollapsibleImageSectionPreview() {
    CollapsibleImageSection("https://picsum.photos/id/1/200/300")
}

//17. Image with Color Overlay

@Composable
fun ImageWithColorOverlay() {
    Box {
        Image(
            painter = painterResource(id = R.drawable.bird),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xAA000000))
        )
    }
}

@Preview
@Composable
fun ImageWithColorOverlayPreview() {
    ImageWithColorOverlay()
}

//18. Crossfade Between Two Images
@Composable
fun CrossfadeImages(image1: String, image2: String) {
    var showFirstImage by remember { mutableStateOf(true) }

    Crossfade(targetState = showFirstImage) { isImage1 ->
        if (isImage1) {
            RemoteImageExample(url = image1)
        } else {
            RemoteImageExample(url = image2)
        }
    }
}

@Preview
@Composable
fun CrossfadeImagesPreview() {
    CrossfadeImages("https://picsum.photos/id/1/200/300", "https://picsum.photos/id/2/200/300")
}

@Composable
fun RemoteImageExample(url: String, modifier: Modifier = Modifier) {
    // Use Coil's rememberAsyncImagePainter to load the image from a remote URL
    val painter: Painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)  // Optional: enable a fade animation for loading images
            .build()
    )

    // Display the image with optional size modifier and content scale
    Image(
        painter = painter,
        contentDescription = "Remote Image",
        modifier = modifier.size(150.dp),
        contentScale = ContentScale.Crop  // Adjust how the image scales inside the container
    )
}

//19. Skeleton Placeholder While Image Loads
@Composable
fun ImageWithSkeleton(url: String) {
    var isLoading by remember { mutableStateOf(true) }

    Box {
        if (isLoading) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.Gray)
            )
        }

        Image(
            painter = rememberAsyncImagePainter(url),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .onGloballyPositioned { isLoading = false },
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
fun ImageWithSkeletonPreview() {
    ImageWithSkeleton("https://picsum.photos/id/1/200/300")
}

//20. Stacked Images with Z-Index
@Composable
fun StackedImages(imageUrls: List<String>) {
    Box {
        imageUrls.forEachIndexed { index, url ->
            RemoteImageExample(url = url, modifier = Modifier.zIndex(index.toFloat()))
        }
    }
}
@Preview
@Composable
fun StackedImagesPreview() {
    StackedImages(imageUrls = listOf("https://picsum.photos/id/1/200/300", "https://picsum.photos/id/2/200/300"))
}


//21. Image Grid with Spacing
@Composable
fun SpacedImageGrid(imageUrls: List<String>) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 100.dp),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(imageUrls) { url ->
            RemoteImageExample(url = url.toString())
        }
    }
}

@Preview
@Composable
fun SpacedImageGridPreview() {
    SpacedImageGrid(imageUrls = listOf("https://picsum.photos/id/1/200/300", "https://picsum.photos/id/2/200/300"))
}
//22. Image with Custom Shape (Hexagon)
@Composable
fun HexagonImage(url: String) {
    Image(
        painter = rememberAsyncImagePainter(url),
        contentDescription = null,
        modifier = Modifier
            .size(150.dp)
            .clip(HexagonShape()),
        contentScale = ContentScale.Crop
    )
}

fun HexagonShape(): Shape {
    return GenericShape { size, _ ->
        val path = Path()
        path.moveTo(size.width / 2, 0f)
        path.lineTo(size.width, size.height * 0.25f)
        path.lineTo(size.width, size.height * 0.75f)
        path.lineTo(size.width / 2, size.height)
        path.lineTo(0f, size.height * 0.75f)
        path.lineTo(0f, size.height * 0.25f)
        path.close()
    }
}

@Preview
@Composable
fun HexagonImagePreview() {
    HexagonImage("https://picsum.photos/id/1/200/300")
}

//23. Blurred Image with Foreground Content
@Composable
fun BlurredImageWithForeground(url: String, foregroundContent: @Composable () -> Unit) {
    Box {
        Image(
            painter = rememberAsyncImagePainter(url),
            contentDescription = null,
            modifier = Modifier.fillMaxSize().blur(16.dp),
            contentScale = ContentScale.Crop
        )
        foregroundContent()
    }
}

@Preview
@Composable
fun BlurredImageWithForegroundPreview() {
    BlurredImageWithForeground("https://picsum.photos/id/1/200/300") {
        println("Foreground content")
    }

}

//
//24. Image with Parallax Effect
@Composable
fun ParallaxImage(url: String, scrollState: ScrollState) {
    Image(
        painter = rememberAsyncImagePainter(url),
        contentDescription = "Parallax Image",
        modifier = Modifier
            .fillMaxWidth()
            .graphicsLayer { translationY = scrollState.value * 0.5f },
        contentScale = ContentScale.Crop
    )
}
@Preview
@Composable
fun ParallaxImagePreview() {
    ParallaxImage("https://picsum.photos/id/1/200/300", rememberScrollState())
}


//25. Shimmer Effect for Image Loading
@Composable
fun ShimmerImage(url: String) {
    var isLoading by remember { mutableStateOf(true) }

    Box {
        if (isLoading) {
            Shimmer(modifier = Modifier.size(150.dp))
        }

        Image(
            painter = rememberAsyncImagePainter(url),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .onGloballyPositioned { isLoading = false },
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun Shimmer(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(
                Brush.linearGradient(
                    listOf(Color.LightGray, Color.Gray, Color.LightGray)
                )
            )
    )
}

@Preview
@Composable
fun ShimmerImagePreview() {
    ShimmerImage("https://picsum.photos/id/1/200/300")
}