package hood.robin.smartmoney.controller;

import hood.robin.smartmoney.entity.Message;
import hood.robin.smartmoney.service.MessageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController extends BaseController<Message> {

    public MessageController(MessageService messageService) {
        super(messageService);
    }
}
