package computacao.paralela.produtor11.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import computacao.paralela.produtor11.dto.Dados;
import computacao.paralela.produtor11.RabbitMQConfig;
import computacao.paralela.produtor11.repository.CooperativaRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class ConsumerController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private CooperativaRepository cooperativaRepository;

    @RabbitListener(queues = {RabbitMQConfig.FILA_PRODUCAO})
    public void receiveMessageDados(@Payload Message message) throws JsonProcessingException {
        String payloadStr = message.getPayload().toString();
        Dados dados = mapper.readValue(payloadStr, Dados.class);
        cooperativaRepository.save(dados);
        System.out.println("Mensagem Recebida! \n" + message.getPayload());
    }

//    @PostMapping("/sendCoffeeOrderData") // Define your endpoint for coffee order data
//    public ResponseEntity<String> sendCoffeeOrderData(@RequestBody Pedido pedido) throws JsonProcessingException {
//        // Envia dados de venda de café para RabbitMQ
//        //System.out.println("Dados de venda de café a serem enviados");
//        //System.out.println(mapper.writeValueAsString(pedido));
//        // Use appropriate exchange and routing key for coffee orders
//        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_PRODUCAO, RabbitMQConfig.ROUTING_KEY_VENDAS, mapper.writeValueAsString(pedido));
//
//        return ResponseEntity.ok("Dados da venda de café enviados com sucesso!");
//    }
}