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

package org.opensaml.saml1.core.impl;

import javax.xml.namespace.QName;

import org.opensaml.common.SAMLObjectBaseTestCase;
import org.opensaml.common.xml.SAMLConstants;
import org.opensaml.saml1.core.AssertionIDReference;

/**
 * Test case for {@link org.opensaml.saml1.core.impl.AssertionIDReferenceImpl}
 */
public class AssertionIDReferenceTest extends SAMLObjectBaseTestCase {

    private final String expectedNCName;

    /** name used to generate objects */
    private final QName qname;


    /**
     * Constructor
     */
    public AssertionIDReferenceTest() {
        super();
        singleElementFile = "/data/org/opensaml/saml1/singleAssertionIDReference.xml";
        singleElementOptionalAttributesFile = "/data/org/opensaml/saml1/singleAssertionIDReferenceContents.xml";
        expectedNCName = "NibbleAHappyWarthog";
        qname = new QName(SAMLConstants.SAML1_NS, AssertionIDReference.LOCAL_NAME, SAMLConstants.SAML1_PREFIX);
    }

    /*
     * @see org.opensaml.common.SAMLObjectBaseTestCase#testSingleElementUnmarshall()
     */
    @Override
    public void testSingleElementUnmarshall() {
        AssertionIDReference assertionIDReference;

        assertionIDReference = (AssertionIDReference) unmarshallElement(singleElementFile);

        assertNull("NCName was " + assertionIDReference.getNCName() + " expected null", assertionIDReference
                .getNCName());
    }

    /*
     * @see org.opensaml.common.SAMLObjectBaseTestCase#testSingleElementOptionalAttributesUnmarshall() No attributes -
     *      test contents
     */
    @Override
    public void testSingleElementOptionalAttributesUnmarshall() {
        AssertionIDReference assertionIDReference;

        assertionIDReference = (AssertionIDReference) unmarshallElement(singleElementOptionalAttributesFile);

        assertEquals("NCName ", expectedNCName, assertionIDReference.getNCName());
    }

    /*
     * @see org.opensaml.common.SAMLObjectBaseTestCase#testSingleElementMarshall()
     */
    @Override
    public void testSingleElementMarshall() {
        assertEquals(expectedDOM, buildXMLObject(qname));
    }

    /*
     * @see org.opensaml.common.SAMLObjectBaseTestCase#testSingleElementOptionalAttributesMarshall() No attributes -
     *      test contents
     */
    @Override
    public void testSingleElementOptionalAttributesMarshall() {
        AssertionIDReference assertionIDReference = (AssertionIDReference) buildXMLObject(qname);

        assertionIDReference.setNCName(expectedNCName);
        assertEquals(expectedOptionalAttributesDOM, assertionIDReference);
    }
}
