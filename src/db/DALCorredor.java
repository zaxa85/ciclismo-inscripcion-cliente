/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import core.BeanCorredor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Pablo Sierralta
 */
public class DALCorredor {

    private static String getNodeValue(String strArg, Element eCorredor) {
        Node nValue = (Node) eCorredor.getElementsByTagName(strArg).item(0).getFirstChild();
        return nValue.getNodeValue();
    }

    public ArrayList<BeanCorredor> obtenerCorredor() {

        ArrayList<BeanCorredor> listaCorredor = new ArrayList<>();
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse("xml/database.xml");
            doc.getDocumentElement().normalize();

            NodeList nodosCorredor = doc.getElementsByTagName("corredor");

            for (int i = 0; i < nodosCorredor.getLength(); i++) {
                Node corredor = nodosCorredor.item(i);

                if (corredor.getNodeType() == Node.ELEMENT_NODE) {
                    Element unElemento = (Element) corredor;

                    BeanCorredor objCorredor = new BeanCorredor();
                    objCorredor.setDni(getNodeValue("dni", unElemento));

                }
            }

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException saxe) {
            saxe.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }

        return listaCorredor;
    }

    public void agregarCorredor(BeanCorredor objCorredor) {

        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.parse(new File("xml/database.xml"));
            doc.getDocumentElement().normalize();

            Node nodosCorredor = doc.getDocumentElement();

            Element nuevoCorredor = doc.createElement("corredor");

            Element nuevoDNICorredor = doc.createElement("dni");
            nuevoDNICorredor.setTextContent(objCorredor.getDni());

            Element nuevoNombreCorredor = doc.createElement("nombre");
            nuevoNombreCorredor.setTextContent(objCorredor.getNombre());

            Element nuevoApellidoCorredor = doc.createElement("apellido");
            nuevoApellidoCorredor.setTextContent(objCorredor.getApellido());

            Element nuevoEdadCorredor = doc.createElement("edad");
            nuevoEdadCorredor.setTextContent(objCorredor.getEdad() + "");

            Element nuevoFechaNacimientoCorredor = doc.createElement("fechaNacimiento");
            nuevoFechaNacimientoCorredor.setTextContent(objCorredor.getFechaNacimiento() + "");

            Element nuevoDepartamentoOrigenCorredor = doc.createElement("departamentoOrigen");
            nuevoDepartamentoOrigenCorredor.setTextContent(objCorredor.getDepartamentoOrigen());

            Element nuevoDepartamentoPuntuaCorredor = doc.createElement("departamentoPuntua");
            nuevoDepartamentoPuntuaCorredor.setTextContent(objCorredor.getDepartamentoPuntua());

            Element nuevoNumeroCompetenciaCorredor = doc.createElement("numeroCompetencia");
            nuevoNumeroCompetenciaCorredor.setTextContent(objCorredor.getNumeroCompetencia());

            nuevoCorredor.appendChild(nuevoDNICorredor);
            nuevoCorredor.appendChild(nuevoNombreCorredor);
            nuevoCorredor.appendChild(nuevoApellidoCorredor);
            nuevoCorredor.appendChild(nuevoEdadCorredor);
            nuevoCorredor.appendChild(nuevoFechaNacimientoCorredor);
            nuevoCorredor.appendChild(nuevoDepartamentoOrigenCorredor);
            nuevoCorredor.appendChild(nuevoDepartamentoPuntuaCorredor);
            nuevoCorredor.appendChild(nuevoNumeroCompetenciaCorredor);

            nodosCorredor.appendChild(nuevoCorredor);

            TransformerFactory transFact = TransformerFactory.newInstance();
            Transformer trans = transFact.newTransformer();
            DOMSource domSource = new DOMSource(doc);

            StreamResult result = new StreamResult(new File("xml/database.xml"));

            trans.transform(domSource, result);

        } catch (ParserConfigurationException pce) {
        } catch (SAXException saxe) {
        } catch (IOException io) {
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(DALCorredor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(DALCorredor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
