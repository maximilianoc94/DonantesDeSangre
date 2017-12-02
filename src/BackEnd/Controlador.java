/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Object;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class Controlador {

    private HashMap<Integer, Donante> hashmapCedula;
    private HashMap<String, ArrayList<Donante>> hashmapSangre;
    private ArrayList<Donante> listaDonantes;

    public Controlador() {
        hashmapCedula = new HashMap<Integer, Donante>();
        hashmapSangre = new HashMap<String, ArrayList<Donante>>();
        listaDonantes = new ArrayList<Donante>();
        this.leerData();
        this.llenarHashmapCedula();
        this.llenarHashmapSangre();
    }

    public void llenarHashmapCedula() {

        for (int i = 0; i < listaDonantes.size(); i++) {
            int llave = listaDonantes.get(i).getCedula();
            Donante value = listaDonantes.get(i);
            hashmapCedula.put(llave, value);
        }
    }

    public void llenarHashmapSangre() {
        ArrayList<Donante> listaA1 = new ArrayList<>();
        ArrayList<Donante> listaA0 = new ArrayList<>();
        ArrayList<Donante> listaB1 = new ArrayList<>();
        ArrayList<Donante> listaB0 = new ArrayList<>();
        ArrayList<Donante> listaAB1 = new ArrayList<>();
        ArrayList<Donante> listaAB0 = new ArrayList<>();
        ArrayList<Donante> listaO1 = new ArrayList<>();
        ArrayList<Donante> listaO0 = new ArrayList<>();
        ArrayList<Donante> listaRH1 = new ArrayList<>();
        ArrayList<Donante> listaRH0 = new ArrayList<>();
        for (int i = 0; i < listaDonantes.size(); i++) {
            String llave = listaDonantes.get(i).getTipoSangre();
            switch (llave) {
                case ("A+"):
                    listaA1.add(listaDonantes.get(i));
                    break;
                case ("A-"):
                    listaA0.add(listaDonantes.get(i));
                    break;
                case ("B+"):
                    listaB1.add(listaDonantes.get(i));
                    break;
                case ("B-"):
                    listaB0.add(listaDonantes.get(i));
                    break;
                case ("AB+"):
                    listaAB1.add(listaDonantes.get(i));
                    break;
                case ("AB-"):
                    listaAB0.add(listaDonantes.get(i));
                    break;
                case ("O+"):
                    listaO1.add(listaDonantes.get(i));
                    break;
                case ("O-"):
                    listaO0.add(listaDonantes.get(i));
                    break;
                case ("RH+"):
                    listaRH1.add(listaDonantes.get(i));
                    break;
                case ("RH-"):
                    listaRH0.add(listaDonantes.get(i));
                    break;
                default:
                    System.out.println("Gabrielle es el Rey!");
                    break;
            }
        }
        hashmapSangre.put("A+", listaA1);
        hashmapSangre.put("A-", listaA0);
        hashmapSangre.put("B+", listaB1);
        hashmapSangre.put("B-", listaB0);
        hashmapSangre.put("AB+", listaAB1);
        hashmapSangre.put("AB-", listaAB0);
        hashmapSangre.put("RH+", listaRH1);
        hashmapSangre.put("RH-", listaRH0);
        hashmapSangre.put("O+", listaO1);
        hashmapSangre.put("O-", listaO0);

    }

    public Donante buscarPorCedula(int cedula) {
        return hashmapCedula.get(cedula);
    }

    public ArrayList<Donante> buscarPorSangre(String sangre) {
        return hashmapSangre.get(sangre);
    }

    public void agregarDonante(String nombres, String apellidos, int cedula, String telefono, String sexo, String tipoSangre, Date fechaNac, String direccion, int peso, Date ultimaDonacion, boolean pircing) {
        Donante Don = new Donante(nombres, apellidos, cedula, telefono, sexo, tipoSangre, fechaNac, direccion, peso, ultimaDonacion, pircing);
        listaDonantes.add(Don);
        this.escribirData();
        hashmapCedula.put(cedula, Don);
        String llave = Don.getTipoSangre();
        ArrayList<Donante> LaLista = hashmapSangre.get(llave);
        LaLista.add(Don);
        hashmapSangre.put(llave, LaLista);
        

        //TODO agregarlo al hashmap de sangre
    }

    public void agregarDonante(String nombres, String apellidos, int cedula, String telefono, String sexo, String tipoSangre, Date fechaNac, String direccion, int peso, Date ultimaDonacion, boolean pircing, Date fechaTatuaje) {
        Donante Don = new Donante(nombres, apellidos, cedula, telefono, sexo, tipoSangre, fechaNac, direccion, peso, ultimaDonacion, pircing, fechaTatuaje);
        listaDonantes.add(Don);
        this.escribirData();
        hashmapCedula.put(cedula, Don);
        //TODO agregarlo al hashmap de sangre
    }

    public void eliminarDonante(int cedDonante, String TipoSangre) {
        for (int i = 0; i < listaDonantes.size(); i++) {
            if (listaDonantes.get(i).getCedula() == cedDonante) {
                listaDonantes.remove(i);
                i = listaDonantes.size(); // break
            }
        }
        hashmapCedula.remove(cedDonante);
        ArrayList<Donante> Lista = hashmapSangre.get(TipoSangre);
        if (Lista != null) {
            for (int j = 0; j < Lista.size(); j++) {
                if (Lista.get(j).getCedula() == cedDonante) {
                    Lista.remove(j);
                    j = Lista.size(); // break
                }
            }
        }
        this.escribirData();
    }

    // Va a leer la lista de donantes
    public void leerData() {
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream("donantes.dat"));
            listaDonantes = (ArrayList<Donante>) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Va a escribir la lista de donantes   
    public void escribirData() {
        ObjectOutputStream oos = null;
        ArrayList<Donante> ObjGuardado = listaDonantes;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("donantes.dat"));
            oos.writeObject(ObjGuardado);
        } catch (IOException ex) {
        } finally {
            try {
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean puedeDonar(Donante seleccionado) {
        long FechaDeNacimiento = seleccionado.getFechaNac().getTime();
        long FechaActual = (new Date()).getTime();
        long Edad = (((((FechaActual - FechaDeNacimiento) / 1000) / 3600) / 24) / 365);
        if (Edad < 18 || Edad > 60) {
            return false;
        } else if (seleccionado.getPeso() < 50) {
            return false;
        } else if (seleccionado.getPircing()) {
            long FechaUltPiercing = seleccionado.getUltPircing().getTime();
            boolean masDe6Meses = (((FechaActual - FechaUltPiercing) / 3600000) / 24) > 180;
            if (!masDe6Meses) {
                return false;
            }
        } else {
            long FechaUltDonacion = seleccionado.getUltDonacion().getTime();
            boolean masDe3Meses = (((FechaActual - FechaUltDonacion) / 3600000) / 24) > 90;
            boolean masDe4Meses = (((FechaActual - FechaUltDonacion) / 3600000) / 24) > 120;
            if (seleccionado.getSexo().equals("Masculino")) {
                if (!masDe3Meses) {
                    return false;
                }
            } else {
                if (!masDe4Meses) {
                    return false;
                }
            }
        }
        return true;
    }

    public HashMap<Integer, Donante> getHashmapCedula() {
        return hashmapCedula;
    }

    public void setHashmapCedula(HashMap<Integer, Donante> hashmapCedula) {
        this.hashmapCedula = hashmapCedula;
    }

    public HashMap<String, ArrayList<Donante>> getHashmapSangre() {
        return hashmapSangre;
    }

    public void setHashmapSangre(HashMap<String, ArrayList<Donante>> hashmapSangre) {
        this.hashmapSangre = hashmapSangre;
    }

    public ArrayList<Donante> getListaDonantes() {
        return listaDonantes;
    }

    public void setListaDonantes(ArrayList<Donante> listaDonantes) {
        this.listaDonantes = listaDonantes;
    }
}
