package com.example.trials.data

import androidx.annotation.StringRes

data class Faq(
    val id: Long,
    @StringRes val question: Int,
    @StringRes val answer: Int
)
