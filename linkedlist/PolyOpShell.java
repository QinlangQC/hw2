/*
Program represents polynomials in a linked list.

For all the methods, feel free to change the type of object to the name of your own linked list
and to change the return type. The current names are just there as a skeleton. 
However, remember to make sure that you MUST implement a linked list yourself.
 */

import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;

import java.lang.System;
import java.util.*;

public class PolyOpShell {

	// Input (part a) in the main 
	public static void main(String[] args) {
		PolyOpShell poly = new PolyOpShell();
		int MAX_POLY = 10;
		LinkedList[] polyarray = new LinkedList[MAX_POLY];
		System.out.println("Please enter what you want:");
		System.out.println("  i for input");
		System.out.println("  a for add");
		System.out.println("  s for subtract");
		System.out.println("  m for multiply");
		System.out.println("  e for evaluate");
		System.out.println("  p for print");
		System.out.println("  q for quit");
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String x = in.nextLine();
			if (x.equals("i")) {
				System.out.println("input: enter index number of polynomial and how many terms");
				int position = in.nextInt();
				int numTerms = in.nextInt();
				polyarray[position] = new LinkedList();
				for (int i = numTerms; i > 0; i--) {
					System.out.format("enter coef and exponent for term %d\n", i);
					double coef = in.nextDouble();
					int exponent = in.nextInt();
					PolyTerm p = new PolyTerm(coef, exponent);
					poly.insertInOrder(p, polyarray[position]);
				}
				poly.printpoly(polyarray[position]);
			}
			if (x.equals("a")){
				System.out.println("input: enter indexes of polynomials to be added and to store the result");
				int position1 = in.nextInt();
				int position2 = in.nextInt();
				int position3 = in.nextInt();
				polyarray[position3] = new LinkedList();
				poly.addPoly(polyarray[position1], polyarray[position2], polyarray[position3]);
				poly.printpoly(polyarray[position1]);
				System.out.println("+");
				poly.printpoly(polyarray[position2]);
				System.out.println("=");
				poly.printpoly(polyarray[position3]);
			}
			if (x.equals("s")){
				System.out.println("input: enter indexes of polynomials to be substracted and to store the result");
				int position1 = in.nextInt();
				int position2 = in.nextInt();
				int position3 = in.nextInt();
				polyarray[position3] = new LinkedList();
				poly.subtractPoly(polyarray[position1], polyarray[position2], polyarray[position3]);
				poly.printpoly(polyarray[position1]);
				System.out.println("-");
				poly.printpoly(polyarray[position2]);
				System.out.println("=");
				poly.printpoly(polyarray[position3]);
			}
			if (x.equals("m")){
				System.out.println("input: enter indexes of polynomials to be multiplied and to store the result");
				int position1 = in.nextInt();
				int position2 = in.nextInt();
				int position3 = in.nextInt();
				polyarray[position3] = new LinkedList();
				poly.multPoly(polyarray[position1], polyarray[position2], polyarray[position3]);
				poly.printpoly(polyarray[position1]);
				System.out.println("*");
				poly.printpoly(polyarray[position2]);
				System.out.println("=");
				poly.printpoly(polyarray[position3]);
			}
			if (x.equals("e")){
				System.out.println("input: enter index of polynomial");
				int position = in.nextInt();
				System.out.println("input: enter value");
				int value = in.nextInt();
				poly.printpoly(polyarray[position]);
				System.out.format("x = %d\n", value);
				poly.evalPoly(polyarray[position], value);
			}
			if (x.equals("p")){
				System.out.println("inout: enter index of polynomial");
				int position = in.nextInt();
				poly.printpoly(polyarray[position]);
			}
			if (x.equals("q"))
				break;;
		}
	}
	
	
	// inserts each object based on decreasing exponent value
	void insertInOrder(PolyTerm p, LinkedList L) {
		if (p.getCoef() == 0)
			return;
		if (L.isEmpty())
			L.add(p);
		else{
			LinkedList tempL = new LinkedList();
			PolyTerm d = (PolyTerm) L.popFront();
			while (d != null && d.getExponent() > p.getExponent()){
				tempL.add(d);
				//d = new PolyTerm();
				d = (PolyTerm) L.popFront();
			}
			if (d == null)
				L.add(p);
			else if (d.getExponent() == p.getExponent()){
				p.setPolyTerm(p.getCoef() + d.getCoef(), p.getExponent());
				L.add(p);
			}
			// d < p
			else{
				L.reverse();
				L.add(d);
				L.add(p);
			}
			tempL.reverse();
			while (!tempL.isEmpty())
				L.add(tempL.popFront());
			L.reverse();
		}
	}
	
	
 	// add polynomials
	void addPoly(LinkedList L1, LinkedList L2, LinkedList L3) {
		SimpleIterator p1 = L1.ListIterator();
		SimpleIterator p2 = L2.ListIterator();
		PolyTerm t1 = (PolyTerm) p1.next();
		PolyTerm t2 = (PolyTerm) p2.next();
		while(t1 != null && t2 != null){
			if(t1.getExponent() > t2.getExponent()){
				PolyTerm temp = new PolyTerm(t1.getCoef(), t1.getExponent());
				insertInOrder(temp, L3);
				t1 = (PolyTerm) p1.next();
				continue;
			}
			else if(t1.getExponent() < t2.getExponent()){
				PolyTerm temp = new PolyTerm(t2.getCoef(), t2.getExponent());
				insertInOrder(temp, L3);
				t2 = (PolyTerm) p2.next();
				continue;
			}
			PolyTerm temp = new PolyTerm(t1.getCoef() + t2.getCoef(), t1.getExponent());
			insertInOrder(temp, L3);
			t1 = (PolyTerm) p1.next();
			t2 = (PolyTerm) p2.next();
		}
		if(t2 != null){
			while(t2 != null){
				PolyTerm temp = new PolyTerm(t2.getCoef(), t2.getExponent());
				insertInOrder(temp, L3);
				t2 = (PolyTerm) p2.next();
			}
		}
		else if(t1 != null){
			while(t1 != null){
				PolyTerm temp = new PolyTerm(t1.getCoef(), t1.getExponent());
				insertInOrder(temp, L3);
				t1 = (PolyTerm) p1.next();
			}
		}
	}
	
	
	// subtract polynomials
	void subtractPoly(LinkedList L1, LinkedList L2, LinkedList L3) {
		SimpleIterator p1 = L1.ListIterator();
		SimpleIterator p2 = L2.ListIterator();
		PolyTerm t1 = (PolyTerm) p1.next();
		PolyTerm t2 = (PolyTerm) p2.next();
		while(t1 != null && t2 != null){
			if(t1.getExponent() > t2.getExponent()){
				PolyTerm temp = new PolyTerm(t1.getCoef(), t1.getExponent());
				insertInOrder(temp, L3);
				t1 = (PolyTerm) p1.next();
				continue;
			}
			else if(t1.getExponent() < t2.getExponent()){
				PolyTerm temp = new PolyTerm(-t2.getCoef(), t2.getExponent());
				insertInOrder(temp, L3);
				t2 = (PolyTerm) p2.next();
				continue;
			}
			PolyTerm temp = new PolyTerm(t1.getCoef() - t2.getCoef(), t1.getExponent());
			insertInOrder(temp, L3);
			t1 = (PolyTerm) p1.next();
			t2 = (PolyTerm) p2.next();
		}
		if(t2 != null){
			while(t2 != null){
				PolyTerm temp = new PolyTerm(-t2.getCoef(), t2.getExponent());
				insertInOrder(temp, L3);
				t2 = (PolyTerm) p2.next();
			}
		}
		else if(t1 != null){
			while(t1 != null){
				PolyTerm temp = new PolyTerm(t1.getCoef(), t1.getExponent());
				insertInOrder(temp, L3);
				t1 = (PolyTerm) p1.next();
			}
		}
	}
	
	
	// multiply polynomials, using actual multiply operation (not iterative addition)
	void multPoly(LinkedList L1, LinkedList L2, LinkedList L3) {
		SimpleIterator p1 = L1.ListIterator();
		PolyTerm t1 = (PolyTerm) p1.next();
		while(t1 != null){
			SimpleIterator p2 = L2.ListIterator();
			PolyTerm t2 = (PolyTerm) p2.next();
			while(t2 != null){
				PolyTerm temp = new PolyTerm(t1.getCoef() * t2.getCoef(), t1.getExponent() + t2.getExponent());
				insertInOrder(temp, L3);
				t2 = (PolyTerm) p2.next();
			}
			t1 = (PolyTerm) p1.next();
		}
	}
	
	
	// evaluates the polynomial
	void evalPoly(LinkedList L1, int value) {
		SimpleIterator p = L1.ListIterator();
		PolyTerm t = (PolyTerm) p.next();
		double result = 0;
		while(t != null){
			double temp = t.getCoef();
			for(int i = t.getExponent(); i > 0; i--){
				temp *= value;
			}
			result += temp;
			t = (PolyTerm) p.next();
		}
		String c;
		if(result == (long) result)
			c = String.format("%d",(long)result);
		else
			c = String.format("%s",result);
		System.out.format("The value of the polynomial with x=%d is: %s\n", value, c);
	}
	
	
	// prints out the polynomial
	void printpoly(LinkedList L1) {
		SimpleIterator p = L1.ListIterator();
		PolyTerm t = (PolyTerm) p.next();
		if(t == null) return;
		double d = t.getCoef();
		String c;
		if(d == (long) d)
			c = String.format("%d",(long)d);
		else
			c = String.format("%s",d);
		System.out.format("%sx^%d", c, t.getExponent());
		t = (PolyTerm) p.next();
		while(t != null){
			d = t.getCoef();
			if(d == (long) d)
				c = String.format("%d",(long)d);
			else
				c = String.format("%s",d);
			System.out.format(" + %sx^%d", c, t.getExponent());
			t = (PolyTerm) p.next();
		}
		System.out.print("\n");
	}
}


/*
  This class is the default code from the pdf file 
  that represents a possible Java class for a polynomial term.
*/

class PolyTerm {
	private double coef;
	private int exponent;
	PolyTerm(){
		coef=0.0;
		exponent=0;
	}
	PolyTerm(double c, int e)
	{
		coef=c;
		exponent=e;
	}
	public void setPolyTerm(double c, int e)
	{
		coef=c;
		exponent=e;
	}
	public int getExponent()
	{    return exponent;  }
	public double getCoef()
	{    return coef;   }
	public String toString()
	{  return coef + " x^" + exponent; }
}
