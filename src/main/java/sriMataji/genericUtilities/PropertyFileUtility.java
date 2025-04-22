package sriMataji.genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This is for reading PropertyFile
 */
public class PropertyFileUtility {

	
	public String readDataFromPropertyFile(String key) throws IOException {
		
		Properties pObj= new Properties();
		FileInputStream fisP=new FileInputStream(IConstantUtility.propertyFilePath);
		try {
			pObj.load(fisP);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value= pObj.getProperty(key);
	
		return value;
		
		/**
		 * FileInputStream reads the .properties file from the path specified by IConstantsUtility.propertyFilePath.
           The load method of Properties loads the file content into a Properties object.
           getProperty(key) retrieves the value for a given key, such as "username" or "url".
		 */
	}	
	
}
