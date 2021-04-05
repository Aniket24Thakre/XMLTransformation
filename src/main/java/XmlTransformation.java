package main.java;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.Scanner;

public class XmlTransformation {
    public static void main (String [] args) throws IOException{
        File inputXsltFile;
        FileInputStream inputXmlFile = null;
        OutputStream outputXML;
        String filesPath ="C:\\Users\\aniket.thakre\\Task\\XML-To-XML-Transform\\";

        System.out.println("Enter InputXsltFile Name");
        Scanner inputXsltfile = new Scanner(new InputStreamReader(System.in));
        String xsltFileName = inputXsltfile.nextLine();

        System.out.println("Enter InputXMLFile Name");
        Scanner inputXMLFilename = new Scanner(new InputStreamReader(System.in));
        String xmlFileName = inputXMLFilename.nextLine();

        System.out.println("Enter OutputXMLFile Name");
        Scanner outputXMLFilename = new Scanner(new InputStreamReader(System.in));
        String outXmlFileName = outputXMLFilename.nextLine();
        outputXML = new FileOutputStream(filesPath+outXmlFileName);

        Result res = new StreamResult(outputXML);
        try {
            inputXsltFile = new File(filesPath+xsltFileName);
            inputXmlFile = new FileInputStream(filesPath+xmlFileName);
            StreamSource xmlStream = new StreamSource(inputXmlFile);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transform = factory.newTransformer(new StreamSource(inputXsltFile));
            transform.transform(xmlStream, res);
        }
        catch (TransformerException | FileNotFoundException exception){
            exception.printStackTrace();
        }
        finally {
            inputXmlFile.close();
            outputXML.close();
        }
    }
}

