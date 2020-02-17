package ua.site.javabook.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "users_uniqe_email_idx")})
public class EntityAuthor extends AbstractNamedEntity {

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @OrderBy("name DESC")
    protected List<EntityBook> bookList;

    public EntityAuthor() {
    }

    public EntityAuthor(EntityAuthor ea) {
        this(ea.getId(), ea.getName(), ea.getEmail(), ea.getPassword(), ea.getBookList());
    }

    public EntityAuthor(Integer id, String name, @Email @NotBlank @Size(max = 100) String email, @NotBlank @Size(min = 5, max = 100) String password, List<EntityBook> bookList) {
        super(id, name);
        this.email = email;
        this.password = password;
        this.bookList = bookList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<EntityBook> getBookList() {
        return bookList;
    }

    public void setBookList(List<EntityBook> bookList) {
        this.bookList = bookList;
    }
}
