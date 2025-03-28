package com.campusdigital;

public class CuentaCorrientePersonal extends CuentaCorriente {
    private double comisionMantenimiento;

    public CuentaCorrientePersonal(Persona titular, String iban, double saldo) {
        super(titular, iban, saldo);
    }

    /**
     * @param titular
     * @param iban
     * @param saldo
     * @param listaEntidades
     * @param comisionMantenimiento
     */
    public CuentaCorrientePersonal(Persona titular, String iban, double saldo, String listaEntidades,
                                   double comisionMantenimiento) {
        super(titular, iban, saldo, listaEntidades);
        this.comisionMantenimiento = comisionMantenimiento;
    }

    @Override
    public String devolverInfoString() {
        return "Cuenta Corriente Personal: " +
               "Titular: " + getTitular().getNombre() + " " + getTitular().getApellidos() + ", " +
               "IBAN: " + getIban() + ", " +
               "Saldo: " + getSaldo() + "€, " +
               "Entidades permitidas: " + getListaEntidades() + ", " +
               "Comisión de mantenimiento: " + comisionMantenimiento + "€";
    }
}
