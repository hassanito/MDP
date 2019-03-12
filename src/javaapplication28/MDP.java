/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication28;
import java.util.*;
import java.math.*;

/**
 *
 * @author hassan
 */
public class MDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("bon");
        /*Point a = new Point(23,56);
        a.info();
        System.out.println(a.get_x());
        System.out.println(a.get_y());
        a.set_x(2.7);
        a.set_y(6.7);
        a.info();
        Square b = new Square(a,10);
        b.info();
        b.set_empty(false);
        b.info();
        Square c = new Square(new Point(5,5),10);
        c.info();
        c.set_empty(false);
        c.info();
        System.out.println(c.get_x_limits());       
        System.out.println(c.contains_point(new Point(5,15)));
        
        Graph g = new Graph(500,500,5);
        //System.out.println(g.liste.toString());
        System.out.println("--------------------------------------");
        Map < String , List<String[]>> entry = new HashMap<String ,List<String[]>>();
        Map <String,List<List<Double>>> entry2 = new HashMap<String,List<List<Double>>>();
        List<String[]> test = new ArrayList<String[]>();
        String[] sx ={"hassan","batata"};
        String[] sz = {"akidement","taayeb"};
        String[] sy = {"hasanan0","helo 3ane"};
        test.add(sx);
        test.add(sy);
        test.add(sz);
        System.out.println(test.get(1)[1]);
        
        //entry.put("bon",test);
       // System.out.println(entry);4
       System.out.println("bon");
       System.out.println(g.squares_list.get(3).state());
           g.squares_list.get(3).set_empty(false);
       
        
       System.out.println("-------------------------------");
       List <Point> seq = new ArrayList<Point>();
       seq.add(new Point(1,3));
       seq.add(new Point(2,5));
       seq.add(new Point(3,7));
       seq.add(new Point(8,9));
       Object batat = new Object(seq);
       batat.info();
       System.out.println("-------------------------------");
       Square n = new Square(new Point(0,0),10);
       n.info();
       Point pi = new Point(5,5);
       n.add_point(pi);
       n.info();
       n.remove_point(pi);
       n.info();
       n.add_point(new Point(11,11));
       n.add_point(new Point(10,10));
       n.info();
       g.find_square_of_point(pi);
       System.out.println("-------------------------------");
       Set<Double> xo = new HashSet<Double>();
       xo.add(4.0);
       xo.add(3.2);
       xo.add(6.3);
       System.out.println("set = "+xo);
       Double[] arr = new Double[3];
       xo.toArray(arr);
       
       for(int i=0;i<arr.length;i++){
        System.out.println("Arr ["+i+"]= "+arr[i]);
       }
       //testing the function that turns a set into an sorted array
       
       Arrays.sort(arr);
       for(int i=0;i<arr.length;i++){
        System.out.println("Arr ["+i+"]= "+arr[i]);
       }
       System.out.println("-------------------------------");
       //PRoof of the sorted array working 
       for(int i=0;i<g.arr.length;i++){
        System.out.println("Arr ["+i+"]= "+g.arr[i]);
       }
       System.out.println("-------------------------------");
       Double poo = 15.65;
       // Should fix the get closest to return not closest that is smaller than the number im searching for
      System.out.println("the closest number to "+poo +" is "+g.arr[g.findClosest(g.arr, poo)]);
       System.out.println("the closest number to "+poo +" is "+g.arr[g.findClosest_and_smaller(g.arr, poo)]);
       g.find_square_of_point(new Point(230,42));
       */
        Graph g = new Graph(60,60,10);
        
        //g.info();
        int x =46;
        int y =32;
        System.out.println(x-x%7.5);
        System.out.println(y-y%7.5);
        Point p = new Point(x,y);
        //g.squares_list.get(52).info();
        //System.out.println(g.squares_list.get(52).contains_point(p));
        System.out.println(g.m.size());
    }

    }
    
}

