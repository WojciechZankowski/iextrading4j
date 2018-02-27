package pl.zankowski.iextrading4j.test.design.api;

import pl.zankowski.iextrading4j.test.design.IDesignRule;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public abstract class AbstractApiDR implements IDesignRule {

    protected boolean isConcreteClass(Class<?> clazz) {
        return clazz != null && (!Modifier.isAbstract(clazz.getModifiers())
                || Modifier.isInterface(clazz.getModifiers()));
    }

    protected boolean inheritsSerializable(Class<?> clazz) {
        return Serializable.class.isAssignableFrom(clazz);
    }

    protected boolean hasAttributes(Class<?> clazz) {
        if (clazz.getDeclaredFields().length == 0) {
            return false;
        }
        boolean hasAttributes = false;
        for (final Field field : clazz.getDeclaredFields()) {
            hasAttributes |= !Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers());
        }
        return hasAttributes;
    }

    protected boolean hasOneConstructor(Class<?> clazz) {
        return clazz.getDeclaredConstructors().length == 1;
    }

    protected boolean isEnum(Class<?> clazz) {
        return clazz.isEnum();
    }

    protected boolean isAbstract(Class<?> clazz) {
        return Modifier.isAbstract(clazz.getModifiers());
    }

}
