package ua.site.javabook.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ua.site.javabook.model.EntityBook;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudBookRepository extends JpaRepository<EntityBook, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM EntityBook eb WHERE eb.id=:id AND eb.id=:userId")
    int delete(@Param("id") int id, @Param("userId") int userId);

    @Override
    @Transactional
    EntityBook save(EntityBook item);

    @Query("SELECT eb FROM EntityBook eb WHERE eb.author.id=:userId ORDER BY eb.nameBook DESC")
    List<EntityBook> getAll(@Param("userId") int userId);
}

