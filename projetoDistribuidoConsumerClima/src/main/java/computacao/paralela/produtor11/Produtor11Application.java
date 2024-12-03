package computacao.paralela.produtor11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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