package model;


import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "toha_pip")
public class Point {

    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "r", nullable = false)
    private Double r;
    @Column(name = "x", nullable = false)
    private Double x;
    @Column(name = "y", nullable = false)
    private Double y;
    @Column(name = "checked", nullable = false)
    private String ischeck;

    public Point(Double r, Double x, Double y) {
        this.r = r;
        this.x = x;
        this.y = y;
        this.ischeck = ((x <= 0 && y >= 0 && y <= (2 * x + r)) || (x >= 0 && y >= 0 && x * x + y * y <= r * r) || (x >= 0 && y <= 0 && x <= r && y >= -r / 2)) ? "Да" : "Нет";
        this.id = new Date().getTime();
    }

    public Point() {
        this.id = new Date().getTime();
    }

    public long getId() {
        return id;
    }

    public Double getR() {
        return r;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public String getIscheck() {
        return ischeck;
    }

    public String getDate() {
        return new SimpleDateFormat("dd.MM.yy, HH:mm:ss").format(new Date(id));
    }
}