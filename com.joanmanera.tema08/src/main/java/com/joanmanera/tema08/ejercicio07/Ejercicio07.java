package com.joanmanera.tema08.ejercicio07;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.Date;

public class Ejercicio07 {
    private static Scanner lector = new Scanner(System.in);
    private static Paciente[] datos = new Paciente[40];
    private static int contadorDatos = 10;
    private static int aux = 0;
    private static int aux2 = 0;

    public Ejercicio07() {
        GregorianCalendar data = new GregorianCalendar();
        datos[0] = new Paciente(1111111, "Carlos Gutierrez", Paciente.Sexo.MASCULINO, 19, data, "Dolor de cabeza",
                Paciente.EstadoPaciente.REGISTRADO);
        datos[1] = new Paciente(2222222, "Óliver Mas", Paciente.Sexo.MASCULINO, 19, data, "Dolor de cabeza",
                Paciente.EstadoPaciente.REGISTRADO);
        datos[2] = new Paciente(3333333, "Juan Delgado", Paciente.Sexo.MASCULINO, 19, data, "Dolor de cabeza",
                Paciente.EstadoPaciente.REGISTRADO);
        datos[3] = new Paciente(4444444, "Aaron Moya", Paciente.Sexo.MASCULINO, 19, data, "Dolor de cabeza",
                Paciente.EstadoPaciente.REGISTRADO);
        datos[4] = new Paciente(5555555, "Nicolás Garrido", Paciente.Sexo.MASCULINO, 19, data, "Dolor de cabeza",
                Paciente.EstadoPaciente.REGISTRADO);
        datos[5] = new Paciente(6666666, "Érik Ramirez", Paciente.Sexo.MASCULINO, 19, data, "Dolor de cabeza",
                Paciente.EstadoPaciente.REGISTRADO);
        datos[6] = new Paciente(7777777, "Ignacio Moya", Paciente.Sexo.MASCULINO, 19, data, "Dolor de cabeza",
                Paciente.EstadoPaciente.REGISTRADO);
        datos[7] = new Paciente(8888888, "Óliver Pons", Paciente.Sexo.MASCULINO, 19, data, "Dolor de cabeza",
                Paciente.EstadoPaciente.REGISTRADO);
        datos[8] = new Paciente(9999999, "Omar Font", Paciente.Sexo.MASCULINO, 19, data, "Dolor de cabeza",
                Paciente.EstadoPaciente.REGISTRADO);
        datos[9] = new Paciente(1000000, "Pablo Nuñez", Paciente.Sexo.MASCULINO, 19, data, "Dolor de cabeza",
                Paciente.EstadoPaciente.REGISTRADO);

        int menuPrincipal = 1;
        while (menuPrincipal != 0) {
            menuPrincipal = menuPrincipal();
            switch (menuPrincipal) {
            case 0:
                System.out.println("\nSaliendo del programa, pulsa intro para continuar...");
                lector.nextLine();
                break;
            case 1:
                nuevoPaciente();
                break;
            case 2:
                atenderPaciente();
                break;
            case 3:
                consultas();
                break;
            case 4:
                altaMedica();
                break;

            default:
                System.out.println("ERROR en la lectura de la opcion del menu principal");
                break;
            }
        }

    }

    private static int menuPrincipal() {
        int numero;
        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();
        do {
            System.out.println("********************");
            System.out.println("**    URGENCIAS   **");
            System.out.println("********************");
            System.out.println("1. Nuevo paciente ...");
            System.out.println("2. Atender paciente ...");
            System.out.println("3. Consultas ...");
            System.out.println("4. Alta medica ...");
            System.out.println("-----------------------");
            System.out.println("0. Salir");

            numero = lector.nextInt();
            lector.nextLine();
        } while (numero < 0 || numero > 4);
        return numero;
    }

