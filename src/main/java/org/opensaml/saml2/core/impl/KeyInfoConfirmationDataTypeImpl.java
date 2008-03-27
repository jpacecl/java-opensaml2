/*
 * Copyright 2008 University Corporation for Advanced Internet Development, Inc.
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

import java.util.List;

import org.opensaml.saml2.core.SubjectConfirmationData;
import org.opensaml.saml2.core.KeyInfoConfirmationDataType;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.signature.KeyInfo;

/**
 * Concrete implementation of {@link org.opensaml.saml2.core.SubjectConfirmationData}.
 */
public class KeyInfoConfirmationDataTypeImpl extends SubjectConfirmationDataImpl 
        implements KeyInfoConfirmationDataType {

    /**
     * Constructor.
     * 
     * @param namespaceURI the namespace the element is in
     * @param elementLocalName the local name of the XML element this Object represents
     * @param namespacePrefix the prefix for the given namespace
     */
    protected KeyInfoConfirmationDataTypeImpl(String namespaceURI, String elementLocalName, String namespacePrefix) {
        super(namespaceURI, elementLocalName, namespacePrefix);
    }

    /** {@inheritDoc} */
    public List<XMLObject> getKeyInfos() {
        return getUnknownXMLObjects(KeyInfo.DEFAULT_ELEMENT_NAME);
    }

}