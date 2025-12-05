package gz.dam.preferenciastarea

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

class RecordTest {

    @Test
    fun `constructor por defecto establece timestamp actual`() {
        val before = System.currentTimeMillis()
        val record = Record(ronda = 5)
        val after = System.currentTimeMillis()

        assertTrue("Timestamp debe estar entre before y after",
            record.timestamp in before..after)
        assertEquals(5, record.ronda)
    }

    @Test
    fun `constructor con timestamp personalizado`() {
        val timestamp = 1234567890123L
        val record = Record(ronda = 10, timestamp = timestamp)

        assertEquals(10, record.ronda)
        assertEquals(timestamp, record.timestamp)
    }

    @Test
    fun `empty() crea record vacio`() {
        val emptyRecord = Record.empty()

        assertEquals(0, emptyRecord.ronda)
        // El timestamp debe ser el actual o muy cercano
        val currentTime = System.currentTimeMillis()
        assertTrue("Timestamp debe ser reciente",
            currentTime - emptyRecord.timestamp < 1000)
    }

    @Test
    fun `getFechaFormateada retorna fecha formateada correctamente`() {
        // Usamos un timestamp conocido: 01/01/2020 12:00
        val timestamp = 1577872800000L // 01/01/2020 12:00 UTC
        val record = Record(ronda = 5, timestamp = timestamp)

        val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
        val expected = formatter.format(Date(timestamp))

        assertEquals(expected, record.getFechaFormateada())
    }

    @Test
    fun `equals y hashCode funcionan correctamente`() {
        val record1 = Record(ronda = 5, timestamp = 1000L)
        val record2 = Record(ronda = 5, timestamp = 1000L)
        val record3 = Record(ronda = 10, timestamp = 1000L)
        val record4 = Record(ronda = 5, timestamp = 2000L)

        assertEquals(record1, record2)
        assertEquals(record1.hashCode(), record2.hashCode())
        assertNotEquals(record1, record3)
        assertNotEquals(record1, record4)
    }

    @Test
    fun `toString contiene ronda y timestamp`() {
        val record = Record(ronda = 7, timestamp = 123456789L)
        val str = record.toString()

        assertTrue(str.contains("7"))
        assertTrue(str.contains("123456789"))
    }
}