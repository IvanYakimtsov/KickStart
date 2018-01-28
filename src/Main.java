import com.yakimtsov.kickstart.entity.Point;
import com.yakimtsov.kickstart.entity.Triangle;
import com.yakimtsov.kickstart.entity.observer.TriangleRecorder;
import com.yakimtsov.kickstart.exception.InvalidParametersException;

/**
 * Created by Ivan on 28.01.2018.
 */
public class Main {
    public static void main(String[] args){
        Point point1 = new Point(1,1);
        Point point2 = new Point(0,0);
        Point point3 = new Point(2,0);
        Triangle triangle = null;
        try {
            triangle = new Triangle(point1,point2,point3);
            System.out.println("id " + triangle.getId());
            System.out.println("area " + TriangleRecorder.getInstance().getTriangleArea(triangle.getId()));
            System.out.println("perimeter " + TriangleRecorder.getInstance().getTrianglePerimeter(triangle.getId()));
            triangle.setSecondPoint(new Point(-2,0));
            System.out.println("id " + triangle.getId());
            System.out.println("area " + TriangleRecorder.getInstance().getTriangleArea(triangle.getId()));
            System.out.println("perimeter " + TriangleRecorder.getInstance().getTrianglePerimeter(triangle.getId()));
        } catch (InvalidParametersException e) {
            e.printStackTrace();
        }

//        try {
//            triangle.setSecondPoint(new Point(1,1));
//        } catch (InvalidParametersException e) {
//            e.printStackTrace();
//        }
    }
}
