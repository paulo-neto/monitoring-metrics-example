package com.paulo.neto.sampleapp.domain.usecase;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class NewOrderUseCase {

	private final JdbcTemplate jdbc;

	private final JmsTemplate jms;

	@Transactional
	public void newOrder(Map<String, Object> order) {

		jdbc.update("insert into orders(id,info) values(nextval('orders_seq'), ?)", order.toString());
		jms.convertAndSend("orders.queue", order.toString());
	}
}
