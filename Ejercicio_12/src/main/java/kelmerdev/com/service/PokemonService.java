package kelmerdev.com.service;

import kelmerdev.com.model.Pokemon;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class PokemonService {
    private final String API_URL = "https://pokeapi.co/api/v2/";

    private final RestClient restClient;

    public PokemonService(RestClient.Builder builder){
        this.restClient = builder
                .baseUrl(API_URL)
                .build();
    }

    public Page<Pokemon> paginate(Pageable pageable) {

    }
}
