package com.webdev.productsystem.Tours.Address.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.CustomUUID;

public class BlockId extends CustomUUID {
    BlockId() {
    }

    public BlockId(String value) {
        super(value);
    }
}
