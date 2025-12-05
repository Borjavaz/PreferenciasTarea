package gz.dam.preferenciastarea

// Interfaz para guardar/obtener récords (Patrón Repository)
// Ref: Android Guide to App Architecture
interface RecordRepository {
    fun saveRecord(record: RecordModel)
    fun getRecord(): RecordModel
}
