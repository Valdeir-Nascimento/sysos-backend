package br.com.sysos.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ClienteResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String nome;
    private String telefone;
    private String email;

}
