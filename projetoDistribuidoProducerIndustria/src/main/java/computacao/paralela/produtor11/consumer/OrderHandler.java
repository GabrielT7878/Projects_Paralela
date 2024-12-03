package computacao.paralela.produtor11.consumer;

import computacao.paralela.produtor11.dto.DadosProducao;
import computacao.paralela.produtor11.dto.Pedido;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Deprecated
public class OrderHandler {

    public void processOrder(List<DadosProducao> validOrders, Pedido pedido) {

        System.out.println("Printando os resultados");
        for (DadosProducao dadosProducao : validOrders) {
            System.out.println(dadosProducao);
        }


        return;
    }

    private DadosProducao findMinValidOrder(List<DadosProducao> validOrders, Pedido pedido) {
        DadosProducao minValidOrder = null;

        for(DadosProducao dadosProducao : validOrders) {
            if (minValidOrder != null){
                if (dadosProducao.getQuantidadeColhida() >= pedido.getQuantidade() &&
                        dadosProducao.getQuantidadeColhida() <= minValidOrder.getQuantidadeColhida())
                    minValidOrder = dadosProducao;
            }
            else {
                if (dadosProducao.getQuantidadeColhida() >= pedido.getQuantidade()) minValidOrder = dadosProducao;
            }
        }
        return minValidOrder;
    }
}
