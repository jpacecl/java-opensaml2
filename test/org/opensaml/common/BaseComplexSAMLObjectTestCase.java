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

package org.opensaml.common;

import org.opensaml.common.xml.ParserPoolManager;
import org.opensaml.xml.Configuration;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.io.Unmarshaller;
import org.opensaml.xml.io.UnmarshallingException;
import org.opensaml.xml.parse.XMLParserException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

/**
 * Base test case for OpenSAML tests that work with {@link org.opensaml.common.SAMLObject}s which represent full,
 * complex, typical "real world" examples of SAML documents.
 */
public abstract class BaseComplexSAMLObjectTestCase extends BaseTestCase {

    /** Location of file containing a single element with NO optional attributes. */
    protected String elementFile;

    /** The expected result of a marshalled single element with no optional attributes. */
    protected Document expectedDOM;

    /** {@inheritDoc} */
    protected void setUp() throws Exception {
        super.setUp();

        ParserPoolManager ppMgr = ParserPoolManager.getInstance();
        if (elementFile != null) {
            expectedDOM = ppMgr.parse(new InputSource(BaseComplexSAMLObjectTestCase.class
                    .getResourceAsStream(elementFile)));
        }
    }

    /** {@inheritDoc} */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Unmarshalls an element file into its SAMLObject.
     * 
     * @param elementFile classpath path to XML file to be unmarshalled
     * 
     * @return the SAMLObject from the file
     */
    protected XMLObject unmarshallElement(String elementFile) {
        try {
            ParserPoolManager ppMgr = ParserPoolManager.getInstance();
            Document doc = ppMgr.parse(new InputSource(BaseComplexSAMLObjectTestCase.class
                    .getResourceAsStream(elementFile)));
            Element samlElement = doc.getDocumentElement();

            Unmarshaller unmarshaller = Configuration.getUnmarshallerFactory().getUnmarshaller(samlElement);
            if (unmarshaller == null) {
                fail("Unable to retrieve unmarshaller by DOM Element");
            }

            return unmarshaller.unmarshall(samlElement);
        } catch (XMLParserException e) {
            fail("Unable to parse element file " + elementFile);
        } catch (UnmarshallingException e) {
            fail("Unmarshalling failed when parsing element file " + elementFile + ": " + e);
        }

        return null;
    }

    /**
     * Tests unmarshalling a document.
     */
    public abstract void testUnmarshall();

    /**
     * Tests marshalling the contents of a complex element to a DOM document.
     */
    public abstract void testMarshall();

}