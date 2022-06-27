package io.github.bapadua.k8s.writer.controller

import io.github.bapadua.k8s.writer.service.FileWriterService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/test"])
class FileWriterController(private val fileWriterService: FileWriterService) {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping(path = ["/file"])
    fun saveFile(@RequestBody content: String): ResponseEntity<String> {
        logger.info("new file request received")
        return ResponseEntity.ok(fileWriterService.createFile(content))
    }
}