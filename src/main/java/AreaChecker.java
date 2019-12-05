import model.Point;
import org.primefaces.event.SlideEndEvent;


import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Map;

public class AreaChecker implements Serializable {
    private Double x;
    private Double y;
    private Double xCanvas;
    private Double yCanvas;
    private String resizeResult;
    private Double r;

    private DataBean bean;

    public Double getxCanvas() {
        return xCanvas;
    }

    public void setxCanvas(Double xCanvas) {
        this.xCanvas = xCanvas;
    }

    public Double getyCanvas() {
        return yCanvas;
    }

    public void setyCanvas(Double yCanvas) {
        this.yCanvas = yCanvas;
    }

    public AreaChecker(){
        r=3.0;
        y=-5.0;
    }

    public Double getX() {
        return x;
    }


    public void setX(Double x) {
        this.x = x;
        //System.out.println("x setted, value " + x);
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
        //System.out.println("y setted, value " + y);
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
        //System.out.println("r setted, value " + r);
    }

    public String getResizeResult() {
        return resizeResult;
    }

    public void setResizeResult(String resizeResult) {
        this.resizeResult = resizeResult;
    }

    public void check() {
        Point p = new Point(getR(), getX(), getY());
        bean.setCurrentPoint(p);
        resizeResult = p.getIscheck();
    }

    public void canvasCheck(){
        Point p = new Point(getR(), xCanvas, yCanvas);
        bean.setCurrentPoint(p);
        resizeResult = p.getIscheck();
    }

    public void resizeCheck(){
        Point p = new Point(getR(), xCanvas, yCanvas);
        resizeResult = p.getIscheck();
    }
    public void setBean(DataBean bean){
        this.bean=bean;
    }
    public DataBean getBean(){
         return bean;
    }

    public boolean getReady(){
        return x!=null && y!=null && r!=null;
    }

    public void handleSlider(SlideEndEvent event){
        setY((double)event.getValue());
    }

}
