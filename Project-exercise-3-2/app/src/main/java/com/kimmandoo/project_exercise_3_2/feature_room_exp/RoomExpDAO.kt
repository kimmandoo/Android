package com.kimmandoo.project_exercise_3_2.feature_room_exp

import androidx.room.*

@Dao
interface RoomExpDAO {
    @Query("select * from roomexpdb")
    fun getAll(): List<RoomExpDB>
    @Insert(onConflict = OnConflictStrategy.REPLACE) //insert로 메모가 들어왔는데 이미 값이 있는 경우면 덮어쓰기가 됨.(update개념)
    fun insert(value : RoomExpDB)
    @Delete
    fun delete(value: RoomExpDB)
}