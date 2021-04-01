package xyz.bsfeng;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bsfeng
 * @date 2021/4/1-11:40
 */
@RestController
@EnableBinding(Sink.class)
public class ConsumerController {

	@StreamListener(Sink.INPUT)
	public void listen(String message) {
		System.out.println("接收到的消息:" + message);
	}
}
