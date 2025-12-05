# Simon Dice - Gestión de Records con SharedPreferences

## 📋 Descripción del Proyecto

Este proyecto implementa un sistema robusto y persistente para la **gestión del mejor puntaje (record)** de la aplicación "Simon Dice". Utiliza la arquitectura de **patrón Repository** junto con **SharedPreferences** y la librería **Gson** para almacenar el record más alto alcanzado por el jugador, incluyendo la marca de tiempo exacta de cuándo se consiguió.

El objetivo es asegurar que el mejor puntaje se mantenga entre sesiones de la aplicación, proporcionando una persistencia de datos ligera y eficiente.

---

## 🎯 Funcionalidad del Sistema de Records

| Característica | Descripción |
| :--- | :--- |
| **Persistencia** | El record se mantiene guardado incluso al cerrar y reabrir la aplicación. |
| **Almacenamiento del Puntaje** | Guarda el número de **ronda más alta** alcanzada. |
| **Marca de Tiempo** | Almacena la **fecha y hora** precisas en que se batió el record. |


---

##  Arquitectura y Componentes Clave

El proyecto sigue el principio de **separación de preocupaciones** a través del patrón Repository:

### 1. `RecordModel.kt` - Modelo de Datos 💾

Define la estructura de datos inmutable para el record.

```kotlin
data class RecordModel(
    val timestamp: String, // Fecha y hora del record (ej: "2024-01-15T14:25:30")
    val round: Int         // Ronda más alta alcanzada
)
```

### 2. `RecordRepository.kt` - Contrato de Almacenamiento 

Define la **interfaz** o contrato para las operaciones de datos, logrando que el resto de la aplicación sea independiente de la fuente de datos subyacente (abstracción de la fuente de datos).

```kotlin
interface RecordRepository {
    /** Guarda un nuevo RecordModel. */
    fun saveRecord(record: RecordModel)
    
    /** Recupera el RecordModel almacenado. */
    fun getRecord(): RecordModel
}
```
