package ComplexNumbers;



import java.lang.Math;
import static java.lang.Math.pow;


public class Complex 
{
   
    double x,y;
    
    
   public Complex()
    {
        this.x=0;
        this.y=0;
    }
    public Complex(double x,double y)
    {
        this.x=x;
        this.y=y;
    }
    public Complex(String z)
    {
         int k=0;//switcher
        int[] tab= new int[z.length()];
        for(int i=0; i<z.length();i++)
        {
            if(z.charAt(i)==' ') {tab[i]=-3; continue;}
            if(z.charAt(i)=='i') {tab[i]=-2; continue;}
             if(z.charAt(i)=='+'){ tab[i]=-1; continue;}
             else if(Integer.parseInt(z.charAt(i)+"")<=9&&Integer.parseInt(""+z.charAt(i))>=0)
            {
                tab[i]=Integer.parseInt(z.charAt(i)+"");
            }
            else tab[i]=0;
        }
        
       
        double decimal=0.0d;
        for(int j=tab.length-1;j>=0;j--)
        {
            if(tab[j]==-2)
            {
                decimal=0.0d;
                k=0;
                
            }
            if(tab[j]==-1)
            {
                decimal=0.0d;
                k=1;
            }
            
            if(k==0 && tab[j]>=0) 
            {this.y+=Math.pow(10d,decimal)*tab[j];
            decimal+=1.0d;
            }
             if(k==1&&tab[j]>=0) 
            {this.x+=Math.pow(10d,decimal)*tab[j];
            decimal+=1.0d;
            }
        }
        
        
    }
    public boolean equals(Complex complex)
    {
        if(this.x!=complex.x) return false;
        if(this.y!=complex.y) return false;
        
        return true;
    }
    public double modulus()
    {
        double a=this.x,b=this.y;
        return Math.pow(a*a+b*b,0.5);
    }
    public Complex add(Complex c)
    {
        Complex complex= new Complex();
        complex.x+=this.x+c.x;
        complex.y+=this.y+c.y;
        
        return complex;
    }
    public String toString()
    {
        String string= "";
        string+=""+this.x+"+"+this.y+"i";
        return string;
    }
    public Complex multiply(Complex complex)
    {
        Complex c=new Complex();
        c.x=this.x*complex.x-this.y*complex.y;
        c.y=this.x*complex.y+this.y*complex.x;
        
        return c;
    }
    
}
