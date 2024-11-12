package kelmerdev.com.ejercicio_07;

import org.modelmapper.ModelMapper;

public class Main {
    public static void main(String[] args) {

        // 1: Crear una instancia de ModelMapper
        ModelMapper modelMapper = new ModelMapper();

        // 2: Configurar el mapeo personalizado
        modelMapper.typeMap(Empleado.class, EmpleadoDTO.class)
                .addMappings(mapper -> {
                    mapper.map(Empleado::getNombre, EmpleadoDTO::setNombreCompleto);
                    // Mapeo profundo usando source
                    mapper.map(src -> src.getDepartamento().getNombre(), EmpleadoDTO::setDepartamentoNombre);
                    mapper.map(src -> src.getDepartamento().getUbicacion(), EmpleadoDTO::setDepartamentoUbicacion);

                });


        // 3. Crear objetos de prueba
        Departamento departamento = new Departamento();
        departamento.setNombre("Departamento de Ingeniería");
        departamento.setUbicacion("Madrid");

        Empleado empleado = new Empleado();
        empleado.setNombre("Juan Perez");
        empleado.setDepartamento(departamento);

        // 4. Realizar el mapeo
        EmpleadoDTO empleadoDTO = modelMapper.map(empleado, EmpleadoDTO.class);

        // 5. Verificar resultados
        System.out.println("Nombre: " + empleadoDTO.getNombreCompleto());
        System.out.println("Departamento: " + empleadoDTO.getDepartamentoNombre());
        System.out.println("Ubicación: " + empleadoDTO.getDepartamentoUbicacion());

    }


}
