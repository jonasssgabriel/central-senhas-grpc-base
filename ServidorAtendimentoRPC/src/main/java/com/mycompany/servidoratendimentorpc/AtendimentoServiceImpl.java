package com.mycompany.servidoratendimentorpc;

import com.mycompany.atendimentorpc.AtendimentoServiceGrpc;
import com.mycompany.atendimentorpc.PedidoSenha;
import com.mycompany.atendimentorpc.Senha;
import com.mycompany.atendimentorpc.TipoAtendimento;
import io.grpc.stub.StreamObserver;

public class AtendimentoServiceImpl
        extends AtendimentoServiceGrpc.AtendimentoServiceImplBase {

    // Estado compartilhado: todos os totens usam o mesmo contador
    private int proximoNumero = 1;

    // synchronized: dois totens nunca recebem o mesmo número
    private synchronized int gerarNumero() {
        return proximoNumero++;
    }

    @Override
    public void pegarSenha(PedidoSenha req, StreamObserver<Senha> observador) {
        // ======================================================================
        // ACRESCENTE AQUI O QUE FOR DO SEU TRABALHO, ANTES DE NUMERAR.
        //
        // Exemplos do que outros trabalhos acrescentam exatamente neste ponto:
        //  - Trabalho 5 (falhas, deadline e validação): recusa nome vazio com
        //    Status.INVALID_ARGUMENT, e verifica Context.current().isCancelled()
        //    antes de numerar, para a Central parar quando o totem já desistiu.
        //  - Trabalho 3 (serviço de nomes): localiza a Central pelo nome antes
        //    de aceitar a chamada.
        //  - Trabalho 6 (evolução do contrato): valida campos novos do contrato.
        //
        // Se não acrescentar nada, o método continua funcionando exatamente
        // como no passo 5 da aula (slides 13-14).
        // ======================================================================

        int numero = gerarNumero();
        String prefixo = req.getTipo() == TipoAtendimento.PRIORITARIO
                ? "P" : "N";
        String codigo = String.format("%s-%03d", prefixo, numero);
        String mensagem = req.getNome() + ", sua senha é " + codigo
                + " (totem: " + req.getLocal() + ")";
        System.out.println("Senha " + codigo + " para " + req.getNome()
                + " no totem " + req.getLocal());
        Senha resposta = Senha.newBuilder()
                .setNumero(numero)
                .setCodigo(codigo)
                .setMensagem(mensagem)
                .build();
        observador.onNext(resposta);   // envia a resposta ao totem
        observador.onCompleted();      // encerra a chamada
    }
}
