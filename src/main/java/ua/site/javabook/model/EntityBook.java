package ua.site.javabook.model;
import org.springframework.data.convert.Jsr310Converters;
import ua.site.javabook.web.converter.DateTimeFormatters;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class EntityBook extends AbstractNamedEntity {

    private DateTimeFormatters.LocalDateFormatter data;
    private LocalDate dataTime;
    private String textComit;
    private String textBook;
    private String nameBook;
    private Integer price;

    protected EntityAuthor author;
}
