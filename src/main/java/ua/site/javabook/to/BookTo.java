package ua.site.javabook.to;

import ua.site.javabook.web.converter.DateTimeFormatters;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class BookTo {
    private final Integer id;
    private final DateTimeFormatters.LocalDateFormatter dateFormatter;
    private final String textComit;
    private final String textBook;
    private final String nameBook;
    private final Integer price;

    @ConstructorProperties({"id", "dateFormatter", "textComit", "textBook", "nameBook", "price"})
    public BookTo(Integer id, DateTimeFormatters.LocalDateFormatter dateFormatter, String textComit, String textBook, String nameBook, Integer price) {
        this.id = id;
        this.dateFormatter = dateFormatter;
        this.textComit = textComit;
        this.textBook = textBook;
        this.nameBook = nameBook;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public DateTimeFormatters.LocalDateFormatter getDateFormatter() {
        return dateFormatter;
    }

    public String getTextComit() {
        return textComit;
    }

    public String getTextBook() {
        return textBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookTo bookTo = (BookTo) o;
        return Objects.equals(id, bookTo.id) &&
                Objects.equals(dateFormatter, bookTo.dateFormatter) &&
                Objects.equals(textComit, bookTo.textComit) &&
                Objects.equals(textBook, bookTo.textBook) &&
                Objects.equals(nameBook, bookTo.nameBook) &&
                Objects.equals(price, bookTo.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateFormatter, textComit, textBook, nameBook, price);
    }

    @Override
    public String toString() {
        return "BookTo{" +
                "id=" + id +
                ", dateFormatter=" + dateFormatter +
                ", textComit='" + textComit + '\'' +
                ", textBook='" + textBook + '\'' +
                ", nameBook='" + nameBook + '\'' +
                ", price=" + price +
                '}';
    }
}
