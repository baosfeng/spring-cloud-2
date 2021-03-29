package com.example.cloud.order.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author bsfeng
 */
@Slf4j
@Component
public class MyLoadBalance implements LoadBalance {

	private final AtomicInteger atomicInteger = new AtomicInteger(0);

	int getNext() {
		int current = atomicInteger.get();
		int next = current > Integer.MAX_VALUE - 1 ? 0 : current + 1;
		log.info("正在进行第{}次访问", next);
		for (; ; ) {
			if (atomicInteger.compareAndSet(next, atomicInteger.incrementAndGet())) return next;
		}

	}

	@Override
	public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
		if (serviceInstances != null && serviceInstances.size() == 0) {
			return null;
		}
		int index = getNext() % serviceInstances.size();
		return serviceInstances.get(index);
	}
}
