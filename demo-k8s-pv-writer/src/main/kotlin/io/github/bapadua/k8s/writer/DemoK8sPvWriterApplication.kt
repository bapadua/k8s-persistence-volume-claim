package io.github.bapadua.k8s.writer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoK8sPvWriterApplication

fun main(args: Array<String>) {
	runApplication<DemoK8sPvWriterApplication>(*args)
}
