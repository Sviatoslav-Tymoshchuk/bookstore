package dao.impl;

import dao.VideoCourseDao;
import model.VideoCourse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class VideoCourseDaoImpl implements VideoCourseDao {

    private final SessionFactory sessionFactory;

    public VideoCourseDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<VideoCourse> findAll() {
       try (Session session = sessionFactory.openSession()){
           List<VideoCourse> videoCourseList = session
                   .createQuery("from video_courses", VideoCourse.class).list();
            videoCourseList.forEach(System.out::println);
            return videoCourseList;
       }
    }

    @Override
    public VideoCourse getVideoCourseById(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            VideoCourse videoCourse = session.load(VideoCourse.class, id);
            System.out.println(videoCourse);

            transaction.commit();
            return videoCourse;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean insertVideoCourse(VideoCourse videoCourse) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(videoCourse);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteVideoCourse(String id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(deleteVideoCourse(id));
            transaction.commit();
            return true;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
}
