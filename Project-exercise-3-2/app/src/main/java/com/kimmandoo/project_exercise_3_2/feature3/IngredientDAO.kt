package com.kimmandoo.project_exercise_3_2.feature3

import androidx.room.*

@Dao
interface IngredientDAO {
    @Query("select * from ingredientDb")
    fun getAll(): List<IngredientDb>
    @Insert(onConflict = OnConflictStrategy.REPLACE) //insert로 메모가 들어왔는데 이미 값이 있는 경우면 덮어쓰기가 됨.(update개념)
    fun insert(memo : IngredientDb)
    @Delete
    fun delete(memo: IngredientDb)
}