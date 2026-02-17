package com.paulo.neto.sampleapp.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulo.neto.sampleapp.domain.usecase.NewOrderUseCase;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class OrderController {

	private final NewOrderUseCase useCase;

	@GetMapping("/health") public Map<String, String> health() {
		return Map.of("status", "ok");
	}

	@PostMapping("/orders")
	public Map<String, Object> createOrder(@RequestBody Map<String, Object> payload) {
		useCase.newOrder(payload);
		return Map.of("result", "ok");
	}
}