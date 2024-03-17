package com.datamateappdev.trials.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.datamateappdev.trials.data.Faq
import com.datamateappdev.trials.data.LocalFaqDataProvider

@Composable
fun FAQScreen(
    modifier: Modifier = Modifier
) {
    val expandedStateMap = remember { mutableStateMapOf<Long, Boolean>() }
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(items = LocalFaqDataProvider.faqs) { faq ->
            val expanded = expandedStateMap[faq.id] ?: false
            FaqItem(onItemClick = { clickedId ->
                expandedStateMap[clickedId] = !(expandedStateMap[clickedId] ?: false)
            }, faq = faq, expanded = expanded)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FaqItem(
    modifier: Modifier = Modifier,
    onItemClick: (Long) -> Unit = {},
    expanded: Boolean,
    faq: Faq
) {
    ElevatedCard(
        onClick = { onItemClick(faq.id) },
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .animateContentSize(animationSpec = tween(durationMillis = 400, easing = LinearEasing))
            .padding(horizontal = 10.dp, vertical = 6.dp)

    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = stringResource(id = faq.question),
                modifier = modifier.weight(1f),
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = null
            )
        }
        if (expanded) Text(text = stringResource(id = faq.answer), modifier = modifier.padding(10.dp))
    }
}