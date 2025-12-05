

package gz.dam.preferenciastarea


import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson

// Guarda récords en SharedPreferences usando JSON
// Ref: Android SharedPreferences https://developer.android.com/training/data-storage/shared-preferences
class SharedPreferencesRecordRepository(
    private val context: Context
) : RecordRepository {


    private val gson = Gson()
    private val prefsName = "simon_dice_prefs"
    private val recordKey = "record"

    // Guarda el récord como JSON en SharedPreferences
    // Ref: Gson User Guide https://github.com/google/gson

    override fun saveRecord(record: RecordModel) {
        val sharedPreferences = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE)
        val recordJson = gson.toJson(record)


        sharedPreferences.edit {
            putString(recordKey, recordJson)
        }
    }

    // Obtiene el récord o devuelve uno por defecto si no existe
    // Ref: Kotlin Null Safety https://kotlinlang.org/docs/null-safety.html

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
