package xyz.bsfeng.stream.pdoducer.service.impl;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import xyz.bsfeng.stream.pdoducer.service.MessageProducerService;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 定义消息的推送管道
 *
 * @author bsfeng
 * @date 2021/4/1-11:20
 */
@EnableBinding(Source.class)
public class MessageProducerServiceImpl implements MessageProducerService {

	/**
	 * 消息发送管道
	 */
	@Resource
	private MessageChannel output;

	@Override
	public String send() {
		String serial = UUID.randomUUID().toString();
		output.send(MessageBuilder.withPayload(serial).build());
		System.out.println("*****serial: " + serial);
		return null;
	}
}
