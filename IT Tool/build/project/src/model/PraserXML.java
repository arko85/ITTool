package model;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class PraserXML {
	String textPraser = null;
public void prase(String path){


      try {
         File inputFile = new File(path);
         DocumentBuilderFactory dbFactory
            = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();

         StringBuilder text = new StringBuilder("");

         text.append("Type :"
            + doc.getDocumentElement().getNodeName()+"\n");

		text.append(doc.getElementsByTagName("OrderReference").item(0).getTextContent()+"\n");
		text.append("MarkIT order number: "+doc.getElementsByTagName("OrderNumber").item(0).getTextContent()+"\n");
		text.append("Order Date: "+doc.getElementsByTagName("OrderDate").item(0).getTextContent()+"\n");
		text.append("Decision-maker:   \nDestination:  "+"\n");

         NodeList nList = doc.getElementsByTagName("OrderLine");
         text.append("----------------------------"+"\n");

         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            text.append("\n"+nNode.getNodeName()+" "+temp+"\n---------"+"\n");

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               text.append("PN : "
                  + eElement
                  .getElementsByTagName("ManufPN")
                  .item(0)
                  .getTextContent()+"\n");
               text.append("Name : "
               + eElement
                  .getElementsByTagName("Name")
                  .item(0)
                  .getTextContent()+"\n");
               text.append("Quantity : "
               + eElement
                  .getElementsByTagName("Quantity")
                  .item(0)
                  .getTextContent()+"\n");
               text.append("Delivery date : "
               + eElement
                  .getElementsByTagName("DeliveryDate")
                  .item(0)
                  .getTextContent()+"\n");
            }
            textPraser=text.toString();
         }
      } catch (Exception e) {
         e.printStackTrace();
      }

   }
/**
 * @return the textPraser
 */
public String getTextPraser() {


	return textPraser;
}
}
