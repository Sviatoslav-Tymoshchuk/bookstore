package model;


import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "books")
public class Book {

    @Size(max = 128)
    private String title;

    @Size(max = 128)
    private String author;

    private Date published;

    @Id
    @Size(max = 17)
    @PrimaryKeyJoinColumn
    private String isbn;

    @Size(max = 128)
    private String category;

    @Size(max = 11)
    @Column(name = "page_count")
    private int pageCount;

    @Size(max = 128)
    private String publisher;

    @DecimalMax("10,2")
    private BigDecimal price;

    @Size(max = 5)
    private int quantity;
}
