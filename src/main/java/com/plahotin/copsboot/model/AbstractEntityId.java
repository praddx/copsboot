package com.plahotin.copsboot.model;

import com.plahotin.copsboot.util.ArtifactForFramework;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

import static com.google.common.base.MoreObjects.toStringHelper;

@EqualsAndHashCode
@ToString
@MappedSuperclass
public class AbstractEntityId<T extends Serializable> implements Serializable, EntityId<T> {

    private T id;

    @ArtifactForFramework
    protected AbstractEntityId() {
    }

    protected AbstractEntityId(@NonNull T id) {
        this.id = id;
    }

    @Override
    public T getId() {
        return this.id;
    }

    @Override
    public String asString() {
        return toStringHelper(this)
                .add("id", id)
                .toString();
    }
}
