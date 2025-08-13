package com.pragma.foodcourt.domain.usecase;


import com.pragma.foodcourt.application.dto.request.DishUpdateRequestDto;
import com.pragma.foodcourt.domain.exception.DomainException;
import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.model.CategoryModel;
import com.pragma.foodcourt.domain.model.Restaurant;
import com.pragma.foodcourt.domain.spi.IDishPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static com.pragma.foodcourt.domain.util.DomainConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DishUseCaseTest {

    @Mock
    private IDishPersistencePort dishPort;

    @InjectMocks
    private DishUseCase useCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void save_ok() {
        DishModel d = validDish();

        useCase.saveDish(d);

        assertTrue(Boolean.TRUE.equals(d.getActive()), "active should be true");
        verify(dishPort).saveDish(d);
    }


    @Test
    void save_nameNull() {
        DishModel d = validDish();
        d.setName(null);
        DomainException ex = assertThrows(DomainException.class, () -> useCase.saveDish(d));
        assertEquals(DISH_NAME_REQUIRED, ex.getMessage());
        verifyNoInteractions(dishPort);
    }

    @Test
    void save_nameBlank() {
        DishModel d = validDish();
        d.setName("   ");
        DomainException ex = assertThrows(DomainException.class, () -> useCase.saveDish(d));
        assertEquals(DISH_NAME_REQUIRED, ex.getMessage());
        verifyNoInteractions(dishPort);
    }

    @Test
    void save_priceNull() {
        DishModel d = validDish();
        d.setPrice(null);
        DomainException ex = assertThrows(DomainException.class, () -> useCase.saveDish(d));
        assertEquals(DISH_PRICE_INVALID, ex.getMessage());
        verifyNoInteractions(dishPort);
    }

    @Test
    void save_priceZero() {
        DishModel d = validDish();
        d.setPrice(0L);
        DomainException ex = assertThrows(DomainException.class, () -> useCase.saveDish(d));
        assertEquals(DISH_PRICE_INVALID, ex.getMessage());
        verifyNoInteractions(dishPort);
    }

    @Test
    void save_descNull() {
        DishModel d = validDish();
        d.setDescription(null);
        DomainException ex = assertThrows(DomainException.class, () -> useCase.saveDish(d));
        assertEquals(DISH_DESCRIPTION_REQUIRED, ex.getMessage());
        verifyNoInteractions(dishPort);
    }

    @Test
    void save_descBlank() {
        DishModel d = validDish();
        d.setDescription("   ");
        DomainException ex = assertThrows(DomainException.class, () -> useCase.saveDish(d));
        assertEquals(DISH_DESCRIPTION_REQUIRED, ex.getMessage());
        verifyNoInteractions(dishPort);
    }

    @Test
    void save_imgNull() {
        DishModel d = validDish();
        d.setUrlImage(null);
        DomainException ex = assertThrows(DomainException.class, () -> useCase.saveDish(d));
        assertEquals(DISH_IMAGE_URL_REQUIRED, ex.getMessage());
        verifyNoInteractions(dishPort);
    }

    @Test
    void save_imgBlank() {
        DishModel d = validDish();
        d.setUrlImage("   ");
        DomainException ex = assertThrows(DomainException.class, () -> useCase.saveDish(d));
        assertEquals(DISH_IMAGE_URL_REQUIRED, ex.getMessage());
        verifyNoInteractions(dishPort);
    }

    @Test
    void save_categoryIdNull() {
        DishModel d = validDish();
        d.setCategory(new CategoryModel((Long) null));
        DomainException ex = assertThrows(DomainException.class, () -> useCase.saveDish(d));
        assertEquals(DISH_CATEGORY_REQUIRED, ex.getMessage());
        verifyNoInteractions(dishPort);
    }

    @Test
    void save_restaurantIdNull() {
        DishModel d = validDish();
        Restaurant r = new Restaurant();
        r.setId(null);
        d.setRestaurant(r);
        DomainException ex = assertThrows(DomainException.class, () -> useCase.saveDish(d));
        assertEquals(DISH_RESTAURANT_ID_REQUIRED, ex.getMessage());
        verifyNoInteractions(dishPort);
    }


    @Test
    void getAll_ok() {
        List<DishModel> data = List.of(validDish(), validDish());
        when(dishPort.getAllDishes()).thenReturn(data);

        List<DishModel> out = useCase.getAllDishes();

        assertEquals(2, out.size());
        verify(dishPort).getAllDishes();
    }


    @Test
    void getById_ok() {
        DishModel d = validDish();
        when(dishPort.getDishById(5L)).thenReturn(d);

        DishModel out = useCase.getDishById(5L);

        assertSame(d, out);
        verify(dishPort).getDishById(5L);
    }

    @Test
    void update_ok() {
        DishModel stored = validDish();
        stored.setPrice(1000L);
        stored.setDescription("old");

        when(dishPort.getDishById(1L)).thenReturn(stored);

        DishUpdateRequestDto req = new DishUpdateRequestDto();
        req.setPrice(2500L);
        req.setDescription("new");

        useCase.updateDish(1L, 99L, req);

        assertEquals(2500L, stored.getPrice());
        assertEquals("new", stored.getDescription());

        ArgumentCaptor<DishModel> captor = ArgumentCaptor.forClass(DishModel.class);
        verify(dishPort).updateDish(captor.capture());
        assertSame(stored, captor.getValue());
    }


    private DishModel validDish() {
        DishModel d = new DishModel();
        d.setName("Arepa");
        d.setPrice(12000L);
        d.setDescription("Corn cake");
        d.setUrlImage("http://img/arepa.png");
        d.setCategory(new CategoryModel(1L));
        Restaurant r = new Restaurant();
        r.setId(10L);
        d.setRestaurant(r);
        return d;
    }
}
