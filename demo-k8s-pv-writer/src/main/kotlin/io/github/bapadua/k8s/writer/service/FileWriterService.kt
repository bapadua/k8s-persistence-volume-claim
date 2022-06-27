package io.github.bapadua.k8s.writer.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.io.File
import java.io.FileWriter
import java.util.UUID

private const val PATH = "/mnt/tmp"

@Service
class FileWriterService {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    fun createFile(content: String): String {
        logger.info("generating file")
        val fileName = getFileName()
        var fileWriter: FileWriter? = null
        val file: File?
        val filePath = "${PATH}/${fileName}"
        try {
            file = File(filePath)
            if (file.createNewFile()) {
                logger.info("file created $filePath")
            }
            fileWriter = FileWriter(file)
            fileWriter.write(content)
            logger.info("file created at $filePath")
        } catch (ex: Exception) {
            logger.error("failed creating file: error ${ex.message}")
            throw ex
        } finally {
            fileWriter?.close()
            logger.info("file generation finished")
        }

        return filePath
    }

    fun getFileName(): String {
        val uuid = UUID.randomUUID().toString()
        return "${uuid}.txt"
    }
}