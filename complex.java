// complex number and functions
public class complex{
	private double real;		// the real part of complex number
	private double imaginary;	// the imaginary part of complex number

	// Functions used by asin() and acos()
	private double calcA(){
		double i = Math.sqrt((1+this.real)*(1+this.real)+this.imaginary*this.imaginary);
		double j = Math.sqrt((1-this.real)*(1-this.real)+this.imaginary*this.imaginary);
		return((i-j)/2);
	}
	private double calcB(){
		double i = Math.sqrt((1+this.real)*(1+this.real)+this.imaginary*this.imaginary);
		double j = Math.sqrt((1-this.real)*(1-this.real)+this.imaginary*this.imaginary);
		return((i+j)/2);
	}

	// Default constructor
	public complex(){
		real = 0;
		imaginary = 0;
	}

	// Create a new complex object with the given real & imaginary parts
	public complex (double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Set real part of a complex number
	public void setReal(double o){
		real=o;
	}

	// Set imaginary part of a complex number
	public void setImaginary(double o){
		imaginary=o;
	}

	// Return the real part of a complex number
	public double getReal(){
		return(real);
	}

	// Return imaginary part of a complex number
	public double getImaginary(){
		return(imaginary);
	}

	// Print string representation of a complex number
	public void print(String x){
		if (imaginary < 0) 
			System.out.println(x + real + imaginary +"i");
		else 
			System.out.println(x + real + "+" + imaginary +"i");
	}

	// Check equality of two complex numbers
	public boolean equal(complex num){
		if (num.real==this.real && num.imaginary==this.imaginary) 
			return(true);
		else 
			return(false);
	}

	// Retun a new complex number equal to "this(a+bi) + num(c+di)"
	public complex add(complex num){
		complex c = new complex();
		c.real = num.real + this.real;
		c.imaginary = num.imaginary + this.imaginary;
		return(c);
	}

	// Retun a new complex number equal to "this(a+bi) - num(c+di)"
	public complex subtract(complex num){
		complex c = new complex();
		c.real = this.real - num.real;
		c.imaginary = this.imaginary - num.imaginary;
		return(c);
	}

	// Retun a new complex number equal to "this(a+bi) * num(c+di)"
	public complex multiply(complex num){
		complex c = new complex();
		c.real = this.real*num.real-this.imaginary*num.imaginary;
		c.imaginary = num.real*this.imaginary + this.real*num.imaginary;
		return(c);
	}

	// Retun a new complex number equal to "this(a+bi) * num(e)"
	public complex multiply(double e){
		complex c = new complex();
		c.real = this.real*e;
		c.imaginary = e*this.imaginary;
		return(c);
	}

	// Retun a new complex number equal to "this(a+bi)/num(c+di)"
	public complex divide(complex num){
		complex c = new complex();
		double d = num.real*num.real+num.imaginary*num.imaginary;
		c.real = (this.real*num.real+this.imaginary*num.imaginary)/d;
		c.imaginary = (num.real*this.imaginary - this.real*num.imaginary)/d;
		return(c);
	}

	// Retun a new complex number equal to "this(a+bi)^num(e)"
	public complex power(double e){
		double t = Math.atan(this.imaginary/this.real);
		double s = Math.pow(this.abs(),e);
		complex c = new complex();
		c.real = s*Math.cos(t*e);
		c.imaginary = s*Math.sin(t*e);
		return(c);
	}

	// Retun a new complex number equal to "this(a+bi)^num(c+di)"
	public complex power(complex e){
		complex c = log();
		complex d = c.multiply(e);
		return(d.exp());
	}

	// Compute nth root of this(a+bi)"
	public complex root(double e){
		return(this.power(1/e));
	}

	// Retun a new complex number which is aditive inverse(-a-bi) of this(a+bi)"
	public complex negate(){
		complex c = new complex();
		c.real = -this.real;
		c.imaginary = -this.imaginary;
		return(c);
	}

	// Retun a new complex number which is conjugate(a-bi) of this(a+bi)
	public complex conjugate(){
		complex c = new complex();
		c.real = this.real;
		c.imaginary = -this.imaginary;
		return(c);
	}

	// Retun a new complex number equal to square root of this(a+bi)
	public complex sqrt(){
		return(this.power(0.5));
	}

	// Retun an absolute value of this(a+bi)
	public double abs(){
		return(Math.sqrt(this.real*this.real+this.imaginary*this.imaginary));
	}

	// Retun a new complex number equal to natural logaritham of this(log(a+bi))
	public complex log(){
		complex c =  new complex();
		c.real = Math.log(abs());
		c.imaginary = phase();
		return(c);
	}

	// Retun a new complex number equal to exponential function of this(e^(a+bi))
	public complex exp(){
		complex c =  new complex();
		c.real = Math.exp(this.real)*Math.cos(this.imaginary);
		c.imaginary = Math.exp(this.real)*Math.sin(this.imaginary);
		return(c);
	}

	// Retun an angle formed by rectangular coordinates of this(a+bi)
	public double phase(){
		return(Math.atan2(this.imaginary,this.real));
	}

	// Retun a new complex number equal to reiprocal(1/a+bi) of this(a+bi)
	public complex reciprocal(){
		complex c =  new complex();
		double s = this.real*this.real+this.imaginary*this.imaginary;
		c.real = this.real/s;
		c.imaginary = -this.imaginary/s;
		return(c);
	}

	// Retun a new complex number equal to sin of this(a+bi)	
	public complex sin(){
		complex c =  new complex();
		c.real = Math.sin(this.real)*Math.cosh(this.imaginary);
		c.imaginary = Math.sinh(this.imaginary)*Math.cos(this.real);
		return(c);
	}

	// Retun a new complex number equal to cos of this(a+bi)	
	public complex cos(){
		complex c =  new complex();
		c.real = Math.cos(this.real)*Math.cosh(this.imaginary);
		c.imaginary = -Math.sinh(this.imaginary)*Math.sin(this.real);
		return(c);
	}

	// Retun a new complex number equal to tan of this(a+bi)
	public complex tan(){
		return(sin().divide(cos()));
	}

	// Retun a new complex number equal to hyperbolic sin of this(a+bi)
	public complex sinh(){
		complex c = new complex();
		c.real = Math.cos(this.imaginary)*Math.sinh(this.real);
		c.imaginary = Math.cosh(this.real)*Math.sin(this.imaginary);
		return(c);
	}

	// Retun a new complex number equal to hyperbolic cos of this(a+bi)
	public complex cosh(){
		complex c = new complex();
		c.real = Math.cos(this.imaginary)*Math.cosh(this.real);
		c.imaginary = Math.sinh(this.real)*Math.sin(this.imaginary);
		return(c);
	}

	// Retun a new complex number equal to hyperbolic tan of this(a+bi)
	public complex tanh(){
		complex c = new complex();
		c.real = Math.sinh(2*this.real)/(Math.cosh(2*this.real)+Math.cos(2*this.imaginary));
		c.imaginary = Math.sin(2*this.imaginary)/(Math.cosh(2*this.real)+Math.cos(2*this.imaginary));
		return(c);
	}

	// Retun a new complex number equal to arcsin of this(a+bi)
	public complex asin(){
		complex c = new complex();
		c.real = Math.asin(calcA());
		double q = calcB();
		c.imaginary = Math.log(q+Math.sqrt(q*q-1));
		return(c);
	}

	// Retun a new complex number equal to arccos of this(a+bi)
	public complex acos(){
		complex c = new complex();
		c.real = Math.acos(calcA());
		double q = calcB();
		c.imaginary = -Math.log(q+Math.sqrt(q*q-1));
		return(c);
	}

	// Retun a new complex number equal to arctan of this(a+bi)
	public complex atan(){
		complex c = new complex(0,1);
		complex d = negate();
		complex e = add(c).divide(d.add(c));
		return(e.log().multiply(new complex(0,0.5)));
	}

	public complex multiplying(int i){
			complex d = new complex();
			
			if(i!=0){
				complex b = new complex(Math.pow(-1,i+1)*i,0);
				complex c = new complex(1*i,1*i);
				d = b.divide(c);				
			}
			return(d);
	}
}