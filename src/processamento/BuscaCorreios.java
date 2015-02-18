/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package processamento;

import BB_SISBB.SISBB;
import java.util.ArrayList;

/**
 *
 * @author f7057419 BUSCA OS CORREIOS E GERA UMA LISTA COM STRINGS DOS CORREIOS
 * QUE SERÃO TRATADOS EM OUTRO MÓDULO
 */
public class BuscaCorreios {

    public ArrayList Sisbb(String txtChave, String txtSenha, ArrayList listaCorreios) throws Exception {

        SISBB p = new SISBB("o");
        String cel = "";

      //  ArrayList<String> listaCorreios2 = new ArrayList<>();
        //  BufferedWriter out = new BufferedWriter(new FileWriter("C:\\temp\\saida.txt"));
        // ABRE EMULADOR
        p.open();
        p.connect();
        p.waitFor("SISTEMA DE INFORMACOES BANCO DO BRASIL");
        p.enter();
        p.getVar().WaitForInput();

        // LOGIN
        p.waitFor("Código de Usuário:");
        p.set(txtChave, 13, 21);
        p.set(txtSenha, 14, 21);
        p.opcaoLogin(1);    //OPÇÃO PARA ENTRAR DIRETO NO CIC

        //ESCOLHER APLICATIVO
        p.waitFor("Navegador de Aplicativos");
        p.set("correio", 15, 14);
        p.set(txtSenha, 16, 14);
        p.enter();
        p.getVar().WaitForInput();
        p.waitFor("F5");

        // VERIFICA TELA DE AVISO
        /*  while (!p.get(1, 10, 1).equals("0")) {
         p.f3(); 
         //  p.getVar().WaitForInput();
         }*/
        if (p.get(6, 21, 7).equals("Existem")) {
            p.f3();
            //    p.getVar().WaitForInput();
        }
        p.waitFor("COEPC001");
        p.set("01", 21, 17);
        p.enter();
        p.getVar().WaitForInput();

        p.waitFor("COEM0015");
        p.set("21", 21, 18);
        p.enter();
        p.getVar().WaitForInput();

        p.waitFor("COEM1200");
        p.set("05", 14, 24);
//SJBACENIMP
   // p.set("SJBACENIMP", 17, 24);
    //   p.set("sjoficio4", 17, 24);
      p.set("sjbacensol", 17, 24);
        //p.set("1903", 20, 34);

        p.enter();
        p.getVar().WaitForInput();

        p.waitFor("COEM1260");

        do {
            String i = p.get(9, 3, 4);
            int ii;
            int i2 = 8;
            ii = Integer.parseInt(i);
            //  System.out.println(i);

            for (int j = ii; j < ii + 12; j++) {
                int linha = 0;
                String textLinha;
                String linha5, linha6, linha7, linha8, linha9, linha10, linha11, linha12, linha13, linha14, linha15, linha16, linha17, linha18, linha19, linha20, linha21, linha22;
                String textoCorreio = "";
                i2++;

                //System.out.println(j);
                //
                if (p.get(i2, 38, 11).equals("SOLICITACAO")) {
                    p.set(String.valueOf(j), 21, 28);
                    p.enter();
                    p.getVar().WaitForInput();

                    if (p.get(23, 42, 8).equals("registro")) {
                        j = j++;
                        p.set(String.valueOf(j), 21, 28);
                        p.enter();
                        p.getVar().WaitForInput();

                    }
                    p.getVar().WaitForInput();
                    p.waitFor("COEM1266");

                    do {
                        //Entrou na mensagem
                        linha5 = (p.get(5, 6, 74));//.replaceAll("CENGSV", "xxxxx").replaceAll("ABRIR GSV", "x");
                        linha6 = (p.get(6, 6, 74));//.replaceAll("CENGSV", "xxxxx").replaceAll("ABRIR GSV", "x");
                        linha7 = (p.get(7, 6, 74));//.replaceAll("CENGSV", "xxxxx").replaceAll("ABRIR GSV", "x");
                        linha8 = (p.get(8, 6, 74));//.replaceAll("CENGSV", "xxxxx").replaceAll("ABRIR GSV", "x");
                        linha9 = (p.get(9, 6, 74));//.replaceAll("CENGSV", "xxxxx").replaceAll("ABRIR GSV", "x");
                        linha10 = (p.get(10, 6, 74));//;.replaceAll("CENGSV", "xxxxx").replaceAll("ABRIR GSV", "x");
                        linha11 = (p.get(11, 6, 74));//.replaceAll("CENGSV", "xxxxx").replaceAll("ABRIR GSV", "x");
                        linha12 = (p.get(12, 6, 74));//.replaceAll("CENGSV", "xxxxx").replaceAll("ABRIR GSV", "x");
                        linha13 = (p.get(13, 6, 74));//.replaceAll("CENGSV", "xxxxx").replaceAll("ABRIR GSV", "x");
                        linha14 = (p.get(14, 6, 74));//.replaceAll("CENGSV", "xxxxx").replaceAll("ABRIR GSV", "x");
                        linha15 = (p.get(15, 6, 74));//.replaceAll("CENGSV", "xxxxx").replaceAll("ABRIR GSV", "x");
                        linha16 = (p.get(16, 6, 74));//.replaceAll("CENGSV", "xxxxx").replaceAll("ABRIR GSV", "x");
                        linha17 = (p.get(17, 6, 74));//.replaceAll("CENGSV", "xxxxx").replaceAll("ABRIR GSV", "x");
                        linha18 = (p.get(18, 6, 74));//.replaceAll("CENGSV", "xxxxx").replaceAll("ABRIR GSV", "x");
                        linha19 = (p.get(19, 6, 74));//.replaceAll("CENGSV", "xxxxx").replaceAll("ABRIR GSV", "x");
                        linha20 = (p.get(20, 6, 74));//.replaceAll("CENGSV", "xxxxx").replaceAll("ABRIR GSV", "x");
                        linha21 = (p.get(21, 6, 74));//.replaceAll("CENGSV", "xxxxx").replaceAll("ABRIR GSV", "x");
                        linha22 = (p.get(22, 6, 74));//.replaceAll("CENGSV", "xxxxx").replaceAll("ABRIR GSV", "x");

                        /*/se a linha começa com a palavra "GSV" insere "@@" no começo para facilitar o tratamento posterior  
                          
                        try {
                            if ("GSV".equals(linha5.substring(0, 3).toUpperCase())) {
                            linha5 = "@@" + linha5.toUpperCase();
                        }                             
                        } catch (Exception e) {                          
                        }
                        try {
                             if ("GSV".equals(linha6.substring(00, 3).toUpperCase())) {
                            linha6 = "@@" + linha6.toUpperCase();
                        }                            
                        } catch (Exception e) {
                        }             
                        try {
                             if ("GSV".equals(linha7.substring(0, 3).toUpperCase())) {
                            linha7 = "@@" + linha7.toUpperCase();
                        }                            
                        } catch (Exception e) {
                        }                      
                       try {
                             if ("GSV".equals(linha8.substring(0, 3).toUpperCase())) {
                            linha8 = "@@" + linha8.toUpperCase();
                        }                            
                        } catch (Exception e) {                            
                        }                        
             //System.out.println(linha9); 
                         try {
                              if ("GSV".equals(linha9.substring(0, 3).toUpperCase())) {
                            linha9 = "@@" + linha9.toUpperCase();
                        }                            
                        } catch (Exception e) {                           
                        }                  
                         try {
                              if ("GSV".equals(linha10.substring(0, 3).toUpperCase())) {
                            linha10 = "@@" + linha10.toUpperCase();
                        }                            
                        } catch (Exception e) {                           
                        }          
                         try {
                             if ("GSV".equals(linha11.substring(0, 3).toUpperCase())) {
                            linha11 = "@@" + linha11.toUpperCase();
                        }                            
                        } catch (Exception e) {                          
                        }
                                                
                         try {
                              if ("GSV".equals(linha12.substring(0, 3).toUpperCase())) {
                            linha12 = "@@" + linha12.toUpperCase();
                        }                              
                        } catch (Exception e) {                        
                        }                                             
                       
                      //  System.out.println(linha13.length());
                          try {                                 
                              if ("GSV".equals(linha13.substring(0, 3).toUpperCase())||linha13.length()!=0) {
                              linha13 = "@@" + linha13.toUpperCase();
                              }                     
                        } catch (Exception e) {                            
                        }                             
                       
                         try {
                              if ("GSV".equals(linha14.substring(0, 3).toUpperCase())) {
                            linha14 = "@@" + linha14.toUpperCase();
                        }                            
                        } catch (Exception e) {                           
                        }                      
                       
                         try {
                             if ("GSV".equals(linha15.substring(0, 3).toUpperCase())) {
                            linha15 = "@@" + linha15.toUpperCase();
                        }
                            } catch (Exception e) {                           
                        }
                     
                         try {
                               if ("GSV".equals(linha16.substring(0, 3).toUpperCase())) {
                            linha16 = "@@" + linha16.toUpperCase();
                        }                            
                        } catch (Exception e) {
                                                    }                     
                       
                         try {
                               if ("GSV".equals(linha17.substring(0, 3).toUpperCase())) {
                            linha17 = "@@" + linha17.toUpperCase();
                        }                            
                        } catch (Exception e) {
                          
                        }
                        try {
                              if ("GSV".equals(linha18.substring(0, 3).toUpperCase())) {
                            linha18 = "@@" + linha18.toUpperCase();
                        }                            
                        } catch (Exception e) {                           
                        }
                       
                        try {
                              if ("GSV".equals(linha19.substring(0, 3).toUpperCase())) {
                            linha19 = "@@" + linha19.toUpperCase();
                        }
                        } catch (Exception e) {
                                                 }                       
                       
                          try {
                                if ("GSV".equals(linha20.substring(0, 3).toUpperCase())) {
                            linha20 = "@@" + linha20.toUpperCase();
                        }                            
                        } catch (Exception e) {                           
                        }
                      
                       try {
                              if ("GSV".equals(linha21.substring(0, 3).toUpperCase())) {
                            linha21 = "@@" + linha21.toUpperCase();
                        }                            
                        } catch (Exception e) {                           
                        }                     
                         try {
                             if ("GSV".equals(linha22.substring(0, 3).toUpperCase())) {
                            linha22 = "@@" + linha22.toUpperCase();
                        }                            
                        } catch (Exception e) {
                            
                        }
                        */

                        textoCorreio = textoCorreio + "\n" + linha5 + "\n" + linha6 + "\n" + linha7 + "\n" + linha8 + "\n" + linha9 + "\n" + linha10 + "\n" + linha11 + "\n" + linha12 + "\n" + linha13 + "\n" + linha14 + "\n" + linha15 + "\n" + linha16 + "\n" + linha17 + "\n" + linha18 + "\n" + linha19 + "\n" + linha20 + "\n" + linha21 + "\n" + linha22;
           //             System.out.println(textoCorreio);       

                        if  (!p.get(23, 4, 6).equals("Última")){
                            p.f8();
                            p.getVar().WaitForInput();
                        }
                        
                        
                    } while (!p.get(23, 4, 6).equals("Última"));
                    listaCorreios.add(textoCorreio);
                    p.f3();
                    p.getVar().WaitForInput();
                    // System.out.println(listaCorreios.size());
                }
                //  System.out.println("ssssssss");
            }

            p.f8();

            p.getVar().WaitForInput();

} while (!p.get(23, 3, 6).equals("Última")); 
// } while (p.get(23, 3, 6).equals("Última"));   //teste copiar só as mensagens da primeira página

       // System.out.println("Chegou na Última tela");
       // System.out.println(listaCorreios.size());

        p.dispose();

        /*   for (Object string : listaCorreios) {
         //  JOptionPane.showMessageDialog(null, string);           
         System.out.println(string); 
         System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
         System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
         System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
         System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
         System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
         System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
         System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
         System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
         System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
         System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
         System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
         System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
         System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
         System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");      
         }*/
        return listaCorreios;

    }

// p.f5();
    // p.f5();
    /*// FINALIZA EMULADOR
     p.f3();
     p.f5();
     p.f5();
     p.dispose();
       
     JOptionPane.showMessageDialog(null,
     "Captura finalizada com sucesso!" + "\r\n");
     */
} // FIM - método sisbb

