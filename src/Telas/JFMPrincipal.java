/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas;

import bacenjud.Autor;
import bacenjud.Comprovante;
import bacenjud.Juiz;
import bacenjud.PesquisaComprovantes;
import bacenjud.Processo;
import bacenjud.Reu;
import bacenjud.pesquisaProcessados;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.List;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import processamento.BuscaCorreios;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import pdf.GeraOficio;
import pdf.Oficio;
import processamento.TrataCorreios;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;





/**
 *
 * @author f7057419
 */
public class JFMPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JFMPrincipal
     */
    public JFMPrincipal() {
       
        initComponents();
        
        
        //Para o form ficar no meio da tela    
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        Integer largura;
        Integer altura;

        largura = d.width;
        largura = (largura / 2) - (800 / 2);
        altura = d.height;
        altura = (altura / 2) - (600 / 2);

        initComponents();

        setBounds(largura, altura, 800, 600);
        
        Color corDoformulario = new Color(240, 240, 240);
        getContentPane().setBackground(corDoformulario);  
        
        

        fecharMeiaNoite();
        
        
        
        
        
        
        
        
              
    }
  public void fecharMeiaNoite() {
        new Thread() {
            @Override
            public void run() {

                DateTime dateTime1 = new DateTime();
                //     System.out.println(dateTime1.getMinuteOfDay());

                int dateTime3 = dateTime1.getDayOfMonth();
                dateTime3 = dateTime3 + 1;
                System.out.println(dateTime3);

                int dateTime4 = 0;
                while (dateTime3 != dateTime4) {
                    dateTime4 = dateTime1.getDayOfMonth();
                }
                System.exit(0);

            }
        }.start();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtChave = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnVai = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("BANCEN JUD solicitação");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 10, 520, 50);

        jLabel2.setFont(new java.awt.Font("Segoe Script", 0, 11)); // NOI18N
        jLabel2.setText("Chave:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 90, 39, 18);

        txtChave.setText("f7057419");
        txtChave.setToolTipText("");
        getContentPane().add(txtChave);
        txtChave.setBounds(90, 90, 140, 30);

        jLabel3.setFont(new java.awt.Font("Segoe Script", 0, 11)); // NOI18N
        jLabel3.setText("Senha:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(100, 150, 40, 20);

        txtSenha.setText("65414038");
        txtSenha.setToolTipText("");
        getContentPane().add(txtSenha);
        txtSenha.setBounds(180, 140, 140, 30);

        btnVai.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        btnVai.setText("123 Vai!!");
        btnVai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaiActionPerformed(evt);
            }
        });
        getContentPane().add(btnVai);
        btnVai.setBounds(30, 200, 101, 35);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaiActionPerformed
        // TODO add your handling code here: 
       Integer mes;
        String mesExtenso = null;
        String data = null;
        String correioArquivo=""; 
      
                LocalDate hoje = new LocalDate();//hoje

        //tratamento mês por extenso
        mes = hoje.getMonthOfYear();

        switch (mes) {
            case 1:
                mesExtenso = "Janeiro";
                break;
            case 2:
                mesExtenso = "Fevereiro";
                break;
            case 3:
                mesExtenso = "Março";
                break;
            case 4:
                mesExtenso = "Abril";
                break;
            case 5:
                mesExtenso = "Maio";
                break;
            case 6:
                mesExtenso = "Junho";
                break;
            case 7:
                mesExtenso = "Julho";
                break;
            case 8:
                mesExtenso = "Agosto";
                break;
            case 9:
                mesExtenso = "Setembro";
                break;
            case 10:
                mesExtenso = "Outubro";
                break;
            case 11:
                mesExtenso = "Novembro";
                break;
            case 12:
                mesExtenso = "Dezembro";
                break;
        }
        data=("São Paulo, " + hoje.getDayOfMonth() + " de " + mesExtenso + " de " + hoje.getYear());
        
               
        
        
        
        ArrayList listaCorreiosReturn = null;       
        ArrayList<String> listaCorreios = new ArrayList<>();        
        ArrayList<Processo> listaProcessoReturn = new ArrayList<>();        
        ArrayList<Autor> listaAutoresReturn = new ArrayList<>();
        ArrayList<Reu> listaReuReturn = new ArrayList<>();
        ArrayList<pesquisaProcessados> listaPesquisaProcessados = new  ArrayList<>();
        ArrayList<Juiz> listaJuizReturn = new ArrayList<>();
        ArrayList<Comprovante> listaProcessadosReturn = new ArrayList<>();
        ArrayList<PesquisaComprovantes> listaComprovantes = new ArrayList<>();
        ArrayList<Oficio> listaOficio = new ArrayList<>();
        
        
        ArrayList<Comprovante> listaComprovante = new ArrayList<>();
        
               
        //1.0-Busca os correios e carrega a lista de correios
                    BuscaCorreios x = new BuscaCorreios();
                    try {
                        listaCorreiosReturn =  x.Sisbb(txtChave.getText(), txtSenha.getText(),listaCorreios);
                    } catch (Exception ex) {
                        Logger.getLogger(JFMPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
              
       //     System.out.println(listaCorreiosReturn.size());
       //1.0           
            
       //2.0 - Verifica Correios irregulares
        TrataCorreios  verificaEmails = new TrataCorreios(); 
        try {
            listaCorreiosReturn = verificaEmails.VerificarCorreiosForaDoPadrao(listaCorreiosReturn);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JFMPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        //2.0
        
        
        
            
       //3.0 Gera Lista Reus
      TrataCorreios  buscaReus = new TrataCorreios();  
        try {
            listaReuReturn=buscaReus.GeraListaReus(txtChave.getText(), txtSenha.getText(),listaCorreiosReturn);
        } catch (SQLException ex) {
            Logger.getLogger(JFMPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
 //     System.out.println(listaReuReturn.size());
      //3.0
      
      //4.0 Gera Lista Autor
      TrataCorreios  buscaAutor = new TrataCorreios(); 
      listaAutoresReturn = buscaAutor.GeraListaAutor(listaCorreiosReturn);
      //System.out.println(listaAutoresReturn.size());
     //4.0
      
      //5.0 Gera lista Processo
     TrataCorreios  buscaProcessso = new TrataCorreios(); 
     listaProcessoReturn = buscaProcessso.GeraListaProcesso(listaCorreiosReturn);
     // System.out.println(listaProcessoReturn.size());
     //5.0
     
     //6.0 Gera Lista Juiz
     TrataCorreios  buscaJuiz = new TrataCorreios(); 
     listaJuizReturn = buscaJuiz.GeraListaJuiz(txtChave.getText(), txtSenha.getText(),listaCorreiosReturn);
     //System.out.println(listaJuizReturn.size());
     //6.0
     
     //7.0 Criar uma listas de pesquisaProcecessados para pesquisa de processados
    
      
     for (Processo processo : listaProcessoReturn) {         
         pesquisaProcessados pesquisaprocesso=new pesquisaProcessados();
         pesquisaprocesso.setCorreio(processo.getCorreio());
         pesquisaprocesso.setData(processo.getData().trim());
         pesquisaprocesso.setValor(soNumeros(processo.getValor().trim()));
         pesquisaprocesso.setId(soNumeros(processo.getId().trim()));
        //pesquisaprocesso.setValor((processo.getValor().trim().replaceAll("R", "").replaceAll("$", "")));
         
           for (Reu reu : listaReuReturn) {
               if (processo.getId() == null ? reu.getId() == null : processo.getId().equals(reu.getId())) {
                   pesquisaprocesso.setPso(reu.getPso());                   
               }  
           }           
           for (Autor autor : listaAutoresReturn) {
               if (processo.getId() == null ? autor.getId() == null : processo.getId().equals(autor.getId())) {
                   pesquisaprocesso.setBanco(autor.getnBanco());                   
               }  
           }          
           
           
           
          listaPesquisaProcessados.add(pesquisaprocesso);
    }
     
     for (pesquisaProcessados xx : listaPesquisaProcessados) {
         System.out.println(xx.getCorreio());
         System.out.println(xx.getData());
         System.out.println(xx.getValor());
         System.out.println(xx.getPso());
         System.out.println(xx.getBanco());
   }
     
//     TrataCorreios  buscaProcessados = new TrataCorreios(); 
//        try {
//            listaProcessadosReturn = buscaProcessados.verificaProcessados(txtChave.getText(), txtSenha.getText(),listaPesquisaProcessados);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(JFMPrincipal.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println(listaProcessadosReturn.size());
        
        
        
        //8.0 Criar uma lista de objetos oficio        
        for (Comprovante comprovante : listaProcessadosReturn) {
            Oficio oficio = new Oficio();  
            String cpf="";
            String agencia="";
            String valor="";
            String protocolo="";
            String banco="";
            String nBanco="";             
            oficio.setData(data);
            
            
            //Carrega o número do correio e número do processo
            for (Processo processo: listaProcessoReturn) {
                if (comprovante.getId() == null ? processo.getId() == null : comprovante.getId().equals(processo.getId())) {
                   oficio.setOficio(processo.getCorreio());  
                   oficio.setProcesso(processo.getProcesso());
                   valor=processo.getValor();
                   protocolo=processo.getProtocolo();
                  
                }             
            }
            //Carrega o Autor
             for (Autor autor: listaAutoresReturn) {
                if (comprovante.getId() == null ? autor.getId() == null : comprovante.getId().equals(autor.getId())) {
                   oficio.setAutor(autor.getNome());
                  // agencia=autor.getAgencia();
                   banco=autor.getBanco();
                   nBanco=autor.getnBanco();
                }             
            }
             
              //Carrega o Réu
             for (Reu reu: listaReuReturn) {
                if (comprovante.getId() == null ? reu.getId() == null : comprovante.getId().equals(reu.getId())) {
                   oficio.setReu(reu.getNome());   
                   cpf=reu.getCpf();
                   agencia=reu.getAgencia();
                }             
            }
             
             oficio.setLinhas("0");
            
            //Carrega o Corpo   
            String corpo;
            corpo ="Meritíssimo(a) Juiz(a)," + "\n"
                    + " " + "\n"
                    + " " + "\n"
                    + "     Em Atenção à solicitação de Vossa Excelência, por meio do ofício expedido" + "\n"
                    + "nos autos do Processo em epígrafe, informamos:"+"\n"
                   // + " " + "\n"
                    + " " + "\n"
                    + "Dados do remetente "
                 //   + " " + "\n"
                    + " " + "\n"
                    +"-CPF/CPNJ: "+cpf+"\n"
                    + "-Agência:"+agencia+"\n"
               //     + " " + "\n"
                    + " " + "\n"
                    + "Dados da transfência"   
              //      + " " + "\n"
                    + " " + "\n"
                    +"-Valor: R$"+valor+"\n"
                    +"-Protocolo:"+protocolo+"\n"
                    + "-ID:"+comprovante.getId()+"\n"
                    + "-Banco:"+banco+"\n"
                    + "Agência:"+nBanco+"\n"
                    + "NR. DOCUMENTO:"+comprovante.getComprovante()+"\n"
             //       + " " + "\n"
                    + " " + "\n"
                    + "     Essas informações são confidências e são encaminhadas com amparo na lei"+"\n"
                    + "Complementar nº105/2001 que dispõe sobre o sigilo das operações e serviços"+"\n"
                    + "prestados pelas instituições financeiras"+"\n"
              //      + ""+"\n"
                    + ""+"\n"
                    + "     Colocamo-nos à disposição para maiores esclarecimentos porventura"+"\n"
                    + "necessários."+"\n"
                    + ""+"\n"
                      + ""+"\n"
                    + "Respeitosamente.";
            
            oficio.setCorpo(corpo);
            
            //Carrega o Juiz e o endereço
            for (Juiz juiz: listaJuizReturn) {
                if (comprovante.getId() == null ? juiz.getId() == null : comprovante.getId().equals(juiz.getId())) {
                   oficio.setDestinario(juiz.getNome());  
                   oficio.setEndereco(juiz.getTribunal() +"\n"+  juiz.getVara().toUpperCase() +"\n"+ juiz.getRua() +"     "+ juiz.getBairro()+"\n"+"CEP: "+ juiz.getCep()  +" - "+ juiz.getCidade() +" - "+ juiz.getUf());
                }             
            }
            listaOficio.add(oficio);        
        }
        
        for (Oficio oficio : listaOficio) {
            
            GeraOficio GO = new GeraOficio();
            try {
                GO.Gerar(oficio);
            } catch (    IOException | DocumentException | InterruptedException ex) {
                Logger.getLogger(JFMPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            GeraOficio Ga = new GeraOficio();
            try {
                Ga.GerarAR(oficio);
            } catch (    IOException | DocumentException ex) {
                Logger.getLogger(JFMPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }     
    
        
           ArrayList<InputStream> list = new ArrayList<>();
        try {
            // Source pdfs
            list.add(new FileInputStream(new File("c:\\temp\\OficioComLogo.pdf")));
            list.add(new FileInputStream(new File("c:\\temp\\ARF.pdf")));

            // Resulting pdf
            String caminho="c:\\temp\\teste\\Oficio"+oficio.getOficio().replaceAll("/", "")+".pdf";
        //    String caminho="c:\\temp\\teste\\Oficio.pdf";
            OutputStream out = new FileOutputStream(new File(caminho));

            doMerge(list, out);

        } catch (FileNotFoundException e) {
            System.out.println(e);
            
        } catch (DocumentException | IOException e) {
            
            System.out.println(e);
        }
        
     //   Renomar o arquivo
    /*    try {  
            File fTmp = new File("c:\\temp\\teste\\Oficio.pdf");  
            File fTxt = new File("c:\\temp\\teste\\Oficio"+correio.replaceAll("/", "")+".pdf");  
            fTxt.createNewFile();  
            Writer arquivo = new FileWriter(fTmp);  
            fTmp.renameTo(fTxt);              
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } 
        */
        
        
        
        }
        
        
        
        
          
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//    //8.0 Gera lista comprovantes
//     
//        
//        
//        for (String id : listaProcessadosReturn) {
//        PesquisaComprovantes pc = new PesquisaComprovantes();
//            
//        pc.setId(id);
//        
//        for (Reu reu : listaReuReturn) {
//               if (pc.getId() == null ? pc.getId() == null : pc.getId().equals(reu.getId())) {
//                   pc.setPso(reu.getPso());                   
//               }  
//       } 
//        
//    
//        
//        for (Processo processo : listaProcessoReturn) {         
//        
//             if (pc.getId() == null ? pc.getId() == null : pc.getId().equals(processo.getId())) {
//                   pc.setData(processo.getData()); 
//                   pc.setValor(processo.getValor());
//                   pc.setCorreio(processo.getCorreio());
//               }       
//        }        
//        listaComprovantes.add(pc);        
//        }
//        
//        
        
//       TrataCorreios  buscacomprovantes = new TrataCorreios(); 
//       System.out.println(listaComprovantes.size());
//        try {
//            listaComprovanteReturn= buscacomprovantes.GeraListaComprovante(txtChave.getText(), txtSenha.getText(), listaComprovantes);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(JFMPrincipal.class.getName()).log(Level.SEVERE, null, ex);
//        }
//       System.out.println(listaComprovanteReturn.size());
//        
       //
        
        
        
     
   //
                           
            System.exit(0);
                     
    }//GEN-LAST:event_btnVaiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFMPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFMPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFMPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFMPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JFMPrincipal().setVisible(true);
            }
        });
    }
    
    public static String soNumeros(String str){
        if (str !=null) {
            return str.replaceAll("[^,0123456789]", "");            
        }else{
            return "";  
        }
    }
    
    public static void doMerge(ArrayList<InputStream> list, OutputStream outputStream)
            throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        document.open();
        PdfContentByte cb = writer.getDirectContent();
        
        for (InputStream in : list) {
            PdfReader reader = new PdfReader(in);
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                document.newPage();
                //import the page from source pdf
                PdfImportedPage page = writer.getImportedPage(reader, i);
                //add the page to the destination pdf
                cb.addTemplate(page, 0, 0);
            }
        }
        
        outputStream.flush();
        document.close();
        outputStream.close();
    }
    
    
    
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtChave;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}