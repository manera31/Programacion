package com.joanmanera.tema08.ejercicio07;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Paciente {
    public enum Sexo {
        MASCULINO, FEMENINO
    }

    public enum EstadoPaciente {
        REGISTRADO, ATENDIDO, ALTA
    }

    private int sip;
    private String nombre;
    private Sexo sexo;
    private int edad;
    private GregorianCalendar fechaEntrada = new GregorianCalendar();
    private String sintomatologia;
    private EstadoPaciente estado;
    private double[] preRev;
    private GregorianCalendar fechaAlta = new GregorianCalendar();
    private String motivoAlta;

    public Paciente(int sip, String nombre, Sexo sexo, int edad, GregorianCalendar fechaEntrada, String sintomatologia,
            EstadoPaciente estado) {
        this.sip = sip;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.fechaEntrada = fechaEntrada;
        this.sintomatologia = sintomatologia;
        this.estado = estado;
        this.preRev = new double[4];// 0-temperatura, 1-pulsaciones por minuto, 2-tension sistolica, 3-tension
                                    // diastolica
    }

    public int getSip() {
        return sip;
    }

    public void setPreRev(double[] preRev) {
        this.preRev = preRev;
    }

    public double getTemperatura() {
        return preRev[0];
    }

    public double getPulsaciones() {
        return preRev[1];
    }

    public double getTensionS() {
        return preRev[2];
    }

    public double getTensionD() {
        return preRev[3];
    }

    public void setFechaAlta(GregorianCalendar fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public void setMotivoAlta(String motivoAlta) {
        this.motivoAlta = motivoAlta;
    }

    public int getEdad() {
        return edad;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public EstadoPaciente getEstado() {
        return estado;
    }

    public void setEstado(EstadoPaciente estado) {
        this.estado = estado;
    }

    public void mostrarDatos() {
        System.out.printf("%9d", sip);
        System.out.printf("%2s", "|");

        System.out.printf("%17s", nombre);
        System.out.printf("%2s", "|");

        if (sexo == Sexo.MASCULINO) {
            System.out.printf("%5s", "H");
            System.out.printf("%4s", "|");
        } else if (sexo == Sexo.FEMENINO) {
            System.out.printf("%5s", "M");
            System.out.printf("%4s", "|");
        }

        // Fecha
        System.out.printf("%12s", fechaEntrada.get(Calendar.YEAR) + "/" + fechaEntrada.get(Calendar.MONTH) + 1 + "/"
                + fechaEntrada.get(Calendar.DAY_OF_MONTH));
        System.out.printf("%2s", "|");

        // Hora
        System.out.printf("%9s", fechaEntrada.get(Calendar.HOUR) + ":" + fechaEntrada.get(Calendar.MINUTE));
        System.out.printf("%3s", "|");

        System.out.printf("%4d", edad);
        System.out.printf("%2s", "|");

        System.out.printf("%17s", sintomatologia);
        System.out.printf("%2s", "|");

        if (estado == EstadoPaciente.ATENDIDO || estado == EstadoPaciente.ALTA) {
            System.out.printf("%6.1f", preRev[0]);
            System.out.printf("%2s", "|");

            System.out.printf("%5.0f", preRev[1]);
            System.out.printf("%2s", "|");

            System.out.printf("%5.0f", preRev[2]);
            System.out.printf("%2s", "|");

            System.out.printf("%5.0f", preRev[3]);
            System.out.printf("%2s", "|");

            if (estado == EstadoPaciente.ALTA) {
                // Fecha
                System.out.printf("%12s", fechaAlta.get(Calendar.YEAR) + "/" + fechaAlta.get(Calendar.MONTH) + 1 + "/"
                        + fechaAlta.get(Calendar.DAY_OF_MONTH));
                System.out.printf("%2s", "|");

                // Hora
                System.out.printf("%9s", fechaAlta.get(Calendar.HOUR) + ":" + fechaAlta.get(Calendar.MINUTE));
                System.out.printf("%3s", "|");

                System.out.printf("%17s", motivoAlta);
                System.out.println();

            } else {
                System.out.println();
            }
        } else {
            System.out.println();
        }

    }

    public long getFechaEntradaInMillis() {
        return fechaEntrada.getTimeInMillis();
    }
}