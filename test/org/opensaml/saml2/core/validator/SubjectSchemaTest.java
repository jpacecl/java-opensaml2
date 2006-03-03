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
import org.opensaml.saml2.core.Subject;
import org.opensaml.saml2.core.SubjectConfirmation;
import org.opensaml.xml.validation.ValidationException;

/**
 * Test case for {@link org.opensaml.saml2.core.validator.SubjectSchemaValidator}.
 */
public class SubjectSchemaTest extends SAMLObjectValidatorBaseTestCase {

    /** Constructor */
    public SubjectSchemaTest() {
        targetQName = new QName(SAMLConstants.SAML20_NS, Subject.LOCAL_NAME, SAMLConstants.SAML20_PREFIX);
        validator = new SubjectSchemaValidator();
    }

    protected void populateRequiredData() {
        super.populateRequiredData();
        Subject subject = (Subject) target;
        SubjectConfirmation subjectConfirmation = (SubjectConfirmation) buildXMLObject(new QName(
                SAMLConstants.SAML20_NS, SubjectConfirmation.LOCAL_NAME, SAMLConstants.SAML20_PREFIX));
        subject.getSubjectConfirmations().add(subjectConfirmation);
    }

    /**
     * Tests absent Confirmation and ID failure.
     * 
     * @throws ValidationException
     */
    public void testConfirmationAndIDFailure() throws ValidationException {
        Subject subject = (Subject) target;

        subject.setNameID(null);
        subject.setBaseID(null);
        subject.getSubjectConfirmations().clear();
        assertValidationFail("No ID or Confirmation present, should raise a Validation Exception");
    }
}