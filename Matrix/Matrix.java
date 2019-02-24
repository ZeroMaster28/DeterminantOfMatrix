
package Matrix;

import java.lang.Math;
import java.util.Scanner;
import ComplexNumbers.Complex;
import java.util.Arrays;

public class Matrix 
{
    int x,y;
    double[][] a;
    public Matrix()
    {
       this.x=1;
       this.y=1;
       a=new double[1][1];
       
    }
    public Matrix(int row, int column)
    {
        if(row==0||column==0) 
        {
            this.x=1;
            this.y=1;
            a=new double[1][1];
        }
        else
        { 
            
        this.x=Math.abs(row);
        this.y=Math.abs(column);
        a=new double[this.x][this.y];
        
        }
    }

    public void setValues()
    {   Scanner scan = new Scanner(System.in);
        for(int i=0;i<x;i++)
        for(int j=0;j<y;j++)
        {
            System.out.println("a"+(int)(i+1)+""+(int)+(j+1)+"=");
            a[i][j]=scan.nextInt();
        }
    }
    public void draw()
    {
        for(int i=0;i<x;i++) 
        {  System.out.print("[");
            for(int j=0;j<y;j++)
            {
             System.out.print(a[i][j]+" ");
             }
     System.out.println("]");
         }
    }
    public void switchColumns(int n, int m)
    {   
        if(n<this.y||m<this.y)
        {
            for(int i=0;i<this.x;i++)
            {
                double pom=a[i][n];
                a[i][n]=a[i][m];
                a[i][m]=pom;
            }
        }
        
    }
    public int findNonZero(int i)
    {
        for(int j=0;j<this.y;j++)
        if(a[i][j]!=0) return j;
        
        return -1;
    }
    public void minusRows(int a1,int a2, double k)//rows: a1 - k*a2
    {
        for(int j=0;j<this.y;j++) a[a1][j]-=a[a2][j]*k;
    }
    public int determiner()
    {
        int sign=1;
        if(this.x!=this.y)  throw new IllegalArgumentException("Rows must equal columns");
        
        for(int i =0;i<this.x-1;i++) //traversal through rows
        {
            int k=i;
            if(a[i][i]==0)
            {k=this.findNonZero(i);
            if(k==-1)return 0;
            this.switchColumns(i,k);
            sign*=(-1);
            }
            
            for(int j=i+1;j<this.x;j++) 
            {
                this.minusRows(j,i,a[j][i]/a[i][i]);
            }
            
      
        }
        int det=1;
        for(int i=0;i<this.x;i++) det*=a[i][i];
        
        return sign*det;
        
    }
    
}
