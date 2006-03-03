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
package org.opensaml.saml2.core.validator;

import org.opensaml.common.SAMLVersion;
import org.opensaml.saml2.core.StatusResponse;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.util.DatatypeHelper;
import org.opensaml.xml.validation.ValidationException;
import org.opensaml.xml.validation.Validator;

/**
 *
 */
public abstract class StatusResponseSchemaValidator implements Validator {

    /**
     * Constructor
     *
     */
    public StatusResponseSchemaValidator() {
    }

    /*
     * @see org.opensaml.xml.validation.Validator#validate(org.opensaml.xml.XMLObject)
     */
    public void validate(XMLObject xmlObject) throws ValidationException {
        StatusResponse response = (StatusResponse) xmlObject;
        validateStatus(response);
        validateID(response);
        validateVersion(response);
        validateIssueInstant(response);

    }

    /**
     * Validates the Status child element. 
     * 
     * @param response
     * @throws ValidationException
     */
    protected void validateStatus(StatusResponse response) throws ValidationException {
        if (response.getStatus() == null)
            throw new ValidationException("Status is required");
        
    }
    
    /**
     * Validates the ID attribute
     * 
     * @param response 
     * @throws ValidationException
     */
    protected void validateID(StatusResponse response) throws ValidationException {
        if (DatatypeHelper.isEmpty(response.getID()))
            throw new ValidationException("ID attribute must not be empty");
    }

    /**
     * Validates the Version attribute
     * 
     * @param response
     * @throws ValidationException
     */
    protected void validateVersion(StatusResponse response) throws ValidationException {
        if (response.getVersion() == null)
            throw new ValidationException("Version attribute must not be null");
        if (response.getVersion().toString() != SAMLVersion.VERSION_20.toString())
            throw new ValidationException("Wrong SAML Version");
    }
    
    /**
     * Validates the IsssueInstant attribute
     * 
     * @param response
     * @throws ValidationException
     */
    protected void validateIssueInstant(StatusResponse response) throws ValidationException {
        if (response.getIssueInstant() == null)
            throw new ValidationException ("IssueInstant attribute must not be null");
    }

}