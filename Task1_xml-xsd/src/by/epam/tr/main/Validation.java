package by.epam.tr.main;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class Validation {

	public static void main(String[] args) {
		SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
		File schemaLocation = new File("src/source/WebXMLSchema.xsd");
		Schema schema;
		try {
			schema = factory.newSchema(schemaLocation);
			Validator validator = schema.newValidator();
			Source source = new StreamSource("src/source/web.xml");
			
			try {
				validator.validate(source);
				System.out.println("Is valid");
			} catch (SAXException | IOException e) {
				System.out.println("Is not valid because ");
				System.out.println(e.getMessage());
			}
		} catch (SAXException e1) {
			
			e1.printStackTrace();
		}
		
		

	}

}
