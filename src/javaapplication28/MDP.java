/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication28;
import java.util.*;
import java.math.*;
import java.util.function.Function;

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
        
        //g.info();
        
        /* 
        //g.squares_list.get(52).info();
        //System.out.println(g.squares_list.get(52).contains_point(p));
        System.out.println(g.m);
        System.out.println(g.m.size());
        //g.info();
        Point point = new Point(x,y);
        System.out.println(g.find_sq_point(point));
        g.m.get(g.find_sq_point(point)).info();
        g.m.get(g.find_sq_point(point)).set_empty(true);
        g.m.get(g.find_sq_point(point)).info();
        System.out.println("-------------------------");
        
        List<Point> lp = new ArrayList<Point>();
        Point p =new Point(3,23,0);
        lp.add(p);
        Point po = new Point(12.56,25.2,0);
        lp.add(po);
        Object o = new Object();
        o.add_point(p);
        o.add_point(po);
        g.add_object(o);
        List<Point> lp1 = new ArrayList<Point>();
        Point p1 =new Point(5,43,0);
        Point p3 = new Point(3,24,0);
        lp1.add(p3);
        lp1.add(p1);
        Point po1 = new Point(26,37.7,0);
        lp1.add(po1);
        Object o1 = new Object();
        o1.add_point(po1);
        o1.add_point(p1);
        o1.add_point(p3);
        g.add_object(o1);
        g.info();
        System.out.println("--------------------------");
       
      /*g.m.get(g.find_sq_point(po)).remove_point(po);
        g.info();
        o.info();
        
        g.remove_object(o);
        g.info();
                System.out.println("--------------------------");
                o.info();
                //o.translate_object_right(100, 200);
                o.info();
        
        Graph g = new Graph(50,50,1);
        g.info();
        Object bon = new Object();
        bon.add_point(new Point(2,2,0));
        g.add_object(bon);
        System.out.println("=========================================");
        g.info();
        System.out.println("=========================================");
        g.translate_right(1);
        g.info();
        */
        System.out.println("test");
        Point test = new Point(26,2,3);
        //test.info();
        Point test2 = new Point(0,1,3);
        //test2.info();
        Object test_object = new Object();
        //test_object.info();
        Object test_object2 = new Object();
        //test_object2.info();
        test_object.add_point(test);
        test_object.add_point(test2);
        test_object.info();
        
        System.out.println("=================================================");
        Graph g = new Graph(100,100,2);
        g.add_object(test_object);
       
        g.info();
        System.out.println("xxxxxxxxxxxxx=================================================");
  
        
        g.info();
       
       
    
 
 
        test_object2.info();
        Point p3 = new Point(27,3,0);
        Point p4 = new Point(49,26,0);
        test_object2.add_point(p4);
        test_object2.add_point(p3);
        test_object2.info();
        //g.translate_right(1);
        //g.objects_in_square.get(1).translate_object_up(g.square_size, g.y);
        //g.translate_down(1);
        g.info();
        
        g.add_object(test_object2);
        //System.out.println(g.find_best_move(1));
        
       // g.check_collusion(g.objects_in_square.get(2));
        //g.info();
        g.info();
        
        
    }
    }
    


class Point{
    private double x;
    private double y;
    //added the square id so every point will be recognized by the object it belongs to and vice versa
    private int square_Id=0;
    public Point(double x,double y,int sq_id){
        this.x =x;
        this.y =y;
        square_Id = sq_id;
        
    }
    public int get_Id(){return square_Id;}
    public void set_Id(int Id){this.square_Id= Id;}
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
        System.out.println("x = "+x+" , y= "+y+ " belongs to object id= "+ this.square_Id );
    }

}
class Object{
    //an object is a sequence of points
    private static int object_Id_generator =0;
    private int object_Id ;
    
