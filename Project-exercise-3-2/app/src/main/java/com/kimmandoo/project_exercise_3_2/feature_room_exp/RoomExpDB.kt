package com.kimmandoo.project_exercise_3_2.feature_room_exp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "roomexpDb")
//ingredientDb라는 이름으로 밑에 클래스를 테이블로 사용하겠다
class RoomExpDB {
//    @PrimaryKey(autoGenerate = true) //PK로 지정된 no의 값이 insert된다면 없을 때 자동으로 증가된 숫자값을 넣어줌
//    @ColumnInfo
//    var no: Int? = null
    @PrimaryKey
    @ColumnInfo
    var name: String = ""
    @ColumnInfo
    var count: String? = ""
    @ColumnInfo(name = "expiration") //코드에서는 exp으로 쓰지만 attribute는 expiration로 생성됨
    var exp: String? = ""

    //이렇게 쓰는 이유 -> 데이터 넣을때 한줄한줄 넣는것보다 생성자로 넣으면 한줄로 끝남
    constructor(name:String, count:String, exp: String){
        this.name = name
        this.count = count
        this.exp = exp
    }
}
