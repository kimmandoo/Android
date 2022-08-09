package com.kimmandoo.project_exercise_3_2.feature2

data class IngredientServer(
    val valueList: MutableList<IngredientCountDue>
)

data class IngredientCountDue(
    val count : Int,
    val validity : String
)
