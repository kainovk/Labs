package ru.unn;

public class Complex {
    private double re;
    private double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public Complex add(Complex complex) {
        this.re += complex.re;
        this.im += complex.im;

        return this;
    }

    public Complex add(double re, double im) {
        this.re += re;
        this.im += im;

        return this;
    }

    public Complex sub(Complex complex) {
        this.re -= complex.re;
        this.im -= complex.im;

        return this;
    }

    public Complex sub(double re, double im) {
        this.re -= re;
        this.im -= im;

        return this;
    }

    public Complex mul(Complex complex) {
        double real = this.re;
        double imag = this.im;
        this.re = real * complex.re - imag * complex.im;
        this.im = real * complex.im + imag * complex.re;

        return this;
    }

    public Complex mul(double re, double im) {
        double real = this.re;
        double imag = this.im;
        this.re = real * re - imag * im;
        this.im = real * im + imag * re;

        return this;
    }

    public Complex div(Complex complex) {
        double real = this.re;
        double imag = this.im;
        this.re = (real * complex.re - imag * complex.im) /
                (complex.re * complex.re + complex.im * complex.im);
        this.im = (real * complex.im + imag * complex.re) /
                (complex.re * complex.re + complex.im * complex.im);

        return this;
    }

    public Complex div(double re, double im) {
        double real = this.re;
        double imag = this.im;
        this.re = (real * re - imag * im) /
                (re * re + im * im);
        this.im = (real * im + imag * re) /
                (re * re + im * im);

        return this;
    }

    public double getRe() {
        return re;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public double getIm() {
        return im;
    }

    public void setIm(double im) {
        this.im = im;
    }
}