class Point{
    private double x;
    private double y;
    public Point(double x,double y){
        this.x =x;
        this.y =y;
    }
    public double get_x(){
        return this.x;
    }
    public double get_y(){
        return y;
    }
    public void set_x(double x){
        this.x= x;
    }
    public void set_y(double y){
        this.y=y;
    }
    public void info(){
        System.out.println("x = "+x+" , y= "+y);
    }

}
class Object{
    //an object is a sequence of points
    public List<Point> sequence;
    public Object(List <Point> sq){
        sequence  =sq;
    }
    public void info(){
        for(int i=0;i<sequence.size();i++){
            sequence.get(i).info();
        }
    }
    
}
class Square{
    // maybe I should something to check that no 2 squares at the same point should exist
    private static int ID_counter =0;// id generator - every square has a specific id that will be mapped to it later 
    private int ID;
    private String id_coor;
    private Point coordinates;
    private boolean empty;
    private double size;
    private double x_limits;
    private double y_limits;
    private List<Point> points_in_square;
    public Square(Point c,double s) {
        this.coordinates = c;
        this.size =s;
        empty = true;
        ID_counter++;
        ID=ID_counter; 
        id_coor = coordinates.get_x() +""+coordinates.get_y();
        // ID counter is static (class related) so it keeps increasing with every object square we create
        // ID is object related so every object created will have a value;
        x_limits = c.get_x()+size;
        y_limits = c.get_y() +size;
        points_in_square = new ArrayList<Point>();
       // System.out.println("the id of this square is = "+ID);
        
    }
    public void set_empty(boolean state){
        empty = state;
    }
    public boolean state(){
        return empty;
    }
    public double get_x_limits(){
        return x_limits;
    }
    public double get_y_limits(){
        return y_limits;
    }
    public String get_id_coor(){return id_coor;}
    public boolean contains_point(Point a){
        //contains point checks if a point belongs to this square 
        if(coordinates.get_x()<a.get_x()&& coordinates.get_y() < a.get_y() && a.get_x()<= x_limits && a.get_y()<= y_limits){
                //checks if the point is within the boundaries of the square - I considered that the point can belong to the x-y limit axis but not the x-y axis
               return true;
        }else{
            return false;
        }
    }
    public int get_ID(){
        return ID;
    }
    public double get_x(){return coordinates.get_x();}
    public double get_y(){return coordinates.get_y();}
    public void add_point(Point a){
        // make sure to add a point as a referenece not a new Point or a copy so remove can work later
        /* not sure if I should check (the contains point function) if the point belongs to this square in this function or in the graph
        and might deprecate it later */
        if(this.contains_point(a)){
            points_in_square.add(a);
             this.set_empty(false);
       } else{
            System.out.println("point does not belong to square");
        }
}
    public void remove_point(Point a){
        //this function removes a point from a square and if the square has no points left it will become empty
        if(points_in_square.contains(a)){
            System.out.println("yes it does ya hmar");
            points_in_square.remove(a);
            
        }
        if(points_in_square.isEmpty()){
            this.set_empty(true);
        }
    }
    public void info(){
        System.out.print("square COOR "+id_coor+" with an id = "+ID+" of size = "+ size +" and coordinates ");
        coordinates.info();
        if(empty==true ){
            System.out.println(" is empty ");
        }else{
            System.out.println("is not empty");
            System.out.println("the square contains ");
            for(int i=0;i<points_in_square.size();i++){
                points_in_square.get(i).info();
            }
        }
        
        
    }
}



class Graph{
    // the graph is the piece we are cutting basically
    double x;
    double y;
    double number_of_squares;
    double square_area;
    double square_size;
    double max;
    
    //List <Square> squares_list = new ArrayList<Square>();
    Map <String,Square > m = new HashMap<String,Square>();
    //the hashmap is a sorted table of all the squares in the graph to make it easy to find which squares do points belong to
    //  Map <Double,List<List<Double>>> entry2 = new HashMap<Double,List<List<Double>>>();
    Double[] arr;
    public Graph(double x,double y,int n){
        this.x =x;
        this.y = y;
        //the number of squares is always a power of 4 
        this.number_of_squares =Math.pow(4,n);
        square_area = (x*y)/number_of_squares;
        square_size = Math.sqrt(square_area);
        //max = Math.sqrt(number_of_squares);
        fill_table();
        System.out.println("heyyaaa ");
          //  sort_hashtable();
        //System.out.println(entry2);
        // arr = sorted_keys_toArray();
        
    }
    // we only use the fill table function once
    
