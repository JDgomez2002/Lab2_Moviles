/**
 * JOSE DANIEL GOMEZ CABRERA 21429
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * PROGRAMACION DE PLATAFORMAS MOVILES
 * Franciso Anzueto
 */

import org.junit.Test
import kotlin.test.*

// No tocar esta clase ---
data class ItemData(
    var originalPos: Int,
    var originalValue: Any?,
	var type: String? = null,
    var info: String? = null
)
// -----------------------

fun main() {
    val result = processList(listOf(25, "Hola!!!", null, true))   
}

//funcion processList
fun processList(inputList: List<Any?>?): List<ItemData>? {
    //Filtro para evitar error en ejecucion
    if (inputList == null) return null
    
    //Crear la lista de ItemData
	var myFinalList = ArrayList<ItemData>()
    
    //Crear variables para almacenar propiedades del objeto ItemData
    var objectPosition: Int = 0
    var objectOriginalValue: Any?
    var objectType: String? = null
    var objectInfo: String? = null
    
    
    for(n in inputList.indices){
        
        //Realizar proceso solo si el elemento no es null (ignora los nulls)
        if((inputList[n]!=null)){

            //Procedimiento----------------------
            
            //Asignar valor original tipo de dato:
            objectOriginalValue = inputList[n]
            
            //Evaluar tipo de dato
            when (inputList[n]) {
    			is Int -> {
                    objectType = "Entero"
                }
    			is String -> {
                    objectType = "Cadena"
                }
    			is Boolean -> {
                    objectType = "Booleano"
                }
    			else -> objectType = null
 			}
            
            //Evaluar Informacion del tipo de dato
            when (inputList[n]) {
    			is Int -> {
                    val myComparison: Int = inputList[n].toString().toInt()
                    val m10: Int = (myComparison%10)
                    val m5: Int = (myComparison%5)
                    val m2: Int = (myComparison%2)
                    //Hice los if, else if, else if con {} porque si no me daba error de compilacion
                    if(m10==0){
                        objectInfo = "M10"
                    }
                    else if (m5==0){
                        objectInfo = "M5"
                    }
                    else if (m2==0){
                        objectInfo = "M2"
                    }
                    else{
                        objectInfo = null
                    }
                }
    			is String -> {
                    val myComparison: String = inputList[n].toString()
                    val longitudCadena: Int = myComparison.length
                    objectInfo = ("L$longitudCadena")
                }
    			is Boolean -> {
                    val myComparison: Boolean = inputList[n].toString().toBoolean()
                    if(myComparison){
                        objectInfo = "Verdadero"
                    } 
                    else{
                        objectInfo = "Falso"
                    }
                }
    			else -> objectInfo = null
 			}
            
            //Crear Objeto ItemData 
            var newItem = ItemData(
			originalPos = objectPosition,
			originalValue = objectOriginalValue,
			type = objectType,
			info = objectInfo
			)
            //Agregar objeto a la lista de ItemData
    		myFinalList.add(newItem)
        }
        objectPosition += 1
    }
    
    return myFinalList
}
