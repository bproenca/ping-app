package com.github.bproenca.pingapp;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPing {

	private final AtomicLong counter = new AtomicLong();
    private Logger log = LoggerFactory.getLogger(ControllerPing.class);

	@GetMapping("/ping")
	public String ping(@RequestParam(value = "name", defaultValue = "World") String name) {
        String retorno = String.format(">> PONG | Counter %d | Hello, %s!", counter.incrementAndGet(), name);
        log.info(retorno);
        return retorno;
	}

    @GetMapping("/terminate/{code}")
	public void terminate(@PathVariable int code) {
        log.info(">> System exit with code {}", code);
        System.exit(code);
	}
}