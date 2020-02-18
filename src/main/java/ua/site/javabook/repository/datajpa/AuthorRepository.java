package ua.site.javabook.repository.datajpa;

import org.hibernate.annotations.Table;
import org.springframework.transaction.annotation.Transactional;
import ua.site.javabook.model.EntityAuthor;

import java.util.List;

@Transactional(readOnly = true)
public interface AuthorRepository {

    @Transactional
    EntityAuthor save(EntityAuthor authorId);

    @Transactional
    void delete(int id);

    EntityAuthor get(int id);

    EntityAuthor getByEmail(String email);

    List<EntityAuthor> getAll();
}
