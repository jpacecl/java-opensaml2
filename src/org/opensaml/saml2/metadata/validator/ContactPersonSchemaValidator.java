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

package org.opensaml.saml2.metadata.validator;

import org.opensaml.saml2.metadata.ContactPerson;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.validation.ValidationException;
import org.opensaml.xml.validation.Validator;

/**
 * Checks {@link org.opensaml.saml2.metadata.ContactPerson} for Schema compliance.
 */
public class ContactPersonSchemaValidator implements Validator {

    /** Constructor */
    public ContactPersonSchemaValidator() {

    }

    /*
     * @see org.opensaml.xml.validation.Validator#validate(org.opensaml.xml.XMLObject)
     */
    public void validate(XMLObject xmlObject) throws ValidationException {
        ContactPerson contactPerson = (ContactPerson) xmlObject;
        validateType(contactPerson);
    }

    /**
     * Checks that Type is present.
     * 
     * @param contactPerson
     * @throws ValidationException
     */
    protected void validateType(ContactPerson contactPerson) throws ValidationException {
        if (contactPerson.getType() == null) {
            throw new ValidationException("Type required");
        }
    }
}