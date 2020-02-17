package ua.site.javabook.repository.datajpa;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ua.site.javabook.model.EntityAuthor;

@Transactional(readOnly = true)
public interface CrudAuthorRepository extends JpaRepository<EntityAuthor, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM EntityAuthor ea WHERE ea.id=:id")
    int delete(@Param("id") int id);

    EntityAuthor getByEmail(String email);

    //    https://stackoverflow.com/a/46013654/548473
    @EntityGraph(attributePaths = {"books"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT ea FROM EntityAuthor ea WHERE ea.id=?1")
   EntityAuthor getWithEntityBook(int id);
}
