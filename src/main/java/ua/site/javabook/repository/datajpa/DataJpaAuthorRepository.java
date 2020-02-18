package ua.site.javabook.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ua.site.javabook.model.EntityAuthor;

import java.util.List;

@Repository
public class DataJpaAuthorRepository implements AuthorRepository {
    private static final Sort SORT_NAME_EMAIL = Sort.by(Sort.Direction.ASC, "name", "email");

    private CrudAuthorRepository crudAuthorRepository;

    @Override
    public EntityAuthor save(EntityAuthor authorId) {
        return crudAuthorRepository.save(authorId);
    }

    @Override
    public void delete(int id) {
        crudAuthorRepository.delete(id);
    }

    @Override
    public EntityAuthor get(int id) {
        return crudAuthorRepository.findById(id).orElse(null);
    }

    @Override
    public EntityAuthor getByEmail(String email) {
        return crudAuthorRepository.getByEmail(email);
    }

    @Override
    public List<EntityAuthor> getAll() {
        return crudAuthorRepository.findAll(SORT_NAME_EMAIL);
    }
}
