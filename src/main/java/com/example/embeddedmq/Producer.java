package com.example.embeddedmq;

import com.google.gson.Gson;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/produce")
public class Producer {




    private String queue = "artemisQueue";

    Gson gson = new Gson();
    String msg;


    @GetMapping("/{message}")
    public String produce(@PathVariable("message") final String message){

        JmsTemplate template = new JmsTemplate(new ActiveMQConnectionFactory("tcp://0.0.0.0:61616"));
        template.convertAndSend(queue,message);

        return "published successfully";

    }

    @PostMapping("/send")
    public String produce(@RequestBody Person person){

        msg = gson.toJson(person);

        JmsTemplate template = new JmsTemplate(new ActiveMQConnectionFactory("tcp://0.0.0.0:61616"));
        template.convertAndSend(queue,msg);

        return "published successfully";

    }

}
