package com.dmslob.spring.core.advanced.reflection;

import com.dmslob.spring.core.advanced.annotations.RunThisMethod;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Test cases to illustrate the usage of {@link ObjectFactory} class.
 */
public class ObjectFactoryTest {

    /**
     * Illustrates that there is no magic, {@link RunThisMethod} does not do the job by itself.
     */
    @Test
    public void testThereIsNoMagicWithoutObjectFactory() {
        MyObject myObject = new MyObject();
        assertEquals("Number of invocations does not match the expected value.", 0, myObject.getCallCount());
    }

    /**
     * Illustrates that the annotation was processed as expected: MyObject.executeMe() was annotated with @RunThisMethod(repeat = 2)
     * which resulted in 3 invocations.
     */
    @Test
    public void testObjectFactoryOnAnnotatedClass() throws Exception {
        MyObject myObject = ObjectFactory.newInstance(MyObject.class);
        assertNotNull(myObject);
        assertEquals("Number of invocations does not match the expected value.", 2, myObject.getCallCount());
    }

    /**
     * Illustrates that the extended classes also inherit the annotations of parent methods. MyExtendedObject contains 2 annotated methods:
     * {@link MyExtendedObject#executeExtended()} - should be executed once
     * {@link MyExtendedObject#executeMe()} - should be executed twice
     */
    @Test
    public void testAnnotationsOnExtendedClass() throws Exception {
        MyExtendedObject myExtendedObject = ObjectFactory.newInstance(MyExtendedObject.class);
        assertNotNull(myExtendedObject);
        assertEquals("Number of invocations does not match the expected value.", 3, myExtendedObject.getCallCount());
    }

    /**
     * Illustrates that the annotation is not inherited when the annotated method is overridden.
     */
    @Test
    public void testAnnotationsWithOverride() throws Exception {
        MyOverriddenObject myOverriddenObject = ObjectFactory.newInstance(MyOverriddenObject.class);
        assertNotNull(myOverriddenObject);
        assertEquals("Number of invocations does not match the expected value.", 0, myOverriddenObject.getCallCount());
    }
}
