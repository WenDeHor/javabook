package ua.site.javabook.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.site.javabook.model.EntityAuthor;
import ua.site.javabook.model.EntityBook;

import java.util.List;


@Repository
public class DataJpaBookRepository implements BookRepository {

    @Autowired
    private CrudBookRepository crudBookRepository;

    @Autowired
    private CrudAuthorRepository crudAuthorRepository;


    @Override
    @Transactional
    public EntityBook save(EntityBook book, int authorId) {
        if (!book.isNew() && get(book.getId(), authorId) == null) {
            return null;
        }
        book.setAuthor(crudAuthorRepository.getOne(authorId));
        return crudBookRepository.save(book);
    }

    @Override
    @Transactional
    public void delete(int bookId, int authorId) {
        crudBookRepository.delete(bookId, authorId);
    }

    @Override
    public EntityBook get(int bookId, int authorId) {
        return crudBookRepository.findById(bookId)
                .filter(book -> book.getAuthor().getId() == authorId)
                .orElse(null);
    }

    @Override
    public List<EntityBook> getAll(int authorId) {

        return crudBookRepository.getAll(authorId);
    }


}
