package br.com.sysos.controller;

import br.com.sysos.dto.request.ClienteRequest;
import br.com.sysos.dto.response.ClienteResponse;
import br.com.sysos.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listar() {
        return ResponseEntity.ok().body(clienteService.listar());
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<ClienteResponse> buscarPorId(@PathVariable Long idCliente) {
        return ResponseEntity.ok().body(clienteService.buscarPorId(idCliente));
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> criar(@Valid @RequestBody ClienteRequest request) {
        ClienteResponse cliente = clienteService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @PutMapping("/{idCliente}")
    public ResponseEntity<ClienteResponse> editar(@PathVariable Long idCliente, @Valid @RequestBody ClienteRequest request) {
        ClienteResponse cliente = clienteService.editar(idCliente, request);
        return ResponseEntity.ok().body(cliente);
    }

    @DeleteMapping("/{idCliente}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long idCliente) {
        clienteService.excluir(idCliente);
    }

}
