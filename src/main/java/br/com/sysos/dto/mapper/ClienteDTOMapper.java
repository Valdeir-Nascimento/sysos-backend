package br.com.sysos.dto.mapper;

import br.com.sysos.dto.request.ClienteRequest;
import br.com.sysos.dto.response.ClienteResponse;
import br.com.sysos.entity.Cliente;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteDTOMapper {

    private static final ModelMapper mapper = new ModelMapper();

    public static ClienteResponse converter(Cliente cliente) {
        return mapper.map(cliente, ClienteResponse.class);
    }

    public static Cliente converter(ClienteRequest request) {
        return mapper.map(request, Cliente.class);
    }

    public static Cliente converter(ClienteResponse response) {
        return mapper.map(response, Cliente.class);
    }

    public static List<ClienteResponse> converter(List<Cliente> clientes) {
        return clientes.stream().map(ClienteDTOMapper::converter).collect(Collectors.toList());
    }

    public static void copyToProperties(ClienteRequest request, Cliente cliente) {
        mapper.map(request, cliente);
    }

}
