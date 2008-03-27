/*
 * Copyright [2007] [University Corporation for Advanced Internet Development, Inc.]
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

package org.opensaml.common.impl;

import java.util.Random;

import org.bouncycastle.util.encoders.Hex;
import org.opensaml.common.IdentifierGenerator;

/**
 * Generates identifiers using random data obtained from a {@link java.util.Random} instance.
 */
public class RandomIdentifierGenerator implements IdentifierGenerator {

    /** Random number generator. */
    private static Random random;

    /**
     * Constructor.
     */
    public RandomIdentifierGenerator() {
        random = new Random();
    }

    /** {@inheritDoc} */
    public String generateIdentifier() {
        return generateIdentifier(16);
    }

    /** {@inheritDoc} */
    public String generateIdentifier(int size) {
        byte[] buf = new byte[size];
        random.nextBytes(buf);
        return "_".concat(new String(Hex.encode(buf)));
    }
}