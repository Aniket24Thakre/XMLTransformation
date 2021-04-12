package main.java;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class XmlTransformation {
    private static final String FOLDER_PATH = "File_Location";
    private static final String PROPERTY_FILE_LOCATION ="resources\\config.properties";
    public static void main (String [] args) throws IOException{
        File inputXsltFile;
        Result result = null;
        String filesPath = null;

        System.out.println("Enter InputXsltFile Name");
        //TODO - 1
         //Replace and try
         //Instead of new Scanner(new InputStreamReader(System.in)) use new Scanner(System.in)
        Scanner inputXsltfile = new Scanner(new InputStreamReader(System.in));
        String xsltFileName = inputXsltfile.nextLine();

        System.out.println("Enter InputXMLFile Name");
        //TODO - 2
        //Replace and try
        //Instead of new Scanner(new InputStreamReader(System.in)) use new Scanner(System.in)
        Scanner inputXMLFilename = new Scanner(new InputStreamReader(System.in));
        String xmlFileName = inputXMLFilename.nextLine();

        System.out.println("Enter OutputXMLFile Name");
        //TODO - 3
        //Replace and try
        //Instead of new Scanner(new InputStreamReader(System.in)) use new Scanner(System.in)
        Scanner outputXMLFilename = new Scanner(new InputStreamReader(System.in));
        String outXmlFileName = outputXMLFilename.nextLine();

        Properties getProperties = new Properties();
        //TODO - 4
        //Please check feasibility of merging 2 try blocks into one
        try(InputStream inputStream = new FileInputStream(PROPERTY_FILE_LOCATION)){
            if(inputStream !=null){
                getProperties.load(inputStream);
                filesPath = getProperties.getProperty(FOLDER_PATH);
            }else {
                throw new FileNotFoundException("Properties file not found");
            }
            try (FileInputStream inputXmlFile = new FileInputStream(filesPath+"\\"+xmlFileName);
                 OutputStream outputXML = new FileOutputStream(filesPath+"\\"+outXmlFileName)){
                inputXsltFile = new File(filesPath + "\\" + xsltFileName);
                StreamSource xmlStream = new StreamSource(inputXmlFile);
                TransformerFactory factory = TransformerFactory.newInstance();
                Transformer transform = factory.newTransformer(new StreamSource(inputXsltFile));
                result = new StreamResult(outputXML);
                transform.transform(xmlStream, result);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

