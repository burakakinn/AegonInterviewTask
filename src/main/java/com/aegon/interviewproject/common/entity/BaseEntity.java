package com.aegon.interviewproject.common.entity;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;


@MappedSuperclass
public class BaseEntity implements Serializable {

    private UUID id;

    @Id
    @GeneratedValue (generator="uuid")
    @GenericGenerator(name="uuid", strategy="org.hibernate.id.UUIDGenerator")
    @Column (name="id", updatable=false, nullable=false)
    @Access(AccessType.FIELD)
    public UUID getId() {
        return id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id.hashCode();
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
        return id.toString();
    }
}