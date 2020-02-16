package ua.site.javabook.model;

import org.springframework.data.domain.Persistable;

import java.util.Objects;

public abstract class AbstractBaseEntity implements Persistable<Integer> {
    public static final int TART_SEQ=500;
    protected Integer id;
    public AbstractBaseEntity() {
    }
    public AbstractBaseEntity(Integer id) {
        this.id = id;
    }
    @Override
    public Integer getId() {
        return id;
    }
    @Override
    public boolean isNew() {
        return this.id==null;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+"="+id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractBaseEntity that = (AbstractBaseEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
