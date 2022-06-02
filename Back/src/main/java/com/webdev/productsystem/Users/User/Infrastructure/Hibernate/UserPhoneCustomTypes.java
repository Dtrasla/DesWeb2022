package com.webdev.productsystem.Users.User.Infrastructure.Hibernate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webdev.productsystem.Tours.Hotel.Domain.Entities.HotelAddress;
import com.webdev.productsystem.Users.User.Domain.Entities.UserPhone;
import com.webdev.productsystem.Users.User.Domain.User;
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

public class UserPhoneCustomTypes implements UserType {
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
        UserPhone response = null;
        try {
            Optional<String> value = Optional.ofNullable(rs.getString(names[0]));
            if (value.isPresent()) {
                HashMap<String, Object> object = new ObjectMapper().readValue(value.get(), HashMap.class);
                response = new UserPhone(
                        (String) object.get("id"),
                        (String) object.get("countryCode"),
                        (String) object.get("number"),
                        (String) object.get("userId")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Error at reading map of User Phone " + e.toString());
        }
        return Optional.ofNullable(response);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        Optional<UserPhone> object = (value == null) ? Optional.empty() : (Optional<UserPhone>) value;
        if (object.isEmpty()) {
            st.setNull(index, Types.LONGVARCHAR);
        } else {
            try {
                st.setString(index, new ObjectMapper().writeValueAsString(object.get().data()).replace("\\", ""));
            } catch (Exception e) {
                e.printStackTrace();
            }
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
