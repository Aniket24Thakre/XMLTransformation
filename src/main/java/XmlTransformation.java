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
    public static void main (String [] args){

        File inputXsltFile;
        Result result = null;
        String filesPath = null;

        System.out.println("Enter InputXsltFile Name");
        Scanner inputXSLTFile = new Scanner(System.in);
        String xsltFileName = inputXSLTFile.nextLine();

        System.out.println("Enter InputXMLFile Name");
        Scanner inputXMLFilename = new Scanner(System.in);
        String xmlFileName = inputXMLFilename.nextLine();

        System.out.println("Enter OutputXMLFile Name");
        Scanner outputXMLFilename = new Scanner(System.in);
        String outXmlFileName = outputXMLFilename.nextLine();

        Properties getProperties = new Properties();
        try(InputStream inputStream = new FileInputStream(PROPERTY_FILE_LOCATION);
            FileInputStream inputXmlFile = new FileInputStream(getFileLocation(getProperties,inputStream)+"\\"+xmlFileName);
            OutputStream outputXML = new FileOutputStream(getFileLocation(getProperties,inputStream)+"\\"+outXmlFileName)){
            inputXsltFile = new File(getFileLocation(getProperties,inputStream) + "\\" + xsltFileName);
            StreamSource xmlStream = new StreamSource(inputXmlFile);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transform = factory.newTransformer(new StreamSource(inputXsltFile));
            result = new StreamResult(outputXML);
            transform.transform(xmlStream, result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static String getFileLocation(Properties properties,InputStream inPut) throws IOException {
        String filePath;
        if(inPut !=null){
            properties.load(inPut);
            filePath = properties.getProperty(FOLDER_PATH);
        }else {
            throw new FileNotFoundException("Property File not Found");
        }
        return filePath;
    }
}

