package gz.dam.preferenciastarea


import java.time.LocalDateTime


// Modelo de datos para guardar récords
// Ref: Kotlin Data Classes https://kotlinlang.org/docs/data-classes.html
data class RecordModel(
    val timestamp: String,
    val round: Int
) {
    companion object {
        // Crea un récord con tiempo actual
        // Ref: Java Time API
        fun createWithCurrentTime(round: Int): RecordModel {
            return RecordModel(
                timestamp = LocalDateTime.now().toString(),
                round = round
            )
        }

        // Récord por defecto (ronda 0)

        fun default(): RecordModel {
            return createWithCurrentTime(0)
        }
    }
}