    private static void nuevoPaciente() {
        int sip;
        String nombre;
        char sexo;
        int edad;
        GregorianCalendar fechaEntrada = new GregorianCalendar();
        String sintomatologia;

        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();

        System.out.println(".- Nuevo paciente -.");
        System.out.println();

        System.out.print("Introduce el SIP del paciente: ");
        sip = lector.nextInt();
        lector.nextLine();

        aux = comprobarEstado(sip);
        if (aux == 1) {

            System.out.println("Este paciente ya esta registrado y esta esperando a ser atendido");

        } else if (aux == 2) {

            System.out.println("Este paciente esta siendo atendido actualmente");

        } else if (aux == 3 || aux == -1) {

            System.out.print("Introduce el NOMBRE del paciente: ");
            nombre = lector.nextLine();

            do {
                System.out.print("Introduce el SEXO del paciente (M/F): ");
                sexo = lector.nextLine().charAt(0);
            } while (sexo != 'M' && sexo != 'm' && sexo != 'F' && sexo != 'f');

            System.out.print("Introduce la EDAD del paciente: ");
            edad = lector.nextInt();
            lector.nextLine();

            System.out.print("Introduce la SINTOMATOLOGIA del paciente: ");
            sintomatologia = lector.nextLine();

            if (sexo == 'M' || sexo == 'm') {
                datos[contadorDatos] = new Paciente(sip, nombre, Paciente.Sexo.MASCULINO, edad, fechaEntrada,
                        sintomatologia, Paciente.EstadoPaciente.REGISTRADO);
            } else {
                datos[contadorDatos] = new Paciente(sip, nombre, Paciente.Sexo.FEMENINO, edad, fechaEntrada,
                        sintomatologia, Paciente.EstadoPaciente.REGISTRADO);
            }

            contadorDatos++;
            System.out.println("Paciente añadido con exito!");
        } else {
            System.out.println("ERROR al añadir el paciente");
        }
        System.out.println();
        System.out.println("Pulse intro para continuar...");
        lector.nextLine();

    }

    private static void atenderPaciente() {
        int sip;
        double[] preRev = new double[4];

        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();

        System.out.println(".- Atender paciente -.");
        System.out.println();

        System.out.print("Introduce el SIP del paciente: ");
        sip = lector.nextInt();
        lector.nextLine();

        aux2 = -1;
        for (int i = 0; i < contadorDatos; i++) {
            if (datos[i].getSip() == sip && datos[i].getEstado() == Paciente.EstadoPaciente.REGISTRADO) {
                aux2 = i;
            }
        }
        aux = comprobarEstado(sip);

        if (aux == 2) {

            System.out
                    .println("ERROR al atender al paciente, el paciente ya ha sido atendido y esta esperando el alta");

        } else if (aux == 1) {

            System.out.print("Introduce la temperatura del paciente: ");
            preRev[0] = lector.nextDouble();

            System.out.print("Introduce las pulsaciones por minuto del paciente: ");
            preRev[1] = lector.nextDouble();

            System.out.print("Introduce la tension sistolica del paciente: ");
            preRev[2] = lector.nextDouble();

            System.out.print("Introduce la tension diastolica del paciente: ");
            preRev[3] = lector.nextDouble();

            datos[aux2].setPreRev(preRev);
            datos[aux2].setEstado(Paciente.EstadoPaciente.ATENDIDO);

            System.out.println("\nEl paciente ha sido atendido con exito!");
            lector.nextLine();

        } else if (aux == 3) {
            System.out.println("ERROR al atender al paciente, el paciente ya ha sido dado de alta");
        } else if (aux == -1) {

            System.out.println("ERROR al atender al paciente, el numero SIP no esta registrado");
        }

        System.out.println();
        System.out.println("\nPulse intro para continuar...");
        lector.nextLine();

    }

