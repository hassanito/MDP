/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication28;

import java.awt.Color;
import java.util.*;
import java.math.*;
import java.util.function.Function;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame; 

class MyCanvas extends JComponent {
  public void paint(Graphics gg) {
      
       Graph g = new Graph(500,500,8);
     
       Point a1 = new Point(200,200,0);
       Point a2 = new Point(250,200,0);
       Point a3 = new Point(270,300,0);
       Point a4 = new Point(230,300,0);
       Object o1 = new Object();
       o1.add_point(a1);
       o1.add_point(a2);
       o1.add_point(a3);
       o1.add_point(a4);
       //g.rotate(1, Math.PI/2);
       //o1.info();
      // g.add_object(o1);
       //o1.rotate(Math.PI/2);
      // g.rotate(1, Math.PI/2);
      // g.rotate(1, Math.PI/2);
       //Object 2
       Point b1 = new Point(250,300,0);
       Point b2 = new Point(370,300,0);
       Point b3 = new Point(400,400,0);
       Point b4 = new Point(330,450,0);
       Object o2 = new Object();
       o2.add_point(b1);
       o2.add_point(b2);
       o2.add_point(b3);
       o2.add_point(b4);
       
       //g.add_object(o2);
       
       Object o3= new Object();
       Point c1 = new Point(350,350,0);
       Point c2 = new Point(450,350,0);
       Point c3 = new Point(450,450,0);
       Point c4 = new Point(350,450,0);
       o3.add_point(c1);
       o3.add_point(c2);
       o3.add_point(c3);
       o3.add_point(c4);
    //   g.add_object(o3);
        g.add_object(o1);
        g.add_object(o2);
        g.add_object(o3);
        System.out.println(o1.heuristic());
        
       
        
        Graphics2D g2 = (Graphics2D) gg;
    // draw a rectangle
    double leftX = 55.5;
    double topY = 100;
    double width = 200;
    double height = 150;
    
    //Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
    
//g2.draw(rect);
    for(String i:g.m.keySet()){
          /* System.out.println( "key = "+i);
    
           System.out.println("x= "+g.m.get(i).get_x());
          
           System.out.println("y = "+ g.m.get(i).get_y());
           System.out.println("size = "+ g.m.get(i).get_square_size());
          */
           int s = 0;
           Rectangle2D rect = new Rectangle2D.Double(g.m.get(i).get_x(),g.m.get(i).get_y(), g.m.get(i).get_square_size(),  g.m.get(i).get_square_size());
           
           if(g.m.get(i).is_empty()==false){
               g2.setColor(Color.red);
               g2.fill(rect);
               g2.setColor(Color.black);
               
           }else{
            // g2.draw(rect);
           }
          
        }
    System.out.println("bouuuu");
   
  }

}


/**
 *
 * @author hassan
 */
public class MDP  {
 
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
       JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 500, 500);
        window.getContentPane().add(new MyCanvas());
        window.setVisible(true);
        
        System.out.println("bon");
  
 
    }
    }
    


class Point{
    private double x;
    private double y;
    private boolean flag;
    //added the square id so every point will be recognized by the object it belongs to and vice versa
    private int square_Id=0;
    public Point(double x,double y,int sq_id){
        this.x =x;
        this.y =y;
        this.flag =false;
        square_Id = sq_id;
        
        
    }
    public void set_flag(boolean v){
        this.flag =v;
    }
    public int get_Id(){return square_Id;}
    public void set_Id(int Id){this.square_Id= Id;}
    public double get_x(){
        return this.x;
    }
    public double get_y(){
        return y;
    }
    public boolean get_flag(){
        return flag;
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
    //this function checks if the object is rotatble
    public boolean is_rotatble(double angle,Point o,double xlimits,double ylimits){
        double a = this.x;
        double b = this.y;
        double c = Math.cos(angle);
        double s = Math.sin(angle);
        a -= o.x;
        b -= o.y;
        double xnew =a*c -b*s;
        double ynew = a*s +b*c;
        a = xnew +o.x;
        b= ynew +o.y;
        if(a>0 && b>0 && a<xlimits && b<ylimits){
            return true;
        }else{
            return false;
        }
    }
    //this function rotates th object 
    public void rotate90(Point o){   
        double a = -(this.y-o.y)+o.x;
        double b =(this.x-o.x)+o.y;
        this.x = a;
        this.y = b;
    }
    public void rotate(double angle,Point o){
        double a =  (this.x-o.x)*Math.cos(angle)-(this.y-o.y)*Math.sin(angle)+o.x;
        double b = (this.x -o.x)*Math.sin(angle)+ (this.y-o.y)*Math.cos(angle)+o.y;
        this.x=a;
        this.y=b;
    }
}
class Object{
    //an object is a sequence of points
    private static int object_Id_generator =0;
    private int object_Id ;
    Graph g;

