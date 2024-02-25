package pl.amilosh.orderservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.amilosh.orderservice.dto.OrderDto;
import pl.amilosh.orderservice.service.OrderService;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name = "inventory")
    @Retry(name = "inventory")
    public ResponseEntity<Object> createOrder(@RequestBody OrderDto orderDto) {
        var createdOrder = orderService.createOrder(orderDto);
        return new ResponseEntity<>(createdOrder, CREATED);
    }

    public ResponseEntity<Object> fallbackMethod(OrderDto orderDto, RuntimeException ex) {
        return new ResponseEntity<>("Oops! Something went wrong, please order after some time 4!", SERVICE_UNAVAILABLE);
    }
}
