package main.java;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class XmlTransformation {
     public static void main (String [] args) throws IOException, TransformerException {
         File inputXsltFile = new File("InputFiles\\InputXslt.xsl");
         File inputXmlFile = new File("InputFiles\\InputXml.xml");
         OutputStream outputXML = new FileOutputStream("InputFiles\\OutputXml.xml");
         StreamSource xmlStream = new StreamSource(inputXmlFile);
         Result res = new StreamResult(outputXML);
         try {
             TransformerFactory factory = TransformerFactory.newInstance();
             Transformer transform = factory.newTransformer(new StreamSource(inputXsltFile));
             transform.transform(xmlStream, res);
         }
         finally {
             outputXML.close();
         }
     }
}
