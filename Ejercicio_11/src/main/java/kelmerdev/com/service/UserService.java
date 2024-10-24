package kelmerdev.com.service;

import kelmerdev.com.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class UserService {
    private final String API_URL = "https://jsonplaceholder.typicode.com/users";

    private final RestClient restClient;

    public UserService(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl(API_URL)
                .build();
    }

    public List<User> getAllUsers() {
        User[] users = restClient.get()
                .retrieve()
                .body(User[].class);
        return List.of(users);
    }

    public User getUserById(Long id) {
        return restClient.get()
                .uri("/{id}", id)
                .retrieve()
                .body(User.class);
    }
}