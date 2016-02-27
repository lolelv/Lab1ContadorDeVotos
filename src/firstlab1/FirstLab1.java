/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstlab1;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class FirstLab1 {

    /* public void ImprimirMatriz(int[][] matriz, int var) {
        for (int i = 0; i < var; i++) {
            for (int j = 0; j < (var + 1); j++) {
                System.out.println("(matriz[i][j]) \t");
            }
            System.out.println("\n");
        }
    }*/
    static void ImprimirMatriz(int[][] x, int cand, int muni) {
        System.out.print("____________|  \t");
            
            int aux_c=0;
            while(aux_c<muni){
                //System.out.println("__________|");
                
                System.out.print("Municipio " +(aux_c+1)+ "|\t");
                aux_c=aux_c+1;
            }
            
        System.out.println("\t");    
        for (int i = 0; i <cand ; i++) {
            System.out.print("\n Candidato " +(i+1)+ "|  \t" );
            for (int j = 0; j < muni; j++) {
                System.out.print("    "  +x[i][j]+  "   \t ");
                //System.out.print( " "+x[i][j] "|");

            }
        }
    }

    static void DarPorcentaje(int totalvot, int cand, int[] votos) {
        double porcen = 0;
        for (int i = 0; i < cand; i++) {
            porcen = ((votos[i]*100)/totalvot);
            System.out.println("\n El candidato " + (i + 1) + " obtuvo el " + porcen + " % de los votos");
        }

    }

    //static void DosPrimerosGanadores(int cand, int totalvot, int[] votos, ) {
        //int dpg[];//

    //}//

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int candidatos, municipios, k;
        System.out.println("VOTACIONES DE LOS MUNICIPIOS DEL DEPARTAMENTO DE TOPAITÍ");
        System.out.print("¿Cuántos candidatos se van a ingresar?: ");
        Scanner a = new Scanner(System.in);
        candidatos = a.nextInt();
        while (candidatos > 20) {
            System.out.println("Sobrepasa la cantidad de candidatos");            
            candidatos = 0;
            System.out.print("Vuelva a ingresar el valor, recuerde que es de máximo 20: ");
            //Scanner c = new Scanner(System.in);
            candidatos = a.nextInt();
        }

        System.out.print("¿Cuántos municipios se van a ingresar?: ");
        Scanner b = new Scanner(System.in);
        municipios = b.nextInt();
        while (municipios > 20){
            System.out.println("Sobrepasa la cantidad de municipios");
            municipios = 0;
            System.out.print("Vuelva a ingresar el valor, recuerde que es de máximo 20: ");
            municipios = b.nextInt();
        }
        System.out.println("Hay " + candidatos + " candidatos, y " + municipios + " municipios.");

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese los votos de los candidatos y municipios respectivamente.");
        int[][] matriz;
        int votos[] = new int[candidatos];
        int aux = 0;
        matriz = new int[candidatos][municipios];
        for (int j = 0; j < candidatos; j++) {
            aux = 0;
            for (int i = 0; i < municipios; i++) {
                System.out.print("Candidato [" + (j + 1) + "] en el Municipio [" + (i + 1) + "]:");
                matriz[j][i] = leer.nextInt();
                aux = aux + matriz[j][i];
                votos[j] = aux;
            }
        }

        System.out.println("");
        System.out.println("Los votos están ubicados: Filas de candidatos / Columnas de municipios.");
        /*for (k = 1; (k < candidatos) && (k < municipios); k++) {
            double[][] A = new double[candidatos][municipios];*/

        ImprimirMatriz(matriz, candidatos, municipios);
        System.out.println("\n");
        int total = 0;
        for (int i = 0; i < candidatos; i++) {
            System.out.println(" Candidato " + (i + 1) + " obtuvo: " + votos[i] + " votos.");
            total = total + votos[i];
        }
        System.out.println("Total votos:" + total);
        DarPorcentaje(total, candidatos, votos);

        int mayor = 0;
        int idenCand = 0;
        for (int i = 0; i < candidatos; i++) {
            if (votos[i] > mayor) {
                mayor = votos[i];
                idenCand = i;
            }
        }
        System.out.println("El candadato " + (idenCand + 1) + " fue el que obtuvo más votos.");

        double ganador = (total * 0.5);
        int band_2=0;
        int idenGanador = 0;
        for (int i = 0; i < candidatos; i++) {
            if (votos[i] > ganador) {
                ganador = votos[i];
                idenGanador = i;
            }
        }
        if (idenGanador != 0) {
            System.out.println("El candidato " + (idenGanador + 1) + " es el ganador ,ya que obtuvo más del 50% de los votos.");
            band_2=1;
        } else {
            System.out.println("No hubo ningun ganador, pues ninguno obtuvo más del 50% en las votaciones.");
            System.out.println("Los dos candidatos que pasan a la siguiente ronda son: ");
        }
        
        if(band_2!=1){
            int idenGanador2=-1;
            int Ganador2=-1;
            int bandera=0;
            for(int d=0; d<candidatos; d++){
                if(votos[d]==votos[idenCand] && d!=idenCand){
                    bandera=1;
                    System.out.println("Los candidatos "+(idenCand+1)+" y " +(d+1)+" .Estos quedaron en empate.");
                  
                }else if(votos[d]<votos[idenCand] && votos[d]>=Ganador2 ){
                       Ganador2=votos[d];
                       idenGanador2=d;
                    }
                    
                }
                if(bandera==0){
                   System.out.println("El candidato " +(idenCand+1)+ " y el candidato " +(idenGanador2+1));
                   
                }
            }
            
          

            }

}

        // TODO code application logic here
    
