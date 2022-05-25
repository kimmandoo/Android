package kimmandoo.room

import androidx.room.*

@Dao
interface RoomMemoDAO {
    @Query("select * from room_memo")
    fun getAll(): List<RoomMemo>
    @Insert(onConflict = OnConflictStrategy.REPLACE) //insert로 메모가 들어왔는데 이미 값이 있는 경우면 덮어쓰기가 됨.(update개념)
    fun insert(memo : RoomMemo)
    @Delete
    fun delete(memo: RoomMemo)
}