package com.aegon.interviewproject.common.entity;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;


@MappedSuperclass
public class BaseEntity implements Serializable {

    private int id; // could be UUID

//    @Id
//    @GeneratedValue (generator="uuid")
//    @GenericGenerator(name="uuid", strategy="org.hibernate.id.UUIDGenerator")
//    @Column (name="id", updatable=false, nullable=false)
//    @Access(AccessType.FIELD)
//    public UUID getId() {
//        return id;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.FIELD)
    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        BaseEntity other = (BaseEntity) obj;
        if (id != other.id) return false;
        return true;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}