/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processamento;

import BB_SISBB.SISBB;
import Telas.FrmSolicitacao;
import bacenjud.Autor;
import bacenjud.Comprovante;
import bacenjud.Juiz;
import bacenjud.Processo;
import bacenjud.Reu;
import bacenjud.pesquisaProcessados;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static org.joda.time.DateTime.now;
import org.joda.time.LocalDate;



/**
 *
 * @author f7057419
 *
 */
public class TrataCorreios {

    public ArrayList VerificarCorreiosForaDoPadrao(ArrayList<String> ListaCorreio) throws FileNotFoundException {
    //   System.out.println(ListaCorreio.size());
        ArrayList<String> listaCorreioCorretos = new ArrayList<>();
        ArrayList<String> listaCorreioforaDoPadrao = new ArrayList<>();
        
        LocalDate hoje=new LocalDate();
        
        //Criacao da pasta
               LocalDate hojePasta = new LocalDate();
               String mesS = null;
        int mess;
        int ano;
        int dia;
       // String data = "07/10/2014";
        dia = hojePasta.getDayOfMonth();
        mess = hojePasta.getMonthOfYear();
        ano = hojePasta.getYear(); 
        
            System.out.println(dia);
            System.out.println(mess);
            System.out.println(ano);  

        switch (mess) {
            case 1:
                mesS = "Janeiro";
                break;
            case 2:
                mesS = "Fevereiro";
                break;
            case 3:
                mesS = "Março";
                break;
            case 4:
                mesS = "Abril";
                break;
            case 5:
                mesS = "Maio";
                break;
            case 6:
                mesS = "Junho";
                break;
            case 7:
                mesS = "Julho";
                break;
            case 8:
                mesS = "Agosto";
                break;
            case 9:
                mesS = "Setembro";
                break;
            case 10:
                mesS = "Outubro";
                break;
            case 11:
                mesS = "Novembro";
                break;
            case 12:
                mesS = "Dezembro";
                break;
        }

        
        
  /*      File dir = new File("c:/temp/OFICIO/BACENJUD/");
        File dirAno = new File("c:/temp/OFICIO/BACENJUD/"+ano);
        File dirMes = new File("c:/temp/OFICIO/BACENJUD/"+ano+"/"+mesS);
        File dirDia = new File("c:/temp/OFICIO/BACENJUD/"+ano+"/"+mesS+"/"+dia);    */
        
     
        
//Salvar na Rede
        
      //  "G:\\Publica\\CENTRAL DE OFICIOS\\BACENJUD SOLICITACAO\\
        
        
        File dirrede = new File("G:\\Publica\\CENTRAL DE OFICIOS\\BACENJUD SOLICITACAO\\");
        File dirAnorede = new File("G:\\Publica\\CENTRAL DE OFICIOS\\BACENJUD SOLICITACAO\\"+ano);
        File dirMesrede = new File("G:\\Publica\\CENTRAL DE OFICIOS\\BACENJUD SOLICITACAO\\"+ano+"\\"+mesS);
        File dirDiarede = new File("G:\\Publica\\CENTRAL DE OFICIOS\\BACENJUD SOLICITACAO\\"+ano+"\\"+mesS+"\\"+dia); 
        
        
        
        
        try {
          //  dir.mkdir();
            dirrede.mkdir();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
          //  dirAno.mkdir();
            dirAnorede.mkdir();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
          //  dirMes.mkdir();
            dirMesrede.mkdir();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try {
        //    dirDia.mkdir();
            dirDiarede.mkdir();
        } catch (Exception e) {
            System.out.println(e);
        }
                       
   //                
       
        
        
     
        
     /*   FileOutputStream arquivo;
        arquivo = new FileOutputStream("c:/temp/OFICIO/BACENJUD/"+ano+"/"+mesS+"/"+dia+"/ForaPadrão_Data_"+now().toLocalTime().toString().replaceAll("/", "").replaceAll("-", "").replaceAll(":", "").substring(0, 6)+".txt");
        PrintStream printStream = new PrintStream(arquivo);    */    
        
        //Rede
        FileOutputStream arquivorede;
        arquivorede = new FileOutputStream("G:\\Publica\\CENTRAL DE OFICIOS\\BACENJUD SOLICITACAO\\"+ano+"\\"+mesS+"\\"+dia+"\\ForaPadrão_Data_"+now().toLocalTime().toString().replaceAll("/", "").replaceAll("-", "").replaceAll(":", "").substring(0, 6)+".txt");
        PrintStream printStreamRede = new PrintStream(arquivorede); 

    
        
        for (String correio : ListaCorreio) {
        //    System.out.println(correio);
          //   printStream.println(correio);            
/*             printStream.println("/////////////////");
             printStream.println("/////////////////");
             printStream.println("/////////////////");
             printStream.println("/////////////////");*/
             
             //rede
             printStreamRede.println(correio);            
             printStreamRede.println("/////////////////");
             printStreamRede.println("/////////////////");
             printStreamRede.println("/////////////////");
             printStreamRede.println("/////////////////");
             
             
             
             //      System.out.println(correio.replaceAll("solicitada", "solicitado"));
            Boolean contemData = true;
          //  Boolean contemGsv = true;
           
            String procurarPor = "&&";
            
       //     String procurarPor = "TRANSF.INTERBANCARIA";
       //     String procurarPor1 = "DATA DO ENVIO";
       //     String procurarPor2 = "SOLICITADO EM";
       //     String procurarPor3 = "DATA DE ENVIO";
         //   String procurarPor3 = "@@GSV";
            
            // String procurarPor4 = "SOLICITACAO"; 

      //      System.out.println(correio);
      //      System.out.println(correio.toUpperCase().contains(procurarPor.toUpperCase()));
      //      System.out.println(correio.toUpperCase().contains(procurarPor1.toUpperCase()));
      //      System.out.println(correio.toUpperCase().contains(procurarPor2.toUpperCase()));
      //      System.out.println(correio.toUpperCase().contains(procurarPor3.toUpperCase()));       
       /*     
       
        String gsv = correio.replaceAll("-", "").replace(":", "");
        int tamanhoString = gsv.length();
        
        
        System.out.println(correio);
        System.out.println (gsv.substring(tamanhoString - 30, tamanhoString).trim().replaceAll(" ", "").replaceAll(":", ""));
        gsv = gsv.substring(tamanhoString - 30, tamanhoString).trim().replaceAll(" ", "").replaceAll(":", "");
            
            
            
            
            
            
            
            
          //  int tamanhoString=correio.replaceAll("-", "").length();            
      //      String gsv="";
       //             gsv=correio.substring(tamanhoString -30, tamanhoString).trim().replaceAll(" ","").replaceAll(":", "");             
            System.out.println("GSV+++++ : " +gsv);
            System.out.println("GSV+++++ : " +gsv.length());
            
            
            System.out.println(gsv.toUpperCase().contains(procurarPor3.toUpperCase()));           
            */
            
            //System.out.println(correio.toUpperCase().contains(procurarPor4.toUpperCase()));//Sempre tem
         //   System.out.println("//////");
         //   System.out.println("//////");

       /*     if (!correio.toUpperCase().contains(procurarPor.toUpperCase())) {
                if (!correio.toUpperCase().contains(procurarPor1.toUpperCase())) {
                    if (!correio.toUpperCase().contains(procurarPor2.toUpperCase())) {
                        if (!correio.toUpperCase().contains(procurarPor2.toUpperCase())) {
                            if (!correio.toUpperCase().contains(procurarPor3.toUpperCase())) {
                                contemData = false;  
                                
                                printStream.println(correio);
                                printStream.println("/////////////////");
                                printStream.println("/////////////////");
                                printStream.println("/////////////////");
                                printStream.println("/////////////////");
                            }            
                        }
                                           
                    }
                }
            }*/

            
               if (!correio.toUpperCase().contains(procurarPor.toUpperCase())) {                      

                               contemData=false;                                 
             }        
            
            
            
            
            
            
            
            
//            if (!correio.toUpperCase().contains(procurarPor3.replaceAll(":", ""))){
//                contemGsv = false;               
//            }

           // System.out.println(correio);            
           //if (contemData == false||contemGsv==false) {
                 if (contemData == false) {                
                //pegar o número do correio                
                String A[] = correio.split(":");
                String numeroCorreio = (A[1]).substring(0, 13);       
                //System.out.println(numeroCorreio);          
                listaCorreioforaDoPadrao.add(numeroCorreio);      
               }else{
              listaCorreioCorretos.add(correio);  
            }                  
            
        }
        
        
        
        

   //     System.out.println(listaCorreioCorretos.size());
   //     System.out.println(listaCorreioforaDoPadrao.size());        
        
        for (String txt : listaCorreioforaDoPadrao) {            
//         printStream.println(txt+" ; "+hoje); 
         printStreamRede.println(txt+" ; "+hoje); 
        }
        //gerar txt com correios fora do padrão
        return listaCorreioCorretos;
    }

    public ArrayList GeraListaReus(String txtChave, String txtSenha,ArrayList<String> ListaCorreio) throws SQLException {
        ArrayList<Reu> listaReu = new ArrayList<>();
        //    Recebe a Lista de strings de correios recorta os dados, carrega lista objetos reu
        //8035782009991;        
     //   System.out.println(ListaCorreio.size());

        for (String correio : ListaCorreio) {
       System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"); 
       System.out.println(correio);   
       System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"); 
       //ID REU 
     /*  String A[] = correio.split("ID da Transferência  :"); 
       String idReu = (A[1]);        
       String B[] = idReu.split("\n");
       idReu = (B[0]).trim();  
       System.out.println(idReu); */
       
        //ID AUTOR
       String A[] = correio.split("ID da Transferência  :");
       String idReu = (A[1]);             
     //System.out.println(idReu);       
       String B[] = idReu.split("Autor:");
       idReu = (B[0]).trim();  
       System.out.println(idReu); 
       
       
       
       
       
       //CPF REU 
       String C[] = correio.split("-  C");
       String cpfReu = (C[1]);       
       String c[] =cpfReu.split(":");
       cpfReu = (c[1]).trim();        
     //  System.out.println(cpfReu);       
       String D[] =cpfReu.split("\n");
       cpfReu = (D[0]).trim();  
   //    System.out.println(cpfReu);      
        
       //NOME REU 
       String E[] = correio.split("Nome           :");
       String nomeReu = (E[1]);             
     //  System.out.println(nomeReu);       
       String F[] = nomeReu.split("\n");
       nomeReu = (F[0]).trim();   
     //  System.out.println(nomeReu); 
       
       //PREFIXO AGÊNCIA REU 
       String G[] = correio.split("Prefixo agência:");
       String prefixoAgenciaReu = (G[1]); 
       String g[] = prefixoAgenciaReu.split("\n");
       prefixoAgenciaReu = (g[0]).trim();
       
       
 
   //  System.out.println(prefixoAgenciaReu);    
       Reu reu=new Reu();
       
       reu.setId(idReu);
       reu.setCpf(cpfReu);
       reu.setNome(nomeReu);
       reu.setAgencia(prefixoAgenciaReu);      
     //  System.out.println(reu.getId() + " " + reu.getCpf() + " " + reu.getNome() + " " + reu.getAgencia());              
      listaReu.add(reu);
      
  }
        //Busca PSO
 //       System.out.println(listaReu.size());
        SISBB p = new SISBB("j");      
        
        //ABRE EMULADOR
        p.open();
        p.connect();
        p.waitFor("SISTEMA DE INFORMACOES BANCO DO BRASIL");
        p.enter();
        p.getVar().WaitForInput();

        // LOGIN
        p.waitFor("Código de Usuário:");
        p.set(txtChave, 13, 21);
        p.set(txtSenha, 14, 21);
        p.opcaoLogin(3);    //OPÇÃO PARA ENTRAR DIRETO NO CIC

        //ESCOLHER APLICATIVO
        p.waitFor("Navegador de Aplicativos");
        p.set("mestre", 15, 14);
        p.set(txtSenha, 16, 14);
        p.enter();
        p.getVar().WaitForInput();
        
     //   p.waitFor("F5");
        while (!p.get(1, 3, 8).equals("MSTM0200")) {                
              p.set("99", 21, 20);
              p.enter();
            }
        
              
       // p.getVar().WaitForInput();
        
        for (Reu reu : listaReu) {
            p.waitFor("MSTM0200");
            
            p.set("01", 18, 20);
            p.set(reu.getAgencia(), 19, 20);
            p.enter();
            p.getVar().WaitForInput();
            p.set("01", 19, 25);
            p.enter();
            p.getVar().WaitForInput();
            p.f8();
            p.getVar().WaitForInput();
            p.f8();
            p.getVar().WaitForInput();
            String seret=p.get(19, 22,4);
            String pso=p.get(20, 22,4);
                    
             if ("".equals(pso)) {
                pso= reu.getAgencia();           
             }
            reu.setPso(pso);           
            while (!p.get(1, 3, 8).equals("MSTM0200")) {                
               p.f3(); 
               p.getVar().WaitForInput();
            } 
        }
        p.close();
        return listaReu;
    }
    
    public ArrayList GeraListaAutor(ArrayList<String> ListaCorreio) {
        ArrayList<Autor> listaAutor = new ArrayList<>();
        //    Recebe a Lista de strings de correios recorta os dados, carrega lista objetos reu
        //8035782009991;        
  //      System.out.println(ListaCorreio.size());

        for (String correio : ListaCorreio) {
          // System.out.println(correio);      
     //DADOS AUTOR
       //ID AUTOR
       String A[] = correio.split("ID da Transferência  :");
       String idAutor = (A[1]);             
     //System.out.println(idReu);       
       String B[] = idAutor.split("Autor:");
       idAutor = (B[0]).trim();  
       System.out.println(idAutor); 
       
      //Nº BANCO DO AUTOR 
       String C[] = correio.split("-  Nº Banco:");
       String nBancoAutor = (C[1]);  
   //  System.out.println(cpfReu);       
       String D[] =nBancoAutor.split("-  Banco   :");
       nBancoAutor = (D[0]).trim();  
     //  System.out.println(nBancoAutor);      
        
       //BANCO AUTOR
       String E[] = correio.split("Banco   :");
       String bancoAutor = (E[1]);             
     //  System.out.println(nomeReu);       
       String F[] = bancoAutor.split("-  Agência");
       bancoAutor = (F[0]).trim();   
    //   System.out.println(bancoAutor); 
       
       
       
       //AGÊNCIA AUTOR 
      String G[] = correio.split("-  Agência");
       String agenciaAutor = (G[1]);             
     //  System.out.println(nomeReu);       
       String H[] = agenciaAutor.split("-  Nome    :");
       agenciaAutor = (H[0]).trim();   
   //    System.out.println(agenciaAutor); 
       
        //NOME AUTOR 
       String I[] = correio.split("Nome    :");
       String nomeAutor = (I[1]);             
     //  System.out.println(nomeReu);       
       String J[] = nomeAutor.split("-  Valor   :");
       nomeAutor = (J[0]).trim();   
 //      System.out.println(nomeAutor); 
       
       Autor autor=new Autor(nBancoAutor, bancoAutor, agenciaAutor, nomeAutor, idAutor);       
      
      autor.setAgencia(agenciaAutor);
      autor.setBanco(bancoAutor);
      autor.setId(idAutor);
      autor.setNome(nomeAutor);
      autor.setnBanco(nBancoAutor);
       
     //  System.out.println(reu.getId() + " " + reu.getCpf() + " " + reu.getNome() + " " + reu.getAgencia());              
      listaAutor.add(autor);
  }
        return listaAutor;

    }
    
    public ArrayList GeraListaProcesso(ArrayList<String> ListaCorreio) {
        ArrayList<Processo> listaProcesso = new ArrayList<>();

        
        
        
        
        for (String correio : ListaCorreio) {
            correio=correio.toUpperCase().replaceAll("@@-", "").replaceAll("ê", "");
            //DADOS PROCESSO
        //ID PROCESSO
        String A[] = correio.split("NCIA  :");
        String idProcesso = (A[1]);
        //System.out.println(idReu);       
        String B[] = idProcesso.split("AUTOR:");
        idProcesso = (B[0]).trim();
     //   System.out.println(idProcesso);

        //Nº CORREIO DO PROCESSO 
        String c[] = correio.split(":");
        String numeroCorreio = (c[1]).substring(0, 13);
   //     System.out.println(numeroCorreio);

        //Nº PROTOCOLO DO PROCESSO 
        String C[] = correio.split("TAÇÃO:");
        String protocolo = (C[1]);
        String D[] = protocolo.split("NUMERO");
        protocolo = (D[0]).trim();
     //   System.out.println(protocolo);

        //Nº DO PROCESSO
        String E[] = correio.split("PROCESSO   :");
        String nProcesso = (E[1].substring(0, 21).trim());
        String e[] = nProcesso.split("\n");
        nProcesso = (e[0]).trim();
        
        
        
   //     System.out.println(nProcesso);

        //VALOR DO PROCESSO 
        String G[] = correio.split("VALOR   :");
        String valorProcesso = (G[1]);
        String H[] = valorProcesso.split("\n");
        valorProcesso = (H[0]).trim();
        String h[]=valorProcesso.split(" ");
        valorProcesso = (h[1]).trim();
        
        System.out.println(valorProcesso);

        //GGV DO PROCESSO
//        System.out.println(correio.contains("@@GSV"));
    //--    String I[] = correio.split("@@GSV");
//            try {
//                
//               System.out.println(I[1]);
//               System.out.println(I[1].length());
//            } catch (Exception e) {
//                System.out.println(e); 
//            }
//        System.out.println(I[1]);
        
  // --     String gsvProcesso = (I[1].substring(0, 10).trim());
        
        
      //  System.out.println(GSV);

       //Data DO PROCESSO
        
        String d[] = correio.split("&&");
        String datadoProcesso = (d[1].substring(0, 21).trim());
        String f[] = datadoProcesso.split("\n");
        datadoProcesso = (f[0]).trim();
        
        System.out.println(datadoProcesso.length());
        
        System.out.println(datadoProcesso);
        
            if (datadoProcesso.length()<10) {
                datadoProcesso=datadoProcesso.substring(0, 6)+"20"+datadoProcesso.substring(6, 8);                
            }
        
      
        System.out.println(datadoProcesso);
        
        
        
        
        
        
               
        /*correio = (correio.replaceAll("solicitada", "solicitado").replaceAll("de", "do"));
        String datadoProcesso = null;

        String procurarPor = "TED-JUDICIAL";        
        String procurarPor1 = "DATA DO ENVIO  :";
        String procurarPor2 = "SOLICITADO EM";
        String procurarPor3 ="REC.JUDICIAL";

     //  int achou1 = 0;
     //   int achou2 = 0;
     //   int achou3 = 0;

        if (correio.toUpperCase().contains(procurarPor.toUpperCase())) {//ACHOU O PRIMEIRO TIPO DE DATA
              //Nº CORREIO DO PROCESSO 
              String J[] = correio.split("TED-JUDICIAL");
              System.out.println(correio.length());
              System.out.println(J[1]);
              datadoProcesso = (J[1]).substring(0, 11);      
              
        } else if (correio.toUpperCase().contains(procurarPor1.toUpperCase())) {//ACHOU O SEGUNDO TIPO DE DATA
             //Nº CORREIO DO PROCESSO 
              String J[] = correio.split("DATA DO ENVIO  :");
              datadoProcesso = (J[1]).substring(0, 11);
        } else if (correio.toUpperCase().contains(procurarPor2.toUpperCase())) {//ACHOU O TERCEIRO TIPO DE DATA
             //Nº CORREIO DO PROCESSO 
              String J[] = correio.split("SOLICITADO EM");
              datadoProcesso = (J[1]).substring(0, 11);
        }
        else if (correio.toUpperCase().contains(procurarPor3.toUpperCase())) {//ACHOU O TERCEIRO TIPO DE DATA
             //Nº CORREIO DO PROCESSO 
              String J[] = correio.split("REC.JUDICIAL");
              datadoProcesso = (J[1]).substring(0, 11);
        }
        
        
        
        
        */
         
        
        
        //System.out.println(datadoProcesso);
        
        
        
         Processo processo = new Processo();         
         processo.setCorreio(numeroCorreio);
         processo.setProtocolo(protocolo);
         processo.setProcesso(nProcesso);
         processo.setData(datadoProcesso);
         processo.setValor(valorProcesso);
         processo.setId(idProcesso);
     //    processo.setGsv(gsvProcesso);
         
         listaProcesso.add(processo);          
        }    
        return listaProcesso;        
    }

    @SuppressWarnings("empty-statement")
    
    public ArrayList GeraListaJuiz(String txtChave, String txtSenha,ArrayList<String> ListaCorreio) {
        ArrayList<Juiz> listaJuiz = new ArrayList<>();
        
        for (String correio : ListaCorreio) {
         //DADOS JUIZ
         //ID JUIZ 
         String A[] = correio.split("ID da Transferência  :");
         String idJuiz = (A[1]);      
         String B[] = idJuiz.split("Autor:");
         idJuiz = (B[0]).trim();  
       //  System.out.println(idJuiz);
         
          //PROTOCOLO JUIZ 
         String C[] = correio.split("Numero da Solicitação:");
         String protocoloJuiz = (C[1]);          
         String D[] = protocoloJuiz.split("Numero do Processo   :");
         protocoloJuiz = (D[0]).trim();  
     //    System.out.println(protocoloJuiz);
         
          //NOME JUIZ 
         String E[] = correio.split("Juiz    :");
         String nomeJuiz = (E[1]);          
         String F[] = nomeJuiz.split("\n");
         nomeJuiz = (F[0]).trim();  
     //    System.out.println(nomeJuiz);
         
         //VARA JUIZ 
         String G[] = correio.split("Vara    :");
         String varaJuiz = (G[1]);          
         String H[] = varaJuiz.split("\n");
         varaJuiz = (H[0]).trim();  
  //       System.out.println(varaJuiz);
         
         //TRIBUNAL JUIZ 
         String I[] = correio.split("Tribunal:");
         String tribunalJuiz = (I[1]);          
         String K[] = tribunalJuiz.split("\n");
         tribunalJuiz = (K[0]).trim();  
   //      System.out.println(tribunalJuiz);
         
         //COMARCA JUIZ 
         String L[] = correio.split("-  Comarca :");
         String comarcaJuiz = (L[1]).substring(0, 30);
         String m[] = comarcaJuiz.split("\n");
         comarcaJuiz = (m[0]).trim(); 
 //        System.out.println(comarcaJuiz);
         
         Juiz juiz = new Juiz();
         
         juiz.setId(idJuiz);
         juiz.setProtocolo(protocoloJuiz);
         juiz.setNome(nomeJuiz);
         juiz.setVara(varaJuiz);
         juiz.setTribunal(tribunalJuiz);
         juiz.setComarca(comarcaJuiz);
         
         listaJuiz.add(juiz);     
        }
        
        //System.out.println(listaJuiz.size());
        //busca código bacen no sisbb e carrega no ojeto 
        
        SISBB p = new SISBB("k");
        LocalDate hoje=new LocalDate();
        LocalDate umMesAtras = hoje.minusMonths(6);
        
        //ABRE EMULADOR
        p.open();
        p.connect();
        p.waitFor("SISTEMA DE INFORMACOES BANCO DO BRASIL");
        p.enter();
        p.getVar().WaitForInput();

        // LOGIN
        p.waitFor("Código de Usuário:");
        p.set(txtChave, 13, 21);
        p.set(txtSenha, 14, 21);
        p.opcaoLogin(3);    //OPÇÃO PARA ENTRAR DIRETO NO CIC

        //ESCOLHER APLICATIVO
        p.waitFor("Navegador de Aplicativos");
        p.set("Eoj", 15, 14);
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
         
        p.waitFor("EOJM0000");
        p.set("10", 21, 10);
        p.enter();
        p.getVar().WaitForInput();   
       
        for (Juiz juiz : listaJuiz) {            
        p.waitFor("EOJP1000");
        p.set("    ", 05, 21);
        p.set("              ", 06, 21);
        p.set("              ", 07, 21);
        p.set("  ",8,21);
        p.set("  ",8,26);
        p.set("    ",8,31);
        p.set("  ",8,38);
        p.set("  ",8,43);
        p.set("    ",8,48);
        
        p.set("07", 05, 21);
        p.set(juiz.getProtocolo().replaceAll("@", ""), 07, 21);           
        p.set(umMesAtras.toString().substring(8, 10),8,21);
        p.set(umMesAtras.toString().substring(5, 7),8,26);
        p.set(umMesAtras.toString().substring(0, 4),8,31);
        p.set(hoje.toString().substring(8, 10),8,38);
        p.set(hoje.toString().substring(5, 7),8,43);
        p.set(hoje.toString().substring(0, 4),8,48);         
        
        p.enter();
        p.getVar().WaitForInput();
        p.set("d",12,3);
        p.enter();
        p.getVar().WaitForInput();
        p.f2();
        p.getVar().WaitForInput();
        
        juiz.setNumeroBacen(p.get(8, 32, 5));
           while (!p.get(1, 3, 8).equals("EOJP1000")) {                
               p.f3(); 
               p.getVar().WaitForInput();
            }
        }
        p.close();     
        //busca endereço do tribunal no sisbb e carrega no ojeto
        SISBB k = new SISBB("l");
        k.open();
        k.connect();
        k.waitFor("SISTEMA DE INFORMACOES BANCO DO BRASIL");
        k.enter();
        k.getVar().WaitForInput();

        // LOGIN
        k.waitFor("Código de Usuário:");
        k.set(txtChave, 13, 21);
        k.set(txtSenha, 14, 21);
        k.opcaoLogin(3);    //OPÇÃO PARA ENTRAR DIRETO NO CIC

        //ESCOLHER APLICATIVO
        k.waitFor("Navegador de Aplicativos");
        k.set("djo", 15, 14);
        k.set(txtSenha, 16, 14);
        k.enter();
        k.getVar().WaitForInput();
       
        if (k.get(1, 10, 1).equals("M")) {
            k.enter();
            k.getVar().WaitForInput();
        }
        
         while (!k.get(1, 3, 8).equals("DJOM0000")) {                
               k.enter(); 
               k.getVar().WaitForInput();
            }        
        
        k.waitFor("DJOM0000");
        
        k.set("41", 21, 11);
        k.enter();
        k.getVar().WaitForInput();
        
        k.set("19", 21, 11);
        k.enter();
        k.getVar().WaitForInput();
        
        k.set("32", 21, 11);
        k.enter();
        k.getVar().WaitForInput();
        
        for (Juiz juiz : listaJuiz) { 
            
        k.waitFor("DJOM0467");
       
        k.set("  ", 20, 15);
        k.set("         " , 21, 15);
        
        k.set("11", 20, 15);
        k.set(juiz.getNumeroBacen(), 21, 15);
        k.enter();
        k.getVar().WaitForInput();
        
        String rua=k.get(7, 26, 50);
        String cep=k.get(9, 71, 10);
        String bairro=k.get(8, 48, 20);
        String cidade=k.get(9,26, 40);
        String uf=k.get(9, 67, 2);
        
        juiz.setRua(rua);
        juiz.setCep(cep);
        juiz.setBairro(bairro);
        juiz.setCidade(cidade);
        juiz.setUf(uf);  
        
         while (!k.get(1, 3, 8).equals("DJOM0467")) {                
               k.f3(); 
               k.getVar().WaitForInput();
            }        
        }
        k.close();       
        return listaJuiz;
    }
    
    public ArrayList verificaProcessados(String txtChave,String txtSenha ,Boolean corrigirDatas,ArrayList<pesquisaProcessados> ListaCorreio) throws FileNotFoundException {
        ArrayList<Comprovante> listaCorreioProcessados = new ArrayList<>();
        ArrayList<String> listaCorreioNaoProcessados = new ArrayList<>();
        
        
                //Criacao da pasta
               LocalDate hojePasta = new LocalDate();
      //  String s = "dezembro";

        String mesS = null;
        int mess;
        int ano;
        int dia;
       // String data = "07/10/2014";
        dia = hojePasta.getDayOfMonth();
        mess = hojePasta.getMonthOfYear();
        ano = hojePasta.getYear(); 
        
            System.out.println(dia);
            System.out.println(mess);
            System.out.println(ano);  

        switch (mess) {
            case 1:
                mesS = "Janeiro";
                break;
            case 2:
                mesS = "Fevereiro";
                break;
            case 3:
                mesS = "Março";
                break;
            case 4:
                mesS = "Abril";
                break;
            case 5:
                mesS = "Maio";
                break;
            case 6:
                mesS = "Junho";
                break;
            case 7:
                mesS = "Julho";
                break;
            case 8:
                mesS = "Agosto";
                break;
            case 9:
                mesS = "Setembro";
                break;
            case 10:
                mesS = "Outubro";
                break;
            case 11:
                mesS = "Novembro";
                break;
            case 12:
                mesS = "Dezembro";
                break;
        }

        
        
        
        /*File dir = new File("c:/temp/OFICIO/BACENJUD/");
        File dirAno = new File("c:/temp/OFICIO/BACENJUD/"+ano);
        File dirMes = new File("c:/temp/OFICIO/BACENJUD/"+ano+"/"+mesS);
        File dirDia = new File("c:/temp/OFICIO/BACENJUD/"+ano+"/"+mesS+"/"+dia);    */
       
   //     "\\\\Srispo02525\\cso1981servjudfunci$\\Publica\\CENTRAL DE OFICIOS\\BACENJUD SOLICITACAO"
        
        
  /*      File dir = new File( "\\\\Srispo02525\\cso1981servjudfunci$\\Publica\\CENTRAL DE OFICIOS\\BACENJUD SOLICITACAO");
        File dirAno = new File("\\\\Srispo02525\\cso1981servjudfunci$\\Publica\\CENTRAL DE OFICIOS\\BACENJUD SOLICITACAO"+ano);
        File dirMes = new File("\\\\Srispo02525\\cso1981servjudfunci$\\Publica\\CENTRAL DE OFICIOS\\BACENJUD SOLICITACAO"+ano+"/"+mesS);
        File dirDia = new File("c:/temp/OFICIO/BACENJUD/"+ano+"/"+mesS+"/"+dia);    */
        
        File dirrede = new File("G:\\Publica\\CENTRAL DE OFICIOS\\BACENJUD SOLICITACAO\\");
        File dirAnorede = new File("G:\\Publica\\CENTRAL DE OFICIOS\\BACENJUD SOLICITACAO\\"+ano);
        File dirMesrede = new File("G:\\Publica\\CENTRAL DE OFICIOS\\BACENJUD SOLICITACAO\\"+ano+"\\"+mesS);
        File dirDiarede = new File("G:\\Publica\\CENTRAL DE OFICIOS\\BACENJUD SOLICITACAO\\"+ano+"\\"+mesS+"\\"+dia); 
        
        	 try {
   //         dir.mkdir();
            dirrede.mkdir();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
     //       dirAno.mkdir();
            dirAnorede.mkdir();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
   //         dirMes.mkdir();
            dirMesrede.mkdir();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try {
     //       dirDia.mkdir();
            dirDiarede.mkdir();
        } catch (Exception e) {
            System.out.println(e);
        }
                       
      
 /*       FileOutputStream arquivo;
        arquivo = new FileOutputStream("c:/temp/OFICIO/BACENJUD/"+ano+"/"+mesS+"/"+dia+"/ForaPadrão_NaoProcessado_"+now().toLocalTime().toString().replaceAll("/", "").replaceAll("-", "").replaceAll(":", "").substring(0, 6)+".txt");
        PrintStream printStream = new PrintStream(arquivo);   */
          //Rede
        FileOutputStream arquivorede;
        arquivorede = new FileOutputStream("G:\\Publica\\CENTRAL DE OFICIOS\\BACENJUD SOLICITACAO\\"+ano+"\\"+mesS+"\\"+dia+"/ForaPadrão_NaoProcessado_"+now().toLocalTime().toString().replaceAll("/", "").replaceAll("-", "").replaceAll(":", "").substring(0, 6)+".txt");
        PrintStream printStreamRede = new PrintStream(arquivorede); 
        

         
             
        SISBB p = new SISBB("m");
        //ABRE EMULADOR
        p.open();
        p.connect();
        p.waitFor("SISTEMA DE INFORMACOES BANCO DO BRASIL");
        p.enter();
        p.getVar().WaitForInput();

        // LOGIN
        p.waitFor("Código de Usuário:");
        p.set(txtChave, 13, 21);
        p.set(txtSenha, 14, 21);
        p.opcaoLogin(3);    //OPÇÃO PARA ENTRAR DIRETO NO CIC

        //ESCOLHER APLICATIVO
        p.waitFor("Navegador de Aplicativos");
        p.set("compe", 15, 14);
        p.set(txtSenha, 16, 14);
        p.enter();
        p.getVar().WaitForInput();
        p.waitFor("CELM800A");
        
        p.set("14", 21, 35);
        p.enter();
        p.getVar().WaitForInput();
        
       while (!"TFIM0000".equals(p.get(1,3,8))) {              
              p.f3();
              p.getVar().WaitForInput();  
      }        
       //p.getVar().WaitForInput();
       //p.set("14", 21, 35);
       //p.enter();
       //p.getVar().WaitForInput();
        p.set("19", 21, 20);
        p.enter();
        p.getVar().WaitForInput();        
              
        
      for (pesquisaProcessados correio : ListaCorreio) {
          p.waitFor("TFIM1900");
   //       System.out.println(correio.getCorreio());          
   //      System.out.println(correio.getValor());
   //       System.out.println(correio.getBanco());
   //       System.out.println(correio.getPso());          
          System.out.println(correio.getData());        
  //        System.out.println(correio.getId()); 
          p.set("10", 15, 23);
          p.set("a", 15, 39);
          
          System.out.println(correio.getData()+"///"+correio.getCorreio());
          
          
          
          
           //limpar campo agencia
          p.set("    ", 16, 23);
          p.set(correio.getPso(), 16, 23);          
          p.set(correio.getData().replaceAll("/", "").replaceAll("-", "").replaceAll(" ", ""), 17, 23);
          p.set(correio.getData().replaceAll("/", "").replaceAll("-", "").replaceAll(" ", ""), 18, 23);
          p.set("       ", 20, 23);
          
         //limpar campo agencia
          p.set(correio.getBanco(), 21, 23);   
          
          if (corrigirDatas==true) {
              JOptionPane.showMessageDialog(null, "Favor erificar se a data está correta");              
          }
          
          
          p.enter();
          p.getVar().WaitForInput(); 
          
          Boolean achou=false;
          String documento;
          String agencia;  
          String DadosCorpo;          
          String finalidade;
          String ted;
          
          
          for (int i = 7; i < 19; i++) {            
             if ("Processado".equals(p.get(i, 6, 10))) {                   
                      p.set("x", i, 3);
                      p.enter();
                      p.getVar().WaitForInput();
                      p.set(correio.getValor(), 13, 51);
                      p.set(correio.getValor(), 14, 51);
                      p.enter();
                      p.getVar().WaitForInput();                
                     
                      
//continuar qd achar
                      if ("TFIM1918".equals(p.get(1,3,8))) { 
                          
                          for (int j = 6; j < 20; j++) {            
                                if ("STR".equals(p.get(j, 5, 3))) { 
                                    p.set("x", j, 3);
                                    p.enter();
                                    p.getVar().WaitForInput();
                                    p.f12();
                                    p.f8();
                                    p.getVar().WaitForInput(); 
      //                              System.out.println(correio.getId()); 
      //                              System.out.println((p.get(14, 41, 18)));                                    
                                    
                                    if ((p.get(14, 41, 18) == null ? correio.getId() == null : p.get(14, 41, 18).equals(correio.getId()))) {
                                       //Copiar os dados
                                         while (!"TFIM1912".equals(p.get(1,3,8))) {              
                                            p.f3();
                                            p.getVar().WaitForInput();  
                                          } 
                                          documento="" + p.get(5,17,9);
                                          agencia="" + p.get(10,18,4);
                                          finalidade="" + p.get(21,15,24);
                                          ted="" + p.get(21,72,9);
                                          DadosCorpo=documento+" Agência: "+agencia+" Finalidade: "+finalidade+ " TED: "+ted ;                                 
                                          Comprovante comprovante= new Comprovante(DadosCorpo, correio.getId());                            
                                          listaCorreioProcessados.add(comprovante);  //Insere dados na lista
                                          achou=true;
                                          j=20;
                                    }  
                                    
                                    while (!"TFIM1918".equals(p.get(1,3,8))) {              
                                            p.f3();
                                            p.getVar().WaitForInput();  
                                    }                        
                                }
                             
                                
                                
                          }                
                      }                      
            }   
             
              while (!"TFIM1910".equals(p.get(1,3,8))) {              
                                            p.f3();
                                            p.getVar().WaitForInput();  
                                    } 
             
             
                          
                   if (achou==true) {
                                         i=20; 
                                    }     
             
             
             
             
          }
          
   
          
          
          
          if (achou==false) {
                listaCorreioNaoProcessados.add("Correio: ;"+correio.getCorreio()+"; PSO: ;"+correio.getPso()+"; Valor: ;"+correio.getValor()+"; Data : ;"+ correio.getData()+";  Agência: ;" + correio.getBanco());              
          }
                  
          while (!"TFIM1900".equals(p.get(1,3,8))) {    //retorna tela para começar o próximo correio          
              p.f3();
              p.getVar().WaitForInput();  
          }      
          
      }   //for lista de correios
      p.dispose();
      
      LocalDate hoje=new LocalDate();  
      
    
      for (String txt :listaCorreioNaoProcessados ) {            
//            printStream.println(txt);  
            printStreamRede.println(txt);
     }
      
  //    System.out.println(listaCorreioProcessados.size());
      return listaCorreioProcessados;
      
    }
    

    
        public void TrocaDePasta(String txtChave, String txtSenha,ArrayList<String> ListaCorreio) throws SQLException {
         SISBB p = new SISBB("O");     
        
        //ABRE EMULADOR
        p.open();
        p.connect();
        p.waitFor("SISTEMA DE INFORMACOES BANCO DO BRASIL");
        p.enter();
        p.getVar().WaitForInput();

        // LOGIN
        p.waitFor("Código de Usuário:");
        p.set(txtChave, 13, 21);
        p.set(txtSenha, 14, 21);
        p.opcaoLogin(3);    //OPÇÃO PARA ENTRAR DIRETO NO CIC

        //ESCOLHER APLICATIVO
        p.waitFor("Navegador de Aplicativos");
        p.set("correio", 15, 14);
        p.set(txtSenha, 16, 14);
        p.enter();
        p.getVar().WaitForInput();
        
        p.waitFor("COEPC001");
        
        p.set("01", 21, 17);       
        p.enter();
        p.getVar().WaitForInput();
        
        p.waitFor("COEM0015");
        
        p.set("21", 21, 18);       
        p.enter();
        p.getVar().WaitForInput();  
            
       for (String correio : ListaCorreio) {         
            p.waitFor("COEM1200");
       
       System.out.println(correio);
       
        p.set("05", 14, 24);    
        p.set(correio.substring(0, 4), 18, 24);
        p.set(correio.substring(5, 13), 18, 31);    
        p.enter();
        p.getVar().WaitForInput();
        
        p.set("SJBACENIMP", 4, 13); 
        p.enter();
        p.getVar().WaitForInput();
        p.set("ROTINA AUTOMATIZADA CONCLÚIDA PARA IMPRESSÃO.", 9, 6); 
        p.enter();
        p.getVar().WaitForInput();
        p.waitFor("Confirma");
        p.set("s", 22, 50);       
        p.enter();
        p.getVar().WaitForInput(); 
       
        while (!p.get(1, 3, 8).equals("COEM1200")) {             
              p.f3();
              p.getVar().WaitForInput();
            }    
    }
       p.close();
        }
   
    public void teste(String txtSenha,String txtChave,ArrayList<String> ListaCorreio) throws FileNotFoundException {
        ArrayList<String> listaCorreioProcessados = new ArrayList<>();
        ArrayList<String> listaCorreioExcuidos = new ArrayList<>();
        SISBB p = new SISBB("d");
        
        FileOutputStream arquivo;
        arquivo = new FileOutputStream("c://temp/BACEN_JUD_Solicitacao_ForaPadrão_Escluido.txt");
        PrintStream printStream = new PrintStream(arquivo);   
       
        LocalDate hoje=new LocalDate();
        LocalDate umMesAtras = hoje.minusMonths(1);
        
        //ABRE EMULADOR
        p.open();
        p.connect();
        p.waitFor("SISTEMA DE INFORMACOES BANCO DO BRASIL");
        p.enter();
        p.getVar().WaitForInput();

        // LOGIN
        p.waitFor("Código de Usuário:");
        p.set(txtChave, 13, 21);
        p.set(txtSenha, 14, 21);
        p.opcaoLogin(3);    //OPÇÃO PARA ENTRAR DIRETO NO CIC

        //ESCOLHER APLICATIVO
        p.waitFor("Navegador de Aplicativos");
        p.set("Eoj", 15, 14);
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
         
        p.waitFor("EOJM0000");
        p.set("10", 21, 10);
        p.enter();
        p.getVar().WaitForInput();         
      for (String correio : ListaCorreio) {        
        
          
          
            
      /*
            
            
            
            
            
            
            
            
            
            
            
            
            
            //DADOS PROCESSO
        //ID PROCESSO
        String A[] = correio.split("ID da Transferência  :");
        String idProcesso = (A[1]);
        //System.out.println(idReu);       
        String B[] = idProcesso.split("Autor:");
        idProcesso = (B[0]).trim();
    //    System.out.println(idProcesso);

        //Nº CORREIO DO PROCESSO 
        String c[] = correio.split(":");
        String numeroCorreio = (c[1]).substring(0, 13);
    //   System.out.println(numeroCorreio);

        //Nº PROTOCOLO DO PROCESSO 
        String C[] = correio.split("Numero da Solicitação:");
        String protocolo = (C[1]);
        String D[] = protocolo.split("Numero do Processo   :");
        protocolo = (D[0]).trim();
//       System.out.println(protocolo);
//
        //Nº DO PROCESSO
        String E[] = correio.split("Numero do Processo   :");
        String nProcesso = (E[1].substring(0, 21).trim());
    //    System.out.println(nProcesso);

        //VALOR DO PROCESSO 
        String G[] = correio.split("-  Valor   :");
        String valorProcesso = (G[1]);
        String H[] = valorProcesso.split("Dados do remetente:");
        valorProcesso = (H[0]).trim();
     //   System.out.println(valorProcesso);

      //GGV DO PROCESSO
        
        String gsv = correio.replaceAll("-", "").replace(":", "");
        int tamanhoString = gsv.length();
        
        
        
     //   System.out.println (gsv.substring(tamanhoString - 30, tamanhoString).trim().replaceAll(" ", "").replaceAll(":", ""));
        gsv = gsv.substring(tamanhoString - 30, tamanhoString).trim().replaceAll(" ", "").replaceAll(":", "");
     //  System.out.println("GSV+++++ : " + gsv);
    //    System.out.println("GSV+++++ : " + gsv.length());        
        String I[] = gsv.split("GSV");        
        String GSV = (I[1]);
    //    System.out.println(GSV.trim());

       //Data DO PROCESSO
        correio = (correio.replaceAll("solicitada", "solicitado"));
        String datadoProcesso = null;

        String procurarPor = "TRANSF.INTERBANCARIA";
        String procurarPor1 = "DATA DO ENVIO  :";
        String procurarPor2 = "SOLICITADO EM";

        int achou1 = 0;
        int achou2 = 0;
        int achou3 = 0;

        if (correio.toUpperCase().contains(procurarPor.toUpperCase())) {//ACHOU O PRIMEIRO TIPO DE DATA
            //Nº CORREIO DO PROCESSO 
              String J[] = correio.split("TED-JUDICIAL");
              datadoProcesso = (J[1]).substring(0, 10);      
        } else if (correio.toUpperCase().contains(procurarPor1.toUpperCase())) {//ACHOU O SEGUNDO TIPO DE DATA
             //Nº CORREIO DO PROCESSO 
              String J[] = correio.split("DATA DO ENVIO  :");
              datadoProcesso = (J[1]).substring(0, 10);
        } else if (correio.toUpperCase().contains(procurarPor2.toUpperCase())) {//ACHOU O TERCEIRO TIPO DE DATA
             //Nº CORREIO DO PROCESSO 
              String J[] = correio.split("SOLICITADO EM");
              datadoProcesso = (J[1]).substring(0, 10);
        }
        
      //   System.out.println(datadoProcesso);
        
         /*Processo processo = new Processo();
         
         processo.setCorreio(numeroCorreio);
         processo.setProtocolo(protocolo);
         processo.setProcesso(nProcesso);
         processo.setData(datadoProcesso);
         processo.setValor(valorProcesso);
         processo.setId(idProcesso);
         processo.setGsv(GSV);*/
         
     
        
    }
    
    
    }

}
