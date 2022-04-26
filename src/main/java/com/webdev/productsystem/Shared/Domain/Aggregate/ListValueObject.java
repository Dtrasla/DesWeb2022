package com.webdev.productsystem.Shared.Domain.Aggregate;

import java.util.List;
import java.util.Objects;

public class ListValueObject {

    protected List<String> value;

    public List<String> value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListValueObject that = (ListValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
