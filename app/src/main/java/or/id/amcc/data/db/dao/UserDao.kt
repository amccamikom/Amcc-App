package or.id.amcc.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import or.id.amcc.data.db.entities.CURRENT_USER_ID
import or.id.amcc.data.db.entities.User

@Dao
interface UserDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(user: User) : Long

    @Query("SELECT * FROM USER WHERE uid = $CURRENT_USER_ID")
    fun getUser() : LiveData<User>

}