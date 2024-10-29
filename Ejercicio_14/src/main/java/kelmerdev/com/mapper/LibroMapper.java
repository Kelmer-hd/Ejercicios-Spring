package kelmerdev.com.mapper;

import kelmerdev.com.dto.LibroRequest;
import kelmerdev.com.dto.LibroResponse;
import kelmerdev.com.model.Libro;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibroMapper {

    private final ModelMapper modelMapper;

    public LibroMapper(ModelMapper modelMapper){
        this.modelMapper=modelMapper;
    }

    public Libro libroRequestToLibro (LibroRequest request){
        return modelMapper.map(request, Libro.class);
    }

    public LibroResponse libroToLibroResponse (Libro libro){
        return modelMapper.map(libro, LibroResponse.class);
    }


    public List<Libro> libroRequestListToLibroList (List<LibroRequest> requests){
        return requests.stream()
                .map(this::libroRequestToLibro)
                .toList();
    }

    public List<LibroResponse> libroListToLibroResponseList (List<Libro> libros){
        return libros.stream()
                .map(this::libroToLibroResponse)
                .toList();
    }

}
