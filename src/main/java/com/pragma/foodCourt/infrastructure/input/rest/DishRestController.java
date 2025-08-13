package com.pragma.foodcourt.infrastructure.input.rest;

import com.pragma.foodcourt.application.dto.request.DishRequestDto;
import com.pragma.foodcourt.application.dto.request.DishUpdateRequestDto;
import com.pragma.foodcourt.application.dto.response.DishResponseDto;
import com.pragma.foodcourt.application.handler.IDishHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Dish")
@RequiredArgsConstructor
public class DishRestController {

    private final IDishHandler dishHandler;

    @Operation(summary = "Add a new dish")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Dish created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Dish already exists", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<Void> saveDish(@RequestBody DishRequestDto dishRequestDto) {
       dishHandler.saveDish(dishRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    @Operation(summary = "Update Dishes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All dishes update"),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @PutMapping("/{idDish}")
    public ResponseEntity<Void> updateDishes(
            @PathVariable("idDish") Long dishId,
            @RequestParam("ownerId") Long ownerId,
            @RequestBody DishUpdateRequestDto request) {

        dishHandler.updateDish(dishId, ownerId, request);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "list dishes by restaurant")
    @GetMapping("/restaurants/{restaurantId}/dishes")
    public ResponseEntity<Page<DishResponseDto>> listDishesByRestaurant(
            @PathVariable Long restaurantId,
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "10") @Min(1) int size,
            @RequestParam(required = false) Long categoryId
    ) {
        Page<DishResponseDto> result = dishHandler.listDishes(restaurantId, page, size, categoryId);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "list all Dishes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All objects returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = DishResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<DishResponseDto>> getAllObjects() {
        return ResponseEntity.ok(dishHandler.getAllDishes());
    }
}