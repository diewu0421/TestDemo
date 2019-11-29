package com.example.architecturedemo.entity

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   2019-08-12 19:58
 */
@Entity(tableName = "login_info",
    indices = [Index(value = ["id"],unique = true)])
data class LoginInfo(
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "pass")
    val pass: String
) {

    @PrimaryKey
    var id: Int = 0
}


@Dao
interface LoginDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLogin(loginInfo: LoginInfo)

    @Query("SELECT * FROM login_info WHERE name=:name")
    fun getLoginInfo(name:String) : LiveData<LoginInfo>
}

@Database(entities = [LoginInfo::class],version = 1,exportSchema = true)
abstract class AppDataBase : RoomDatabase() {
    abstract fun loginDao() : LoginDao
}