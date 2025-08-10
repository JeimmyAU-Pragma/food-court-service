package com.pragma.foodcourt.domain.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DomainConstants {
    public static final String ROLE_ADMIN = "ADMINISTRADOR";
    public static final String ROLE_OWNER = "PROPIETARIO";

    public static final String MESSAGE_ERROR_ADMIN =  "Solo un administrador puede crear restaurantes.";
    public static final String MESSAGE_ERROR_OWNER = "El usuario no tiene rol PROPIETARIO";
    public static final String INVALID_PHONE_NUMBER =  "Teléfono inválido";
    public static final String NIT_INVALID = "NIT debe ser numérico";
    public static  final String NAME_INVALID=   "el nombre no puede ser solo números";

}