    private static void consultas() {
        int numero = 1;
        int sip;

        while (numero != 0) {
            numero = menuConsultas();
            switch (numero) {
            case 0:
                break;
            case 1:
                System.out.println(".- Colsulta por SIP -.");
                System.out.print("Introduce el SIP: ");
                sip = lector.nextInt();
                lector.nextLine();

                aux = 0;
                mostrarCampos();
                for (int i = 0; i < contadorDatos; i++) {
                    if (datos[i].getSip() == sip) {
                        datos[i].mostrarDatos();
                        aux++;
                    }
                }
                if (aux == 0) {

                    System.out.println("No hay ningun paciente con el SIP: " + sip);

                }

                break;
            case 2:
                long fechaInt1;
                long fechaInt2;
                String fechaInicioString;
                String fechaFinString;

                Date dataInicio = new Date();
                Date dataFin = new Date();
                SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
                GregorianCalendar fechaInicio = new GregorianCalendar();
                GregorianCalendar fechaFin = new GregorianCalendar();

                System.out.println(".- Colsulta por FECHAS -.");
                System.out.print("Introduce la fecha de inicio con formato 'aaaa/mm/dd': ");
                fechaInicioString = lector.nextLine();
                try {
                    dataInicio = formato.parse(fechaInicioString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                fechaInicio.setTime(dataInicio);
                fechaInt1 = fechaInicio.getTimeInMillis();

                System.out.print("Introduce la fecha de fin con formato 'aaaa/mm/dd'(0 para omitir): ");
                fechaFinString = lector.nextLine();
                if (Integer.parseInt(fechaFinString.replaceAll("/", "")) != 0) {
                    try {
                        dataFin = formato.parse(fechaFinString);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    fechaFin.setTime(dataFin);
                    fechaInt2 = fechaFin.getTimeInMillis();

                } else {
                    GregorianCalendar fechaFinMil = new GregorianCalendar();
                    fechaInt2 = fechaFinMil.getTimeInMillis();
                }

                aux = 0;
                mostrarCampos();
                for (int i = 0; i < contadorDatos; i++) {
                    if (fechaInt1 <= datos[i].getFechaEntradaInMillis() && fechaInt2 >= datos[i].getFechaEntradaInMillis()) {
                        datos[i].mostrarDatos();
                        aux++;
                    }
                }
                if (aux == 0) {
                    System.out.println("No hay pacientes registrados con esta fecha");
                }

                break;
            case 3:
                consultaEstadisticas();

                break;
            case 4:
                System.out.println(".- Mostrar histórico mensual -.");

                mostrarCampos();
                for (int i = 0; i < contadorDatos; i++) {
                    datos[i].mostrarDatos();
                }
                if (contadorDatos == 0) {
                    System.out.println("Todavia no se han registrado pacientes en el sistema");
                }

                break;

            default:
                System.out.println("ERROR en la lectura de la opcion en el menu de consultas");
                break;
            }
            System.out.println("\nPulse intro para continuar...");
            lector.nextLine();
        }

    }

    private static int menuConsultas() {
        int numero;
        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();
        do {
            System.out.println("********************");
            System.out.println("**    COLSULTAS   **");
            System.out.println("********************");
            System.out.println("1. Por SIP ...");
            System.out.println("2. Por fechas ...");
            System.out.println("3. Estadísticas ...");
            System.out.println("4. Mostrar histórico mensual ...");
            System.out.println("-----------------------");
            System.out.println("0. Volver al menu principal");

            numero = lector.nextInt();
            lector.nextLine();
        } while (numero < 0 || numero > 4);
        return numero;
    }

    private static void consultaEstadisticas() {
        double mediaTemp = 0;
        double mediaPpm = 0;
        double mediaTension = 0;
        double mediaEdad = 0;
        double porcentajeHombres = 0;
        double porcentajeMujeres = 0;
        aux = 0;

        System.out.println(".- Colsulta por ESTADISTICAS -.");

        for (int i = 0; i < contadorDatos; i++) {
            if (datos[i].getEstado() != Paciente.EstadoPaciente.REGISTRADO) {
                aux++;
                mediaTemp += datos[i].getTemperatura();
                mediaPpm += datos[i].getPulsaciones();
                mediaTension += datos[i].getTensionD() + datos[i].getTensionS();
            }

            mediaEdad += datos[i].getEdad();
            if (datos[i].getSexo() == Paciente.Sexo.MASCULINO) {
                porcentajeHombres++;
            } else {
                porcentajeMujeres++;
            }
        }
        mediaTemp /= aux;
        mediaPpm /= aux;
        mediaTension = (mediaTension / 2) / aux;
        mediaEdad = mediaEdad / contadorDatos;
        porcentajeHombres = (porcentajeHombres / contadorDatos) * 100;
        porcentajeMujeres = (porcentajeMujeres / contadorDatos) * 100;

        System.out.printf("\nMedia de la temperatura: %.2f\n", mediaTemp);
        System.out.printf("Media des pulsaciones por minuto: %.2f\n", mediaPpm);
        System.out.printf("Media de la tension: %.2f\n", mediaTension);
        System.out.printf("Media de la edad: %.2f\n", mediaEdad);
        System.out.printf("Porcentaje de hombres: %.2f\n", porcentajeHombres);
        System.out.printf("Porcentaje de mejeres: %.2f\n", porcentajeMujeres);

    }

    private static void altaMedica() {
        int sip;
        String motivoAlta;
        GregorianCalendar fechaAlta = new GregorianCalendar();

        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();

        System.out.println(".- Alta médica -.");
        System.out.println();

        System.out.print("Introduce el SIP: ");
        sip = lector.nextInt();
        lector.nextLine();

        aux2 = -1;
        for (int i = 0; i < contadorDatos; i++) {
            if (datos[i].getSip() == sip && datos[i].getEstado() == Paciente.EstadoPaciente.ATENDIDO) {
                aux2 = i;
            }
        }
        aux = comprobarEstado(sip);
        if (aux == 1) {
            System.out.println("ERROR al dar de alta, el paciente esta registrado pero todavia no ha sido atendido");
        } else if (aux == 2) {
            System.out.print("Introduce el motivo de alta: ");
            motivoAlta = lector.nextLine();

            datos[aux2].setFechaAlta(fechaAlta);
            datos[aux2].setMotivoAlta(motivoAlta);
            datos[aux2].setEstado(Paciente.EstadoPaciente.ALTA);

            System.out.println("El paciente ha sido dado de alta con exito!");

        } else if (aux == 3) {
            System.out.println("ERROR al dar de alta, el paciente ya ha sido dado de alta");

        } else if (aux == -1) {
            System.out.println("El numero SIP intoducido no corresponde a ningun paciente");
        }

        System.out.println("\nPulse intro para continuar...");
        lector.nextLine();

    }

    private static int comprobarEstado(int sip) {
        for (int i = (contadorDatos - 1); i >= 0; i--) {
            if (datos[i].getSip() == sip) {
                if (datos[i].getEstado() == Paciente.EstadoPaciente.REGISTRADO) {
                    return 1;
                } else if (datos[i].getEstado() == Paciente.EstadoPaciente.ATENDIDO) {
                    return 2;
                } else if (datos[i].getEstado() == Paciente.EstadoPaciente.ALTA) {
                    return 3;
                }
            }
        }
        return -1;
    }

    private static void mostrarCampos() {

        System.out.printf("%9s%2s%17s%2s%5s%4s%12s%2s%9s%3s%4s%2s%17s%2s%6s%2s%5s%2s%5s%2s%5s%2s%12s%2s%9s%3s%17s\n",
                "SIP", "|", "Nombre", "|", "Sexo", "|", "Fecha ent.", "|", "Hora ent.", "|", "Edad", "|",
                "Sintomatología", "|", "Temp", "|", "PPM", "|", "T.Sis", "|", "T.Dia", "|", "Fecha sal.", "|",
                "Hora sal.", "|", "Motivo sal.");
    }
}