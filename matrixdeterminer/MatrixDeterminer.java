
package matrixdeterminer;

import ComplexNumbers.Complex;
import java.util.Scanner;
import Matrix.Matrix;


public class MatrixDeterminer {

    
    public static void main(String[] args) 
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Real Numbers: R \n"+"Complex Numbers: C");
        String option= scan.next();
        System.out.println("Number of rows: ");
        int n=scan.nextInt();
        
        switch(option)
        {
            case "R":
                {
                   Matrix matrix=new Matrix(n,n);
                   matrix.setValues();
                   matrix.draw();
                   System.out.println("determiner: "+matrix.determiner());
                } break;
            case "C":
            {
                System.out.println("What is your complex number");
                String s=scan.next();
                Complex z=new Complex(s);
                System.out.println(z);
            }
        }
        
        scan.next();
        
         
    }
        
        

      
     
    }
    

