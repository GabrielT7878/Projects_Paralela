//package computacao.paralela.produtor11.consumer;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import computacao.paralela.produtor11.RabbitMQConfig;
//import computacao.paralela.produtor11.dto.Dados;
//import computacao.paralela.produtor11.dto.Pedido;
//import computacao.paralela.produtor11.repository.CooperativaRepository;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class CooperativaConsumer {
//
//    @Autowired
//    private CooperativaRepository cooperativaRepository;
//
//    @Setter
//    @Getter
//    private Integer cooperativaId;
//
//    private final ObjectMapper mapper = new ObjectMapper();
//
//    @RabbitListener(queues = {RabbitMQConfig.FILA_PRODUCAO})
//    public void receiveMessageDados(@Payload Message message) throws JsonProcessingException {
//        String payloadStr = message.getPayload().toString();
//        Dados dados = mapper.readValue(payloadStr, Dados.class);
//        cooperativaRepository.save(dados);
//        System.out.println("Mensagem Recebida! \n" + message.getPayload());
//    }
//
////    @RabbitListener(queues = {RabbitMQConfig.FILA_VENDAS})
////    public void receiveMessageVendas(@Payload Message message) throws JsonProcessingException {
////        String payloadStr = message.getPayload().toString();
////        Pedido pedido = mapper.readValue(payloadStr, Pedido.class);
////        List<Dados> validOrders = cooperativaRepository.findValidOrder(pedido.getTipoCafe(),this.cooperativaId);
////        System.out.println("Printando os pedidos disponíveis na cooperativa atual:");
////        for (Dados dados : validOrders) {
////            System.out.println(dados);
////        }
////        System.out.println("Printando os pedidos encontrados em outras cooperativas:");
////        //System.out.println("Mensagem Recebida! \n" + message.getPayload());
////
////    }
//}
