package gz.dam.preferenciastarea


import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// Crea ViewModels con dependencias (Application)
// Ref: Android ViewModel with Factory https://developer.android.com/topic/libraries/architecture/viewmodel#factories
class VMFactory(private val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VM::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return VM(app) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
