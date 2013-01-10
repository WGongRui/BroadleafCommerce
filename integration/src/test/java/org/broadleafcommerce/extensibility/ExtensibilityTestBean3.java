/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.broadleafcommerce.extensibility;

/**
 * 
 * @author jfischer
 *
 */
public class ExtensibilityTestBean3 extends ExtensibilityTestBean {
    
    private String testProperty = "new";
    private String testProperty3 = "none3";
    
    /**
     * @return the testProperty
     */
    public String getTestProperty() {
        return testProperty;
    }
    
    /**
     * @param testProperty the testProperty to set
     */
    public void setTestProperty(String testProperty) {
        this.testProperty = testProperty;
    }
    
    /**
     * @return the testProperty3
     */
    public String getTestProperty3() {
        return testProperty3;
    }
    
    /**
     * @param testProperty3 the testProperty3 to set
     */
    public void setTestProperty3(String testProperty3) {
        this.testProperty3 = testProperty3;
    }

}
