package gz.dam.preferenciastarea

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.ViewModel
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

class VMFactoryTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val expectedException = ExpectedException.none()

    @Test
    fun testCreateViewModel() {
        // Creamos una aplicación simple para testing
        val app = Application()
        val factory = VMFactory(app)

        val viewModel = factory.create(VM::class.java)

        assertTrue(viewModel is VM)
    }

    @Test
    fun testCreateWithWrongClassThrowsException() {
        // Configuramos la excepción esperada
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Unknown ViewModel class")

        val app = Application()
        val factory = VMFactory(app)

        // Esto debería lanzar IllegalArgumentException
        factory.create(ViewModel::class.java)
    }

    @Test
    fun testFactoryWithValidModelClass() {
        val app = Application()
        val factory = VMFactory(app)

        val viewModel = factory.create(VM::class.java)

        assertTrue(viewModel is VM)
        // Verificamos que no sea null
        assertTrue(viewModel != null)
    }
}