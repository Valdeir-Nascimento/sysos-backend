package br.com.sysos.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrdemServico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "preco", nullable = false)
    private BigDecimal preco;

    @Column(name = "data_abertura", nullable = false)
    private OffsetDateTime dataAbertura;

    @Column(name = "data_finalizacao", nullable = false)
    private OffsetDateTime dataFinalizacao;

    @Enumerated(EnumType.STRING)
    private StatusOS status;

    @OneToMany(mappedBy = "ordemServico")
    private List<Comentario> comentarios  = new ArrayList<>();

}
