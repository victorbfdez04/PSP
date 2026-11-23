package com.mycompany.lanzadorprocesos;


public class LanzadorProcesos {
    public void ejecutar(String ruta){ 
            ProcessBuilder pb;
            try {
                    pb = new ProcessBuilder(ruta);
                    pb.start();
            } catch (Exception e) {
                    e.printStackTrace();
            }
    } 
    
 	public static void main(String[] args) {
            //String ruta= "C:\\Program Files\\Notepad++\\notepad++.exe";
 		String ruta = "C:\\Users\\b15-01m\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe";
            LanzadorProcesos lp=new LanzadorProcesos();
            lp.ejecutar(ruta);
            System.out.println("Finalizado");
    }
}