    public java.util.List<Point> sequence;
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
    public java.util.List <Point> boundaries;
    public boolean colluded;
    public Object(){
        sequence  = new ArrayList<Point>();
        object_Id_generator++;
        object_Id = object_Id_generator;
        x_is_at_limits=false;
        y_is_at_limits=false;
        xsize_is_at_limits=false;
        ysize_is_at_limits=false;
        colluded = false;
    }
    public void limits_info(){
        System.out.println("x limits reached "+this.x_is_at_limits);
        System.out.println("xsize limits reached "+this.xsize_is_at_limits);
        System.out.println("y limits reached "+this.y_is_at_limits);
        System.out.println("ysize limits reached "+this.ysize_is_at_limits);


                
    }
   
    public boolean is_object_rotatable(double angle){
        for(int i=0;i<this.sequence.size();i++){
            if(this.sequence.get(i).is_rotatble(angle, this.center(), this.g.x, this.g.y)==false){
                return false;
            }
        }
        return true;
    
    }
    public boolean is_rotatable(){
        boolean a = this.is_object_rotatable(Math.PI/2);
        boolean b = this.is_object_rotatable(-Math.PI/2);
        boolean c = this.is_object_rotatable(Math.PI);
        boolean d = this.is_object_rotatable(-Math.PI);
        if(a==false||b==false||c==false||d==false){
            return false;
        }else{
            return true;
        }

    }
    
