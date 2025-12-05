package gz.dam.preferenciastarea

import org.junit.Assert.*
import org.junit.Test

class ControladorPreferenceTest {

    // Simulador simple de SharedPreferences
    class TestPreferences {
        private var ronda = 0
        private var timestamp = 0L

        fun guardar(record: Record) {
            ronda = record.ronda
            timestamp = record.timestamp
        }

        fun obtener(): Record {
            return if (timestamp == 0L) {
                Record.empty()
            } else {
                Record(ronda, timestamp)
            }
        }

        fun limpiar() {
            ronda = 0
            timestamp = 0L
        }
    }

    @Test
    fun testLogicaDeRecord() {
        val testPrefs = TestPreferences()

        // Test 1: Guardar y obtener
        val record1 = Record(ronda = 8, timestamp = 123456789L)
        testPrefs.guardar(record1)

        val obtenido1 = testPrefs.obtener()
        assertEquals(8, obtenido1.ronda)
        assertEquals(123456789L, obtenido1.timestamp)

        // Test 2: Obtener cuando está vacío
        testPrefs.limpiar()
        val obtenido2 = testPrefs.obtener()
        assertEquals(0, obtenido2.ronda)

        // Test 3: Guardar otro record
        val record2 = Record(ronda = 12, timestamp = 987654321L)
        testPrefs.guardar(record2)

        val obtenido3 = testPrefs.obtener()
        assertEquals(12, obtenido3.ronda)
        assertEquals(987654321L, obtenido3.timestamp)
    }

    @Test
    fun testRecordEmptyCuandoTimestampEsCero() {
        val testPrefs = TestPreferences()

        // Simular timestamp = 0 (no hay record guardado)
        testPrefs.guardar(Record(ronda = 0, timestamp = 0L))

        val record = testPrefs.obtener()
        assertEquals(0, record.ronda)
        // Debería crear un nuevo timestamp
        assertTrue(record.timestamp > 0)
    }
}