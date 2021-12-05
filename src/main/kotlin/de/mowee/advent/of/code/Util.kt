package de.mowee.advent.of.code

import java.io.File

fun getResourceAsText(path: String): String {
    return File(ClassLoader.getSystemResource(path).file).readText()
}

fun String.toLines(): List<String> = trimIndent().lines()

fun String.textToNumberedList(): List<Int> {
    return toLines().mapNotNull { it.toIntOrNull() }
}
