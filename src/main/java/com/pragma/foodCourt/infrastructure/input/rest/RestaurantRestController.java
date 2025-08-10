package com.pragma.foodcourt.infrastructure.input.rest;

import com.pragma.foodcourt.application.dto.request.RestaurantRequestDto;
import com.pragma.foodcourt.application.dto.response.RestaurantResponseDto;
import com.pragma.foodcourt.application.handler.IRestaurantHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Restaurant")
@RequiredArgsConstructor
public class RestaurantRestController {

    private final IRestaurantHandler restaurantHandler;

    @Operation(summary = "Add a new Restaurant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Restaurant created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Restaurant already exists", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<Void> saveRestaurant(@RequestBody RestaurantRequestDto restaurantRequestDto) {
        restaurantHandler.saveRestaurant(restaurantRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all Restaurants")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All objects returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = RestaurantResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<RestaurantResponseDto>> getAllObjects() {
        return ResponseEntity.ok(restaurantHandler.getAllRestaurants());
    }


//    @Operation(summary = "Validate Owner of Restaurant")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "All objects returned",
//                    content = @Content(mediaType = "application/json",
//                            array = @ArraySchema(schema = @Schema(implementation = RestaurantResponseDto.class)))),
//            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
//    })
//    @GetMapping("/{idRestaurant}/owner/{idOwner}")
//    public ResponseEntity<Boolean> isOwner(@PathVariable Long idRestaurant, @PathVariable Long idOwner) {
//        return ResponseEntity.ok(restaurantHandler.isOwner(idRestaurant,idOwner));
//    }

    @DeleteMapping("/{idRestaurant} ")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long idRestaurant) {
        restaurantHandler.deleteRestaurant(idRestaurant);
        return ResponseEntity.noContent().build();
    }



}