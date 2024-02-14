package pl.amilosh.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.amilosh.orderservice.dto.OrderDto;
import pl.amilosh.orderservice.service.OrderService;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(CREATED)
    public String createOrder(@RequestBody OrderDto orderDto) {
        orderService.createOrder(orderDto);
        return "Order have been created successfully.";
    }
}
