package dao;

import model.VideoCourse;

import java.util.List;

public interface VideoCourseDao {

    List<VideoCourse> findAll();

    VideoCourse getVideoCourseById(int id);

    boolean insertVideoCourse(VideoCourse videoCourse);

    boolean deleteVideoCourse(String id);
}
