package hse.btf.pdfeditor.models.serializers

import hse.btf.pdfeditor.Singleton.itemsHolder
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

private val format = Json { encodeDefaults = true }

fun saveToFile(fileName: String?): Unit {
    // opening vs creating file and (over)writing information to it
    val filePath = fileName ?: ("./src/main/kotlin/hse/btf/pdfeditor/datasaving" + "dataFile.json")
    val file = File(filePath)

    // getting Json string
    val json = format.encodeToString(itemsHolder.observableItemsList.toList())
    file.writeText(json)
}

fun readFromFile(fileName: String?): Unit {
    val filePath = fileName ?: ("./src/main/kotlin/hse/btf/pdfeditor/datasaving" + "dataFile.json")
    val file = File(filePath)

    val fileData = file.readText()
    itemsHolder.updateFromFileData(fileData)
}