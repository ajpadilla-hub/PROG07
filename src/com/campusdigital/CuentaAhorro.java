package com.campusdigital;

public class CuentaAhorro extends CuentaBancaria {
    private double tipoInteresAnual;

    /**
     * @param titular
     * @param iban
     * @param saldo
     * @param tipoInteresAnual
     */
    public CuentaAhorro(Persona titular, String iban, double saldo, double tipoInteresAnual) {
        super(titular, iban, saldo);
        this.tipoInteresAnual = tipoInteresAnual;
    }

    /**
     * @return the tipoInteresAnual
     */
    public double getTipoInteresAnual() {
        return tipoInteresAnual;
    }

    /**
     * @param tipoInteresAnual the tipoInteresAnual to set
     */
    public void setTipoInteresAnual(double tipoInteresAnual) {
        this.tipoInteresAnual = tipoInteresAnual;
    }

    @Override
    public String devolverInfoString() {
        return "Cuenta Ahorro: " +
               "Titular: " + getTitular().getNombre() + " " + getTitular().getApellidos() + ", " +
               "IBAN: " + getIban() + ", " +
               "Saldo: " + getSaldo() + "€, " +
               "Interés Anual: " + tipoInteresAnual + "%";
    }
}
