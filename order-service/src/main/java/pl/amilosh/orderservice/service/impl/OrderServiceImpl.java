package pl.amilosh.orderservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.amilosh.orderservice.dto.OrderDto;
import pl.amilosh.orderservice.mapping.OrderMapper;
import pl.amilosh.orderservice.repository.OrderRepository;
import pl.amilosh.orderservice.service.OrderService;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    @Override
    public void createOrder(OrderDto orderDto) {
        var order = orderMapper.toEntity(orderDto);
        orderRepository.save(order);
    }
}
