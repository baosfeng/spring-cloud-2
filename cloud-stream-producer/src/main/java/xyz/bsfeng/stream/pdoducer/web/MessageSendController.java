package xyz.bsfeng.stream.pdoducer.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.bsfeng.stream.pdoducer.service.MessageProducerService;

import javax.annotation.Resource;

/**
 * @author bsfeng
 * @date 2021/4/1-11:22
 */
@RestController
@RequestMapping("/stream")
public class MessageSendController {

	/**
	 * 自动注入
	 */
	@Resource
	private MessageProducerService messageProvider;

	@GetMapping(value = "/sendMessage")
	public String sendMessage() {
		return messageProvider.send();
	}

}
