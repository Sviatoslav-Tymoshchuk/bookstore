package model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Time;

@Data
@Entity
@Table(name = "video_courses")
public class VideoCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    @Size(max = 20)
    private int id;

    @Size(max = 254)
    private String tile;

    @Size(max = 50)
    private String author;

    private Time time;

    @Size(max = 50)
    private String publisher;


}
