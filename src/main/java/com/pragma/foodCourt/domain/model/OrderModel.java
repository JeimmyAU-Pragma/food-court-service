package com.pragma.foodcourt.domain.model;

import java.time.LocalDateTime;
import java.util.List;


public class OrderModel {

    private Long id;
    private Long clientId;
    private Long restaurantId;
    private LocalDateTime date;
    private OrderStatus status;
    private List<ItemPedido> items;
}
