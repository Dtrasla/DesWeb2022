package com.webdev.productsystem.Tours.Hotel.Infrastructure.Hibernate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webdev.productsystem.Tours.Hotel.Domain.Entities.HotelAddress;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class HotelAddressCustomTypes implements UserType {
    @Override
    public int[] sqlTypes() {
        return new int[]{Types.LONGVARCHAR};
    }

    @Override
    public Class returnedClass() {
        return List.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return Objects.equals(x, y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return Objects.hashCode(x);
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        HotelAddress response = null;
        try {
            Optional<String> value = Optional.ofNullable(rs.getString(names[0]));
            if (value.isPresent()) {
                HashMap<String, Object> object = new ObjectMapper().readValue(value.get(), HashMap.class);
                response = new HotelAddress(
                        (String) object.get("id"),
                        (String) object.get("data"),
                        (String) object.get("zipCode"),
                        (String) object.get("blockId"),
                        (String) object.get("cityId")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Error at reading map of Hotel Address " + e.toString());
        }
        return Optional.ofNullable(response);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        Optional<HotelAddress> object = (value == null) ? Optional.empty() : (Optional<HotelAddress>) value;
        try {
            if(object.isEmpty()) {
                st.setNull(index, Types.VARCHAR);
            } else {
                st.setString(index, new ObjectMapper().writeValueAsString(object.get().data()).replace("\\", ""));
            }
        } catch (Exception e) {
            throw new HibernateException("Error serializing value of HotelAddress " + e.toString());
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return null;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return null;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return null;
    }
}
