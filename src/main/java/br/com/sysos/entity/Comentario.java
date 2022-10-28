package br.com.sysos.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Setter
@Getter
@Entity
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "data_envio", nullable = false)
    private OffsetDateTime dataEnvio;

    @ManyToOne(fetch = FetchType.LAZY)
    private OrdemServico ordemServico;

}
