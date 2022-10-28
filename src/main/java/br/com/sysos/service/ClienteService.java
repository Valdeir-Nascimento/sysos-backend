package br.com.sysos.service;

import br.com.sysos.dto.mapper.ClienteDTOMapper;
import br.com.sysos.dto.request.ClienteRequest;
import br.com.sysos.dto.response.ClienteResponse;
import br.com.sysos.entity.Cliente;
import br.com.sysos.exception.ClienteNaoEncontradoException;
import br.com.sysos.repository.ClienteRepository;
import br.com.sysos.util.ResourceUriUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<ClienteResponse> listar() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ClienteDTOMapper.converter(clientes);
    }

    public ClienteResponse criar(ClienteRequest request) {
        Cliente cliente = ClienteDTOMapper.converter(request);
        cliente = clienteRepository.save(cliente);
        ResourceUriUtil.addUriInResponseHeader(cliente.getId()); //Adiciona no header da requisição o recurso que foi criado
        return ClienteDTOMapper.converter(cliente);
    }

    public ClienteResponse buscarPorId(Long idCliente) {
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        if (cliente.isEmpty()) {
            throw new ClienteNaoEncontradoException(idCliente);
        }
        return ClienteDTOMapper.converter(cliente.get());
    }

    public ClienteResponse editar(Long idCliente, ClienteRequest request) {
        ClienteResponse clienteEncontrado = buscarPorId(idCliente);
        Cliente cliente = ClienteDTOMapper.converter(clienteEncontrado);
        ClienteDTOMapper.copyToProperties(request, cliente);
        cliente = clienteRepository.save(cliente);
        return ClienteDTOMapper.converter(cliente);
    }

    public void excluir(Long idCliente) {
        try {
            clienteRepository.deleteById(idCliente);
        } catch (EmptyResultDataAccessException ex) {
            throw new ClienteNaoEncontradoException(idCliente);
        }
    }

}
