package com.kelmerdev.ui;

import com.kelmerdev.model.Producto;
import com.kelmerdev.service.ProductoService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class ProductoView extends VerticalLayout {

    private final ProductoService productoService;
    private final Grid<Producto> grid = new Grid<>(Producto.class);
    private final TextField nombreField = new TextField("Nombre");
    private final TextField precioField = new TextField("Precio");
    private final Button saveButton = new Button("Guardar");
    private final Button deleteButton = new Button("Eliminar");

    public ProductoView(ProductoService productoService) {
        this.productoService = productoService;

        grid.setColumns("id", "nombre", "precio");

        saveButton.addClickListener(event -> saveProducto());
        deleteButton.addClickListener(event -> deleteProducto());

        HorizontalLayout formLayout = new HorizontalLayout(nombreField, precioField, saveButton, deleteButton);
        add(grid, formLayout);

        updateGrid();
    }

    private void saveProducto() {
        try {
            Producto producto = new Producto();
            producto.setNombre(nombreField.getValue());
            producto.setPrecio(Double.parseDouble(precioField.getValue()));
            productoService.save(producto);
            updateGrid();
            Notification.show("Producto guardado");
        } catch (NumberFormatException e) {
            Notification.show("Precio inválido");
        }
    }

    private void deleteProducto() {
        Producto producto = grid.asSingleSelect().getValue();
        if (producto != null) {
            productoService.deleteById(producto.getId());
            updateGrid();
            Notification.show("Producto eliminado");
        } else {
            Notification.show("Selecciona un producto");
        }
    }

    private void updateGrid() {
        grid.setItems(productoService.findAll());
    }
}
