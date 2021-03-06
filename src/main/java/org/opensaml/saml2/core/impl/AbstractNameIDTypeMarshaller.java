/*
 * Copyright [2005] [University Corporation for Advanced Internet Development, Inc.]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.opensaml.saml2.core.impl;

import org.opensaml.common.impl.AbstractSAMLObjectMarshaller;
import org.opensaml.saml2.core.NameID;
import org.opensaml.saml2.core.NameIDType;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.io.MarshallingException;
import org.opensaml.xml.util.XMLHelper;
import org.w3c.dom.Element;

/**
 * A thread safe Marshaller for {@link org.opensaml.saml2.core.NameIDType} objects.
 */
public abstract class AbstractNameIDTypeMarshaller extends AbstractSAMLObjectMarshaller {

    /** Constructor. */
    protected AbstractNameIDTypeMarshaller(){
        super();
    }
    
    /**
     * Constructor.
     * 
     * @param namespaceURI the namespace URI of either the schema type QName or element QName of the elements this
     *            marshaller operates on
     * @param elementLocalName the local name of either the schema type QName or element QName of the elements this
     *            marshaller operates on
     * 
     * @throws NullPointerException if any of the arguments are null (or empty in the case of String parameters)
     */
    protected AbstractNameIDTypeMarshaller(String namespaceURI, String elementLocalName) {
        super(namespaceURI, elementLocalName);
    }

    /** {@inheritDoc} */
    protected void marshallAttributes(XMLObject samlObject, Element domElement) throws MarshallingException {
        NameIDType nameID = (NameIDType) samlObject;

        if (nameID.getNameQualifier() != null) {
            domElement.setAttributeNS(null, NameID.NAME_QUALIFIER_ATTRIB_NAME, nameID.getNameQualifier());
        }

        if (nameID.getSPNameQualifier() != null) {
            domElement.setAttributeNS(null, NameID.SP_NAME_QUALIFIER_ATTRIB_NAME, nameID.getSPNameQualifier());
        }

        if (nameID.getFormat() != null) {
            domElement.setAttributeNS(null, NameID.FORMAT_ATTRIB_NAME, nameID.getFormat());
        }

        if (nameID.getSPProvidedID() != null) {
            domElement.setAttributeNS(null, NameID.SPPROVIDED_ID_ATTRIB_NAME, nameID.getSPProvidedID());
        }
    }

    /** {@inheritDoc} */
    protected void marshallElementContent(XMLObject samlObject, Element domElement) throws MarshallingException {
        NameIDType nameID = (NameIDType) samlObject;
        XMLHelper.appendTextContent(domElement, nameID.getValue());
    }
}