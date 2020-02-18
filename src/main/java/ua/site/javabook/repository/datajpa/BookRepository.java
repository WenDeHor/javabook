package ua.site.javabook.repository.datajpa;

import org.springframework.transaction.annotation.Transactional;
import ua.site.javabook.model.EntityAuthor;
import ua.site.javabook.model.EntityBook;

import java.util.List;

@Transactional(readOnly = true)
public interface BookRepository {

    @Transactional
    EntityBook save(EntityBook book, int authorId);

    EntityBook get(int id, int authorId);

    @Transactional
    void delete(int id, int authorId);

    List<EntityBook> getAll(int authorId);


}
