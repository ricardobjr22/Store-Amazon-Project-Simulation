/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author elric
 */
public class file {
    File myFile;
    FileWriter fw;
    BufferedWriter bw;
    
    FileReader fr;
    BufferedReader br;
    
    private int lastID;
    
    public file(String nameFile, int id) throws IOException{
        try{
            myFile = new File(nameFile);
            if(!myFile.exists()){
                myFile.createNewFile();
                fw = new FileWriter(myFile.getAbsoluteFile(), true);
                bw = new BufferedWriter(fw);
                bw.write(String.valueOf(id) + "\n****\n");
                lastID = id;
            }else{
                fw = new FileWriter(myFile.getAbsoluteFile(), true);
                bw = new BufferedWriter(fw);
            }
            
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "No se pudo crear el archivo");
        }finally{
            try{
                if(bw != null)
                    bw.close();
                if(fw != null)
                    fw.close();
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    
    public boolean rename(File newNameFile){
        return myFile.renameTo(newNameFile);
    }
    
    public boolean exist(){
        return myFile.exists();
    }
    
    public void updateLastID_us(String id){
        try{
            file myFile2 = new file("temp.txt", Integer.parseInt(id));
            fr = new FileReader(myFile.getAbsoluteFile());
            br = new BufferedReader(fr);
            String dataTemp;
            int index;
            while((dataTemp = br.readLine()) != null){
                if(dataTemp.contains("****")){
                    break;
                }
            }
            while((dataTemp = br.readLine()) != null){
                myFile2.write_us(dataTemp + "\n");
            }
            if(br != null)
                br.close();
            if(fr != null)
                fr.close();
            File newFile = new File("archivo.txt");
            if(!(myFile.delete() && myFile2.rename(newFile))){
                JOptionPane.showMessageDialog(null, "Error en update ID");
            }
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, ex);
        } finally{
            try{
                if(br != null)
                    br.close();
                if(fr != null)
                    fr.close();
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    
    public void updateLastID_pr(String id){
        try{
            file myFile2 = new file("temp.txt", Integer.parseInt(id));
            fr = new FileReader(myFile.getAbsoluteFile());
            br = new BufferedReader(fr);
            String dataTemp;
            int index;
            while((dataTemp = br.readLine()) != null){
                if(dataTemp.contains("****")){
                    break;
                }
            }
            while((dataTemp = br.readLine()) != null){
                myFile2.write_us(dataTemp + "\n");
            }
            if(br != null)
                br.close();
            if(fr != null)
                fr.close();
            File newFile = new File("archivo1.txt");
            if(!(myFile.delete() && myFile2.rename(newFile))){
                JOptionPane.showMessageDialog(null, "Error en update ID");
            }
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, ex);
        } finally{
            try{
                if(br != null)
                    br.close();
                if(fr != null)
                    fr.close();
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    
    public int getLastID(){
        try{
            fr = new FileReader(myFile.getAbsoluteFile());
            br = new BufferedReader(fr);
            String data = br.readLine();
            return Integer.parseInt(data);
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, ex);
        } finally{
            try{
                if(br != null)
                    br.close();
                if(fr != null)
                    fr.close();
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        return 0;
    }
    
    public void write_us(String data) throws IOException{
        try{
            String tmp = "";
            fw = new FileWriter(myFile.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(data);
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, ex);
        } finally{
            try{
                if(bw != null)
                    bw.close();
                if(fw != null)
                    fw.close();
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    
    public void write_pr(String data) throws IOException{
        try{
            String tmp = "";
            fw = new FileWriter(myFile.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(data);
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, ex);
        } finally{
            try{
                if(bw != null)
                    bw.close();
                if(fw != null)
                    fw.close();
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    
    public usuarios search_us(String data) throws IOException{
        try{
            fr = new FileReader(myFile.getAbsoluteFile());
            br = new BufferedReader(fr);
            String dataTemp;
            String tmp = "";
            usuarios u = new usuarios();
            int index;
            while((dataTemp = br.readLine()) != null){
                if(dataTemp.contains("****")){
                    break;
                }
            }
            while((dataTemp = br.readLine()) != null){
                for(int i = 0; i < dataTemp.length(); i++){
                    if(dataTemp.charAt(i) != '|'){
                        tmp += dataTemp.charAt(i);
                    }else{
                        break;
                    }
                }
                if(tmp.equals(data)){
                    index = 0;
                    tmp = "";
                    for(int i = 0; i < dataTemp.length(); i++){
                        if(dataTemp.charAt(i) != '|'){
                            tmp += dataTemp.charAt(i);
                        }else{
                            switch(index){
                                case 0:
                                    u.setID(Integer.parseInt(tmp));
                                    break;
                                case 1:
                                    u.setNombre(tmp);
                                    break;
                                case 2:
                                    u.setAp(tmp);
                                    break;
                                case 3:
                                    u.setAm(tmp);
                                    break;
                                case 4:
                                    u.setPerfil(tmp);
                                    break;
                                case 5:
                                    u.setNombre_usuario(tmp);
                                    break;
                                case 6:
                                    u.setContraseña(tmp);
                                    break;
                                case 7:
                                    u.setCalificacion(Double.parseDouble(tmp));
                            }
                            tmp = "";
                            index++;
                        }
                    }
                    return u;
                }else{
                    tmp = "";
                }
            }
        }catch(IOException ex){
                JOptionPane.showMessageDialog(null, ex);
            } finally{
                try{
                    if(br != null)
                        br.close();
                    if(fr != null)
                        fr.close();
                }catch(IOException ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        return null;
    }
    
    public productos search_pr(String data) throws IOException{
        try{
            fr = new FileReader(myFile.getAbsoluteFile());
            br = new BufferedReader(fr);
            String dataTemp;
            String tmp = "";
            productos pr = new productos();
            int index;
            while((dataTemp = br.readLine()) != null){
                if(dataTemp.contains("****")){
                    break;
                }
            }
            while((dataTemp = br.readLine()) != null){
                for(int i = 0; i < dataTemp.length(); i++){
                    if(dataTemp.charAt(i) != '|'){
                        tmp += dataTemp.charAt(i);
                    }else{
                        break;
                    }
                }
                if(tmp.equals(data)){
                    index = 0;
                    tmp = "";
                    for(int i = 0; i < dataTemp.length(); i++){
                        if(dataTemp.charAt(i) != '|'){
                            tmp += dataTemp.charAt(i);
                        }else{
                            switch(index){
                                case 0:
                                    pr.setID(Integer.parseInt(tmp));
                                    break;
                                case 1:
                                    pr.setVendedorID(Integer.parseInt(tmp));
                                    break;
                                case 2:
                                    pr.setDescripcion(tmp);
                                    break;
                                case 3:
                                    pr.setCategoria(tmp);
                                    break;
                                case 4:
                                    pr.setPrecio(Double.parseDouble(tmp));
                                    break;
                                case 5:
                                    pr.setCantidad(Integer.parseInt(tmp));
                                    break;
                                case 6:
                                    pr.setCantidadVendida(Integer.parseInt(tmp));
                                    break;
                                case 7:
                                    pr.setCalificacion(Double.parseDouble(tmp));
                                    break;
                                case 8:
                                    pr.setImagen(tmp);
                            }
                            tmp = "";
                            index++;
                        }
                    }
                    return pr;
                }else{
                    tmp = "";
                }
            }
        }catch(IOException ex){
                JOptionPane.showMessageDialog(null, ex);
            } finally{
                try{
                    if(br != null)
                        br.close();
                    if(fr != null)
                        fr.close();
                }catch(IOException ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        return null;
    }
    
    public void modify_us(String id, String data){
        try{
            file myFile2 = new file("temp.txt", getLastID());
            fr = new FileReader(myFile.getAbsoluteFile());
            br = new BufferedReader(fr);
            String dataTemp;
            String tmp = "";
            int index;
            while((dataTemp = br.readLine()) != null){
                if(dataTemp.contains("****")){
                    break;
                }
            }
            while((dataTemp = br.readLine()) != null){
                tmp = "";
                for(int i = 0; i < dataTemp.length(); i++){
                    if(dataTemp.charAt(i) != '|'){
                        tmp += dataTemp.charAt(i);
                    }else{
                        break;
                    }
                }
                if(tmp.equals(id)){
                    myFile2.write_us(data);
                }else{
                    myFile2.write_us(dataTemp + "\n");
                }
            }
            if(br != null)
                br.close();
            if(fr != null)
                fr.close();
            File newFile = new File("archivo.txt");
            if(myFile.delete() && myFile2.rename(newFile)){
                JOptionPane.showMessageDialog(null, "Archivo modificado con éxito");
            }else{
                JOptionPane.showMessageDialog(null, "El archivo no se pudo modificar");
            }
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, ex);
        } finally{
            try{
                if(br != null)
                    br.close();
                if(fr != null)
                    fr.close();
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    
    public void modify_pr(String id, String data){
        try{
            file myFile2 = new file("temp.txt", getLastID());
            fr = new FileReader(myFile.getAbsoluteFile());
            br = new BufferedReader(fr);
            String dataTemp;
            String tmp = "";
            int index;
            while((dataTemp = br.readLine()) != null){
                if(dataTemp.contains("****")){
                    break;
                }
            }
            while((dataTemp = br.readLine()) != null){
                tmp = "";
                for(int i = 0; i < dataTemp.length(); i++){
                    if(dataTemp.charAt(i) != '|'){
                        tmp += dataTemp.charAt(i);
                    }else{
                        break;
                    }
                }
                if(tmp.equals(id)){
                    myFile2.write_us(data);
                }else{
                    myFile2.write_us(dataTemp + "\n");
                }
            }
            if(br != null)
                br.close();
            if(fr != null)
                fr.close();
            File newFile = new File("archivo1.txt");
            if(myFile.delete() && myFile2.rename(newFile)){
                JOptionPane.showMessageDialog(null, "Archivo modificado con éxito");
            }else{
                JOptionPane.showMessageDialog(null, "El archivo no se pudo modificar");
            }
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, ex);
        } finally{
            try{
                if(br != null)
                    br.close();
                if(fr != null)
                    fr.close();
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    
    public void delete_us(String id){
        try{
            file myFile2 = new file("temp.txt", getLastID() - 1);
            fr = new FileReader(myFile.getAbsoluteFile());
            br = new BufferedReader(fr);
            String dataTemp;
            String tmp = "";
            while((dataTemp = br.readLine()) != null){
                if(dataTemp.contains("****")){
                    break;
                }
            }
            while((dataTemp = br.readLine()) != null){
                for(int i = 0; i < dataTemp.length(); i++){
                    if(dataTemp.charAt(i) != '|'){
                        tmp += dataTemp.charAt(i);
                    }else{
                        break;
                    }
                }
                if(!(tmp.equals(id))){
                    myFile2.write_us(dataTemp + "\n");
                }
            }
            if(br != null)
                br.close();
            if(fr != null)
                fr.close();
            File newFile = new File("archivo.txt");
            if(myFile.delete() && myFile2.rename(newFile)){
                JOptionPane.showMessageDialog(null, "Elemento eliminado con éxito");
            }else{
                JOptionPane.showMessageDialog(null, "El elemento no se pudo eliminar");
            }
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, ex);
        } finally{
            try{
                if(br != null)
                    br.close();
                if(fr != null)
                    fr.close();
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    
    public void delete_pr(String id){
        try{
            file myFile2 = new file("temp.txt", getLastID() - 1);
            fr = new FileReader(myFile.getAbsoluteFile());
            br = new BufferedReader(fr);
            String dataTemp;
            String tmp = "";
            while((dataTemp = br.readLine()) != null){
                if(dataTemp.contains("****")){
                    break;
                }
            }
            while((dataTemp = br.readLine()) != null){
                for(int i = 0; i < dataTemp.length(); i++){
                    if(dataTemp.charAt(i) != '|'){
                        tmp += dataTemp.charAt(i);
                    }else{
                        break;
                    }
                }
                if(!(tmp.equals(id))){
                    myFile2.write_us(dataTemp + "\n");
                }
            }
            if(br != null)
                br.close();
            if(fr != null)
                fr.close();
            File newFile = new File("archivo1.txt");
            if(myFile.delete() && myFile2.rename(newFile)){
                JOptionPane.showMessageDialog(null, "Elemento eliminado con éxito");
            }else{
                JOptionPane.showMessageDialog(null, "El elemento no se pudo eliminar");
            }
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, ex);
        } finally{
            try{
                if(br != null)
                    br.close();
                if(fr != null)
                    fr.close();
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
}
