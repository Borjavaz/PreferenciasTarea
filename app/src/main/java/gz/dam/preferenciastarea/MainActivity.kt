package gz.dam.preferenciastarea

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import gz.dam.preferenciastarea.ui.theme.SimonDiceTheme

// Activity principal con Jetpack Compose

class MainActivity : ComponentActivity() {

    // Configura la UI con Compose y ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SimonDiceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val viewModel: VM = viewModel(
                        factory = VMFactory(application) // Inyecta dependencias
                    )
                    SimonDiceUI(viewModel)
                }
            }
        }
    }

    // Libera recursos al destruir la Activity
    override fun onDestroy() {
        super.onDestroy()
        SoundPlayer.getInstance(this).release()
    }
}
