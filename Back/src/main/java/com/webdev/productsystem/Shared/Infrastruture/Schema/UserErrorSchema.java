package com.webdev.productsystem.Shared.Infrastruture.Schema;

import io.swagger.v3.oas.annotations.media.Schema;



public class UserErrorSchema {

    @Schema(description = "Description of the presented error", example = "Invalid UUID")
    private String error;

    public UserErrorSchema() {}

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
