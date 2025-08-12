package com.pragma.foodcourt.domain.util;

public class DomainConstants {
    public DomainConstants() {
    }

    public static final String ROLE_ADMIN = "ADMINISTRADOR";
    public static final String ROLE_OWNER = "PROPIETARIO";

    public static final String MESSAGE_ERROR_ADMIN =  "Solo un administrador puede crear restaurantes.";
    public static final String MESSAGE_ERROR_OWNER = "El usuario no tiene rol PROPIETARIO";
    public static final String INVALID_PHONE_NUMBER =  "Teléfono inválido";
    public static final String NIT_INVALID = "NIT debe ser numérico";
    public static  final String NAME_INVALID=   "el nombre no puede ser solo números";


    public static final String DISH_NOT_FOUND = "El plato no existe.";
    public static final String OWNER_NOT_ALLOWED = "Solo el propietario del restaurante puede actualizar el plato.";
    public static final String DISH_PRICE_REQUIRED = "El precio es obligatorio.";
    public static final String DISH_PRICE_POSITIVE = "El precio debe ser un entero positivo mayor a 0.";
    public static final String DISH_DESCRIPTION_REQUIRED = "La descripción es obligatoria.";
}
