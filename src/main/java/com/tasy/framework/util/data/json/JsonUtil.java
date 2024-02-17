package com.tasy.framework.util.data.json;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class JsonUtil {

    public void guardarNombrepaciente(List<String> datospaciente) {

        JSONObject paciente = new JSONObject();
        paciente.put("Nombre", datospaciente.get(0));
        paciente.put("Codigo", datospaciente.get(1));

        JSONObject datosPaciente = new JSONObject();
        datosPaciente.put("Paciente", paciente);

        JSONArray pacientes = new JSONArray();
        pacientes.add(datosPaciente);


        try (FileWriter file = new FileWriter("paciente.json")) {
            file.write(pacientes.toJSONString());
            file.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void guardarAtencion(List<String> datospacientes) {

        JSONObject paciente = new JSONObject();
        paciente.put("Nombre", datospacientes.get(0));
        paciente.put("Atencion", datospacientes.get(1));

        JSONObject datosPaciente = new JSONObject();
        datosPaciente.put("Paciente", paciente);

        JSONArray pacientes = new JSONArray();
        pacientes.add(datosPaciente);

        try (FileWriter file = new FileWriter("paciente.json")) {
            file.write(pacientes.toJSONString());
            file.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String jsonreader(String datospaciente) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("paciente.json");
        Object obj = jsonParser.parse(reader);
        String datos= null;
        JSONArray pacienteList = (JSONArray) obj;
        for (Object paciente : pacienteList) {
           datos = mostrarInformacionPaciente((JSONObject) paciente,datospaciente);
        }
        return datos;
    }

    public String mostrarInformacionPaciente(JSONObject jsonObject,String datospaciente) {
        JSONObject paciente = (JSONObject) jsonObject.get("Paciente");
        String nombre = (String) paciente.get(datospaciente);
        System.out.println(nombre);
        return nombre;
    }

    @Test
    void prueba() throws IOException, ParseException {
       /* List<String> lista = new ArrayList<>();
        lista.add("Luis Carlos Reyes Savage");
        lista.add("123293");
        guardarNombrepaciente(lista);*/
        jsonreader("Codigo");
    }


}


