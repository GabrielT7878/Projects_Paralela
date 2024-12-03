package computacao.paralela.produtor11;

import com.fasterxml.jackson.core.JsonProcessingException;
//import computacao.paralela.produtor11.consumer.CooperativaConsumer;
import computacao.paralela.produtor11.controller.ProducerController;
import computacao.paralela.produtor11.repository.CooperativaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Produtor11Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Produtor11Application.class, args);

        //ProducerController producerController = context.getBean(ProducerController.class);
        //CooperativaConsumer cooperativaConsumer = context.getBean(CooperativaConsumer.class);
        //MenuInterface menuInterface = new MenuInterface(producerController);
        //menuInterface.start();
    }
}