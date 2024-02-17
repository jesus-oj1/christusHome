package com.chritusHome.testCase;

import org.testng.annotations.Test;

public class CPO2_Crear_Cuenta_de_Usuario  extends baseExecute{
    @Test
    void test() throws InterruptedException {
        homepage.clickIniciarSesion();
        crearUsuario.crearusuario();
    }
    @Override
    public String setModulo() {
        return null;
    }
    @Override
    public String setperfil() {
        return null;
    }
    @Override
    public String setCasoPrueba() {
        return null;
    }
    @Override
    public String setNombreTester() {
        return null;
    }
    @Override
    public String setPaquete() {
        return null;
    }
}
