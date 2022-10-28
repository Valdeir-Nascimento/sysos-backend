package br.com.sysos.exception;

public class ClienteNaoEncontradoException extends EntidadeNaoEncontradaException {

    public ClienteNaoEncontradoException(String message) {
        super(message);
    }

    public ClienteNaoEncontradoException(Long id) {
        this(String.format("Não existe registro de cliente com id: %d", id));
    }
}
