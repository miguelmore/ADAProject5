
package mx.ipn.cic.ada.fourier;

/**
 *
 * @author Miguel Moreno
 */
public class Complex {
    
    private double re;   // parte real
    private double im;   // parte imaginaria

    public Complex(double r, double i) {
        re = r;
        im = i;
    }      

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }
            
    public Complex plus(Complex b) {
        double r = this.re + b.re;
        double i = this.im + b.im;
        return new Complex(r, i);
    }    
    
    public Complex minus(Complex b) {       
        double r = this.re - b.re;
        double i = this.im - b.im;
        return new Complex(r, i);
    }
    
    public Complex multiply(Complex b) {
        double r = this.re * b.re - this.im * b.im;
        double i = this.re * b.im + this.im * b.re;
        return new Complex(r, i);
    }

    public Complex mulScale(double alpha) {
        return new Complex(alpha * this.re, alpha * this.im);
    }
    
    public Complex conjugate() {
        return new Complex(this.re, -this.im);
    }
    
    public Complex reciprocal() {
        double scale = this.re*this.re + this.im*this.im;
        return new Complex(this.re / scale, -this.im / scale);
    }

    @Override
    public String toString() {
        String com = null;
        if (im <  0)
            com = re + " - " + (-im) + "i";
        else
            com = re + " + " + im + "i";
        return com;
    }
}