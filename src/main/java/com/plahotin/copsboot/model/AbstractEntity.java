package com.plahotin.copsboot.model;

import com.plahotin.copsboot.util.ArtifactForFramework;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;

import static com.google.common.base.MoreObjects.toStringHelper;

@EqualsAndHashCode
@MappedSuperclass
public class AbstractEntity<T extends EntityId> implements Entity<T> {

    @EmbeddedId
    private T id;

    @ArtifactForFramework
    protected AbstractEntity() {}

    protected AbstractEntity(@NonNull T id) {
        this.id = id;
    }

    @Override
    public T getId() {
        return null;
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("id", id)
                .toString();
    }
}
