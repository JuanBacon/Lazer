/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.applet.AudioClip;
import javax.swing.ImageIcon;
import Clases.*;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.Icon;
import java.io.*;


/**
 *
 * @author Juan_die.bustamante@uao.edu.co & Juan.Renza
 */
public class Principal extends javax.swing.JFrame {
        
    
        //Variables utilizadas para la creación de tarjetas, contadores y cambios de pantalla
        int score = 0;
        int HS = 0;
        String CadHS;
        int ScoreIglesia = 50;
        int ScoreGranja = 50;
        int ScoreMilicia = 50;
        int ScoreBurguesia = 50;
        int tipo;
        int contadortuto = 0;
        //Número de tarjetas 
        int n = 40;
        Icon icono;
        Icon tuto;
        int i;
        AudioClip fondo;
        AudioClip select;
        AudioClip gameover;
        ArrayList <Tarjeta> TAJ = new ArrayList<>();
        //Objetos Persistencia
        FileWriter FW;
        PrintWriter PW;
        File F;
        FileReader FR;
        BufferedReader BR;
        
        
    public Principal() {
        
        
        
        initComponents();
        
        //Carga la mayor puntuación guardada en un archivo
        try {
        
        F = new File("ListaScore.txt");
        FR = new FileReader(F);
        BR = new BufferedReader(FR);
    
        while((CadHS = BR.readLine())!= null)
            
            JHS.setText(CadHS);
            HS = Integer.parseInt(JHS.getText());
            
        } catch(Throwable e){System.out.print(e);}
        
        //Establecer la posición de la ventana en el centro de la pantalla
        this.setLocationRelativeTo(null);
        //Establecer el icono de la ventana
        setIconImage(new ImageIcon(getClass().getResource("/IMG/icono.png")).getImage());
        
        //Mostrar el menú principal
        PanelJuego.setVisible(false);
        PanelTuto.setVisible(false);
        PanelPerson.setVisible(false);
        PanelInicio.setVisible(true);
        PanelFinal.setVisible(false);
        Jtuto.setVisible(false);

        
        //Instancia de la variable AudioClip del fondo
        fondo = java.applet.Applet.newAudioClip(getClass().getResource("/Sound/audio.wav"));
        fondo.loop();
        
               
        
        
        //CREACIÓN DE OBJETOS
        
        
        
        Granja G1 = new Granja("<html>Los granjeros quieren todas las comunidades del primer mundo para trabajar.¿deseas invertir en ellos?<html>",10,0,-10,-10,1);
        TAJ.add(G1);
        Granja G2 = new Granja("<html>Unos alienigenas han aterrizado en tus campos, y quieren hacer dibujitos en ellos.¿lo permites?<html>",-10,0,20,10,1);
        TAJ.add(G2);
        Granja G3 = new Granja("<html>Los granjeros están mostrando tendencias psicópatas y se están haciendo amigos de las vacas.¿Quieres pagar un psiquiatra?<html>",10,0,0,-20,1);
        TAJ.add(G3);
        Granja G4 = new Granja("<html>Por accidente tus campesinos han creado una fruta nueva.¿Quieres compartir la noticia con el pueblo?<html>",25,0,-5,10,1);
        TAJ.add(G4);
        Granja G5 = new Granja("<html>Ahora tus granjeros se identifican cómo empresarios ejecutivos dueños de multinacionales.¿Deseas cumplir sus sueños?<html>",-20,0,0,20,1);
        TAJ.add(G5);
        
        Milicia M1 = new Milicia("<html>Tus soldados quieren jugar al nuevo Call Of Duty para entrenarse ¿Deseas comprarles consolas y juegos?<html>",0,0,20,-5,2);
        TAJ.add(M1);
        Milicia M2 = new Milicia("<html>Una horda de zombies están atacando tu pueblo.¿Mandas a tu ejercito a protegerlos?<html>",10,10,-20,10,2);
        TAJ.add(M2);
        Milicia M3 = new Milicia("<html>Los fusiles de tu armada han quedado obsoletos.¿Deseas invertir de tus impuestos a nuevos rifles?<html>",0,0,10,-10,2);
        TAJ.add(M3);
        Milicia M4 = new Milicia("<html>Tus soldados quieren tomar cargos politicos altos.¿Deseas iniciar un imperio de parapolitica?<html>",-10,-10,10,-10,2);
        TAJ.add(M4);
        Milicia M5 = new Milicia("<html>Tus soldados no saben lavar ropa y han estropeado sus uniformes.¿Quieres invertir en unos nuevos?<html>",0,0,0,0,2);
        TAJ.add(M5);
        
        Iglesia I1 = new Iglesia("<html>Se ha acabado el agua bendita en tus iglesias. ¿Quieres importar más?<html>",0,10,0,-10,3);
        TAJ.add(I1);
        Iglesia I2 = new Iglesia("<html>Tus padres quieren intervenir en la politica del pueblo.¿Los intruduces en las ramas del poder? <html>",0,20,0,-10,3);
        TAJ.add(I2);
        Iglesia I3 = new Iglesia("<html>Un sacerdote ha recibido la orden divina de demoler su templo.¿Asumir los gastos de reconstrucción? <html>",-5,20,0,-10,3);
        TAJ.add(I3);
        Iglesia I4 = new Iglesia("<html>Dios ha decidido cobrarte más impuestos divinos, lo que se traduce como más ingresos a la iglesia.¿Lo permites?<html>",0,10,0,-10,3);
        TAJ.add(I4);
        Iglesia I5 = new Iglesia("<html>La cantidad de personas bautizadas en tu mandato ha reducido. ¿Quieres rociar agua bendita por todo el pueblo?<html>",0,-10,0,0,3);
        TAJ.add(I5);
        
        Burguesia B1 = new Burguesia("<html>La realeza cree que es buena idea introducir una hegemonía exclusiva.¿Estás de acuerdo?<html>",-5,-5,-5,10,4);
        TAJ.add(B1);
        Burguesia B2 = new Burguesia("<html>Tus principes ahora se creen princesas.¿Quieres cambiar la jerarquía real?<html>",0,0,0,-10,4);
        TAJ.add(B2);
        Burguesia B3 = new Burguesia("<html>Tu caballero personal ha sentido una atracción psico-sexual hacia ti.¿Quieres cambiarlo?<html>",0,-5,0,5,4);
        TAJ.add(B3);
        Burguesia B4 = new Burguesia("<html>Tu reina ya no te quiere y se ha acostado con un Granjero llamado Carlos.¿Quieres ejecutar a todos los carlos del pueblo... y a tu esposa?<html>",-20,-5,-5,20,4);
        TAJ.add(B4);
        Burguesia B5 = new Burguesia("<html> Una mota de polvo ha caido en tu alfombra favorita.¿Quieres ejecutar a todas tus sirvientas y buscar otras?<html>",-10,0,0,10,4);
        TAJ.add(B5);
        
        
        
        
        
        Granja GA = new Granja ("<html>Las ovejas ya no producen lana y los pastores han empezado a enviar lana humana. ¿Quieres invertir en nuevas ovejas?<html>",10,0,0,-10,1);
        TAJ.add(GA);
        Granja GB = new Granja ("<html>Los granjeros olvidaron como distinguir a una vaca de un toro. ¿Quieres invertir en su educación?<html>",10,0,0,-10,1);
        TAJ.add(GB);
        Granja GC = new Granja ("<html>Las gallinas se aburrieron de poner huevos y han empezado a picotear a todos los granjeros. ¿Quieres enviar ayuda?<html>",10,-10,0,0,1);
        TAJ.add(GC);
        Granja GD = new Granja ("<html>Las plantas han sido maldecidos y ahora general oro en lugar de frutas. ¿Enviarás a un exorcista?<html>",10,0,-10,-10,1);
        TAJ.add(GD);
        Granja GE = new Granja ("<html>Los granjeros de tomate verde han empezado una guerra con los de tomate rojo. ¿Deseas controlar a los revoltosos? <html>",20,-20,0,-10,1);
        TAJ.add(GE);
        Milicia MA = new Milicia ("<html>Tus soldados han olvidado su orientación sexual y perderán la guerra porque se celan los unos a los otros. ¿Deseas enviarles la palabra de Yisus?<html>",0,10,-30,0,2);
        TAJ.add(MA);
        Milicia MB = new Milicia ("<html>La guerra se ha convertido en un intercambio de armaduras entre ejércitos y ya no se identifica amigos de enemigo. ¿Quieres comprar nuevas armaduras?<html>",0,+20,0,-20,2);
        TAJ.add(MB);
        Milicia MC = new Milicia ("<html>Tu ejército sufre de depresión por no tener con quién pelear ¿Quieres enviarlos a asaltar aldeas sin sentido?<html>",0,-20,0,30,2);
        TAJ.add(MC);
        Milicia MD = new Milicia ("<html>Las sirenas han intentado seducir a tu ejército para eliminarlo. ¿Quieres recordarles que el único amor que necesitan es el de Yisus?<html>",0,15,-20,-10,2);
        TAJ.add(MD);
        Milicia ME = new Milicia ("<html>Tus soldados han perdido la noción humana y han empezado a violar a los animales de las granjas. ¿Deseas enviar nuevas tropas a por ellos?<html>",20,-20,0,0,2);
        TAJ.add(ME);
        Iglesia IA = new Iglesia ("<html>Tus sacerdotes de nuevo olvidaron el valor de no tocar a sus clérigos. ¿Deseas eliminar a aquellos impuros?<html>",0,-10,-20,0,3);
        TAJ.add(IA);
        Iglesia IB = new Iglesia ("<html>Los clérigos se han cansado de ser maltratados y han creado una nueva secta. ¿Quieres apoyarlos?<html>",10,10,-10,-10,3);
        TAJ.add(IB);
        Iglesia IC = new Iglesia ("<html>Se han acabado los crucifijos en oro con diamantes y rubíes. ¿Quieres comprar más mientras tú pueblo pasa hambre?<html>",-20,-20,20,-20,3);
        TAJ.add(IC);
        Iglesia ID = new Iglesia ("<html>Tu ciudad pasa frío y tú gente necesita quemar biblias para mantenerse caliente. ¿Lo permites?<html>",10,10,-10,10,3);
        TAJ.add(ID);
        Iglesia IE = new Iglesia ("<html>Se han generado nuevas iglesias con mejores argumentos. ¿Quieres eliminar a la anterior?<html>",0,-10,10,-10,3);
        TAJ.add(IE);
        Burguesia BA = new Burguesia ("<html>Se han acabado los pañuelos hechos de las lágrimas y cabellos de vírgenes pobres. ¿Quieres hacer más?<html>",-20,0,-10,20,4);
        TAJ.add(BA);
        Burguesia BB = new Burguesia ("<html>Las pieles de los animales que cobijan a las doncellas se han desgastado por el oro de sus pijamas. ¿Quieres cazar más animales? <html>",0,-20,0,20,4);
        TAJ.add(BB);
        Burguesia BC = new Burguesia ("<html>Un príncipe de un reino de solo hombres vino a proponerte grandes cantidades de oro por todos tus animales hembras. ¿Se los vendes? <html>",-10,0,0,20,4);
        TAJ.add(BC);
        Burguesia BD = new Burguesia ("<html>La sangre de vírgenes en la que se bañan las doncellas se ha terminado. ¿Les enviarás más?<html>",-20,0,0,10,4);
        TAJ.add(BD);
        Burguesia BE = new Burguesia ("<html>A tu caballero más poderoso no lo quiso casar el padre de la capital por sus grandes pecados. ¿Deseas intervenir en la iglesia?<html>",0,0,-20,20,4);
        TAJ.add(BE);

       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelInicio = new javax.swing.JPanel();
        JHS = new javax.swing.JLabel();
        JHS1 = new javax.swing.JLabel();
        BTutorial = new javax.swing.JButton();
        BPersonalizar = new javax.swing.JButton();
        Bsalir = new javax.swing.JButton();
        BInicio = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();
        PanelTuto = new javax.swing.JPanel();
        Jtuto2 = new javax.swing.JLabel();
        Jtuto1 = new javax.swing.JLabel();
        Jtuto = new javax.swing.JLabel();
        BTutorial1 = new javax.swing.JButton();
        BPersonalizar1 = new javax.swing.JButton();
        Bsalir1 = new javax.swing.JButton();
        BInicio1 = new javax.swing.JButton();
        Tarjeta1 = new javax.swing.JPanel();
        IMG1 = new javax.swing.JLabel();
        No1 = new javax.swing.JButton();
        Si1 = new javax.swing.JButton();
        Ftuto = new javax.swing.JLabel();
        PanelPerson = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        TextoP = new javax.swing.JTextField();
        JTIglesia = new javax.swing.JTextField();
        JTBurguesia = new javax.swing.JTextField();
        JTMilicia = new javax.swing.JTextField();
        JTGranja = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        IMGP = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PanelJuego = new javax.swing.JPanel();
        Tarjeta = new javax.swing.JPanel();
        IMG = new javax.swing.JLabel();
        TEXTO = new javax.swing.JLabel();
        No = new javax.swing.JButton();
        Si = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        JLScore = new javax.swing.JLabel();
        JLI = new javax.swing.JLabel();
        JLB = new javax.swing.JLabel();
        JLG = new javax.swing.JLabel();
        JLM = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        PanelFinal = new javax.swing.JPanel();
        JLP = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LAZER 1.0");
        setMaximumSize(new java.awt.Dimension(800, 480));
        setMinimumSize(new java.awt.Dimension(800, 480));
        setPreferredSize(new java.awt.Dimension(800, 480));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 480));
        getContentPane().setLayout(null);

        PanelInicio.setLayout(null);

        JHS.setFont(new java.awt.Font("Karmatic Arcade", 0, 18)); // NOI18N
        JHS.setForeground(new java.awt.Color(255, 255, 255));
        JHS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JHS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/crown.png"))); // NOI18N
        JHS.setText("0");
        PanelInicio.add(JHS);
        JHS.setBounds(590, 50, 120, 50);

        JHS1.setFont(new java.awt.Font("Karmatic Arcade", 0, 18)); // NOI18N
        JHS1.setForeground(new java.awt.Color(255, 255, 255));
        JHS1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JHS1.setText("PUNTUACION MAXIMA");
        PanelInicio.add(JHS1);
        JHS1.setBounds(540, 20, 250, 40);

        BTutorial.setBackground(new java.awt.Color(51, 102, 255));
        BTutorial.setFont(new java.awt.Font("Karmatic Arcade", 0, 18)); // NOI18N
        BTutorial.setForeground(new java.awt.Color(255, 255, 255));
        BTutorial.setText("Tutorial");
        BTutorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTutorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTutorialActionPerformed(evt);
            }
        });
        PanelInicio.add(BTutorial);
        BTutorial.setBounds(260, 270, 270, 40);

        BPersonalizar.setBackground(new java.awt.Color(51, 102, 255));
        BPersonalizar.setFont(new java.awt.Font("Karmatic Arcade", 0, 18)); // NOI18N
        BPersonalizar.setForeground(new java.awt.Color(255, 255, 255));
        BPersonalizar.setText("Personalizar");
        BPersonalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BPersonalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPersonalizarActionPerformed(evt);
            }
        });
        PanelInicio.add(BPersonalizar);
        BPersonalizar.setBounds(260, 330, 270, 40);

        Bsalir.setBackground(new java.awt.Color(51, 102, 255));
        Bsalir.setFont(new java.awt.Font("Karmatic Arcade", 0, 18)); // NOI18N
        Bsalir.setForeground(new java.awt.Color(255, 255, 255));
        Bsalir.setText("Salir");
        Bsalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Bsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BsalirActionPerformed(evt);
            }
        });
        PanelInicio.add(Bsalir);
        Bsalir.setBounds(260, 390, 270, 40);

        BInicio.setBackground(new java.awt.Color(51, 102, 255));
        BInicio.setFont(new java.awt.Font("Karmatic Arcade", 0, 18)); // NOI18N
        BInicio.setForeground(new java.awt.Color(255, 255, 255));
        BInicio.setText("Iniciar");
        BInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BInicioActionPerformed(evt);
            }
        });
        PanelInicio.add(BInicio);
        BInicio.setBounds(260, 210, 270, 40);

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Inicio.png"))); // NOI18N
        PanelInicio.add(Fondo);
        Fondo.setBounds(0, 0, 800, 450);

        getContentPane().add(PanelInicio);
        PanelInicio.setBounds(0, 0, 800, 450);

        PanelTuto.setLayout(null);

        Jtuto2.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        Jtuto2.setForeground(new java.awt.Color(255, 255, 255));
        Jtuto2.setText("<html>Bienvenido al tutorial, pulsa el boton izquiero del mouse para continuar<html>");
        PanelTuto.add(Jtuto2);
        Jtuto2.setBounds(270, 30, 250, 100);

        Jtuto1.setFont(new java.awt.Font("Lucida Console", 1, 24)); // NOI18N
        Jtuto1.setForeground(new java.awt.Color(255, 255, 255));
        Jtuto1.setText("<html>Bienvenido al tutorial, pulsa el boton izquiero del mouse para continuar<html>");
        PanelTuto.add(Jtuto1);
        Jtuto1.setBounds(550, 210, 250, 240);

        Jtuto.setFont(new java.awt.Font("Karmatic Arcade", 1, 14)); // NOI18N
        Jtuto.setForeground(new java.awt.Color(255, 255, 255));
        Jtuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/mouse.png"))); // NOI18N
        Jtuto.setText("<html>Bienvenido al tutorial, pulsa el boton izquiero del mouse para continuar<html>");
        PanelTuto.add(Jtuto);
        Jtuto.setBounds(10, 200, 250, 240);

        BTutorial1.setBackground(new java.awt.Color(51, 102, 255));
        BTutorial1.setFont(new java.awt.Font("Karmatic Arcade", 0, 18)); // NOI18N
        BTutorial1.setForeground(new java.awt.Color(255, 255, 255));
        BTutorial1.setText("Tutorial");
        BTutorial1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTutorial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTutorial1ActionPerformed(evt);
            }
        });
        PanelTuto.add(BTutorial1);
        BTutorial1.setBounds(260, 270, 270, 40);

        BPersonalizar1.setBackground(new java.awt.Color(51, 102, 255));
        BPersonalizar1.setFont(new java.awt.Font("Karmatic Arcade", 0, 18)); // NOI18N
        BPersonalizar1.setForeground(new java.awt.Color(255, 255, 255));
        BPersonalizar1.setText("Personalizar");
        BPersonalizar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BPersonalizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPersonalizar1ActionPerformed(evt);
            }
        });
        PanelTuto.add(BPersonalizar1);
        BPersonalizar1.setBounds(260, 330, 270, 40);

        Bsalir1.setBackground(new java.awt.Color(51, 102, 255));
        Bsalir1.setFont(new java.awt.Font("Karmatic Arcade", 0, 18)); // NOI18N
        Bsalir1.setForeground(new java.awt.Color(255, 255, 255));
        Bsalir1.setText("Salir");
        Bsalir1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Bsalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bsalir1ActionPerformed(evt);
            }
        });
        PanelTuto.add(Bsalir1);
        Bsalir1.setBounds(260, 390, 270, 40);

        BInicio1.setBackground(new java.awt.Color(51, 102, 255));
        BInicio1.setFont(new java.awt.Font("Karmatic Arcade", 0, 18)); // NOI18N
        BInicio1.setForeground(new java.awt.Color(255, 255, 255));
        BInicio1.setText("Iniciar");
        BInicio1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BInicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BInicio1ActionPerformed(evt);
            }
        });
        PanelTuto.add(BInicio1);
        BInicio1.setBounds(260, 210, 270, 40);

        Tarjeta1.setBackground(java.awt.Color.orange);
        Tarjeta1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        Tarjeta1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Tarjeta1.setLayout(null);

        IMG1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Agro.png"))); // NOI18N
        Tarjeta1.add(IMG1);
        IMG1.setBounds(40, 110, 230, 230);

        No1.setText("NO");
        No1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        No1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No1ActionPerformed(evt);
            }
        });
        Tarjeta1.add(No1);
        No1.setBounds(60, 360, 60, 23);

        Si1.setText("SÍ");
        Si1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Si1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Si1ActionPerformed(evt);
            }
        });
        Tarjeta1.add(Si1);
        Si1.setBounds(193, 360, 50, 23);

        PanelTuto.add(Tarjeta1);
        Tarjeta1.setBounds(240, 20, 300, 410);

        Ftuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Inicio.png"))); // NOI18N
        Ftuto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FtutoMouseClicked(evt);
            }
        });
        PanelTuto.add(Ftuto);
        Ftuto.setBounds(0, 0, 800, 450);

        getContentPane().add(PanelTuto);
        PanelTuto.setBounds(0, 0, 800, 450);

        PanelPerson.setMaximumSize(new java.awt.Dimension(800, 450));
        PanelPerson.setMinimumSize(new java.awt.Dimension(800, 450));
        PanelPerson.setRequestFocusEnabled(false);
        PanelPerson.setLayout(null);

        jComboBox1.setFont(new java.awt.Font("Karmatic Arcade", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Granja", "Milicia", "Iglesia", "Burguesia" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        PanelPerson.add(jComboBox1);
        jComboBox1.setBounds(50, 210, 130, 50);
        PanelPerson.add(TextoP);
        TextoP.setBounds(280, 80, 220, 60);
        PanelPerson.add(JTIglesia);
        JTIglesia.setBounds(690, 260, 70, 30);
        PanelPerson.add(JTBurguesia);
        JTBurguesia.setBounds(690, 380, 70, 30);
        PanelPerson.add(JTMilicia);
        JTMilicia.setBounds(580, 380, 70, 30);
        PanelPerson.add(JTGranja);
        JTGranja.setBounds(580, 260, 70, 30);

        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setFont(new java.awt.Font("Karmatic Arcade", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("VOLVER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        PanelPerson.add(jButton2);
        jButton2.setBounds(660, 20, 100, 30);

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setFont(new java.awt.Font("Karmatic Arcade", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("AGREGAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        PanelPerson.add(jButton1);
        jButton1.setBounds(30, 370, 180, 50);

        IMGP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Agro.png"))); // NOI18N
        PanelPerson.add(IMGP);
        IMGP.setBounds(280, 170, 230, 225);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Personalizar.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        PanelPerson.add(jLabel2);
        jLabel2.setBounds(0, 0, 800, 450);

        getContentPane().add(PanelPerson);
        PanelPerson.setBounds(0, 0, 800, 450);

        PanelJuego.setLayout(null);

        Tarjeta.setBackground(java.awt.Color.orange);
        Tarjeta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        Tarjeta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Tarjeta.setLayout(null);

        IMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Agro.png"))); // NOI18N
        Tarjeta.add(IMG);
        IMG.setBounds(40, 100, 230, 230);

        TEXTO.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        TEXTO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TEXTO.setText("<html>El ganado del pueblo se ha revolucionado  contra los granjeros, ¿quieres mandar a tu ejercito a ayudarlos?<html>");
        TEXTO.setToolTipText("");
        TEXTO.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        Tarjeta.add(TEXTO);
        TEXTO.setBounds(30, 10, 250, 90);

        No.setText("NO");
        No.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoActionPerformed(evt);
            }
        });
        Tarjeta.add(No);
        No.setBounds(60, 360, 60, 23);

        Si.setText("SÍ");
        Si.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiActionPerformed(evt);
            }
        });
        Tarjeta.add(Si);
        Si.setBounds(193, 360, 50, 23);

        PanelJuego.add(Tarjeta);
        Tarjeta.setBounds(230, 20, 300, 410);

        jButton4.setBackground(new java.awt.Color(102, 102, 255));
        jButton4.setFont(new java.awt.Font("Karmatic Arcade", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("SALIR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        PanelJuego.add(jButton4);
        jButton4.setBounds(10, 410, 100, 30);

        JLScore.setBackground(new java.awt.Color(255, 255, 255));
        JLScore.setFont(new java.awt.Font("Karmatic Arcade", 0, 14)); // NOI18N
        JLScore.setForeground(new java.awt.Color(255, 255, 255));
        JLScore.setText("00");
        JLScore.setToolTipText("");
        PanelJuego.add(JLScore);
        JLScore.setBounds(730, 50, 40, 20);

        JLI.setFont(new java.awt.Font("Karmatic Arcade", 0, 14)); // NOI18N
        JLI.setForeground(new java.awt.Color(255, 255, 255));
        JLI.setText("50");
        PanelJuego.add(JLI);
        JLI.setBounds(700, 200, 50, 30);

        JLB.setFont(new java.awt.Font("Karmatic Arcade", 0, 14)); // NOI18N
        JLB.setForeground(new java.awt.Color(255, 255, 255));
        JLB.setText("50");
        PanelJuego.add(JLB);
        JLB.setBounds(700, 360, 50, 30);

        JLG.setFont(new java.awt.Font("Karmatic Arcade", 0, 14)); // NOI18N
        JLG.setForeground(new java.awt.Color(255, 255, 255));
        JLG.setText("50");
        PanelJuego.add(JLG);
        JLG.setBounds(600, 200, 60, 30);

        JLM.setFont(new java.awt.Font("Karmatic Arcade", 0, 14)); // NOI18N
        JLM.setForeground(new java.awt.Color(255, 255, 255));
        JLM.setText("50");
        PanelJuego.add(JLM);
        JLM.setBounds(600, 360, 60, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/PlantillaLazer.png"))); // NOI18N
        PanelJuego.add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 450);

        getContentPane().add(PanelJuego);
        PanelJuego.setBounds(0, 0, 800, 450);

        PanelFinal.setMaximumSize(new java.awt.Dimension(800, 450));
        PanelFinal.setMinimumSize(new java.awt.Dimension(800, 450));
        PanelFinal.setPreferredSize(new java.awt.Dimension(800, 450));
        PanelFinal.setLayout(null);

        JLP.setFont(new java.awt.Font("Karmatic Arcade", 0, 18)); // NOI18N
        JLP.setForeground(new java.awt.Color(255, 255, 255));
        JLP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelFinal.add(JLP);
        JLP.setBounds(140, 220, 510, 120);

        jButton3.setBackground(new java.awt.Color(102, 102, 255));
        jButton3.setFont(new java.awt.Font("Karmatic Arcade", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("ACEPTAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        PanelFinal.add(jButton3);
        jButton3.setBounds(310, 370, 180, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Perdiste.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        PanelFinal.add(jLabel3);
        jLabel3.setBounds(0, 0, 810, 450);

        getContentPane().add(PanelFinal);
        PanelFinal.setBounds(0, 0, 800, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTutorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTutorialActionPerformed
       
        //BOTÓN DEL TUTORIAL
        
        select = java.applet.Applet.newAudioClip(getClass().getResource("/Sound/select.wav"));
        select.play();
        //Establecer el contador del tutorial a 0
        contadortuto = 0;
        //Mostrar/ocultar ventanas
        PanelJuego.setVisible(false);
        PanelFinal.setVisible(false);
        PanelTuto.setVisible(true);
        PanelInicio.setVisible(false);
        PanelPerson.setVisible(false);

        
        
        BTutorial1.setVisible(false);
        BInicio1.setVisible(false);
        BPersonalizar1.setVisible(false);
        Bsalir1.setVisible(false);
        Jtuto1.setVisible(false);
        Jtuto.setVisible(true);
        Jtuto2.setVisible(false);
        Tarjeta1.setVisible(false);
        tuto = (new ImageIcon(getClass().getResource("/IMG/Inicio.png")));
        Ftuto.setIcon(tuto);
        
        
        
        
    }//GEN-LAST:event_BTutorialActionPerformed

    private void BPersonalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPersonalizarActionPerformed

        //BOTÓN PERSONALIZAR
        select = java.applet.Applet.newAudioClip(getClass().getResource("/Sound/select.wav"));
        select.play();
        PanelJuego.setVisible(false);
        PanelFinal.setVisible(false);
        PanelTuto.setVisible(false);
        PanelInicio.setVisible(false);
        PanelPerson.setVisible(true);
        
        
        
        
        
    }//GEN-LAST:event_BPersonalizarActionPerformed

    private void BsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BsalirActionPerformed
       
        //BOTÓN SALIR
        
        select = java.applet.Applet.newAudioClip(getClass().getResource("/Sound/select.wav"));
        select.play();
        System.exit(0);
        
        
    }//GEN-LAST:event_BsalirActionPerformed

    private void BInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BInicioActionPerformed

        //BOTÓN INICIO 
        
        select = java.applet.Applet.newAudioClip(getClass().getResource("/Sound/select.wav"));
        select.play();
        
        
        PanelJuego.setVisible(true);
        PanelInicio.setVisible(false);
        PanelFinal.setVisible(false);

        PanelTuto.setVisible(false);
        PanelPerson.setVisible(false);
        //RESTABLECE EL VALOR DEL SCORE
        score = 0;
        //Reinicia los valores de los parámetros
        ScoreIglesia = 50;
        ScoreMilicia = 50;
        ScoreGranja = 50;
        ScoreBurguesia = 50;
        //Establece los parámetros
        
        JLScore.setText(""+ score);
        JLI.setText(""+ ScoreIglesia);
        JLM.setText(""+ ScoreMilicia);
        JLG.setText(""+ ScoreGranja);
        JLB.setText(""+ ScoreBurguesia);
        
        
       //Instancia i, en un metodo random, para coger un valor aleatorio
        i = Random();
        //Metodo que muestra la tarjeta
        AsignarTarjeta(i);
        
        
    }//GEN-LAST:event_BInicioActionPerformed
    public int Random(){
        
        i = (int)(Math.random()*n);
        System.out.print(i);
        return i;
        
    }
     public void AsignarTarjeta(int i){
        
                //Establece el texto
                TEXTO.setText(TAJ.get(i).getTexto());
        //switch que varia el tipo según el objeto escogido aleatoriamente
        switch(TAJ.get(i).getTipo()){
            
            case 1:
                Tarjeta.setBackground(Color.ORANGE);
                
                icono = (new ImageIcon(getClass().getResource("/IMG/Agro.png")));
                IMG.setIcon(icono);
            break;
            
            case 2: 
                Tarjeta.setBackground(Color.GRAY);
                
                icono = (new ImageIcon(getClass().getResource("/IMG/Warrior.png")));
                IMG.setIcon(icono);
               
                break;
            case 3: 
                Tarjeta.setBackground(Color.PINK);
                icono = (new ImageIcon(getClass().getResource("/IMG/Priest.png")));
                IMG.setIcon(icono);
                break;
            case 4: 
                Tarjeta.setBackground(Color.LIGHT_GRAY);
                icono = (new ImageIcon(getClass().getResource("/IMG/Burgues.png")));
                IMG.setIcon(icono);
                break;
     
        }
        
        
        
        
        
        
        
    }
    private void SiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiActionPerformed
        
        //BOTÓN SI 
        select = java.applet.Applet.newAudioClip(getClass().getResource("/Sound/select.wav"));
        select.play();
        
        //Contador de score
        JLScore.setText(""+ (score+=1));
        //Aplicacion a los parametros
        JLI.setText(""+ (ScoreIglesia+= TAJ.get(i).getIglesia()));
        JLM.setText(""+ (ScoreMilicia+= TAJ.get(i).getMilicia()));
        JLG.setText(""+ (ScoreGranja += TAJ.get(i).getGranja()));
        JLB.setText(""+ (ScoreBurguesia += TAJ.get(i).getBurguesia()));
        //Toma una nueva tarjeta
        i = Random();
        AsignarTarjeta(i);
        //Validacion de los parametros al llegar a 0 para acabar el juego
        if(ScoreIglesia <= 0) {
        PanelJuego.setVisible(false);
        PanelInicio.setVisible(false);
        PanelPerson.setVisible(false);
        PanelFinal.setVisible(true);
        fondo.stop();
        gameover = java.applet.Applet.newAudioClip(getClass().getResource("/Sound/Major Loss.wav"));
        gameover.loop();
        JLP.setText("<html>Los padres se han vuelto hostiles y han satanizado a tu pueblo. No lograste suplir sus clerigos y ahora te impondran una cruzada<html>");

        }
        else if (ScoreMilicia <= 0){
        PanelJuego.setVisible(false);
        PanelInicio.setVisible(false);
        PanelPerson.setVisible(false);
        PanelFinal.setVisible(true);
        fondo.stop();
        gameover = java.applet.Applet.newAudioClip(getClass().getResource("/Sound/Major Loss.wav"));
        gameover.loop();
        JLP.setText("<html>Tu ejercito se ha alzado en armas contra ti. Preparate para un golpe de estado y posiblemente una dictadura<html>");
        }
        else if (ScoreGranja <=0 ){
        PanelJuego.setVisible(false);
        PanelInicio.setVisible(false);
        PanelPerson.setVisible(false);
        PanelFinal.setVisible(true);
        fondo.stop();
        gameover = java.applet.Applet.newAudioClip(getClass().getResource("/Sound/Major Loss.wav"));
        gameover.loop();
        JLP.setText("<html>Los granjeros hicieron un paro agrario tan fuerte que tu imperio ha muerto de hambre. No tienes a quien gobernar<html>");

        }
        else if (ScoreBurguesia <= 0){
            
        PanelJuego.setVisible(false);
        PanelInicio.setVisible(false);
        PanelPerson.setVisible(false);
        PanelFinal.setVisible(true);
        fondo.stop();
        gameover = java.applet.Applet.newAudioClip(getClass().getResource("/Sound/Major Loss.wav"));
        gameover.loop();
        JLP.setText("<html>Tu deuda externa esta por los cielos. Debes vender tu pais para saldar tu cuenta<html>");
        
        }
        
    }//GEN-LAST:event_SiActionPerformed

    private void NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoActionPerformed
        
        //BOTÓN NO 
        select = java.applet.Applet.newAudioClip(getClass().getResource("/Sound/select.wav"));
        select.play();
        //Contador de score
        JLScore.setText(""+ (score+=1));
        
     
        //Aplicacion a los parametros en negativo
        JLI.setText(""+ (ScoreIglesia-= TAJ.get(i).getIglesia()));
        JLM.setText(""+ (ScoreMilicia-= TAJ.get(i).getMilicia()));
        JLG.setText(""+ (ScoreGranja -= TAJ.get(i).getGranja()));
        JLB.setText(""+ (ScoreBurguesia -= TAJ.get(i).getBurguesia()));
        //Toma una nueva tarjeta
        i = Random();
        AsignarTarjeta(i);
        //Validacion de los parametros al llegar a 0 para acabar el juego
        if(ScoreIglesia <= 0) {
        PanelJuego.setVisible(false);
        PanelInicio.setVisible(false);
        PanelPerson.setVisible(false);
        PanelFinal.setVisible(true);
        fondo.stop();
        gameover = java.applet.Applet.newAudioClip(getClass().getResource("/Sound/Major Loss.wav"));
        gameover.loop();
        JLP.setText("<html>Los padres se han vuelto hostiles y han satanizado a tu pueblo. No lograste suplir sus clerigos y ahora te impondran una cruzada<html>");

        }
        else if (ScoreMilicia <= 0){
        PanelJuego.setVisible(false);
        PanelInicio.setVisible(false);
        PanelPerson.setVisible(false);
        PanelFinal.setVisible(true);
        fondo.stop();
        gameover = java.applet.Applet.newAudioClip(getClass().getResource("/Sound/Major Loss.wav"));
        gameover.loop();
        JLP.setText("<html>Tu ejercito se ha alzado en armas contra ti. Preparate para un golpe de estado y posiblemente una dictadura<html>");
        }
        else if (ScoreGranja <=0 ){
        PanelJuego.setVisible(false);
        PanelInicio.setVisible(false);
        PanelPerson.setVisible(false);
        PanelFinal.setVisible(true);
        fondo.stop();
        gameover = java.applet.Applet.newAudioClip(getClass().getResource("/Sound/Major Loss.wav"));
        gameover.loop();
        JLP.setText("<html>Los granjeros hicieron un paro agrario tan fuerte que tu imperio ha muerto de hambre, no tienes a quien gobernar<html>");

        }
        else if (ScoreBurguesia <= 0){
        PanelJuego.setVisible(false);
        PanelInicio.setVisible(false);
        PanelPerson.setVisible(false);
        PanelFinal.setVisible(true);
        fondo.stop();
        gameover = java.applet.Applet.newAudioClip(getClass().getResource("/Sound/Major Loss.wav"));
        gameover.loop();
        
        JLP.setText("<html>Tu deuda externa esta por los cielos, debes vender tu pais para saldar tu cuenta<html>");

        }

        
    }//GEN-LAST:event_NoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        //BOTÓN VOLVER
        select = java.applet.Applet.newAudioClip(getClass().getResource("/Sound/select.wav"));
        select.play();
        PanelJuego.setVisible(false);
        PanelInicio.setVisible(true);
        PanelPerson.setVisible(false);
        PanelFinal.setVisible(false);
        
        
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        //BOTÓN AGREGAR TARJETA
        select = java.applet.Applet.newAudioClip(getClass().getResource("/Sound/select.wav"));
        select.play();
        
        Granja ObG;
        Milicia ObM;
        Iglesia ObI;
        Burguesia ObB;
        String tipoP;
        String textoP;
        int xgranja;
        int xiglesia;
        int xmilicia;
        int xburguesia;
        int tipo;
        
        
        //try{
            
        
        tipoP = jComboBox1.getSelectedItem().toString();
        textoP = "<html>"+TextoP.getText()+"<html>";
        
        //do{
             xgranja = Integer.parseInt(JTGranja.getText());
        //}while(xgranja>-20 && xgranja<20);
        //do{
            xiglesia = Integer.parseInt(JTIglesia.getText());
        //}while(xiglesia>-20 && xiglesia<20);
        //do{
            xmilicia = Integer.parseInt(JTMilicia.getText());
        //}while(xmilicia>-20 && xmilicia<20);
        //do{
            xburguesia = Integer.parseInt(JTBurguesia.getText());
        //}while(xburguesia>-20 && xburguesia<20);

        
        //Creación de los objetos
        
        switch(tipoP){
            case "Granja":
                icono = (new ImageIcon(getClass().getResource("/IMG/Agro.png")));
                IMGP.setIcon(icono);
                tipo = 1;
                ObG = new Granja(textoP,xgranja,xmilicia,xiglesia,xburguesia,tipo);
                TAJ.add(ObG);
                
                break;
            case "Milicia":
                icono = (new ImageIcon(getClass().getResource("/IMG/Warrior.png")));
                IMGP.setIcon(icono);
                tipo = 2;
                ObM = new Milicia(textoP,xgranja,xmilicia,xiglesia,xburguesia,tipo);
                TAJ.add(ObM);
                break;
            case "Iglesia":
                icono = (new ImageIcon(getClass().getResource("/IMG/Priest.png")));
                IMGP.setIcon(icono);
                tipo = 3;
                ObI = new Iglesia(textoP,xgranja,xmilicia,xiglesia,xburguesia,tipo);
                TAJ.add(ObI);
                break;
            case "Burguesia":
                icono = (new ImageIcon(getClass().getResource("/IMG/Burgues.png")));
                IMGP.setIcon(icono);
                tipo = 4;
                ObB = new Burguesia(textoP,xgranja,xmilicia,xiglesia,xburguesia,tipo);
                TAJ.add(ObB);
                break;
        }
        
      
      //Aumento en la n   
        Acumulan();
        
        
        //Limpiar campos
        jComboBox1.setSelectedIndex(0);
        TextoP.setText("");
        JTGranja.setText("");
        JTMilicia.setText("");
        JTIglesia.setText("");
        JTBurguesia.setText("");
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public void Acumulan(){
        
        n += 1;
   
    }
    
    
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       //CAMBIAR LA IMAGEN AL SELECCIONAR X FACCIÓN
        String tipoP;
       tipoP = jComboBox1.getSelectedItem().toString();
       
         switch(tipoP){
            case "Granja":
                icono = (new ImageIcon(getClass().getResource("/IMG/Agro.png")));
                IMGP.setIcon(icono);
                
                
                break;
            case "Milicia":
                icono = (new ImageIcon(getClass().getResource("/IMG/Warrior.png")));
                IMGP.setIcon(icono);
               
                break;
            case "Iglesia":
                icono = (new ImageIcon(getClass().getResource("/IMG/Priest.png")));
                IMGP.setIcon(icono);
                
                break;
            case "Burguesia":
                icono = (new ImageIcon(getClass().getResource("/IMG/Burgues.png")));
                IMGP.setIcon(icono);
                
                
                break;
        }
       
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       //Volver al menú 
        select = java.applet.Applet.newAudioClip(getClass().getResource("/Sound/select.wav"));
        select.play();
        gameover.stop();
        fondo.loop();
        PanelJuego.setVisible(false);
        PanelPerson.setVisible(false);
        PanelInicio.setVisible(true);
        PanelFinal.setVisible(false);
        
        
        
        //Comparación de la puntuacion actual con la maxima puntuacion guardada en un file
        String Cadena = "";
        
        
       if (score>HS){
            
            HS = score;
            
           CadHS = ""+ HS;
            
             try {
        
        FW = new FileWriter("ListaScore.txt");
        PW = new PrintWriter(FW);
        

       

        PW.print(CadHS);
        
        FW.close();
        PW.close();
        
        } catch(Throwable e){ System.out.print(e);}
        
        try {
        
        F = new File("ListaScore.txt");
        FR = new FileReader(F);
        BR = new BufferedReader(FR);
    
        while((Cadena = BR.readLine())!= null)
            
            JHS.setText(Cadena);

        } catch(Throwable e){System.out.print(e);}
        
        
        }
       
        
        
        
        
        

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       //volver al menú
        select = java.applet.Applet.newAudioClip(getClass().getResource("/Sound/select.wav"));
        select.play();
        PanelJuego.setVisible(false);
        PanelPerson.setVisible(false);
        PanelInicio.setVisible(true);
        PanelFinal.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void BTutorial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTutorial1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTutorial1ActionPerformed

    private void BPersonalizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPersonalizar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BPersonalizar1ActionPerformed

    private void Bsalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bsalir1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Bsalir1ActionPerformed

    private void BInicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BInicio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BInicio1ActionPerformed

    private void FtutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FtutoMouseClicked
       //Pasa pantalla 
        select.play();
        
        
        switch(contadortuto){
            case 0: 
                BInicio1.setVisible(true);
                BTutorial1.setVisible(false);
                BPersonalizar1.setVisible(false);
                Bsalir1.setVisible(false);
                Jtuto1.setVisible(true);
                Jtuto2.setVisible(false);
                Jtuto1.setText("<html>Este es el boton de inicio, usalo para empezar una nueva partida<html>");
                
        break;
            case 1:
                BInicio1.setVisible(false);
                BTutorial1.setVisible(true);
                BPersonalizar1.setVisible(false);
                Bsalir1.setVisible(false);;
            Jtuto1.setText("<html>Este es el boton de tutorial, es donde estas ahora mismo<html>");
        break;
            case 2: BInicio1.setVisible(false);
                BTutorial1.setVisible(false);
                BPersonalizar1.setVisible(true);
                Bsalir1.setVisible(false);
            Jtuto1.setText("<html>Este es el boton de personalizar, entra ahi para personlazar tu juego <html>");
        break;          
            case 3: 
                BInicio1.setVisible(false);
                BTutorial1.setVisible(false);
                BPersonalizar1.setVisible(false);
                Bsalir1.setVisible(true);
            Jtuto1.setText("<html>Este es el boton de salir, oprimelo para terminar el juego<html>");
        break;
            case 4: 
                BInicio1.setVisible(true);
                BTutorial1.setVisible(true);
                BPersonalizar1.setVisible(true);
                Bsalir1.setVisible(true);
                Jtuto1.setText("<html>vamos a ver como funciona el juego<html>");
        break;
            case 5: 
                
                BTutorial1.setVisible(false);
                 BInicio1.setVisible(false);
                 BPersonalizar1.setVisible(false);
                 Bsalir1.setVisible(false);
                Jtuto1.setVisible(false);
                Jtuto.setVisible(false);
                Jtuto2.setVisible(true);
                
                Jtuto2.setText("<html>éste es un juego de decisiones, conviértete en rey y lidera tu pueblo<html>");
                
                
                tuto = (new ImageIcon(getClass().getResource("/IMG/PlantillaLazer.png")));
                Ftuto.setIcon(tuto);
                
        break;
            case 6: 
                
                No1.setVisible(false);
                Si1.setVisible(false);
                Tarjeta1.setVisible(true);
                Jtuto2.setText("<html>Se te presentarán casos, en donde tienes que tomar una decision<html>");
                
                
                
        break;
            case 7: Jtuto2.setText("<html>Por ejemplo...<html>");
        break;
            case 8: Jtuto2.setText("<html>Los campesinos de tu pueblo se han perdido, ¿deseas llevar a la milicia a buscarlos?<html>");
                break; 
            case 9: Jtuto2.setText("<html>Puedes decidir entre sí...<html>");
                    
                    Si1.setVisible(true);
                break;
            case 10: Jtuto2.setText("<html>O no<html>");
                     No1.setVisible(true);
                     break;
            case 11: 
                    Jtuto2.setText("<html>Dependiendo de tu decisión, el juego tomará un rumbo <html>");
                    break; 
            case 12: Jtuto2.setText("<html>Existen 4 facciones...<html>");
            break;
            case 13: 
                    
                    Tarjeta1.setBackground(Color.LIGHT_GRAY);
                    icono = (new ImageIcon(getClass().getResource("/IMG/Burgues.png")));
                    IMG1.setIcon(icono);
                    
                    Jtuto2.setText("<html>'Burguesía'<html>");
                break;
                case 14:
                    
                    
                Tarjeta1.setBackground(Color.PINK);
                    icono = (new ImageIcon(getClass().getResource("/IMG/Priest.png")));
                IMG1.setIcon(icono);
                Jtuto2.setText("<html>'Iglesia'<html>");
                break;
                case 15: 
                   
                Tarjeta1.setBackground(Color.GRAY);
                    icono = (new ImageIcon(getClass().getResource("/IMG/Warrior.png")));
                IMG1.setIcon(icono);
                Jtuto2.setText("<html>'Milicia'<html>");
                break;
                case 16:
                    
                    
                Tarjeta1.setBackground(Color.ORANGE);
                    icono = (new ImageIcon(getClass().getResource("/IMG/Agro.png")));
                IMG1.setIcon(icono);
                Jtuto2.setText("<html>y 'Granja'<html>");
                break;
                case 17: Jtuto2.setText("<html>Por cada decisión que tomes, será un mes transcurrido en tu mandato<html>");
                break;
                case 18:
                    Jtuto2.setText("<html>y tu puntuación se sumará en 1 <html>");
                    break; 
                case 19: Jtuto2.setText("<html>Ahora estás preparado<html>");
                Tarjeta1.setVisible(false);
                break;
                case 20: Jtuto2.setText("<html>Juega y obtén la mayor puntuación <html>");
                break;
                case 21: 
                    Jtuto2.setText("<html>y recuerda, cada decisión cuenta <html>");
                    break;
                case 22: 
                    PanelJuego.setVisible(false);
                    PanelFinal.setVisible(false);
                    PanelTuto.setVisible(false);
                    PanelInicio.setVisible(true);
                    PanelPerson.setVisible(false);
                    break;
                
        }
        
        
        
        
        
        
        contadortuto = contadortuto + 1;

        
    }//GEN-LAST:event_FtutoMouseClicked

    private void No1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_No1ActionPerformed

    private void Si1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Si1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Si1ActionPerformed
    
   
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BInicio;
    private javax.swing.JButton BInicio1;
    private javax.swing.JButton BPersonalizar;
    private javax.swing.JButton BPersonalizar1;
    private javax.swing.JButton BTutorial;
    private javax.swing.JButton BTutorial1;
    private javax.swing.JButton Bsalir;
    private javax.swing.JButton Bsalir1;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Ftuto;
    private javax.swing.JLabel IMG;
    private javax.swing.JLabel IMG1;
    private javax.swing.JLabel IMGP;
    private javax.swing.JLabel JHS;
    private javax.swing.JLabel JHS1;
    private javax.swing.JLabel JLB;
    private javax.swing.JLabel JLG;
    private javax.swing.JLabel JLI;
    private javax.swing.JLabel JLM;
    private javax.swing.JLabel JLP;
    private javax.swing.JLabel JLScore;
    private javax.swing.JTextField JTBurguesia;
    private javax.swing.JTextField JTGranja;
    private javax.swing.JTextField JTIglesia;
    private javax.swing.JTextField JTMilicia;
    private javax.swing.JLabel Jtuto;
    private javax.swing.JLabel Jtuto1;
    private javax.swing.JLabel Jtuto2;
    private javax.swing.JButton No;
    private javax.swing.JButton No1;
    private javax.swing.JPanel PanelFinal;
    private javax.swing.JPanel PanelInicio;
    private javax.swing.JPanel PanelJuego;
    private javax.swing.JPanel PanelPerson;
    private javax.swing.JPanel PanelTuto;
    private javax.swing.JButton Si;
    private javax.swing.JButton Si1;
    private javax.swing.JLabel TEXTO;
    private javax.swing.JPanel Tarjeta;
    private javax.swing.JPanel Tarjeta1;
    private javax.swing.JTextField TextoP;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
