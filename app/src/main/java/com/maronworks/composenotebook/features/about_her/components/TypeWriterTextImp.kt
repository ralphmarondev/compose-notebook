package com.maronworks.composenotebook.features.about_her.components

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.streams.toList

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TypeWriterTextImp() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Type Writer")
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            AnimateTypewriterText(
                baseText = "You are ",
                highlightText = "awesome",
                parts = listOf(
                    "awesome",
                    "great"
                )
            )
        }
    }
}

@Composable
private fun AnimateTypewriterText(
    baseText: String,
    highlightText: String,
    parts: List<String>
) {

    val highlightStart = baseText.indexOf(highlightText)
    var partIndex by remember { mutableIntStateOf(0) }
    var partText by remember { mutableStateOf("") }
    val textToDisplay = "$baseText$partText"
    var selectedPartRects by remember { mutableStateOf(listOf<Rect>()) }

    LaunchedEffect(key1 = parts) {
        while (partIndex <= parts.size) {
            val part = parts[partIndex]
            part.forEachIndexed { charIndex, _ ->
                partText = part.substring(startIndex = 0, endIndex = charIndex + 1)
                delay(100)
            }
            delay(1000)
            part.forEachIndexed { charIndex, _ ->
                partText = part
                    .substring(startIndex = 0, endIndex = part.length - (charIndex + 1))
                delay(30)
            }
            delay(500)
            partIndex = (partIndex + 1) % parts.size
        }
    }

    Text(
        text = textToDisplay,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.drawBehind {
            val borderSize = 20.sp.toPx()
            selectedPartRects.forEach { rect ->
                val selectedRect = rect.translate(0f, -borderSize / 1.5f)
                drawLine(
                    color = Color(0x408559DA),
                    start = Offset(selectedRect.left, selectedRect.bottom),
                    end = selectedRect.bottomRight,
                    strokeWidth = borderSize
                )
            }
        },
        onTextLayout = { layoutResult ->
            val start = baseText.length
            val end = textToDisplay.count()
            selectedPartRects = if (start < end) {
                layoutResult.getBoundingBoxesForRange(start = start, end = end - 1)
            } else {
                emptyList()
            }

            if (highlightStart >= 0) {
                selectedPartRects = selectedPartRects + layoutResult
                    .getBoundingBoxesForRange(
                        start = highlightStart,
                        end = highlightStart + highlightText.length
                    )
            }
        }
    )
}

private fun TextLayoutResult.getBoundingBoxesForRange(start: Int, end: Int): List<Rect> {
    var prevRect: Rect? = null
    var firstLineCharRect: Rect? = null
    val boundingBoxes = mutableListOf<Rect>()
    for (i in start..end) {
        val rect = getBoundingBox(i)
        val isLastRect = i == end

        // single char case
        if (isLastRect && firstLineCharRect == null) {
            firstLineCharRect = rect
            prevRect = rect
        }

        // `rect.right` is zero for the last space in each line
        // looks like an issue to me, reported: https://issuetracker.google.com/issues/197146630
        if (!isLastRect && rect.right == 0f) continue

        if (firstLineCharRect == null) {
            firstLineCharRect = rect
        } else if (prevRect != null) {
            if (prevRect.bottom != rect.bottom || isLastRect) {
                boundingBoxes.add(
                    firstLineCharRect.copy(right = prevRect.right)
                )
                firstLineCharRect = rect
            }
        }
        prevRect = rect
    }
    return boundingBoxes
}