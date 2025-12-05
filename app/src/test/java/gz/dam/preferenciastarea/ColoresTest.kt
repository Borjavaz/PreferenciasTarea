package gz.dam.preferenciastarea

import androidx.compose.ui.graphics.Color
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class ColoresTest {

    @Test
    fun testColoresValues() {
        assertEquals(0, Colores.ROJO.colorInt)
        assertEquals(1, Colores.VERDE.colorInt)
        assertEquals(2, Colores.AZUL.colorInt)
        assertEquals(3, Colores.AMARILLO.colorInt)

        assertEquals("ROJO", Colores.ROJO.nombre)
        assertEquals("Mi", Colores.ROJO.tono)
    }

    @Test
    fun testColoresEnum() {
        val todosColores = Colores.values()

        assertEquals(4, todosColores.size)
        assertEquals(Colores.ROJO, todosColores[0])
        assertEquals(Colores.VERDE, todosColores[1])
        assertEquals(Colores.AZUL, todosColores[2])
        assertEquals(Colores.AMARILLO, todosColores[3])
    }

    @Test
    fun testBaseColorReturnsColor() {
        // Solo verificamos que no retorna el color por defecto
        assertNotEquals(Color.Unspecified, Colores.ROJO.baseColor())
        assertNotEquals(Color.Unspecified, Colores.VERDE.baseColor())
    }

    @Test
    fun testColorOscurecidoReturnsColor() {
        assertNotEquals(Color.Unspecified, Colores.ROJO.colorOscurecido())
        assertNotEquals(Color.Unspecified, Colores.VERDE.colorOscurecido())
    }
}