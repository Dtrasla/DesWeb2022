package com.webdev.productsystem.Shared.Infrastruture.Schema;

import io.swagger.v3.oas.annotations.media.Schema;

public class PhoneErrorSchema {
    @Schema(description = "Description of the presented error", example = "Invalid UUID")
    private String error;

    public PhoneErrorSchema() {}

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

