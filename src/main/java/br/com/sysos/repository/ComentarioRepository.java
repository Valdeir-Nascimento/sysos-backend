package br.com.sysos.repository;

import br.com.sysos.entity.Comentario;
import br.com.sysos.entity.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
