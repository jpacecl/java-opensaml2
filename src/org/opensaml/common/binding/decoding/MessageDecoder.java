/*
 * Copyright [2006] [University Corporation for Advanced Internet Development, Inc.]
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

package org.opensaml.common.binding.decoding;

import javax.servlet.ServletRequest;

import org.opensaml.common.SAMLObject;
import org.opensaml.common.binding.BindingException;
import org.opensaml.common.binding.security.SAMLSecurityPolicy;
import org.opensaml.saml2.metadata.provider.MetadataProvider;
import org.opensaml.xml.security.trust.TrustEngine;

/**
 * Decodes a SAML message in a binding specific mannger. The decode() method should be run before any accessor methods
 * are called.
 * 
 * @param <RequestType> type of incoming protocol request
 */
public interface MessageDecoder<RequestType extends ServletRequest>{
    
    /**
     * Gets the binding URI supported by this encoder.
     * 
     * @return binding URI supported by this encoder
     */
    public String getBindingURI();
    
    /**
     * Gets the request to decode.
     * 
     * @return request to decode
     */
    public RequestType getRequest();
    
    /**
     * Sets the request to decode.
     * 
     * @param request request to decode
     */
    public void setRequest(RequestType request);
    
    /**
     * Gets the metadata provider used to lookup information about the issuer.
     * 
     * @return metadata provider used to lookup information about the issuer
     */
    public MetadataProvider getMetadataProvider();

    /**
     * Sets the metadata provider used to lookup information about the issuer.
     * 
     * @param metadataProvider metadata provider used to lookup information about the issuer
     */
    public void setMetadataProvider(MetadataProvider metadataProvider);

    /**
     * Gets the trust engine used to verify the credentials of a request.
     * 
     * @return the trust engine used to verify the credentials of a request
     */
    public TrustEngine getTrustEngine();
    
    /**
     * Gets the security policy to apply to the request and its payload.
     * 
     * @return security policy to apply to the request and its payload
     */
    public SAMLSecurityPolicy getSecurityPolicy();
    
    /**
     * Sets the security policy to apply to the request and its payload.
     * 
     * @param policy security policy to apply to the request and its payload
     */
    public void setSecurityPolicy(SAMLSecurityPolicy policy);
    
    /**
     * Sets the the trust engine used to verify the credentials of a request.
     * 
     * @param trustEngine the trust engine used to verify the credentials of a request
     */
    public void setTrustEngine(TrustEngine trustEngine);

    /**
     * Decodes a SAML message in a binding specific manner.
     * 
     * @throws BindingException thrown if the message can not be decoded
     */
    public void decode() throws BindingException;

    /**
     * Gets the SAML message that was received and decoded.
     * 
     * @return SAML message
     */
    public SAMLObject getSAMLMessage();
    
}