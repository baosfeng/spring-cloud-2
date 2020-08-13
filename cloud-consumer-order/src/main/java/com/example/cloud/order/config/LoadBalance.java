package com.example.cloud.order.config;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalance {

	ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
