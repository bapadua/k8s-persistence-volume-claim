package io.github.bapadua.k8s.reader.controller

import io.github.bapadua.k8s.reader.service.FileReadService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.websocket.server.PathParam

@RestController
@RequestMapping(path = ["/test"])
class TestController(private val fileReadService: FileReadService) {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping(path = ["/file"])
    fun readFileFromPersistentVolume(@PathParam("path") path: String): ResponseEntity<String> {
        logger.info("searching file $path")
        return ResponseEntity.ok(fileReadService.read(path))
    }
}