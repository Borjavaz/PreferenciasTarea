package gz.dam.preferenciastarea

import org.junit.Test

class RecordRepositoryTest {

    @Test
    fun testRepositoryInterfaceContracts() {
        val mockRepository = object : RecordRepository {
            private var testRecord = RecordModel.default()

            override fun saveRecord(record: RecordModel) {
                testRecord = record
            }

            override fun getRecord(): RecordModel {
                return testRecord
            }
        }

        val testRecord = RecordModel("2024-01-01T12:00:00", 20)

        mockRepository.saveRecord(testRecord)
        val retrieved = mockRepository.getRecord()

        assert(testRecord.timestamp == retrieved.timestamp)
        assert(testRecord.round == retrieved.round)
    }
}