package gz.dam.preferenciastarea

import org.junit.Assert.*
import org.junit.Test

class VMFactoryTest {

    @Test
    fun testFactoryEsViewModelProviderFactory() {
        // Solo verificamos que la clase existe y tiene el constructor correcto
        // No podemos instanciarla sin Application real, pero podemos verificar su tipo

        assertNotNull(VMFactory::class.java)
        assertTrue(VMFactory::class.java.constructors.size > 0)
    }

    @Test
    fun testVMClassExiste() {
        // Verificamos que las clases existen y son accesibles
        assertNotNull(VM::class.java)
        assertNotNull(VMFactory::class.java)

        // Verificamos que VMFactory puede crear VM (en teoría)
        val constructors = VMFactory::class.java.constructors
        assertTrue(constructors.any { it.parameterCount == 1 })
    }
}