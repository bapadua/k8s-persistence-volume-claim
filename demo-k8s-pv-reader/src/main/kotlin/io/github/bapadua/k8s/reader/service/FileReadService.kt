package io.github.bapadua.k8s.reader.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.io.File
import java.util.Scanner

@Service
class FileReadService {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    fun read(path: String): String {
        logger.info("reading file content from $path")
        var reader: Scanner? = null;
        try {
            val content = StringBuffer()
            val file = File(path)
            reader = Scanner(file)
            while (reader.hasNextLine()) {
                content.append(reader.nextLine())
            }
            return content.toString()
        } catch (ex: Exception) {
            logger.error("failed reading file:  ex=${ex.message}")
            ex.printStackTrace()
        } finally {
            logger.info("closing file reader...")
            reader?.close()
        }
       throw Exception("failed to read/parse file")
    }
}