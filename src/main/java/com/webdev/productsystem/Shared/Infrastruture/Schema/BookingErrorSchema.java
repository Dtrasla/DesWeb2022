package com.webdev.productsystem.Shared.Infrastruture.Schema;

import io.swagger.v3.oas.annotations.media.Schema;

public class BookingErrorSchema {

    @Schema(description = "Description of the presented error", example = "Invalid UUID")
    private String error;

    public BookingErrorSchema() {}

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
