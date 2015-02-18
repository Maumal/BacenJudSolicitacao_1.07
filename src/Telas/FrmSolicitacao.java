/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas;

import static Telas.JFMPrincipal.doMerge;
import static Telas.JFMPrincipal.soNumeros;
import bacenjud.Autor;
import bacenjud.Comprovante;
import bacenjud.Juiz;
import bacenjud.PesquisaComprovantes;
import bacenjud.Processo;
import bacenjud.Reu;
import bacenjud.pesquisaProcessados;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import pdf.GeraOficio;
import pdf.Oficio;
import processamento.BuscaCorreios;
import processamento.TrataCorreios;

/**
 *
 * @author f7057419
 */
public final class FrmSolicitacao extends javax.swing.JFrame {

    /**
     * Creates new form FrmSolicitacao
     */
    public FrmSolicitacao() throws Exception {
        
       initComponents();

        txtChave.setText(System.getProperty("user.name").toUpperCase());
        txtSenha.requestFocus();
        //Altera a cor do formulário
        //Color corDoformulario = new Color(0,56,168);//Azul do banco
        //Random gerador = new Random(); 
        //int R = gerador.nextInt(256);
        //int G = gerador.nextInt(256);
        //int B = gerador.nextInt(256);          
        //Color corDoformulario = new Color(R,G,B);
       // Color corDoformulario = new Color(0, 228, 255);
        Color corDoformulario = new Color(0, 132, 254);
        getContentPane().setBackground(corDoformulario); //Aqui o método chave
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Altera o tamanho do form
        // setBounds(300, 200, 400, 300);
          //Para o form ficar no meio da tela    
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        Integer largura;
        Integer altura;

        largura = d.width;
        largura = (largura / 2) - (550 / 2);
        altura = d.height;
        altura = (altura / 2) - (595 / 2);
               
        
        setBounds( largura,altura, 595, 550);
        
         // Copiar arquivos de logo LogoRetangular.png e AR.pdf da rede para temp
        //File arIN = new File("c:/temp/AR.pdf");  
        File arIN = new File("\\\\Srispo02525\\cso1981servjudfunci$\\Publica\\INFORMACOES A TERCEIROS\\OFÍCIO\\OFICIO_PROG\\AR.pdf");
        //     \\Srispo02525\cso1981servjudfunci$\Publica\INFORMACOES A TERCEIROS\OFÍCIO\OFICIO_PROG

        File arOUT = new File("c:/temp/AR.pdf");
        copyFile(arIN, arOUT);

        // File logoIN = new File("c:/temp/LogoRetangular.png");  
        File logoIN = new File("\\\\Srispo02525\\cso1981servjudfunci$\\Publica\\INFORMACOES A TERCEIROS\\OFÍCIO\\OFICIO_PROG\\LogoRetangular.png");

        File logoOUT = new File("c:/temp/LogoRetangular.png");
        copyFile(logoIN, logoOUT);

        this.setIconImage(Toolkit.getDefaultToolkit().getImage("Logo.png"));  
        
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
             //   System.out.println(dateTime3);

                int dateTime4 = 0;
                while (dateTime3 != dateTime4) {
                    dateTime4 = dateTime1.getDayOfMonth();
                }
                System.exit(0);

            }
        }.start();
    }
     
     public void copyFile(File in, File out) throws Exception {
        FileChannel destinationChannel;
        try (FileChannel sourceChannel = new FileInputStream(in).getChannel()) {
            destinationChannel = new FileOutputStream(out).getChannel();
            sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
        }
        destinationChannel.close();
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
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtSenha = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtChave = new javax.swing.JTextField();
        rbCorrigirData = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Solicitação \\o/");
        getContentPane().setLayout(null);

        jToggleButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(80, 170, 251));
        jToggleButton1.setText("Iniciar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1);
        jToggleButton1.setBounds(40, 240, 140, 60);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/nome.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(260, 20, 300, 40);

        jPanel1.setBackground(new java.awt.Color(80, 170, 251));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        txtSenha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtSenha.setToolTipText("");
        jPanel1.add(txtSenha);
        txtSenha.setBounds(380, 30, 130, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/Senha.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(270, 30, 100, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("* Somente Funcionários");
        jLabel4.setToolTipText("");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 10, 120, 13);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/chave1.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 30, 100, 30);

        txtChave.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(txtChave);
        txtChave.setBounds(120, 30, 130, 28);

        rbCorrigirData.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbCorrigirData.setForeground(new java.awt.Color(255, 255, 51));
        rbCorrigirData.setText("Corrigir Data");
        jPanel1.add(rbCorrigirData);
        rbCorrigirData.setBounds(30, 70, 160, 25);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 90, 540, 120);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/hand_3_2.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(380, 270, 160, 180);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Telas/fundo.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, -10, 320, 550);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(80, 170, 251));
        jLabel5.setText("Desenvolvido por: F7057419 - Maurício da Silva Luiz");
        jLabel5.setToolTipText("");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(250, 490, 300, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
       // TODO add your handling code here:  
        Integer mes;
        String mesExtenso = null;
        String data = null;
        String correioArquivo=""; 
        Boolean corrigirDatas=false;
      
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
        ArrayList<String> listaCorreiosMudarPasta = new ArrayList<>();
        
        
     //   ArrayList<Comprovante> listaComprovante = new ArrayList<>();
        
               
        //1.0-Busca os correios e carrega a lista de correios
                    BuscaCorreios x = new BuscaCorreios();  
                    
                    try {
                        listaCorreiosReturn =  x.Sisbb(txtChave.getText(), txtSenha.getText(),listaCorreios);
                    } catch (Exception ex) {
                        Logger.getLogger(JFMPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
              
   //      System.out.println(listaCorreiosReturn.size());
       //1.0           
            
       //2.0 - Verifica Correios irregulares
        TrataCorreios  verificaEmails = new TrataCorreios(); 
        try {
            listaCorreiosReturn = verificaEmails.VerificarCorreiosForaDoPadrao(listaCorreiosReturn);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JFMPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        //2.0
        
      //  System.out.println(listaCorreiosReturn.size());
        
            
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
   
if (rbCorrigirData.isSelected()) {
     corrigirDatas = true;
}
     
     
     TrataCorreios  buscaProcessados = new TrataCorreios();     
        try {
            listaProcessadosReturn = buscaProcessados.verificaProcessados(txtChave.getText(), txtSenha.getText(),corrigirDatas,listaPesquisaProcessados);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JFMPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(listaProcessadosReturn.size());
        
        
        
        //8.0 Criar uma lista de objetos oficio        
        for (Comprovante comprovante : listaProcessadosReturn) {
            Oficio oficio = new Oficio();  
            String cpf="";
            String agencia="";
            String valor="";
            String protocolo="";
            String banco="";
            String nBanco="";
            String dataCorpo="";
            oficio.setData(data);
            
            
            //Carrega o número do correio e número do processo
            for (Processo processo: listaProcessoReturn) {
                if (comprovante.getId() == null ? processo.getId() == null : comprovante.getId().equals(processo.getId())) {
                   oficio.setOficio(processo.getCorreio());  
                   oficio.setProcesso(processo.getProcesso());
                   valor=processo.getValor();
                   dataCorpo=processo.getData();
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
            corpo ="Meritíssimo(a) Juiz(a),"
                  //  + " " + "\n"
                    + " " + "\n"
                    + "          Em atenção à solicitação de Vossa Excelência, por meio do ofício expedido nos autos do processo em epígrafe, informamos:"                  
               //    + " " + "\n"
                    + " " + "\n"
                    + "Dados do remetente: "
             ///      + " " + "\n"
                    + " "+ "\n"
                    +"CPF/CNPJ: "+cpf+ "\n"
                    + "Agência do Réu: "+agencia+"\n"                   
               //     + " " + "\n"
                  //  + " " + "\n"
                    + "Dados da transferência: "   
        //           + " " + "\n"
                    + " " + "\n"
                    +"Valor: R$ "+valor+"\n"
                    +"Protocolo: "+protocolo+"\n"
                    +"ID: "+comprovante.getId()+"\n"
                    +"Banco: " +nBanco+ "  "+banco+"\n"
                   // + "Agência do Autor: "+nBanco+"\n"                                                  
                    +"Documento: "+comprovante.getComprovante()+"\n"
                    +"Data: "+dataCorpo+"\n"
                                    
             //       + " " + "\n"
                  //  + " " + "\n"
                    + "         Essas informações são confidênciais e são encaminhadas com amparo na lei Complementar nº105/2001 que dispõe sobre o sigilo das operações e serviços prestados pelas instituições financeiras."
                    + ""+"\n"
                    + "       Colocamo-nos à disposição para maiores esclarecimentos porventura necessários."
                
               //     + " "+"\n"
                      + " "+"\n"
                    + "         Respeitosamente,";
            
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
           ArrayList<InputStream> listrede = new ArrayList<>();
        try {     
            // Source pdfs
            list.add(new FileInputStream(new File("c:\\temp\\OficioComLogo.pdf")));
            list.add(new FileInputStream(new File("c:\\temp\\ARF.pdf")));
            
            listrede.add(new FileInputStream(new File("c:\\temp\\OficioComLogo.pdf")));
            listrede.add(new FileInputStream(new File("c:\\temp\\ARF.pdf")));
            
   ///Criação de pastas
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

    /*    File dir = new File("c:/temp/OFICIO/BACENJUD/");
        File dirAno = new File("c:/temp/OFICIO/BACENJUD/"+ano);
        File dirMes = new File("c:/temp/OFICIO/BACENJUD/"+ano+"/"+mesS);
        File dirDia = new File("c:/temp/OFICIO/BACENJUD/"+ano+"/"+mesS+"/"+dia);    */
        
        File dirrede = new File("G:\\Publica\\CENTRAL DE OFICIOS\\BACENJUD SOLICITACAO\\");
        File dirAnorede = new File("G:\\Publica\\CENTRAL DE OFICIOS\\BACENJUD SOLICITACAO\\"+ano);
        File dirMesrede = new File("G:\\Publica\\CENTRAL DE OFICIOS\\BACENJUD SOLICITACAO\\"+ano+"\\"+mesS);
        File dirDiarede = new File("G:\\Publica\\CENTRAL DE OFICIOS\\BACENJUD SOLICITACAO\\"+ano+"\\"+mesS+"\\"+dia);
        
        
        
      	 try {
       //     dir.mkdir();
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
    //        dirMes.mkdir();
            dirMesrede.mkdir();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try {
    //        dirDia.mkdir();
            dirDiarede.mkdir();
        } catch (Exception e) {
            System.out.println(e);
        }
		
                       
   //                
//String caminho="c:/temp/OFICIO/BACENJUD/"+ano+"/"+mesS+"/"+dia+"/"+oficio.getOficio().replaceAll("/", "")+"_"+oficio.getAutor().replaceAll("/", "").toUpperCase()+".pdf";

        
     
String caminhoRede="G:\\Publica\\CENTRAL DE OFICIOS\\BACENJUD SOLICITACAO\\"+ano+"\\"+mesS+"\\"+dia+"\\"+oficio.getOficio().replaceAll("/", "")+"_"+oficio.getAutor().replaceAll("/", "").replace("\\","").toUpperCase()+".pdf";
        
//String caminho="c:\\temp\\teste\\Oficio.pdf";
       
           
    //     OutputStream out = new FileOutputStream(new File(caminho));
         OutputStream outrede = new FileOutputStream(new File(caminhoRede));

           // doMerge(list, out);
             try {
 //              doMerge(list, out); 
               doMerge(listrede, outrede);
               listaCorreiosMudarPasta.add(oficio.getOficio());
            } catch (DocumentException | IOException e) {
            }
            

        } catch (FileNotFoundException e) {
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
        

        
        
        System.out.println(listaCorreiosMudarPasta.size());
        
        TrataCorreios  MudadePasta = new TrataCorreios();  
        try {
            MudadePasta.TrocaDePasta(txtChave.getText(), txtSenha.getText(),listaCorreiosMudarPasta);
        } catch (SQLException ex) {
            Logger.getLogger(JFMPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
    }//GEN-LAST:event_jToggleButton1ActionPerformed

 
    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSolicitacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new FrmSolicitacao().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(FrmSolicitacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JRadioButton rbCorrigirData;
    private javax.swing.JTextField txtChave;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
