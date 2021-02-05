package com.example.quizapp

object Constants{

    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWERS:String="correct_answers"

    fun getQuestions(): ArrayList<QuestionClass>{
        val QuestionsList=ArrayList<QuestionClass>()

        // 1
        val que1 = QuestionClass(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina", "Australia",
            "Armenia", "Austria", 1
        )

        QuestionsList.add(que1)

        // 2
        val que2 = QuestionClass(
            2, "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Angola", "Austria",
            "Australia", "Armenia", 3
        )

        QuestionsList.add(que2)

        // 3
        val que3 = QuestionClass(
            3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belarus", "Belize",
            "Brunei", "Brazil", 4
        )

        QuestionsList.add(que3)

        // 4
        val que4 = QuestionClass(
            4, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas", "Belgium",
            "Barbados", "Belize", 2
        )

        QuestionsList.add(que4)

        // 5
        val que5 = QuestionClass(
            5, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon", "France",
            "Fiji", "Finland", 3
        )

        QuestionsList.add(que5)

        // 6
        val que6 = QuestionClass(
            6, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany", "Georgia",
            "Greece", "none of these", 1
        )

        QuestionsList.add(que6)

        // 7
        val que7 = QuestionClass(
            7, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica", "Egypt",
            "Denmark", "Ethiopia", 3
        )

        QuestionsList.add(que7)

        // 8
        val que8 = QuestionClass(
            8, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Ireland", "Iran",
            "Hungary", "India", 4
        )

        QuestionsList.add(que8)

        // 9
        val que9 = QuestionClass(
            9, "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia", "New Zealand",
            "Tuvalu", "United States of America", 2
        )

        QuestionsList.add(que9)

        // 10
        val que10 = QuestionClass(
            10, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait", "Jordan",
            "Sudan", "Palestine", 1
        )

        QuestionsList.add(que10)

        return QuestionsList
    }

}