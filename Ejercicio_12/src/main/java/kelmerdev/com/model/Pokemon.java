package kelmerdev.com.model;

import lombok.Data;

import java.util.List;

@Data
public class Pokemon {
    private Long id;
    private String name;
    private Integer height;
    private Integer weight;
    private List<PokemonType> types;
    private Sprites sprites;
    private List<Ability> abilities;
}
