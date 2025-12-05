package gz.dam.preferenciastarea

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class GameStateTest {

    @Test
    fun `todos los estados existen y son instancias correctas`() {
        val inicio = GameState.Inicio
        val preparando = GameState.Preparando
        val mostrandoSecuencia = GameState.MostrandoSecuencia
        val esperandoJugador = GameState.EsperandoJugador
        val procesandoInput = GameState.ProcesandoInput
        val secuenciaCorrecta = GameState.SecuenciaCorrecta
        val gameOver = GameState.GameOver(5)

        assertTrue(inicio is GameState)
        assertTrue(preparando is GameState)
        assertTrue(mostrandoSecuencia is GameState)
        assertTrue(esperandoJugador is GameState)
        assertTrue(procesandoInput is GameState)
        assertTrue(secuenciaCorrecta is GameState)
        assertTrue(gameOver is GameState)
    }

    @Test
    fun `GameOver contiene rondaAlcanzada`() {
        val gameOver = GameState.GameOver(7)

        assertEquals(7, gameOver.rondaAlcanzada)
    }

    @Test
    fun `GameOver equals funciona correctamente`() {
        val gameOver1 = GameState.GameOver(5)
        val gameOver2 = GameState.GameOver(5)
        val gameOver3 = GameState.GameOver(10)

        assertEquals(gameOver1, gameOver2)
        assertNotEquals(gameOver1, gameOver3)
        assertNotEquals(gameOver1, GameState.Inicio)
    }

    @Test
    fun `GameOver toString contiene la ronda`() {
        val gameOver = GameState.GameOver(12)
        val str = gameOver.toString()

        assertTrue(str.contains("12"))
    }

    @Test
    fun `estados singleton son siempre la misma instancia`() {
        assertEquals(GameState.Inicio, GameState.Inicio)
        assertEquals(GameState.Preparando, GameState.Preparando)
        assertEquals(GameState.MostrandoSecuencia, GameState.MostrandoSecuencia)
        assertEquals(GameState.EsperandoJugador, GameState.EsperandoJugador)
        assertEquals(GameState.ProcesandoInput, GameState.ProcesandoInput)
        assertEquals(GameState.SecuenciaCorrecta, GameState.SecuenciaCorrecta)
    }
}