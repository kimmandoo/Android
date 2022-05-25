package kimmandoo.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "room_memo")
//room_memo라는 이름으로 밑에 클래스를 테이블로 사용하겠다
class RoomMemo {
    @PrimaryKey(autoGenerate = true) //PK로 지정된 no의 값이 insert된다면 없을 때 자동으로 증가된 숫자값을 넣어줌
    @ColumnInfo
    var no: Long? = null
    @ColumnInfo
    var content: String = ""
    @ColumnInfo(name = "date") //코드에서는 datetime으로 쓰지만 attribute는 date로 생성됨
    var datetime: Long = 0

    //이렇게 쓰는 이유 -> 데이터 넣을때 한줄한줄 넣는것보다 생성자로 넣으면 한줄로 끝남
    constructor(content:String, datetime:Long){
        this.content = content
        this.datetime = datetime
    }
}