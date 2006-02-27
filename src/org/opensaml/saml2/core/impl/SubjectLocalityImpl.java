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

/**
 * 
 */

package org.opensaml.saml2.core.impl;

import java.util.List;

import org.opensaml.common.SAMLObject;
import org.opensaml.common.impl.AbstractSAMLObject;
import org.opensaml.common.xml.SAMLConstants;
import org.opensaml.saml2.core.SubjectLocality;

/**
 * A concrete implementation of {@link org.opensaml.saml2.core.SubjectLocality}.
 */
public class SubjectLocalityImpl extends AbstractSAMLObject implements SubjectLocality {

    /** The Address of the assertion */
    private String address;

    /** The DNS Name of the assertion */
    private String dnsName;

    /** Constructor */
    public SubjectLocalityImpl() {
        super(SAMLConstants.SAML20_NS, SubjectLocality.LOCAL_NAME);
        setElementNamespacePrefix(SAMLConstants.SAML20_PREFIX);
    }

    /**
     * @see org.opensaml.saml2.core.SubjectLocality#getAddress()
     */
    public String getAddress() {
        return address;
    }

    /**
     * @see org.opensaml.saml2.core.SubjectLocality#setAddress(java.lang.String)
     */
    public void setAddress(String newAddress) {
        this.address = prepareForAssignment(this.address, newAddress);
    }

    /**
     * @see org.opensaml.saml2.core.SubjectLocality#getDNSName()
     */
    public String getDNSName() {
        return dnsName;
    }

    /**
     * @see org.opensaml.saml2.core.SubjectLocality#setDNSName(java.lang.String)
     */
    public void setDNSName(String newDNSName) {
        this.dnsName = prepareForAssignment(this.dnsName, newDNSName);
    }

    /**
     * @see org.opensaml.common.SAMLObject#getOrderedChildren()
     */
    public List<SAMLObject> getOrderedChildren() {
        return null;
    }
}