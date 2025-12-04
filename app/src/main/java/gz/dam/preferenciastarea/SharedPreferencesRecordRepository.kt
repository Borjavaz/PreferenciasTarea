

package gz.dam.preferenciastarea


import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson


class SharedPreferencesRecordRepository(
    private val context: Context
) : RecordRepository {


    private val gson = Gson()
    private val prefsName = "simon_dice_prefs"
    private val recordKey = "record"


    override fun saveRecord(record: RecordModel) {
        val sharedPreferences = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE)
        val recordJson = gson.toJson(record)


        sharedPreferences.edit {
            putString(recordKey, recordJson)
        }
    }


    override fun getRecord(): RecordModel {
        val sharedPreferences = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE)
        val recordJson = sharedPreferences.getString(recordKey, null)


        return if (recordJson != null) {
            gson.fromJson(recordJson, RecordModel::class.java)
        } else {
            RecordModel.default()
        }
    }
}
