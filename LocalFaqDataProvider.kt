package com.datamateappdev.trials.data

import com.datamateappdev.trials.R

object LocalFaqDataProvider {
    val faqs = listOf(
        Faq(
            id = 1,
            question = R.string.faq_question_one,
            answer = R.string.faq_question_one_answer
        ),
        Faq(
            id = 2,
            question = R.string.faq_question_two,
            answer = R.string.faq_question_two_answer
        ),
        Faq(
            id = 3,
            question = R.string.faq_question_three,
            answer = R.string.faq_question_three_answer
        ),
        Faq(
            id = 4,
            question = R.string.faq_question_four,
            answer = R.string.faq_question_four_answer
        )
    )
}