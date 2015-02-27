/**
 * Created by Mac on 2015/2/24.
 */
import java.util.*;
public class test {
    public static void main(String[] args){
        LinkedList l = new LinkedList();
        l.add("a");
        l.add("b");
        l.print();
        l.remove("b");
        System.out.println(l.contain("a"));
        System.out.println(l.contain("b"));
        l.add("b");
        l.add("c");
        l.reverse();
        l.print();
        l.popFront();
        l.print();
        SimpleIterator i = l.ListIterator();
        System.out.println(i.next());
        System.out.println(i.next());
        System.out.println(i.next());

//        Scanner in = new Scanner(System.in);
//        if(in.hasNextInt())
//            System.out.println(in.nextInt());

        PolyOpShell poly = new PolyOpShell();
        LinkedList[] polya = new LinkedList[3];
        PolyTerm t = new PolyTerm(1, 1);
        polya[0] = new LinkedList();
        poly.insertInOrder(t, polya[0]);
        t = new PolyTerm(4, 4);
        poly.insertInOrder(t, polya[0]);
        t = new PolyTerm(3, 3);
        poly.insertInOrder(t, polya[0]);
        t = new PolyTerm(2, 2);
        poly.insertInOrder(t, polya[0]);

        t = new PolyTerm(2, 2);
        polya[1] = new LinkedList();
        poly.insertInOrder(t, polya[1]);
        t = new PolyTerm(9, 0);
        poly.insertInOrder(t, polya[1]);
        poly.printpoly(polya[0]);
        poly.printpoly(polya[1]);

        polya[2] = new LinkedList();
        poly.multPoly(polya[0], polya[1], polya[2]);
        poly.printpoly(polya[2]);

        poly.evalPoly(polya[1], 2);
    }
}