    public List<Point> sequence;
    public void add_point(Point a){
        a.set_Id(object_Id);
        sequence.add(a);
    }
    //these object indicate if an object is at the limits and cant be translated further
    //they act as limit switches that turn on once we hit the limits
    private boolean x_is_at_limits;
    private boolean y_is_at_limits;
    private boolean xsize_is_at_limits;
    private boolean ysize_is_at_limits;
    
    public Object(){
        sequence  = new ArrayList<Point>();
        object_Id_generator++;
        object_Id = object_Id_generator;
        x_is_at_limits=false;
        y_is_at_limits=false;
        xsize_is_at_limits=false;
        ysize_is_at_limits=false;
    }
    public double x_heuristic(){
        double h_x=0;
        //this function sums the points that make up the object to measure the overall distance from the object to the x axis
        //it returns the sum of all x's
        for(int i=0;i<this.sequence.size();i++){
            h_x += this.sequence.get(i).get_x();
        }
        return h_x;
    
    }
    public double y_heuristic(){
        double h_y=0;
        //this function sums the points that make up the object to measure the overall distance from the object to the x axis
        //it returns the sum of all x's
        for(int i=0;i<this.sequence.size();i++){
            h_y += this.sequence.get(i).get_y();
        }
        return h_y;
    
    }
    public double heuristic(){
        //this function takes the average of the x and y heuristic
        return this.x_heuristic()+this.y_heuristic();
    }
    public int get_Id(){
    return object_Id;}
    public boolean xlimits(){
        return this.x_is_at_limits;
    };
    public boolean ylimits(){
       return this.y_is_at_limits;
    };
    public boolean xsizelimits(){
        return this.xsize_is_at_limits;
    }
    public boolean ysizelimits(){
        return this.ysize_is_at_limits;
    }
    public void info(){
        System.out.println("the object id is = "+object_Id);
        for(int i=0;i<sequence.size();i++){
            sequence.get(i).info();
        }
        System.out.println("the value of the x heuristic is "+ this.x_heuristic());
        System.out.println("the value of the y heuristic is "+ this.y_heuristic());
        System.out.println("the value of the heuristic is "+ this.heuristic());

    }
    public void translate_object_right(double size,double x_limits){
        //this function translates all the points of object by a value = size   
        //the first loop checks if all the points will be inside the graph when translate 
        //the second loop puts translates them once we know they will not be outside the limits
        //PPPPPSSSSSSS : this algorithms should be reviewed to improve complexity later
         
        //maybe add a test to check that the object is at the limit without going into the loop
        for(int i=0;i<this.sequence.size();i++){
            
            
            //checks if the point is bigger than the limits - I should add something that stops this in the future
            if(this.sequence.get(i).get_x()+size<=x_limits){
               // current.set_x(current.get_x()+size);
            }else{
                this.xsize_is_at_limits = true;
                System.out.println("error this point is over the limit");
                break;
            }
        }
        if(this.xsize_is_at_limits==false){
            //the first statement removes the limits that the object might have had hit  before
            this.x_is_at_limits =false;
            for(int i=0;i<this.sequence.size();i++){
               
                this.sequence.get(i).set_x(this.sequence.get(i).get_x()+size);            }
        }
    }
    public void translate_object_left(double size){
        for(int i=0;i<this.sequence.size();i++){
          
            if(this.sequence.get(i).get_x()-size<0){
               this.x_is_at_limits=true;
               break;
            }
        }
        if(this.x_is_at_limits==false){
            //the first statement removes the limits that the object might have had hit  before
            this.xsize_is_at_limits =false;
        for(int i=0;i<this.sequence.size();i++){
           
           this.sequence.get(i).set_x(this.sequence.get(i).get_x()-size);
            }
        }
    }
    public void translate_object_up(double size,double y_limits){
        
        for(int i=0;i<this.sequence.size();i++){
    
            if(this.sequence.get(i).get_y()+size>=y_limits){
               this.ysize_is_at_limits=true;
               break;
            }
        }
        if(this.ysize_is_at_limits==false){
            //the first statement removes the limits that the object might have had hit  before
            this.y_is_at_limits =false;
        for(int i=0;i<this.sequence.size();i++){
            
            this.sequence.get(i).set_y(this.sequence.get(i).get_y()+size);
            }
        }
    }
    public void translate_object_down(double size){
        
        for(int i=0;i<this.sequence.size();i++){
            
            if(this.sequence.get(i).get_y()-size<0){
               this.y_is_at_limits=true;
               break;
            }
        }
        if(this.y_is_at_limits==false){
            //the first statement removes the limits that the object might have had hit  before
            this.ysize_is_at_limits =false;
        for(int i=0;i<this.sequence.size();i++){
           
            this.sequence.get(i).set_y(this.sequence.get(i).get_y()-size);
            }
        }
    }
    
}
class Square{
    // maybe I should do something to check that no 2 squares at the same point should exist
    private static int ID_counter =0;// id generator - every square has a specific id that will be mapped to it later 
    private int ID;
    private String id_coor;
    private Point coordinates;
    private boolean empty;
    private double size;
    private double x_limits;
    private double y_limits;
    public List<Point> points_in_square;
    public Square(Point c,double s) {
        this.coordinates = c;
        this.size =s;
        empty = true;
        ID_counter++;
        ID=ID_counter; 
        id_coor = coordinates.get_x() +"-"+coordinates.get_y();
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
        if(coordinates.get_x()<=a.get_x()&& coordinates.get_y() <= a.get_y() && a.get_x()< x_limits && a.get_y()< y_limits){
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
    /*
      Function UP uses functionnal programming
      up takes an object and returns a double
      up takes an object ,moves it up to get the heuristic value of the up move then it gets the object 
      to where it was 
      it might be a little bit complex so the complexity needs to be revised later */
    Function<Object, Double> up = (Object input) -> {
            this.translate_up(input.get_Id());
            double a =this.objects_in_square.get(input.get_Id()).heuristic();
            if(input.ysizelimits()==false){
            this.translate_down(input.get_Id());}
            System.out.println("up");
            return a;
        };
    Function<Object, Double> down = (Object input) -> {
            
            this.translate_down(input.get_Id());
            double a =this.objects_in_square.get(input.get_Id()).heuristic();
            if(input.ylimits()==false){
            this.translate_up(input.get_Id());
            }
            System.out.println("down");
            return a;
        };
        Function<Object, Double> right = (Object input) -> {
            this.translate_right(input.get_Id());
            double a =this.objects_in_square.get(input.get_Id()).heuristic();
            if(input.xsizelimits()==false){
            this.translate_left(input.get_Id());}
            System.out.println("right");
            return a;
        };
        Function<Object, Double> left = (Object input) -> {
            this.translate_left(input.get_Id());
            double a =this.objects_in_square.get(input.get_Id()).heuristic();
            if(input.xlimits()==false){
            this.translate_right(input.get_Id());}
            System.out.println("left");
            return a;
        };
        
    //this list will contain the actions of the AI ya3ne l functions tab3ul l translate
    List<Function> actions = new ArrayList<Function>();
    double x;
    double y;
    double number_of_squares;
    double square_area;
    double square_size;
    double max;
    //List <Object> objects_in_square  = new ArrayList<Object>();
    //objects_in_Square stores the objects that are added to the graph and points to them using the mapping
    Map <Integer,Object> objects_in_square =  new HashMap<Integer,Object>();
    //squares_list contains the list of squares that form the graph
    List <Square> squares_list = new ArrayList<Square>();
    //m contains is a mapping fromt the coordinates to the squares 
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
        fill_table();
        System.out.println("heyyaaa ");
        actions.add(up);
        actions.add(down);
        actions.add(left);
        actions.add(right);
       
    }
    // we only use the fill table function once
    //thes function uses the test functions to find the move with the smalles heuristic.
    //it will return an index to the function that is the best move;
    public int find_best_move(int object_id){
        if(this.objects_in_square.containsKey(object_id)){
          
            //watch out for the min you might have to change it later
        double min =1000000;
        int i_min=0;
        for(int i=0;i<actions.size();i++){
            double a = (Double)actions.get(i).apply(this.objects_in_square.get(object_id));
            if(a<=min){
                min =a ;
                i_min =i;
                System.out.println("min is = "+min);
               
            }
                
            }
        return i_min;
        }else{
            System.out.println("OBJECT with id = "+object_id+" is not in the egraph");
        }
        return 0;
        }
    
    public void do_best_move(int object_id){
    if(this.objects_in_square.containsKey(object_id)){
            int index = this.find_best_move(object_id);
            System.out.println("the index of the best move is ==================================================================  "+index );
            switch (index){
                case 0:
                    this.translate_up(object_id);
                    break;
                case 1:
                   
                    this.translate_down(object_id);
                    break;
                case 2:
                    this.translate_left(object_id);
                    break;
                case 3:
                    this.translate_right(object_id);
                    break;
            }
            System.out.println("best action applied");
            }else{
            System.out.println("OBJECT with id = "+object_id+" is not in the egraph");
        }
    }
    public void do_set_of_best_moves(int object_id){ 
        if(this.objects_in_square.containsKey(object_id)){
            if(this.objects_in_square.keySet().size()==0){
            while(this.objects_in_square.get(object_id).xlimits()==false&&this.objects_in_square.get(object_id).ylimits()==false){
                this.do_best_move(object_id);
            }
            System.out.println("THE OBJECT IS IN PLACE CAPTAIN");
            }
            else{
                //this function here moves the object according to the heuristic as long as there is no collusion
                while(this.objects_in_square.get(object_id).xlimits()==false&&this.objects_in_square.get(object_id).ylimits()==false&&this.check_collusion(this.objects_in_square.get(object_id))){
                this.do_best_move(object_id);
            }
            System.out.println("THE OBJECT IS IN PLACE CAPTAIN");
            
            }
            }else{
            System.out.println("OBJECT with id = "+object_id+" is not in the egraph");
        }
    }
    private void fill_table(){
        //function should create a list of squares
        // idea : take the x and y of the point and use it the multiple of x with the divider 
        int counter =0;
        for(int i=0;i<x/square_size;i++){
            for(int j=0;j<y/square_size;j++){
                                
                Square a = new Square(new Point(i*square_size,j*square_size,0),square_size);
                squares_list.add(a);
                
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
    
 //the complexity of add_object msibe 
    public void add_object(Object o){
        /*this function will add the object to the graph ( the piece we are cutting on) 
        the ai algorithm will be applied inside this function on the object */
        if(this.objects_in_square.keySet().size()==0){
            //if the graph has no objects
        this.objects_in_square.put(o.get_Id(), o);
        for(int i=0;i<o.sequence.size();i++){
            // we first find the square which the points is in then we put it inside the square
            m.get(this.find_sq_point(o.sequence.get(i))).add_point(o.sequence.get(i));
            System.out.println("point added");
        }
        this.do_set_of_best_moves(o.get_Id());
        }else{
           
            this.objects_in_square.put(o.get_Id(),o);
            o.info();
            while(this.check_collusion(o)==true && o.xsizelimits()==false && o.ysizelimits()==false){
                //if there is a collusion we keep translating the object up and to the right 
                System.out.println("translate yayyy");
                this.translate_up(o.get_Id());
                this.translate_right(o.get_Id());
            }
            o.info();
            if(this.check_collusion(o)==false){
                System.out.println("eyooo");
               for(int i=0;i<o.sequence.size();i++){
                    // we first find the square which the points is in then we put it inside the square
                     m.get(this.find_sq_point(o.sequence.get(i))).add_point(o.sequence.get(i));
                     System.out.println("point added");
            } 
               o.info();
               this.do_set_of_best_moves(o.get_Id());
            }else{
                   System.out.println("OBJECT CANNOT BE PLACED");
            }
        
        }

    }
    public boolean check_collusion(Object current){
        //Object current = this.objects_in_square.get(object_id);
        if(this.objects_in_square.keySet().size()==0){
            // there is no collusion if only one object is in the graph
            return false;
        }
        for(int i=0;i<current.sequence.size();i++){
            if(m.get(this.find_sq_point(current.sequence.get(i))).state()==false){
                System.out.println("collusion");
                return true;
            };
        }
        System.out.println("no collusion");
        return false;
    }
    public void remove_object(Object o){
        //this function removes the object that the add_object functions puts in the graph
        this.objects_in_square.remove(o.get_Id());
        for(int i=0;i<o.sequence.size();i++){
            m.get(this.find_sq_point(o.sequence.get(i)));
            System.out.println("point removed");
        }
        
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
 

    public String find_sq_point(Point a){
        //this function find the string id of the point a
        double a1 = a.get_x();
        a1 = a1-a1%this.square_size;
        double a2 = a.get_y();
        a2 = a2-a2%this.square_size;
        
        String s = Double.toString(a1)+"-"+Double.toString(a2);
        
        return s;
        
    }
    public void info(){
        for(String i:m.keySet()){
            System.out.println( "key = "+i);
            m.get(i).info();
        }
        System.out.println("the objects in this graph are : ");
        for(int i:objects_in_square.keySet()){
            this.objects_in_square.get(i).info();
        }
    }
    public void translate_right(int object_id){
        //first check if the object is in the graph  
        if(this.objects_in_square.containsKey(object_id)){
          
            if(this.objects_in_square.get(object_id).xsizelimits()==false){
            //this.remove_object(this.objects_in_square.get(object_id));
           this.objects_in_square.get(object_id).translate_object_right(this.square_size,this.x);
           // this.add_object(this.objects_in_square.get(object_id));
            }else{
                System.out.println("current xsizelimits are true cant move object right ");
            }
        }else{
            System.out.println("OBJECT with id = "+object_id+" is not in the egraph");
        }
    }
    public void translate_left(int object_id){
        //first check if the object is in the graph  
        if(this.objects_in_square.containsKey(object_id)){
            
            if(this.objects_in_square.get(object_id).xlimits()==false){
            //this.remove_object(this.objects_in_square.get(object_id));
            this.objects_in_square.get(object_id).translate_object_left(this.square_size);
            //this.add_object(this.objects_in_square.get(object_id));
            }else{
                System.out.println("current xlimits are true cant move object left");
            }
        }else{
            System.out.println("OBJECT with id = "+object_id+" is not in the egraph");
        }
    }
    public void translate_up(int object_id){
        //first check if the object is in the graph  
        if(this.objects_in_square.containsKey(object_id)){
            
            if(this.objects_in_square.get(object_id).ysizelimits()==false){
                
            //this.remove_object(this.objects_in_square.get(object_id));
            this.objects_in_square.get(object_id).translate_object_up(this.square_size,this.y);
            //this.add_object(this.objects_in_square.get(object_id));
            }else{
                System.out.println("current ysizelimits are true cant move object up ");
            }
        }else{
            System.out.println("OBJECT with id = "+object_id+" is not in the egraph");
        }
    }
    public void translate_down(int object_id){
        //first check if the object is in the graph  
        if(this.objects_in_square.containsKey(object_id)){
            
            if(this.objects_in_square.get(object_id).ylimits()==false){
                System.out.println("test thissssssssssssssssss");
            //this.remove_object(this.objects_in_square.get(object_id));
            this.objects_in_square.get(object_id).translate_object_down(this.square_size);
            //this.add_object(this.objects_in_square.get(object_id));
            }else{
                System.out.println("current ylimits are true cant move object down ");
            }
        }else{
            System.out.println("OBJECT with id = "+object_id+" is not in the egraph");
        }
    }
    
    
}