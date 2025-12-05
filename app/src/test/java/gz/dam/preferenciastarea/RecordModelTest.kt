package gz.dam.preferenciastarea

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDateTime

class RecordModelTest {

    @Test
    fun testCreateWithCurrentTime() {
        val round = 5
        val record = RecordModel.createWithCurrentTime(round)

        assertEquals(5, record.round)
        assert(record.timestamp.isNotEmpty())
    }

    @Test
    fun testDefault() {
        val defaultRecord = RecordModel.default()

        assertEquals(0, defaultRecord.round)
        assert(defaultRecord.timestamp.isNotEmpty())
    }

    @Test
    fun testDataClassProperties() {
        val timestamp = "2024-01-01T10:00:00"
        val round = 8
        val record = RecordModel(timestamp, round)

        assertEquals(timestamp, record.timestamp)
        assertEquals(round, record.round)
    }
}