    public Point center(){
        Point p;
        double x= 0;
        double y=0;
        for(int i=0;i<this.sequence.size();i++){
            x += this.sequence.get(i).get_x();
            y +=this.sequence.get(i).get_y();
            
        }
        x = x/this.sequence.size();
        y = y/this.sequence.size();
        p = new Point(x,y,this.object_Id);
        return p;
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
            
            
            if(this.sequence.get(i).get_x()+size>=x_limits){
                this.xsize_is_at_limits =true;
                break;
            }
        }
        if(this.xsize_is_at_limits==false){
            //the first statement removes the limits that the object might have had hit  before
            this.x_is_at_limits =false;
            for(int i=0;i<this.sequence.size();i++){
               // the sq finds the square of this point
            String sq = g.find_sq_point(this.sequence.get(i));
           // this line removes the point from the square
            g.m.get(sq).remove_point(this.sequence.get(i));
            this.sequence.get(i).set_x(this.sequence.get(i).get_x()+size);     
            // the sq finds the square of this point
            String sq2 = g.find_sq_point(this.sequence.get(i));
           // this line removes the point from the square
            g.m.get(sq2).add_point(this.sequence.get(i));
            //finds collusion
           if(g.m.get(sq2).get_contains_same_object()== false){
                System.out.println("contains same object "+g.m.get(sq2).get_contains_same_object());
                                this.colluded = true;

           }
            }
    
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
           // the sq finds the square of this point
            String sq = g.find_sq_point(this.sequence.get(i));
           // this line removes the point from the square
            g.m.get(sq).remove_point(this.sequence.get(i));
           this.sequence.get(i).set_x(this.sequence.get(i).get_x()-size);
           // the sq finds the square of this point
            String sq2 = g.find_sq_point(this.sequence.get(i));
           // this line removes the point from the square
            g.m.get(sq2).add_point(this.sequence.get(i));
           //finds collusions 
       if(g.m.get(sq2).get_contains_same_object()== false){
                System.out.println("contains same object "+g.m.get(sq2).get_contains_same_object());
                                this.colluded = true;

       }
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
            // the sq finds the square of this point
            String sq = g.find_sq_point(this.sequence.get(i));
           // this line removes the point from the square
            g.m.get(sq).remove_point(this.sequence.get(i));
            this.sequence.get(i).set_y(this.sequence.get(i).get_y()+size);
            //over here we add the point to the new square
            String sq2 = g.find_sq_point(this.sequence.get(i));
            g.m.get(sq2).add_point(this.sequence.get(i));
            if(g.m.get(sq2).get_contains_same_object()== false){
                System.out.println("contains same object "+g.m.get(sq2).get_contains_same_object());
                this.colluded = true;
            }
            
         
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
           // the sq finds the square of this point
            String sq = g.find_sq_point(this.sequence.get(i));
           // this line removes the point from the square
            g.m.get(sq).remove_point(this.sequence.get(i));
            this.sequence.get(i).set_y(this.sequence.get(i).get_y()-size);
            // the sq finds the square of this point
            String sq2 = g.find_sq_point(this.sequence.get(i));
           // this line removes the point from the square
            g.m.get(sq2).add_point(this.sequence.get(i));
            if(g.m.get(sq2).get_contains_same_object()== false){
                System.out.println("contains same object "+g.m.get(sq2).get_contains_same_object());
                                this.colluded = true;

            }
        }
        }
    }
    //this function rotates an object 90 degrees
    //using the xlimits might cause a problem
    //maybe I should use a rotate limit
    public void rotate(double angle){
        //System.out.println("getting there");
        //this.rotation_is_at_limits =false;
        
        if(this.is_object_rotatable(angle)==true){
            //the first statement removes the limits that the object might have had hit  before
        Point center = this.center();
        for(int i=0;i<this.sequence.size();i++){
           // the sq finds the square of this point
            String sq = g.find_sq_point(this.sequence.get(i));
           // this line removes the point from the square
            g.m.get(sq).remove_point(this.sequence.get(i));
           
            this.sequence.get(i).rotate(angle,center);
            // the sq finds the square of this point
            String sq2 = g.find_sq_point(this.sequence.get(i));
           // this line removes the point from the square
            g.m.get(sq2).add_point(this.sequence.get(i));
            if(g.m.get(sq2).get_contains_same_object()== false){
                System.out.println("contains same object "+g.m.get(sq2).get_contains_same_object());
                                this.colluded = true;

            }
        }
        }
    }
    //this function finds the boundaries points between 2 points    
    public java.util.List<Point> find_boundaries(Point a,Point b){
        java.util.List<Point> bound= new ArrayList<Point>();
        double slope=0;
     
        slope = (b.get_y()- a.get_y())/(b.get_x()-a.get_x());
        if(a.get_x()<b.get_x()){
        for(int i=0;i<g.xvar.size();i++){
            double v = g.xvar.get(i);
            double c=0;
            if(v>=a.get_x() && v<= b.get_x()){
                c = slope *(v-a.get_x()) +a.get_y();
                Point p = new Point(v,c,0);
                p.set_flag(true);
                bound.add(p);
                this.add_point(p);
                //p.info();
            }
        }}else{
        for(int i=0;i<g.xvar.size();i++){
            double v = g.xvar.get(i);
            double c=0;
            if(v<=a.get_x() && v>= b.get_x()){
                c = slope *(v-a.get_x()) +a.get_y();
                Point p = new Point(v,c,0);
                bound.add(p);
                this.add_point(p);
                //p.info();
            }
        }
        }
        if(a.get_y()<b.get_y()){
        for(int i=0;i<g.yvar.size();i++){
            double v = g.yvar.get(i);
            double c=0;
            if(v>=a.get_y() && v<= b.get_y()){
                c = (1/slope) *(v-a.get_y()) +a.get_x();
                Point p = new Point(c,v,0);
                bound.add(p);
                this.add_point(p);
               // p.info();
            }
        }}else{
        
        for(int i=0;i<g.yvar.size();i++){
            double v = g.yvar.get(i);
            double c=0;
            if(v<=a.get_y() && v>= b.get_y()){
                c = (1/slope) *(v-a.get_y()) +a.get_x();
                Point p = new Point(c,v,0);
                bound.add(p);
                this.add_point(p);
              //  p.info();
            }
        }
        }
        
        return bound;
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
    public double id_x;
    public double id_y;
    private int object_id;
    public java.util.List<Point> points_in_square;
    //this variable confirms that all points in this square belong to the same object
    boolean contains_same_object;
    public Square(Point c,double s) {
        this.coordinates = c;
        this.size =s;
        empty = true;
        ID_counter++;
        ID=ID_counter; 
        double id_x = coordinates.get_x();
        double id_y =coordinates.get_y();
        id_coor = coordinates.get_x() +"-"+coordinates.get_y();
        object_id =0;

         
        
        // ID counter is static (class related) so it keeps increasing with every object square we create
        // ID is object related so every object created will have a value;
        x_limits = c.get_x()+size;
        y_limits = c.get_y() +size;
        points_in_square = new ArrayList<Point>();
       // System.out.println("the id of this square is = "+ID);
        
    }
    public boolean get_contains_same_object(){
        int pId = this.points_in_square.get(0).get_Id();
        for(int i=1;i<this.points_in_square.size();i++){
            if(this.points_in_square.get(i).get_Id()!=pId){
                System.out.println("point id = " +this.points_in_square.get(i).get_Id());
                return false;
            }
        }
        return true;
    }
    public void set_object_id(int id){
        this.object_id = id;
    }
    public int get_object_id(){
        return this.object_id;
    }
    public double get_square_size(){
        return this.size;
       }
    public void set_empty(boolean state){
        empty = state;
    }
    public boolean is_empty(){
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
            if(this.points_in_square.size()>=1&& this.get_object_id()!= a.get_Id()){
              }
           
            points_in_square.add(a);
            this.object_id = a.get_Id();
            this.set_empty(false);
       } else{
            throw new IllegalStateException("add_point: Should not get here!!!");

        }
}
    public void remove_point(Point a){
        //this function removes a point from a square and if the square has no points left it will become empty
        if(points_in_square.contains(a)){
            //System.out.println("yes it does ya hmar");
            points_in_square.remove(a);
            
        } else {
            throw new IllegalStateException("remove_point: Should not get here!!!");
        }
        if(points_in_square.isEmpty()){
            this.object_id =0;
            this.set_empty(true);
        }
    }
    
    
    public void info(){
        System.out.print("square COOR "+id_coor+" with an id = "+ID+" of size = "+ size +" and coordinates ");
        coordinates.info();
        System.out.println("The id of the object contained in this square is = "+this.object_id);
      
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
            if(input.ysizelimits()==false||input.colluded==true){
            this.translate_down(input.get_Id());}
            //System.out.println("up");
            return a;
        };
    Function<Object, Double> down = (Object input) -> {
            
            this.translate_down(input.get_Id());
            double a =this.objects_in_square.get(input.get_Id()).heuristic();
            if(input.ylimits()==false||input.colluded==true){
            this.translate_up(input.get_Id());
            }
            //System.out.println("down");
            return a;
        };
        Function<Object, Double> right = (Object input) -> {
            this.translate_right(input.get_Id());
            double a =this.objects_in_square.get(input.get_Id()).heuristic();
            if(input.xsizelimits()==false||input.colluded==true){
            this.translate_left(input.get_Id());}
            //System.out.println("right");
            return a;
        };
        Function<Object, Double> left = (Object input) -> {
            this.translate_left(input.get_Id());
            double a =this.objects_in_square.get(input.get_Id()).heuristic();
            
            if(input.xlimits()==false||input.colluded==true){
            this.translate_right(input.get_Id());}
            return a;
        };
        Function <Object,Double> rotate90 = (Object input)->{
            this.rotate(input.get_Id(), Math.PI/2);
            double a= this.objects_in_square.get(input.get_Id()).heuristic();
            if(input.colluded==true){
                this.rotate(input.get_Id(),-Math.PI/2);
            }
            return a;
        };
        Function <Object,Double> rotatem90 = (Object input)->{
            this.rotate(input.get_Id(), -Math.PI/2);
            double a= this.objects_in_square.get(input.get_Id()).heuristic();
            if(input.colluded==true){
                this.rotate(input.get_Id(),+Math.PI/2);
            }
            return a;
        };
        Function <Object,Double> rotate180 = (Object input)->{
            this.rotate(input.get_Id(), Math.PI);
            double a= this.objects_in_square.get(input.get_Id()).heuristic();
            if(input.colluded==true){
                this.rotate(input.get_Id(),-Math.PI);
            }
            return a;
        };
        Function <Object,Double> rotatem180 = (Object input)->{
            this.rotate(input.get_Id(), -Math.PI);
            double a= this.objects_in_square.get(input.get_Id()).heuristic();
            if(input.colluded==true){
                this.rotate(input.get_Id(),+Math.PI);
            }
            return a;
        };
        Function <Object,Double> rotate45 = (Object input)->{
            this.rotate(input.get_Id(), Math.PI/4);
            double a= this.objects_in_square.get(input.get_Id()).heuristic();
            if(input.colluded==true){
                this.rotate(input.get_Id(),-Math.PI/4);
            }
            return a;
        };
        Function <Object,Double> rotatem45 = (Object input)->{
            this.rotate(input.get_Id(), -Math.PI/4);
            double a= this.objects_in_square.get(input.get_Id()).heuristic();
            if(input.colluded==true){
                this.rotate(input.get_Id(),Math.PI/4);
            }
            return a;
        };
        Function <Object,Double> rotate135 = (Object input)->{
            this.rotate(input.get_Id(), 3*Math.PI/4);
            double a= this.objects_in_square.get(input.get_Id()).heuristic();
            if(input.colluded==true){
                this.rotate(input.get_Id(),-3*Math.PI/4);
            }
            return a;
        };
        Function <Object,Double> rotatem135 = (Object input)->{
            this.rotate(input.get_Id(), -3*Math.PI/4);
            double a= this.objects_in_square.get(input.get_Id()).heuristic();
            if(input.colluded==true){
                this.rotate(input.get_Id(),3*Math.PI/4);
            }
            return a;
        };
    //this list will contain the actions of the AI ya3ne l functions tab3ul l translate
    java.util.List<Function<Object, Double>> actions = new java.util.ArrayList<>();
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
    java.util.List <Square> squares_list = new ArrayList<Square>();
    
    //m contains is a mapping fromt the coordinates to the squares 
    Map <String,Square > m = new HashMap<String,Square>();
    //the hashmap is a sorted table of all the squares in the graph to make it easy to find which squares do points belong to
    //  Map <Double,List<List<Double>>> entry2 = new HashMap<Double,List<List<Double>>>();
    Double[] arr;
    //xvar and yvar lists contain the x and y of that divide the grid 
    java.util.List <Double> xvar = new ArrayList<Double>();
    java.util.List <Double> yvar = new ArrayList<Double>();
    private double heuristic;
    private double n;
    public Graph(double x,double y,int n){
        this.x =x;
        this.y = y;
        //the number of squares is always a power of 4 
        heuristic =0;
        this.number_of_squares =Math.pow(4,n);
        square_area = (x*y)/number_of_squares;
        square_size = Math.sqrt(square_area);
        this.n = n;
        fill_table();
        System.out.println("heyyaaa ");
        actions.add(up);
        actions.add(down);
        actions.add(left);
        actions.add(right);
        actions.add(rotate90);
        actions.add(rotatem90);
        actions.add(rotate180);
        actions.add(rotatem180);
        //actions.add(rotate45);
        //actions.add(rotatem45);
        //actions.add(rotate135);
        //actions.add(rotatem135);
    
        }
    public double calculate_heuristic(){
        //System.out.println("we get here");
        for(int i=1;i<=this.objects_in_square.size();i++){
        heuristic += this.objects_in_square.get(i).heuristic();
        }
        return this.heuristic;
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
            double a = actions.get(i).apply(this.objects_in_square.get(object_id));
            if(a<=min){
                min =a ;
                i_min =i;
                //System.out.println("min is = "+min);
               
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
          //  System.out.println("the index of the best move is ==================================================================  "+index );
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
                case 4:
                    this.rotate(object_id, Math.PI/2);
                    break;
                case 5:
                    this.rotate(object_id,-Math.PI/2);
                    break;
                case 6:
                    this.rotate(object_id, Math.PI);
                    break;
                case 7:
                    this.rotate(object_id, -Math.PI);
                    break;
                case 8:
                    this.rotate(object_id, Math.PI/4);
                    break;
                case 9:
                    this.rotate(object_id, -Math.PI/4);
                    break;
                case 10:
                    this.rotate(object_id, 3*Math.PI/4);
                    break;
                case 11:
                    this.rotate(object_id, -3*Math.PI/4);
                    break;
            }
            //System.out.println("best action applied");
            }else{
            System.out.println("OBJECT with id = "+object_id+" is not in the egraph");
        }
    }
    public void do_set_of_best_moves(int object_id){ 
        
        
        if(this.objects_in_square.keySet().size()>=1){
              double old=1;
              double nouv=0;
              int i=0;
              //this while lop is a permenant fix
              System.out.println("we are entering the loop");
              // this is the non classical search function
              /*while(nouv<=old){
                  old= this.objects_in_square.get(object_id).heuristic();
                  this.do_best_move(object_id);
                  System.out.println("the best move was = "+this.find_best_move(object_id));
                  nouv = this.objects_in_square.get(object_id).heuristic();
                  System.out.println(" i = "+i);
                  System.out.println("old = "+old);
                  System.out.println("nouv = "+nouv);

                  i++;
              }*/
            i=0;
            while(this.objects_in_square.get(object_id).xlimits()==false || this.objects_in_square.get(object_id).ylimits()==false||this.objects_in_square.get(object_id).is_rotatable()==false){
                if(i>1000){
                break;
                }
                this.do_best_move(object_id);
                System.out.println(i); 
                i++;
                
            }     
        }else{
          
        /*
        if(this.objects_in_square.containsKey(object_id)){
            if(this.objects_in_square.keySet().size()==0){
            while(this.object_collusion(this.objects_in_square.get(object_id))==false){
                this.do_best_move(object_id);
            }
            System.out.println("THE OBJECT IS IN PLACE CAPTAIN");
            }
            else{
                //this function here moves the object according to the heuristic as long as there is no collusion
                while(this.objects_in_square.get(object_id).xlimits()==false&&this.objects_in_square.get(object_id).ylimits()==false){
                    this.do_best_move(object_id);
            }
            System.out.println("THE OBJECT IS IN PLACE CAPTAIN");
            
            }
            }else{
            System.out.println("OBJECT with id = "+object_id+" is not in the egraph");
        }*/
    }
    }
    private void fill_table(){
        //function should create a list of squares
        // idea : take the x and y of the point and use it the multiple of x with the divider 
        int counter =0;
        for(int i=0;i<x/square_size;i++){
             xvar.add(i*square_size);
             yvar.add(i*square_size);
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
        //o.g makes adds this graph as an attribute so we can do functions over it
        o.g = this;
        if(this.objects_in_square.keySet().size()==0){
            //if the graph has no objects
        this.objects_in_square.put(o.get_Id(), o);
        //we build the boundaries in this loop
         for(int i=0;i<o.sequence.size()-1;i++){
            if(o.sequence.get(i).get_flag()==true){
                break;
            }    
            o.find_boundaries(o.sequence.get(i), o.sequence.get(i+1));
           
            
        }
         
        for(int i=0;i<o.sequence.size();i++){
            // we first find the square which the points is in then we put it inside the square
            
            m.get(this.find_sq_point(o.sequence.get(i))).add_point(o.sequence.get(i));
            
            
            
        //    System.out.println("point added");
        }
        // the fact that if a point is bigger than the other might be a problem
        // I should add this later when it works
         this.do_set_of_best_moves(o.get_Id());
        }else{
            
            // we add the object to the square
            this.objects_in_square.put(o.get_Id(),o);
            //we find the boundaries of the object 
            for(int i=0;i<o.sequence.size()-1;i++){
            if(o.sequence.get(i).get_flag()==true){
                break;
            }    
            o.find_boundaries(o.sequence.get(i), o.sequence.get(i+1));
           
        }
            for(int i=0;i<o.sequence.size();i++){
                    // we first find the square which the points is in then we put it inside the square
                     m.get(this.find_sq_point(o.sequence.get(i))).add_point(o.sequence.get(i));
             //        System.out.println("point added");
            }
            
            while( o.xsizelimits()==false || o.ysizelimits()==false){
                //if there is a collusion we keep translating the object up and to the right 
               // System.out.println("translate yayyy");
                this.translate_up(o.get_Id());
                this.translate_right(o.get_Id());
            }
            if(o.xsizelimits()==true || o.ysizelimits()==true ||o.xlimits()==true || o.ylimits()==true){
                this.do_set_of_best_moves(o.get_Id());
            };
          
        }

    }
    public boolean object_collusion(Object current){
        //Object current = this.objects_in_square.get(object_id);
        if(this.objects_in_square.keySet().isEmpty()==true){
            // there is no collusion if only one object is in the graph
            return false;
        }
        for(int i=0;i<current.sequence.size();i++){
            if(m.get(this.find_sq_point(current.sequence.get(i))).get_object_id()!= current.sequence.get(i).get_Id()){
                System.out.println("object id= "+m.get(this.find_sq_point(current.sequence.get(i))).get_object_id());
                System.out.println(current.sequence.get(i).get_Id());
                System.out.println("collusion");
                // throw new IllegalStateException("OBJECT with id = "+object_id+" is not in the egraph");
                 //ntebeh hon
                 return true;
            };
        }
        System.out.println("no collusion");
        return false;
        // if we have a collusion we return true otherwise we return true
    }
    public void remove_object(Object o){
        //this function removes the object that the add_object functions puts in the graph
        this.objects_in_square.remove(o.get_Id());
        for(int i=0;i<o.sequence.size();i++){
            // the thing is you should remove the points from the squares too
            String sq = this.find_sq_point(o.sequence.get(i));
            m.get(sq).remove_point(o.sequence.get(i));
          //  System.out.println("point removed");
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
 

    public  String find_sq_point(Point a){
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
               // System.out.println("current xsizelimits are true cant move object right ");
            }
           
        }else{
            System.out.println("OBJECT with id = "+object_id+" is not in the egraph");
        }
        if(this.objects_in_square.get(object_id).colluded==true){
               this.objects_in_square.get(object_id).colluded=false;
               this.translate_left(object_id);
               
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
                //System.out.println("current xlimits are true cant move object left");
            }
            
        }else{
            System.out.println("OBJECT with id = "+object_id+" is not in the egraph");
        }
        if(this.objects_in_square.get(object_id).colluded==true){
               this.objects_in_square.get(object_id).colluded=false;
               this.translate_right(object_id);
               
            }
    }
    public void translate_up(int object_id){
       // System.out.println("WE TRANSLATED THE OBJECT UP");
        //first check if the object is in the graph  
        if(this.objects_in_square.containsKey(object_id)){
            
            if(this.objects_in_square.get(object_id).ysizelimits()==false ){
                
            //this.remove_object(this.objects_in_square.get(object_id));
            this.objects_in_square.get(object_id).translate_object_up(this.square_size,this.y);
            //this.add_object(this.objects_in_square.get(object_id));
            
            }else{
                //System.out.println("current ysizelimits are true cant move object up ");
            }
            
        }else{
            System.out.println("OBJECT with id = "+object_id+" is not in the egraph");
           throw new IllegalStateException("OBJECT with id = "+object_id+" is not in the egraph");

        }
        if(this.objects_in_square.get(object_id).colluded==true){
               this.objects_in_square.get(object_id).colluded=false;
               this.translate_down(object_id);
               
            }
    }
    public void translate_down(int object_id){
        //first check if the object is in the graph  
        if(this.objects_in_square.containsKey(object_id)){
            
            if(this.objects_in_square.get(object_id).ylimits()==false){
               // System.out.println("test thissssssssssssssssss");
            //this.remove_object(this.objects_in_square.get(object_id));
            this.objects_in_square.get(object_id).translate_object_down(this.square_size);
            //this.add_object(this.objects_in_square.get(object_id));
           
            }else{
                //System.out.println("current ylimits are true cant move object down ");
            }
        }else{
           // System.out.println("OBJECT with id = "+object_id+" is not in the egraph");
        }
        if(this.objects_in_square.get(object_id).colluded==true){
               this.objects_in_square.get(object_id).colluded=false;
               this.translate_up(object_id);
               
            }
    }
    public void rotate(int object_id,double angle){
        //first check if the object is in the graph  
        if(this.objects_in_square.containsKey(object_id)){
            Object c = this.objects_in_square.get(object_id);
            if(c.is_object_rotatable(angle)==true){
               
               // System.out.println("test thissssssssssssssssss");
            //this.remove_object(this.objects_in_square.get(object_id));
          // System.out.println("THIS SHIT SUPPOSEDLY WORKS");
            this.objects_in_square.get(object_id).rotate(angle);
            //this.add_object(this.objects_in_square.get(object_id));
           
            }else{
                //System.out.println("current ylimits are true cant move object down ");
                           // System.out.println("THIS SHIT MIGHT BE WORKING");

            }
        }else{
        //    System.out.println("THIS SHIT IS NOT WORKING");
        }
        if(this.objects_in_square.get(object_id).colluded==true){
               this.objects_in_square.get(object_id).colluded=false;
               
               this.rotate(object_id,-angle);
               
            }
    }
   
    
    
}