import kelmerdev.com.ejercicio_03.Game;
import kelmerdev.com.ejercicio_03.GameDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class modelMapperTest {

    private ModelMapper mapper;

    @BeforeEach
    public void setup() {
        this.mapper = new ModelMapper();
    }

    @Test
    public void whenMapGameWithExactMatch_thenConvertsToDTO() {
        // when similar source object is provided
        Game game = new Game(1L, "Game 1");
        GameDTO gameDTO = this.mapper.map(game, GameDTO.class);

        // then it maps by default
        assertEquals(game.getId(), gameDTO.getId());
        assertEquals(game.getName(), gameDTO.getName());
    }
}
