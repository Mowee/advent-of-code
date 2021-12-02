package de.mowee.advent.of.code

import java.io.File

fun getResourceAsText(path: String): String {
    return File(ClassLoader.getSystemResource(path).file).readText()
}
