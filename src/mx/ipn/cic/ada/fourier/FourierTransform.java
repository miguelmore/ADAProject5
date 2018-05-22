
package mx.ipn.cic.ada.fourier;

/**
 *
 * @author Miguel Moreno
 */
public class FourierTransform {
       
    public Complex[] fft(Complex[] x){        
        int n = x.length;
        
        if(n == 1){
            return new Complex[] { x[0] };
        }

        if(n%2 != 0) {
            throw new IllegalArgumentException("n no es potencia de 2");
        }

        // Separamos en pares e impares
        Complex[] even = new Complex[n/2];
        for (int k = 0; k < n/2; k++) {
            even[k] = x[2*k];
        }        
        
        Complex[] odd  = new Complex[n/2];  
        for (int k = 0; k < n/2; k++) {
            odd[k] = x[2*k + 1];
        }
        
        Complex[] q = fft(even);
        Complex[] r = fft(odd);

        // Combinamos los resultados
        Complex[] y = new Complex[n];
        for (int k=0; k<n/2; k++) {
            double kth = -2 * k * Math.PI / n;
            Complex wk = new Complex(Math.cos(kth), Math.sin(kth));
            
            y[k]       = q[k].plus(wk.multiply(r[k]));
            y[k + n/2] = q[k].minus(wk.multiply(r[k]));
        }
        
        return y;
    }


    public Complex[] ifft(Complex[] x){
        int n = x.length;
        
        if(n == 1){
            return new Complex[] { x[0] };
        }

        if(n%2 != 0) {
            throw new IllegalArgumentException("n no es potencia de 2");
        }

        // Separamos en pares e impares
        Complex[] even = new Complex[n/2];
        for (int k = 0; k < n/2; k++) {
            even[k] = x[2*k];
        }        
        
        Complex[] odd  = new Complex[n/2];  
        for (int k = 0; k < n/2; k++) {
            odd[k] = x[2*k + 1];
        }
        
        Complex[] q = fft(even);
        Complex[] r = fft(odd);

        // Combinamos los resultados
        Complex[] y = new Complex[n];
        for (int k = 0; k < n/2; k++) {
            double kth = -2 * k * Math.PI / n;
            Complex wk = new Complex(Math.cos(kth), Math.sin(kth)*-1);
            
            y[k]       = (q[k].plus(wk.multiply(r[k]))).mulScale(1.0 / n);
            y[k + n/2] = (q[k].minus(wk.multiply(r[k]))).mulScale(1.0 / n);
        }
        
        return y;
    }

    public void test() { 
        int n = 4;
        Complex[] x = new Complex[n];

        System.out.println("Inicial");
        for (int i = 0; i < n; i++) {
            x[i] = new Complex(i, 0);
            System.out.println(i);
        }
       
        Complex[] y = fft(x);
        System.out.println("\nFFT");
        for (Complex complex : y) {
            System.out.println(complex);
        }
        
        Complex[] z = ifft(y);
        System.out.println("\nIFFT");
        for (Complex complex : z) {
            System.out.println(complex.getRe());
        }

    }
}
