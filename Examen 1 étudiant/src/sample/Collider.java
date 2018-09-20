package sample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by utilisateur on 2016-09-16.
 */
public class Collider {
    public interface ICollider{
        public boolean collide(Point p, Cercle c);
    }
    public static List<Boolean> getColliderList(ICollider collider){
        Point[] points = {
            new Point(0,0), new Point(10,10), new Point(20,20), new Point(30,30), new Point(40,40)
        };
        Cercle[] circles = {
            new Cercle(5,5,10), new Cercle(5,5,4), new Cercle(10,10,30), new Cercle(0,0,20), new Cercle(0,0,10)
        };
        List<Boolean> results = new ArrayList<>();
        for(int i = 0; i < points.length; i++){
            results.add(collider.collide(points[i], circles[i]));
        }
        return results;
    }
}
