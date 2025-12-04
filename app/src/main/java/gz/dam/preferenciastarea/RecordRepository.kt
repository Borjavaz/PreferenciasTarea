package gz.dam.preferenciastarea


interface RecordRepository {
    fun saveRecord(record: RecordModel)
    fun getRecord(): RecordModel
}
