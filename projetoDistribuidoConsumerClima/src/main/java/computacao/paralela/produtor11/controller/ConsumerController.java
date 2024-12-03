package computacao.paralela.produtor11.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import computacao.paralela.produtor11.RabbitMQConfig;
import computacao.paralela.produtor11.dto.DadosClima;
import computacao.paralela.produtor11.repository.CooperativaRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ConsumerController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private CooperativaRepository cooperativaRepository;

    @RabbitListener(queues = {RabbitMQConfig.FILA_CLIMA})
    public void receiveMessageDados(@Payload Message message) throws JsonProcessingException {
        String payloadStr = message.getPayload().toString();
        DadosClima dadosClima = mapper.readValue(payloadStr, DadosClima.class);
        cooperativaRepository.save(dadosClima);
        System.out.println("Mensagem Recebida! \n" + message.getPayload());
    }

}