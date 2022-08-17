package com.kimmandoo.project_exercise_3_2.feature3

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(IngredientDb::class), version = 1, exportSchema = false) // version을 써줘야하는 이유는 업데이트하면서 룸 테이블이 바뀔 수 있기 때문
abstract class RoomHelper: RoomDatabase() {
    abstract fun ingredientDao(): IngredientDAO // 추상메서드. 룸이 알아서 다 해줌
}