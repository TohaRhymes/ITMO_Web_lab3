import model.Point;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DataBean {
    private List<Point> points;
    private Point currentPoint;
    private boolean notEmpty;

    private EntityManager em = Persistence.createEntityManagerFactory("hibernate").createEntityManager();

    public DataBean() {
        Query query = em.createQuery("select p from Point p");
        points = query.getResultList();
        points.sort((p1, p2) -> p1.getId() > p2.getId() ? -1 : 1);
        System.out.println(points.toString());
        setNotEmpty(true);
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setCurrentPoint(Point currentPoint) {
        this.currentPoint = currentPoint;
        points.add(0, currentPoint);
        addPointToDatabase(currentPoint);
        setNotEmpty(true);
    }

    public void setNotEmpty(boolean notEmpty) {
        this.notEmpty = points.size() > 0;
    }

    public boolean isNotEmpty() {
        return notEmpty;
    }

    private void addPointToDatabase(Point p) {
        em.getTransaction().begin();
        em.persist(p);
        em.flush();
        em.getTransaction().commit();
        System.out.println("commited");
    }
}
