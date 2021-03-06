
package esignerclientjava.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="uploadSignedFileResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "uploadSignedFileResult"
})
@XmlRootElement(name = "uploadSignedFileResponse")
public class UploadSignedFileResponse {

    protected boolean uploadSignedFileResult;

    /**
     * Gets the value of the uploadSignedFileResult property.
     * 
     */
    public boolean isUploadSignedFileResult() {
        return uploadSignedFileResult;
    }

    /**
     * Sets the value of the uploadSignedFileResult property.
     * 
     */
    public void setUploadSignedFileResult(boolean value) {
        this.uploadSignedFileResult = value;
    }

}
