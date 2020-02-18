package ua.site.javabook.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.convert.Jsr310Converters;
import ua.site.javabook.web.converter.DateTimeFormatters;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class EntityBook extends AbstractBaseEntity {

    @Column(name = "data_time", nullable = false)
    @NotNull
    private DateTimeFormatters.LocalDateFormatter data;
//    private LocalDate dataTime;

    @Column(name = "textComit", nullable = false)
    @NotBlank
    @Size
    private String textComit;

    @Column(name = "textBook", nullable = false)
    @NotBlank
    @Size
    private String textBook;

    @Column(name = "nameBook", nullable = false)
    @NotBlank
    @Size
    private String nameBook;

    @Column(name = "price", nullable = false)
    @Range(min = 1, max = 5000)
    private Integer price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    protected EntityAuthor author;

    public EntityBook() {
    }

    public EntityBook(Integer id, @NotNull DateTimeFormatters.LocalDateFormatter data, @NotBlank @Size String textComit, @NotBlank @Size String textBook, @NotBlank @Size String nameBook, @Range(min = 1, max = 5000) Integer price) {
        super(id);
        this.data = data;
        this.textComit = textComit;
        this.textBook = textBook;
        this.nameBook = nameBook;
        this.price = price;
    }

    public DateTimeFormatters.LocalDateFormatter getData() {
        return data;
    }

    public void setData(DateTimeFormatters.LocalDateFormatter data) {
        this.data = data;
    }

    public String getTextComit() {
        return textComit;
    }

    public void setTextComit(String textComit) {
        this.textComit = textComit;
    }

    public String getTextBook() {
        return textBook;
    }

    public void setTextBook(String textBook) {
        this.textBook = textBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public EntityAuthor getAuthor() {
        return author;
    }

    public void setAuthor(EntityAuthor author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "EntityBook{" +
                "data=" + data +
                ", textComit='" + textComit + '\'' +
                ", textBook='" + textBook + '\'' +
                ", nameBook='" + nameBook + '\'' +
                ", price=" + price +
                ", author=" + author +
                '}';
    }
}