    private void fill_table(){
        //function should create a list of squares
        // idea : take the x and y of the point and use it the multiple of x with the divider 
        int counter =0;
        for(int i=0;i<x/square_size;i++){
            for(int j=0;j<y/square_size;j++){
                                
                Square a = new Square(new Point(i*square_size,j*square_size),square_size);
                //squares_list.add(a);
                m.put(a.get_id_coor(),a);
                counter++;
            }
        }
        System.out.println("we made "+counter+" squares");
    }
    private void sort_hashtable(){
      // this function will group the squares by the same x so we can place the point better later on in every square
        
      for(int i=0;i<squares_list.size();i++){
         // System.out.println(i);
         //squares_list.get(i).info();
         Square current = squares_list.get(i);
         if(entry2.containsKey(current.get_x())){
           List<List<Double>> bon = new ArrayList<List<Double>>();
           bon = entry2.get(current.get_x());
           List<Double> y_ID  = new ArrayList<Double>();
           y_ID.add(current.get_y());
           y_ID.add(Double.valueOf(current.get_ID()));
           bon.add(y_ID);
           entry2.replace(current.get_x(), bon);
         }else {
             List<Double> y_ID  = new ArrayList<Double>();
             y_ID.add(current.get_y());
             y_ID.add(Double.valueOf(current.get_ID()));
             List<List<Double>> bon = new ArrayList<List<Double>>();
             bon.add(y_ID);
             entry2.put(current.get_x(),bon);
         }
         
          
      }
    }
    public int find_square_of_point(Point a){
		//this function will find the square which the point belongs to in the most efficient way
		// it will use the sorted hashtable as some kind of filter 
		//we will find the x closest to 
                /*
                 Suggestion on how to solve this : use binary search https://www.geeksforgeeks.org/find-closest-number-array/
                 to find the closest number in the sorted array.
                 the array should be sorted once outside this function to reduce complexity since the graph is created only once
                so the array wont change 
                */
                //the x_of_square finds the x of the square the points belongs to
                Double x_of_square = arr[findClosest_and_smaller(arr,a.get_x())];
                System.out.println(x_of_square);
                List<List<Double>> keys = entry2.get(x_of_square);
                for(int i=0;i<keys.size();i++){
           // GO BACK HERE AND TRY TO FIX THIS MESS        
                }
                
 return 0;
    }
    public void add_object(Object o){
        /*this function will add the object to the graph ( the piece we are cutting on) 
        the ai algorithm will be applied inside this function on the object */
           

    }
    // Returns element closest to target in arr[] 
    public static Integer findClosest(Double arr[], Double target) 
    { 
        int n = arr.length; 
  
        // Corner cases 
        if (target <= arr[0]) 
            return 0; 
        if (target >= arr[n - 1]) 
            return n - 1; 
  
        // Doing binary search  
        int i = 0, j = n, mid = 0; 
        while (i < j) { 
            mid = (i + j) / 2; 
  
            if (arr[mid] == target) 
                return mid; 
  
            /* If target is less than array element, 
               then search in left */
            if (target < arr[mid]) { 
         
                // If target is greater than previous 
                // to mid, return closest of two 
                if (mid > 0 && target > arr[mid - 1])  
                    if(getClosest(arr[mid - 1],  
                                  arr[mid], target)==0){
                        return mid-1;
                    }else{
                        return mid;
                    }  
                /* Repeat for left half */
                j = mid;               
            } 
  
            // If target is greater than mid 
            else { 
                if (mid < n-1 && target < arr[mid + 1])  
                    if(getClosest(arr[mid - 1],  
                                  arr[mid], target)==0){
                        return mid;
                    }else{
                        return mid+1;
                    }  
                i = mid + 1; // update i 
            } 
        } 
  
        // Only single element left after search 
        return mid; 
    } 
  
    // Method to compare which one is the more close 
    // We find the closest by taking the difference 
    //  between the target and both values. It assumes 
    // that val2 is greater than val1 and target lies 
    // between these two. 
    private static Integer getClosest(Double val1, Double val2,  
                                         Double target) 
    { 
        if (target - val1 >= val2 - target)  
            return 0;         
        else 
            return 1;         
    } 
    public static int findClosest_and_smaller(Double arr[],Double target){
        int index = findClosest(arr,target);
        if(arr[index]>target){
            return index-1;
        }else{
            return index;
        }
    }
    public void info(){
        for(String i:m.keySet()){
            System.out.println( "key = "+i);
            m.get(i).info();
        }
    }
    
}