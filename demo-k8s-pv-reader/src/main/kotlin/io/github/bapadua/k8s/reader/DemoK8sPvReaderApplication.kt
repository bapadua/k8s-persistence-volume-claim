package io.github.bapadua.k8s.reader

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoK8sPvReaderApplication

fun main(args: Array<String>) {
	runApplication<DemoK8sPvReaderApplication>(*args)
}
