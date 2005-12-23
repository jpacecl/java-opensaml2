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

package org.opensaml.saml1.core;

import javax.xml.namespace.QName;

import org.opensaml.common.IllegalAddException;
import org.opensaml.common.SAMLObject;
import org.opensaml.common.util.xml.XMLConstants;
/**
 * This interface defines how the object representing a SAML 1 <code> StatusCode</code> element behaves. 
 */
public interface StatusCode extends SAMLObject {

    /** Element name, no namespace. */

    public final static String LOCAL_NAME = "StatusCode";
    
    /** QName for this element. */

    public final static QName QNAME = new QName(XMLConstants.SAMLP1_NS, LOCAL_NAME, XMLConstants.SAMLP1_PREFIX);

    /** Name for the attribute which defines the Value. */ 

    public final static String VALUE_ATTRIB_NAME = "Value";
   
    //
    // TODO the value is a QNAME.  Do we need to store it as such (and if so what is the magicke to
    // do this
    //
    
    /** Return the Value (attribute). */

    String getValue();
     
    /** Set the Value (attribute). */

    void setValue(String value);
     
    /** Return the object representing the <code>StatusCode <code> (child element). */

    StatusCode getStatusCode();
    
    /** Set the object representing the <code>StatusCode <code> (child element). */

    void setStatusCode(StatusCode statusCode) throws IllegalAddException;
}