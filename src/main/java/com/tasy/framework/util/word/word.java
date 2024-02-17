package com.tasy.framework.util.word;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class word {

    private boolean Status;
    private List<String> Paso;
    private String Modulo;
    private String Perfil;
    private String Tester;
    private String Paquete;
    private String Caso;


    public word(List<String> paso, String modulo, String perfil, String tester, String paquete, String caso, boolean status) throws XmlException, IOException {
        this.Paso = paso;
        this.Modulo = modulo;
        this.Perfil = perfil;
        this.Tester = tester;
        this.Paquete = paquete;
        this.Caso = caso;
        this.Status = status;
        saveTextToWordDocument();
    }

    public void saveTextToWordDocument() throws IOException, XmlException {

        creacionCarpeta(Paquete);

        System.out.println("Document Name is : " + Caso);

        //Create Instance for document, paragraphs, Styles
        XWPFDocument doc = new XWPFDocument();// document object
        XWPFParagraph p = doc.createParagraph();//paragraph allignments, borders
        XWPFRun r = p.createRun();//Set font styles, colors, next line


        //Header and Footer obj
        CTSectPr sectPr = doc.getDocument().getBody().addNewSectPr();
        XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(doc, sectPr);

        // Creating Header objects
        CTP ctpHeader = CTP.Factory.newInstance();
        CTR ctrHeader = ctpHeader.addNewR();
        CTText ctHeader = ctrHeader.addNewT();

        // Alignments and color, styles of the header in the word doc -- Header
        XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeader, doc);
        XWPFRun headerRun = headerParagraph.createRun();

        //Setting Header
        headerParagraph.setAlignment(ParagraphAlignment.LEFT);
        headerRun.setFontSize(10);
        headerRun.setColor("808000");
        headerRun.setText("Tasy 1823 - Regression.");
        headerRun.addBreak();
        String curr_date = getCurrentDate("yyyy-MM-dd-hh:mm:ss");
        headerRun.setText(curr_date);

        //Parse
        XWPFParagraph[] parsHeader = new XWPFParagraph[1];
        parsHeader[0] = headerParagraph;
        policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT, parsHeader);

        //Create Footer Objects
        CTP ctpFooter = CTP.Factory.newInstance();
        CTR ctrFooter = ctpFooter.addNewR();
        CTText ctFooter = ctrFooter.addNewT();

        //Setting Footer
        String footerText = "� 2021. Confidential - Do not Share this documents.";
        ctFooter.setStringValue(footerText);

        // Alignments and color, styles of the header in the word doc -- Footer
        XWPFParagraph footerparagraph = new XWPFParagraph(ctpFooter, doc);
        footerparagraph.setAlignment(ParagraphAlignment.LEFT);

        //Parse
        XWPFParagraph[] parsFooter = new XWPFParagraph[1];
        parsFooter[0] = footerparagraph;
        policy.createFooter(XWPFHeaderFooterPolicy.DEFAULT, parsFooter);//Corrected to Footer

        //Title in the center ( Test Scenraio Name )
        p.setAlignment(ParagraphAlignment.CENTER);
        r.setBold(true);
        r.setFontFamily("Arial");
        r.setText("Evidencia de Pruebas");
        r.addBreak();
        r.setText("Datos de Prueba");
        r.addBreak();

        ////////////////////////////////////////////////////////
        //Se crean los datos ///

        //Se crear los datos de prueba.
        //Create Intance for document, paragraphs, Styles para los datos del encabezado
        XWPFParagraph pDatos = doc.createParagraph();
        pDatos.setPageBreak(false);
        XWPFRun rDatos = pDatos.createRun();


        pDatos.setAlignment(ParagraphAlignment.LEFT);
        pDatos.setAlignment(ParagraphAlignment.START);
        rDatos.setFontFamily("Arial");
        rDatos.setFontSize(10);
        rDatos.setBold(true);
        rDatos.setText("Fecha:" + getCurrentDate("yyyy-MM-dd"));
        rDatos.addBreak();
        rDatos.setText("Aplicación: Tasy");
        rDatos.addBreak();
        rDatos.setText("Módulo:" + Modulo + "");
        rDatos.addBreak();
        rDatos.setText("Perfil: " + Perfil + "");
        rDatos.addBreak();
        rDatos.setText("Caso de Pruebas: " + Caso + "");
        rDatos.addBreak();
        rDatos.setText("Nombre de Tester: " + Tester + "");
        rDatos.addBreak();
        if (Status) {
            rDatos.setText("Estatus: Pasado");
        } else {
            rDatos.setText("Estatus: Fallado");
        }
        rDatos.addBreak();

        ///////////////////////////////////////////////////////////
        //En esta parte se crean los pasos para el Word///

        //Create Intance for document, paragraphs, Styles para los pasos
        XWPFParagraph pPasos = doc.createParagraph();
        pPasos.setPageBreak(false);
        XWPFRun rPasos = pPasos.createRun();

        //Pasos Style.
        pPasos.setAlignment(ParagraphAlignment.LEFT);
        pDatos.setAlignment(ParagraphAlignment.START);
        rPasos.setBold(false);
        rPasos.setFontFamily("Arial");
        rPasos.setFontSize(9);

        for (String paso : Paso) {
            try {
                rPasos.addBreak();
                rPasos.setText(paso);
                rPasos.addBreak();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        //Formato de Imagen
        XWPFParagraph pImagen = doc.createParagraph();
        pImagen.setAlignment(ParagraphAlignment.CENTER);
        pImagen.setPageBreak(true);
        XWPFRun rImagen = pImagen.createRun();

        try {
            File dest = new File(System.getProperty("user.dir") + "\\TestResults\\" + Paquete + "\\" + Caso + ".jpg");

            int width = 500;
            int height = 280;
            String imgFile = dest.getName();
            int imgFormat = getImageFormat(imgFile);

            rImagen.addBreak();
            rImagen.addPicture(new FileInputStream(dest), imgFormat, imgFile, Units.toEMU(width), Units.toEMU(height));
            rImagen.addBreak();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());

        }
        rPasos.addBreak();
        FileOutputStream out;
        if (Status) {
            out = new FileOutputStream(System.getProperty("user.dir") + "\\TestResults\\" + Paquete + "\\" + Caso + "_Pasado.doc");
        } else {
            out = new FileOutputStream(System.getProperty("user.dir") + "\\TestResults\\" + Paquete + "\\" + Caso + "_Fallado.doc");
        }
        doc.write(out);
        out.close();
        System.out.println("Word document with screenshots created successfully");
    }

    private static int getImageFormat(String imgFileName) {
        int format;
        if (imgFileName.endsWith(".emf"))
            format = XWPFDocument.PICTURE_TYPE_EMF;
        else if (imgFileName.endsWith(".wmf"))
            format = XWPFDocument.PICTURE_TYPE_WMF;
        else if (imgFileName.endsWith(".pict"))
            format = XWPFDocument.PICTURE_TYPE_PICT;
        else if (imgFileName.endsWith(".jpeg") || imgFileName.endsWith(".jpg"))
            format = XWPFDocument.PICTURE_TYPE_JPEG;
        else if (imgFileName.endsWith(".png"))
            format = XWPFDocument.PICTURE_TYPE_PNG;
        else if (imgFileName.endsWith(".dib"))
            format = XWPFDocument.PICTURE_TYPE_DIB;
        else if (imgFileName.endsWith(".gif"))
            format = XWPFDocument.PICTURE_TYPE_GIF;
        else if (imgFileName.endsWith(".tiff"))
            format = XWPFDocument.PICTURE_TYPE_TIFF;
        else if (imgFileName.endsWith(".eps"))
            format = XWPFDocument.PICTURE_TYPE_EPS;
        else if (imgFileName.endsWith(".bmp"))
            format = XWPFDocument.PICTURE_TYPE_BMP;
        else if (imgFileName.endsWith(".wpg"))
            format = XWPFDocument.PICTURE_TYPE_WPG;
        else {
            return 0;
        }
        return format;
    }

    private static String getCurrentDate(String format) {
        DateFormat dateformat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateformat.format(date);

    }

    private static void creacionCarpeta(String paquete) {
        File carpeta = new File(System.getProperty("user.dir") + "\\TestResults\\" + paquete + "");
        if (!carpeta.exists()) {
            if (carpeta.mkdir()) {
                System.out.println("Carpeta Creada Correctamente");
            } else {
                System.out.println("No se pudo crear la carpeta");
            }
        } else {
            System.out.println("La carpeta ya exite");
        }

    }

}
