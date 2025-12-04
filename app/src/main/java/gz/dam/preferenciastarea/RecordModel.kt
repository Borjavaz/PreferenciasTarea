package gz.dam.preferenciastarea


import java.time.LocalDateTime


data class RecordModel(
    val timestamp: String,
    val round: Int
) {
    companion object {
        fun createWithCurrentTime(round: Int): RecordModel {
            return RecordModel(
                timestamp = LocalDateTime.now().toString(),
                round = round
            )
        }


        fun default(): RecordModel {
            return createWithCurrentTime(0)
        }
    }
}
