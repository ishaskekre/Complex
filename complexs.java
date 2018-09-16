public class complex implements Comparable <Object>
{
    private double a; // real
    private double b; // imaginary
    //private means ACCESSOR METHODS needed ("getters")
    private static double epsilon = Math.pow(10, -5);
    
    public static void main(String[] args) //the main method lol
    {
        1complex sumsum = new complex();
        complex product = new complex(1,0);
        
        for (int i=0; i<=15; i++) {
            complex cur = new complex(i,1);
            complex cur2 = new complex(1, i);   
            complex current = cur.divide(cur2);
            //System.out.print(i);
            //System.out.println(current);
            sumsum = sumsum.add(current);
            if (i <= 12) {
                product = product.multiply(current);
            }
            //System.out.println(sumsum);
        }

        System.out.println(sumsum);
        System.out.println(sumsum.theta());
        System.out.println(product);
        System.out.println(product.theta());*/

        complex cur = new complex();

        for (int i=1; i<=20; i++) {
            complex num = new complex(Math.pow(-1, i+1) * i, 0);
            complex den = cur.add(new complex(1,1));
            cur = num.divide(den);

            if (i== 17) {
                System.out.println(cur.theta());
            }
            if (i== 20) {
                System.out.println(cur);
            }
        }   
        /*complex x = new complex(1,1);
        x = x.power(5);
        complex roots[] = x.root(6);
        for (int i=0; i<roots.length; i++) {
            System.out.println(roots[i]);
        }
        */
        //arg = angle
    }

    public static complex somefoo(int k) {
        complex temp = new complex();
        complex bomplex = new complex();
        complex habdaeiei = new complex();
        for(int a = 0; a < k; a++)
        {   
            temp.setA(1.0);
            temp.setB(Math.pow(-1, a)*Math.sqrt(a));
            bomplex = divide(1.0, temp);
            System.out.println(bomplex.toString());
            habdaeiei = habdaeiei.add(bomplex);
        }
        return habdaeiei;
    }

    //CONSTRUCTORS
    public complex() //No ARG Contructor, set a and b to 0
    {
        a = 0;
        b = 0;
    }
    public complex(double x, double y) // Regular Constructor
    {
        a = x;
        b = y;
    }
    public complex(complex c) //copy constructor
    {
        a = c.getA();
        b = c.getB();
    }
    
    //MODIFIERS
    public void setA(double a) //set a value
    {
        this.a = a;
    }
    public void setB(double b) //set b value
    {
        this.b = b;
    }
    public void setEpsilon(double e) //set epsilon value
    {
        epsilon = e;
    }
    
    //ACCESSORS
    public double getA() //return a value
    {
        return a;
    }
    public double getB() //return b value
    {
        return b;
    }
    //METHODS
    public double r() //reurn the magnitude of the complex number
    {
        return (Math.sqrt(Math.pow(this.a, 2) + (Math.pow(this.b, 2))));
    }
    public static double r(complex c) //reurn the magnitude of argument complex number
    {
        return (c.r());
    }
    public double theta() //return of the degree value of the complex number
    {
        if (this.a == 0)
        {
            if (this.b < 0)
            {
                return Math.PI / -2;
            }
            if (this.b > 0)
            {
                return Math.PI / 2;
            }
            if (this.b == 0)
            {
                return 0;
            }
        }
        if (this.getA() != 0 && this.getB() == 0)
        {
            if (this.getA() < 0)
            {
                return Math.PI;
            }
            if (this.getA() > 0)
            {
                return 0;
            }
        }
        if (this.getA() < 0)
        {
            return Math.atan(this.getB() / this.getA()) + Math.PI;
        }
        return Math.atan(this.getB() / this.getA());
    }
    public static double theta(complex c) //return of the degree value of argument complex number
    {
        return c.theta();
    }
    public complex conjugate()
    {
        return (new complex(this.a, -1 * this.b));
    }
    public static complex conjugate(complex c) //create conjugate of argument complex number
    {
        return (c.conjugate());
    }
    public complex add(complex c) //add values of a and b of complex number c and this
    {
        double real = this.a + c.a;
        double imaginary = this.b + c.b;
        return (new complex(real, imaginary));
    }
    public complex add(double d) //add d value to a of complex number
    {
        complex com = new complex(d, 0);
        return (this.add(com));
    }
    public static complex add(complex c, double d) //add d value to a value of complex number c
    {
        return (c.add(d));
    }
    public static complex add(complex c, complex d) //add values of a and b of complex numbers c and d
    {
        return (c.add(d));
    }
    public complex subtract(complex c) //subtract values of a and b of complex number c from complex
    {
        double real = this.a - c.a;
        double imaginary = this.b - c.b;
        return (new complex(real, imaginary));
    }
    public complex subtract(double d) //subtract d from value a of complex number
    {
        complex com = new complex(d, 0);
        return (this.subtract(com));
    }
    public static complex subtract(complex c, double d) //subtract d from value a from complex d
    {
        return (c.subtract(d));
    }
    public static complex subtract(complex c, complex d) //subtract complex number d from c
    {
        return (c.subtract(d));
    }
    public complex multiply(complex c) //multiply complex number by complex number c
    {
        double real = this.a * c.a - this.b * c.b;
        double imaginary = this.a * c.b + this.b * c.a;
        return (new complex(real, imaginary));
    }
    public complex multiply(double d) //multiply complex number by constant d
    {
        return (new complex(this.a * d, this.b * d));
    }
    public static complex multiply(complex c, double d) //multiply complex number c by number d
    {
        return (c.multiply(d));
    }
    public static complex multiply(complex c, complex d) //multiply complex numbers c and d together
    {
        return (c.multiply(d));
    }
    public complex divide(complex c) //divide a complex number by argument complex number c
    {
        double conjugateMult = c.a * c.a + c.b * c.b;
        complex numerator = this.multiply(c.conjugate());
        if (conjugateMult == 0)
        {
            throw new IllegalArgumentException("0 Error");
        }
        else
        {
            return (new complex(numerator.a / conjugateMult, numerator.b / conjugateMult));
        }
    }
    public complex divide(double d) //divide complex number by a number d
    {
        if (d == 0)
        {
            throw new IllegalArgumentException("0 Error");
        }
        else
        {
            return (new complex(this.a / d, this.b / d));
        }
    }
    public static complex divide(complex c, complex d) //dividing the complex c by complex d
    {
        return (c.divide(d));
    }
    public static complex divide(complex c, double d) //dividing the complex number c by number d
    {
        return (c.divide(d));
    }
    public static complex divide(double d, complex c) //dividing the number d by complex number c
    {
        complex com = new complex(d, 0);
        return (com.divide(c));
    }
    public complex power(double n) //raise a complex number number to nth power
    {
        if (n == 0 && this.r() == 0)
        {
            return (new complex(1, 0));
        }
        else if (this.r() == 0)
        {
            return (new complex(0, 0));
        }
        else
        {
            double real = Math.pow(this.r(), n) * Math.cos(n * this.theta());
            double imaginary = Math.pow(this.r(), n) * Math.sin(n * this.theta());
            return (new complex(real, imaginary));
        }
    }
    public static complex power(complex c, double n) //raise complex number c to nth power
    {
        return (c.power(n));
    }
    public static complex power(double n, complex c) //raise number n to the complex c power
    {
        if (c.r() == 0)
        {
            return (new complex(1, 0));
        }
        else if (n == 0 && c.r() == 0)
        {
            return (new complex(1, 0));
        }
        else
        {
            double real = Math.pow(n, c.a) * Math.cos(c.b * Math.log(n));
            double imaginary = Math.pow(n, c.a) * Math.sin(c.b * Math.log(n));
            return (new complex(real, imaginary));
        }
    }
    public static complex power(complex c, complex d) //raises a complex number by a complex power
    {
        complex l = power(c.r(), d);
        double t = Math.exp(-(d.b) * c.theta());
        complex m = new complex(t * Math.cos(d.a * c.theta()), t * Math.sin(d.a * c.theta()));
        return l.multiply(m);
    }
    public complex root(double n) //returns first nth root of complex number
    {
        if (n == 0)
        {
            throw new IllegalArgumentException("0 Error");
        }
        return (this.power(1 / n));
    }
    public static complex root(complex c, double n) //returns first nth root of complex number c
    {
        return (c.root(n));
    }
    public complex[] root(int n) //returns an array of length n of the n roots of a complex number; non static
    {
        if (n < 0) throw new IllegalArgumentException("YOU CANNOT TAKE THE ZEROTH ROOT OF SOMETHING");
        double modroot = rootfinder(this.r(), n);
        complex[] comproots = new complex[n];
        for (int i = 0; i < n; i++)
        {
            comproots[i] = new complex(modroot * Math.cos(((this.theta() + 2 * Math.PI * i) / n)), modroot * Math.sin(((this.theta() + 2 * Math.PI * i) / n)));
        }
        return comproots;
    }
    public static double rootfinder(double k, double m)
    {
        double y = 2;
        while (Math.abs(Math.pow(y, m) - k) / Math.abs(k) > epsilon)
        {
            y = y - (Math.pow(y, m) - k) / (m * Math.pow(y, m - 1));
        }
        return y;
    }
    public complex ln() //returning the ln of the complex number
    {
        if (this.r() == 0)
        {
            throw new IllegalArgumentException("0 Error");
        }
        else
        {
            return (new complex(Math.log(this.r()), this.theta()));
        }
    }
    public static complex ln(complex c) //returning the ln of argument complex number c
    {
        return (c.ln());
    }
    public complex log(double d) //log base d of complex number
    {
        return (ln(this).divide(Math.log(d)));
    }
    public static complex log(complex c, double d) //log base d of complex number c
    {
        return (c.log(d));
    }
    public static complex sin(complex c) //takes the sine of a complex number
    {
        return new complex(Math.sin(c.a) * Math.cosh(c.b), Math.cos(c.a) * Math.sinh(c.b));
    }
    public complex sin()
    {
        return (sin(this));
    }
    public static complex cos(complex c) //takes the cosine of a complex number
    {
        return new complex(Math.cos(c.a) * Math.cosh(c.b), -1 * Math.sin(c.a) * Math.sinh(c.b));
    }
    public complex cos()
    {
        return (cos(this));
    }
    public static complex sinh(complex c) //takes the hyperbolic sine of a complex number
    {
        return new complex(Math.sinh(c.a) * Math.cos(c.b), Math.cosh(c.a) * Math.sin(c.b));
    }
    public complex sinh()
    {
        return (sinh(this));
    }
    public static complex cosh(complex c) //takes the hyperbolic cosine of a complex number
    {
        return new complex(Math.cosh(c.a) * Math.cos(c.b), Math.sinh(c.a) * Math.sin(c.b));
    }
    public complex cosh()
    {
        return (cosh(this));
    }
    public boolean equals(complex c) //compares if complex numbers are same using a and b terms
    {
        if (Math.abs(this.a - c.a) / Math.abs(this.a) < epsilon && Math.abs(this.b - c.b) / Math.abs(this
                                                                                                     .b) < epsilon)
        {
            return true; //if a and b values are same, return true
        }
        else
        { // if no match, return false
            return false;
        }
    }
    public String toString() // returns complex numbers in a+bi format
    {
        String cForm = "";
        cForm = a + " + (" + b + "i)";
        return cForm;
    }
    public int compareTo(Object O) //compares complex numbers using magnitudes or values
    {
        int n = 0;
        if (this.getClass() == O.getClass())
        {
            complex c = (complex) O;
            if (Math.abs(this.r() - c.r()) / Math.abs(this.r()) < epsilon) //return 0 if same
            {
                n = 0;
            }
            else if (this.r() - c.r() > 0) //if the magnitude is larger, return 1
            {
                n = 1;
            }
            else if (this.r() - c.r() < 0) //if the magnitude is smaller, return -1
            {
                n = -1;
            }
        }
        else
        {
            n = 123456789; //if somehow not matching any value, return error number 123456789
        }
        return n;
    }
}
