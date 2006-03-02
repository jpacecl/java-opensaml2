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

package org.opensaml.saml2.core.validator;

import javax.xml.namespace.QName;

import org.opensaml.common.SAMLObjectValidatorBaseTestCase;
import org.opensaml.common.xml.SAMLConstants;
import org.opensaml.saml2.core.Attribute;
import org.opensaml.xml.validation.ValidationException;

public class AttributeSchemaTest extends SAMLObjectValidatorBaseTestCase {

    private QName qname;
    private AttributeSchemaValidator attributeValidator;
    
    /**Constructor*/
    public AttributeSchemaTest() {
        qname = new QName(SAMLConstants.SAML20_NS, Attribute.LOCAL_NAME, SAMLConstants.SAML20_PREFIX);
        attributeValidator = new AttributeSchemaValidator();
    }
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Tests the correct case.
     * 
     * @throws ValidationException
     */
    public void testProper() throws ValidationException {
        Attribute attribute = (Attribute) buildXMLObject(qname);

        attribute.setName("name");

        attributeValidator.validate(attribute);
    }

    /**
     * Tests absent Name failure.
     * 
     * @throws ValidationException
     */
    public void testNameFailure() throws ValidationException {
        Attribute attribute = (Attribute) buildXMLObject(qname);

        try {
            attributeValidator.validate(attribute);
            fail("Name missing, should raise a Validation Exception");
        } catch (ValidationException success) {
        }
    }
}