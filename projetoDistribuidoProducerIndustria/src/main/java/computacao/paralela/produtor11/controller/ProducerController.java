package computacao.paralela.produtor11.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import computacao.paralela.produtor11.dto.DadosClima;
import computacao.paralela.produtor11.dto.DadosProducao;
import computacao.paralela.produtor11.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import computacao.paralela.produtor11.dto.Pedido;

@Controller
public class ProducerController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final ObjectMapper mapper = new ObjectMapper();

    @PostMapping("/sendDadosProducao")
    public ResponseEntity<String> sendAgricultureData(@RequestBody DadosProducao dadosProducao) throws JsonProcessingException {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_PRODUCAO, RabbitMQConfig.ROUTING_KEY_PRODUCAO, mapper.writeValueAsString(dadosProducao));
        return ResponseEntity.ok("Dados enviados com sucesso!");
    }

    @PostMapping("/sendDadosClima") // Define your endpoint for coffee order data
    public ResponseEntity<String> sendCoffeeOrderData(@RequestBody DadosClima dadosClima) throws JsonProcessingException {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_CLIMA, RabbitMQConfig.ROUTING_KEY_CLIMA, mapper.writeValueAsString(dadosClima));

        return ResponseEntity.ok("Dados de clima enviados com sucesso!");
    }
}