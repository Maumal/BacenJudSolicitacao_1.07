/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processamento;

import BB_SISBB.SISBB;
import DAO.Conexao;
import bacenjud.Autor;
import bacenjud.Juiz;
import bacenjud.Processo;
import bacenjud.Reu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.joda.time.LocalDate;

/**
 *
 * @author f7057419
 */
public class teste {
    

    public static void main(String[] args) throws SQLException {
        
        String teste=" 29/09/2014";
        
        
        System.out.println(teste.trim().replaceAll("/", "").replaceAll("-", "").replaceAll(" ", "").substring(0, 2));
         System.out.println(teste.trim().replaceAll("/", "").replaceAll("-", "").replaceAll(" ", "").substring(2, 4));
             System.out.println(teste.trim().replaceAll("/", "").replaceAll("-", "").replaceAll(" ", "").substring(4, 8));
        
        
        
        
        
        
        
        
        
        String correio = "Número - Título:2014/48183615-BACEN JUD 2.0 - SOLICITACAO\n"
                + "------------------------------------------------------------------------\n"
                + "Rem.:     7418 CSL BRASILIA         DF            Em: 23/09/2014 - 08:21\n"
                + "APL. EOJ\n"
                + "Dest:     3289 SAO CRISTOVAO        PR            Em: 23/09/2014 - 08:29\n"
                + "F4078069 HELTON HISTER (45)32189600 GER RELACIONAMENTO\n"
                + "------------------------------------------------------------------------\n"
                + "Original: 3289 BANCO DO BRASIL-SAO CRISTOVAO\n"
                + "\n"
                + "De  : 4718 - CSL BRASILIA\n"
                + "Para: 3289 - SAO CRISTOVAO\n"
                + "\n"
                + "*Mensagem gerada automaticamente pelo aplicativo EOJ, não passível de\n"
                + "retorno e nem envio de cópia para o prefixo 7418 CSL Brasília (DF).\n"
                + "Duvidas e informaçoes adicionais devem ser sanadas e obtidas junto à\n"
                + "Super jurisdicionante (IN 136).*\n"
                + "\n"
                + "--------------------------------------------------------------------------\n"
                + "\n"
                + "\n"
                + "BACEN JUD 2.0 - SOLICITACAO\n"
                + "\n"
                + "Sr. Gerente,\n"
                + "\n"
                + "DEMANDA JUDICIAL-SOLICITAÇÃO DE TRANSFERÊNCIA PARA OUTRA INSTITUIÇÃO FI-\n"
                + "NANCEIRA-Conforme Lei Complementar nº 105, de 10.01.01 e IN 136-Bloqueio\n"
                + ", Desbloqueio e Transferência de Valores por Ordem Judicial, informamos\n"
                + "abaixo a Solicitação Judicial, repassada pelo BACEN em 22.09.2014.\n"
                + "\n"
                + "Caberá a essa Dependência, efetuar manualmente nesta data, TED da\n"
                + "importância abaixo, levando a débito da conta 31550-0500-0, a saber:\n"
                + "Numero da Solicitação: 20140002786547\n"
                + "Numero do Processo   : 00087343220104058400\n"
                + "\n"
                + "\n"
                + "--------------------------------------------------------------------------\n"
                + "ID da Transferência  : 072014000010018748\n"
                + "\n"
                + "Autor:\n"
                + "-  Nº Banco: 104\n"
                + "-  Banco   : CEF\n"
                + "-  Agência : 0649\n"
                + "-  Nome    : MINISTERIO PUBLICO FEDERAL\n"
                + "-  Valor   :R$ 30.105,87\n"
                + "Dados do remetente:\n"
                + "-  CPF            : 4126486950\n"
                + "-  Nome           : JOACIR ALVES JUNIOR\n"
                + "-  Codigo MCI     : 915034652\n"
                + "-  Prefixo agência: 3289\n"
                + "0000030103  0510030103\n"
                + "Dados do solicitante:\n"
                + "-  Juiz    : MARIO AZEVEDO JAMBO\n"
                + "\n"
                + "--------------------------------------------------------------------------\n"
                + "-  Vara    : 2e Vara Federal / RN\n"
                + "-  Tribunal: TRIB REG FEDERAL 5A. REGIAO\n"
                + "-  Comarca : Natal\n"
                + "\n"
                + "Salientamos que se trata de uma ordem judicial, a transferência deve ser\n"
                + "efetuada imediatamente. O ID da transferência consta no corpo da mensa-\n"
                + "gem.\n"
                + "\n"
                + "A responsabilidade pelo acompanhamento e conferencia do cumprimento da\n"
                + "ordem judicial é da dependência detentora do MCI do cliente (réu), que\n"
                + "deverá, após a confirmação do envio da TED Judicial, encaminhar\n"
                + "correspondência  via AR, ou protocolar diretamente na Vara de Justiça\n"
                + "responsável pelo processo, se estiver na mesma localidade, comunicando\n"
                + "do cumprimento da ordem Judicial e os dados utilizados no envio da TED\n"
                + "Judicial, especialmente a data e o ID utilizado.\n"
                + "\n"
                + "\n"
                + "--------------------------------------------------------------------------\n"
                + "\n"
                + "Para consultar o endereço da Vara de Justiça diretamente no DJO, a de-\n"
                + "pendência deve acessar o aplicativo EOJ-10, tipo de ordem 7, informando\n"
                + "o numero do protocolo, e ao detalhar a execução (D), e consultar a Vara\n"
                + "de Justiça (F2). Gravar as informaçoes contidas no campo 'Código BACEN'.\n"
                + "Acessar o sistema DJO, Opção 41-19-32-11, informando o Código Bacen.\n"
                + "\n"
                + "\n"
                + "------------------------------------------------------------------------\n"
                + "Rem.:     3289 SAO CRISTOVAO        PR            Em: 23/09/2014 - 08:30\n"
                + "* F4078069 HELTON HISTER (45)32189600 GER RELACIONAMENTO\n"
                + "Dest:     8342 PSO CASCAVEL         PR            Em: 23/09/2014 - 08:52\n"
                + "F6324571 LUCIANA DE FATIMA SERAFINI (45)32201825 GER SEGMENTO\n"
                + "------------------------------------------------------------------------\n"
                + "Original: 8342 BANCO DO BRASIL-PSO CASCAVEL\n"
                + "\n"
                + "\n"
                + "--------------------------------------------------------------------------\n"
                + "Para: SOP São Cristóvão\n"
                + "a/c Leonardo\n"
                + "\n"
                + "Para suas providências.\n"
                + "\n"
                + "Helton Hister\n"
                + "Ger.Relacion.UN\n"
                + "\n"
                + "------------------------------------------------------------------------\n"
                + "Rem.:     8342 PSO CASCAVEL         PR            Em: 24/09/2014 - 10:50\n"
                + "* F6210349 LEONARDO MATTE (45)32189600 GER MODULO\n"
                + "Dest:     1981 CENOP SERV SAO PAULO SP            Em: 24/09/2014 - 10:54\n"
                + "F5116452 JONATHAN JORDAO DOS REIS (11)34914066 ESCRITURARIO\n"
                + "------------------------------------------------------------------------\n"
                + "Original: 1981 BANCO DO BRASIL-CENOP SERV SAO PAULO\n"
                + "\n"
                + "\n"
                + "--------------------------------------------------------------------------\n"
                + "A/C : RESPOSTA A OFÍCIO\n"
                + "\n"
                + "Pedimos responder ao juízo, conforme TED abaixo:\n"
                + "\n"
                + "------------------------------------------------\n"
                + "TR.329 - TRANSF.INTERBANCARIA-TED-JUDICIAL\n"
                + "23/09/2014 10.55.23 8342-12246   6015117    0004\n"
                + "DOC:054186 104 00360305 AGE0649 CTA0000000000000\n"
                + "REMETENTE:    JOACIR ALVES JUNIOR\n"
                + "CPF                               041.264.869-50\n"
                + "DESTINATARIO:\n"
                + "CPF                               000.000.000-00\n"
                + "VALOR DOC............:                 30.105,87\n"
                + "VALOR TARIFA.........:                      0,00\n"
                + "VALOR TOTAL..........:                 30.105,87\n"
                + "ID...................:        072014000010018748\n"
                + "\n"
                + "--------------------------------------------------------------------------\n"
                + "\n"
                + "De Pasta...: <ENTRADA>\n"
                + "Para Pasta : $CAIXA  Em 24/09/2014-10:54\n"
                + "Por........: F5116452  - JONATHAN JORDAO DOS REIS SILVA\n"
                + "\n"
                + "De Pasta...: $CAIXA\n"
                + "Para Pasta : SJUDICIAL  Em 24/09/2014-10:54\n"
                + "Por........: F5116452  - JONATHAN JORDAO DOS REIS SILVA\n"
                + "\n"
                + "########################################################################\n"
                + "#                MENSAGEM REDIRECIONADA AUTOMATICAMENTE                #\n"
                + "#  CASO O REDIRECIONAMENTO TENHA SIDO INDEVIDO, DEVOLVER PARA $APOIO   #\n"
                + "########################################################################\n"
                + "\n"
                + "Redirecionamento: Palavra Chave Título :  JUD\n"
                + "\n"
                + "\n"
                + "--------------------------------------------------------------------------\n"
                + "De Pasta...: SJUDICIAL\n"
                + "Para Pasta : SJBAxxxxx  Em 24/09/2014-11:02\n"
                + "Por........: F2191681  - CRISTINE HELENA SVITEK\n"
                + "\n"
                + "Abrir GSV e direcionar para equipe SJ Oficio 4.\n"
                + "\n"
                + "De Pasta...: SJBAxxxxx\n"
                + "Para Pasta : SJOFICIO4  Em 24/09/2014-11:22\n"
                + "Por........: T1067968  - DENISE MAIA DE SOUSA\n"
                + "\n"
                + "GSV 15094974";
      
        /*
        //DADOS JUIZ
         //ID JUIZ 
         String A[] = correio.split("ID da Transferência  :");
         String idJuiz = (A[1]);      
         String B[] = idJuiz.split("Autor:");
         idJuiz = (B[0]).trim();  
         System.out.println(idJuiz);
         
          //PROTOCOLO JUIZ 
         String C[] = correio.split("Numero da Solicitação:");
         String protocoloJuiz = (C[1]);          
         String D[] = protocoloJuiz.split("Numero do Processo   :");
         protocoloJuiz = (D[0]).trim();  
         System.out.println(protocoloJuiz);
         
          //NOME JUIZ 
         String E[] = correio.split("Juiz    :");
         String nomeJuiz = (E[1]);          
         String F[] = nomeJuiz.split("-  Vara    :");
         nomeJuiz = (F[0]).trim();  
         System.out.println(nomeJuiz);
         
         //VARA JUIZ 
         String G[] = correio.split("Vara    :");
         String varaJuiz = (G[1]);          
         String H[] = varaJuiz.split("-  Tribunal:");
         varaJuiz = (H[0]).trim();  
         System.out.println(varaJuiz);
         
         //TRIBUNAL JUIZ 
         String I[] = correio.split("Tribunal:");
         String tribunalJuiz = (I[1]);          
         String K[] = tribunalJuiz.split("-  Comarca :");
         tribunalJuiz = (K[0]).trim();  
         System.out.println(tribunalJuiz);
         
         //COMARCA JUIZ 
         String L[] = correio.split("-  Comarca :");
         String comarcaJuiz = (L[1]).substring(0, 30);
         System.out.println(comarcaJuiz);
         
      
         
         
         
         SISBB p = new SISBB("c");
         SISBB k = new SISBB("d");
         
         LocalDate hoje=new LocalDate();
         LocalDate umMesAtras = hoje.minusMonths(1);
         
     
         
         
          // ABRE EMULADOR
        p.open();
        p.connect();
        p.waitFor("SISTEMA DE INFORMACOES BANCO DO BRASIL");
        p.enter();
        p.getVar().WaitForInput();

        // LOGIN
        p.waitFor("Código de Usuário:");
        p.set("f7057419", 13, 21);
        p.set("65414038", 14, 21);
        p.opcaoLogin(3);    //OPÇÃO PARA ENTRAR DIRETO NO CIC

        //ESCOLHER APLICATIVO
        p.waitFor("Navegador de Aplicativos");
        p.set("Eoj", 15, 14);
        p.set("65414038", 16, 14);
        p.enter();
        p.getVar().WaitForInput();
        p.waitFor("F5");

        // VERIFICA TELA DE AVISO
        /*  while (!p.get(1, 10, 1).equals("0")) {
         p.f3(); 
         //  p.getVar().WaitForInput();
         }
        if (p.get(6, 21, 7).equals("Existem")) {
            p.f3();
            //    p.getVar().WaitForInput();
        }
         
        p.waitFor("EOJM0000");
        p.set("10", 21, 10);
        p.enter();
        p.getVar().WaitForInput();

        p.waitFor("EOJP1000");
        p.set("07", 05, 21);
        p.set(protocoloJuiz, 07, 21);
        
        //System.out.println(umMesAtras.toString().substring(8, 10));
        //System.out.println(umMesAtras.toString().substring(5, 7));
        //System.out.println(umMesAtras.toString().substring(0, 4));        
        
        //System.out.println(hoje.toString().substring(8, 10));
        //System.out.println(hoje.toString().substring(5, 7));
        //System.out.println(hoje.toString().substring(0, 4));    
        
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
        
        String BacenJuiz=p.get(8, 32, 5);
        System.out.println(BacenJuiz);
        
        p.close();
            
        k.open();
        k.connect();
        k.waitFor("SISTEMA DE INFORMACOES BANCO DO BRASIL");
        k.enter();
        k.getVar().WaitForInput();

        // LOGIN
        k.waitFor("Código de Usuário:");
        k.set("f7057419", 13, 21);
        k.set("65414038", 14, 21);
        k.opcaoLogin(3);    //OPÇÃO PARA ENTRAR DIRETO NO CIC

        //ESCOLHER APLICATIVO
        k.waitFor("Navegador de Aplicativos");
        k.set("djo", 15, 14);
        k.set("65414038", 16, 14);
        k.enter();
        k.getVar().WaitForInput();
        if (k.get(1, 10, 1).equals("M")) {
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
        
        k.set("11", 20, 15);
        k.set(BacenJuiz, 21, 15);
        k.enter();
        k.getVar().WaitForInput();
        
        String rua=k.get(7, 26, 50);
        String cep=k.get(9, 71, 10);
        String bairro=k.get(8, 48, 20);
        String cidade=k.get(9,26, 40);
        String uf=k.get(9, 67, 2);
        
        System.out.println(rua);
        System.out.println(cep);
        System.out.println(bairro);
        System.out.println(cidade);
        System.out.println(uf);
     
        
        
        
        
        
        
        
        
        
        

      
        */
        
        
  
         
         
         
         
         
        
         
         

       
       
         //fim busca reu
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
       
         //fim busca reu
        
        /*
        
        
        //-----------------------         
        //DADOS PROCESSO
        //ID PROCESSO
        String A[] = correio.split("ID da Transferência  :");
        String idProcesso = (A[1]);
        //System.out.println(idReu);       
        String B[] = idProcesso.split("Autor:");
        idProcesso = (B[0]).trim();
        System.out.println(idProcesso);

        //Nº CORREIO DO PROCESSO 
        String c[] = correio.split(":");
        String numeroCorreio = (c[1]).substring(0, 13);
   //     System.out.println(numeroCorreio);

        //Nº PROTOCOLO DO PROCESSO 
        String C[] = correio.split("Numero da Solicitação:");
        String protocolo = (C[1]);
        String D[] = protocolo.split("Numero do Processo   :");
        protocolo = (D[0]).trim();
     //   System.out.println(protocolo);

        //Nº DO PROCESSO
        String E[] = correio.split("Numero do Processo   :");
        String nProcesso = (E[1].substring(0, 21).trim());
   //     System.out.println(nProcesso);

        //VALOR DO PROCESSO 
        String G[] = correio.split("-  Valor   :");
        String valorProcesso = (G[1]);
        String H[] = valorProcesso.split("Dados do remetente:");
        valorProcesso = (H[0]).trim();
    //    System.out.println(valorProcesso);

      //GGV DO PROCESSO
        
        String gsv = correio.replaceAll("-", "").replace(":", "");
        int tamanhoString = gsv.length();
        
        gsv = gsv.substring(tamanhoString - 30, tamanhoString).trim().replaceAll(" ", "").replaceAll(":", "");
        System.out.println("GSV+++++ : " + gsv);
        System.out.println("GSV+++++ : " + gsv.length());        
        String I[] = gsv.split("GSV");        
        String GSV = (I[1]);
      //  System.out.println(GSV);

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
        
     //    System.out.println(datadoProcesso);
        
         Processo processo = new Processo();
         
         processo.setCorreio(numeroCorreio);
         processo.setProtocolo(protocolo);
         processo.setProcesso(nProcesso);
         processo.setData(datadoProcesso);
         processo.setValor(valorProcesso);
         processo.setId(idProcesso);
         processo.setGsv(GSV);
         
      /*    System.out.println("Correio :" +processo.getCorreio() +"  " +
                  "Protocolo :" + processo.getProtocolo() +
                  " " +"Processo" +  processo.getProcesso() + " " +"Data : "  +processo.getData() + 
                  " " +"Valor :"  +processo.getValor() + "  "+"Id :" +processo.getId() + "  " +"GSV :" +  processo.getGsv() );
         
        System.out.println(processo.getCorreio() +"  " + processo.getProtocolo() + " " + processo.getProcesso() + " " + processo.getData() + " " + processo.getValor() + "  "+processo.getId() + "  " + processo.getGsv() );
         
        */
        
        
       /*
        
        
     
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
         System.out.println(nBancoAutor);      
        
         //BANCO AUTOR
         String E[] = correio.split("Banco   :");
         String bancoAutor = (E[1]);             
         //  System.out.println(nomeReu);       
         String F[] = bancoAutor.split("-  Agência");
         bancoAutor = (F[0]).trim();   
         System.out.println(bancoAutor);       
       
       
         //AGÊNCIA AUTOR 
         String G[] = correio.split("-  Agência");
         String agenciaAutor = (G[1]);             
         //  System.out.println(nomeReu);       
         String H[] = agenciaAutor.split("-  Nome    :");
         agenciaAutor = (H[0]).trim();   
         System.out.println(agenciaAutor); 
       
         //NOME AUTOR 
         String I[] = correio.split("Nome    :");
         String nomeAutor = (I[1]);             
         //  System.out.println(nomeReu);       
         String J[] = nomeAutor.split("-  Valor   :");
         nomeAutor = (J[0]).trim();   
         System.out.println(nomeAutor); 
       
         Autor autor=new Autor(nBancoAutor, bancoAutor, agenciaAutor, nomeAutor, idAutor);       
      
         autor.setAgencia(agenciaAutor);
         autor.setBanco(bancoAutor);
         autor.setId(idAutor);
         autor.setNome(nomeAutor);
         autor.setnBanco(nBancoAutor);
      
      
      

       
         System.out.println(autor.getAgencia() +"  " +autor.getBanco()+" " + autor.getId() + " " + autor.getNome() + "  " + autor.getnBanco() );    
       
       */
         //fim busca autor
         //----------------------- 
        
      
         /*  
         int tamanhoString=correio.length();
            
         String gsv=correio.substring(tamanhoString -15, tamanhoString);
       
       
         System.out.println(gsv);
        
        
       
       
         //DADOS JUIZ
         //ID JUIZ
         String A[] = correio.split("ID da Transferência  :");
         String idJuiz = (A[1]);     
         String B[] = idJuiz.split("Autor:");
         idJuiz = (B[0]).trim();  
         System.out.println(idJuiz); 
              
         //NOME DO JUIZ 
         String C[] = correio.split("-  Nº Banco:");
         String nomeJuiz = (C[1]);       
         String D[] =nomeJuiz.split("-  Banco   :");
         nomeJuiz = (D[0]).trim();  
         System.out.println(nomeJuiz);      
        
         //VARA DO JUIZ 
         String E[] = correio.split("Banco   :");
         String varaJuiz = (E[1]);       
         String F[] = varaJuiz.split("-  Agência");
         varaJuiz = (F[0]).trim();   
         System.out.println(varaJuiz);       
           
         //TRIBUNAL DO JUIZ  
         String G[] = correio.split("-  Agência");
         String tribunalJuiz = (G[1]);       
         String H[] = tribunalJuiz.split("-  Nome    :");
         tribunalJuiz = (H[0]).trim();   
         System.out.println(tribunalJuiz); 
       
         //COMARCA DO JUIZ 
         String I[] = correio.split("Nome    :");
         String comarcaJuiz = (I[1]);       
         String J[] = comarcaJuiz.split("-  Valor   :");
         comarcaJuiz = (J[0]).trim();   
         System.out.println(comarcaJuiz); 
       
         //PROCESSO DO JUIZ 
         String K[] = correio.split("Nome    :");
         String protocoloJuiz = (K[1]);       
         String L[] = protocoloJuiz.split("-  Valor   :");
         protocoloJuiz = (L[0]).trim();   
         System.out.println(protocoloJuiz); 
      
         /* String cep="";
         String rua="";
         String numeroBancen="";
         String cidade="";
         String uf="";
         String bairro="";
         */
        /*  
         Juiz juiz=new Juiz();
      
         juiz.setId(idJuiz);
         juiz.setNome(nomeJuiz);
         juiz.setVara(varaJuiz);
         juiz.setTribunal(tribunalJuiz);
         juiz.setComarca(comarcaJuiz);
         juiz.setProtocolo(correio);
   
      
      

       
         System.out.println( );    
       
       
         //fim busca autor
            
         */
        
        
        
        
        
         //ID REU 
       String A[] = correio.split("ID da Transferência  :");
       String idReu = (A[1]);             
   //    System.out.println(idReu);       
       String B[] = idReu.split("Autor:");
       idReu = (B[0]).trim();  
       System.out.println(idReu); 
       
       //CPF REU 
       String C[] = correio.split("-  C");
       String cpfReu = (C[1]);  
       
       String c[] =cpfReu.split(":");
       cpfReu = (c[1]).trim(); 
       
     //  System.out.println(cpfReu);       
       String D[] =cpfReu.split("-  Nome");
       cpfReu = (D[0]).trim();  
       System.out.println(cpfReu);      
        
       //NOME REU 
       String E[] = correio.split("Nome           :");
       String nomeReu = (E[1]);             
     //  System.out.println(nomeReu);       
       String F[] = nomeReu.split("-  Codigo MCI");
       nomeReu = (F[0]).trim();   
       System.out.println(nomeReu); 
       
       //PREFIXO AGÊNCIA REU 
       String G[] = correio.split("agência:");
       String prefixoAgenciaReu = (G[1]).substring(0, 4).trim();             
  //     System.out.println(prefixoAgenciaReu);       
     //  String H[] = prefixoAgenciaReu.split("000");
     //  nomeReu = (H[0]);  
       System.out.println(prefixoAgenciaReu); 
       
       //Busca PSO
       
        Connection cn = (Connection) new Conexao().conectar();
        
        
    //    String sqlVai = "select DEPENDENCIA.PREFPSO  from bdjudicial.DEPENDENCIA where PREF= " + "'" + prefixoAgenciaReu + "'"; 
        
         String sqlVai = "select *  from bdjudicial.DEPENDENCIA where PREF= " +  prefixoAgenciaReu ; 
      //  String sqlVai = "select PREFPSO  from bdjudicial.DEPENDENCIA where PREF=0001"; 
     //   String sqlVai = "select *  from bdjudicial.Ajure where pleco = '1' and DT_GRAV = " + "'" + dataHoje + "'";  
        java.sql.Statement stm = cn.createStatement();
        ResultSet rs = stm.executeQuery(sqlVai);
             
        
        while (rs.next()) {
             System.out.println(rs.getString("PREFPSO"));
        }
       
       
        
       
      
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
