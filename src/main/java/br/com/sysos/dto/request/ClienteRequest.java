package br.com.sysos.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ClienteRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nome;
    private String telefone;
    private String email;

}
