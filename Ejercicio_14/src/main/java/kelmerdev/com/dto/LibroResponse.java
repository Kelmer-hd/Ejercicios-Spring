package kelmerdev.com.dto;


import kelmerdev.com.model.StatusLibro;
import lombok.Data;

@Data
public class LibroResponse {
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private Integer yearPublished;
    private Integer copiesAvailable;
    private StatusLibro status;
}
